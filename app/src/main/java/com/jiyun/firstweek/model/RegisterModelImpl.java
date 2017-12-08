package com.jiyun.firstweek.model;

import com.jiyun.firstweek.callback.LoginCallback;

/**
 * Created by mengYao on 2017/10/24.
 */

public class RegisterModelImpl implements RegisterIModel {
    @Override
    public void register(String user, String pass, LoginCallback callback) {
        if (user.length()==11&&pass.length()>=6&&pass.length()<=10){
            callback.onSuccess("注册成功");
        }else{
            callback.onFailure("注册失败");
        }
    }
}
