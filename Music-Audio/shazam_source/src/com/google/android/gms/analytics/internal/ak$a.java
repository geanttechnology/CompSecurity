// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.hy;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            ak

public static final class a
{

    private final Object a;
    private final hy b;
    private Object c;

    static a a(String s, int i, int j)
    {
        return new <init>(hy.a(s, Integer.valueOf(j)), Integer.valueOf(i));
    }

    static <init> a(String s, long l, long l1)
    {
        return new <init>(hy.a(s, Long.valueOf(l1)), Long.valueOf(l));
    }

    static <init> a(String s, String s1, String s2)
    {
        return new <init>(hy.a(s, s2), s1);
    }

    static <init> a(String s, boolean flag)
    {
        return new <init>(hy.a(s, flag), Boolean.valueOf(flag));
    }

    public final Object a()
    {
        if (c != null)
        {
            return c;
        }
        if (f.a && hy.b())
        {
            return b.e();
        } else
        {
            return a;
        }
    }

    (hy hy1, Object obj)
    {
        w.a(hy1);
        b = hy1;
        a = obj;
    }
}
