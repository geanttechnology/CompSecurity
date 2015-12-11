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
import android.support.v7.jg;
import android.support.v7.jj;
import android.support.v7.jk;
import android.support.v7.jl;
import android.support.v7.jx;
import android.support.v7.kb;
import android.support.v7.kc;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.File;
import java.lang.reflect.Field;
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
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook:
//            s, h, p, j, 
//            GraphRequest, o, b, u, 
//            AccessToken, Profile

public final class k
{
    public static interface a
    {

        public abstract void a();
    }


    private static final String a = com/facebook/k.getCanonicalName();
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
    private static File l;
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

    public k()
    {
    }

    public static void a(int i1)
    {
        g = i1;
    }

    public static void a(Context context)
    {
        com/facebook/k;
        JVM INSTR monitorenter ;
        a(context, ((a) (null)));
        com/facebook/k;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public static void a(Context context, int i1)
    {
        com/facebook/k;
        JVM INSTR monitorenter ;
        a(context, i1, null);
        com/facebook/k;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public static void a(Context context, int i1, a a1)
    {
        com/facebook/k;
        JVM INSTR monitorenter ;
        if (r.booleanValue() && i1 != n)
        {
            throw new h("The callback request code offset can't be updated once the SDK is initialized.");
        }
        break MISSING_BLOCK_LABEL_35;
        context;
        com/facebook/k;
        JVM INSTR monitorexit ;
        throw context;
        if (i1 >= 0)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        throw new h("The callback request code offset can't be negative.");
        n = i1;
        a(context);
        com/facebook/k;
        JVM INSTR monitorexit ;
    }

    public static void a(Context context, a a1)
    {
        com/facebook/k;
        JVM INSTR monitorenter ;
        if (!r.booleanValue()) goto _L2; else goto _L1
_L1:
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        a1.a();
_L4:
        com/facebook/k;
        JVM INSTR monitorexit ;
        return;
_L2:
        kc.a(context, "applicationContext");
        kc.b(context, false);
        kc.a(context, false);
        m = context.getApplicationContext();
        c(m);
        kb.a(m, d);
        jx.b();
        jl.a(m);
        l = m.getCacheDir();
        context = new FutureTask(new Callable(a1) {

            final a a;

            public Void a()
                throws Exception
            {
                com.facebook.b.a().c();
                u.a().c();
                if (AccessToken.a() != null && Profile.a() == null)
                {
                    Profile.b();
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

    public static void a(Context context, String s1)
    {
        context = context.getApplicationContext();
        d().execute(new Runnable(context, s1) {

            final Context a;
            final String b;

            public void run()
            {
                k.b(a, b);
            }

            
            {
                a = context;
                b = s1;
                super();
            }
        });
    }

    public static boolean a()
    {
        com/facebook/k;
        JVM INSTR monitorenter ;
        boolean flag = r.booleanValue();
        com/facebook/k;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean a(s s1)
    {
        HashSet hashset = b;
        hashset;
        JVM INSTR monitorenter ;
        boolean flag;
        if (b() && b.contains(s1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hashset;
        JVM INSTR monitorexit ;
        return flag;
        s1;
        hashset;
        JVM INSTR monitorexit ;
        throw s1;
    }

    static p b(Context context, String s1)
    {
        if (context == null || s1 == null)
        {
            try
            {
                throw new IllegalArgumentException("Both context and applicationId must be non-null");
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                kb.a("Facebook-publish", context);
            }
            return new p(null, null, new j(null, context));
        }
        String s2;
        String s3;
        Object obj;
        String s4;
        jk jk1;
        long l1;
        jk1 = jk.a(context);
        obj = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
        s3 = (new StringBuilder()).append(s1).append("ping").toString();
        s2 = (new StringBuilder()).append(s1).append("json").toString();
        l1 = ((SharedPreferences) (obj)).getLong(s3, 0L);
        s4 = ((SharedPreferences) (obj)).getString(s2, null);
        context = jj.a(android.support.v7.jj.a.a, jk1, jg.c(context), b(context), context);
        s1 = GraphRequest.a(null, String.format("%s/activities", new Object[] {
            s1
        }), context, null);
        if (l1 == 0L) goto _L2; else goto _L1
_L1:
        if (s4 == null) goto _L4; else goto _L3
_L3:
        context = JSONObjectInstrumentation.init(s4);
_L11:
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_229;
        }
        return (p)com.facebook.p.a("true", null, new o(new GraphRequest[] {
            s1
        })).get(0);
        context;
        throw new h("An error occurred while publishing install.", context);
        return new p(null, null, null, context);
_L2:
        s1 = s1.i();
        obj = ((SharedPreferences) (obj)).edit();
        ((android.content.SharedPreferences.Editor) (obj)).putLong(s3, System.currentTimeMillis());
        if (s1.b() == null) goto _L6; else goto _L5
_L5:
        context = s1.b();
        if (context instanceof JSONObject) goto _L8; else goto _L7
_L7:
        context = context.toString();
_L9:
        ((android.content.SharedPreferences.Editor) (obj)).putString(s2, context);
_L6:
        ((android.content.SharedPreferences.Editor) (obj)).apply();
        return s1;
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
        kc.b();
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
                        String s1 = (String)obj;
                        if (s1.toLowerCase(Locale.ROOT).startsWith("fb"))
                        {
                            d = s1.substring(2);
                        } else
                        {
                            d = s1;
                        }
                        d = (String)obj;
                    } else
                    if (obj instanceof Integer)
                    {
                        throw new h("App Ids cannot be directly placed in the manfiest.They mut be prexied by 'fb' or be placed in the string resource file.");
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
        Object obj1 = o;
        obj1;
        JVM INSTR monitorenter ;
        Executor executor;
        if (c != null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        executor = n();
        Object obj;
        obj = executor;
        if (executor != null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        obj = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, p, q);
        c = ((Executor) (obj));
        obj1;
        JVM INSTR monitorexit ;
        return c;
        Exception exception;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static String e()
    {
        return h;
    }

    public static Context f()
    {
        kc.b();
        return m;
    }

    public static String g()
    {
        return "4.5.0";
    }

    public static long h()
    {
        kc.b();
        return i.get();
    }

    public static String i()
    {
        kc.b();
        return d;
    }

    public static String j()
    {
        kc.b();
        return e;
    }

    public static String k()
    {
        kc.b();
        return f;
    }

    public static int l()
    {
        kc.b();
        return g;
    }

    public static int m()
    {
        kc.b();
        return n;
    }

    private static Executor n()
    {
        Object obj;
        try
        {
            obj = android/os/AsyncTask.getField("THREAD_POOL_EXECUTOR");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        try
        {
            obj = ((Field) (obj)).get(null);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        if (obj == null)
        {
            return null;
        }
        if (!(obj instanceof Executor))
        {
            return null;
        } else
        {
            return (Executor)obj;
        }
    }

    static 
    {
        b = new HashSet(Arrays.asList(new s[] {
            s.f
        }));
    }
}
