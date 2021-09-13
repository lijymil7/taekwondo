package com.midashnt.taekwondo.app.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.midashnt.taekwondo.app.dto.WeightClass;
import com.midashnt.taekwondo.app.service.WeightClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping(value = "/v1/weightClass")
public class WeightClassController {

	protected WeightClassService weightClassService;
	protected Gson gson = new Gson();

	@Autowired
	public WeightClassController(WeightClassService weightClassService) {
		this.weightClassService = weightClassService;
	}

	@PostMapping(value = "/create-weightclass")
	public String createWeightClass(@RequestParam Map<String, Object> data, HttpServletResponse response) {
		JsonObject object = new JsonObject();

		try {
			WeightClass weightClass = new WeightClass();
			weightClass.setEventIndex(Integer.parseInt((String)data.get(WeightClass.KEY_EVENT_INDEX)));
			weightClass.setWeightClassNameKO((String)data.get(WeightClass.KEY_WEIGHT_CLASS_NAME_KO));
			weightClass.setWeightClassNameEN((String)data.get(WeightClass.KEY_WEIGHT_CLASS_NAME_EN));
			weightClass.setRoundCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_CNT)));
			weightClass.setRoundOneGameTime(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_ONE_GAME_TIME)));
			weightClass.setRoundOneBreakTime(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_ONE_BREAK_TIME)));
			weightClass.setRoundOneDoubleTargetMittCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_ONE_DOUBLE_TARGET_MITT_CNT)));
			weightClass.setRoundOneLargeMittCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_ONE_LARGE_MITT_CNT)));
			weightClass.setRoundTwoGameTime(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_TWO_GAME_TIME)));
			weightClass.setRoundTwoBreakTime(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_TWO_BREAK_TIME)));
			weightClass.setRoundTwoDoubleTargetMittCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_TWO_DOUBLE_TARGET_MITT_CNT)));
			weightClass.setRoundTwoLargeMittCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_TWO_LARGE_MITT_CNT)));
			weightClass.setRoundTreeGameTime(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_TREE_GAME_TIME)));
			weightClass.setRoundTreeBreakTime(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_TREE_BREAK_TIME)));
			weightClass.setRoundTreeDoubleTargetMittCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_TREE_DOUBLE_TARGET_MITT_CNT)));
			weightClass.setRoundTreeLargeMittCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_TREE_LARGE_MITT_CNT)));
			weightClass.setRoundFourGameTime(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_FOUR_GAME_TIME)));
			weightClass.setRoundFourBreakTime(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_FOUR_BREAK_TIME)));
			weightClass.setRoundFourDoubleTargetMittCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_FOUR_DOUBLE_TARGET_MITT_CNT)));
			weightClass.setRoundFourLargeMittCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_FOUR_LARGE_MITT_CNT)));
			weightClass.setRoundFiveGameTime(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_FIVE_GAME_TIME)));
			weightClass.setRoundFiveBreakTime(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_FIVE_BREAK_TIME)));
			weightClass.setRoundFiveDoubleTargetMittCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_FIVE_DOUBLE_TARGET_MITT_CNT)));
			weightClass.setRoundFiveLargeMittCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_FIVE_LARGE_MITT_CNT)));
			weightClass.setWeightClassOrder(Integer.parseInt((String)data.get(WeightClass.KEY_WEIGHT_CLASS_ORDER)));

			weightClassService.createWeightClass(weightClass);
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			e.printStackTrace();
		}

		return object.toString();
	}

	@PutMapping(value = "/update-weightclass")
	public String updateWeightClass(@RequestParam Map<String, Object> data, HttpServletResponse response) {
		JsonObject object = new JsonObject();

		try {
			WeightClass weightClass = new WeightClass();
			weightClass.setWeightClassIndex(Integer.parseInt((String)data.get(WeightClass.KEY_WEIGHT_CLASS_INDEX)));
			weightClass.setEventIndex(Integer.parseInt((String)data.get(WeightClass.KEY_EVENT_INDEX)));
			weightClass.setWeightClassNameKO((String)data.get(WeightClass.KEY_WEIGHT_CLASS_NAME_KO));
			weightClass.setWeightClassNameEN((String)data.get(WeightClass.KEY_WEIGHT_CLASS_NAME_EN));
			weightClass.setRoundCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_CNT)));
			weightClass.setRoundOneGameTime(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_ONE_GAME_TIME)));
			weightClass.setRoundOneBreakTime(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_ONE_BREAK_TIME)));
			weightClass.setRoundOneDoubleTargetMittCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_ONE_DOUBLE_TARGET_MITT_CNT)));
			weightClass.setRoundOneLargeMittCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_ONE_LARGE_MITT_CNT)));
			weightClass.setRoundTwoGameTime(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_TWO_GAME_TIME)));
			weightClass.setRoundTwoBreakTime(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_TWO_BREAK_TIME)));
			weightClass.setRoundTwoDoubleTargetMittCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_TWO_DOUBLE_TARGET_MITT_CNT)));
			weightClass.setRoundTwoLargeMittCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_TWO_LARGE_MITT_CNT)));
			weightClass.setRoundTreeGameTime(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_TREE_GAME_TIME)));
			weightClass.setRoundTreeBreakTime(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_TREE_BREAK_TIME)));
			weightClass.setRoundTreeDoubleTargetMittCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_TREE_DOUBLE_TARGET_MITT_CNT)));
			weightClass.setRoundTreeLargeMittCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_TREE_LARGE_MITT_CNT)));
			weightClass.setRoundFourGameTime(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_FOUR_GAME_TIME)));
			weightClass.setRoundFourBreakTime(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_FOUR_BREAK_TIME)));
			weightClass.setRoundFourDoubleTargetMittCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_FOUR_DOUBLE_TARGET_MITT_CNT)));
			weightClass.setRoundFourLargeMittCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_FOUR_LARGE_MITT_CNT)));
			weightClass.setRoundFiveGameTime(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_FIVE_GAME_TIME)));
			weightClass.setRoundFiveBreakTime(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_FIVE_BREAK_TIME)));
			weightClass.setRoundFiveDoubleTargetMittCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_FIVE_DOUBLE_TARGET_MITT_CNT)));
			weightClass.setRoundFiveLargeMittCnt(Integer.parseInt((String)data.get(WeightClass.KEY_ROUND_FIVE_LARGE_MITT_CNT)));
			weightClass.setWeightClassOrder(Integer.parseInt((String)data.get(WeightClass.KEY_WEIGHT_CLASS_ORDER)));

			weightClassService.updateWeightClass(weightClass);
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			e.printStackTrace();
		}

		return object.toString();
	}

	@GetMapping(value = "/get-weightclass-list-by-event-index/{eventIndex}")
	public String getWeightClassListByEventIndex(@PathVariable(WeightClass.KEY_EVENT_INDEX) int eventIndex, HttpServletResponse response) {
		JsonArray array = new JsonArray();

		try {
			List<WeightClass> weightClassList = weightClassService.getWeightClassListByEventIndex(eventIndex);
			JsonElement element = gson.toJsonTree(weightClassList);
			array = element.getAsJsonArray();
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			e.printStackTrace();
		}

		return array.toString();
	}

	@DeleteMapping(value = "/delete-weightclass/{weightClassIndex}")
	public String deleteWeightClass(@PathVariable(WeightClass.KEY_WEIGHT_CLASS_INDEX) int weightClassIndex, HttpServletResponse response) {
		JsonObject object = new JsonObject();

		try {
			weightClassService.deleteWeightClass(weightClassIndex);
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			e.printStackTrace();
		}

		return object.toString();
	}

}