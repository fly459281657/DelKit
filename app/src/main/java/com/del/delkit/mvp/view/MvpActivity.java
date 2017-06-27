package com.del.delkit.mvp.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.del.delkit.R;
import com.del.delkit.mvp.presenter.StringPresenter;

/**
 * mvp模式
 * <p>
 * Created by ${dmz} on 2017/6/26.
 */

public class MvpActivity extends AppCompatActivity implements StringView {

    private TextView tv;

    private StringPresenter stringPresenter;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvp_activity);

        tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringPresenter.load();
            }
        });

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在加载数据,请稍等...");

        stringPresenter = new StringPresenter("", this);

    }


    @Override
    public void showDialog() {
        progressDialog.show();
    }

    @Override
    public void hideDialog() {
        progressDialog.dismiss();
    }

    @Override
    public void setContent(String content) {
        tv.setText(content);
    }
}
