package net.myanmarlinks.savethelibrary.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import net.myanmarlinks.savethelibrary.model.sqlite.Book;
import net.myanmarlinks.savethelibrary.model.sqlite.Loan;
import net.myanmarlinks.savethelibrary.model.sqlite.User;
import net.myanmarlinks.savethelibrary.model.sqlite.dao.BookDao;
import net.myanmarlinks.savethelibrary.model.sqlite.dao.LoanDao;
import net.myanmarlinks.savethelibrary.model.sqlite.dao.UserDao;

/**
 * Created by soethihanaung on 11/11/17.
 */

@Database(entities = {User.class, Book.class, Loan.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "MyDatabase";

    private static AppDatabase INSTANCE;
    private static AppDatabase SECOND_INSTANCE;

    public abstract UserDao userModel();
    public abstract BookDao bookModel();
    public abstract LoanDao loanModel();

    public static AppDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                            // To simplify the codelab, allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static AppDatabase getDatabase(Context context) {
        if(SECOND_INSTANCE == null) {
            SECOND_INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return SECOND_INSTANCE;
    }

    public static void destroyInstanceOne() {
        INSTANCE = null;
    }

    public static void destoryInstanceTwo() {
        SECOND_INSTANCE = null;
    }



}
