// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.b.d;
import com.google.android.gms.d.bk;
import java.util.List;

// Referenced classes of package com.google.android.gms.ads.internal.formats:
//            a, g

public final class c extends com.google.android.gms.d.bn.a
    implements g.a
{

    private final String a;
    private final List b;
    private final String c;
    private final bk d;
    private final String e;
    private final double f;
    private final String g;
    private final String h;
    private final a i;
    private final Bundle j;
    private final Object k = new Object();
    private g l;

    public c(String s, List list, String s1, bk bk, String s2, double d1, 
            String s3, String s4, a a1, Bundle bundle)
    {
        a = s;
        b = list;
        c = s1;
        d = bk;
        e = s2;
        f = d1;
        g = s3;
        h = s4;
        i = a1;
        j = bundle;
    }

    public final String a()
    {
        return a;
    }

    public final void a(g g1)
    {
        synchronized (k)
        {
            l = g1;
        }
        return;
        g1;
        obj;
        JVM INSTR monitorexit ;
        throw g1;
    }

    public final List b()
    {
        return b;
    }

    public final String c()
    {
        return c;
    }

    public final bk d()
    {
        return d;
    }

    public final String e()
    {
        return e;
    }

    public final double f()
    {
        return f;
    }

    public final String g()
    {
        return g;
    }

    public final String h()
    {
        return h;
    }

    public final com.google.android.gms.b.c i()
    {
        return com.google.android.gms.b.d.a(l);
    }

    public final String j()
    {
        return "2";
    }

    public final String k()
    {
        return "";
    }

    public final Bundle l()
    {
        return j;
    }
}
