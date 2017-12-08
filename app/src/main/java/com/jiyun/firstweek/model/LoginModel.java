package com.jiyun.firstweek.model;

import com.jiyun.firstweek.callback.LoginCallback;

/**
 * Created by mengYao on 2017/10/24.
 */

public class LoginModel implements LoginIModel {
    @Override
    public void login(String user, String pass, LoginCallback callback) {
        if (user.length()==11&&pass.length()>=6&&pass.length()<=10){
            callback.onSuccess("登陆成功");
        }else{
            callback.onFailure("登陆失败");
        }
    }
}
