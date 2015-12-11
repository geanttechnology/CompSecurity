// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.common.internal.w;

public final class jy
{

    public final String a;
    final Integer b;
    final String c;
    final boolean d;
    final String e;

    public jy(String s, Integer integer, String s1)
    {
        this(s, integer, s1, "");
    }

    private jy(String s, Integer integer, String s1, String s2)
    {
        w.a(s);
        w.a(s2);
        a = s;
        b = integer;
        c = s1;
        d = false;
        e = s2;
    }

    public final String a()
    {
        if (c != null)
        {
            return (new StringBuilder()).append(c).append("_").append(a).toString();
        } else
        {
            return a;
        }
    }
}
