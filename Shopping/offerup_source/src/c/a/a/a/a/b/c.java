// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import c.a.a.a.e;
import c.a.a.a.q;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package c.a.a.a.a.b:
//            b, w, e, i, 
//            f, u, d

public class c
{

    private final Context a;
    private final c.a.a.a.a.f.c b;

    public c(Context context)
    {
        a = context.getApplicationContext();
        b = new c.a.a.a.a.f.c(context, "TwitterAdvertisingInfoPreferences");
    }

    static b a(c c1)
    {
        return c1.b();
    }

    public static ExecutorService a(String s)
    {
        ExecutorService executorservice = Executors.newSingleThreadExecutor(c(s));
        a(s, executorservice);
        return executorservice;
    }

    private void a(b b1)
    {
        if (b(b1))
        {
            b.a(b.b().putString("advertising_id", b1.a).putBoolean("limit_ad_tracking_enabled", b1.b));
            return;
        } else
        {
            b.a(b.b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
            return;
        }
    }

    static void a(c c1, b b1)
    {
        c1.a(b1);
    }

    private static void a(String s, ExecutorService executorservice)
    {
        TimeUnit timeunit = TimeUnit.SECONDS;
        Runtime.getRuntime().addShutdownHook(new Thread(new w(s, executorservice, 2L, timeunit), (new StringBuilder("Crashlytics Shutdown Hook for ")).append(s).toString()));
    }

    private b b()
    {
        b b1 = (new c.a.a.a.a.b.e(a)).a();
        if (!b(b1))
        {
            b1 = (new f(a)).a();
            if (!b(b1))
            {
                e.d().a("Fabric", "AdvertisingInfo not present");
                return b1;
            } else
            {
                e.d().a("Fabric", "Using AdvertisingInfo from Service Provider");
                return b1;
            }
        } else
        {
            e.d().a("Fabric", "Using AdvertisingInfo from Reflection Provider");
            return b1;
        }
    }

    public static ScheduledExecutorService b(String s)
    {
        ScheduledExecutorService scheduledexecutorservice = Executors.newSingleThreadScheduledExecutor(c(s));
        a(s, scheduledexecutorservice);
        return scheduledexecutorservice;
    }

    private static boolean b(b b1)
    {
        return b1 != null && !TextUtils.isEmpty(b1.a);
    }

    public static ThreadFactory c(String s)
    {
        return new u(s, new AtomicLong(1L));
    }

    public final b a()
    {
        b b1 = new b(b.a().getString("advertising_id", ""), b.a().getBoolean("limit_ad_tracking_enabled", false));
        if (b(b1))
        {
            e.d().a("Fabric", "Using AdvertisingInfo from Preference Store");
            (new Thread(new d(this, b1))).start();
            return b1;
        } else
        {
            b b2 = b();
            a(b2);
            return b2;
        }
    }
}
