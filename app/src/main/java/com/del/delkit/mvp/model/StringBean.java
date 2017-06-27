package com.del.delkit.mvp.model;

/**
 * Created by ${dmz} on 2017/6/26.
 */

public interface StringBean {

    /**
     * 网络请求
     *
     * @param url        请求的url
     * @param onBackCall 数据的回调
     */
    void getData(String url, OnBackCall onBackCall);

    /**
     * 网络请求的回调
     */
    interface OnBackCall {
        /**
         * 成功之后的回调
         *
         * @param content
         */
        void onSuccess(String content);

        /**
         * 失败之后的回调
         *
         * @param error
         */
        void onFail(String error);
    }


}
