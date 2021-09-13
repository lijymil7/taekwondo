package com.midashnt.taekwondo.app.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.midashnt.taekwondo.app.dto.Competition;
import com.midashnt.taekwondo.app.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/competition")
public class CompetitionController {

	protected CompetitionService competitionService;
	protected Gson gson = new Gson();

	@Autowired
	public CompetitionController(CompetitionService competitionService) {
		this.competitionService = competitionService;
	}

	@PostMapping(value = "/create-competition")
	public String createCompetition(@RequestParam Map<String, Object> data, HttpServletResponse response) {
		JsonObject object = new JsonObject();

		try {
			Competition competition = new Competition();
			competition.setCompetitionClassification((String)data.get(Competition.KEY_COMPETITION_CLASSIFICATION));
			competition.setCompetitionNameKO((String)data.get(Competition.KEY_COMPETITION_NAME_KO));
			competition.setCompetitionNameEN((String)data.get(Competition.KEY_COMPETITION_NAME_EN));
			competition.setCompetitionGrade(Integer.parseInt((String)data.get(Competition.KEY_COMPETITION_GRADE)));
			competition.setCompetitionHostInstitutionKO((String)data.get(Competition.KEY_COMPETITION_HOST_INSTITUTION_KO));
			competition.setCompetitionHostInstitutionEN((String)data.get(Competition.KEY_COMPETITION_HOST_INSTITUTION_EN));
			competition.setCompetitionStartDate((String)data.get(Competition.KEY_COMPETITION_START_DATE));
			competition.setCompetitionEndDate((String)data.get(Competition.KEY_COMPETITION_END_DATE));
			competition.setRegistrationStartDate((String)data.get(Competition.KEY_REGISTRATION_START_DATE));
			competition.setRegistrationEndDate((String)data.get(Competition.KEY_REGISTRATION_END_DATE));
			competition.setCorrectionStartDate((String)data.get(Competition.KEY_CORRECTION_START_DATE));
			competition.setCorrectionEndDate((String)data.get(Competition.KEY_CORRECTION_END_DATE));
			competition.setCompetitionHomepage((String)data.get(Competition.KEY_COMPETITION_HOMEPAGE));
			competition.setCompetitionLogoPath((String)data.get(Competition.KEY_COMPETITION_LOGO_PATH));
			competition.setCompetitionImagePath((String)data.get(Competition.KEY_COMPETITION_IMAGE_PATH));

			competitionService.createCompetition(competition);
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			e.printStackTrace();
		}

		return object.toString();
	}

	@PutMapping(value = "/update-competition")
	public String updateCompetition(@RequestParam Map<String, Object> data, HttpServletResponse response) {
		JsonObject object = new JsonObject();

		try {
			Competition competition = new Competition();
			competition.setCompetitionIndex(Integer.parseInt((String)data.get(Competition.KEY_COMPETITION_INDEX)));
			competition.setCompetitionClassification((String)data.get(Competition.KEY_COMPETITION_CLASSIFICATION));
			competition.setCompetitionNameKO((String)data.get(Competition.KEY_COMPETITION_NAME_KO));
			competition.setCompetitionNameEN((String)data.get(Competition.KEY_COMPETITION_NAME_EN));
			competition.setCompetitionGrade(Integer.parseInt((String)data.get(Competition.KEY_COMPETITION_GRADE)));
			competition.setCompetitionHostInstitutionKO((String)data.get(Competition.KEY_COMPETITION_HOST_INSTITUTION_KO));
			competition.setCompetitionHostInstitutionEN((String)data.get(Competition.KEY_COMPETITION_HOST_INSTITUTION_EN));
			competition.setCompetitionStartDate((String)data.get(Competition.KEY_COMPETITION_START_DATE));
			competition.setCompetitionEndDate((String)data.get(Competition.KEY_COMPETITION_END_DATE));
			competition.setRegistrationStartDate((String)data.get(Competition.KEY_REGISTRATION_START_DATE));
			competition.setRegistrationEndDate((String)data.get(Competition.KEY_REGISTRATION_END_DATE));
			competition.setCorrectionStartDate((String)data.get(Competition.KEY_CORRECTION_START_DATE));
			competition.setCorrectionEndDate((String)data.get(Competition.KEY_CORRECTION_END_DATE));
			competition.setCompetitionHomepage((String)data.get(Competition.KEY_COMPETITION_HOMEPAGE));
			competition.setCompetitionLogoPath((String)data.get(Competition.KEY_COMPETITION_LOGO_PATH));
			competition.setCompetitionImagePath((String)data.get(Competition.KEY_COMPETITION_IMAGE_PATH));

			competitionService.updateCompetition(competition);
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			e.printStackTrace();
		}

		return object.toString();
	}

	@DeleteMapping(value = "/delete-competition/{competitionIndex}")
	public String deleteCompetition(@PathVariable(Competition.KEY_COMPETITION_INDEX) int competitionIndex, HttpServletResponse response) {
		JsonObject object = new JsonObject();

		try {
			competitionService.deleteCompetition(competitionIndex);
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			e.printStackTrace();
		}

		return object.toString();
	}

}