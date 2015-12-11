// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;


public class TCommServiceDownException extends Exception
{

    public TCommServiceDownException(Exception exception)
    {
        super(exception);
    }

    public TCommServiceDownException(String s)
    {
        super(s);
    }

    public TCommServiceDownException(String s, Exception exception)
    {
        super(s, exception);
    }
}
