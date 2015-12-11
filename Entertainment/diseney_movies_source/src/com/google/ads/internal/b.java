// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;


public final class b extends Exception
{

    public final boolean a;

    public b(String s, boolean flag)
    {
        super(s);
        a = flag;
    }

    public b(String s, boolean flag, Throwable throwable)
    {
        super(s, throwable);
        a = flag;
    }

    public void a(String s)
    {
        com.google.ads.util.b.b(c(s));
        com.google.ads.util.b.a(null, this);
    }

    public void b(String s)
    {
        String s1 = c(s);
        if (a)
        {
            s = this;
        } else
        {
            s = null;
        }
        throw new RuntimeException(s1, s);
    }

    public String c(String s)
    {
        String s1 = s;
        if (a)
        {
            s1 = (new StringBuilder()).append(s).append(": ").append(getMessage()).toString();
        }
        return s1;
    }
}
