// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.auth;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.utils.Utility;

public class AuthInfo
{

    private String mAppKey;
    private String mKeyHash;
    private String mPackageName;
    private String mRedirectUrl;
    private String mScope;

    public AuthInfo(Context context, String s, String s1, String s2)
    {
        mAppKey = "";
        mRedirectUrl = "";
        mScope = "";
        mPackageName = "";
        mKeyHash = "";
        mAppKey = s;
        mRedirectUrl = s1;
        mScope = s2;
        mPackageName = context.getPackageName();
        mKeyHash = Utility.getSign(context, mPackageName);
    }

    public static AuthInfo parseBundleData(Context context, Bundle bundle)
    {
        return new AuthInfo(context, bundle.getString("appKey"), bundle.getString("redirectUri"), bundle.getString("scope"));
    }

    public String getAppKey()
    {
        return mAppKey;
    }

    public Bundle getAuthBundle()
    {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", mAppKey);
        bundle.putString("redirectUri", mRedirectUrl);
        bundle.putString("scope", mScope);
        bundle.putString("packagename", mPackageName);
        bundle.putString("key_hash", mKeyHash);
        return bundle;
    }

    public String getKeyHash()
    {
        return mKeyHash;
    }

    public String getPackageName()
    {
        return mPackageName;
    }

    public String getRedirectUrl()
    {
        return mRedirectUrl;
    }

    public String getScope()
    {
        return mScope;
    }
}
