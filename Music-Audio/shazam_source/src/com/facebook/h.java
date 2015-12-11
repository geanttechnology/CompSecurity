// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;


public class h extends RuntimeException
{

    public h()
    {
    }

    public h(String s)
    {
        super(s);
    }

    public h(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public h(Throwable throwable)
    {
        super(throwable);
    }

    public String toString()
    {
        return getMessage();
    }
}
