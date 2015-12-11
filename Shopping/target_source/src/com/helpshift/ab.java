// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;


public class ab
{

    private long a;
    private String b;
    private String c;
    private String d;

    public ab()
    {
        a = -1L;
        b = "";
        d = "";
        c = "";
    }

    public ab(long l, String s, String s1, String s2)
    {
        a = l;
        b = s;
        c = s1;
        d = s2;
    }

    public String a()
    {
        return d;
    }

    public String b()
    {
        return c;
    }

    public String c()
    {
        return b;
    }

    public boolean equals(Object obj)
    {
        obj = (ab)obj;
        return c.equals(((ab) (obj)).c) && d.equals(((ab) (obj)).d) && b.equals(((ab) (obj)).b);
    }

    public String toString()
    {
        return c;
    }
}
