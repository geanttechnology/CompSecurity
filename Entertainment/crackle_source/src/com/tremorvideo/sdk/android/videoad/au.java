// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import android.os.SystemClock;
import com.tremorvideo.sdk.android.adapter.TremorAdapterCalls;
import java.io.File;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ad, y, bf, av, 
//            bg, bk, bj, bi, 
//            bl, bm, bn, n, 
//            br, bh, u, t, 
//            ac, bt

public class au
    implements bf.a
{
    class a extends Thread
    {

        final au a;

        public void run()
        {
_L3:
            try
            {
                if (au.a(a))
                {
                    au.b(a);
                }
            }
            catch (Exception exception)
            {
                ad.a(exception);
            }
            this;
            JVM INSTR monitorenter ;
            if (!au.c(a))
            {
                break MISSING_BLOCK_LABEL_45;
            }
            this;
            JVM INSTR monitorexit ;
            ad.d("Background thread exited");
            return;
            if (au.a(a)) goto _L2; else goto _L1
_L1:
            ad.d("Download manager stopped");
            wait();
_L5:
            this;
            JVM INSTR monitorexit ;
              goto _L3
            Exception exception1;
            exception1;
            this;
            JVM INSTR monitorexit ;
            try
            {
                throw exception1;
            }
            catch (InterruptedException interruptedexception)
            {
                ad.a(interruptedexception);
            }
              goto _L3
_L2:
            if (!au.d(a)) goto _L5; else goto _L4
_L4:
            ad.d("Download manager will be idle until next signal");
            if (!a.n)
            {
                a.l = true;
            }
            wait();
              goto _L5
        }

        a()
        {
            a = au.this;
            super();
        }
    }

    class b
    {

        int a;
        long b;
        long c;
        long d;
        boolean e;
        String f;
        final au g;

        public b()
        {
            g = au.this;
            super();
            c = 0L;
            d = 0L;
            e = true;
            f = null;
        }
    }

    public static interface c
    {

        public abstract void a(n n1);

        public abstract void h();

        public abstract void j();

        public abstract void l();

        public abstract void m();

        public abstract void n();
    }


    bf a;
    String b;
    av c;
    String d;
    av e;
    n f;
    boolean g;
    List h;
    int i;
    long j;
    boolean k;
    boolean l;
    boolean m;
    boolean n;
    c o;
    private Map p;
    private Map q;
    private List r;
    private n s;
    private av t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private Context y;
    private Thread z;

    public au(Context context, String s1)
    {
        int i1 = 0;
        super();
        w = false;
        x = false;
        j = 0L;
        z = null;
        b = s1;
        y = context;
        r = new ArrayList();
        q = new HashMap();
        p = new HashMap();
        u = false;
        v = false;
        i = 0;
        s1 = ad.s();
        for (int j1 = s1.length; i1 < j1; i1++)
        {
            Object obj = s1[i1];
            r.add(obj);
            q.put(obj, new b());
        }

        (new y(context.getFilesDir())).b();
    }

    private void a(bf bf1, boolean flag, boolean flag1)
    {
        ad.d(" ");
        if (flag)
        {
            ad.a(ad.d.b, (new StringBuilder()).append("Re-Starting Job: ").append(bf1.toString()).toString());
        } else
        {
            ad.a(ad.d.b, (new StringBuilder()).append("Starting Job: ").append(bf1.toString()).toString());
        }
        a = bf1;
        if (flag)
        {
            a.d();
            return;
        } else
        {
            a.b();
            return;
        }
    }

    private void a(br br1)
    {
        if (p.containsKey(d))
        {
            ad.d("onRequestDownloaded removing request");
            p.remove(d);
        }
        e = new av(br1, d);
        p.put(d, e);
        ad.d((new StringBuilder()).append(" onRequestDownloaded _ActiveChannel=").append(d).append(" _Requests.size()=").append(p.size()).toString());
        a(e.f());
    }

    private void a(n.a a1)
    {
        if (a1.a == bf.d.a)
        {
            a1 = new bg(this, y, a1.b, a1.c);
        } else
        if (a1.a == bf.d.b)
        {
            a1 = new bk(this, y, a1.c);
        } else
        if (a1.a == bf.d.e)
        {
            a1 = new bj(this, y, a1.c);
        } else
        if (a1.a == bf.d.c)
        {
            a1 = new bi(this, y, f);
        } else
        if (a1.a == bf.d.f)
        {
            a1 = new bl(this, y, f);
        } else
        if (a1.a == bf.d.g)
        {
            a1 = new bm(this, y, f, a1.c);
        } else
        if (a1.a == bf.d.h)
        {
            a1 = new bn(this, y, f);
        } else
        {
            a1 = null;
        }
        if (a1 != null)
        {
            a(((bf) (a1)), false, false);
            return;
        } else
        {
            u = false;
            a = null;
            return;
        }
    }

    private void a(n n1)
    {
        if (o != null)
        {
            o.a(n1);
        }
        h = n1.a();
        i = 0;
        f = n1;
        g = false;
        if (h.size() > 0)
        {
            a((n.a)h.get(0));
        } else
        {
            m();
            if (ad.e == 0)
            {
                d();
                return;
            }
        }
    }

    private void a(String s1, av av1, n n1)
    {
        ad.d("Dumping Unusable Ad.");
        n1.c();
        a(av1, n1);
        f(s1);
    }

    static boolean a(au au1)
    {
        return au1.u;
    }

    static void b(au au1)
    {
        au1.p();
    }

    private boolean b(n n1)
    {
        long l1 = ad.D();
        if (n1.w() > 0L && l1 - n1.x() >= n1.w())
        {
            ad.d("Ad is expired because its lifetime has elapsed.");
            return true;
        }
        if ((new GregorianCalendar()).after(n1.e()))
        {
            ad.d("Ad is expired because it cache date has elapsed.");
            return true;
        } else
        {
            return false;
        }
    }

    static boolean c(au au1)
    {
        return au1.w;
    }

    static boolean d(au au1)
    {
        return au1.x;
    }

    private boolean h(String s1)
    {
        s1 = (b)q.get(s1);
        return ((b) (s1)).a >= 5 && ad.D() - ((b) (s1)).b < 60000L;
    }

    private String i()
    {
        int i1 = 0;
        do
        {
            if (i1 >= 2)
            {
                break;
            }
            for (Iterator iterator = r.iterator(); iterator.hasNext();)
            {
                String s1 = (String)iterator.next();
                if (i1 == 1)
                {
                    return s1;
                }
                if (((b)q.get(s1)).f != null)
                {
                    return s1;
                }
            }

            i1++;
        } while (true);
        return null;
    }

    private boolean i(String s1)
    {
        if (h(s1))
        {
            ad.d((new StringBuilder()).append(s1).append(" is closed because of too many calls this minute").toString());
            TremorAdapterCalls.onGetAdFailed();
            return false;
        }
        b b1 = (b)q.get(s1);
        if (!b1.e)
        {
            ad.d((new StringBuilder()).append(s1).append(" is closed because of no ad match").toString());
            TremorAdapterCalls.onGetAdFailed();
            return false;
        }
        long l1 = ad.D();
        if (l1 - b1.c <= b1.d)
        {
            long l2 = b1.d;
            long l3 = b1.c;
            ad.d((new StringBuilder()).append(s1).append(" is closed because of built in call delay: ").append(l2 - (l1 - l3)).append("ms remaining.").toString());
            return false;
        } else
        {
            return true;
        }
    }

    private String j()
    {
        int i1 = 0;
label0:
        do
        {
label1:
            {
                if (i1 >= 2)
                {
                    break label0;
                }
                String s1;
label2:
                do
                {
                    for (Iterator iterator = r.iterator(); iterator.hasNext();)
                    {
                        s1 = (String)iterator.next();
                        while (!p.containsKey(s1) && (ad.e == 1 || i(s1))) 
                        {
                            if (i1 == 1)
                            {
                                return s1;
                            }
                            continue label2;
                        }
                    }

                    break label1;
                } while (((b)q.get(s1)).f == null);
                return s1;
            }
            i1++;
        } while (true);
        return null;
    }

    private String j(String s1)
    {
        return (new StringBuilder()).append(s1).append("precached").toString();
    }

    private av k()
    {
        for (Iterator iterator = r.iterator(); iterator.hasNext();)
        {
            Object obj = (String)iterator.next();
            obj = (av)p.get(obj);
            if (obj != null && !((av) (obj)).c())
            {
                return ((av) (obj));
            }
        }

        return null;
    }

    private void l()
    {
        z = new a();
        z.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            final au a;

            public void uncaughtException(Thread thread, Throwable throwable)
            {
                ad.a(throwable);
            }

            
            {
                a = au.this;
                super();
            }
        });
        z.start();
    }

    private void m()
    {
        if (r.size() == 1)
        {
            ad.d("Pre loading ad...");
            e.f().a(y);
            if (!e.f().k)
            {
                a(d, e, e.f());
            }
        }
        n n1 = e.d();
        if (o != null)
        {
            o.l();
        }
        if (ad.e == 1)
        {
            u = false;
        }
        TremorAdapterCalls.onAdReady();
        com.tremorvideo.sdk.android.videoad.y.a(n1);
        e = null;
        f = null;
        i = 0;
        d = null;
        h = null;
    }

    private boolean n()
    {
label0:
        {
            n.a a1 = (n.a)h.get(i);
            a.a(a1.b, f);
            o();
            a = null;
            i = i + 1;
            if (i < h.size())
            {
                a((n.a)h.get(i));
                break label0;
            }
            try
            {
                m();
                if (ad.e == 0)
                {
                    d();
                }
            }
            catch (Exception exception)
            {
                ad.a(exception);
                return true;
            }
        }
        return false;
    }

    private void o()
    {
        if (!g && f != null && f.m())
        {
            g = true;
            (new y(y.getFilesDir().getAbsoluteFile())).d(f);
        }
    }

    private void p()
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        ad.d("processCurrentJob:beginNewDownload");
        d();
        flag1 = false;
        flag2 = false;
        flag3 = false;
        flag = false;
        flag4 = false;
