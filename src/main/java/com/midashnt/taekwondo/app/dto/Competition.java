package com.midashnt.taekwondo.app.dto;

import org.springframework.stereotype.Component;

@Component
public class Competition {

	public static final String COLUMN_NAME_COMPETITION_INDEX = "COMPETITION_INDEX";
	public static final String KEY_COMPETITION_INDEX = "competitionIndex";
	private int competitionIndex;

	public static final String COLUMN_NAME_COMPETITION_CLASSIFICATION = "COMPETITION_CLASSIFICATION";
	public static final String KEY_COMPETITION_CLASSIFICATION = "competitionClassification";
	private String competitionClassification;

	public static final String COLUMN_NAME_COMPETITION_NAME_KO = "COMPETITION_NAME_KO";
	public static final String KEY_COMPETITION_NAME_KO = "competitionNameKO";
	private String competitionNameKO;

	public static final String COLUMN_NAME_COMPETITION_NAME_EN = "COMPETITION_NAME_EN";
	public static final String KEY_COMPETITION_NAME_EN = "competitionNameEN";
	private String competitionNameEN;

	public static final String COLUMN_NAME_COMPETITION_GRADE = "COMPETITION_GRADE";
	public static final String KEY_COMPETITION_GRADE = "competitionGrade";
	private int competitionGrade;

	public static final String COLUMN_NAME_COMPETITION_HOST_INSTITUTION_KO = "COMPETITION_HOST_INSTITUTION_KO";
	public static final String KEY_COMPETITION_HOST_INSTITUTION_KO = "competitionHostInstitutionKO";
	private String competitionHostInstitutionKO;

	public static final String COLUMN_NAME_COMPETITION_HOST_INSTITUTION_EN = "COMPETITION_HOST_INSTITUTION_EN";
	public static final String KEY_COMPETITION_HOST_INSTITUTION_EN = "competitionHostInstitutionEN";
	private String competitionHostInstitutionEN;

	public static final String COLUMN_NAME_COMPETITION_START_DATE = "COMPETITION_START_DATE";
	public static final String KEY_COMPETITION_START_DATE = "competitionStartDate";
	private String competitionStartDate;

	public static final String COLUMN_NAME_COMPETITION_END_DATE = "COMPETITION_END_DATE";
	public static final String KEY_COMPETITION_END_DATE = "competitionEndDate";
	private String competitionEndDate;

	public static final String COLUMN_NAME_REGISTRATION_START_DATE = "REGISTRATION_START_DATE";
	public static final String KEY_REGISTRATION_START_DATE = "registrationStartDate";
	private String registrationStartDate;

	public static final String COLUMN_NAME_REGISTRATION_END_DATE = "REGISTRATION_END_DATE";
	public static final String KEY_REGISTRATION_END_DATE = "registrationEndDate";
	private String registrationEndDate;

	public static final String COLUMN_NAME_CORRECTION_START_DATE = "CORRECTION_START_DATE";
	public static final String KEY_CORRECTION_START_DATE = "correctionStartDate";
	private String correctionStartDate;

	public static final String COLUMN_NAME_CORRECTION_END_DATE = "CORRECTION_END_DATE";
	public static final String KEY_CORRECTION_END_DATE = "correctionEndDate";
	private String correctionEndDate;

	public static final String COLUMN_NAME_COMPETITION_HOMEPAGE = "COMPETITION_HOMEPAGE";
	public static final String KEY_COMPETITION_HOMEPAGE = "competitionHomepage";
	private String competitionHomepage;

	public static final String COLUMN_NAME_COMPETITION_LOGO_PATH = "COMPETITION_LOGO_PATH";
	public static final String KEY_COMPETITION_LOGO_PATH = "competitionLogoPath";
	private String competitionLogoPath;

	public static final String COLUMN_NAME_COMPETITION_IMAGE_PATH = "COMPETITION_IMAGE_PATH";
	public static final String KEY_COMPETITION_IMAGE_PATH = "competitionImagePath";
	private String competitionImagePath;

	public int getCompetitionIndex () {
		return competitionIndex;
	}

	public void setCompetitionIndex (int competitionIndex) {
		this.competitionIndex = competitionIndex;
	}

	public String getCompetitionClassification() {
		return competitionClassification;
	}

	public void setCompetitionClassification(String competitionClassification) {
		this.competitionClassification = competitionClassification;
	}

	public String getCompetitionNameKO() {
		return competitionNameKO;
	}

	public void setCompetitionNameKO(String competitionNameKO) {
		this.competitionNameKO = competitionNameKO;
	}

	public String getCompetitionNameEN() {
		return competitionNameEN;
	}

	public void setCompetitionNameEN(String competitionNameEN) {
		this.competitionNameEN = competitionNameEN;
	}

	public int getCompetitionGrade() {
		return competitionGrade;
	}

	public void setCompetitionGrade(int competitionGrade) {
		this.competitionGrade = competitionGrade;
	}

	public String getCompetitionHostInstitutionKO() {
		return competitionHostInstitutionKO;
	}

	public void setCompetitionHostInstitutionKO(String competitionHostInstitutionKO) {
		this.competitionHostInstitutionKO = competitionHostInstitutionKO;
	}

	public String getCompetitionHostInstitutionEN() {
		return competitionHostInstitutionEN;
	}

	public void setCompetitionHostInstitutionEN(String competitionHostInstitutionEN) {
		this.competitionHostInstitutionEN = competitionHostInstitutionEN;
	}

	public String getCompetitionStartDate () {
		return competitionStartDate;
	}

	public void setCompetitionStartDate (String competitionStartDate) {
		this.competitionStartDate = competitionStartDate;
	}

	public String getCompetitionEndDate () {
		return competitionEndDate;
	}

	public void setCompetitionEndDate (String competitionEndDate) {
		this.competitionEndDate = competitionEndDate;
	}

	public String getRegistrationStartDate () {
		return registrationStartDate;
	}

	public void setRegistrationStartDate (String registrationStartDate) {
		this.registrationStartDate = registrationStartDate;
	}

	public String getRegistrationEndDate () {
		return registrationEndDate;
	}

	public void setRegistrationEndDate (String registrationEndDate) {
		this.registrationEndDate = registrationEndDate;
	}

	public String getCorrectionStartDate () {
		return correctionStartDate;
	}

	public void setCorrectionStartDate (String correctionStartDate) {
		this.correctionStartDate = correctionStartDate;
	}

	public String getCorrectionEndDate () {
		return correctionEndDate;
	}

	public void setCorrectionEndDate (String correctionEndDate) {
		this.correctionEndDate = correctionEndDate;
	}

	public String getCompetitionHomepage() {
		return competitionHomepage;
	}

	public void setCompetitionHomepage(String competitionHomepage) {
		this.competitionHomepage = competitionHomepage;
	}

	public String getCompetitionLogoPath () {
		return competitionLogoPath;
	}

	public void setCompetitionLogoPath (String competitionLogoPath) {
		this.competitionLogoPath = competitionLogoPath;
	}

	public String getCompetitionImagePath () {
		return competitionImagePath;
	}

	public void setCompetitionImagePath (String competitionImagePath) {
		this.competitionImagePath = competitionImagePath;
	}

}