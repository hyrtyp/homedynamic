package com.hyrt.cnp.homedynamic.tests.ui;

import android.test.ActivityInstrumentationTestCase2;

import com.hyrt.cnp.homedynamic.ui.UserLoginActivity;

/**
 * Created by GYH on 13-12-27.
 */
public class UserLoginActivityTest extends ActivityInstrumentationTestCase2<UserLoginActivity>{

    private UserLoginActivity userLoginActivity;
    public UserLoginActivityTest() {
        super(UserLoginActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        userLoginActivity=getActivity();
    }

    public void testActivity(){
        assertNotNull("userloginactivity is null",userLoginActivity);
    }

    public void testJsonData(){
//        userLoginActivity.getSpiceManager().execute();
    }

}
