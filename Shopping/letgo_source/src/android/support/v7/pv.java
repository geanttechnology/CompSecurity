// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

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
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.List;

// Referenced classes of package android.support.v7:
//            ps, pq, ll, qa, 
//            pz, pu, tp, pw

public final class pv
    implements pw.a
{

    private final String a;
    private final pz b;
    private final long c;
    private final pq d;
    private final AdRequestParcel e;
    private final AdSizeParcel f;
    private final Context g;
    private final Object h = new Object();
    private final VersionInfoParcel i;
    private final boolean j;
    private final NativeAdOptionsParcel k;
    private final List l;
    private qa m;
    private int n;

    public pv(Context context, String s, pz pz1, ps ps1, pq pq1, AdRequestParcel adrequestparcel, AdSizeParcel adsizeparcel, 
            VersionInfoParcel versioninfoparcel, boolean flag, NativeAdOptionsParcel nativeadoptionsparcel, List list)
    {
        n = -2;
        g = context;
        b = pz1;
        d = pq1;
        long l1;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(s))
        {
            a = b();
        } else
        {
            a = s;
        }
        if (ps1.b != -1L)
        {
            l1 = ps1.b;
        } else
        {
            l1 = 10000L;
        }
        c = l1;
        e = adrequestparcel;
        f = adsizeparcel;
        i = versioninfoparcel;
        j = flag;
        k = nativeadoptionsparcel;
        l = list;
    }

    static qa a(pv pv1, qa qa1)
    {
        pv1.m = qa1;
        return qa1;
    }

    static Object a(pv pv1)
    {
        return pv1.h;
    }

    private void a(long l1, long l2, long l3, long l4)
    {
        do
        {
            if (n != -2)
            {
                return;
            }
            b(l1, l2, l3, l4);
        } while (true);
    }

    private void a(pu pu1)
    {
        if ("com.google.ads.mediation.AdUrlAdapter".equals(a))
        {
            Bundle bundle1 = e.zzsA.getBundle(a);
            Bundle bundle = bundle1;
            if (bundle1 == null)
            {
                bundle = new Bundle();
            }
            bundle.putString("sdk_less_network_id", d.b);
            e.zzsA.putBundle(a, bundle);
        }
        if (i.zzIB >= 0x3e8fa0)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        if (f.zzsH)
        {
            m.a(ll.a(g), e, d.h, pu1);
            return;
        }
        try
        {
            m.a(ll.a(g), f, e, d.h, pu1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (pu pu1)
        {
            zzb.zzd("Could not request ad from mediation adapter.", pu1);
        }
        a(5);
        return;
        if (j)
        {
            m.a(ll.a(g), e, d.h, d.a, pu1, k, l);
            return;
        }
        if (f.zzsH)
        {
            m.a(ll.a(g), e, d.h, d.a, pu1);
            return;
        }
        m.a(ll.a(g), f, e, d.h, d.a, pu1);
        return;
    }

    static void a(pv pv1, pu pu1)
    {
        pv1.a(pu1);
    }

    static int b(pv pv1)
    {
        return pv1.n;
    }

    private String b()
    {
        if (!TextUtils.isEmpty(d.e))
        {
            if (b.b(d.e))
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
        zzb.zzaE("Fail to determine the custom event's version, assuming the old one.");
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private void b(long l1, long l2, long l3, long l4)
    {
        long l5 = SystemClock.elapsedRealtime();
        l1 = l2 - (l5 - l1);
        l2 = l4 - (l5 - l3);
        if (l1 <= 0L || l2 <= 0L)
        {
            zzb.zzaD("Timed out waiting for adapter.");
            n = 3;
            return;
        }
        try
        {
            h.wait(Math.min(l1, l2));
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            n = -1;
        }
    }

    private qa c()
    {
        zzb.zzaD((new StringBuilder()).append("Instantiating mediation adapter: ").append(a).toString());
        qa qa1;
        try
        {
            qa1 = b.a(a);
        }
        catch (RemoteException remoteexception)
        {
            zzb.zza((new StringBuilder()).append("Could not instantiate mediation adapter: ").append(a).toString(), remoteexception);
            return null;
        }
        return qa1;
    }

    static qa c(pv pv1)
    {
        return pv1.c();
    }

    static qa d(pv pv1)
    {
        return pv1.m;
    }

    public pw a(long l1, long l2)
    {
        Object obj1;
        synchronized (h)
        {
            long l3 = SystemClock.elapsedRealtime();
            obj1 = new pu();
            tp.a.post(new Runnable(((pu) (obj1))) {

                final pu a;
                final pv b;

                public void run()
                {
label0:
                    {
                        synchronized (pv.a(b))
                        {
                            if (pv.b(b) == -2)
                            {
                                break label0;
                            }
                        }
                        return;
                    }
                    pv.a(b, pv.c(b));
                    if (pv.d(b) != null)
                    {
                        break MISSING_BLOCK_LABEL_66;
                    }
                    b.a(4);
                    obj2;
                    JVM INSTR monitorexit ;
                    return;
                    exception1;
                    obj2;
                    JVM INSTR monitorexit ;
                    throw exception1;
                    a.a(b);
                    pv.a(b, a);
                    obj2;
                    JVM INSTR monitorexit ;
                }

            
            {
                b = pv.this;
                a = pu1;
                super();
            }
            });
            a(l3, c, l1, l2);
            obj1 = new pw(d, m, a, ((pu) (obj1)), n);
        }
        return ((pw) (obj1));
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a()
    {
        Object obj = h;
        obj;
        JVM INSTR monitorenter ;
        if (m != null)
        {
            m.c();
        }
_L1:
        n = -1;
        h.notify();
        return;
        Object obj1;
        obj1;
        zzb.zzd("Could not destroy mediation adapter.", ((Throwable) (obj1)));
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public void a(int i1)
    {
        synchronized (h)
        {
            n = i1;
            h.notify();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
