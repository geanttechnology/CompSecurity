// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.utils.exceptions;


public class CimException extends RuntimeException
{

    public CimException()
    {
    }

    public CimException(String s)
    {
        super(s);
    }

    public CimException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public CimException(Throwable throwable)
    {
        super(throwable);
    }
}
