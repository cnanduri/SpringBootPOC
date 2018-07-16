package com.cn.vo;

public class Header {

	private String contentType;

	private String transactionId;

	private Header() {

	}

	public String getContentType() {
		return contentType;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public static class HeaderBuilder {
		private String contentType;

		private String transactionId;

		public HeaderBuilder setContentType(String contentType) {
			this.contentType = contentType;
			return this;
		}

		public HeaderBuilder setTransactionId(String transactionId) {
			this.transactionId = transactionId;
			return this;
		}

		public Header build() {
			Header header = new Header();
			header.contentType = contentType;
			header.transactionId = transactionId;
			return header;
		}

	}

}

