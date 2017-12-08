package com.jiyun.firstweek.callback;

/**
 * Created by mengYao on 2017/10/24.
 */

public interface LoginCallback {
    void onSuccess(String success);
    void onFailure(String failure);
}
