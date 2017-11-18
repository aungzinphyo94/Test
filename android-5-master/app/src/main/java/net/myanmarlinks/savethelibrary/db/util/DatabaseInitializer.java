package net.myanmarlinks.savethelibrary.db.util;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import net.myanmarlinks.savethelibrary.db.AppDatabase;
import net.myanmarlinks.savethelibrary.model.sqlite.Book;
import net.myanmarlinks.savethelibrary.model.sqlite.Loan;
import net.myanmarlinks.savethelibrary.model.sqlite.User;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by soethihanaung on 11/11/17.
 */

public class DatabaseInitializer {

    private static final int DELAY_MILLIS = 500;

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    public static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            populateWithTestData(mDb);
            return null;
        }
    }

    private static void addLoan(final AppDatabase db, final String id,
                                final int user, final int book, Date from, Date to) {
        Loan loan = new Loan();
        loan.userId = user;
        loan.bookId = book;
        loan.startTime = from;
        loan.endTime = to;
        db.loanModel().insertLoan(loan);
    }

    private static int addBook(final AppDatabase db, final String title) {
        Book book = new Book();

        book.title = title;
        long book_id = db.bookModel().insertBook(book);
        return (int) book_id;
    }

    private static int addUser(final AppDatabase db, final String name,
                                final String lastName, final int age) {
        User user = new User();
        user.age = age;
        user.name = name;
        user.lastName = lastName;
        long foo = db.userModel().insertUser(user);
        return (int) foo;
    }

    private static void populateWithTestData(AppDatabase db) {
        db.loanModel().deleteAll();
        db.userModel().deleteAll();
        db.bookModel().deleteAll();

        int user1 = addUser(db, "Jason", "Seaver", 40);
        int user2 = addUser(db,  "Mike", "Seaver", 12);
        addUser(db,  "Carol", "Seaver", 15);

        int book1 = addBook(db, "Dune");
        int book2 = addBook(db, "1984");
        int book3 = addBook(db,"The War of the Worlds");
        int book4 = addBook(db, "Brave New World");
        addBook(db, "Foundation");
        try {
            // Loans are added with a delay, to have time for the UI to react to changes.

            Date today = getTodayPlusDays(0);
            Date yesterday = getTodayPlusDays(-1);
            Date twoDaysAgo = getTodayPlusDays(-2);
            Date lastWeek = getTodayPlusDays(-7);
            Date twoWeeksAgo = getTodayPlusDays(-14);

            addLoan(db, UUID.randomUUID().toString(), user1, book1, twoWeeksAgo, lastWeek);
            Thread.sleep(DELAY_MILLIS);
            addLoan(db, UUID.randomUUID().toString(),user2, book1, lastWeek, yesterday);
            Thread.sleep(DELAY_MILLIS);
            addLoan(db,UUID.randomUUID().toString(), user2, book2, lastWeek, today);
            Thread.sleep(DELAY_MILLIS);
            addLoan(db, UUID.randomUUID().toString(), user2, book3, lastWeek, twoDaysAgo);
            Thread.sleep(DELAY_MILLIS);
            addLoan(db, UUID.randomUUID().toString(), user2, book4, lastWeek, today);
            Log.d("DB", "Added loans");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Date getTodayPlusDays(int daysAgo) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, daysAgo);
        return calendar.getTime();
    }
}
