package com.tat.development.skills.utils;

import java.util.Locale;

/**
 * AppLocale.
 * Utility for operations with locales.
 * @author Aydar_Safiullin
 */
public class AppLocale {
    /**
     * @return russian Locale.
     */
    public static Locale getRussianLocale() {
        Locale russianLocale = new Locale("ru", "Ru");
        return russianLocale;
    }
}
