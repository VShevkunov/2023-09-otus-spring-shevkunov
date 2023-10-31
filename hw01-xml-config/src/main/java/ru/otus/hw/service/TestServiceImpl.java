package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import ru.otus.hw.dao.CsvQuestionDao;
import ru.otus.hw.domain.Answer;
import ru.otus.hw.domain.Question;

@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final IOService ioService;

    private final CsvQuestionDao csvQuestionDao;

    @Override
    public void executeTest() {

        ioService.printLine("");
        ioService.printFormattedLine("Please answer the questions below%n");

        for (Question question : csvQuestionDao.findAll()) {

            ioService.printLine("");
            ioService.printFormattedLine(question.text());
            for (Answer answer : question.answers()) {
                ioService.printFormattedLine(answer.text() + " - " + answer.isCorrect());

            }
        }
    }
}
