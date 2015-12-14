// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;


public class RenameDeviceResponse
{

    private final int mError;
    private final String mMessage;

    public RenameDeviceResponse(String s, int i)
    {
        mMessage = s;
        mError = i;
    }

    public int getError()
    {
        return mError;
    }

    public String getMessage()
    {
        return mMessage;
    }
}
