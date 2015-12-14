// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component.view;

import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WeiboAuthListener;

public class 
{

    private String mAccessToken;
    private String mAppKey;
    private String mAttentionScreenName;
    private String mAttentionUid;
    private WeiboAuthListener mAuthlistener;

    public static  createRequestParam(String s, String s1, String s2, WeiboAuthListener weiboauthlistener)
    {
          = new <init>();
        .mAppKey = s;
        .mAttentionUid = s1;
        .mAttentionScreenName = s2;
        .mAuthlistener = weiboauthlistener;
        return ;
    }

    public static mAuthlistener createRequestParam(String s, String s1, String s2, String s3, WeiboAuthListener weiboauthlistener)
    {
        mAuthlistener mauthlistener = new <init>();
        mauthlistener.mAppKey = s;
        mauthlistener.mAccessToken = s1;
        mauthlistener.mAttentionUid = s2;
        mauthlistener.mAttentionScreenName = s3;
        mauthlistener.mAuthlistener = weiboauthlistener;
        return mauthlistener;
    }

    private boolean hasAuthoriz()
    {
        return !TextUtils.isEmpty(mAccessToken);
    }







    private ()
    {
    }
}
