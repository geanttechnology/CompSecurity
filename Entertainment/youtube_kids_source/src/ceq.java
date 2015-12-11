// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ceq
    implements bn
{

    public static final List a = Collections.emptyList();
    final cei b;
    final cfb c;
    final chq d;
    cfa e;
    cen f;
    Thread g;
    public boolean h;
    private final Context i;
    private cex j;
    private final AtomicBoolean k = new AtomicBoolean(false);
    private boolean l;
    private boolean m;
    private CountDownLatch n;
    private final ExecutorService o = Executors.newSingleThreadExecutor();
    private final Queue p = new LinkedBlockingQueue(10);
    private int q;
    private int r;
    private CountDownLatch s;
    private final Timer t = new Timer("Timer - Reconnect to RC server");
    private TimerTask u;
    private long v;
    private final ScheduledExecutorService w = Executors.newSingleThreadScheduledExecutor();
    private ScheduledFuture x;

    public ceq(Context context, cei cei1, cfb cfb1, chq chq1)
    {
        l = true;
        m = true;
        q = 5000;
        i = (Context)b.a(context);
        b = (cei)b.a(cei1);
        c = (cfb)b.a(cfb1);
        d = (chq)b.a(chq1);
        d();
        s = new CountDownLatch(0);
        n = new CountDownLatch(0);
    }

    static AtomicBoolean a(ceq ceq1)
    {
        return ceq1.k;
    }

    static void a(ceq ceq1, cgl cgl1, cgo cgo1, List list)
    {
        if (ceq1.n.getCount() != 0L || ceq1.s.getCount() != 0L)
        {
            try
            {
                ceq1.s.await(cex.a, TimeUnit.MILLISECONDS);
                ceq1.n.await(5L, TimeUnit.SECONDS);
            }
            catch (InterruptedException interruptedexception)
            {
                ceq1.d.a("Interrupted while waiting to connect.", new Object[] {
                    interruptedexception
                });
            }
        }
        if (ceq1.h) goto _L2; else goto _L1
_L1:
        ceq1.p.poll();
        a(list, 2);
        list = ceq1.d;
        cgl1 = cgl1.toString();
        cgo1 = cgo1.toString();
        if (ceq1.a())
        {
            ceq1 = " still connecting, but not done";
        } else
        {
            ceq1 = " not connected";
        }
        list.b("Dropping call for method: %s(%s), because %s.", new Object[] {
            cgl1, cgo1, ceq1
        });
_L4:
        return;
_L2:
        if (ceq1.e.a(cgl1, cgo1) != 200)
        {
            break; /* Loop/switch isn't completed */
        }
        ceq1.p.poll();
        ceq1.r = 0;
        list = list.iterator();
        s s1;
        while (list.hasNext()) 
        {
            s1 = (s)list.next();
        }
        if (true) goto _L4; else goto _L3
        list;
        chq chq1 = ceq1.d;
        String s2 = String.valueOf(cgl1);
        String s3 = String.valueOf(cgo1);
        chq1.a((new StringBuilder(String.valueOf(s2).length() + 35 + String.valueOf(s3).length())).append("Exception while sending message: ").append(s2).append("(").append(s3).append(")").toString(), list);
_L3:
        int i1 = ceq1.r + 1;
        ceq1.r = i1;
        if (i1 < 2)
        {
            cgl1 = ceq1.d;
            int j1 = ceq1.r;
            cgl1.a((new StringBuilder(50)).append("Increasing recent errors and retrying: ").append(j1).toString());
            return;
        } else
        {
            ceq1.d.b("Too many errors on sending %s(%s). Reconnecting...", new Object[] {
                cgl1.toString(), cgo1.toString()
            });
            ceq1.b();
            return;
        }
    }

    static void a(ceq ceq1, List list, int i1)
    {
        a(list, i1);
    }

    static void a(ceq ceq1, CountDownLatch countdownlatch)
    {
        if (countdownlatch != null)
        {
            countdownlatch.countDown();
        }
    }

    private static void a(List list, int i1)
    {
        for (list = list.iterator(); list.hasNext(); list.next()) { }
    }

    static boolean a(ceq ceq1, boolean flag)
    {
        ceq1.h = false;
        return false;
    }

    static void b(ceq ceq1, boolean flag)
    {
        ceq1.c(false);
    }

    static boolean b(ceq ceq1)
    {
        return ceq1.h;
    }

    static void c(ceq ceq1)
    {
        ceq1.e();
    }

    static void c(ceq ceq1, boolean flag)
    {
        ceq1.d(false);
    }

    private void c(boolean flag)
    {
        e.a(true, flag);
    }

    static CountDownLatch d(ceq ceq1)
    {
        return ceq1.n;
    }

    private void d(boolean flag)
    {
        if (flag)
        {
            n = new CountDownLatch(1);
            i.sendBroadcast(cgi.f.a());
            return;
        } else
        {
            n.countDown();
            i.sendBroadcast(cgi.g.a());
            return;
        }
    }

    static boolean d(ceq ceq1, boolean flag)
    {
        ceq1.m = flag;
        return flag;
    }

    static cei e(ceq ceq1)
    {
        return ceq1.b;
    }

    private void e()
    {
        this;
        JVM INSTR monitorenter ;
        cex cex1;
        cex1 = (cex)p.peek();
        j = cex1;
        if (cex1 == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        java.util.concurrent.Future future = o.submit(new ceu(this));
        x = w.schedule(new cev(this, future), q, TimeUnit.MILLISECONDS);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static chq f(ceq ceq1)
    {
        return ceq1.d;
    }

    static boolean g(ceq ceq1)
    {
        return ceq1.m;
    }

    static cfa h(ceq ceq1)
    {
        return ceq1.e;
    }

    static void i(ceq ceq1)
    {
        ceq1.b();
    }

    static cex j(ceq ceq1)
    {
        return ceq1.j;
    }

    static Queue k(ceq ceq1)
    {
        return ceq1.p;
    }

    static ScheduledFuture l(ceq ceq1)
    {
        return ceq1.x;
    }

    static int m(ceq ceq1)
    {
        return ceq1.q;
    }

    static cen n(ceq ceq1)
    {
        return ceq1.f;
    }

    public final CountDownLatch a(cen cen)
    {
        b.a(cen);
        if (n.getCount() != 0L)
        {
            d.a("Already in the process of connecting. Ignoring connect request");
            return n;
        } else
        {
            f = cen;
            r = 0;
            d(true);
            s.countDown();
            (new cer(this, "asyncConnect")).start();
            return n;
        }
    }

    public final void a(cgl cgl1, cgo cgo1, List list)
    {
        this;
        JVM INSTR monitorenter ;
        p.offer(new cex(cgl1, cgo1, list));
        if (j == null)
        {
            e();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        cgl1;
        throw cgl1;
    }

    public final void a(boolean flag)
    {
        k.set(true);
        cex cex1;
        for (Iterator iterator = p.iterator(); iterator.hasNext(); a(cex1.b, 4))
        {
            cex1 = (cex)iterator.next();
            Object obj = d;
            obj = String.valueOf(cex1);
            (new StringBuilder(String.valueOf(obj).length() + 18)).append("Dropping message: ").append(((String) (obj)));
        }

        p.clear();
        if (u != null)
        {
            u.cancel();
            u = null;
        }
        try
        {
            n.await(3L, TimeUnit.SECONDS);
        }
        catch (InterruptedException interruptedexception)
        {
            d.a("Interrupted while waiting for BC to connect", interruptedexception);
        }
        if (n.getCount() > 0L)
        {
            d.b("Timed out while waiting for BC to connect. Will attempt stopping the connection.");
        }
        if (h)
        {
            c(flag);
        }
        b(false);
        d(false);
        i.sendBroadcast(cgi.a.a());
    }

    public final boolean a()
    {
        return n.getCount() != 0L;
    }

    void b()
    {
        b(false);
        d(false);
        c(false);
        if (k.get()) goto _L2; else goto _L1
_L1:
        if (!l) goto _L4; else goto _L3
_L3:
        l = false;
        a(f);
_L2:
        i.sendBroadcast(cgi.h.a());
        return;
_L4:
        Object obj = i;
        b.b(obj, "Call Network.setContext() before calling this method");
        obj = ((ConnectivityManager)((Context) (obj)).getSystemService("connectivity")).getActiveNetworkInfo();
        boolean flag;
        if (obj != null && ((NetworkInfo) (obj)).isConnected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            android.content.Intent intent = cgi.c.a();
            i.sendBroadcast(intent);
        }
        if (s.getCount() == 0L)
        {
            if (v << 1 < 0x3a980L)
            {
                v = v << 1;
            }
            d.a("Reconnecting in %dms.", new Object[] {
                Long.valueOf(v)
            });
            s = new CountDownLatch(1);
            u = new cew(this);
            t.schedule(u, v);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    void b(boolean flag)
    {
        h = flag;
        Context context = i;
        android.content.Intent intent;
        if (flag)
        {
            intent = cgi.d.a();
        } else
        {
            intent = cgi.e.a();
        }
        context.sendBroadcast(intent);
    }

    void d()
    {
        l = true;
        v = (int)(Math.random() * 1000D) + 2000;
    }

}
