// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.analytics.internal.ai;
import com.google.android.gms.analytics.internal.g;
import com.google.android.gms.analytics.internal.l;
import com.google.android.gms.analytics.internal.n;
import com.google.android.gms.analytics.internal.r;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ju;

// Referenced classes of package com.google.android.gms.analytics:
//            a

public final class b extends Service
{

    private static Boolean b;
    private final Handler a = new Handler();

    public b()
    {
    }

    static Handler a(b b1)
    {
        return b1.a;
    }

    public static boolean a(Context context)
    {
        w.a(context);
        if (b != null)
        {
            return b.booleanValue();
        } else
        {
            boolean flag = l.a(context, com/google/android/gms/analytics/b);
            b = Boolean.valueOf(flag);
            return flag;
        }
    }

    public final IBinder onBind(Intent intent)
    {
        return null;
    }

    public final void onCreate()
    {
        super.onCreate();
        g g1 = r.a(this).a();
        if (f.a)
        {
            g1.b("Device AnalyticsService is starting up");
            return;
        } else
        {
            g1.b("Local AnalyticsService is starting up");
            return;
        }
    }

    public final void onDestroy()
    {
        g g1 = r.a(this).a();
        if (f.a)
        {
            g1.b("Device AnalyticsService is shutting down");
        } else
        {
            g1.b("Local AnalyticsService is shutting down");
        }
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i, int j)
    {
        Object obj = a.a;
        obj;
        JVM INSTR monitorenter ;
        ju ju1 = a.b;
        if (ju1 == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        if (ju1.a.isHeld())
        {
            ju1.b();
        }
        obj;
        JVM INSTR monitorexit ;
_L1:
        obj = r.a(this);
        Object obj1 = ((r) (obj)).a();
        intent = intent.getAction();
        SecurityException securityexception;
        if (f.a)
        {
            ((g) (obj1)).a("Device AnalyticsService called. startId, action", Integer.valueOf(j), intent);
        } else
        {
            ((g) (obj1)).a("Local AnalyticsService called. startId, action", Integer.valueOf(j), intent);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(intent))
        {
            ((r) (obj)).c().a(new ai(j, ((r) (obj)), ((g) (obj1))) {

                final int a;
                final r b;
                final g c;
                final b d;

                public final void a()
                {
                    b.a(d).post(new Runnable(this) {

                        final _cls1 a;

                        public final void run()
                        {
label0:
                            {
                                if (a.d.stopSelfResult(a.a))
                                {
                                    if (!f.a)
                                    {
                                        break label0;
                                    }
                                    a.c.b("Device AnalyticsService processed last dispatch request");
                                }
                                return;
                            }
                            a.c.b("Local AnalyticsService processed last dispatch request");
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                }

            
            {
                d = b.this;
                a = i;
                b = r1;
                c = g1;
                super();
            }
            });
        }
        return 2;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw obj1;
        }
        // Misplaced declaration of an exception variable
        catch (SecurityException securityexception) { }
          goto _L1
    }
}
