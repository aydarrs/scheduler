package com.tat.development.skills.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * AppDateFormatterUtil.
 * Utility for operations with dates.
 * @author Aydar_Safiullin
 */
public class AppDateFormatterUtil {
    /**
     * Create needed date formats.
     * @param date - formatting date.
     * @return - formatted date.
     */
    public static String getFormattedDate(Date date) {
    SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE yyyy.MM.dd HH:mm", AppLocale.getRussianLocale());
    return dateFormatter.format(date);
    }
}
