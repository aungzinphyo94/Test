package net.myanmarlinks.savethelibrary.sqlite;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by azphyo on 11/11/2017.
 */

@Entity
public class User {
    public @PrimaryKey
    String id;
    public String name;
    public String lastName;
    public int age;
}
