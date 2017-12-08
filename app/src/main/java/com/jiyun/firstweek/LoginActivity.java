package com.jiyun.firstweek;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jiyun.firstweek.presenter.LoginPresenter;
import com.jiyun.firstweek.view.LoginIView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,LoginIView {

    private EditText mEditUsername;
    private EditText mEditPassword;
    private Button mBtnLogin;
    private Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mEditUsername = (EditText) findViewById(R.id.mEditUsername);
        mEditPassword = (EditText) findViewById(R.id.mEditPassword);
        mBtnLogin = (Button) findViewById(R.id.mBtnLogin);
        mBtnRegister = (Button) findViewById(R.id.mBtnRegister);

        mBtnLogin.setOnClickListener(this);
        mBtnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mBtnLogin:
                LoginPresenter loginPresenter = new LoginPresenter(this);
                loginPresenter.login(mEditUsername.getText().toString().trim(),mEditPassword.getText().toString().trim());
                break;
            case R.id.mBtnRegister:
                startActivityForResult(new Intent(LoginActivity.this,RegisterActivity.class),1);
                break;
        }
    }

    @Override
    public void onSuccess(String success) {
        Toast.makeText(this, success, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
    }

    @Override
    public void onFailure(String failure) {
        Toast.makeText(this, failure, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&&resultCode==2&&data!=null){
            mEditUsername.setText(data.getStringExtra("user"));
            mEditPassword.setText(data.getStringExtra("pass"));
        }
    }
}
