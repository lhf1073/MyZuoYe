package com.example.myshujuku.squ;

import android.app.Application;

import com.example.myshujuku.DaoMaster;
import com.example.myshujuku.DaoSession;

/**
 * Created by Lenovo on 2018/3/13.
 */

public class Squelte extends Application{

    private static Squelte squelte;
    private DaoSession daoSession;

    public static Squelte getSquelte() {
        return squelte;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        squelte=this;
        shujuku();
    }

    private void shujuku() {
        DaoMaster.DevOpenHelper ku = new DaoMaster.DevOpenHelper(this,"ku");
        DaoMaster daoMaster = new DaoMaster(ku.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }
    public DaoSession daoMaster(){

        return daoSession;
    }
}
