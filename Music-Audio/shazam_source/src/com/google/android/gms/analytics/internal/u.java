// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.stats.b;
import com.google.android.gms.d.ja;
import java.util.Collections;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            p, k, r, c, 
//            ad, d, ak, af, 
//            o, n

public final class u extends p
{
    protected final class a
        implements ServiceConnection
    {

        final u a;
        private volatile d b;
        private volatile boolean c;

        public final d a()
        {
            Object obj;
            Context context;
            r.i();
            obj = new Intent("com.google.android.gms.analytics.service.START");
            ((Intent) (obj)).setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
            context = ((o) (a)).i.a;
            ((Intent) (obj)).putExtra("app_package_name", context.getPackageName());
            b b1 = com.google.android.gms.common.stats.b.a();
            this;
            JVM INSTR monitorenter ;
            boolean flag;
            b = null;
            c = true;
            flag = b1.a(context, ((Intent) (obj)), a.a, 129);
            a.a("Bind to service requested", Boolean.valueOf(flag));
            if (flag)
            {
                break MISSING_BLOCK_LABEL_113;
            }
            c = false;
            this;
            JVM INSTR monitorexit ;
            return null;
            wait(((Long)ak.L.a()).longValue());
_L1:
            c = false;
            obj = b;
            b = null;
            if (obj != null)
            {
                break MISSING_BLOCK_LABEL_157;
            }
            a.f("Successfully bound to service but never got onServiceConnected callback");
            this;
            JVM INSTR monitorexit ;
            return ((d) (obj));
            Object obj1;
            obj1;
            this;
            JVM INSTR monitorexit ;
            throw obj1;
            obj1;
            a.e("Wait for service connect was interrupted");
              goto _L1
        }

        public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            w.b("AnalyticsServiceConnection.onServiceConnected");
            this;
            JVM INSTR monitorenter ;
            if (ibinder != null)
            {
                break MISSING_BLOCK_LABEL_27;
            }
            a.f("Service connected with null binder");
            notifyAll();
            this;
            JVM INSTR monitorexit ;
            return;
            Object obj;
            Object obj1;
            obj1 = null;
            obj = null;
            componentname = obj1;
            String s = ibinder.getInterfaceDescriptor();
            componentname = obj1;
            if (!"com.google.android.gms.analytics.internal.IAnalyticsService".equals(s)) goto _L2; else goto _L1
_L1:
            componentname = obj1;
            ibinder = com.google.android.gms.analytics.internal.d.a.a(ibinder);
            componentname = ibinder;
            a.b("Bound to IAnalyticsService interface");
            componentname = ibinder;
_L4:
            {
                if (componentname != null)
                {
                    break; /* Loop/switch isn't completed */
                }
                try
                {
                    com.google.android.gms.common.stats.b.a().a(((o) (a)).i.a, a.a);
                }
                // Misplaced declaration of an exception variable
                catch (ComponentName componentname) { }
                finally { }
            }
            notifyAll();
            this;
            JVM INSTR monitorexit ;
            return;
            componentname;
            this;
            JVM INSTR monitorexit ;
            throw componentname;
_L2:
            componentname = obj1;
            a.e("Got binder with a wrong descriptor", s);
            componentname = obj;
            continue; /* Loop/switch isn't completed */
            ibinder;
            a.f("Service connect failed to get IAnalyticsService");
            if (true) goto _L4; else goto _L3
            notifyAll();
            throw componentname;
_L3:
label0:
            {
                if (c)
                {
                    break label0;
                }
                a.e("onServiceConnected received after the timeout limit");
                ((o) (a)).i.b().a(new Runnable(this, componentname) {

                    final d a;
                    final a b;

                    public final void run()
                    {
                        if (!b.a.b())
                        {
                            b.a.c("Connected to service after a timeout");
                            u u1 = b.a;
                            d d1 = a;
                            r.i();
                            u1.b = d1;
                            u1.c();
                            ((o) (u1)).i.c().d();
                        }
                    }

            
            {
                b = a1;
                a = d1;
                super();
            }
                });
            }
            break MISSING_BLOCK_LABEL_104;
            b = componentname;
            break MISSING_BLOCK_LABEL_104;
        }

        public final void onServiceDisconnected(ComponentName componentname)
        {
            w.b("AnalyticsServiceConnection.onServiceDisconnected");
            ((o) (a)).i.b().a(new Runnable(this, componentname) {

                final ComponentName a;
                final a b;

                public final void run()
                {
                    u u1 = b.a;
                    ComponentName componentname = a;
                    r.i();
                    if (u1.b != null)
                    {
                        u1.b = null;
                        u1.a("Disconnected from device AnalyticsService", componentname);
                        ((o) (u1)).i.c().c();
                    }
                }

            
            {
                b = a1;
                a = componentname;
                super();
            }
            });
        }

        protected a()
        {
            a = u.this;
            super();
        }
    }


    final a a = new a();
    d b;
    private final af c;
    private k d;

    protected u(r r1)
    {
        super(r1);
        d = new k(r1.c);
        c = new af(r1) {

            final u a;

            public final void a()
            {
                u.a(a);
            }

            
            {
                a = u.this;
                super(r1);
            }
        };
    }

    static void a(u u1)
    {
        r.i();
        if (u1.b())
        {
            u1.b("Inactivity, disconnecting from device AnalyticsService");
            u1.e();
        }
    }

    protected final void a()
    {
    }

    public final boolean a(c c1)
    {
        w.a(c1);
        r.i();
        o();
        d d1 = b;
        if (d1 == null)
        {
            return false;
        }
        String s;
        java.util.List list;
        if (c1.f)
        {
            s = ad.h();
        } else
        {
            s = ad.i();
        }
        list = Collections.emptyList();
        try
        {
            d1.a(c1.a, c1.d, s, list);
            c();
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            b("Failed to send hits to AnalyticsService");
            return false;
        }
        return true;
    }

    public final boolean b()
    {
        r.i();
        o();
        return b != null;
    }

    final void c()
    {
        d.a();
        c.a(((Long)ak.K.a()).longValue());
    }

    public final boolean d()
    {
        r.i();
        o();
        if (b != null)
        {
            return true;
        }
        d d1 = a.a();
        if (d1 != null)
        {
            b = d1;
            c();
            return true;
        } else
        {
            return false;
        }
    }

    public final void e()
    {
        r.i();
        o();
        try
        {
            com.google.android.gms.common.stats.b.a().a(super.i.a, a);
        }
        catch (IllegalStateException illegalstateexception) { }
        catch (IllegalArgumentException illegalargumentexception) { }
        if (b != null)
        {
            b = null;
            super.i.c().c();
        }
    }
}
