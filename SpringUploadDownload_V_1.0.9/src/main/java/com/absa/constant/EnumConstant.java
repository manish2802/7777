package com.absa.constant;

public enum EnumConstant {

	INVALID_REQUEST(0, "The request is invalid"), MISSING_PARAMETER(1,
			"Required query parameter is missing"), MISSING_HEADER(2,
					"Required header is missing"), FIXED_URL(4, "abc&&/URL=");
	private final int id;
	private final String msg;

	EnumConstant(int id, String msg) {
		this.id = id;
		this.msg = msg;
	}

	public int getId() {
		return this.id;
	}

	public String getMsg() {
		return this.msg;
	}

}
