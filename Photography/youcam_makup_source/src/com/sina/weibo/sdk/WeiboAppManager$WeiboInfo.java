// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk;

import android.text.TextUtils;

public class 
{

    private String mPackageName;
    private int mSupportApi;

    private void setPackageName(String s)
    {
        mPackageName = s;
    }

    private void setSupportApi(int i)
    {
        mSupportApi = i;
    }

    public String getPackageName()
    {
        return mPackageName;
    }

    public int getSupportApi()
    {
        return mSupportApi;
    }

    public boolean isLegal()
    {
        return !TextUtils.isEmpty(mPackageName) && mSupportApi > 0;
    }

    public String toString()
    {
        return (new StringBuilder("WeiboInfo: PackageName = ")).append(mPackageName).append(", supportApi = ").append(mSupportApi).toString();
    }



    public ()
    {
    }
}
