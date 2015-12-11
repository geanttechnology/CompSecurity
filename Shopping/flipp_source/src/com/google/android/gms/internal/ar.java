// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;

// Referenced classes of package com.google.android.gms.internal:
//            au, ao, aq, er, 
//            as, et, at, bn, 
//            an, v, x, cu, 
//            bq

public final class ar
    implements au
{

    final an a;
    final v b;
    final x c;
    final Context d;
    final Object e = new Object();
    final cu f;
    bq g;
    int h;
    private final String i;
    private final bn j;
    private final long k;

    public ar(Context context, String s, bn bn1, ao ao1, an an, v v, x x, 
            cu cu)
    {
        h = -2;
        d = context;
        i = s;
        j = bn1;
        long l;
        if (ao1.b != -1L)
        {
            l = ao1.b;
        } else
        {
            l = 10000L;
        }
        k = l;
        a = an;
        b = v;
        c = x;
        f = cu;
    }

    public final at a(long l)
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        long l1;
        long l2;
        l1 = SystemClock.elapsedRealtime();
        obj1 = new aq();
        er.a.post(new as(this, ((aq) (obj1))));
        l2 = k;
_L1:
        long l4;
        if (h != -2)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        l4 = SystemClock.elapsedRealtime();
        long l3;
        l3 = l2 - (l4 - l1);
        l4 = 60000L - (l4 - l);
        if (l3 > 0L && l4 > 0L)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        et.b("Timed out waiting for adapter.");
        h = 3;
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        e.wait(Math.min(l3, l4));
          goto _L1
        InterruptedException interruptedexception;
        interruptedexception;
        h = -1;
          goto _L1
        obj1 = new at(a, g, i, ((aq) (obj1)), h);
        obj;
        JVM INSTR monitorexit ;
        return ((at) (obj1));
    }

    final bq a()
    {
        et.b((new StringBuilder("Instantiating mediation adapter: ")).append(i).toString());
        bq bq;
        try
        {
            bq = j.a(i);
        }
        catch (RemoteException remoteexception)
        {
            String s = (new StringBuilder("Could not instantiate mediation adapter: ")).append(i).toString();
            if (et.a(3))
            {
                Log.d("Ads", s, remoteexception);
            }
            return null;
        }
        return bq;
    }

    public final void a(int l)
    {
        synchronized (e)
        {
            h = l;
            e.notify();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
