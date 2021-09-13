package com.midashnt.taekwondo.app.mapper;

import com.midashnt.taekwondo.app.dto.Competition;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CompetitionMapper {

	String createCompetition(Competition competition);

	void updateCompetition(Competition competition);

	Competition getCompetitionByIndex(int competitionIndex);

	List<Competition> getCompetitionListByCompetitionClassification(String competitionClassification);

	void deleteCompetition(int competitionIndex);

}