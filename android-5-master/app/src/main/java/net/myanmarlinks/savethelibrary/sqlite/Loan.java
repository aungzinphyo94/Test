package net.myanmarlinks.savethelibrary.sqlite;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

/**
 * Created by azphyo on 11/11/2017.
 */

@Entity(foreignKeys = {
        @ForeignKey(entity = Book.class,
                parentColumns = "id",
                childColumns = "book_id"),

        @ForeignKey(entity = User.class,
                parentColumns = "id",
                childColumns = "user_id")})
@TypeConverters(DateConverter.class)
public class Loan {
    // Fields can be public or private with getters and setters.
    public @PrimaryKey
    String id;
    public Date startTime;
    public Date endTime;
    @ColumnInfo(name="book_id")
    public String bookId;
    @ColumnInfo(name="user_id")
    public String userId;
}
