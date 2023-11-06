package ru.otus.hw.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import ru.otus.hw.config.TestFileNameProvider;
import ru.otus.hw.dao.dto.QuestionDto;
import ru.otus.hw.domain.Question;
import ru.otus.hw.exceptions.QuestionReadException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CsvQuestionDao implements QuestionDao {
    private final TestFileNameProvider fileNameProvider;

    @Override
    public List<Question> findAll() {

        final var fileName = fileNameProvider.getTestFileName();
        var questions = new ArrayList<Question>();

        try (var inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {

            if (inputStream != null) {
                var questionsDtoBeans =
                        new CsvToBeanBuilder<QuestionDto>(new InputStreamReader(inputStream)).
                                withType(QuestionDto.class).
                                withSeparator(';').
                                withSkipLines(1).
                                build().parse();

                for (QuestionDto question: questionsDtoBeans) {
                    questions.add(question.toDomainObject());
                }
            }
        } catch (IOException e) {
            throw new QuestionReadException("file not found! " + fileName, e);
        }

        return questions;
    }
}
