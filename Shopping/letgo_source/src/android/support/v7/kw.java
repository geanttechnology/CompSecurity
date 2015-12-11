// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.ad;
import com.google.android.gms.analytics.internal.g;
import com.google.android.gms.analytics.internal.l;
import com.google.android.gms.analytics.internal.n;
import com.google.android.gms.analytics.internal.r;
import com.google.android.gms.common.internal.x;

// Referenced classes of package android.support.v7:
//            kv, ww, wf

public class kw extends Service
{

    private static Boolean b;
    private Handler a;

    public kw()
    {
    }

    private void a()
    {
        Object obj = kv.a;
        obj;
        JVM INSTR monitorenter ;
        ww ww1 = kv.b;
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
            boolean flag = l.a(context, android/support/v7/kw);
            b = Boolean.valueOf(flag);
            return flag;
        }
    }

    private Handler b()
    {
        Handler handler1 = a;
        Handler handler = handler1;
        if (handler1 == null)
        {
            handler = new Handler(getMainLooper());
            a = handler;
        }
        return handler;
    }

    protected void a(g g1, Handler handler, int i)
    {
        handler.post(new Runnable(i, g1) {

            final int a;
            final g b;
            final kw c;

            public void run()
            {
                boolean flag = c.stopSelfResult(a);
                if (flag)
                {
                    b.a("Install campaign broadcast processed", Boolean.valueOf(flag));
                }
            }

            
            {
                c = kw.this;
                a = i;
                b = g1;
                super();
            }
        });
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        r.a(this).f().b("CampaignTrackingService is starting up");
    }

    public void onDestroy()
    {
        r.a(this).f().b("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        a();
        r r1 = r.a(this);
        g g1 = r1.f();
        Handler handler = null;
        if (r1.e().a())
        {
            g1.f("Unexpected installation campaign (package side)");
            intent = handler;
        } else
        {
            intent = intent.getStringExtra("referrer");
        }
        handler = b();
        if (TextUtils.isEmpty(intent))
        {
            if (!r1.e().a())
            {
                g1.e("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            }
            r1.h().a(new Runnable(g1, handler, j) {

                final g a;
                final Handler b;
                final int c;
                final kw d;

                public void run()
                {
                    d.a(a, b, c);
                }

            
            {
                d = kw.this;
                a = g1;
                b = handler;
                c = i;
                super();
            }
            });
            return 2;
        }
        i = r1.e().e();
        if (intent.length() > i)
        {
            g1.c("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(intent.length()), Integer.valueOf(i));
            intent = intent.substring(0, i);
        }
        g1.a("CampaignTrackingService called. startId, campaign", Integer.valueOf(j), intent);
        r1.i().a(intent, new Runnable(g1, handler, j) {

            final g a;
            final Handler b;
            final int c;
            final kw d;

            public void run()
            {
                d.a(a, b, c);
            }

            
            {
                d = kw.this;
                a = g1;
                b = handler;
                c = i;
                super();
            }
        });
        return 2;
    }
}
