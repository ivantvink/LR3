package utils;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class ClipboardUtils {
    // Метод для копирования текста в буфер обмена
    public static void copyToClipboard(String str) {
        StringSelection selection = new StringSelection(str);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
    }

    // Дополнительный метод для очистки буфера обмена
    public static void clearClipboard() {
        StringSelection selection = new StringSelection("");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
    }
}