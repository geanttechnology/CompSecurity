// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.auth;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Oauth2AccessToken
{

    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_EXPIRES_IN = "expires_in";
    public static final String KEY_PHONE_NUM = "phone_num";
    public static final String KEY_REFRESH_TOKEN = "refresh_token";
    public static final String KEY_UID = "uid";
    private String mAccessToken;
    private long mExpiresTime;
    private String mPhoneNum;
    private String mRefreshToken;
    private String mUid;

    public Oauth2AccessToken()
    {
        mUid = "";
        mAccessToken = "";
        mRefreshToken = "";
        mExpiresTime = 0L;
        mPhoneNum = "";
    }

    public Oauth2AccessToken(String s)
    {
        mUid = "";
        mAccessToken = "";
        mRefreshToken = "";
        mExpiresTime = 0L;
        mPhoneNum = "";
        if (s == null || s.indexOf("{") < 0)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        s = new JSONObject(s);
        setUid(s.optString("uid"));
        setToken(s.optString("access_token"));
        setExpiresIn(s.optString("expires_in"));
        setRefreshToken(s.optString("refresh_token"));
        setPhoneNum(s.optString("phone_num"));
        return;
        s;
        s.printStackTrace();
        return;
    }

    public Oauth2AccessToken(String s, String s1)
    {
        mUid = "";
        mAccessToken = "";
        mRefreshToken = "";
        mExpiresTime = 0L;
        mPhoneNum = "";
        mAccessToken = s;
        mExpiresTime = System.currentTimeMillis();
        if (s1 != null)
        {
            mExpiresTime = mExpiresTime + Long.parseLong(s1) * 1000L;
        }
    }

    private static String getString(Bundle bundle, String s, String s1)
    {
        Object obj = s1;
        if (bundle != null)
        {
            bundle = bundle.getString(s);
            obj = s1;
            if (bundle != null)
            {
                obj = bundle;
            }
        }
        return ((String) (obj));
    }

    public static Oauth2AccessToken parseAccessToken(Bundle bundle)
    {
        if (bundle != null)
        {
            Oauth2AccessToken oauth2accesstoken = new Oauth2AccessToken();
            oauth2accesstoken.setUid(getString(bundle, "uid", ""));
            oauth2accesstoken.setToken(getString(bundle, "access_token", ""));
            oauth2accesstoken.setExpiresIn(getString(bundle, "expires_in", ""));
            oauth2accesstoken.setRefreshToken(getString(bundle, "refresh_token", ""));
            oauth2accesstoken.setPhoneNum(getString(bundle, "phone_num", ""));
            return oauth2accesstoken;
        } else
        {
            return null;
        }
    }

    public static Oauth2AccessToken parseAccessToken(String s)
    {
        if (TextUtils.isEmpty(s) || s.indexOf("{") < 0)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        Oauth2AccessToken oauth2accesstoken;
        s = new JSONObject(s);
        oauth2accesstoken = new Oauth2AccessToken();
        oauth2accesstoken.setUid(s.optString("uid"));
        oauth2accesstoken.setToken(s.optString("access_token"));
        oauth2accesstoken.setExpiresIn(s.optString("expires_in"));
        oauth2accesstoken.setRefreshToken(s.optString("refresh_token"));
        oauth2accesstoken.setPhoneNum(s.optString("phone_num"));
        return oauth2accesstoken;
        s;
        s.printStackTrace();
        return null;
    }

    private void setPhoneNum(String s)
    {
        mPhoneNum = s;
    }

    public long getExpiresTime()
    {
        return mExpiresTime;
    }

    public String getPhoneNum()
    {
        return mPhoneNum;
    }

    public String getRefreshToken()
    {
        return mRefreshToken;
    }

    public String getToken()
    {
        return mAccessToken;
    }

    public String getUid()
    {
        return mUid;
    }

    public boolean isSessionValid()
    {
        return !TextUtils.isEmpty(mAccessToken);
    }

    public void setExpiresIn(String s)
    {
        if (!TextUtils.isEmpty(s) && !s.equals("0"))
        {
            setExpiresTime(System.currentTimeMillis() + Long.parseLong(s) * 1000L);
        }
    }

    public void setExpiresTime(long l)
    {
        mExpiresTime = l;
    }

    public void setRefreshToken(String s)
    {
        mRefreshToken = s;
    }

    public void setToken(String s)
    {
        mAccessToken = s;
    }

    public void setUid(String s)
    {
        mUid = s;
    }

    public Bundle toBundle()
    {
        Bundle bundle = new Bundle();
        bundle.putString("uid", mUid);
        bundle.putString("access_token", mAccessToken);
        bundle.putString("refresh_token", mRefreshToken);
        bundle.putString("expires_in", Long.toString(mExpiresTime));
        bundle.putString("phone_num", mPhoneNum);
        return bundle;
    }

    public String toString()
    {
        return (new StringBuilder("uid: ")).append(mUid).append(", ").append("access_token").append(": ").append(mAccessToken).append(", ").append("refresh_token").append(": ").append(mRefreshToken).append(", ").append("phone_num").append(": ").append(mPhoneNum).append(", ").append("expires_in").append(": ").append(Long.toString(mExpiresTime)).toString();
    }
}
