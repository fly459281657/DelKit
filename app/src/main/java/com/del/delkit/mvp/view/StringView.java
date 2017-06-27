package com.del.delkit.mvp.view;

/**
 * view接口，需要activity实现，被presenter引用，用来更新界面
 * Created by ${dmz} on 2017/6/26.
 */

public interface StringView {

    /**
     * 显示等待窗口
     */
    void showDialog();

    /**
     * 隐藏等待窗口
     */
    void hideDialog();

    /**
     * 更新界面显示
     *
     * @param content 显示的内容
     */
    void setContent(String content);


}
