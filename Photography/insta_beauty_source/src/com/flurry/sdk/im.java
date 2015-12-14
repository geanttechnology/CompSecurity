// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.flurry.sdk:
//            kc, ik, kg, in, 
//            ij, il, io, js, 
//            jz, hl, kr, ii, 
//            ma, kb

public class im
{

    public static int a;
    public static int b;
    public static AtomicInteger c;
    static jz d;
    private static im f;
    private static Map g;
    private String e;
    private final AtomicInteger h = new AtomicInteger(0);
    private long i;
    private kb j;

    private im()
    {
        e = com/flurry/sdk/im.getSimpleName();
        j = new _cls1();
        g = new HashMap();
        c = new AtomicInteger(0);
        if (b == 0)
        {
            b = 0x927c0;
        }
        if (a == 0)
        {
            a = 15;
        }
        n();
        if (d == null)
        {
            q();
        }
        kc.a().a("com.flurry.android.sdk.NetworkStateEvent", j);
    }

    public static im a()
    {
        com/flurry/sdk/im;
        JVM INSTR monitorenter ;
        im im1;
        if (f == null)
        {
            f = new im();
        }
        im1 = f;
        com/flurry/sdk/im;
        JVM INSTR monitorexit ;
        return im1;
        Exception exception;
        exception;
        throw exception;
    }

    static String a(im im1)
    {
        return im1.e;
    }

    public static void a(int i1)
    {
        a = i1;
    }

    public static void b()
    {
        if (f != null)
        {
            kc.a().b("com.flurry.android.sdk.NetworkStateEvent", f.j);
            g.clear();
            g = null;
            f = null;
        }
    }

    public static void b(int i1)
    {
        b = i1;
    }

    static void b(im im1)
    {
        im1.o();
    }

    private void c(ik ik1)
    {
        ik1.d = true;
        ik1.a();
        c.incrementAndGet();
        ik1.g();
        kg.a(3, e, (new StringBuilder()).append(ik1.d()).append(" report to ").append(ik1.e()).append(" finalized.").toString());
        d();
        g();
    }

    static void f()
    {
        q();
    }

    private void g()
    {
        if (j() || k())
        {
            kg.a(3, e, "Threshold reached. Sending callback logging reports");
            l();
        }
    }

    private void h()
    {
        if (j())
        {
            kg.a(3, e, "Max Callback Attempts threshold reached. Sending callback logging reports");
            l();
        }
    }

    private void i()
    {
        if (k())
        {
            kg.a(3, e, "Time threshold reached. Sending callback logging reports");
            l();
        }
    }

    private boolean j()
    {
        return c.intValue() >= a;
    }

    private boolean k()
    {
        return System.currentTimeMillis() > i;
    }

    private void l()
    {
        Iterator iterator = c().iterator();
_L2:
        in in1;
        boolean flag;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        in1 = (in)iterator.next();
        Iterator iterator1 = in1.d().iterator();
        flag = false;
        do
        {
label0:
            {
                if (!iterator1.hasNext())
                {
                    break label0;
                }
                Iterator iterator2 = ((ij)iterator1.next()).a.iterator();
                boolean flag1 = flag;
                do
                {
                    flag = flag1;
                    if (!iterator2.hasNext())
                    {
                        break;
                    }
                    ik ik1 = (ik)iterator2.next();
                    if (ik1.j)
                    {
                        iterator2.remove();
                    } else
                    if (!ik1.f.equals(il.d))
                    {
                        ik1.j = true;
                        flag1 = true;
                    }
                } while (true);
            }
        } while (true);
        if (flag)
        {
            io.a().a(in1);
        }
        if (true) goto _L2; else goto _L1
_L1:
        io.a().c();
        i = System.currentTimeMillis() + (long)b;
        o();
        m();
        c = new AtomicInteger(0);
        d();
        return;
    }

