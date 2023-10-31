package com.wilk.tomasz.service.data;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class DataGenerator {

    private static final int OUTSIDE_EXISTING_RANGE = 1000;
    private static final int USER_COLLECTION_SIZE = 10;
    private static final int POST_COLLECTION_SIZE = 100;
    private static final int COMMENT_COLLECTION_SIZE = 500;
    private static final Random random = new Random();

    public static String generateRandomName() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public static String generateRandomBody() {
        return RandomStringUtils.randomAlphabetic(50);
    }

    public static String generateRandomEmailAddress() {
        return RandomStringUtils.randomAlphabetic(15) + "@randomEmail.com";
    }

    public static int getExistingUserId() {
        return random.nextInt(1, USER_COLLECTION_SIZE);
    }

    public static int getNotExistingUserId() {
        return getExistingUserId() + OUTSIDE_EXISTING_RANGE;
    }

    public static int getExistingPostId() {
        return random.nextInt(1, POST_COLLECTION_SIZE);
    }

    public static int getNotExistingPostId() {
        return getExistingPostId() + OUTSIDE_EXISTING_RANGE;
    }

    public static int getExistingCommentId() {
        return random.nextInt(1, COMMENT_COLLECTION_SIZE);
    }

    public static int getNotExistingCommentId() {
        return getExistingCommentId() + OUTSIDE_EXISTING_RANGE;
    }
}
