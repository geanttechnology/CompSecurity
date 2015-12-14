// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.d;


public class c
{

    String a;
    String b;
    private String c;

    public c(String s, String s1, String s2)
    {
        a(s);
        b = s1;
        a = s2;
    }

    public String a()
    {
        return c;
    }

    public void a(String s)
    {
        c = s;
    }

    public String b()
    {
        return a;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || !(obj instanceof c))
            {
                return false;
            }
            obj = (c)obj;
            if (a != ((c) (obj)).a || a() != ((c) (obj)).a() || b != ((c) (obj)).b)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        if (a != null && !a.isEmpty())
        {
            return a.hashCode();
        }
        if (a() != null)
        {
            return a().hashCode();
        } else
        {
            return b.hashCode();
        }
    }
}