    private void m()
    {
        List list = c();
        int i1 = 0;
        while (i1 < list.size()) 
        {
            in in1 = (in)list.get(i1);
            if (in1.f())
            {
                c(in1.a());
            } else
            {
                List list1 = in1.d();
                int j1 = 0;
                while (j1 < list1.size()) 
                {
                    Object obj = (ij)list1.get(j1);
                    if (((ij) (obj)).n())
                    {
                        in1.e().remove(Long.valueOf(((ij) (obj)).e()));
                    } else
                    {
                        obj = ((ij) (obj)).a.iterator();
                        while (((Iterator) (obj)).hasNext()) 
                        {
                            if (((ik)((Iterator) (obj)).next()).j)
                            {
                                ((Iterator) (obj)).remove();
                            }
                        }
                    }
                    j1++;
                }
            }
            i1++;
        }
    }

    private void n()
    {
        i = js.a().c().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getLong("timeToSendNextPulseReport", 0L);
    }

    private void o()
    {
        android.content.SharedPreferences.Editor editor = js.a().c().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        editor.putLong("timeToSendNextPulseReport", i);
        editor.commit();
    }

    private int p()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = h.incrementAndGet();
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    private static void q()
    {
        d = new jz(js.a().c().getFileStreamPath(".yflurryanongoingpulsecallbackreporter"), ".yflurryanongoingpulsecallbackreporter", 2, new _cls6());
    }

