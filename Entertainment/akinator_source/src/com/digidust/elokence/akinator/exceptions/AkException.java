// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.exceptions;


public class AkException extends Exception
{

    private static final long serialVersionUID = 0x7aef6a37de9affafL;

    public AkException()
    {
    }

    public AkException(String s)
    {
        super(s);
    }

    public AkException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public AkException(Throwable throwable)
    {
        super(throwable);
    }
}
