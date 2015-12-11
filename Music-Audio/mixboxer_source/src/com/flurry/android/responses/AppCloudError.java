// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.responses;


public class AppCloudError
{

    private int fa;
    private String mErrorMessage;

    public AppCloudError(int i, String s)
    {
        fa = i;
        mErrorMessage = s;
    }

    public int getErrorCode()
    {
        return fa;
    }

    public String getErrorMessage()
    {
        return mErrorMessage;
    }
}
