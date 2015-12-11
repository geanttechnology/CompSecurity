// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.u;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.api:
//            Scope

public final class com.google.android.gms.common.api.b
{
    public static interface a
    {
    }

    public static interface a.a
        extends a
    {
    }

    public static final class a.b
        implements a.c
    {

        private a.b()
        {
        }
    }

    public static interface a.c
        extends a
    {
    }

    public static interface a.d
        extends a.a, a.c
    {
    }

    public static interface b
    {

        public abstract void a();

        public abstract void a(d.c c1);

        public abstract void a(com.google.android.gms.common.internal.a a1);

        public abstract void a(com.google.android.gms.common.internal.a a1, Set set);

        public abstract void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[]);

        public abstract boolean b();

        public abstract boolean c();
    }

    public static final class c
    {

        public c()
        {
        }
    }

    public static interface d
    {

        public abstract int a();

        public abstract b a(Context context, Looper looper, h h, Object obj, d.b b1, d.d d1);
    }

    public static interface e
    {

        public abstract IInterface a(IBinder ibinder);

        public abstract String a();

        public abstract String b();
    }

    public static interface f
    {

        public abstract int a();

        public abstract e a(Object obj);
    }

    public static final class g
    {
    }


    private final d a;
    private final f b = null;
    private final c c;
    private final g d = null;
    private final ArrayList e;
    private final String f;

    public transient com.google.android.gms.common.api.b(String s, d d1, c c1, Scope ascope[])
    {
        u.a(d1, "Cannot construct an Api with a null ClientBuilder");
        u.a(c1, "Cannot construct an Api with a null ClientKey");
        f = s;
        a = d1;
        c = c1;
        e = new ArrayList(Arrays.asList(ascope));
    }

    public d a()
    {
        boolean flag;
        if (a != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        u.a(flag, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return a;
    }

    public f b()
    {
        boolean flag;
        if (b != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        u.a(flag, "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return b;
    }

    public List c()
    {
        return e;
    }

    public c d()
    {
        boolean flag;
        if (c != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        u.a(flag, "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
        return c;
    }

    public boolean e()
    {
        return d != null;
    }

    public String f()
    {
        return f;
    }
}
