// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager;

import java.net.URI;

public class k
{

    private long a;
    private String b;
    private URI c;
    private String d;

    public k(long l, String s, URI uri)
    {
        this(l, s, uri, null);
    }

    public k(long l, String s, URI uri, String s1)
    {
        a = l;
        b = s;
        c = uri;
        d = s1;
    }

    public long a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public URI c()
    {
        return c;
    }

    public String d()
    {
        return d;
    }
}
