// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import com.facebook.ads.a.c.c;
import com.facebook.ads.a.c.e;
import com.facebook.ads.a.c.f;
import com.facebook.ads.a.d.a;
import com.facebook.ads.a.f.p;
import com.facebook.ads.a.f.s;
import com.facebook.ads.d;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;
import org.json.JSONException;

// Referenced classes of package com.facebook.ads.a.e:
//            c, d, e, f

public final class b
{
    public static interface a
    {

        public abstract void a(com.facebook.ads.a.c c1);

        public abstract void a(com.facebook.ads.a.e.e e1);
    }


    public static final ThreadPoolExecutor d;
    private static final p h;
    Map a;
    public a b;
    public e c;
    private final com.facebook.ads.a.e.c e = com.facebook.ads.a.e.c.a();
    private com.facebook.ads.a.d.a f;
    private final String g;

    public b()
    {
        String s1 = com.facebook.ads.d.a();
        if (s.a(s1))
        {
            s1 = "https://graph.facebook.com/network_ads_common/";
        } else
        {
            s1 = String.format("https://graph.%s.facebook.com/network_ads_common/", new Object[] {
                s1
            });
        }
        g = s1;
    }

    static com.facebook.ads.a.d.a a(b b1, com.facebook.ads.a.d.a a1)
    {
        b1.f = a1;
        return a1;
    }

    static String a(b b1)
    {
        return b1.g;
    }

    static void a(b b1, com.facebook.ads.a.c c1)
    {
        b1.a(c1);
    }

    static void a(b b1, String s1)
    {
        b1.a(s1);
    }

