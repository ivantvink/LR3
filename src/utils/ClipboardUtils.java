package utils;

import javax.swing.*;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class ClipboardUtils {
    // Метод для копирования текста в буфер обмена с выводом сообщения
    public static void copyToClipboard(String str) {
        StringSelection selection = new StringSelection(str);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        JOptionPane.showMessageDialog(null, "Password copied to clipboard!");
    }

    // Дополнительный метод для очистки буфера обмена
    public static void clearClipboard() {
        StringSelection selection = new StringSelection("");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
    }
}