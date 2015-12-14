// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.net.openapi;

import android.content.Context;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;

public class RefreshTokenApi
{

    private static final String REFRESH_TOKEN_URL = "https://api.weibo.com/oauth2/access_token";
    private Context mContext;

    private RefreshTokenApi(Context context)
    {
        mContext = context.getApplicationContext();
    }

    public static RefreshTokenApi create(Context context)
    {
        return new RefreshTokenApi(context);
    }

    public void refreshToken(String s, String s1, RequestListener requestlistener)
    {
        WeiboParameters weiboparameters = new WeiboParameters(s);
        weiboparameters.put("client_id", s);
        weiboparameters.put("grant_type", "refresh_token");
        weiboparameters.put("refresh_token", s1);
        (new AsyncWeiboRunner(mContext)).requestAsync("https://api.weibo.com/oauth2/access_token", weiboparameters, "POST", requestlistener);
    }
}
