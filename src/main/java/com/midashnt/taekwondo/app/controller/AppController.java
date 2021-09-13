package com.midashnt.taekwondo.app.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.midashnt.taekwondo.app.dto.Competition;
import com.midashnt.taekwondo.app.dto.Event;
import com.midashnt.taekwondo.app.service.CompetitionService;
import com.midashnt.taekwondo.app.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/app")
public class AppController {

    protected CompetitionService competitionService;
    protected EventService eventService;
    protected Gson gson = new Gson();

    @Autowired
    public AppController(CompetitionService competitionService, EventService eventService) {
        this.competitionService = competitionService;
        this.eventService = eventService;
    }

    @GetMapping(value = "/get-competition-list-by-competition-classification/{competitionClassification}")
    public String getCompetitionListByCompetitionClassification(@PathVariable(Competition.KEY_COMPETITION_CLASSIFICATION)String competitionClassification, HttpServletResponse response) {
        JsonArray array = new JsonArray();

        try {
            List<Competition> eventList = competitionService.getCompetitionListByCompetitionClassification(competitionClassification);
            JsonElement element = gson.toJsonTree(eventList);
            array = element.getAsJsonArray();
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            e.printStackTrace();
        }

        return array.toString();
    }

    @GetMapping(value = "/get-event-list-and-weight-class-list-by-competition-index/{competitionIndex}")
    public String getEventListAndWeightClassListByCompetitionIndex(@PathVariable(Event.KEY_COMPETITION_INDEX) int competitionIndex, HttpServletResponse response) {
        JsonArray array = new JsonArray();

        try {
            List<Map<String,Object>> eventMapList = eventService.getEventListAndWeightClassListByCompetitionIndex(competitionIndex);
            JsonElement element = gson.toJsonTree(eventMapList);
            array = element.getAsJsonArray();
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            e.printStackTrace();
        }

        return array.toString();
    }


}