    public void a(ik ik1)
    {
        this;
        JVM INSTR monitorenter ;
        kg.a(3, e, (new StringBuilder()).append(ik1.d()).append(" report sent successfully to ").append(ik1.e()).toString());
        ik1.f = il.a;
        ik1.g = "";
        c(ik1);
        if (kg.c() <= 3 && kg.d())
        {
            js.a().a(new _cls4(ik1));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ik1;
        throw ik1;
    }

    public void a(in in1)
    {
        this;
        JVM INSTR monitorenter ;
        if (in1 != null) goto _L2; else goto _L1
_L1:
        kg.a(3, e, "Must add valid PulseCallbackAsyncReportInfo");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        kg.a(3, e, (new StringBuilder()).append("Adding and sending ").append(in1.c()).append(" report to PulseCallbackManager.").toString());
        if (in1.d().size() != 0)
        {
            if (i == 0L)
            {
                i = System.currentTimeMillis() + (long)b;
                js.a().b(new _cls2());
            }
            int i1 = p();
            in1.a(i1);
            g.put(Integer.valueOf(i1), in1);
            in1 = in1.d().iterator();
            while (in1.hasNext()) 
            {
                hl.a().e().b((kr)in1.next());
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        in1;
        throw in1;
    }

    public boolean a(ik ik1, String s)
    {
        this;
        JVM INSTR monitorenter ;
        ik1.h = ik1.h + 1;
        ik1.i = System.currentTimeMillis();
        if (!ik1.c() && !TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        kg.a(3, e, (new StringBuilder()).append("Maximum number of redirects attempted. Aborting: ").append(ik1.d()).append(" report to ").append(ik1.e()).toString());
        boolean flag = false;
        ik1.f = il.c;
        ik1.g = "";
        c(ik1);
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        kg.a(3, e, (new StringBuilder()).append("Report to ").append(ik1.e()).append(" redirecting to url: ").append(s).toString());
        flag = true;
        ik1.a(s);
        d();
        if (true) goto _L4; else goto _L3
_L3:
        ik1;
        throw ik1;
    }

    public void b(ik ik1)
    {
        this;
        JVM INSTR monitorenter ;
        kg.a(3, e, (new StringBuilder()).append("Maximum number of attempts reached. Aborting: ").append(ik1.d()).toString());
        ik1.f = il.b;
        ik1.i = System.currentTimeMillis();
        ik1.g = "";
        c(ik1);
        this;
        JVM INSTR monitorexit ;
        return;
        ik1;
        throw ik1;
    }

    public void b(in in1)
    {
        this;
        JVM INSTR monitorenter ;
        if (in1 != null) goto _L2; else goto _L1
_L1:
        kg.a(3, e, "Must add valid PulseCallbackAsyncReportInfo");
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (i == 0L)
        {
            i = System.currentTimeMillis() + (long)b;
            js.a().b(new _cls3());
        }
        int i1 = p();
        in1.a(i1);
        g.put(Integer.valueOf(i1), in1);
        for (Iterator iterator = in1.d().iterator(); iterator.hasNext();)
        {
            Iterator iterator1 = ((ij)iterator.next()).a.iterator();
            while (iterator1.hasNext()) 
            {
                ik ik1 = (ik)iterator1.next();
                c.incrementAndGet();
                h();
            }
        }

        break MISSING_BLOCK_LABEL_156;
        in1;
        throw in1;
        i();
        kg.a(3, e, (new StringBuilder()).append("Restoring ").append(in1.c()).append(" report to PulseCallbackManager. ").append("Number of stored completed callbacks: ").append(c.get()).toString());
          goto _L3
    }

    public boolean b(ik ik1, String s)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        ik1.f = il.c;
        ik1.i = System.currentTimeMillis();
        String s1;
        s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        ik1.g = s1;
        if (!ik1.b()) goto _L2; else goto _L1
_L1:
        kg.a(3, e, (new StringBuilder()).append("Maximum number of attempts reached. Aborting: ").append(ik1.d()).append(" report to ").append(ik1.e()).toString());
        c(ik1);
_L3:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (ma.h(ik1.f()))
        {
            break MISSING_BLOCK_LABEL_154;
        }
        kg.a(3, e, (new StringBuilder()).append("Url: ").append(ik1.f()).append(" is invalid.").toString());
        c(ik1);
          goto _L3
        ik1;
        throw ik1;
        kg.a(3, e, (new StringBuilder()).append("Retrying callback to ").append(ik1.d()).append(" in: ").append(ik1.l.g() / 1000L).append(" seconds.").toString());
        flag = true;
        ik1.a();
        c.incrementAndGet();
        d();
        g();
          goto _L3
    }

    public List c()
    {
        return new ArrayList(g.values());
    }

    public void c(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        kg.a(3, e, (new StringBuilder()).append("Removing report ").append(i1).append(" from PulseCallbackManager").toString());
        g.remove(Integer.valueOf(i1));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void d()
    {
        js.a().b(new _cls5());
    }

    public List e()
    {
        if (d == null)
        {
            q();
        }
        return (List)d.a();
    }

    private class _cls1
        implements kb
    {

        final im a;

        public void a(jk jk1)
        {
            kg.a(4, im.a(a), (new StringBuilder()).append("onNetworkStateChanged : isNetworkEnable = ").append(jk1.a).toString());
            class _cls1
                implements Runnable
            {

                final _cls1 a;

                public void run()
                {
                    io.a().c();
                }

                _cls1()
                {
                    a = _cls1.this;
                    super();
                }
            }

            if (jk1.a)
            {
                js.a().b(new _cls1());
            }
        }

        public volatile void a(ka ka)
        {
            a((jk)ka);
        }

        _cls1()
        {
            a = im.this;
            super();
        }
    }


    private class _cls6
        implements le
    {

        public lb a(int i1)
        {
            return new la(new in.a());
        }

        _cls6()
        {
        }
    }


    private class _cls4
        implements Runnable
    {

        final ik a;
        final im b;

        public void run()
        {
            Toast.makeText(js.a().c(), (new StringBuilder()).append("PulseCallbackReportInfo HTTP Response Code: ").append(a.e).append(" for url: ").append(a.f()).toString(), 1).show();
        }

        _cls4(ik ik1)
        {
            b = im.this;
            a = ik1;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final im a;

        public void run()
        {
            im.b(a);
        }

        _cls2()
        {
            a = im.this;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final im a;

        public void run()
        {
            im.b(a);
        }

        _cls3()
        {
            a = im.this;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final im a;

        public void run()
        {
            List list = im.a().c();
            if (im.d == null)
            {
                im.f();
            }
            im.d.a(list);
        }

        _cls5()
        {
            a = im.this;
            super();
        }
    }

}
