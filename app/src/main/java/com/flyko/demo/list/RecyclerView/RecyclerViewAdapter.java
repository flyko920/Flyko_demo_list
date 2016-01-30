package com.flyko.demo.list.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.flyko.demo.list.R;

import java.util.List;

/**
 * 项目名称:My Application
 *
 * 包名:com.flyou.henucenter.myapplication.adpater
 * 作者: flyou
 * 创建时间:15/8/19 11:42
 * 描述:
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<String> mDatas;
    private Context mContex;
    private LayoutInflater mInFlater;
//设置item的回调
    public interface OnItemClickListener {
        void onItemClick(View view, int Position);

        void onItemLongClick(View view, int Position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {

        this.onItemClickListener = listener;
    }

    public RecyclerViewAdapter(List<String> datas, Context Contex) {
        this.mContex = Contex;
        this.mDatas = datas;
        mInFlater = LayoutInflater.from(mContex);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInFlater.inflate(R.layout.item_view, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    public void add(int pos) {
        mDatas.add(pos, "I am new item ");
        notifyItemInserted(pos);

    }

    public void delete(int pos) {

        mDatas.remove(pos);
        notifyItemRemoved(pos);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.textView.setText(mDatas.get(position));
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.itemView,layoutPosition);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();//增加或删除item使用这个方法获得其position  
                    onItemClickListener.onItemLongClick(holder.itemView,layoutPosition);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public MyViewHolder(View itemView) {

        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.textInfo);
    }


} 