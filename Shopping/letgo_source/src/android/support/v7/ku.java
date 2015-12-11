// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.analytics.internal.ad;
import com.google.android.gms.analytics.internal.ai;
import com.google.android.gms.analytics.internal.g;
import com.google.android.gms.analytics.internal.l;
import com.google.android.gms.analytics.internal.n;
import com.google.android.gms.analytics.internal.r;
import com.google.android.gms.common.internal.x;

// Referenced classes of package android.support.v7:
//            kt, ww

public final class ku extends Service
{

    private static Boolean b;
    private final Handler a = new Handler();

    public ku()
    {
    }

    static Handler a(ku ku1)
    {
        return ku1.a;
    }

    private void a()
    {
        Object obj = kt.a;
        obj;
        JVM INSTR monitorenter ;
        ww ww1 = kt.b;
        if (ww1 == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        if (ww1.b())
        {
            ww1.a();
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        catch (SecurityException securityexception)
        {
            return;
        }
    }

    public static boolean a(Context context)
    {
        x.a(context);
        if (b != null)
        {
            return b.booleanValue();
        } else
        {
            boolean flag = l.a(context, android/support/v7/ku);
            b = Boolean.valueOf(flag);
            return flag;
        }
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        r r1 = r.a(this);
        g g1 = r1.f();
        if (r1.e().a())
        {
            g1.b("Device AnalyticsService is starting up");
            return;
        } else
        {
            g1.b("Local AnalyticsService is starting up");
            return;
        }
    }

    public void onDestroy()
    {
        r r1 = r.a(this);
        g g1 = r1.f();
        if (r1.e().a())
        {
            g1.b("Device AnalyticsService is shutting down");
        } else
        {
            g1.b("Local AnalyticsService is shutting down");
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        a();
        r r1 = r.a(this);
        g g1 = r1.f();
        intent = intent.getAction();
        if (r1.e().a())
        {
            g1.a("Device AnalyticsService called. startId, action", Integer.valueOf(j), intent);
        } else
        {
            g1.a("Local AnalyticsService called. startId, action", Integer.valueOf(j), intent);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(intent))
        {
            r1.i().a(new ai(j, r1, g1) {

                final int a;
                final r b;
                final g c;
                final ku d;

                public void a(Throwable throwable)
                {
                    ku.a(d).post(new Runnable(this) {

                        final _cls1 a;

                        public void run()
                        {
label0:
                            {
                                if (a.d.stopSelfResult(a.a))
                                {
                                    if (!a.b.e().a())
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
                d = ku.this;
                a = i;
                b = r1;
                c = g1;
                super();
            }
            });
        }
        return 2;
    }
}
