package com.fmi.fengshuirestapi.pojo;

public class FengShuiResponse {
	private final String contentType;
	private final String content;

	public FengShuiResponse(String contentType, String content) {
		this.contentType = contentType;
		this.content = content;
	}

	public String getContentType() {
		return contentType;
	}

	public String getContent() {
		return content;
	}
}