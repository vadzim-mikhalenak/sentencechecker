package com.as.sentencechecker.controller;

import com.as.sentencechecker.client.model.AddSentenceRequest;
import com.as.sentencechecker.client.model.SentenceValidationResponse;
import com.as.sentencechecker.service.SentenceCheckerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vadzim Mikhalenak.
 */

@RestController
@RequestMapping("v1/checker")
public class SentenceCheckerController {

	private static final Logger logger = LoggerFactory.getLogger(SentenceCheckerController.class);

	private final SentenceCheckerService sentenceCheckerService;

	public SentenceCheckerController(SentenceCheckerService sentenceCheckerService) {
		this.sentenceCheckerService = sentenceCheckerService;
	}

	@RequestMapping(value = "/sentence/add", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public void setLeftPart(@RequestBody AddSentenceRequest request) {
		logger.info("Add sentence {} to the vocabulary", request.getSentence());
		sentenceCheckerService.addWordsToVocabulary(request.getSentence());
	}

	@RequestMapping(value = "/sentence/check", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public SentenceValidationResponse getDiff(@RequestBody AddSentenceRequest request) {
		logger.info("Check sentence {}", request.getSentence());
		boolean isValid = sentenceCheckerService.checkSentenceIsValid(request.getSentence());

		return new SentenceValidationResponse(isValid);
	}

}
