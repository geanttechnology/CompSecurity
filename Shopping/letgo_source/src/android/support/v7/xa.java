// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.common.internal.x;

public class xa
{

    private final String a;
    private final Integer b;
    private final String c;
    private final boolean d;
    private final String e;

    public xa(String s, Integer integer, String s1, boolean flag)
    {
        this(s, integer, s1, flag, "");
    }

    public xa(String s, Integer integer, String s1, boolean flag, String s2)
    {
        x.a(s);
        x.a(s2);
        a = s;
        b = integer;
        c = s1;
        d = flag;
        e = s2;
    }

    public String a()
    {
        return a;
    }

    public Integer b()
    {
        return b;
    }

    public String c()
    {
        return c;
    }

    public String d()
    {
        if (c != null)
        {
            return (new StringBuilder()).append(c).append("_").append(a).toString();
        } else
        {
            return a;
        }
    }

    public boolean e()
    {
        return d;
    }

    public String f()
    {
        return e;
    }
}
