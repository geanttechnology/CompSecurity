// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.a;

import com.smule.android.network.core.b;
import com.smule.android.network.core.k;
import com.smule.android.network.core.l;
import com.smule.android.network.core.m;
import com.smule.android.network.core.n;
import com.smule.android.network.core.o;
import java.util.HashMap;

public class e
{

    private static final String a = com/smule/android/network/a/e.getName();
    private static e b = null;

    private e()
    {
    }

    public static e a()
    {
        com/smule/android/network/a/e;
        JVM INSTR monitorenter ;
        e e1;
        if (b == null)
        {
            b = new e();
        }
        e1 = b;
        com/smule/android/network/a/e;
        JVM INSTR monitorexit ;
        return e1;
        Exception exception;
        exception;
        throw exception;
    }

    public o b()
    {
        Object obj = new k(m.a, "/v2/store/player/entitlement/list", l.b, n.c, null, true);
        obj.d = new HashMap();
        obj = com.smule.android.network.core.b.a().a(((k) (obj)));
        if (((o) (obj)).b != 0)
        {
            com.smule.android.network.core.b.a(((o) (obj)));
        }
        return ((o) (obj));
    }

}
