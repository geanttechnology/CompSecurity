// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.c;

// Referenced classes of package com.google.android.gms.b:
//            t, v, x

public abstract class u
    implements t
{

    private final String a;
    private final Object b;

    private u(String s, Object obj)
    {
        a = s;
        b = obj;
        com.google.android.gms.ads.internal.c.h().a(this);
    }

    u(String s, Object obj, _cls1 _pcls1)
    {
        this(s, obj);
    }

    public static u a(String s)
    {
        s = a(s, (String)null);
        com.google.android.gms.ads.internal.c.h().a(s);
        return s;
    }

    public static u a(String s, int i)
    {
        return new _cls2(s, Integer.valueOf(i));
    }

    public static u a(String s, long l)
    {
        return new _cls3(s, Long.valueOf(l));
    }

    public static u a(String s, Boolean boolean1)
    {
        return new _cls1(s, boolean1);
    }

    public static u a(String s, String s1)
    {
        return new _cls4(s, s1);
    }

    public static u b(String s)
    {
        s = a(s, (String)null);
        com.google.android.gms.ads.internal.c.h().b(s);
        return s;
    }

    protected abstract Object a(SharedPreferences sharedpreferences);

    public String a()
    {
        return a;
    }

    public Object b()
    {
        return b;
    }

    public Object c()
    {
        return com.google.android.gms.ads.internal.c.i().a(this);
    }

    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls4 {}

}
