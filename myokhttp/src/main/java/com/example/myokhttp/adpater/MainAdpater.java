package com.example.myokhttp.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myokhttp.R;
import com.example.myokhttp.student.User;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Lenovo on 2018/3/13.
 */

public class MainAdpater extends RecyclerView.Adapter<MainAdpater.ViewHolder>{
    private List<User.ResultBean.DataBean> data;
    private Context mc;

    public MainAdpater(List<User.ResultBean.DataBean> data, Context mc) {
        this.data = data;
        this.mc = mc;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mc).inflate(R.layout.mainiem, parent,false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
     if (TextUtils.isEmpty(data.get(position).getThumbnail_pic_s02())&&TextUtils.isEmpty(data.get(position).getThumbnail_pic_s03())){
         Picasso.with(mc).load(data.get(position).getThumbnail_pic_s()).into(holder.img);
         holder.img1.setVisibility(View.GONE);
         holder.img2.setVisibility(View.GONE);

         holder.tv.setText(data.get(position).getTitle());
     }else {
         Picasso.with(mc).load(data.get(position).getThumbnail_pic_s()).into(holder.img);
         Picasso.with(mc).load(data.get(position).getThumbnail_pic_s02()).into(holder.img1);
         Picasso.with(mc).load(data.get(position).getThumbnail_pic_s03()).into(holder.img2);

         holder.tv.setText(data.get(position).getTitle());
     }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final ImageView img1;
        private final ImageView img2;
        private final TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            img1 = itemView.findViewById(R.id.img1);
            img2 = itemView.findViewById(R.id.img2);

            tv = itemView.findViewById(R.id.tv);
        }
    }
}
