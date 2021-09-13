package com.midashnt.taekwondo.app.service;
import com.midashnt.taekwondo.app.dto.WeightClass;
import java.util.List;
public interface WeightClassService {
	void createWeightClass(WeightClass weightClass);
	void updateWeightClass(WeightClass weightClass);
	WeightClass getWeightClassByIndex(int weightClassIndex);
	List<WeightClass> getWeightClassListByEventIndex(int eventIndex);
	void deleteWeightClass(int weightClassIndex);
}