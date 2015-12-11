// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.ad;
import com.google.android.gms.analytics.internal.g;
import com.google.android.gms.analytics.internal.l;
import com.google.android.gms.analytics.internal.o;
import com.google.android.gms.analytics.internal.r;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ja;
import com.google.android.gms.d.ju;

// Referenced classes of package com.google.android.gms.analytics:
//            c

public class d extends Service
{

    private static Boolean b;
    private Handler a;

    public d()
    {
    }

    public static boolean a(Context context)
    {
        w.a(context);
        if (b != null)
        {
            return b.booleanValue();
        } else
        {
            boolean flag = l.a(context, com/google/android/gms/analytics/d);
            b = Boolean.valueOf(flag);
            return flag;
        }
    }

    protected final void a(g g1, Handler handler, int i)
    {
        handler.post(new Runnable(i, g1) {

            final int a;
            final g b;
            final d c;

            public final void run()
            {
                boolean flag = c.stopSelfResult(a);
                if (flag)
                {
                    b.a("Install campaign broadcast processed", Boolean.valueOf(flag));
                }
            }

            
            {
                c = d.this;
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
        r.a(this).a().b("CampaignTrackingService is starting up");
    }

    public void onDestroy()
    {
        r.a(this).a().b("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        Object obj = c.a;
        obj;
        JVM INSTR monitorenter ;
        ju ju1 = c.b;
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
        g g1;
        r r1;
        r1 = r.a(this);
        g1 = r1.a();
        obj = null;
        Handler handler;
        Exception exception;
        if (f.a)
        {
            g1.f("Unexpected installation campaign (package side)");
            intent = ((Intent) (obj));
        } else
        {
            intent = intent.getStringExtra("referrer");
        }
        handler = a;
        obj = handler;
        if (handler == null)
        {
            obj = new Handler(getMainLooper());
            a = ((Handler) (obj));
        }
        if (TextUtils.isEmpty(intent))
        {
            if (!f.a)
            {
                g1.e("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            }
            r1.b().a(new Runnable(g1, ((Handler) (obj)), j) {

                final g a;
                final Handler b;
                final int c;
                final d d;

                public final void run()
                {
                    d.a(a, b, c);
                }

            
            {
                d = d.this;
                a = g1;
                b = handler;
                c = i;
                super();
            }
            });
            return 2;
        }
        break MISSING_BLOCK_LABEL_169;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
          goto _L1
        i = ad.c();
        Object obj1 = intent;
        if (intent.length() > i)
        {
            g1.c("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(intent.length()), Integer.valueOf(i));
            obj1 = intent.substring(0, i);
        }
        g1.a("CampaignTrackingService called. startId, campaign", Integer.valueOf(j), obj1);
        intent = r1.c();
        obj = new Runnable(g1, ((Handler) (obj)), j) {

            final g a;
            final Handler b;
            final int c;
            final d d;

            public final void run()
            {
                d.a(a, b, c);
            }

            
            {
                d = d.this;
                a = g1;
                b = handler;
                c = i;
                super();
            }
        };
        w.a(((String) (obj1)), "campaign param can't be empty");
        ((o) (intent)).i.b().a(new com.google.android.gms.analytics.internal.n._cls2(intent, ((String) (obj1)), ((Runnable) (obj))));
        return 2;
    }
}
