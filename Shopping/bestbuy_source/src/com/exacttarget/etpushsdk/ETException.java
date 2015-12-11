// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;


public class ETException extends Exception
{

    private static final long serialVersionUID = 1L;

    public ETException()
    {
    }

    public ETException(String s)
    {
        super(s);
    }

    public ETException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public ETException(Throwable throwable)
    {
        super(throwable);
    }
}
