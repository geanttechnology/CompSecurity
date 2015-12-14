// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;


public class WebException extends Exception
{

    int code;

    WebException(String s, int i)
    {
        super(s);
        code = i;
    }

    WebException(String s, Throwable throwable)
    {
        super(s, throwable);
        code = 0;
    }

    int getStatusCode()
    {
        return code;
    }
}
