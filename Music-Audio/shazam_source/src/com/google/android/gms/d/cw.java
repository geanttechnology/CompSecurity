// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.d:
//            be, cz, cx, dd, 
//            dc, gm, dg, dh

public final class cw
{

    final Object a = new Object();
    boolean b;
    dc c;
    private final AdRequestInfoParcel d;
    private final dg e;
    private final Context f;
    private final cz g;
    private final boolean h;

    public cw(Context context, AdRequestInfoParcel adrequestinfoparcel, dg dg, cz cz1, boolean flag)
    {
        b = false;
        f = context;
        d = adrequestinfoparcel;
        e = dg;
        g = cz1;
        h = flag;
    }

    public final dd a(long l, be be1)
    {
        ArrayList arraylist;
        bd bd;
        Iterator iterator;
        com.google.android.gms.ads.internal.util.client.b.a(3);
        arraylist = new ArrayList();
        bd = be1.a();
        iterator = g.a.iterator();
_L4:
        cx cx1;
        Iterator iterator1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_367;
        }
        cx1 = (cx)iterator.next();
        (new StringBuilder("Trying mediation network: ")).append(cx1.b);
        com.google.android.gms.ads.internal.util.client.b.a(4);
        iterator1 = cx1.c.iterator();
_L2:
        String s;
        bd bd1;
label0:
        {
            if (!iterator1.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            s = (String)iterator1.next();
            bd1 = be1.a();
            synchronized (a)
            {
                if (!b)
                {
                    break label0;
                }
                be1 = new dd(-1);
            }
            return be1;
        }
        c = new dc(f, s, e, g, cx1, d.c, d.d, d.k, h, d.C, d.n);
        obj;
        JVM INSTR monitorexit ;
        obj = c.a(l);
        if (((dd) (obj)).a == 0)
        {
            com.google.android.gms.ads.internal.util.client.b.a(3);
            be1.a("mediation_network_succeed", s);
            if (!arraylist.isEmpty())
            {
                be1.a("mediation_networks_fail", TextUtils.join(",", arraylist));
            }
            be1.a(bd1, new String[] {
                "mls"
            });
            be1.a(bd, new String[] {
                "ttm"
            });
            return ((dd) (obj));
        }
        break MISSING_BLOCK_LABEL_313;
        be1;
        obj;
        JVM INSTR monitorexit ;
        throw be1;
        arraylist.add(s);
        be1.a(bd1, new String[] {
            "mlf"
        });
        if (((dd) (obj)).c != null)
        {
            gm.a.post(new Runnable(((dd) (obj))) {

                final dd a;
                final cw b;

                public final void run()
                {
                    try
                    {
                        a.c.c();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        com.google.android.gms.ads.internal.util.client.b.a(5);
                    }
                }

            
            {
                b = cw.this;
                a = dd1;
                super();
            }
            });
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (true) goto _L4; else goto _L3
_L3:
        if (!arraylist.isEmpty())
        {
            be1.a("mediation_networks_fail", TextUtils.join(",", arraylist));
        }
        return new dd(1);
    }
}
