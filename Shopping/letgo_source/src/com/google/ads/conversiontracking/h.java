// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.conversiontracking;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.util.Log;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

// Referenced classes of package com.google.ads.conversiontracking:
//            i, j, g

public class h
{
    private class a
        implements Runnable
    {

        final h a;

        public void run()
        {
label0:
            {
                synchronized (h.a(a))
                {
                    if (h.b(a) && j.d(h.c(a)) && !h.d(a))
                    {
                        break label0;
                    }
                }
                return;
            }
            h.f(a).addAll(h.e(a).a(100L));
            j.c(h.c(a));
            h.a(a, true);
            h.a(a).notify();
            obj;
            JVM INSTR monitorexit ;
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private a()
        {
            a = h.this;
            super();
        }

    }

    public class b
        implements Runnable
    {

        protected long a;
        final h b;

        private void a()
        {
            if (a == 0L)
            {
                a = 1000L;
                return;
            } else
            {
                a = Math.min(a * 2L, 60000L);
                return;
            }
        }

        public void run()
        {
            h.b(b, true);
_L2:
            Object obj = h.a(b);
            obj;
            JVM INSTR monitorenter ;
            for (; h.f(b).isEmpty(); h.a(b).wait())
            {
                h.a(b, false);
            }

            break MISSING_BLOCK_LABEL_80;
            Exception exception;
            exception;
            obj;
            JVM INSTR monitorexit ;
            try
            {
                throw exception;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.w("GoogleConversionReporter", "Dispatch thread is interrupted.");
            }
            h.b(b, false);
            return;
            g g1;
            h.a(b, true);
            g1 = (g)h.f(b).remove(0);
            obj;
            JVM INSTR monitorexit ;
            if (g1 == null) goto _L2; else goto _L1
_L1:
label0:
            {
                if (j.a(h.c(b), g1.e, g1.f, g1.b))
                {
                    break label0;
                }
                h.e(b).a(g1);
            }
              goto _L2
            int k = b.a(g1);
            if (k != 2)
            {
                break MISSING_BLOCK_LABEL_184;
            }
            h.e(b).a(g1);
            a = 0L;
              goto _L2
            if (k != 0)
            {
                break MISSING_BLOCK_LABEL_213;
            }
            h.e(b).c(g1);
            a();
            Thread.sleep(a);
              goto _L2
            h.e(b).c(g1);
            a = 0L;
              goto _L2
        }

        public b()
        {
            b = h.this;
            super();
            a = 0L;
        }
    }


    private final Object a = new Object();
    private final List b = new LinkedList();
    private Context c;
    private boolean d;
    private boolean e;
    private i f;

    public h(Context context)
    {
        d = true;
        e = false;
        c = context;
        f = new i(context);
        (new Thread(new b())).start();
        ScheduledThreadPoolExecutor scheduledthreadpoolexecutor = new ScheduledThreadPoolExecutor(1);
        long l = (j.b(context) + 0x493e0L) - j.a();
        context = new a();
        if (l <= 0L)
        {
            l = 0L;
        }
        scheduledthreadpoolexecutor.scheduleAtFixedRate(context, l, 0x493e0L, TimeUnit.MILLISECONDS);
    }

    static Object a(h h1)
    {
        return h1.a;
    }

    static boolean a(h h1, boolean flag)
    {
        h1.d = flag;
        return flag;
    }

    private void b(g g1)
    {
        if (!g1.b && g1.a)
        {
            j.a(c, g1.e, g1.f);
        }
    }

    static boolean b(h h1)
    {
        return h1.e;
    }

    static boolean b(h h1, boolean flag)
    {
        h1.e = flag;
        return flag;
    }

    static Context c(h h1)
    {
        return h1.c;
    }

    static boolean d(h h1)
    {
        return h1.d;
    }

    static i e(h h1)
    {
        return h1.f;
    }

    static List f(h h1)
    {
        return h1.b;
    }

    protected int a(g g1)
    {
        Object obj1;
        AndroidHttpClient androidhttpclient;
        obj1 = null;
        androidhttpclient = AndroidHttpClient.newInstance(System.getProperty("http.agent"), c);
        Object obj = String.valueOf(g1.g);
        if (((String) (obj)).length() == 0) goto _L2; else goto _L1
_L1:
        obj = "Pinging: ".concat(((String) (obj)));
_L7:
        HttpGet httpget;
        Log.i("GoogleConversionReporter", ((String) (obj)));
        httpget = new HttpGet(g1.g);
        if (androidhttpclient instanceof HttpClient) goto _L4; else goto _L3
_L3:
        obj = androidhttpclient.execute(httpget);
_L8:
        int k;
        k = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        Log.i("GoogleConversionReporter", (new StringBuilder(33)).append("Receive response code ").append(k).toString());
        obj = ((HttpResponse) (obj)).getEntity();
        if (obj == null) goto _L6; else goto _L5
_L5:
        ((HttpEntity) (obj)).consumeContent();
          goto _L6
_L9:
        if (k != 2)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        b(g1);
        androidhttpclient.close();
        return k;
_L2:
        obj = new String("Pinging: ");
          goto _L7
        g1;
        obj = obj1;
_L10:
        Log.e("GoogleConversionReporter", "Error sending ping", g1);
        if (obj != null)
        {
            try
            {
                ((HttpUriRequest) (obj)).abort();
            }
            // Misplaced declaration of an exception variable
            catch (g g1) { }
            finally
            {
                androidhttpclient.close();
            }
        }
        androidhttpclient.close();
        return 0;
_L4:
        obj = HttpInstrumentation.execute((HttpClient)androidhttpclient, httpget);
          goto _L8
_L12:
        k = 1;
          goto _L9
        throw g1;
        g1;
        obj = httpget;
          goto _L10
_L6:
        if (k != 200) goto _L12; else goto _L11
_L11:
        k = 2;
          goto _L9
    }

    protected void a(Runnable runnable)
    {
        (new Thread(runnable)).start();
    }

    public void a(String s, j.c c1, boolean flag, boolean flag1, boolean flag2)
    {
        c1 = new g(s, c1, flag, flag1);
        s = ((String) (a));
        s;
        JVM INSTR monitorenter ;
        if (flag2)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        a(new Runnable(c1) {

            final g a;
            final h b;

            public void run()
            {
                b.a(a);
            }

            
            {
                b = h.this;
                a = g1;
                super();
            }
        });
        s;
        JVM INSTR monitorexit ;
        return;
        f.b(c1);
        if (e && j.d(c))
        {
            b.add(c1);
            d = true;
            a.notify();
        }
        s;
        JVM INSTR monitorexit ;
        return;
        c1;
        s;
        JVM INSTR monitorexit ;
        throw c1;
    }
}
