// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;

// Referenced classes of package com.google.analytics.tracking.android:
//            av, t, an, ai, 
//            aj, h, ar, f, 
//            p, u, r, g

public final class s extends av
{

    private static final Object a = new Object();
    private static s o;
    private Context b;
    private f c;
    private volatile h d;
    private int e;
    private boolean f;
    private boolean g;
    private String h;
    private boolean i;
    private boolean j;
    private g k;
    private Handler l;
    private r m;
    private boolean n;

    private s()
    {
        e = 1800;
        f = true;
        i = true;
        j = true;
        k = new t(this);
        n = false;
    }

    public static s a()
    {
        if (o == null)
        {
            o = new s();
        }
        return o;
    }

    static boolean a(s s1)
    {
        return s1.i;
    }

    static int b(s s1)
    {
        return s1.e;
    }

    static boolean c(s s1)
    {
        return s1.n;
    }

    static Handler d(s s1)
    {
        return s1.l;
    }

    static Object e()
    {
        return a;
    }

    final void a(Context context, h h1)
    {
        this;
        JVM INSTR monitorenter ;
        Context context1 = b;
        if (context1 == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        b = context.getApplicationContext();
        if (d != null) goto _L1; else goto _L3
_L3:
        d = h1;
        if (f)
        {
            c();
            f = false;
        }
        if (!g) goto _L1; else goto _L4
_L4:
        if (d != null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        an.c("setForceLocalDispatch() queued. It will be called once initialization is complete.");
        g = true;
_L5:
        g = false;
          goto _L1
        context;
        throw context;
        ai.a().a(aj.af);
        d.b();
          goto _L5
    }

    final void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        a(n, flag);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final void a(boolean flag, boolean flag1)
    {
        this;
        JVM INSTR monitorenter ;
        if (n != flag) goto _L2; else goto _L1
_L1:
        boolean flag2 = i;
        if (flag2 != flag1) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!flag && flag1)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        if (e > 0)
        {
            l.removeMessages(1, a);
        }
        if (flag || !flag1)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        if (e > 0)
        {
            l.sendMessageDelayed(l.obtainMessage(1, a), e * 1000);
        }
        StringBuilder stringbuilder = new StringBuilder("PowerSaveMode ");
        Object obj;
        if (!flag && flag1)
        {
            obj = "terminated.";
        } else
        {
            obj = "initiated.";
        }
        an.c(stringbuilder.append(((String) (obj))).toString());
        n = flag;
        i = flag1;
        if (true) goto _L3; else goto _L4
_L4:
        obj;
        throw obj;
    }

    final f b()
    {
        this;
        JVM INSTR monitorenter ;
        if (c != null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        if (b == null)
        {
            throw new IllegalStateException("Cant get a store unless we have a context");
        }
        break MISSING_BLOCK_LABEL_31;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        c = new ar(k, b);
        if (h != null)
        {
            c.c().a(h);
            h = null;
        }
        f f1;
        if (l == null)
        {
            l = new Handler(b.getMainLooper(), new u(this));
            if (e > 0)
            {
                l.sendMessageDelayed(l.obtainMessage(1, a), e * 1000);
            }
        }
        if (m == null && j)
        {
            m = new r(this);
            r r1 = m;
            Context context = b;
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(r1, intentfilter);
            intentfilter = new IntentFilter();
            intentfilter.addAction("com.google.analytics.RADIO_POWERED");
            intentfilter.addCategory(context.getPackageName());
            context.registerReceiver(r1, intentfilter);
        }
        f1 = c;
        this;
        JVM INSTR monitorexit ;
        return f1;
    }

    public final void c()
    {
        this;
        JVM INSTR monitorenter ;
        if (d != null) goto _L2; else goto _L1
_L1:
        an.c("Dispatch call queued. Dispatch will run once initialization is complete.");
        f = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        ai.a().a(aj.S);
        d.a();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    final void d()
    {
        this;
        JVM INSTR monitorenter ;
        if (!n && i && e > 0)
        {
            l.removeMessages(1, a);
            l.sendMessage(l.obtainMessage(1, a));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
