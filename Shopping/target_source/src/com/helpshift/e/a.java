// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.e;


public class a
{

    private Long a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    public a(String s)
    {
        b = s;
    }

    public String a()
    {
        return b;
    }

    public void a(Long long1)
    {
        a = long1;
    }

    public void a(String s)
    {
        c = s;
    }

    public String b()
    {
        return (new StringBuilder()).append(b).append("_").append(f).toString();
    }

    public void b(String s)
    {
        d = s;
    }

    public String c()
    {
        return c;
    }

    public void c(String s)
    {
        e = s;
    }

    public String d()
    {
        return d;
    }

    public void d(String s)
    {
        f = s;
    }

    public String e()
    {
        return e;
    }

    public String f()
    {
        return f;
    }

    public String toString()
    {
        return (new StringBuilder()).append("id:").append(a).append(", identifier:").append(b).append(", profileId:").append(c).append(", name:").append(d).append(", email:").append(e).append(", salt:").append(f).toString();
    }
}