_L14:
        if (flag)
        {
            a = null;
            e = null;
            f = null;
            n = true;
        }
        if (!flag4) goto _L4; else goto _L3
_L3:
        if (e == null || ad.e != 0 || e.i().b().size() <= 0) goto _L6; else goto _L5
_L5:
        e.j();
        if (e.e()) goto _L6; else goto _L7
_L7:
        flag = false;
_L12:
        if (flag)
        {
            if (ad.e == 0 && e != null)
            {
                p.remove(e.h());
            }
            synchronized (z)
            {
                ((b)q.get(d)).d = 10000L;
                ((b)q.get(d)).e = false;
            }
            e = null;
        }
        f = null;
        a = null;
        n = true;
        if (!flag3) goto _L9; else goto _L8
_L8:
        ad.d("NEW REQUEST ERROR/TIMEOUT");
        u = false;
        o.j();
_L4:
        return;
_L2:
        if (a.a() == bf.b.e)
        {
            ad.d("_CurrentJob CANCELLED");
            if (ad.e == 0)
            {
                a(a, true, true);
                flag1 = false;
                flag2 = false;
                flag3 = false;
                flag = false;
                flag4 = false;
            } else
            {
                flag1 = false;
                flag2 = false;
                flag3 = false;
                flag = true;
                flag4 = false;
            }
        } else
        if (a.a() == bf.b.b)
        {
            if (a instanceof bh)
            {
                synchronized (z)
                {
                    if (d != null)
                    {
                        ((b)q.get(d)).d = 2000L;
                    }
                }
                a(((bh)a).h());
                o();
                k = true;
                if (o == null)
                {
                    break; /* Loop/switch isn't completed */
                }
                o.h();
                flag1 = false;
                flag2 = false;
                flag3 = false;
                flag = false;
                flag4 = false;
            } else
            {
                flag4 = n();
                flag1 = false;
                flag2 = false;
                flag3 = false;
                flag = false;
            }
        } else
        if (a.a() == bf.b.d || a.a() == bf.b.c)
        {
            if (a instanceof bh)
            {
                if (ad.e == 1)
                {
                    flag = false;
                    flag1 = true;
                } else
                {
                    flag = false;
                    flag1 = false;
                }
            } else
            {
                flag = true;
                flag1 = false;
            }
            flag2 = flag;
            flag3 = flag1;
            flag4 = true;
            flag = false;
            flag1 = false;
        } else
        {
            if (a.a() != bf.b.f)
            {
                break; /* Loop/switch isn't completed */
            }
            if (a instanceof bh)
            {
                if (ad.e == 1)
                {
                    flag = false;
                    flag1 = true;
                } else
                {
                    flag = false;
                    flag1 = false;
                }
            } else
            {
                flag = true;
                flag1 = false;
            }
            flag2 = false;
            flag3 = flag1;
            flag4 = true;
            flag1 = flag;
            flag = false;
        }
        continue; /* Loop/switch isn't completed */
        exception;
        thread;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        thread;
        JVM INSTR monitorexit ;
        throw exception1;
