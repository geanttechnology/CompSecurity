// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.d;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.kahuna.sdk:
//            v, g, m

public class h
{
    private class a extends TimerTask
    {

        final h a;
        private String b;

        public void run()
        {
            if (b != null && !"".equals(b))
            {
                String s1;
                try
                {
                    String s = com.google.android.gms.gcm.d.a(h.a(h.f())).a(new String[] {
                        b
                    });
                    h.b(s);
                    Object obj = com.kahuna.sdk.h.d(h.a(h.f()));
                    int i = h.e(h.a(h.f()));
                    h.c((new StringBuilder()).append("Saving regId on app version ").append(i).toString());
                    obj = ((SharedPreferences) (obj)).edit();
                    ((android.content.SharedPreferences.Editor) (obj)).putString("registration_id", s);
                    ((android.content.SharedPreferences.Editor) (obj)).putInt("appVersion", i);
                    ((android.content.SharedPreferences.Editor) (obj)).commit();
                    return;
                }
                catch (Exception exception)
                {
                    if (m.s())
                    {
                        Log.e("Kahuna", (new StringBuilder()).append("Exception registering for Push: ").append(exception).toString());
                        exception.printStackTrace();
                    }
                    s1 = exception.getMessage();
                }
                if (s1 != null && "SERVICE_NOT_AVAILABLE".equals(s1))
                {
                    h.e();
                    return;
                }
            }
        }

        public a(String s)
        {
            a = h.this;
            super();
            b = s;
        }
    }


    private static final Random a = new Random();
    private static final int b;
    private static h c = new h();
    private Context d;
    private boolean e;
    private String f;
    private Timer g;
    private Object h;

    private h()
    {
        e = false;
        h = new Object();
    }

    static Context a(h h1)
    {
        return h1.d;
    }

    protected static void a()
    {
        Object obj;
        Object obj1;
        try
        {
            if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(c.d) == 0)
            {
                c.e = true;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            c.e = false;
        }
        if (c.e)
        {
            obj = "GCM is being managed from Play Services";
        } else
        {
            obj = "GCM is being managed from Old GCM Client Library";
        }
        d(((String) (obj)));
        obj1 = d(c.d);
        obj = ((SharedPreferences) (obj1)).edit();
        if (!c.e) goto _L2; else goto _L1
_L1:
        obj1 = ((SharedPreferences) (obj1)).getString("regId", "");
        if (!v.a(((String) (obj1))))
        {
            d("Migrating Push Token from Old GCM to Play Services");
            ((android.content.SharedPreferences.Editor) (obj)).putString("registration_id", ((String) (obj1)));
        }
_L4:
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        return;
_L2:
        obj1 = ((SharedPreferences) (obj1)).getString("registration_id", "");
        if (!v.a(((String) (obj1))))
        {
            d("Migrating Push Token from Play Services back to Old GCM");
            ((android.content.SharedPreferences.Editor) (obj)).putString("regId", ((String) (obj1)));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(long l)
    {
        synchronized (h)
        {
            if (g != null)
            {
                g.cancel();
            }
            g = new Timer();
            g.schedule(new a(f), l);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static void a(Context context)
    {
        c.d = context;
    }

    protected static void a(Context context, int i)
    {
        context = d(context).edit();
        context.putInt("backoff_ms", i);
        context.commit();
    }

    protected static void a(String s)
    {
        c.f = s;
        if (c.e)
        {
            c.a(0L);
            return;
        } else
        {
            com.kahuna.sdk.g.a(c.d, new String[] {
                c.f
            });
            return;
        }
    }

    protected static String b()
    {
        String s;
        SharedPreferences sharedpreferences;
        if (!c.e)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        sharedpreferences = d(c.d);
        s = sharedpreferences.getString("registration_id", "");
        if (!"".equals(s)) goto _L2; else goto _L1
_L1:
        d("Registration not found.");
        s = "";
_L4:
        return s;
_L2:
        if (sharedpreferences.getInt("appVersion", 0x80000000) == f(c.d)) goto _L4; else goto _L3
_L3:
        d("App version changed.");
        return "";
        return com.kahuna.sdk.g.c(c.d);
    }

    protected static void b(Context context)
    {
        d("Resetting backoff");
        a(context, 3000);
    }

    protected static void b(String s)
    {
        com/kahuna/sdk/h;
        JVM INSTR monitorenter ;
        m.j().c(s);
        m.j().f();
_L2:
        com/kahuna/sdk/h;
        JVM INSTR monitorexit ;
        return;
        s;
        Log.e("Kahuna", "KahunaSDK wasn't initialized in onAppCreate(), please initialized Kahuna correctly to prevent strange behavior");
        s.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        s;
        throw s;
    }

    protected static int c(Context context)
    {
        return d(context).getInt("backoff_ms", 3000);
    }

    static void c(String s)
    {
        d(s);
    }

    protected static boolean c()
    {
        return c.e;
    }

    protected static SharedPreferences d(Context context)
    {
        return context.getSharedPreferences("com.google.android.gcm", 0);
    }

    protected static void d()
    {
        try
        {
            m.j().l();
            return;
        }
        catch (Exception exception)
        {
            Log.e("Kahuna", "KahunaSDK wasn't initialized in onAppCreate(), please initialized Kahuna correctly to prevent strange behavior");
            exception.printStackTrace();
            return;
        }
    }

    private static void d(String s)
    {
        if (m.s())
        {
            String s1;
            if (c.e)
            {
                s1 = "Play Services GCM: ";
            } else
            {
                s1 = "Old GCM: ";
            }
            Log.d("Kahuna", (new StringBuilder()).append(s1).append(s).toString());
        }
    }

    static int e(Context context)
    {
        return f(context);
    }

    protected static void e()
    {
        int i = c(c.d);
        int j = i / 2;
        j = a.nextInt(i) + j;
        d((new StringBuilder()).append("Scheduling registration retry, backoff = ").append(j).append("(").append(i).append(")").toString());
        if (c.e)
        {
            c.a(j);
        } else
        {
            Object obj = new Intent("com.google.android.gcm.intent.RETRY");
            ((Intent) (obj)).setPackage(c.d.getPackageName());
            obj = PendingIntent.getBroadcast(c.d, 0, ((Intent) (obj)), 0);
            ((AlarmManager)c.d.getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + (long)j, ((PendingIntent) (obj)));
        }
        if (i < b)
        {
            a(c.d, i * 2);
        }
    }

    private static int f(Context context)
    {
        int i;
        try
        {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return 1;
        }
        return i;
    }

    static h f()
    {
        return c;
    }

    static 
    {
        b = (int)TimeUnit.SECONDS.toMillis(3600L);
    }
}
