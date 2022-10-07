package by.epam.hw.less18.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import by.epam.hw.less18.entity.criteria.Criteria;

public class DeviceDataMatcher {
	private List<String> dataFromSource;
	private Criteria criteria;
	
	public DeviceDataMatcher(List<String> dataFromSource, Criteria criteria) {
		this.dataFromSource = dataFromSource;
		this.criteria = criteria;
	}
	
	public List<String> match(){
		List<String> deviceDataResult = new ArrayList<>();
		List<String> searchPatterns = formFindPattern();
		
		for (String data : dataFromSource){
			if(checkToPatters(data, searchPatterns) == true){
				deviceDataResult.add(data);
			}
		}
		return deviceDataResult;
}
		
	private List<String> formFindPattern(){
		List<String> list = new ArrayList<String>();
		
		for(Map.Entry<String, Object> pair : criteria.getCriteria().entrySet()) {
			String line = pair.getKey() + "=" + pair.getValue();
			list.add(line);
		}
		return list;
	}
	
	private boolean checkToPatters(String data, List<String> searchPatterns){
		for(String pattern : searchPatterns){
			if(!data.contains(pattern)){
				return false;
			}
		}		
		return true;
	}
}
