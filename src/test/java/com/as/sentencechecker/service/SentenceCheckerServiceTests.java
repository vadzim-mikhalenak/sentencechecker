package com.as.sentencechecker.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Vadzim Mikhalenak.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SentenceCheckerServiceTests {

	@Autowired
	private SentenceCheckerService sentenceCheckerService;

	@Before
	public void setup() {
		sentenceCheckerService.clearVocabulary();
	}

	@Test
	public void testNoSuchWordInTheVocabulary() {
		boolean isValid = sentenceCheckerService.checkSentenceIsValid("sentence");
		Assert.assertFalse(isValid);
	}


	@Test
	public void testWordInTheVocabularyAsIs() {
		sentenceCheckerService.addWordsToVocabulary("sentence");
		boolean isValid = sentenceCheckerService.checkSentenceIsValid("sentence");
		Assert.assertTrue(isValid);
	}

	@Test
	public void testWordInTheVocabularyWithAnotherLettersOrder() {
		sentenceCheckerService.addWordsToVocabulary("sentence");
		boolean isValid = sentenceCheckerService.checkSentenceIsValid("sentenec");
		Assert.assertTrue(isValid);
	}


	@Test
	public void testTheSameSentence() {
		sentenceCheckerService.addWordsToVocabulary("This is a valid sentence");
		boolean isValid = sentenceCheckerService.checkSentenceIsValid("This is a valid sentence");
		Assert.assertTrue(isValid);
	}


	@Test
	public void testSentenceWithAnotherLettersOrder() {
		sentenceCheckerService.addWordsToVocabulary("This is a valid sentence");
		boolean isValid = sentenceCheckerService.checkSentenceIsValid("Thsi si a valdi sentence ");
		Assert.assertTrue(isValid);
	}

	@Test
	public void testInvalidSentence() {
		sentenceCheckerService.addWordsToVocabulary("This is a valid sentence");
		boolean isValid = sentenceCheckerService.checkSentenceIsValid("Ths sis a valid sentence");
		Assert.assertFalse(isValid);
	}


}
