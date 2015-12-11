// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import com.facebook.a.a;
import com.facebook.internal.b;
import com.facebook.internal.c;
import com.facebook.internal.k;
import com.facebook.internal.o;
import com.facebook.internal.p;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook:
//            q, n, h, GraphRequest, 
//            m, f, b, s, 
//            AccessToken, Profile

public final class i
{
    public static interface a
    {

        public abstract void a();
    }


    private static final String a = com/facebook/i.getCanonicalName();
    private static final HashSet b;
    private static volatile Executor c;
    private static volatile String d;
    private static volatile String e;
    private static volatile String f;
    private static volatile int g;
    private static volatile String h = "facebook.com";
    private static AtomicLong i = new AtomicLong(0x10000L);
    private static volatile boolean j = false;
    private static boolean k = false;
    private static com.facebook.internal.i l;
    private static Context m;
    private static int n = 64206;
    private static final Object o = new Object();
    private static final BlockingQueue p = new LinkedBlockingQueue(10);
    private static final ThreadFactory q = new ThreadFactory() {

        private final AtomicInteger a = new AtomicInteger(0);

        public Thread newThread(Runnable runnable)
        {
            return new Thread(runnable, (new StringBuilder()).append("FacebookSdk #").append(a.incrementAndGet()).toString());
        }

    };
    private static Boolean r = Boolean.valueOf(false);

    public i()
    {
    }

    public static void a(int i1)
    {
        g = i1;
    }

