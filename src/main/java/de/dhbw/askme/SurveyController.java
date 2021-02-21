package de.dhbw.askme;

import de.dhbw.askme.domain.Survey;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.validation.Valid;

@Singleton
@Controller("/survey")
public class SurveyController {
    private final de.dhbw.askme.SurveyRepository repository;
    private static final Logger log = LoggerFactory.getLogger(SurveyController.class);

    public SurveyController(de.dhbw.askme.SurveyRepository surveyRepository) {
        this.repository = surveyRepository;
    }

    @Get("/{id}")
    public Survey show(Long id) {
        log.debug("Get survey with id {}", id);
        return repository
                .findById(id)
                .orElse(null);
    }

    @Put("/{id}")
    public HttpResponse update(@Body @Valid Survey survey) {
        log.debug("Update survey: {}", survey);
        repository.update(survey);

        return HttpResponse
                .noContent();
    }

    @Get()
    public Iterable<Survey> list() {
        log.debug("List surveys");

        return repository.findAll();
    }

    @Post("/")
    public HttpResponse<Survey> save(@Body @Valid Survey survey) {
        log.debug("Save survey: {}", survey);
        Survey newSurvey = repository.save(survey);

        return HttpResponse
                .created(newSurvey);
    }

    @Delete("/{id}")
    public HttpResponse delete(Long id) {
        log.debug("Save survey: {}", id);
        repository.deleteById(id);
        return HttpResponse.noContent();
    }

    @Delete("/")
    public HttpResponse deleteAll() {
        log.debug("Deleting all surveys");
        repository.deleteAll();
        return HttpResponse.noContent();
    }
}
