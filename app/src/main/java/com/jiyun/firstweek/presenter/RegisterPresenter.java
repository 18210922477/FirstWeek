package com.jiyun.firstweek.presenter;

import com.jiyun.firstweek.callback.LoginCallback;
import com.jiyun.firstweek.model.RegisterIModel;
import com.jiyun.firstweek.model.RegisterModelImpl;
import com.jiyun.firstweek.view.LoginIView;

/**
 * Created by mengYao on 2017/10/24.
 */

public class RegisterPresenter {
    private RegisterIModel registerIModel;
    private LoginIView loginIView;

    public RegisterPresenter(LoginIView loginIView) {
        this.loginIView = loginIView;
        registerIModel=new RegisterModelImpl();
    }
    public void register(String user,String pass){
        registerIModel.register(user, pass, new LoginCallback() {
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
