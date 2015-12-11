// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.d;
import java.util.List;

// Referenced classes of package com.google.android.gms.d:
//            cz, cx, dg, db, 
//            gm, dd, dh

public final class dc
    implements dd.a
{

    final String a;
    final cx b;
    final AdRequestParcel c;
    final AdSizeParcel d;
    final Context e;
    final Object f = new Object();
    final VersionInfoParcel g;
    final boolean h;
    final NativeAdOptionsParcel i;
    final List j;
    dh k;
    int l;
    private final dg m;
    private final long n;

    public dc(Context context, String s, dg dg1, cz cz1, cx cx1, AdRequestParcel adrequestparcel, AdSizeParcel adsizeparcel, 
            VersionInfoParcel versioninfoparcel, boolean flag, NativeAdOptionsParcel nativeadoptionsparcel, List list)
    {
        l = -2;
        e = context;
        m = dg1;
        b = cx1;
        long l1;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(s))
        {
            a = b();
        } else
        {
            a = s;
        }
        if (cz1.b != -1L)
        {
            l1 = cz1.b;
        } else
        {
            l1 = 10000L;
        }
        n = l1;
        c = adrequestparcel;
        d = adsizeparcel;
        g = versioninfoparcel;
        h = flag;
        i = nativeadoptionsparcel;
        j = list;
    }

    private String b()
    {
        if (!TextUtils.isEmpty(b.e))
        {
            if (m.b(b.e))
            {
                return "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
            } else
            {
                return "com.google.ads.mediation.customevent.CustomEventAdapter";
            }
        }
        break MISSING_BLOCK_LABEL_44;
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    public final dd a(long l1)
    {
        Object obj = f;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        long l2;
        long l3;
        l2 = SystemClock.elapsedRealtime();
        obj1 = new db();
        gm.a.post(new Runnable(((db) (obj1))) {

            final db a;
            final dc b;

            public final void run()
            {
label0:
                {
                    synchronized (b.f)
                    {
                        if (b.l == -2)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                b.k = b.a();
                if (b.k != null)
                {
                    break MISSING_BLOCK_LABEL_65;
                }
                b.a(4);
                obj4;
                JVM INSTR monitorexit ;
                return;
                exception;
                obj4;
                JVM INSTR monitorexit ;
                throw exception;
                Object obj3;
                dc dc1;
                obj3 = a;
                dc1 = b;
                synchronized (((db) (obj3)).a)
                {
                    obj3.b = dc1;
                }
                db db1;
                dc1 = b;
                db1 = a;
                if (!"com.google.ads.mediation.AdUrlAdapter".equals(dc1.a))
                {
                    break MISSING_BLOCK_LABEL_178;
                }
                obj3 = dc1.c.m.getBundle(dc1.a);
                obj2 = obj3;
                if (obj3 != null)
                {
                    break MISSING_BLOCK_LABEL_147;
                }
                obj2 = new Bundle();
                ((Bundle) (obj2)).putString("sdk_less_network_id", dc1.b.b);
                dc1.c.m.putBundle(dc1.a, ((Bundle) (obj2)));
                if (dc1.g.d >= 0x3e8fa0) goto _L2; else goto _L1
_L1:
                if (!dc1.d.e) goto _L4; else goto _L3
_L3:
                dc1.k.a(com.google.android.gms.b.d.a(dc1.e), dc1.c, dc1.b.h, db1);
_L5:
                obj4;
                JVM INSTR monitorexit ;
                return;
                exception1;
                obj2;
                JVM INSTR monitorexit ;
                throw exception1;
_L4:
                dc1.k.a(com.google.android.gms.b.d.a(dc1.e), dc1.d, dc1.c, dc1.b.h, db1);
                  goto _L5
                RemoteException remoteexception;
                remoteexception;
                com.google.android.gms.ads.internal.util.client.b.a(5);
                dc1.a(5);
                  goto _L5
_L2:
label1:
                {
                    if (!dc1.h)
                    {
                        break label1;
                    }
                    dc1.k.a(com.google.android.gms.b.d.a(dc1.e), dc1.c, dc1.b.h, dc1.b.a, db1, dc1.i, dc1.j);
                }
                  goto _L5
label2:
                {
                    if (!dc1.d.e)
                    {
                        break label2;
                    }
                    dc1.k.a(com.google.android.gms.b.d.a(dc1.e), dc1.c, dc1.b.h, dc1.b.a, db1);
                }
                  goto _L5
                dc1.k.a(com.google.android.gms.b.d.a(dc1.e), dc1.d, dc1.c, dc1.b.h, dc1.b.a, db1);
                  goto _L5
            }

            
            {
                b = dc.this;
                a = db1;
                super();
            }
        });
        l3 = n;
_L1:
        long l5;
        if (l != -2)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        l5 = SystemClock.elapsedRealtime();
        long l4;
        l4 = l3 - (l5 - l2);
        l5 = 60000L - (l5 - l1);
        if (l4 > 0L && l5 > 0L)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        com.google.android.gms.ads.internal.util.client.b.a(4);
        l = 3;
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        f.wait(Math.min(l4, l5));
          goto _L1
        InterruptedException interruptedexception;
        interruptedexception;
        l = -1;
          goto _L1
        obj1 = new dd(b, k, a, ((db) (obj1)), l);
        obj;
        JVM INSTR monitorexit ;
        return ((dd) (obj1));
    }

    final dh a()
    {
        (new StringBuilder("Instantiating mediation adapter: ")).append(a);
        com.google.android.gms.ads.internal.util.client.b.a(4);
        dh dh;
        try
        {
            dh = m.a(a);
        }
        catch (RemoteException remoteexception)
        {
            (new StringBuilder("Could not instantiate mediation adapter: ")).append(a);
            com.google.android.gms.ads.internal.util.client.b.a(3);
            return null;
        }
        return dh;
    }

    public final void a(int i1)
    {
        synchronized (f)
        {
            l = i1;
            f.notify();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
