package com.fmi.fengshuirestapi;

public class Response {
	private final String contentType;
	private final String content;

	public Response(String contentType, String content) {
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
