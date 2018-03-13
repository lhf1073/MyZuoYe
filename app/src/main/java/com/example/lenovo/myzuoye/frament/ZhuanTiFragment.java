package com.example.lenovo.myzuoye.frament;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.example.lenovo.myzuoye.R;
import com.example.lenovo.myzuoye.adpater.ZhuanAdpater;
import com.example.lenovo.myzuoye.student.User;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhuanTiFragment extends Fragment {


    private RecyclerView recy;
    private TableLayout tab;
    private RecyclerView recy1;
    private RecyclerView lv;
    private ArrayList<String> list;
    private String a="http://172.16.54.20:8080/qinzi.txt";
    private List<User.ResultBean.DataBean> data;
    private Handler handler=new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String json = (String) msg.obj;
            Gson gson = new Gson();
            User user = gson.fromJson(json, User.class);
            data = user.getResult().getData();

            ZhuanAdpater zhuanAdpater = new ZhuanAdpater(data,getActivity());
            lv.setAdapter(zhuanAdpater);
            LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
            lv.setLayoutManager(manager);
        }
    };

    public ZhuanTiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_zhuan_ti, container, false);
        initView(inflate);
        initData();
        return inflate;
    }



    private void initData() {


      new Thread(new Runnable() {
          @Override
          public void run() {
              OkHttpClient okHttpClient = new OkHttpClient();
              Request build = new Request.Builder().url(a).build();
              Call call = okHttpClient.newCall(build);
              try {
                  Response execute = call.execute();
                  String string = execute.body().string();
                  Message message = new Message();
                  message.obj=string;

                  handler.sendMessage(message);
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }).start();
    }

    private void initView(View inflate) {

        recy = (RecyclerView) inflate.findViewById(R.id.recy);
        tab = (TableLayout) inflate.findViewById(R.id.tab);
        recy1 = (RecyclerView) inflate.findViewById(R.id.recy1);
        lv = (RecyclerView) inflate.findViewById(R.id.lv);
    }
}
