package com.example.myshujuku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.myshujuku.squ.Squelte;
import com.example.myshujuku.student.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button tj;
    private Button sc;
    private Button xg;
    private Button cz;
    private DaoSession daoSession;
    private RecyclerView recy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        daoSession = Squelte.getSquelte().daoMaster();

        initView();
    }

    private void initView() {
        tj = (Button) findViewById(R.id.tj);
        sc = (Button) findViewById(R.id.sc);
        xg = (Button) findViewById(R.id.xg);
        cz = (Button) findViewById(R.id.cz);

        tj.setOnClickListener(this);
        sc.setOnClickListener(this);
        xg.setOnClickListener(this);
        cz.setOnClickListener(this);
        recy = (RecyclerView) findViewById(R.id.recy);
        recy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tj:
                User user = new User();
                user.setName("ss");
                user.setAge("100");

                daoSession.insert(user);
                break;
            case R.id.sc:

                daoSession.delete((long) 1);
                break;
            case R.id.xg:

                break;
            case R.id.cz:

                break;
        }
    }
}
