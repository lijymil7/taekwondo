package com.midashnt.taekwondo.app.mapper;

import com.midashnt.taekwondo.app.dto.Event;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface EventMapper {

	String createEvent(Event event);

	void updateEvent(Event event);

	Event getEventByIndex(int eventIndex);

	List<Event> getEventListByCompetitionIndex(int competitionIndex);

	List<Map<String,Object>> getEventMapListByCompetitionIndex(int competitionIndex);

	void deleteEvent(int eventIndex);

}