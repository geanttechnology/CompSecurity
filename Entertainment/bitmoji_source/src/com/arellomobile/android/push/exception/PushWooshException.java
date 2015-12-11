// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.exception;


public class PushWooshException extends Exception
{

    private static final long serialVersionUID = 1L;

    public PushWooshException(Exception exception)
    {
        super(exception);
    }

    public PushWooshException(String s)
    {
        super(s);
    }
}
