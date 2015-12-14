// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

// Referenced classes of package com.flurry.sdk:
//            li, lk, ll, kg, 
//            kc, lf, jw, lg, 
//            je, js, kb, lj, 
//            ka, jv, ly

public class lh
    implements ll.a
{

    private static lh a;
    private static final String b = com/flurry/sdk/lh.getSimpleName();
    private final Map c = new WeakHashMap();
    private final li d = new li();
    private final Object e = new Object();
    private long f;
    private long g;
    private lf h;
    private kb i;
    private kb j;

    private lh()
    {
        i = new kb() {

            final lh a;

            public volatile void a(ka ka)
            {
                a((lj)ka);
            }

            public void a(lj lj1)
            {
                lh.a(a);
            }

            
            {
                a = lh.this;
                super();
            }
        };
        j = new kb() {

            final lh a;

            public void a(jv jv1)
            {
                class _cls5
                {

                    static final int a[];

                    static 
                    {
                        a = new int[jv.a.values().length];
                        try
                        {
                            a[jv.a.e.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            a[jv.a.f.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            a[jv.a.b.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (_cls5.a[jv1.b.ordinal()])
                {
                default:
                    return;

                case 1: // '\001'
                    kg.a(3, lh.h(), (new StringBuilder()).append("Automatic onStartSession for context:").append(jv1.a).toString());
                    lh.a(a, jv1.a);
                    return;

                case 2: // '\002'
                    kg.a(3, lh.h(), (new StringBuilder()).append("Automatic onEndSession for context:").append(jv1.a).toString());
                    a.d(jv1.a);
                    return;

                case 3: // '\003'
                    kg.a(3, lh.h(), (new StringBuilder()).append("Automatic onEndSession (destroyed) for context:").append(jv1.a).toString());
                    break;
                }
                a.d(jv1.a);
            }

            public volatile void a(ka ka)
            {
                a((jv)ka);
            }

            
            {
                a = lh.this;
                super();
            }
        };
        lk lk1 = lk.a();
        f = 0L;
        g = ((Long)lk1.a("ContinueSessionMillis")).longValue();
        lk1.a("ContinueSessionMillis", this);
        kg.a(4, b, (new StringBuilder()).append("initSettings, ContinueSessionMillis = ").append(g).toString());
        kc.a().a("com.flurry.android.sdk.ActivityLifecycleEvent", j);
        kc.a().a("com.flurry.android.sdk.FlurrySessionTimerEvent", i);
    }

    public static lh a()
    {
        com/flurry/sdk/lh;
        JVM INSTR monitorenter ;
        lh lh1;
        if (a == null)
        {
            a = new lh();
        }
        lh1 = a;
        com/flurry/sdk/lh;
        JVM INSTR monitorexit ;
        return lh1;
        Exception exception;
        exception;
        throw exception;
    }

    private void a(lf lf1)
    {
        synchronized (e)
        {
            h = lf1;
        }
        return;
        lf1;
        obj;
        JVM INSTR monitorexit ;
        throw lf1;
    }

    static void a(lh lh1)
    {
        lh1.i();
    }

    static void a(lh lh1, Context context)
    {
        lh1.e(context);
    }

    static void a(lh lh1, lf lf1)
    {
        lh1.b(lf1);
    }

    public static void b()
    {
        com/flurry/sdk/lh;
        JVM INSTR monitorenter ;
        if (a != null)
        {
            kc.a().a(a.i);
            kc.a().a(a.j);
            lk.a().b("ContinueSessionMillis", a);
        }
        a = null;
        com/flurry/sdk/lh;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void b(lf lf1)
    {
        synchronized (e)
        {
            if (h == lf1)
            {
                h = null;
            }
        }
        return;
        lf1;
        obj;
        JVM INSTR monitorexit ;
        throw lf1;
    }

    private void e(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        if ((lf)c.get(context) == null) goto _L2; else goto _L1
_L1:
        if (!jw.a().c()) goto _L4; else goto _L3
_L3:
        kg.a(3, b, (new StringBuilder()).append("Session already started with context:").append(context).toString());
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        kg.e(b, (new StringBuilder()).append("Session already started with context:").append(context).toString());
          goto _L5
        context;
        throw context;
_L2:
        lf lf2;
        d.a();
        lf2 = e();
        lf lf1;
        lf1 = lf2;
        if (lf2 != null)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        lf1 = new lf();
        kg.e(b, (new StringBuilder()).append("Flurry session started for context:").append(context).toString());
        lg lg1 = new lg();
        lg1.a = new WeakReference(context);
        lg1.b = lf1;
        lg1.c = lg.a.a;
        lg1.b();
        c.put(context, lf1);
        a(lf1);
        kg.e(b, (new StringBuilder()).append("Flurry session resumed for context:").append(context).toString());
        lg lg2 = new lg();
        lg2.a = new WeakReference(context);
        lg2.b = lf1;
        lg2.c = lg.a.c;
        lg2.b();
        f = 0L;
          goto _L5
    }

    static String h()
    {
        return b;
    }

    private void i()
    {
        this;
        JVM INSTR monitorenter ;
        int k = d();
        if (k <= 0) goto _L2; else goto _L1
_L1:
        kg.a(5, b, (new StringBuilder()).append("Session cannot be finalized, sessionContextCount:").append(k).toString());
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj = e();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        kg.a(5, b, "Session cannot be finalized, current session not found");
          goto _L3
        obj;
        throw obj;
        kg.e(b, "Flurry session ended");
        lg lg1 = new lg();
        lg1.b = ((lf) (obj));
        lg1.c = lg.a.e;
        lg1.d = je.a().d();
        lg1.b();
        js.a().b(new ly(((lf) (obj))) {

            final lf a;
            final lh b;

            public void a()
            {
                lh.a(b, a);
            }

            
            {
                b = lh.this;
                a = lf1;
                super();
            }
        });
          goto _L3
    }

    public void a(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = context instanceof Activity;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (jw.a().c())
        {
            kg.a(3, b, (new StringBuilder()).append("bootstrap for context:").append(context).toString());
            e(context);
        }
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }

    public void a(String s, Object obj)
    {
        if (s.equals("ContinueSessionMillis"))
        {
            g = ((Long)obj).longValue();
            kg.a(4, b, (new StringBuilder()).append("onSettingUpdate, ContinueSessionMillis = ").append(g).toString());
            return;
        } else
        {
            kg.a(6, b, "onSettingUpdate internal error!");
            return;
        }
    }

    public void b(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        if (!jw.a().c()) goto _L2; else goto _L1
_L1:
        boolean flag = context instanceof Activity;
        if (!flag) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        kg.a(3, b, (new StringBuilder()).append("Manual onStartSession for context:").append(context).toString());
        e(context);
        if (true) goto _L3; else goto _L4
_L4:
        context;
        throw context;
    }

    public long c()
    {
        return f;
    }

    public void c(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        if (!jw.a().c()) goto _L2; else goto _L1
_L1:
        boolean flag = context instanceof Activity;
        if (!flag) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        kg.a(3, b, (new StringBuilder()).append("Manual onEndSession for context:").append(context).toString());
        d(context);
        if (true) goto _L3; else goto _L4
_L4:
        context;
        throw context;
    }

    public int d()
    {
        this;
        JVM INSTR monitorenter ;
        int k = c.size();
        this;
        JVM INSTR monitorexit ;
        return k;
        Exception exception;
        exception;
        throw exception;
    }

    void d(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        lf lf1 = (lf)c.remove(context);
        if (lf1 != null) goto _L2; else goto _L1
_L1:
        if (!jw.a().c()) goto _L4; else goto _L3
_L3:
        kg.a(3, b, (new StringBuilder()).append("Session cannot be ended, session not found for context:").append(context).toString());
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        kg.e(b, (new StringBuilder()).append("Session cannot be ended, session not found for context:").append(context).toString());
          goto _L5
        context;
        throw context;
_L2:
label0:
        {
            kg.e(b, (new StringBuilder()).append("Flurry session paused for context:").append(context).toString());
            lg lg1 = new lg();
            lg1.a = new WeakReference(context);
            lg1.b = lf1;
            lg1.d = je.a().d();
            lg1.c = lg.a.d;
            lg1.b();
            if (d() != 0)
            {
                break label0;
            }
            d.a(g);
            f = System.currentTimeMillis();
        }
          goto _L5
        f = 0L;
          goto _L5
    }

    public lf e()
    {
        lf lf1;
        synchronized (e)
        {
            lf1 = h;
        }
        return lf1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean f()
    {
        this;
        JVM INSTR monitorenter ;
        if (e() != null) goto _L2; else goto _L1
_L1:
        kg.a(2, b, "Session not found. No active session");
        boolean flag = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void g()
    {
        this;
        JVM INSTR monitorenter ;
        lg lg1;
        for (Iterator iterator = c.entrySet().iterator(); iterator.hasNext(); lg1.b())
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            lg1 = new lg();
            lg1.a = new WeakReference(entry.getKey());
            lg1.b = (lf)entry.getValue();
            lg1.c = lg.a.d;
            lg1.d = je.a().d();
        }

        break MISSING_BLOCK_LABEL_103;
        Exception exception;
        exception;
        throw exception;
        c.clear();
        js.a().b(new ly() {

            final lh a;

            public void a()
            {
                lh.a(a);
            }

            
            {
                a = lh.this;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
    }

}
