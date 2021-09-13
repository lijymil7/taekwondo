package com.midashnt.taekwondo.app.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.midashnt.taekwondo.app.dto.Event;
import com.midashnt.taekwondo.app.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/event")
public class EventController {

	protected EventService eventService;
	protected Gson gson = new Gson();

	@Autowired
	public EventController(EventService eventService) {
		this.eventService = eventService;
	}

	@PostMapping(value = "/create-event")
	public String createEvent(@RequestParam Map<String, Object> data, HttpServletResponse response) {
		JsonObject object = new JsonObject();

		try {
			Event event = new Event();
			event.setCompetitionIndex(Integer.parseInt((String)data.get(Event.KEY_COMPETITION_INDEX)));
			event.setEventNameKO((String)data.get(Event.KEY_EVENT_NAME_KO));
			event.setEventNameEN((String)data.get(Event.KEY_EVENT_NAME_EN));
			event.setEventClassification(Integer.parseInt((String)data.get(Event.KEY_EVENT_CLASSIFICATION)));
			event.setEventType(Integer.parseInt((String)data.get(Event.KEY_EVENT_TYPE)));
			event.setEventRating(Integer.parseInt((String)data.get(Event.KEY_EVENT_RATING)));
			event.setRoundCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_CNT)));
			event.setRoundOneGameTime(Integer.parseInt((String)data.get(Event.KEY_ROUND_ONE_GAME_TIME)));
			event.setRoundOneBreakTime(Integer.parseInt((String)data.get(Event.KEY_ROUND_ONE_BREAK_TIME)));
			event.setRoundOneDoubleTargetMittCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_ONE_DOUBLE_TARGET_MITT_CNT)));
			event.setRoundOneLargeMittCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_ONE_LARGE_MITT_CNT)));
			event.setRoundTwoGameTime(Integer.parseInt((String)data.get(Event.KEY_ROUND_TWO_GAME_TIME)));
			event.setRoundTwoBreakTime(Integer.parseInt((String)data.get(Event.KEY_ROUND_TWO_BREAK_TIME)));
			event.setRoundTwoDoubleTargetMittCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_TWO_DOUBLE_TARGET_MITT_CNT)));
			event.setRoundTwoLargeMittCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_TWO_LARGE_MITT_CNT)));
			event.setRoundTreeGameTime(Integer.parseInt((String)data.get(Event.KEY_ROUND_TREE_GAME_TIME)));
			event.setRoundTreeBreakTime(Integer.parseInt((String)data.get(Event.KEY_ROUND_TREE_BREAK_TIME)));
			event.setRoundTreeDoubleTargetMittCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_TREE_DOUBLE_TARGET_MITT_CNT)));
			event.setRoundTreeLargeMittCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_TREE_LARGE_MITT_CNT)));
			event.setRoundFourGameTime(Integer.parseInt((String)data.get(Event.KEY_ROUND_FOUR_GAME_TIME)));
			event.setRoundFourBreakTime(Integer.parseInt((String)data.get(Event.KEY_ROUND_FOUR_BREAK_TIME)));
			event.setRoundFourDoubleTargetMittCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_FOUR_DOUBLE_TARGET_MITT_CNT)));
			event.setRoundFourLargeMittCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_FOUR_LARGE_MITT_CNT)));
			event.setRoundFiveGameTime(Integer.parseInt((String)data.get(Event.KEY_ROUND_FIVE_GAME_TIME)));
			event.setRoundFiveBreakTime(Integer.parseInt((String)data.get(Event.KEY_ROUND_FIVE_BREAK_TIME)));
			event.setRoundFiveDoubleTargetMittCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_FIVE_DOUBLE_TARGET_MITT_CNT)));
			event.setRoundFiveLargeMittCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_FIVE_LARGE_MITT_CNT)));
			event.setEventOrder(Integer.parseInt((String)data.get(Event.KEY_EVENT_ORDER)));

			eventService.createEvent(event);
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			e.printStackTrace();
		}

		return object.toString();
	}

	@PutMapping(value = "/update-event")
	public String updateEvent(@RequestParam Map<String, Object> data, HttpServletResponse response) {
		JsonObject object = new JsonObject();

		try {
			Event event = new Event();
			event.setEventIndex(Integer.parseInt((String)data.get(Event.KEY_EVENT_INDEX)));
			event.setCompetitionIndex(Integer.parseInt((String)data.get(Event.KEY_COMPETITION_INDEX)));
			event.setEventNameKO((String)data.get(Event.KEY_EVENT_NAME_KO));
			event.setEventNameEN((String)data.get(Event.KEY_EVENT_NAME_EN));
			event.setEventClassification(Integer.parseInt((String)data.get(Event.KEY_EVENT_CLASSIFICATION)));
			event.setEventType(Integer.parseInt((String)data.get(Event.KEY_EVENT_TYPE)));
			event.setEventRating(Integer.parseInt((String)data.get(Event.KEY_EVENT_RATING)));
			event.setRoundCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_CNT)));
			event.setRoundOneGameTime(Integer.parseInt((String)data.get(Event.KEY_ROUND_ONE_GAME_TIME)));
			event.setRoundOneBreakTime(Integer.parseInt((String)data.get(Event.KEY_ROUND_ONE_BREAK_TIME)));
			event.setRoundOneDoubleTargetMittCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_ONE_DOUBLE_TARGET_MITT_CNT)));
			event.setRoundOneLargeMittCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_ONE_LARGE_MITT_CNT)));
			event.setRoundTwoGameTime(Integer.parseInt((String)data.get(Event.KEY_ROUND_TWO_GAME_TIME)));
			event.setRoundTwoBreakTime(Integer.parseInt((String)data.get(Event.KEY_ROUND_TWO_BREAK_TIME)));
			event.setRoundTwoDoubleTargetMittCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_TWO_DOUBLE_TARGET_MITT_CNT)));
			event.setRoundTwoLargeMittCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_TWO_LARGE_MITT_CNT)));
			event.setRoundTreeGameTime(Integer.parseInt((String)data.get(Event.KEY_ROUND_TREE_GAME_TIME)));
			event.setRoundTreeBreakTime(Integer.parseInt((String)data.get(Event.KEY_ROUND_TREE_BREAK_TIME)));
			event.setRoundTreeDoubleTargetMittCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_TREE_DOUBLE_TARGET_MITT_CNT)));
			event.setRoundTreeLargeMittCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_TREE_LARGE_MITT_CNT)));
			event.setRoundFourGameTime(Integer.parseInt((String)data.get(Event.KEY_ROUND_FOUR_GAME_TIME)));
			event.setRoundFourBreakTime(Integer.parseInt((String)data.get(Event.KEY_ROUND_FOUR_BREAK_TIME)));
			event.setRoundFourDoubleTargetMittCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_FOUR_DOUBLE_TARGET_MITT_CNT)));
			event.setRoundFourLargeMittCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_FOUR_LARGE_MITT_CNT)));
			event.setRoundFiveGameTime(Integer.parseInt((String)data.get(Event.KEY_ROUND_FIVE_GAME_TIME)));
			event.setRoundFiveBreakTime(Integer.parseInt((String)data.get(Event.KEY_ROUND_FIVE_BREAK_TIME)));
			event.setRoundFiveDoubleTargetMittCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_FIVE_DOUBLE_TARGET_MITT_CNT)));
			event.setRoundFiveLargeMittCnt(Integer.parseInt((String)data.get(Event.KEY_ROUND_FIVE_LARGE_MITT_CNT)));
			event.setEventOrder(Integer.parseInt((String)data.get(Event.KEY_EVENT_ORDER)));

			eventService.updateEvent(event);
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			e.printStackTrace();
		}

		return object.toString();
	}

	@GetMapping(value = "/get-event-list-by-competition-index/{competitionIndex}")
	public String getEventListByCompetitionIndex(@PathVariable(Event.KEY_COMPETITION_INDEX) int competitionIndex, HttpServletResponse response) {
		JsonArray array = new JsonArray();

		try {
			List<Event> eventList = eventService.getEventListByCompetitionIndex(competitionIndex);
			JsonElement element = gson.toJsonTree(eventList);
			array = element.getAsJsonArray();
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			e.printStackTrace();
		}

		return array.toString();
	}

	@DeleteMapping(value = "/delete-event/{eventIndex}")
	public String deleteEvent(@PathVariable(Event.KEY_EVENT_INDEX) int eventIndex, HttpServletResponse response) {
		JsonObject object = new JsonObject();

		try {
			eventService.deleteEvent(eventIndex);
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			e.printStackTrace();
		}

		return object.toString();
	}

}