package com.midashnt.taekwondo.app.service;

import com.midashnt.taekwondo.app.dto.Competition;
import com.midashnt.taekwondo.app.mapper.CompetitionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompetitionServiceImpl implements CompetitionService {

	protected CompetitionMapper competitionMapper;

	@Autowired
	public CompetitionServiceImpl(CompetitionMapper competitionMapper) {
		this.competitionMapper = competitionMapper;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void createCompetition(Competition competition) {
		competitionMapper.createCompetition(competition);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void updateCompetition(Competition competition) {
		competitionMapper.updateCompetition(competition);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
	@Override
	public Competition getCompetitionByIndex(int competitionIndex) {
		return competitionMapper.getCompetitionByIndex(competitionIndex);
	}

	@Override
	public List<Competition> getCompetitionListByCompetitionClassification(String competitionClassification) {
		return competitionMapper.getCompetitionListByCompetitionClassification(competitionClassification);
	}


	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void deleteCompetition(int competitionIndex) {
		competitionMapper.deleteCompetition(competitionIndex);
	}

}