package com.as.sentencechecker.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Vadzim Mikhalenak.
 */
@Service
public class SentenceCheckerService {

	private static final Logger logger = LoggerFactory.getLogger(SentenceCheckerService.class);

	private Set<String> vocabulary = new HashSet<>();

	/**
	 * Adds words from the sentence to the internal vocabulary.
	 *
	 * @param sentence
	 */
	public void addWordsToVocabulary(String sentence) {
		String[] words = sentence.toLowerCase().split(" ");

		for (final String word : words) {
			addWordToVocabulary(word);
		}
	}

	/**
	 * Check if the whole sentence is valid by checking if each word from the sentence is valid.
	 * The word is valid if at least one permutation of its letters presents in the internal vocabulary.
	 * All words are lover-cased before testing.
	 *
	 * @param sentence to be tested.
	 * @return true if sentence is valid
	 */
	public boolean checkSentenceIsValid(String sentence) {
		if (sentence == null) {
			return false;
		}

		logger.debug("Checking {} for validation", sentence);

		String[] words = sentence.toLowerCase().split(" ");

		for (final String word : words) {
			if (!checkWordIsValid(word)) {
				logger.debug("Word {} can't be found in the vocabulary", word);
				return false;
			}
		}
		return true;
	}

	protected void clearVocabulary() {
		vocabulary.clear();
	}

	private boolean checkWordIsValid(String word) {
		char[] chars = word.toCharArray();
		Arrays.sort(chars);
		return vocabulary.contains(new String(chars));
	}

	private void addWordToVocabulary(String word) {

		char[] chars = word.toCharArray();
		Arrays.sort(chars);
		String ordered = new String(chars);
		vocabulary.add(ordered);

		logger.debug("{} is added as {}", word, ordered);
	}

}
