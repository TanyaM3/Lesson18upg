package by.epam.hw.less18.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria {
	private String groupSearchName;
	private Map<String, Object> criteria = new HashMap<String, Object>();
	private int numberOfCriteria = 0;

	public Criteria() {
	}

	public Criteria(String groupSearchName) {
		this.groupSearchName = groupSearchName;
		this.numberOfCriteria = 0;
	}

	public String getGroupSearchName() {
		return groupSearchName;
	}

	public void add(String searchCriteria, Object value) {
		getCriteria().put(searchCriteria, value);
		numberOfCriteria++;
	}

	public int getNumberOfCriteria() {
		return numberOfCriteria;
	}

	public void setNumberOfCriteria(int numberOfCriteria) {
		this.numberOfCriteria = numberOfCriteria;
	}

	public Map<String, Object> getCriteria() {
		return criteria;
	}

	public void setCriteria(Map<String, Object> criteria) {
		this.criteria = criteria;
	}
}