    public static boolean a(Context context)
    {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0)
        {
            return true;
        }
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return context != null && context.isConnected();
    }

    static com.facebook.ads.a.d.c b(b b1)
    {
        return b1. new com.facebook.ads.a.d.c() {

            final b a;

            public final void a(String s1)
            {
                com.facebook.ads.a.f.d.b(com.facebook.ads.a.e.b.d(a));
                com.facebook.ads.a.e.b.a(a, null);
                com.facebook.ads.a.e.b.a(a, s1);
            }

            public final void a(Throwable throwable, String s1)
            {
                com.facebook.ads.a.f.d.b(com.facebook.ads.a.e.b.d(a));
                com.facebook.ads.a.e.b.a(a, null);
                Object obj;
                b b2;
                com.facebook.ads.a.a a1;
                com.facebook.ads.a.e.b.e(a);
                obj = com.facebook.ads.a.e.c.a(s1);
                if (((com.facebook.ads.a.e.d) (obj)).b != d.a.b)
                {
                    break MISSING_BLOCK_LABEL_83;
                }
                obj = ((com.facebook.ads.a.e.f)obj).c;
                b2 = a;
                a1 = com.facebook.ads.a.a.m;
                if (obj != null)
                {
                    s1 = ((String) (obj));
                }
                try
                {
                    com.facebook.ads.a.e.b.a(b2, a1.a(s1));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s1) { }
                com.facebook.ads.a.e.b.a(a, new com.facebook.ads.a.c(com.facebook.ads.a.a.b, throwable.getMessage()));
                return;
            }

            
            {
                a = b.this;
                super();
            }
        };
    }

    static com.facebook.ads.a.d.a c(b b1)
    {
        return b1.f;
    }

    static e d(b b1)
    {
        return b1.c;
    }

    static com.facebook.ads.a.e.c e(b b1)
    {
        return b1.e;
    }

    static a f(b b1)
    {
        return b1.b;
    }

    public final void a()
    {
        if (f != null)
        {
            com.facebook.ads.a.d.a a1 = f;
            Object obj = (List)a1.c.get(a1.d);
            if (obj != null)
            {
                obj = ((List) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    Future future = (Future)((WeakReference)((Iterator) (obj)).next()).get();
                    if (future != null)
                    {
                        future.cancel(true);
                    }
                } while (true);
            }
            a1.c.remove(a1.d);
            f = null;
        }
    }

    public final void a(com.facebook.ads.a.c c1)
    {
        if (b != null)
        {
            (new Handler(Looper.getMainLooper())).post(new Runnable(c1) {

                final com.facebook.ads.a.c a;
                final b b;

                public final void run()
                {
                    com.facebook.ads.a.e.b.f(b).a(a);
                }

            
            {
                b = b.this;
                a = c1;
                super();
            }
            });
        }
        a();
    }

    public final void a(String s1)
    {
        Object obj;
        static final class _cls5
        {

            static final int a[];

            static 
            {
                a = new int[com.facebook.ads.a.e.d.a.values().length];
                try
                {
                    a[com.facebook.ads.a.e.d.a.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[d.a.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        c c1;
        try
        {
            obj = com.facebook.ads.a.e.c.a(s1);
            c1 = ((com.facebook.ads.a.e.d) (obj)).a;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            a(com.facebook.ads.a.a.k.a(s1.getMessage()));
            return;
        }
        if (c1 == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        com.facebook.ads.a.f.d.a(c1.c.c(), c);
        com.facebook.ads.a.e._cls5.a[((com.facebook.ads.a.e.d) (obj)).b.ordinal()];
        JVM INSTR tableswitch 1 2: default 178
    //                   1 72
    //                   2 150;
           goto _L1 _L2 _L3
_L1:
        a(com.facebook.ads.a.a.l.a(s1));
        return;
_L2:
        obj = (com.facebook.ads.a.e.e)obj;
        if (c1 == null) goto _L5; else goto _L4
_L4:
        if (c1.c.d())
        {
            com.facebook.ads.a.f.d.a(s1, c);
        }
_L5:
        if (b != null)
        {
            (new Handler(Looper.getMainLooper())).post(new Runnable(((com.facebook.ads.a.e.e) (obj))) {

                final com.facebook.ads.a.e.e a;
                final b b;

                public final void run()
                {
                    com.facebook.ads.a.e.b.f(b).a(a);
                }

            
            {
                b = b.this;
                a = e1;
                super();
            }
            });
        }
        a();
        return;
_L3:
        String s2;
        s2 = ((com.facebook.ads.a.e.f)obj).c;
        obj = com.facebook.ads.a.a.m;
        if (s2 != null)
        {
            s1 = s2;
        }
        a(((com.facebook.ads.a.a) (obj)).a(s1));
        return;
    }

    static 
    {
        p p1 = new p();
        h = p1;
        d = (ThreadPoolExecutor)Executors.newCachedThreadPool(p1);
    }

    // Unreferenced inner class com/facebook/ads/a/e/b$1

/* anonymous class */
    public final class _cls1
        implements Runnable
    {

        final Context a;
        final e b;
        final b c;

        public final void run()
        {
            com.facebook.ads.a.c.f.b(a);
            c.a = b.c();
            Object obj;
            Object obj1;
            com.facebook.ads.a.d.a a1;
            Object obj2;
            Object obj3;
            try
            {
                com.facebook.ads.a.e.b.a(c, new com.facebook.ads.a.d.a(a, b.e));
                a1 = com.facebook.ads.a.e.b.c(c);
                obj2 = com.facebook.ads.a.e.b.a(c);
                obj1 = new com.facebook.ads.a.d.d(c.a);
                obj = b.b(c);
                obj3 = ((com.facebook.ads.a.d.d) (obj1)).a();
                obj1 = a1.b;
                obj2 = new HttpPost(((String) (obj2)));
            }
            catch (Exception exception)
            {
                com.facebook.ads.a.e.b.a(c, com.facebook.ads.a.a.i.a(exception.getMessage()));
                return;
            }
            if (obj3 == null)
            {
                break MISSING_BLOCK_LABEL_121;
            }
            ((HttpEntityEnclosingRequestBase) (obj2)).setEntity(((org.apache.http.HttpEntity) (obj3)));
            obj3 = new SyncBasicHttpContext(new BasicHttpContext());
            obj2 = com.facebook.ads.a.d.a.a.submit(new com.facebook.ads.a.d.b(((org.apache.http.impl.client.AbstractHttpClient) (obj1)), ((org.apache.http.protocol.HttpContext) (obj3)), ((org.apache.http.client.methods.HttpUriRequest) (obj2)), ((com.facebook.ads.a.d.c) (obj))));
            obj1 = (List)a1.c.get(a1.d);
            obj = obj1;
            if (obj1 != null)
            {
                break MISSING_BLOCK_LABEL_204;
            }
            obj = new LinkedList();
            a1.c.put(a1.d, obj);
            ((List) (obj)).add(new WeakReference(obj2));
            return;
        }

            public 
            {
                c = b.this;
                a = context;
                b = e1;
                super();
            }
    }

}
