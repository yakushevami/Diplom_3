package user;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {

    public static User getNewRandomUser() {
        return new User(RandomStringUtils.randomAlphabetic(6),
                  RandomStringUtils.randomAlphanumeric(7) + "@yandex.ru",
                        RandomStringUtils.randomAlphanumeric(8));
    }
}