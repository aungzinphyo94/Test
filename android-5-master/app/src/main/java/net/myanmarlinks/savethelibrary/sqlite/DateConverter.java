package net.myanmarlinks.savethelibrary.sqlite;

import android.arch.persistence.room.TypeConverter;

import java.sql.Date;

/**
 * Created by azphyo on 11/11/2017.
 */

public class DateConverter {
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
