// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager;


public class a
{

    private final long a;
    private final long b;

    public a(long l, long l1)
    {
        a = l;
        b = l1;
    }

    public long a()
    {
        return a;
    }

    public long b()
    {
        return b;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(a);
        stringbuilder.append("/");
        stringbuilder.append(b);
        return stringbuilder.toString();
    }
}
