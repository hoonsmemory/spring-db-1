package io.hoon.springdb1.jdbc.connection;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static io.hoon.springdb1.jdbc.connection.ConnectionConst.*;

@Slf4j
public class DBConnectionUtil {

    public static Connection getConnection() {
        Connection connection = null;
        try{
            /**
             * 단순히 getCoonection을 하지만 H2 Driver의 구현체에 의해 커넥션을 맺게 된다.
             * (DriverManager가 라이브러리에 등록된 드라이버 목록을 자동으로 인식한다.)
             */
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            log.info("get connection = {}, class = {} ",connection, connection.getClass() );
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return connection;
    }
}
