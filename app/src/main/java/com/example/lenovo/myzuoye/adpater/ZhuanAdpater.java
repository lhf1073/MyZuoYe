package com.example.lenovo.myzuoye.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.myzuoye.R;
import com.example.lenovo.myzuoye.student.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2018/3/11.
 */

public class ZhuanAdpater extends RecyclerView.Adapter<ZhuanAdpater.ViewHolder>{
    private List<User.ResultBean.DataBean> data;
    private Context mc;

    public ZhuanAdpater(List<User.ResultBean.DataBean> data, Context mc) {
        this.data = data;
        this.mc = mc;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mc).inflate(R.layout.zhuanti, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
     holder.t.setText(data.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView t;

        public ViewHolder(View itemView) {
            super(itemView);
            t = itemView.findViewById(R.id.t);
        }
    }
}
