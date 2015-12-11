// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.reward.client.b;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.b.ad;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            e, i, b

public class h
{

    private static final Object a = new Object();
    private static h b;
    private final a c = new a();
    private final e d = new e();
    private final i e = new i();
    private final com.google.android.gms.ads.internal.client.b f = new com.google.android.gms.ads.internal.client.b();
    private final ad g = new ad();
    private final b h = new b();

    protected h()
    {
    }

    public static a a()
    {
        return b().c;
    }

    protected static void a(h h1)
    {
        synchronized (a)
        {
            b = h1;
        }
        return;
        h1;
        obj;
        JVM INSTR monitorexit ;
        throw h1;
    }

    private static h b()
    {
        h h1;
        synchronized (a)
        {
            h1 = b;
        }
        return h1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static 
    {
        a(new h());
    }
}
