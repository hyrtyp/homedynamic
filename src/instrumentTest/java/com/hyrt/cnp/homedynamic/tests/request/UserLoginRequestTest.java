package com.hyrt.cnp.homedynamic.tests.request;

import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import com.hyrt.cnp.homedynamic.request.UserLoginRequest;

/**
 * Created by GYH on 13-12-27.
 */
public class UserLoginRequestTest extends InstrumentationTestCase {

    private UserLoginRequest userLoginRequest;

    @Override
    protected void setUp() throws Exception {
        userLoginRequest=new UserLoginRequest("android");
        super.setUp();
    }

    @MediumTest
    private void shouldHaveUrl(){
        assertEquals(userLoginRequest.getUrl(),"http://api.chinaxueqian.com/account/login/?username=360828213@qq.com&password=123456");
    }
}
