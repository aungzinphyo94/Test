package net.myanmarlinks.savethelibrary.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import net.myanmarlinks.savethelibrary.R;
import net.myanmarlinks.savethelibrary.db.AppDatabase;
import net.myanmarlinks.savethelibrary.db.util.DatabaseInitializer;
import net.myanmarlinks.savethelibrary.model.sqlite.Book;
import net.myanmarlinks.savethelibrary.model.sqlite.User;

import java.util.List;

public class RoomActivity extends AppCompatActivity {

    private AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDb = AppDatabase.getDatabase(getApplicationContext());

        populateDb();

        fetchData();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppDatabase.destroyInstanceOne();
    }

    public void populateDb() {
        DatabaseInitializer.populateSync(mDb);
    }

    public void fetchData() {
        List<User> youngUsers = mDb.userModel().loadAllUsers();
        List<Book> books = mDb.bookModel().findAllBooks();
        Log.d("USER", youngUsers.toString());
        Log.d("BOOKS", books.toString());
        Toast.makeText(getApplicationContext(), youngUsers.toString(), Toast.LENGTH_SHORT).show();
    }

}
