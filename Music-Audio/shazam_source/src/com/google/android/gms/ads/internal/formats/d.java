// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.b.c;
import com.google.android.gms.d.bk;
import java.util.List;

// Referenced classes of package com.google.android.gms.ads.internal.formats:
//            a, g

public final class d extends com.google.android.gms.d.bp.a
    implements g.a
{

    private final String a;
    private final List b;
    private final String c;
    private final bk d;
    private final String e;
    private final String f;
    private final a g;
    private final Bundle h;
    private final Object i = new Object();
    private g j;

    public d(String s, List list, String s1, bk bk, String s2, String s3, a a1, 
            Bundle bundle)
    {
        a = s;
        b = list;
        c = s1;
        d = bk;
        e = s2;
        f = s3;
        g = a1;
        h = bundle;
    }

    public final String a()
    {
        return a;
    }

    public final void a(g g1)
    {
        synchronized (i)
        {
            j = g1;
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

    public final String f()
    {
        return f;
    }

    public final c g()
    {
        return com.google.android.gms.b.d.a(j);
    }

    public final Bundle h()
    {
        return h;
    }

    public final String j()
    {
        return "1";
    }

    public final String k()
    {
        return "";
    }
}
