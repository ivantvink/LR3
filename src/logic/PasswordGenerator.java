package logic;

import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()_+-=[]{}|;':,.<>?";

    // Метод для генерации пароля
    public static String generate(int length, boolean useNumbers, boolean useUppercase, boolean useSymbols) {
        StringBuilder characterPool = new StringBuilder(LOWERCASE);
        SecureRandom random = new SecureRandom();

        // Добавляем выбранные типы символов в пул символов
        if (useNumbers) characterPool.append(DIGITS);
        if (useUppercase) characterPool.append(UPPERCASE);
        if (useSymbols) characterPool.append(SYMBOLS);

        // Если пользователь не выбрал ни одного типа символов, выбрасываем исключение
        if (characterPool.isEmpty()) {
            throw new IllegalArgumentException("No character types selected. Please select at least one option.");
        }

        // Генерация пароля из выбранного пула символов
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            password.append(characterPool.charAt(random.nextInt(characterPool.length())));
        }

        return password.toString();
    }
}