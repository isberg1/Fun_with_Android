package com.basic;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "countries")
public class Country  {

    @PrimaryKey
    @ColumnInfo(name = "userid")
    private int mId;

    @ColumnInfo(name = "name")
    private String mName;

    @ColumnInfo(name = "capital")
    private String mCapital;

    @ColumnInfo(name = "yearVisited")
    private int mYearVisited;

    public Country(int mId, String mName, String mCapital, int mYearVisited) {
        this.mId = mId;
        this.mName = mName;
        this.mCapital = mCapital;
        this.mYearVisited = mYearVisited;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getCapital() {
        return mCapital;
    }

    public void setCapital(String mCapital) {
        this.mCapital = mCapital;
    }

    public int getYearVisited() {
        return mYearVisited;
    }

    public void setYearVisited(int mYearVisited) {
        this.mYearVisited = mYearVisited;
    }

    @Override
    public String toString() {
        return "Country{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mCapital='" + mCapital + '\'' +
                ", mYearVisited=" + mYearVisited +
                '}';
    }
}
