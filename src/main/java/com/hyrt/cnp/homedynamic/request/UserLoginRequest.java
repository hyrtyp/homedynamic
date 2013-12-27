package com.hyrt.cnp.homedynamic.request;

import com.hyrt.cnp.homedynamic.model.Usermodel;
import com.octo.android.robospice.request.springandroid.SpringAndroidSpiceRequest;

/**
 * Created by GYH on 13-12-27.
 */
public class UserLoginRequest extends SpringAndroidSpiceRequest<Usermodel.Model> {

    private String keyword;

    public UserLoginRequest(String keyword) {
        super(Usermodel.Model.class);
        this.keyword = keyword;
    }

    @Override
    public Usermodel.Model loadDataFromNetwork() throws Exception {
        String url = getUrl();
        return getRestTemplate().getForObject(url, Usermodel.Model.class);
    }

    public String getUrl(){
        String url = "http://api.chinaxueqian.com/account/login/?username=360828213@qq.com&password=123456";
        return url;
    }
}