    public static void a(Context context)
    {
        com/facebook/i;
        JVM INSTR monitorenter ;
        a(context, ((a) (null)));
        com/facebook/i;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public static void a(Context context, a a1)
    {
        com/facebook/i;
        JVM INSTR monitorenter ;
        if (!r.booleanValue()) goto _L2; else goto _L1
_L1:
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        a1.a();
_L4:
        com/facebook/i;
        JVM INSTR monitorexit ;
        return;
_L2:
        com.facebook.internal.p.a(context, "applicationContext");
        com.facebook.internal.p.b(context, false);
        com.facebook.internal.p.a(context, false);
        m = context.getApplicationContext();
        c(m);
        com.facebook.internal.o.a(m, d);
        com.facebook.internal.k.b();
        com.facebook.internal.c.a(m);
        l = new com.facebook.internal.i(new Callable() {

            public File a()
                throws Exception
            {
                return i.m().getCacheDir();
            }

            public Object call()
                throws Exception
            {
                return a();
            }

        });
        context = new FutureTask(new Callable(a1) {

            final a a;

            public Void a()
                throws Exception
            {
                com.facebook.b.a().c();
                com.facebook.s.a().c();
                if (com.facebook.AccessToken.a() != null && com.facebook.Profile.a() == null)
                {
                    com.facebook.Profile.b();
                }
                if (a != null)
                {
                    a.a();
                }
                return null;
            }

            public Object call()
                throws Exception
            {
                return a();
            }

            
            {
                a = a1;
                super();
            }
        });
        d().execute(context);
        r = Boolean.valueOf(true);
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    public static void a(Context context, String s)
    {
        context = context.getApplicationContext();
        d().execute(new Runnable(context, s) {

            final Context a;
            final String b;

            public void run()
            {
                com.facebook.i.b(a, b);
            }

            
            {
                a = context;
                b = s;
                super();
            }
        });
    }

    public static boolean a()
    {
        com/facebook/i;
        JVM INSTR monitorenter ;
        boolean flag = r.booleanValue();
        com/facebook/i;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean a(q q1)
    {
        HashSet hashset = b;
        hashset;
        JVM INSTR monitorenter ;
        boolean flag;
        if (b() && b.contains(q1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hashset;
        JVM INSTR monitorexit ;
        return flag;
        q1;
        hashset;
        JVM INSTR monitorexit ;
        throw q1;
    }

    static n b(Context context, String s)
    {
        if (context == null || s == null)
        {
            try
            {
                throw new IllegalArgumentException("Both context and applicationId must be non-null");
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                com.facebook.internal.o.a("Facebook-publish", context);
            }
            return new n(null, null, new h(null, context));
        }
        String s1;
        String s2;
        Object obj;
        String s3;
        b b1;
        long l1;
        b1 = com.facebook.internal.b.a(context);
        obj = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
        s2 = (new StringBuilder()).append(s).append("ping").toString();
        s1 = (new StringBuilder()).append(s).append("json").toString();
        l1 = ((SharedPreferences) (obj)).getLong(s2, 0L);
        s3 = ((SharedPreferences) (obj)).getString(s1, null);
        context = com.facebook.internal.a.a(com.facebook.internal.a.a.a, b1, com.facebook.a.a.b(context), b(context), context);
        s = com.facebook.GraphRequest.a(null, String.format("%s/activities", new Object[] {
            s
        }), context, null);
        if (l1 == 0L) goto _L2; else goto _L1
_L1:
        if (s3 == null) goto _L4; else goto _L3
_L3:
        context = JSONObjectInstrumentation.init(s3);
_L11:
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        return (n)com.facebook.n.a("true", null, new m(new GraphRequest[] {
            s
        })).get(0);
        context;
        throw new f("An error occurred while publishing install.", context);
        return new n(null, null, null, context);
_L2:
        s = s.i();
        obj = ((SharedPreferences) (obj)).edit();
        ((android.content.SharedPreferences.Editor) (obj)).putLong(s2, System.currentTimeMillis());
        if (s.b() == null) goto _L6; else goto _L5
_L5:
        context = s.b();
        if (context instanceof JSONObject) goto _L8; else goto _L7
_L7:
        context = context.toString();
_L9:
        ((android.content.SharedPreferences.Editor) (obj)).putString(s1, context);
_L6:
        ((android.content.SharedPreferences.Editor) (obj)).apply();
        return s;
_L8:
        context = JSONObjectInstrumentation.toString((JSONObject)context);
          goto _L9
_L4:
        context = null;
        continue; /* Loop/switch isn't completed */
        context;
        context = null;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public static boolean b()
    {
        return j;
    }

    public static boolean b(Context context)
    {
        com.facebook.internal.p.b();
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    static void c(Context context)
    {
        if (context != null)
        {
            try
            {
                context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
            if (context != null && ((ApplicationInfo) (context)).metaData != null)
            {
                if (d == null)
                {
                    Object obj = ((ApplicationInfo) (context)).metaData.get("com.facebook.sdk.ApplicationId");
                    if (obj instanceof String)
                    {
                        obj = (String)obj;
                        if (((String) (obj)).toLowerCase(Locale.ROOT).startsWith("fb"))
                        {
                            d = ((String) (obj)).substring(2);
                        } else
                        {
                            d = ((String) (obj));
                        }
                    } else
                    if (obj instanceof Integer)
                    {
                        throw new f("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                    }
                }
                if (e == null)
                {
                    e = ((ApplicationInfo) (context)).metaData.getString("com.facebook.sdk.ApplicationName");
                }
                if (f == null)
                {
                    f = ((ApplicationInfo) (context)).metaData.getString("com.facebook.sdk.ClientToken");
                }
                if (g == 0)
                {
                    a(((ApplicationInfo) (context)).metaData.getInt("com.facebook.sdk.WebDialogTheme"));
                    return;
                }
            }
        }
    }

    public static boolean c()
    {
        return k;
    }

    public static Executor d()
    {
        synchronized (o)
        {
            if (c == null)
            {
                c = AsyncTask.THREAD_POOL_EXECUTOR;
            }
        }
        return c;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static String e()
    {
        return h;
    }

    public static Context f()
    {
        com.facebook.internal.p.b();
        return m;
    }

    public static String g()
    {
        return "4.7.0";
    }

    public static long h()
    {
        com.facebook.internal.p.b();
        return i.get();
    }

    public static String i()
    {
        com.facebook.internal.p.b();
        return d;
    }

    public static String j()
    {
        com.facebook.internal.p.b();
        return f;
    }

    public static int k()
    {
        com.facebook.internal.p.b();
        return g;
    }

    public static int l()
    {
        com.facebook.internal.p.b();
        return n;
    }

    static Context m()
    {
        return m;
    }

    static 
    {
        b = new HashSet(Arrays.asList(new q[] {
            q.f
        }));
    }
}
