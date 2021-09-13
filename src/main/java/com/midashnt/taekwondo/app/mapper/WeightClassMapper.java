package com.midashnt.taekwondo.app.mapper;

import com.midashnt.taekwondo.app.dto.WeightClass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface WeightClassMapper {

	String createWeightClass(WeightClass weightClass);

	void updateWeightClass(WeightClass weightClass);

	WeightClass getWeightClassByIndex(int weightClassIndex);

	List<WeightClass> getWeightClassListByEventIndex(int eventIndex);

	List<Map<String, Object>> getWeightClassMapListByEventIndex(int eventIndex);

	void deleteWeightClass(int weightClassIndex);

}