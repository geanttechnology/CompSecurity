// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.e;
import com.google.android.gms.ads.internal.purchase.i;
import com.google.android.gms.ads.internal.request.a;
import com.google.android.gms.d.av;
import com.google.android.gms.d.aw;
import com.google.android.gms.d.ax;
import com.google.android.gms.d.bc;
import com.google.android.gms.d.co;
import com.google.android.gms.d.de;
import com.google.android.gms.d.fb;
import com.google.android.gms.d.ft;
import com.google.android.gms.d.gd;
import com.google.android.gms.d.gm;
import com.google.android.gms.d.gn;
import com.google.android.gms.d.gr;
import com.google.android.gms.d.hg;
import com.google.android.gms.d.ii;
import com.google.android.gms.d.ij;

public final class p
{

    private static final Object a;
    private static p b;
    private final a c = new a();
    private final com.google.android.gms.ads.internal.overlay.a d = new com.google.android.gms.ads.internal.overlay.a();
    private final e e = new e();
    private final fb f = new fb();
    private final gm g = new gm();
    private final hg h = new hg();
    private final gn i;
    private final gd j = new gd();
    private final ii k = new ij();
    private final bc l = new bc();
    private final ft m = new ft();
    private final aw n = new aw();
    private final av o = new av();
    private final ax p = new ax();
    private final i q = new i();
    private final gr r = new gr();
    private final de s = new de();
    private final co t = new co();

    protected p()
    {
        int i1 = android.os.Build.VERSION.SDK_INT;
        Object obj;
        if (i1 >= 19)
        {
            obj = new com.google.android.gms.d.gn.g();
        } else
        if (i1 >= 18)
        {
            obj = new com.google.android.gms.d.gn.e();
        } else
        if (i1 >= 17)
        {
            obj = new com.google.android.gms.d.gn.d();
        } else
        if (i1 >= 16)
        {
            obj = new com.google.android.gms.d.gn.f();
        } else
        if (i1 >= 14)
        {
            obj = new com.google.android.gms.d.gn.c();
        } else
        if (i1 >= 11)
        {
            obj = new com.google.android.gms.d.gn.b();
        } else
        if (i1 >= 9)
        {
            obj = new com.google.android.gms.d.gn.a();
        } else
        {
            obj = new gn();
        }
        i = ((gn) (obj));
    }

    public static a a()
    {
        return s().c;
    }

    public static com.google.android.gms.ads.internal.overlay.a b()
    {
        return s().d;
    }

    public static e c()
    {
        return s().e;
    }

    public static fb d()
    {
        return s().f;
    }

    public static gm e()
    {
        return s().g;
    }

    public static hg f()
    {
        return s().h;
    }

    public static gn g()
    {
        return s().i;
    }

    public static gd h()
    {
        return s().j;
    }

    public static ii i()
    {
        return s().k;
    }

    public static bc j()
    {
        return s().l;
    }

    public static ft k()
    {
        return s().m;
    }

    public static aw l()
    {
        return s().n;
    }

    public static av m()
    {
        return s().o;
    }

    public static ax n()
    {
        return s().p;
    }

    public static i o()
    {
        return s().q;
    }

    public static gr p()
    {
        return s().r;
    }

    public static de q()
    {
        return s().s;
    }

    public static co r()
    {
        return s().t;
    }

    private static p s()
    {
        p p1;
        synchronized (a)
        {
            p1 = b;
        }
        return p1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static 
    {
        a = new Object();
        p p1 = new p();
        synchronized (a)
        {
            b = p1;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
