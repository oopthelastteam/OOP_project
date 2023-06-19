package datamodel;

import java.util.List;
import java.util.Map;

import constant.constants;

public class FestivalEntity extends baseEntity{

	public FestivalEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FestivalEntity(String name, Map<String, String> additionalInfo) {
		super(name, additionalInfo);
		// TODO Auto-generated constructor stub
	}

	public FestivalEntity(String name, String description, Map<String, String> additionalInfo,
			List<String> relatedEntityIds, String rootURL) {
		super(name, description, additionalInfo, relatedEntityIds, rootURL);
		// TODO Auto-generated constructor stub
	}

	public FestivalEntity(String name, String description, Map<String, String> additionalInfo) {
		super(name, description, additionalInfo);
		// TODO Auto-generated constructor stub
	}
	public String getType() {
		return constants.FESTIVAL_ENTITY;
	}
}
