package com.del.delkit.mvp.presenter;

import com.del.delkit.mvp.model.StringBean;
import com.del.delkit.mvp.model.StringBeanImpl;
import com.del.delkit.mvp.view.StringView;

/**
 * presenter--主要的控制类，引用view与model
 * <p>
 * 通过view来接收activity的事件，触发对应的处理逻辑
 * <p>
 * 通过model去获取数据
 * <p>
 * 通过OnBackCall回调数据
 * <p>
 * 最后由view回调界面更新
 * <p>
 * Created by ${dmz} on 2017/6/26.
 */

public class StringPresenter implements StringBean.OnBackCall {

    private StringView stringView;//对view的引用

    private StringBean bean;//对model的引用

    private String url;//请求的链接


    public StringPresenter(String url, StringView view) {
        this.url = url;
        this.stringView = view;
        bean = new StringBeanImpl();
    }

    /**
     * 请求数据
     */
    public void load() {
        stringView.showDialog();
        bean.getData(url, this);
    }

    @Override
    public void onSuccess(String content) {
        stringView.hideDialog();
        stringView.setContent(content);
    }

    @Override
    public void onFail(String error) {
        stringView.hideDialog();
        //获取数据失败回调处理事件

    }
}
