package io.hoon.springdb1.jdbc.exception.translator;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static io.hoon.springdb1.jdbc.connection.ConnectionConst.*;
import static org.assertj.core.api.Assertions.*;

@Slf4j
public class SpringExceptionTranslatorTest {

    DataSource dataSource;

    @BeforeEach
    void init() {
        dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
    }

    @Test
    void sqlExceptionErrorCode() {
        String sql = "select bad grammar";

        try {
            Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
        } catch (SQLException e) {
            assertThat(e.getErrorCode()).isEqualTo(42122);
            int errorCode = e.getErrorCode();
            log.info("errorCode={}",errorCode);
            log.info("errorCode={}",e);
        }

    }
    
    //스프링이 제공하는 SQL 예외 변환기
    @Test
    void springSQLExceptionTranslator() {
        String sql = "select bad grammar";

        try {
            Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
        } catch (SQLException e) {
            assertThat(e.getErrorCode()).isEqualTo(42122);

            //org.springframework.jdbc.support.sql-error-codes.xml
            SQLErrorCodeSQLExceptionTranslator exceptionTranslator = new SQLErrorCodeSQLExceptionTranslator(dataSource);
            DataAccessException dataAccessException = exceptionTranslator.translate("test", sql, e);

            log.info("dataAccessException", dataAccessException);
            assertThat(dataAccessException.getClass()).isEqualTo(BadSqlGrammarException.class);

        }

    }

}
