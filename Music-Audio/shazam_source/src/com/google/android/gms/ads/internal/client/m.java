// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.reward.a.b;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.d.bw;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            h, n, b

public final class m
{

    private static final Object a;
    private static m b;
    private final a c = new a();
    private final h d = new h();
    private final n e = new n();
    private final com.google.android.gms.ads.internal.client.b f = new com.google.android.gms.ads.internal.client.b();
    private final bw g = new bw();
    private final b h = new b();

    protected m()
    {
    }

    public static a a()
    {
        return d().c;
    }

    public static h b()
    {
        return d().d;
    }

    public static n c()
    {
        return d().e;
    }

    private static m d()
    {
        m m1;
        synchronized (a)
        {
            m1 = b;
        }
        return m1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static 
    {
        a = new Object();
        m m1 = new m();
        synchronized (a)
        {
            b = m1;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