_L9:
        if (ad.e == 1 && (flag2 || flag1))
        {
            if (flag2)
            {
                ad.d("NEW ASEET DOWNLOAD  ERROR");
                u = false;
                if (p.containsKey(d))
                {
                    p.remove(d);
                }
                if (o != null)
                {
                    o.m();
                }
            } else
            if (flag1)
            {
                ad.d("NEW ASSET DOWNLOAD  TIMEOUT");
                if (o != null)
                {
                    o.n();
                }
            }
        }
        if (ad.e != 0) goto _L4; else goto _L10
_L10:
        d();
        return;
_L6:
        flag = true;
        if (true) goto _L12; else goto _L11
_L11:
        flag1 = false;
        flag2 = false;
        flag3 = false;
        flag = false;
        flag4 = false;
        if (true) goto _L14; else goto _L13
_L13:
    }

    public void a()
    {
        if (z != null)
        {
            synchronized (z)
            {
                u = false;
                w = true;
                if (a != null)
                {
                    a.c();
                }
                z.notify();
            }
            return;
        } else
        {
            return;
        }
        exception;
        thread;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(av av1, n n1)
    {
        this;
        JVM INSTR monitorenter ;
        av1.a();
        if (av1.e())
        {
            ad.d("removeAdFromRequest removing request");
            p.remove(av1.h());
        }
        this;
        JVM INSTR monitorexit ;
        com.tremorvideo.sdk.android.videoad.y.b(n1);
        return;
        av1;
        this;
        JVM INSTR monitorexit ;
        throw av1;
    }

    public void a(bf bf1)
    {
        ad.a(ad.d.b, (new StringBuilder()).append("Job ").append(bf1.a().name()).append(": ").append(bf1.toString()).toString());
    }

    public void a(String s1, String s2)
    {
        s1 = j(s1);
        b b1 = new b();
        b1.f = s2;
        r.add(s1);
        q.put(s1, b1);
    }

    public void a(boolean flag)
    {
        m = flag;
        if (z != null) goto _L2; else goto _L1
_L1:
        u = true;
        l();
_L4:
        return;
_L2:
        if (u) goto _L4; else goto _L3
_L3:
        Thread thread = z;
        thread;
        JVM INSTR monitorenter ;
        for (Iterator iterator = q.keySet().iterator(); iterator.hasNext();)
        {
            String s1 = (String)iterator.next();
            ((b)q.get(s1)).e = true;
        }

        break MISSING_BLOCK_LABEL_97;
        Exception exception;
        exception;
        thread;
        JVM INSTR monitorexit ;
        throw exception;
        u = true;
        z.notify();
        thread;
        JVM INSTR monitorexit ;
        ad.d("Resuming Download Manager");
        return;
    }

    public void a(boolean flag, c c1)
    {
        o = c1;
        a(flag);
    }

    public boolean a(String s1)
    {
        if (b(s1))
        {
            return true;
        } else
        {
            return b(j(s1));
        }
    }

    public void b()
    {
        ad.d("Stopping Current Job");
        Object obj = ad.o();
        if (p.containsKey(obj))
        {
            obj = (av)p.get(obj);
            if (obj != null)
            {
                c = ((av) (obj));
            }
        }
        if (z != null)
        {
            synchronized (z)
            {
                if (u)
                {
                    u = false;
                    if (a != null)
                    {
                        a.c();
                    }
                }
                z.notify();
            }
            return;
        } else
        {
            return;
        }
        exception;
        thread;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean b(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        av av1;
        if (!p.containsKey(s1))
        {
            break MISSING_BLOCK_LABEL_65;
        }
        av1 = (av)p.get(s1);
        if (av1 == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        if (av1.b())
        {
            n n1 = av1.f();
            if (!b(n1))
            {
                break MISSING_BLOCK_LABEL_67;
            }
            TremorAdapterCalls.onGetAdFailed();
            a(s1, av1, n1);
        }
        return false;
        this;
        JVM INSTR monitorexit ;
        return true;
        s1;
        this;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public void c()
    {
        ad.d("Stopping Download Manager");
        String s1 = ad.o();
        if (p.containsKey(s1))
        {
            av av1 = (av)p.get(s1);
            if (av1 != null && av1.b())
            {
                a(s1, av1, av1.f());
            }
        }
        if (z != null)
        {
            synchronized (z)
            {
                if (u)
                {
                    u = false;
                    if (a != null)
                    {
                        a.c();
                    }
                }
            }
            return;
        } else
        {
            return;
        }
        exception;
        thread;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean c(String s1)
    {
        if (d(s1))
        {
            return true;
        } else
        {
            return d(j(s1));
        }
    }

    public void d()
    {
        long l1 = ad.D();
        Object obj = j();
        ad.d((new StringBuilder()).append("*beginNewDownload streamingAdRequest=").append(m).toString());
        if (ad.e == 1 && m)
        {
            obj = i();
            d = ((String) (obj));
            e = null;
            x = false;
            b b1 = (b)q.get(obj);
            if (l1 - b1.b >= 60000L)
            {
                b1.b = l1;
                b1.a = 0;
            }
            b1.a = b1.a + 1;
            b1.c = l1;
            String s1 = b;
            if (b1.f != null)
            {
                s1 = b1.f;
            }
            k = false;
            l = false;
            n = false;
            j = SystemClock.elapsedRealtime();
            a(new bh(this, ((String) (obj)), s1, m), false, false);
            return;
        }
        if (obj != null)
        {
            d = ((String) (obj));
            e = null;
            x = false;
            b b2 = (b)q.get(obj);
            if (l1 - b2.b >= 60000L)
            {
                b2.b = l1;
                b2.a = 0;
            }
            b2.a = b2.a + 1;
            b2.c = l1;
            String s2 = b;
            if (b2.f != null)
            {
                s2 = b2.f;
            }
            k = false;
            l = false;
            n = false;
            j = SystemClock.elapsedRealtime();
            a(new bh(this, ((String) (obj)), s2, m), false, false);
            return;
        }
        av av1 = k();
        if (av1 == null)
        {
            x = true;
            return;
        }
        obj = av1.g();
        if (obj != null)
        {
            d = av1.h();
            e = av1;
            x = false;
            a(((n) (obj)));
            return;
        } else
        {
            x = true;
            return;
        }
    }

    public boolean d(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        String s2 = s1;
        if (!p.containsKey(s1))
        {
            s2 = j(s1);
        }
        if (!p.containsKey(s2)) goto _L2; else goto _L1
_L1:
        s1 = (av)p.get(s2);
        if (s1 == null) goto _L2; else goto _L3
_L3:
        if (!s1.b()) goto _L2; else goto _L4
_L4:
        n n1 = s1.f();
        if (!b(n1)) goto _L6; else goto _L5
_L5:
        a(s2, s1, n1);
_L2:
        this;
        JVM INSTR monitorexit ;
        return false;
_L6:
        if (!(s1.f() instanceof u))
        {
            break MISSING_BLOCK_LABEL_99;
        }
        this;
        JVM INSTR monitorexit ;
        return true;
        if (!(s1.f() instanceof t))
        {
            break MISSING_BLOCK_LABEL_113;
        }
        this;
        JVM INSTR monitorexit ;
        return true;
        a(s2, s1, n1);
          goto _L2
        s1;
        this;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public n e()
    {
        return f;
    }

    public boolean e(String s1)
    {
        if (v) goto _L2; else goto _L1
_L1:
        ad.d((new StringBuilder()).append("Starting ad for ").append(s1).toString());
        av av1;
        n n1;
        boolean flag;
        if (b(s1))
        {
            ad.d("TremorDebug: startAdView - Ad is ready");
            flag = true;
        } else
        if (b(j(s1)))
        {
            ad.d("TremorDebug: startAdView - Ad is ready pre-cache channel");
            f(s1);
            s1 = j(s1);
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        ad.d("TremorDebug: startAdView - Ad was ready. Check expriry");
        av1 = (av)p.get(s1);
        n1 = av1.f();
        if (!b(n1)) goto _L6; else goto _L5
_L5:
        ad.d("TremorDebug: startAdView - Ad Expired and dumped.");
        a(s1, av1, n1);
_L8:
        ad.d("TremorDebug: startAdView - returning false");
        return false;
_L6:
        ad.d("TremorDebug: startAdView - Ad was good");
        s = n1;
        t = av1;
        v = true;
        ad.d("TremorDebug: startAdView - Returning true");
        return true;
_L4:
        ad.d("TremorDebug: startAdView - Ad was not ready");
        continue; /* Loop/switch isn't completed */
_L2:
        ad.d("TremorDebug: startAdView - ad view was aleady started!");
        if (true) goto _L8; else goto _L7
_L7:
    }

    public n f()
    {
        return s;
    }

    public void f(String s1)
    {
        ad.f().b();
        if (z != null)
        {
            synchronized (z)
            {
                ((b)q.get(s1)).e = true;
                z.notify();
            }
            return;
        } else
        {
            return;
        }
        s1;
        thread;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public br g()
    {
        if (t == null)
        {
            return null;
        } else
        {
            return t.i();
        }
    }

    public boolean g(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!p.containsKey(s1)) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        if (x)
        {
            return false;
        }
          goto _L3
_L2:
        if (d == null)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return true;
        this;
        JVM INSTR monitorexit ;
        return false;
        s1;
        this;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public void h()
    {
        if (v)
        {
            ad.d("onAdViewed");
            ad.f().b();
            ad.g().a();
            a(t, s);
            s = null;
            t = null;
            v = false;
            if (ad.e == 1)
            {
                m = false;
                if (c != null)
                {
                    ad.d("preservedRequest !=null");
                    p.put(ad.o(), c);
                    ad.d((new StringBuilder()).append(" onRequestDownloaded _ActiveChannel=").append(ad.o()).append(" _Requests.size()=").append(p.size()).toString());
                    c = null;
                    u = true;
                } else
                {
                    ad.d("preservedRequest is  false");
                    u = false;
                }
            }
            synchronized (z)
            {
                z.notify();
            }
        }
        return;
        exception;
        thread;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
