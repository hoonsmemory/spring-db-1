package io.hoon.springdb1.jpa;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class JpaItemRepositoryTest {
    @Autowired
    ItemRepository repository;

    @Test
    void selectItem() {
        ItemSearchCond itemSearchCond = new ItemSearchCond();
        log.info("repository = {}", repository.getClass());
        List<Item> all = repository.findAll(itemSearchCond);
    }
}