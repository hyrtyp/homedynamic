package com.hyrt.cnp.homedynamic.ui;

import android.os.Bundle;
import android.widget.Toast;

import com.hyrt.cnp.homedynamic.api.BaseActivity;
import com.hyrt.cnp.homedynamic.model.Usermodel;
import com.hyrt.cnp.homedynamic.request.UserLoginRequest;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

/**
 * Created by GYH on 13-12-27.
 */
public class UserLoginActivity extends BaseActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loaduserLogin();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public void loaduserLogin() {
        setProgressBarIndeterminateVisibility(true);
        getSpiceManager().execute(new UserLoginRequest("android"), "github", DurationInMillis.ONE_SECOND * 10,
                new UserloginListener());
    }

    public class UserloginListener implements RequestListener<Usermodel.Model> {

        @Override
        public void onRequestFailure(SpiceException spiceException) {
            setProgressBarIndeterminateVisibility(false);
            Toast.makeText(UserLoginActivity.this, "失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRequestSuccess(Usermodel.Model result) {
            setProgressBarIndeterminateVisibility(false);
            Toast.makeText(UserLoginActivity.this,"username="+result.getData().getUsername(),Toast.LENGTH_SHORT).show();
        }
    }
}
