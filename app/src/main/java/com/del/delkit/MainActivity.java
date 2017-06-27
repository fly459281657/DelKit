package com.del.delkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.del.delkit.comm.recycleview.DividerItemDecorateion;
import com.del.delkit.comm.recycleview.RecycleAdapter;
import com.del.delkit.mvp.view.MvpActivity;

public class MainActivity extends AppCompatActivity implements RecycleAdapter.OnRecyclerClickListener {

    private RecyclerView recyclerView;
    private RecycleAdapter adapter;
    private String[] datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        datas = this.getResources().getStringArray(R.array.main_menu);
        adapter = new RecycleAdapter(this, datas, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);//如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        recyclerView.addItemDecoration(new DividerItemDecorateion(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
    }


    @Override
    public void onItemClick(int position) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(this, MvpActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }

    @Override
    public void onItemLongClick(int position) {
        showToast("长按了" + datas[position]);
    }

    private void showToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

}
