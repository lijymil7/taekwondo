package com.midashnt.taekwondo.app.service;
import com.midashnt.taekwondo.app.dto.WeightClass;
import com.midashnt.taekwondo.app.mapper.WeightClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class WeightClassServiceImpl implements WeightClassService {
	protected WeightClassMapper weightClassMapper;
	@Autowired
	public WeightClassServiceImpl(WeightClassMapper weightClassMapper) {
		this.weightClassMapper = weightClassMapper;
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void createWeightClass(WeightClass weightClass) {
		weightClassMapper.createWeightClass(weightClass);
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void updateWeightClass(WeightClass weightClass) {
		weightClassMapper.updateWeightClass(weightClass);
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
	@Override
	public WeightClass getWeightClassByIndex(int weightClassIndex) {
		return weightClassMapper.getWeightClassByIndex(weightClassIndex);
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
	@Override
	public List<WeightClass> getWeightClassListByEventIndex(int eventIndex) {
		return weightClassMapper.getWeightClassListByEventIndex(eventIndex);
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void deleteWeightClass(int weightClassIndex) {
		weightClassMapper.deleteWeightClass(weightClassIndex);
	}
}