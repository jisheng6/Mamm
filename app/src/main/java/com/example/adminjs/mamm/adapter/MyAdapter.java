package com.example.adminjs.mamm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.adminjs.mamm.R;
import com.example.adminjs.mamm.bean.Bean;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adminjs on 2017/12/6.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.IViewholder> {
    private Context context;
    private List<Bean.NewslistBean>list;

    public MyAdapter(Context context) {
        this.context = context;
    }
    public void addData(Bean bean){
        if(list == null){
            list = new ArrayList<>();
        }
        list.addAll(bean.getNewslist());
        notifyDataSetChanged();
    }

    @Override
    public IViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_layout, null);

        return new IViewholder(view);
    }

    @Override
    public void onBindViewHolder(IViewholder holder, int position) {
       holder.simpleDraweeView.setImageURI(list.get(position).getPicUrl());
       holder.textView.setText(list.get(position).getTitle());
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
        roundingParams.setRoundAsCircle(true);
        holder.simpleDraweeView.getHierarchy().setRoundingParams(roundingParams);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();

    }

    class IViewholder extends RecyclerView.ViewHolder{

         SimpleDraweeView simpleDraweeView;
        TextView textView;
        public IViewholder(View itemView) {
            super(itemView);
             simpleDraweeView = itemView.findViewById(R.id.simpledra);
            textView = itemView.findViewById(R.id.text);
        }
    }
}
