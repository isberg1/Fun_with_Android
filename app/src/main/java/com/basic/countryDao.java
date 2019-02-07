package com.basic;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface countryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Country... countries);

    @Update (onConflict = OnConflictStrategy.REPLACE)
    public void update(Country... countries);

    @Delete
    public void delete(Country country);

    @Query("SELECT * FROM countries")
    public List<Country> getCountries();

    @Query(value = "SELECT * FROM countries WHERE userid = :id")
    public Country getCountryById(int id);

    @Query("DELETE FROM countries")
    public void dropTable();

}