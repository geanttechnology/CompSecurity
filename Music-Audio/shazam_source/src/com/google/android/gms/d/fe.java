// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.b;

// Referenced classes of package com.google.android.gms.d:
//            ez, dd, gb, cw, 
//            dc, dh, dg, cz, 
//            be, he

public final class fe extends ez
{

    protected dd a;
    private dg k;
    private cw l;
    private cz m;
    private final be n;

    fe(Context context, gb.a a1, he he, dg dg, fb.a a2, be be)
    {
        super(context, a1, he, a2);
        k = dg;
        m = a1.c;
        n = be;
    }

    protected final gb a(int i)
    {
        AdRequestInfoParcel adrequestinfoparcel = g.a;
        com.google.android.gms.ads.internal.client.AdRequestParcel adrequestparcel = adrequestinfoparcel.c;
        he he = d;
        java.util.List list = h.d;
        java.util.List list1 = h.f;
        java.util.List list2 = h.j;
        int j = h.l;
        long l1 = h.k;
        String s1 = adrequestinfoparcel.i;
        boolean flag = h.h;
        cx cx;
        dh dh1;
        String s;
        db db;
        cz cz;
        if (a != null)
        {
            cx = a.b;
        } else
        {
            cx = null;
        }
        if (a != null)
        {
            dh1 = a.c;
        } else
        {
            dh1 = null;
        }
        if (a != null)
        {
            s = a.d;
        } else
        {
            s = com/google/ads/mediation/admob/AdMobAdapter.getName();
        }
        cz = m;
        if (a != null)
        {
            db = a.e;
        } else
        {
            db = null;
        }
        return new gb(adrequestparcel, he, list, i, list1, list2, j, l1, s1, flag, cx, dh1, s, cz, db, h.i, g.d, h.g, g.f, h.n, h.o, g.h, null, adrequestinfoparcel.x);
    }

    public final void b()
    {
        Object obj = f;
        obj;
        JVM INSTR monitorenter ;
        super.b();
        if (l == null) goto _L2; else goto _L1
_L1:
        Object obj2 = l;
        Object obj1 = ((cw) (obj2)).a;
        obj1;
        JVM INSTR monitorenter ;
        obj2.b = true;
        if (((cw) (obj2)).c == null) goto _L4; else goto _L3
_L3:
        dc dc1 = ((cw) (obj2)).c;
        obj2 = dc1.f;
        obj2;
        JVM INSTR monitorenter ;
        if (dc1.k != null)
        {
            dc1.k.c();
        }
_L5:
        dc1.l = -1;
        dc1.f.notify();
_L4:
        obj1;
        JVM INSTR monitorexit ;
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.ads.internal.util.client.b.a(5);
          goto _L5
        Exception exception2;
        exception2;
        obj2;
        JVM INSTR monitorexit ;
        throw exception2;
        Exception exception1;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected final void b(long l1)
    {
        synchronized (f)
        {
            l = new cw(c, g.a, k, m, h.t);
        }
        a = l.a(l1, n);
        switch (a.a)
        {
        default:
            throw new ez.a((new StringBuilder("Unexpected mediation result: ")).append(a.a).toString(), 0);

        case 1: // '\001'
            throw new ez.a("No fill from any mediation ad networks.", 3);

        case 0: // '\0'
            return;
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
