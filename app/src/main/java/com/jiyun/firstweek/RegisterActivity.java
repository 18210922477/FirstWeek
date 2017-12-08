package com.jiyun.firstweek;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jiyun.firstweek.presenter.RegisterPresenter;
import com.jiyun.firstweek.view.LoginIView;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,LoginIView {

    private EditText mEditUser;
    private EditText mEditPass;
    private Button mRegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

    }

    private void initView() {
        mEditUser = (EditText) findViewById(R.id.mEditUser);
        mEditPass = (EditText) findViewById(R.id.mEditPass);
        mRegisterButton = (Button) findViewById(R.id.mRegisterButton);

        mRegisterButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mRegisterButton:
                RegisterPresenter registerPresenter = new RegisterPresenter(this);
                registerPresenter.register(mEditUser.getText().toString().trim(),mEditPass.getText().toString().trim());
                break;
        }
    }

    @Override
    public void onSuccess(String success) {
        Toast.makeText(this, success, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        intent.putExtra("user",mEditUser.getText().toString().trim());
        intent.putExtra("pass",mEditPass.getText().toString().trim());
        setResult(2,intent);
        finish();
    }

    @Override
    public void onFailure(String failure) {
        Toast.makeText(this, failure, Toast.LENGTH_SHORT).show();
    }
}
