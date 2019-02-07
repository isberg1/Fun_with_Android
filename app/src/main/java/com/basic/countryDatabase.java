package com.basic;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Country.class}, version = 1/*, exportSchema = false*/)
public abstract class countryDatabase extends RoomDatabase {
    public abstract countryDao daoAccess();
}