package logic;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()_+-=[]{}|;':,.<>?";

    public static String generate(int length, boolean useNumbers, boolean useUppercase, boolean useSymbols) {
        StringBuilder characterPool = new StringBuilder(LOWERCASE);
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Сначала добавляем по одному символу из каждого выбранного типа
        if (useNumbers) {
            password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
            characterPool.append(DIGITS);
        }
        if (useUppercase) {
            password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
            characterPool.append(UPPERCASE);
        }
        if (useSymbols) {
            password.append(SYMBOLS.charAt(random.nextInt(SYMBOLS.length())));
            characterPool.append(SYMBOLS);
        }

        // Если пользователь не выбрал ни одного типа символов
        if (characterPool.length() == LOWERCASE.length()) {
            throw new IllegalArgumentException("No character types selected. Please select at least one option.");
        }

        // Генерируем оставшуюся часть пароля
        for (int i = password.length(); i < length; i++) {
            password.append(characterPool.charAt(random.nextInt(characterPool.length())));
        }

        // Перемешиваем символы, чтобы гарантировать случайность
        return shuffleString(password.toString());
    }

    // Метод для перемешивания символов в строке
    private static String shuffleString(String input) {
        List<Character> characters = new ArrayList<>();
        for (char c : input.toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle(characters);
        StringBuilder shuffled = new StringBuilder();
        for (char c : characters) {
            shuffled.append(c);
        }
        return shuffled.toString();
    }
}