// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.w;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class com.google.android.gms.common.api.a
{
    public static abstract class a
    {

        public int a()
        {
            return 0x7fffffff;
        }

        public abstract b a(Context context, Looper looper, h h, Object obj, c.b b1, c.c c1);

        public List b()
        {
            return Collections.emptyList();
        }

        public a()
        {
        }
    }

    public static interface b
    {

        public abstract void a(c.e e1);

        public abstract void a(q q);

        public abstract void a(q q, Set set);

        public abstract void a(String s, PrintWriter printwriter);

        public abstract void d();

        public abstract boolean e();

        public abstract boolean f();
    }

    public static final class c
    {

        public c()
        {
        }
    }

    public static interface d
    {

        public abstract String a();

        public abstract String b();

        public abstract IInterface c();
    }

    public static interface e
    {

        public abstract d a();

        public abstract int b();
    }

    public static final class f
    {
    }


    final e a = null;
    final f b = null;
    final String c;
    private final a d;
    private final c e;

    public com.google.android.gms.common.api.a(String s, a a1, c c1)
    {
        w.a(a1, "Cannot construct an Api with a null ClientBuilder");
        w.a(c1, "Cannot construct an Api with a null ClientKey");
        c = s;
        d = a1;
        e = c1;
    }

    public final a a()
    {
        boolean flag;
        if (d != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return d;
    }

    public final c b()
    {
        boolean flag;
        if (e != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag, "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
        return e;
    }
}
