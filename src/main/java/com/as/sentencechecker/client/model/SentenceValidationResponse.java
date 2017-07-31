package com.as.sentencechecker.client.model;

/**
 * @author Vadzim Mikhalenak.
 */
public class SentenceValidationResponse implements JacksonSettings {

	private boolean valid;

	public SentenceValidationResponse(boolean valid) {
		this.valid = valid;
	}

	public boolean isValid() {
		return valid;
	}
}
