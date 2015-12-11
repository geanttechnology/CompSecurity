// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.support.v7.vf;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.x;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            ak

public static final class a
{

    private final Object a;
    private final vf b;
    private Object c;

    static a a(String s, float f1)
    {
        return a(s, f1, f1);
    }

    static a a(String s, float f1, float f2)
    {
        return new <init>(vf.a(s, Float.valueOf(f2)), Float.valueOf(f1));
    }

    static <init> a(String s, int i)
    {
        return a(s, i, i);
    }

    static a a(String s, int i, int j)
    {
        return new <init>(vf.a(s, Integer.valueOf(j)), Integer.valueOf(i));
    }

    static <init> a(String s, long l)
    {
        return a(s, l, l);
    }

    static a a(String s, long l, long l1)
    {
        return new <init>(vf.a(s, Long.valueOf(l1)), Long.valueOf(l));
    }

    static <init> a(String s, String s1)
    {
        return a(s, s1, s1);
    }

    static a a(String s, String s1, String s2)
    {
        return new <init>(vf.a(s, s2), s1);
    }

    static <init> a(String s, boolean flag)
    {
        return a(s, flag, flag);
    }

    static a a(String s, boolean flag, boolean flag1)
    {
        return new <init>(vf.a(s, flag1), Boolean.valueOf(flag));
    }

    public Object a()
    {
        if (c != null)
        {
            return c;
        }
        if (f.a && vf.b())
        {
            return b.d();
        } else
        {
            return a;
        }
    }

    private (vf vf1, Object obj)
    {
        x.a(vf1);
        b = vf1;
        a = obj;
    }
}
