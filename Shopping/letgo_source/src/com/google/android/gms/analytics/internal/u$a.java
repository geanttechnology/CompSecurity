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
import android.support.v7.wf;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.common.stats.b;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            u, ad, d

protected class a
    implements ServiceConnection
{

    final u a;
    private volatile d b;
    private volatile boolean c;

    public d a()
    {
        Object obj;
        Context context;
        a.m();
        obj = new Intent("com.google.android.gms.analytics.service.START");
        ((Intent) (obj)).setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        context = a.o();
        ((Intent) (obj)).putExtra("app_package_name", context.getPackageName());
        b b1 = com.google.android.gms.common.stats.b.a();
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        b = null;
        c = true;
        flag = b1.a(context, ((Intent) (obj)), u.a(a), 129);
        a.a("Bind to service requested", Boolean.valueOf(flag));
        if (flag)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        c = false;
        this;
        JVM INSTR monitorexit ;
        return null;
        wait(a.q().w());
_L1:
        c = false;
        obj = b;
        b = null;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_156;
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

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        x.b("AnalyticsServiceConnection.onServiceConnected");
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
        ibinder = a(ibinder);
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
                com.google.android.gms.common.stats.b.a().a(a.o(), u.a(a));
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
            a.r().a(new Runnable(componentname) {

                final d a;
                final u.a b;

                public void run()
                {
                    if (!b.a.b())
                    {
                        b.a.c("Connected to service after a timeout");
                        u.a(b.a, a);
                    }
                }

            
            {
                b = u.a.this;
                a = d;
                super();
            }
            });
        }
        break MISSING_BLOCK_LABEL_101;
        b = componentname;
        break MISSING_BLOCK_LABEL_101;
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        x.b("AnalyticsServiceConnection.onServiceDisconnected");
        a.r().a(new Runnable(componentname) {

            final ComponentName a;
            final u.a b;

            public void run()
            {
                u.a(b.a, a);
            }

            
            {
                b = u.a.this;
                a = componentname;
                super();
            }
        });
    }

    protected _cls2.a(u u1)
    {
        a = u1;
        super();
    }
}
