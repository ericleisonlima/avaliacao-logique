package model;

public class LinkBean {
	
	private int id;
	private String url;
	private String code;
	private String custom;
	
	public LinkBean() {
		// TODO Auto-generated constructor stub
	}
	
	public LinkBean(int id, String url, String code, String custom) {
		this.id = id;
		this.url = url;
		this.code = code;
		this.custom = custom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCustom() {
		return custom;
	}

	public void setCustom(String custom) {
		this.custom = custom;
	}
	
	

}
