package com.basic;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import java.util.concurrent.ExecutionException;

public class MyAsyncHelperClass {

    private countryDatabase db;
    private String name;

    public MyAsyncHelperClass(Context context, String name) {
        this.name = name;
        this.db = Room.databaseBuilder(context, countryDatabase.class, name).build();
    }


    public void insert(Country... countries){
        new  AsyncTask<Country,Void,Void>(){
            @Override
            protected Void doInBackground(Country... countries) {
                db.daoAccess().insert(countries);
                return null;
            }
        }.execute(countries);
    }

    public Country get1ByID(final int id){
        Country temp = null;

        try {
            temp = new AsyncTask<Integer,Void, Country>(){
                @Override
                protected Country doInBackground(Integer... integers) {
                    return db.daoAccess().getCountryById(id);
                }
            }.execute(id).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return temp;
    }

    public void dropTable() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                db.daoAccess().dropTable();
                return null;
            }
        }.execute();
    }


}
