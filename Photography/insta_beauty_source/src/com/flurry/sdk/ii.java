// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.sdk:
//            ks, ij, kg, im, 
//            kn, ma, jq, jz, 
//            js, je, ik, iq, 
//            kx, in, kr

public class ii extends ks
{

    public static long a;
    private static final String b = com/flurry/sdk/ii.getSimpleName();

    public ii()
    {
        a(30000L);
    }

    static void a(ii ii1, ik ik1, ij ij1)
    {
        ii1.b(ik1, ij1);
    }

    static void a(ii ii1, ik ik1, ij ij1, kn kn1)
    {
        ii1.a(ik1, ij1, kn1);
    }

    static void a(ii ii1, ik ik1, ij ij1, String s)
    {
        ii1.a(ik1, ij1, s);
    }

    private void a(ik ik1, ij ij1)
    {
        kg.a(3, b, (new StringBuilder()).append(ij1.m()).append(" report sent successfully to : ").append(ij1.i()).toString());
        im.a().a(ik1);
        c(ij1);
    }

    private void a(ik ik1, ij ij1, kn kn1)
    {
        Object obj = null;
        List list = kn1.b("Location");
        String s = obj;
        if (list != null)
        {
            s = obj;
            if (list.size() > 0)
            {
                s = ma.b((String)list.get(0), ij1.s());
            }
        }
        boolean flag = im.a().a(ik1, s);
        if (flag)
        {
            kg.a(3, b, (new StringBuilder()).append("Received redirect url. Retrying: ").append(s).toString());
        } else
        {
            kg.a(3, b, "Received redirect url. Retrying: false");
        }
        if (flag)
        {
            ij1.c(s);
            kn1.a(s);
            kn1.c("Location");
            jq.a().a(this, kn1);
            return;
        } else
        {
            c(ij1);
            return;
        }
    }

    private void a(ik ik1, ij ij1, String s)
    {
        boolean flag = im.a().b(ik1, s);
        kg.a(3, b, (new StringBuilder()).append("Failed report retrying: ").append(flag).toString());
        if (flag)
        {
            d(ij1);
            return;
        } else
        {
            c(ij1);
            return;
        }
    }

    static String b()
    {
        return b;
    }

    static void b(ii ii1, ik ik1, ij ij1)
    {
        ii1.a(ik1, ij1);
    }

    private void b(ik ik1, ij ij1)
    {
        im.a().b(ik1);
        c(ij1);
    }

    protected jz a()
    {
        return new jz(js.a().c().getFileStreamPath(".yflurryanpulsecallbackreporter"), ".yflurryanpulsecallbackreporter", 2, new _cls1());
    }

    protected void a(ij ij1)
    {
        kg.a(3, b, (new StringBuilder()).append("Sending next pulse report to ").append(ij1.i()).append(" at: ").append(ij1.t()).toString());
        long l1 = je.a().d();
        long l = l1;
        if (l1 == 0L)
        {
            l = a;
        }
        long l2 = je.a().g();
        l1 = l2;
        if (l2 == 0L)
        {
            l1 = System.currentTimeMillis() - l;
        }
        ik ik1 = new ik(ij1, l, l1, ij1.r());
        kn kn1 = new kn();
        kn1.a(ij1.t());
        kn1.d(0x186a0);
        Map map;
        if (ij1.f().equals(iq.c))
        {
            kn1.a(new kx());
            if (ij1.l() != null)
            {
                kn1.a(ij1.l().getBytes());
            }
            kn1.a(kp.a.c);
        } else
        {
            kn1.a(kp.a.b);
        }
        kn1.a(ij1.j() * 1000);
        kn1.b(ij1.k() * 1000);
        kn1.c(true);
        kn1.a(true);
        kn1.c((ij1.j() + ij1.k()) * 1000);
        map = ij1.h();
        if (map != null)
        {
            String s;
            for (Iterator iterator = ij1.h().keySet().iterator(); iterator.hasNext(); kn1.a(s, (String)map.get(s)))
            {
                s = (String)iterator.next();
            }

        }
        kn1.b(false);
        kn1.a(new _cls2(ij1, ik1));
        jq.a().a(this, kn1);
    }

    protected volatile void a(kr kr)
    {
        a((ij)kr);
    }

    protected void a(List list)
    {
        this;
        JVM INSTR monitorenter ;
        im.a().d();
        this;
        JVM INSTR monitorexit ;
        return;
        list;
        throw list;
    }

    protected void b(List list)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = im.a().e();
        if (obj != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (((List) (obj)).size() == 0) goto _L1; else goto _L3
_L3:
        kg.a(3, b, (new StringBuilder()).append("Restoring ").append(((List) (obj)).size()).append(" from report queue.").toString());
        in in1;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); im.a().b(in1))
        {
            in1 = (in)((Iterator) (obj)).next();
        }

        break MISSING_BLOCK_LABEL_104;
        list;
        throw list;
        Iterator iterator = im.a().c().iterator();
        while (iterator.hasNext()) 
        {
            Iterator iterator1 = ((in)iterator.next()).d().iterator();
            while (iterator1.hasNext()) 
            {
                ij ij1 = (ij)iterator1.next();
                if (!ij1.n())
                {
                    kg.a(3, b, (new StringBuilder()).append("Callback for ").append(ij1.m()).append(" to ").append(ij1.i()).append(" not completed.  Adding to reporter queue.").toString());
                    list.add(ij1);
                }
            }
        }
          goto _L1
    }


    private class _cls1
        implements le
    {

        final ii a;

        public lb a(int i)
        {
            return new la(new ij.a());
        }

        _cls1()
        {
            a = ii.this;
            super();
        }
    }


    private class _cls2
        implements kn.a
    {

        final ij a;
        final ik b;
        final ii c;

        public volatile void a(kn kn1, Object obj)
        {
            a(kn1, (String)obj);
        }

        public void a(kn kn1, String s)
        {
            kg.a(3, ii.b(), (new StringBuilder()).append("Pulse report to ").append(a.i()).append(" for ").append(a.m()).append(", HTTP status code is: ").append(kn1.h()).toString());
            int i = kn1.h();
            b.a((int)kn1.c());
            b.e = i;
            if (!kn1.f())
            {
                Exception exception = kn1.j();
                if (kn1.d())
                {
                    if (kn1.i())
                    {
                        kg.a(3, ii.b(), (new StringBuilder()).append("Timeout occured when trying to connect to: ").append(a.i()).append(". Exception: ").append(kn1.j().getMessage()).toString());
                    } else
                    {
                        kg.a(3, ii.b(), (new StringBuilder()).append("Manually managed http request timeout occured for: ").append(a.i()).toString());
                    }
                    ii.a(c, b, a);
                    return;
                } else
                {
                    kg.a(3, ii.b(), (new StringBuilder()).append("Error occured when trying to connect to: ").append(a.i()).append(". Exception: ").append(exception.getMessage()).toString());
                    ii.a(c, b, a, s);
                    return;
                }
            }
            if (i >= 200 && i < 300)
            {
                ii.b(c, b, a);
                return;
            }
            if (i >= 300 && i < 400)
            {
                ii.a(c, b, a, kn1);
                return;
            } else
            {
                kg.a(3, ii.b(), (new StringBuilder()).append(a.m()).append(" report failed sending to : ").append(a.i()).toString());
                ii.a(c, b, a, s);
                return;
            }
        }

        _cls2(ij ij1, ik ik1)
        {
            c = ii.this;
            a = ij1;
            b = ik1;
            super();
        }
    }

}
