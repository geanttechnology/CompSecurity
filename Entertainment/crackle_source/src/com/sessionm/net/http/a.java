// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.net.http;

import android.content.Context;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.sessionm.net.b;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.sessionm.net.http:
//            c

public class a
    implements com.sessionm.net.a
{

    private static final int bY = 10;
    private static final int bZ = 30;
    private static final int ge = 1;
    private static Class gh;
    private static int gi = 1;
    private static int gj;
    private ThreadPoolExecutor gf;
    private int gg;
    private int gk;

    public a(Context context)
    {
        this(context, false, true, new Object[0]);
    }

    public transient a(Context context, boolean flag, boolean flag1, Object aobj[])
    {
        gg = -1;
        gk = 1;
        if (aobj.length > 0)
        {
            gk = ((Integer)aobj[0]).intValue();
        }
        aobj = new PriorityBlockingQueue(10, new Comparator() {

            final a gl;

            public int a(c c1, c c2)
            {
                return c2.getPriority() - c1.getPriority();
            }

            public int compare(Object obj, Object obj1)
            {
                return a((c)obj, (c)obj1);
            }

            
            {
                gl = a.this;
                super();
            }
        });
        gf = new ThreadPoolExecutor(gk, gk, 30L, TimeUnit.SECONDS, ((java.util.concurrent.BlockingQueue) (aobj)));
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            try
            {
                gf.getClass().getMethod("allowCoreThreadTimeOut", new Class[] {
                    Boolean.TYPE
                }).invoke(gf, new Object[] {
                    Boolean.valueOf(true)
                });
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[]) { }
        }
        gf.setThreadFactory(new ThreadFactory() {

            final a gl;

            public Thread newThread(Runnable runnable)
            {
                runnable = new Thread(runnable);
                runnable.setName((new StringBuilder()).append("SessionM Thread-").append(a.bv()).toString());
                return runnable;
            }

            
            {
                gl = a.this;
                super();
            }
        });
        gf.prestartAllCoreThreads();
        CookieSyncManager.createInstance(context);
    }

    public static void a(Class class1)
    {
        gh = class1;
    }

    static int bv()
    {
        int i = gi;
        gi = i + 1;
        return i;
    }

    public void a(String s, String s1, String s2, b b, int i, Map map, int j, 
            File file)
    {
        if (gh != null)
        {
            if (Log.isLoggable("SessionM.Request", 3))
            {
                Log.d("SessionM.Request", "http client is using a test request.");
            }
            try
            {
                file = (c)gh.newInstance();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new RuntimeException("Error creating test request.", s);
            }
        } else
        {
            file = new c();
        }
        file.B(s);
        file.setMethod(s1);
        file.C(s2);
        file.a(b);
        CookieManager.getInstance().setAcceptCookie(true);
        file.r(i);
        file.e(System.currentTimeMillis());
        i = j;
        if (j == -1)
        {
            i = gg;
        }
        file.setTimeout(i);
        file.c(map);
        if (Log.isLoggable("SessionM.Request", 3))
        {
            Log.d("SessionM.Request", (new StringBuilder()).append("Enqueue request, URL: ").append(s).append(", max pool size: ").append(gf.getMaximumPoolSize()).append(", cur pool size: ").append(gf.getPoolSize()).append(", active threads: ").append(gf.getActiveCount()).toString());
        }
        gf.execute(file);
        gj++;
    }

    public int getRequestCount()
    {
        return gj;
    }

    public void n(int i)
    {
        gg = i;
    }

}
