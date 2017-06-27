package com.del.delkit.comm.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.del.delkit.R;

/**
 * Created by ${dmz} on 2017/6/26.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    private String[] datas;
    private LayoutInflater inflater;

    private OnRecyclerClickListener onRecyclerClickListener;

    public RecycleAdapter(Context contexts, String[] datas, OnRecyclerClickListener onRecyclerClickListener) {
        this.datas = datas;
        this.onRecyclerClickListener = onRecyclerClickListener;
        inflater = LayoutInflater.from(contexts);
    }


    /**
     * 创建新View，被LayoutManager所调用
     * 返回一个自定义的ViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.main_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    /**
     * 填充onCreateViewHolder方法返回的holder中的控件
     * 将数据与界面进行绑定的操作
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv.setText(datas[position]);
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecyclerClickListener.onItemClick(position);
            }
        });
        holder.tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onRecyclerClickListener.onItemLongClick(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }

    /**
     * recyclerView的item按键回调
     */
    public interface OnRecyclerClickListener {

        void onItemClick(int postion);

        void onItemLongClick(int postion);
    }

}
