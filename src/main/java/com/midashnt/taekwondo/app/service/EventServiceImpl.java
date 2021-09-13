package com.midashnt.taekwondo.app.service;

import com.midashnt.taekwondo.app.dto.Event;
import com.midashnt.taekwondo.app.mapper.EventMapper;
import com.midashnt.taekwondo.app.mapper.WeightClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EventServiceImpl implements EventService {

	protected EventMapper eventMapper;
	protected WeightClassMapper weightClassMapper;

	@Autowired
	public EventServiceImpl(EventMapper eventMapper, WeightClassMapper weightClassMapper) {
		this.eventMapper = eventMapper;
		this.weightClassMapper = weightClassMapper;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void createEvent(Event event) {
		eventMapper.createEvent(event);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void updateEvent(Event event) {
		eventMapper.updateEvent(event);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
	@Override
	public Event getEventByIndex(int eventIndex) {
		return eventMapper.getEventByIndex(eventIndex);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
	@Override
	public List<Event> getEventListByCompetitionIndex(int competitionIndex) {
		return eventMapper.getEventListByCompetitionIndex(competitionIndex);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String,Object>> getEventListAndWeightClassListByCompetitionIndex(int competitionIndex) {
		List<Map<String, Object>> eventMapList = eventMapper.getEventMapListByCompetitionIndex(competitionIndex);
		for (Map<String, Object> objectMap : eventMapList) {
			List<Map<String, Object>> weightClassMapList = weightClassMapper.getWeightClassMapListByEventIndex((Integer) objectMap.get(Event.KEY_EVENT_INDEX));
			for (Map<String, Object> weightClassMap : weightClassMapList) {
				List<Map<String, Object>> roundInfoList = new ArrayList<>();

				Map<String, Object> roundInfo = (Map<String, Object>) weightClassMap.get("roundOne");
				if ((Integer) roundInfo.get("roundGameTime") != 0) {
					roundInfoList.add(roundInfo);
				}

				roundInfo = (Map<String, Object>) weightClassMap.get("roundTwo");
				if ((Integer) roundInfo.get("roundGameTime") != 0) {
					roundInfoList.add(roundInfo);
				}

				roundInfo = (Map<String, Object>) weightClassMap.get("roundTree");
				if ((Integer) roundInfo.get("roundGameTime") != 0) {
					roundInfoList.add(roundInfo);
				}

				roundInfo = (Map<String, Object>) weightClassMap.get("roundFour");
				if ((Integer) roundInfo.get("roundGameTime") != 0) {
					roundInfoList.add(roundInfo);
				}

				roundInfo = (Map<String, Object>) weightClassMap.get("roundFive");
				if ((Integer) roundInfo.get("roundGameTime") != 0) {
					roundInfoList.add(roundInfo);
				}

				weightClassMap.remove("roundOne");
				weightClassMap.remove("roundTwo");
				weightClassMap.remove("roundTree");
				weightClassMap.remove("roundFour");
				weightClassMap.remove("roundFive");

				weightClassMap.put("roundInfo", roundInfoList);
			}

			objectMap.put("weightClasses", weightClassMapList);
		}

		return eventMapList;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void deleteEvent(int eventIndex) {
		eventMapper.deleteEvent(eventIndex);
	}

}