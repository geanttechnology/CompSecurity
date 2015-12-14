// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.net.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;

public class ShareWeiboApi
{

    private static final String REPOST_URL = "https://api.weibo.com/2/statuses/repost.json";
    private static final String TAG = com/sina/weibo/sdk/net/openapi/ShareWeiboApi.getName();
    private static final String UPDATE_URL = "https://api.weibo.com/2/statuses/update.json";
    private static final String UPLOAD_URL = "https://api.weibo.com/2/statuses/upload.json";
    private String mAccessToken;
    private String mAppKey;
    private Context mContext;

    private ShareWeiboApi(Context context, String s, String s1)
    {
        mContext = context.getApplicationContext();
        mAppKey = s;
        mAccessToken = s1;
    }

    private WeiboParameters buildUpdateParams(String s, String s1, String s2)
    {
        WeiboParameters weiboparameters = new WeiboParameters(mAppKey);
        weiboparameters.put("status", s);
        if (!TextUtils.isEmpty(s2))
        {
            weiboparameters.put("long", s2);
        }
        if (!TextUtils.isEmpty(s1))
        {
            weiboparameters.put("lat", s1);
        }
        if (!TextUtils.isEmpty(mAppKey))
        {
            weiboparameters.put("source", mAppKey);
        }
        return weiboparameters;
    }

    public static ShareWeiboApi create(Context context, String s, String s1)
    {
        return new ShareWeiboApi(context, s, s1);
    }

    private void requestAsync(String s, WeiboParameters weiboparameters, String s1, RequestListener requestlistener)
    {
        if (TextUtils.isEmpty(mAccessToken) || TextUtils.isEmpty(s) || weiboparameters == null || TextUtils.isEmpty(s1) || requestlistener == null)
        {
            LogUtil.e(TAG, "Argument error!");
            return;
        } else
        {
            weiboparameters.put("access_token", mAccessToken);
            (new AsyncWeiboRunner(mContext)).requestAsync(s, weiboparameters, s1, requestlistener);
            return;
        }
    }

    public void repost(String s, String s1, int i, RequestListener requestlistener)
    {
        s1 = buildUpdateParams(s1, null, null);
        s1.put("id", s);
        s1.put("is_comment", String.valueOf(i));
        requestAsync("https://api.weibo.com/2/statuses/repost.json", s1, "POST", requestlistener);
    }

    public void update(String s, String s1, String s2, RequestListener requestlistener)
    {
        requestAsync("https://api.weibo.com/2/statuses/update.json", buildUpdateParams(s, s1, s2), "POST", requestlistener);
    }

    public void upload(String s, Bitmap bitmap, String s1, String s2, RequestListener requestlistener)
    {
        s = buildUpdateParams(s, s1, s2);
        s.put("pic", bitmap);
        requestAsync("https://api.weibo.com/2/statuses/upload.json", s, "POST", requestlistener);
    }

}
