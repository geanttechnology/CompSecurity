// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


public class CvPreloaderResponse
{

    public final int code;
    public final boolean isError;
    public final String message;

    public CvPreloaderResponse()
    {
        isError = false;
        message = null;
        code = 0;
    }

    public CvPreloaderResponse(String s, int i)
    {
        isError = true;
        message = s;
        code = i;
    }
}
