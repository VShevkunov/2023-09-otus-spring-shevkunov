package ru.otus.hw.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.hw.dao.QuestionDao;

@ExtendWith(MockitoExtension.class)
class TestServiceImplTest {

    @Mock
    private IOService ioService;

    @Mock
    private QuestionDao questionDao;

    private TestService testService;

    @BeforeEach
    void setUp() {

       testService = new TestServiceImpl(ioService, questionDao);

    }

    @Test
    @DisplayName("Запуск фактически не падает")
    void testExecuteTest() {

        testService.executeTest();
        Assertions.assertTrue(true);

    }
}