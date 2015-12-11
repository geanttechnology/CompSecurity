// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import java.io.IOException;

public class WebViewErrorException extends IOException
{

    private String mDescription;
    private int mErrorCode;
    private String mFailingUrl;

    public WebViewErrorException(int i, String s, String s1)
    {
        mErrorCode = i;
        mDescription = s;
        mFailingUrl = s1;
    }

    public String toString()
    {
        return String.format("%s\n ErrorCode = %s, Description = %s, FailingUrl = %s", new Object[] {
            getClass().getSimpleName(), Integer.valueOf(mErrorCode), mDescription, mFailingUrl
        });
    }
}
