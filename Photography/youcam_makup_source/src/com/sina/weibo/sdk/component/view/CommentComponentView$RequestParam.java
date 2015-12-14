// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component.view;

import com.sina.weibo.sdk.auth.WeiboAuthListener;

public class I
{

    private String mAccessToken;
    private String mAppKey;
    private WeiboAuthListener mAuthlistener;
    private mAuthlistener mCategory;
    private String mContent;
    private String mTopic;

    public static I createRequestParam(String s, String s1, String s2, I i, WeiboAuthListener weiboauthlistener)
    {
        I j = new <init>();
        j.mAppKey = s;
        j.mTopic = s1;
        j.mContent = s2;
        j.mCategory = i;
        j.mAuthlistener = weiboauthlistener;
        return j;
    }

    public static mAuthlistener createRequestParam(String s, String s1, String s2, String s3, mAuthlistener mauthlistener, WeiboAuthListener weiboauthlistener)
    {
        mAuthlistener mauthlistener1 = new <init>();
        mauthlistener1.mAppKey = s;
        mauthlistener1.mAccessToken = s1;
        mauthlistener1.mTopic = s2;
        mauthlistener1.mContent = s3;
        mauthlistener1.mCategory = mauthlistener;
        mauthlistener1.mAuthlistener = weiboauthlistener;
        return mauthlistener1;
    }







    private I()
    {
    }
}
