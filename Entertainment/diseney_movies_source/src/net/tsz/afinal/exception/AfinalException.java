// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.exception;


public class AfinalException extends RuntimeException
{

    private static final long serialVersionUID = 1L;

    public AfinalException()
    {
    }

    public AfinalException(String s)
    {
        super(s);
    }

    public AfinalException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public AfinalException(Throwable throwable)
    {
        super(throwable);
    }
}
