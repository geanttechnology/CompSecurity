// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import com.facebook.a.a;
import com.facebook.b.b;
import com.facebook.b.c;
import com.facebook.b.d;
import com.facebook.b.n;
import com.facebook.b.p;
import com.facebook.b.t;
import com.facebook.b.u;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
//            s, h, p, j, 
//            GraphRequest, o, b, a, 
//            u, t, AccessToken, Profile

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
    private static n l;
    private static Context m;
    private static int n = 64206;
    private static final Object o = new Object();
    private static final BlockingQueue p = new LinkedBlockingQueue(10);
    private static final ThreadFactory q = new ThreadFactory() {

        private final AtomicInteger a = new AtomicInteger(0);

        public final Thread newThread(Runnable runnable)
        {
            return new Thread(runnable, (new StringBuilder("FacebookSdk #")).append(a.incrementAndGet()).toString());
        }

    };
    private static Boolean r = Boolean.valueOf(false);

    public k()
    {
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
        u.a(context, "applicationContext");
        u.b(context, false);
        u.a(context, false);
        context = context.getApplicationContext();
        m = context;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        if (((ApplicationInfo) (context)).metaData != null)
        {
            break; /* Loop/switch isn't completed */
        }
_L11:
        t.a(m, d);
        com.facebook.b.p.b();
        com.facebook.b.d.a(m);
        l = new n(new Callable() {

            public final Object call()
            {
                return com.facebook.k.p().getCacheDir();
            }

        });
        context = new FutureTask(new Callable(a1) {

            final a a;

            public final Object call()
            {
                Object obj1 = com.facebook.b.a();
                Object obj2 = ((com.facebook.b) (obj1)).a.a();
                if (obj2 != null)
                {
                    ((com.facebook.b) (obj1)).a(((AccessToken) (obj2)), false);
                }
                obj1 = com.facebook.u.a();
                obj2 = ((com.facebook.u) (obj1)).a.a();
                if (obj2 != null)
                {
                    ((com.facebook.u) (obj1)).a(((Profile) (obj2)), false);
                }
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

            
            {
                a = a1;
                super();
            }
        });
        e().execute(context);
        r = Boolean.valueOf(true);
        if (true) goto _L4; else goto _L3
        context;
        throw context;
_L3:
        if (d != null) goto _L6; else goto _L5
_L5:
        Object obj = ((ApplicationInfo) (context)).metaData.get("com.facebook.sdk.ApplicationId");
        if (!(obj instanceof String)) goto _L8; else goto _L7
_L7:
        obj = (String)obj;
        if (!((String) (obj)).toLowerCase(Locale.ROOT).startsWith("fb")) goto _L10; else goto _L9
_L9:
        d = ((String) (obj)).substring(2);
_L6:
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
            g = ((ApplicationInfo) (context)).metaData.getInt("com.facebook.sdk.WebDialogTheme");
        }
          goto _L11
_L10:
        d = ((String) (obj));
          goto _L6
_L8:
        if (!(obj instanceof Integer)) goto _L6; else goto _L12
_L12:
        throw new h("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
        context;
          goto _L11
    }

    public static void a(Context context, String s1)
    {
        context = context.getApplicationContext();
        e().execute(new Runnable(context, s1) {

            final Context a;
            final String b;

            public final void run()
            {
                com.facebook.k.b(a, b);
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
        if (j && b.contains(s1))
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

    static com.facebook.p b(Context context, String s1)
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
                t.a(context);
            }
            return new com.facebook.p(null, null, new j(null, context));
        }
        String s2;
        String s3;
        SharedPreferences sharedpreferences;
        String s4;
        c c1;
        long l1;
        c1 = com.facebook.b.c.a(context);
        sharedpreferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
        s2 = (new StringBuilder()).append(s1).append("ping").toString();
        s3 = (new StringBuilder()).append(s1).append("json").toString();
        l1 = sharedpreferences.getLong(s2, 0L);
        s4 = sharedpreferences.getString(s3, null);
        context = com.facebook.b.b.a(com.facebook.b.b.a.a, c1, com.facebook.a.a.d(context), b(context), context);
        s1 = com.facebook.GraphRequest.a(String.format("%s/activities", new Object[] {
            s1
        }), context);
        if (l1 == 0L) goto _L2; else goto _L1
_L1:
        if (s4 == null) goto _L4; else goto _L3
_L3:
        context = new JSONObject(s4);
_L6:
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        return (com.facebook.p)com.facebook.p.a("true", null, new o(new GraphRequest[] {
            s1
        })).get(0);
        context;
        throw new h("An error occurred while publishing install.", context);
        return new com.facebook.p(null, null, null, context);
_L2:
        context = s1.a();
        s1 = sharedpreferences.edit();
        s1.putLong(s2, System.currentTimeMillis());
        if (((com.facebook.p) (context)).a != null)
        {
            s1.putString(s3, ((com.facebook.p) (context)).a.toString());
        }
        s1.apply();
        return context;
_L4:
        context = null;
        continue; /* Loop/switch isn't completed */
        context;
        context = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static boolean b()
    {
        return j;
    }

    public static boolean b(Context context)
    {
        u.b();
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    public static String c(Context context)
    {
        u.b();
        PackageManager packagemanager;
        if (context != null)
        {
            if ((packagemanager = context.getPackageManager()) != null)
            {
                context = context.getPackageName();
                Signature asignature[];
                try
                {
                    context = packagemanager.getPackageInfo(context, 64);
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    return null;
                }
                asignature = ((PackageInfo) (context)).signatures;
                if (asignature != null && asignature.length != 0)
                {
                    MessageDigest messagedigest;
                    try
                    {
                        messagedigest = MessageDigest.getInstance("SHA-1");
                    }
                    // Misplaced declaration of an exception variable
                    catch (Context context)
                    {
                        return null;
                    }
                    messagedigest.update(((PackageInfo) (context)).signatures[0].toByteArray());
                    return Base64.encodeToString(messagedigest.digest(), 9);
                }
            }
        }
        return null;
    }

    public static void c()
    {
        j = false;
    }

    public static boolean d()
    {
        return k;
    }

    public static Executor e()
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

    public static String f()
    {
        return h;
    }

    public static Context g()
    {
        u.b();
        return m;
    }

    public static String h()
    {
        return "4.7.0";
    }

    public static long i()
    {
        u.b();
        return i.get();
    }

    public static String j()
    {
        u.b();
        return d;
    }

    public static String k()
    {
        u.b();
        return e;
    }

    public static String l()
    {
        u.b();
        return f;
    }

    public static int m()
    {
        u.b();
        return g;
    }

    public static void n()
    {
        g = 0x7f0c012f;
    }

    public static int o()
    {
        u.b();
        return n;
    }

    static Context p()
    {
        return m;
    }

    static 
    {
        b = new HashSet(Arrays.asList(new s[] {
            s.f
        }));
    }
}
