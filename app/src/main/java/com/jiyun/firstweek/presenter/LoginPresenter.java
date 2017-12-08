package com.jiyun.firstweek.presenter;

import com.jiyun.firstweek.callback.LoginCallback;
import com.jiyun.firstweek.model.LoginIModel;
import com.jiyun.firstweek.model.LoginModel;
import com.jiyun.firstweek.view.LoginIView;

/**
 * Created by mengYao on 2017/10/24.
 */

public class LoginPresenter {
    private LoginIModel loginIModel;
    private LoginIView loginIView;

    public LoginPresenter(LoginIView loginIView) {
        this.loginIView = loginIView;
        loginIModel=new LoginModel();
    }
    public void login(String user,String pass){
        loginIModel.login(user, pass, new LoginCallback() {
            @Override
            public void onSuccess(String success) {
                loginIView.onSuccess(success);
            }

            @Override
            public void onFailure(String failure) {
                loginIView.onFailure(failure);
            }
        });
    }
}
