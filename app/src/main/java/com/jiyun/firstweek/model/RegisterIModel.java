package com.jiyun.firstweek.model;

import com.jiyun.firstweek.callback.LoginCallback;

/**
 * Created by mengYao on 2017/10/24.
 */

public interface RegisterIModel {
    void register(String user, String pass, LoginCallback callback);
}
