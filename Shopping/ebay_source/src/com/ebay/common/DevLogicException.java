// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import android.util.Log;

public class DevLogicException extends RuntimeException
{

    public static final String TAG = "DevLogicException";
    private static final long serialVersionUID = 1L;

    public DevLogicException(Exception exception)
    {
        super(exception);
        Log.e("DevLogicException", (new StringBuilder()).append(exception.getClass()).append(": ").append(exception.getMessage()).toString(), exception);
    }

    public DevLogicException(String s)
    {
        super(s);
        Log.e("DevLogicException", (new StringBuilder()).append("DevLogicException: ").append(s).toString(), this);
    }
}
