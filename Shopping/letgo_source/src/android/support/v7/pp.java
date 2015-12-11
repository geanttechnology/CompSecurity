// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v7:
//            nt, ps, pq, pw, 
//            pv, tp, pz, qa

public final class pp
{

    private final AdRequestInfoParcel a;
    private final pz b;
    private final Context c;
    private final Object d = new Object();
    private final ps e;
    private final boolean f;
    private boolean g;
    private pv h;

    public pp(Context context, AdRequestInfoParcel adrequestinfoparcel, pz pz, ps ps1, boolean flag)
    {
        g = false;
        c = context;
        a = adrequestinfoparcel;
        b = pz;
        e = ps1;
        f = flag;
    }

    public pw a(long l, long l1, nt nt1)
    {
        ArrayList arraylist;
        ns ns;
        Iterator iterator;
        zzb.zzaC("Starting mediation.");
        arraylist = new ArrayList();
        ns = nt1.a();
        iterator = e.a.iterator();
_L4:
        pq pq1;
        Iterator iterator1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_382;
        }
        pq1 = (pq)iterator.next();
        zzb.zzaD((new StringBuilder()).append("Trying mediation network: ").append(pq1.b).toString());
        iterator1 = pq1.c.iterator();
_L2:
        String s;
        ns ns1;
label0:
        {
            if (!iterator1.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            s = (String)iterator1.next();
            ns1 = nt1.a();
            synchronized (d)
            {
                if (!g)
                {
                    break label0;
                }
                nt1 = new pw(-1);
            }
            return nt1;
        }
        h = new pv(c, s, b, e, pq1, a.zzDy, a.zzqf, a.zzqb, f, a.zzqt, a.zzqv);
        obj;
        JVM INSTR monitorexit ;
        obj = h.a(l, l1);
        if (((pw) (obj)).a == 0)
        {
            zzb.zzaC("Adapter succeeded.");
            nt1.a("mediation_network_succeed", s);
            if (!arraylist.isEmpty())
            {
                nt1.a("mediation_networks_fail", TextUtils.join(",", arraylist));
            }
            nt1.a(ns1, new String[] {
                "mls"
            });
            nt1.a(ns, new String[] {
                "ttm"
            });
            return ((pw) (obj));
        }
        break MISSING_BLOCK_LABEL_327;
        nt1;
        obj;
        JVM INSTR monitorexit ;
        throw nt1;
        arraylist.add(s);
        nt1.a(ns1, new String[] {
            "mlf"
        });
        if (((pw) (obj)).c != null)
        {
            tp.a.post(new Runnable(((pw) (obj))) {

                final pw a;
                final pp b;

                public void run()
                {
                    try
                    {
                        a.c.c();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzb.zzd("Could not destroy mediation adapter.", remoteexception);
                    }
                }

            
            {
                b = pp.this;
                a = pw1;
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
            nt1.a("mediation_networks_fail", TextUtils.join(",", arraylist));
        }
        return new pw(1);
    }

    public void a()
    {
        synchronized (d)
        {
            g = true;
            if (h != null)
            {
                h.a();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
