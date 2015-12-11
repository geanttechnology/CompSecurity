// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.impl.ads.protocol.v13.SdkLogRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            hf, cr, gd, fp, 
//            fq, at, i, j, 
//            cf, fw, l, h, 
//            p, v, bc, g, 
//            ei, ej, cw, as, 
//            aw, fd, ba, ft, 
//            hp, ef, eo, ha, 
//            gw, gx, hq, aa, 
//            ce

public class cm
    implements hf
{

    private static final String a = com/flurry/sdk/cm.getSimpleName();
    private final Map b = Collections.synchronizedMap(new HashMap());
    private bc c;
    private h d;
    private g e;
    private ef f;
    private eo g;
    private File h;
    private fw i;
    private String j;

    public cm()
    {
    }

    private SdkLogRequest a(List list)
    {
        list = cr.a(list);
        if (list.isEmpty())
        {
            gd.a(3, a, "List of adLogs is empty");
            return null;
        } else
        {
            String s = fp.a().d();
            List list1 = cr.e();
            SdkLogRequest sdklogrequest = new SdkLogRequest();
            sdklogrequest.apiKey = s;
            sdklogrequest.adReportedIds = list1;
            sdklogrequest.sdkAdLogs = list;
            sdklogrequest.testDevice = false;
            sdklogrequest.agentTimestamp = System.currentTimeMillis();
            sdklogrequest.agentVersion = Integer.toString(fq.a());
            gd.a(3, a, (new StringBuilder()).append("Got ad log request:").append(sdklogrequest.toString()).toString());
            return sdklogrequest;
        }
    }

    static void a(cm cm1)
    {
        cm1.l();
    }

    static void b(cm cm1)
    {
        cm1.k();
    }

    private void b(List list)
    {
        at at1;
        for (list = list.iterator(); list.hasNext(); b.put(at1.b(), at1))
        {
            at1 = (at)list.next();
        }

    }

    static void c(cm cm1)
    {
        cm1.j();
    }

    private void j()
    {
        this;
        JVM INSTR monitorenter ;
        SdkLogRequest sdklogrequest = a(new ArrayList(b.values()));
        if (sdklogrequest == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        com.flurry.sdk.i.a().g().a(sdklogrequest, com.flurry.sdk.j.a().i(), fp.a().d(), (new StringBuilder()).append("").append(fq.a()).toString());
        m();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void k()
    {
        this;
        JVM INSTR monitorenter ;
        gd.a(4, a, "Saving AdLog data.");
        i.a(new ArrayList(b.values()));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void l()
    {
        this;
        JVM INSTR monitorenter ;
        List list;
        gd.a(4, a, "Loading AdLog data.");
        list = (List)i.a();
        if (list == null) goto _L2; else goto _L1
_L1:
        b(list);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!h.exists())
        {
            continue; /* Loop/switch isn't completed */
        }
        gd.a(4, a, "Legacy AdLog data found, converting.");
        list = com.flurry.sdk.l.b(h);
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        b(list);
        h.delete();
        k();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void m()
    {
        b.clear();
        i.b();
    }

    public at a(String s)
    {
        at at1 = (at)b.get(s);
        Object obj = at1;
        if (at1 == null)
        {
            s = new at(s);
            obj = s;
            if (b.size() < 32767)
            {
                b.put(s.b(), s);
                obj = s;
            }
        }
        return ((at) (obj));
    }

    public void a()
    {
        d.a();
        com.flurry.sdk.i.a().d().a();
        com.flurry.sdk.i.a().e().a();
        fp.a().b(new hq() {

            final cm a;

            public void safeRun()
            {
                cm.c(a);
            }

            
            {
                a = cm.this;
                super();
            }
        });
        fp.a().b(new hq() {

            final cm a;

            public void safeRun()
            {
                com.flurry.sdk.i.a().l().f();
            }

            
            {
                a = cm.this;
                super();
            }
        });
        fp.a().b(new hq() {

            final cm a;

            public void safeRun()
            {
                com.flurry.sdk.i.a().i().c();
            }

            
            {
                a = cm.this;
                super();
            }
        });
    }

    public void a(Context context)
    {
        c = new bc();
        d = new h();
        e = new g();
        e.a();
        f = new ei();
        g = new ej();
        h = context.getFileStreamPath(f());
        i = new fw(context.getFileStreamPath(g()), ".yflurryadlog.", 1, new ha() {

            final cm a;

            public gx a(int i1)
            {
                return new gw(new at.a(new as.a()));
            }

            
            {
                a = cm.this;
                super();
            }
        });
        j = cw.a(context);
        fp.a().b(new hq() {

            final cm a;

            public void safeRun()
            {
                cm.a(a);
            }

            
            {
                a = cm.this;
                super();
            }
        });
    }

    public void a(String s, aw aw1, boolean flag, Map map)
    {
        this;
        JVM INSTR monitorenter ;
        if (aw1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        gd.a(3, a, (new StringBuilder()).append("logAdEvent(").append(s).append(", ").append(aw1).append(", ").append(flag).append(", ").append(map).append(")").toString());
        a(s).a(new as(aw1.a(), flag, fd.a().f(), map));
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

    public bc b()
    {
        return c;
    }

    public void b(Context context)
    {
        d.b();
        com.flurry.sdk.i.a().k().b();
        fp.a().b(new hq() {

            final cm a;

            public void safeRun()
            {
                com.flurry.sdk.i.a().l().e();
            }

            
            {
                a = cm.this;
                super();
            }
        });
        fp.a().b(new hq() {

            final cm a;

            public void safeRun()
            {
                com.flurry.sdk.i.a().i().d();
            }

            
            {
                a = cm.this;
                super();
            }
        });
    }

    public g c()
    {
        return e;
    }

    public void c(Context context)
    {
        if (!ft.a().c())
        {
            com.flurry.sdk.i.a().d().d(context);
            com.flurry.sdk.i.a().e().c(context);
        }
        fp.a().b(new hq() {

            final cm a;

            public void safeRun()
            {
                cm.b(a);
            }

            
            {
                a = cm.this;
                super();
            }
        });
        fp.a().b(new hq() {

            final cm a;

            public void safeRun()
            {
                com.flurry.sdk.i.a().t();
            }

            
            {
                a = cm.this;
                super();
            }
        });
        fp.a().b(new hq() {

            final cm a;

            public void safeRun()
            {
                com.flurry.sdk.i.a().u();
            }

            
            {
                a = cm.this;
                super();
            }
        });
    }

    public ef d()
    {
        return f;
    }

    public eo e()
    {
        return g;
    }

    String f()
    {
        return (new StringBuilder()).append(".flurryadlog.").append(Integer.toString(fp.a().d().hashCode(), 16)).toString();
    }

    String g()
    {
        return (new StringBuilder()).append(".yflurryadlog.").append(Long.toString(hp.i(fp.a().d()), 16)).toString();
    }

    public void h()
    {
        this;
        JVM INSTR monitorenter ;
        fp.a().b(new hq() {

            final cm a;

            public void safeRun()
            {
                cm.c(a);
            }

            
            {
                a = cm.this;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public String i()
    {
        return j;
    }

}
