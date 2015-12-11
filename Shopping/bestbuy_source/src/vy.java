// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.gs;

public final class vy
    implements wa
{

    private final String a;
    private final wd b;
    private final long c;
    private final vu d;
    private final av e;
    private final ay f;
    private final Context g;
    private final Object h = new Object();
    private final gs i;
    private wg j;
    private int k;

    public vy(Context context, String s, wd wd1, vv vv1, vu vu1, av av, ay ay1, 
            gs gs1)
    {
        k = -2;
        g = context;
        b = wd1;
        d = vu1;
        long l;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(s))
        {
            a = b();
        } else
        {
            a = s;
        }
        if (vv1.b != -1L)
        {
            l = vv1.b;
        } else
        {
            l = 10000L;
        }
        c = l;
        e = av;
        f = ay1;
        i = gs1;
    }

    static Object a(vy vy1)
    {
        return vy1.h;
    }

    static wg a(vy vy1, wg wg1)
    {
        vy1.j = wg1;
        return wg1;
    }

    private void a(long l, long l1, long l2, long l3)
    {
        do
        {
            if (k != -2)
            {
                return;
            }
            b(l, l1, l2, l3);
        } while (true);
    }

    private void a(vx vx1)
    {
        if (i.d >= 0x3e8fa0)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        if (f.e)
        {
            j.a(sb.a(g), e, d.g, vx1);
            return;
        }
        try
        {
            j.a(sb.a(g), f, e, d.g, vx1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (vx vx1)
        {
            acb.d("Could not request ad from mediation adapter.", vx1);
        }
        a(5);
        return;
        if (f.e)
        {
            j.a(sb.a(g), e, d.g, d.a, vx1);
            return;
        }
        j.a(sb.a(g), f, e, d.g, d.a, vx1);
        return;
    }

    static void a(vy vy1, vx vx1)
    {
        vy1.a(vx1);
    }

    static int b(vy vy1)
    {
        return vy1.k;
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
        acb.e("Fail to determine the custom event's version, assuming the old one.");
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private void b(long l, long l1, long l2, long l3)
    {
        long l4 = SystemClock.elapsedRealtime();
        l = l1 - (l4 - l);
        l1 = l3 - (l4 - l2);
        if (l <= 0L || l1 <= 0L)
        {
            acb.c("Timed out waiting for adapter.");
            k = 3;
            return;
        }
        try
        {
            h.wait(Math.min(l, l1));
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            k = -1;
        }
    }

    private wg c()
    {
        acb.c((new StringBuilder()).append("Instantiating mediation adapter: ").append(a).toString());
        wg wg1;
        try
        {
            wg1 = b.a(a);
        }
        catch (RemoteException remoteexception)
        {
            acb.a((new StringBuilder()).append("Could not instantiate mediation adapter: ").append(a).toString(), remoteexception);
            return null;
        }
        return wg1;
    }

    static wg c(vy vy1)
    {
        return vy1.c();
    }

    static wg d(vy vy1)
    {
        return vy1.j;
    }

    public vz a(long l, long l1)
    {
        Object obj1;
        synchronized (h)
        {
            long l2 = SystemClock.elapsedRealtime();
            obj1 = new vx();
            aca.a.post(new Runnable(((vx) (obj1))) {

                final vx a;
                final vy b;

                public void run()
                {
label0:
                    {
                        synchronized (vy.a(b))
                        {
                            if (vy.b(b) == -2)
                            {
                                break label0;
                            }
                        }
                        return;
                    }
                    vy.a(b, vy.c(b));
                    if (vy.d(b) != null)
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
                    vy.a(b, a);
                    obj2;
                    JVM INSTR monitorexit ;
                }

            
            {
                b = vy.this;
                a = vx1;
                super();
            }
            });
            a(l2, c, l, l1);
            obj1 = new vz(d, j, a, ((vx) (obj1)), k);
        }
        return ((vz) (obj1));
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
        if (j != null)
        {
            j.c();
        }
_L1:
        k = -1;
        h.notify();
        return;
        Object obj1;
        obj1;
        acb.d("Could not destroy mediation adapter.", ((Throwable) (obj1)));
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public void a(int l)
    {
        synchronized (h)
        {
            k = l;
            h.notify();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
