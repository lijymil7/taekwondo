package com.midashnt.taekwondo.app.dto;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Event {

	public static final String COLUMN_NAME_EVENT_INDEX = "EVENT_INDEX";
	public static final String KEY_EVENT_INDEX = "eventIndex";
	private int eventIndex;

	public static final String COLUMN_NAME_COMPETITION_INDEX = "COMPETITION_INDEX";
	public static final String KEY_COMPETITION_INDEX = "competitionIndex";
	private int competitionIndex;

	public static final String COLUMN_NAME_EVENT_NAME_KO = "EVENT_NAME_KO";
	public static final String KEY_EVENT_NAME_KO = "eventNameKO";
	private String eventNameKO;

	public static final String COLUMN_NAME_EVENT_NAME_EN = "EVENT_NAME_EN";
	public static final String KEY_EVENT_NAME_EN = "eventNameEN";
	private String eventNameEN;

	public static final String COLUMN_NAME_EVENT_CLASSIFICATION = "EVENT_CLASSIFICATION";
	public static final String KEY_EVENT_CLASSIFICATION = "eventClassification";

	public static final int EVENT_CLASSIFICATION_POOMSAE = 1;
	public static final int EVENT_CLASSIFICATION_KYORUGI = 2;
	public static final int EVENT_CLASSIFICATION_ELECTRON_KYORUGI = 3;

	private int eventClassification;

	public static final String COLUMN_NAME_EVENT_TYPE = "EVENT_TYPE";
	public static final String KEY_EVENT_TYPE = "eventType";

	public static final int EVENT_TYPE_INDIVIDUAL_MAN = 1;
	public static final int EVENT_TYPE_INDIVIDUAL_WOMEN = 2;
	public static final int EVENT_TYPE_TEAM_MAN = 3;
	public static final int EVENT_TYPE_TEAM_WOMEN = 4;
	public static final int EVENT_TYPE_DOUBLES = 5;
	public static final int EVENT_TYPE_MIXED = 6;

	private int eventType;

	public static final String COLUMN_NAME_EVENT_RATING = "EVENT_RATING";
	public static final String KEY_EVENT_RATING = "eventRating";

	public static final int EVENT_RATING_COLOR_BELT = 1;
	public static final int EVENT_RATING_BLACK_BELT = 2;
	public static final int EVENT_RATING_ALL = 3;

	private int eventRating;

	public static final String COLUMN_NAME_ROUND_CNT = "ROUND_CNT";
	public static final String KEY_ROUND_CNT = "roundCnt";
	private int roundCnt;

	public static final String COLUMN_NAME_ROUND_ONE_GAME_TIME = "ROUND_ONE_GAME_TIME";
	public static final String KEY_ROUND_ONE_GAME_TIME = "roundOneGameTime";
	private int roundOneGameTime;

	public static final String COLUMN_NAME_ROUND_ONE_BREAK_TIME = "ROUND_ONE_BREAK_TIME";
	public static final String KEY_ROUND_ONE_BREAK_TIME = "roundOneBreakTime";
	private int roundOneBreakTime;

	public static final String COLUMN_NAME_ROUND_ONE_DOUBLE_TARGET_MITT_CNT = "ROUND_ONE_DOUBLE_TARGET_MITT_CNT";
	public static final String KEY_ROUND_ONE_DOUBLE_TARGET_MITT_CNT = "roundOneDoubleTargetMittCnt";
	private int roundOneDoubleTargetMittCnt;

	public static final String COLUMN_NAME_ROUND_ONE_LARGE_MITT_CNT = "ROUND_ONE_LARGE_MITT_CNT";
	public static final String KEY_ROUND_ONE_LARGE_MITT_CNT = "roundOneLargeMittCnt";
	private int roundOneLargeMittCnt;

	public static final String COLUMN_NAME_ROUND_TWO_GAME_TIME = "ROUND_TWO_GAME_TIME";
	public static final String KEY_ROUND_TWO_GAME_TIME = "roundTwoGameTime";
	private int roundTwoGameTime;

	public static final String COLUMN_NAME_ROUND_TWO_BREAK_TIME = "ROUND_TWO_BREAK_TIME";
	public static final String KEY_ROUND_TWO_BREAK_TIME = "roundTwoBreakTime";
	private int roundTwoBreakTime;

	public static final String COLUMN_NAME_ROUND_TWO_DOUBLE_TARGET_MITT_CNT = "ROUND_TWO_DOUBLE_TARGET_MITT_CNT";
	public static final String KEY_ROUND_TWO_DOUBLE_TARGET_MITT_CNT = "roundTwoDoubleTargetMittCnt";
	private int roundTwoDoubleTargetMittCnt;

	public static final String COLUMN_NAME_ROUND_TWO_LARGE_MITT_CNT = "ROUND_TWO_LARGE_MITT_CNT";
	public static final String KEY_ROUND_TWO_LARGE_MITT_CNT = "roundTwoLargeMittCnt";
	private int roundTwoLargeMittCnt;

	public static final String COLUMN_NAME_ROUND_TREE_GAME_TIME = "ROUND_TREE_GAME_TIME";
	public static final String KEY_ROUND_TREE_GAME_TIME = "roundTreeGameTime";
	private int roundTreeGameTime;

	public static final String COLUMN_NAME_ROUND_TREE_BREAK_TIME = "ROUND_TREE_BREAK_TIME";
	public static final String KEY_ROUND_TREE_BREAK_TIME = "roundTreeBreakTime";
	private int roundTreeBreakTime;

	public static final String COLUMN_NAME_ROUND_TREE_DOUBLE_TARGET_MITT_CNT = "ROUND_TREE_DOUBLE_TARGET_MITT_CNT";
	public static final String KEY_ROUND_TREE_DOUBLE_TARGET_MITT_CNT = "roundTreeDoubleTargetMittCnt";
	private int roundTreeDoubleTargetMittCnt;

	public static final String COLUMN_NAME_ROUND_TREE_LARGE_MITT_CNT = "ROUND_TREE_LARGE_MITT_CNT";
	public static final String KEY_ROUND_TREE_LARGE_MITT_CNT = "roundTreeLargeMittCnt";
	private int roundTreeLargeMittCnt;

	public static final String COLUMN_NAME_ROUND_FOUR_GAME_TIME = "ROUND_FOUR_GAME_TIME";
	public static final String KEY_ROUND_FOUR_GAME_TIME = "roundFourGameTime";
	private int roundFourGameTime;

	public static final String COLUMN_NAME_ROUND_FOUR_BREAK_TIME = "ROUND_FOUR_BREAK_TIME";
	public static final String KEY_ROUND_FOUR_BREAK_TIME = "roundFourBreakTime";
	private int roundFourBreakTime;

	public static final String COLUMN_NAME_ROUND_FOUR_DOUBLE_TARGET_MITT_CNT = "ROUND_FOUR_DOUBLE_TARGET_MITT_CNT";
	public static final String KEY_ROUND_FOUR_DOUBLE_TARGET_MITT_CNT = "roundFourDoubleTargetMittCnt";
	private int roundFourDoubleTargetMittCnt;

	public static final String COLUMN_NAME_ROUND_FOUR_LARGE_MITT_CNT = "ROUND_FOUR_LARGE_MITT_CNT";
	public static final String KEY_ROUND_FOUR_LARGE_MITT_CNT = "roundFourLargeMittCnt";
	private int roundFourLargeMittCnt;

	public static final String COLUMN_NAME_ROUND_FIVE_GAME_TIME = "ROUND_FIVE_GAME_TIME";
	public static final String KEY_ROUND_FIVE_GAME_TIME = "roundFiveGameTime";
	private int roundFiveGameTime;

	public static final String COLUMN_NAME_ROUND_FIVE_BREAK_TIME = "ROUND_FIVE_BREAK_TIME";
	public static final String KEY_ROUND_FIVE_BREAK_TIME = "roundFiveBreakTime";
	private int roundFiveBreakTime;

	public static final String COLUMN_NAME_ROUND_FIVE_DOUBLE_TARGET_MITT_CNT = "ROUND_FIVE_DOUBLE_TARGET_MITT_CNT";
	public static final String KEY_ROUND_FIVE_DOUBLE_TARGET_MITT_CNT = "roundFiveDoubleTargetMittCnt";
	private int roundFiveDoubleTargetMittCnt;

	public static final String COLUMN_NAME_ROUND_FIVE_LARGE_MITT_CNT = "ROUND_FIVE_LARGE_MITT_CNT";
	public static final String KEY_ROUND_FIVE_LARGE_MITT_CNT = "roundFiveLargeMittCnt";
	private int roundFiveLargeMittCnt;

	public static final String COLUMN_NAME_EVENT_ORDER = "EVENT_ORDER";
	public static final String KEY_EVENT_ORDER = "eventOrder";
	private int eventOrder;

	WeightClass[] weightClasses;

	public int getEventIndex () {
		return eventIndex;
	}

	public void setEventIndex (int eventIndex) {
		this.eventIndex = eventIndex;
	}

	public int getCompetitionIndex () {
		return competitionIndex;
	}

	public void setCompetitionIndex (int competitionIndex) {
		this.competitionIndex = competitionIndex;
	}

	public String getEventNameKO() {
		return eventNameKO;
	}

	public void setEventNameKO(String eventNameKO) {
		this.eventNameKO = eventNameKO;
	}

	public String getEventNameEN() {
		return eventNameEN;
	}

	public void setEventNameEN(String eventNameEN) {
		this.eventNameEN = eventNameEN;
	}

	public int getEventClassification () {
		return eventClassification;
	}

	public void setEventClassification (int eventClassification) {
		this.eventClassification = eventClassification;
	}

	public int getEventType () {
		return eventType;
	}

	public void setEventType (int eventType) {
		this.eventType = eventType;
	}

	public int getEventRating () {
		return eventRating;
	}

	public void setEventRating (int eventRating) {
		this.eventRating = eventRating;
	}

	public int getRoundCnt () {
		return roundCnt;
	}

	public void setRoundCnt (int roundCnt) {
		this.roundCnt = roundCnt;
	}

	public int getRoundOneGameTime () {
		return roundOneGameTime;
	}

	public void setRoundOneGameTime (int roundOneGameTime) {
		this.roundOneGameTime = roundOneGameTime;
	}

	public int getRoundOneBreakTime () {
		return roundOneBreakTime;
	}

	public void setRoundOneBreakTime (int roundOneBreakTime) {
		this.roundOneBreakTime = roundOneBreakTime;
	}

	public int getRoundOneDoubleTargetMittCnt () {
		return roundOneDoubleTargetMittCnt;
	}

	public void setRoundOneDoubleTargetMittCnt (int roundOneDoubleTargetMittCnt) {
		this.roundOneDoubleTargetMittCnt = roundOneDoubleTargetMittCnt;
	}

	public int getRoundOneLargeMittCnt () {
		return roundOneLargeMittCnt;
	}

	public void setRoundOneLargeMittCnt (int roundOneLargeMittCnt) {
		this.roundOneLargeMittCnt = roundOneLargeMittCnt;
	}

	public int getRoundTwoGameTime () {
		return roundTwoGameTime;
	}

	public void setRoundTwoGameTime (int roundTwoGameTime) {
		this.roundTwoGameTime = roundTwoGameTime;
	}

	public int getRoundTwoBreakTime () {
		return roundTwoBreakTime;
	}

	public void setRoundTwoBreakTime (int roundTwoBreakTime) {
		this.roundTwoBreakTime = roundTwoBreakTime;
	}

	public int getRoundTwoDoubleTargetMittCnt () {
		return roundTwoDoubleTargetMittCnt;
	}

	public void setRoundTwoDoubleTargetMittCnt (int roundTwoDoubleTargetMittCnt) {
		this.roundTwoDoubleTargetMittCnt = roundTwoDoubleTargetMittCnt;
	}

	public int getRoundTwoLargeMittCnt () {
		return roundTwoLargeMittCnt;
	}

	public void setRoundTwoLargeMittCnt (int roundTwoLargeMittCnt) {
		this.roundTwoLargeMittCnt = roundTwoLargeMittCnt;
	}

	public int getRoundTreeGameTime () {
		return roundTreeGameTime;
	}

	public void setRoundTreeGameTime (int roundTreeGameTime) {
		this.roundTreeGameTime = roundTreeGameTime;
	}

	public int getRoundTreeBreakTime () {
		return roundTreeBreakTime;
	}

	public void setRoundTreeBreakTime (int roundTreeBreakTime) {
		this.roundTreeBreakTime = roundTreeBreakTime;
	}

	public int getRoundTreeDoubleTargetMittCnt () {
		return roundTreeDoubleTargetMittCnt;
	}

	public void setRoundTreeDoubleTargetMittCnt (int roundTreeDoubleTargetMittCnt) {
		this.roundTreeDoubleTargetMittCnt = roundTreeDoubleTargetMittCnt;
	}

	public int getRoundTreeLargeMittCnt () {
		return roundTreeLargeMittCnt;
	}

	public void setRoundTreeLargeMittCnt (int roundTreeLargeMittCnt) {
		this.roundTreeLargeMittCnt = roundTreeLargeMittCnt;
	}

	public int getRoundFourGameTime () {
		return roundFourGameTime;
	}

	public void setRoundFourGameTime (int roundFourGameTime) {
		this.roundFourGameTime = roundFourGameTime;
	}

	public int getRoundFourBreakTime () {
		return roundFourBreakTime;
	}

	public void setRoundFourBreakTime (int roundFourBreakTime) {
		this.roundFourBreakTime = roundFourBreakTime;
	}

	public int getRoundFourDoubleTargetMittCnt () {
		return roundFourDoubleTargetMittCnt;
	}

	public void setRoundFourDoubleTargetMittCnt (int roundFourDoubleTargetMittCnt) {
		this.roundFourDoubleTargetMittCnt = roundFourDoubleTargetMittCnt;
	}

	public int getRoundFourLargeMittCnt () {
		return roundFourLargeMittCnt;
	}

	public void setRoundFourLargeMittCnt (int roundFourLargeMittCnt) {
		this.roundFourLargeMittCnt = roundFourLargeMittCnt;
	}

	public int getRoundFiveGameTime () {
		return roundFiveGameTime;
	}

	public void setRoundFiveGameTime (int roundFiveGameTime) {
		this.roundFiveGameTime = roundFiveGameTime;
	}

	public int getRoundFiveBreakTime () {
		return roundFiveBreakTime;
	}

	public void setRoundFiveBreakTime (int roundFiveBreakTime) {
		this.roundFiveBreakTime = roundFiveBreakTime;
	}

	public int getRoundFiveDoubleTargetMittCnt () {
		return roundFiveDoubleTargetMittCnt;
	}

	public void setRoundFiveDoubleTargetMittCnt (int roundFiveDoubleTargetMittCnt) {
		this.roundFiveDoubleTargetMittCnt = roundFiveDoubleTargetMittCnt;
	}

	public int getRoundFiveLargeMittCnt () {
		return roundFiveLargeMittCnt;
	}

	public void setRoundFiveLargeMittCnt (int roundFiveLargeMittCnt) {
		this.roundFiveLargeMittCnt = roundFiveLargeMittCnt;
	}

	public int getEventOrder() {
		return eventOrder;
	}

	public void setEventOrder(int eventOrder) {
		this.eventOrder = eventOrder;
	}

	public WeightClass[] getWeightClasses() {
		return weightClasses;
	}

	public void setWeightClasses(WeightClass[] weightClasses) {
		this.weightClasses = weightClasses;
	}

}