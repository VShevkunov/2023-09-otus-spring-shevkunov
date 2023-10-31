package ru.otus.hw.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.hw.dao.CsvQuestionDao;

@ExtendWith(MockitoExtension.class)
class TestServiceImplTest {
    @Mock
    private IOService ioService;
    @Mock
    private CsvQuestionDao csvQuestionDao;
    private TestService testServiceImpl;

    @BeforeEach
    void setUp() {

        testServiceImpl = new TestServiceImpl(ioService, csvQuestionDao);
    }

    @Test
    @DisplayName("Бин создался")
    void getCsvTest() {

        Assertions.assertNotNull(testServiceImpl);
    }

    @Test
    @DisplayName("Запуск фактически не падает")
    void testExecuteTest() {

        Throwable exception = null;

        try{
            testServiceImpl.executeTest();
        }catch (Exception e){
            exception = e;
        }

        Assertions.assertNull(exception);
    }





}