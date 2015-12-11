// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.a.a;

import com.google.api.a.e.b;
import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.g.l;

public class s extends b
{

    public String accessToken;
    Long expiresInSeconds;
    String refreshToken;
    private String scope;
    private String tokenType;

    public s()
    {
    }

    public s a()
    {
        return (s)super.clone();
    }

    public s a(String s1)
    {
        accessToken = (String)c.a(s1);
        return this;
    }

    public s a(String s1, Object obj)
    {
        return (s)super.set(s1, obj);
    }

    public b clone()
    {
        return a();
    }

    public l clone()
    {
        return a();
    }

    public Object clone()
    {
        return a();
    }

    public b set(String s1, Object obj)
    {
        return a(s1, obj);
    }

    public l set(String s1, Object obj)
    {
        return a(s1, obj);
    }
}
