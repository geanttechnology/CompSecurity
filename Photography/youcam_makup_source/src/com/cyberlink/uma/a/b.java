// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.uma.a;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.cyberlink.uma.a:
//            g, h, f, c, 
//            a

class b
{

    private f a;
    private final ExecutorService b = Executors.newSingleThreadExecutor(new ThreadFactory() {

        final b a;

        public Thread newThread(Runnable runnable)
        {
            runnable = new Thread(runnable, "CountlyConnectionQueue");
            try
            {
                runnable.setPriority(4);
            }
            catch (Throwable throwable)
            {
                return runnable;
            }
            return runnable;
        }

            
            {
                a = b.this;
                super();
            }
    });
    private String c;
    private Context d;
    private String e;
    private Future f;
    private String g;
    private String h;

    b()
    {
    }

    private String g()
    {
        Object obj = new g();
        String s = (new StringBuilder()).append("app_key=").append(c).append("&device_id=").append(com.cyberlink.uma.a.h.a()).append("&timestamp=").append(((g) (obj)).a()).append("&tz=").append(((g) (obj)).b()).append("&metrics=").append(h).toString();
        obj = s;
        if (g != null)
        {
            obj = (new StringBuilder()).append(s).append("&vendor_info=").append(g).toString();
        }
        return ((String) (obj));
    }

    String a()
    {
        return c;
    }

    void a(int i)
    {
        d();
        if (i > 0)
        {
            String s = (new StringBuilder()).append(g()).append("&session_duration=").append(i).toString();
            a.a(s);
            f();
        }
    }

    void a(Context context)
    {
        d = context;
        h = com.cyberlink.uma.a.h.e(d);
    }

    void a(f f1)
    {
        a = f1;
    }

    void a(String s)
    {
        c = s;
    }

    Context b()
    {
        return d;
    }

    void b(int i)
    {
        d();
        String s1 = (new StringBuilder()).append(g()).append("&end_session=1").toString();
        String s = s1;
        if (i > 0)
        {
            s = (new StringBuilder()).append(s1).append("&session_duration=").append(i).toString();
        }
        a.a(s);
        f();
    }

    void b(String s)
    {
        e = s;
    }

    String c()
    {
        return e;
    }

    void c(String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        s = URLEncoder.encode(s, "UTF-8");
_L1:
        g = s;
        return;
        s = null;
          goto _L1
        s;
    }

    void d()
    {
        if (d == null)
        {
            throw new IllegalStateException("context has not been set");
        }
        if (c == null || c.length() == 0)
        {
            throw new IllegalStateException("app key has not been set");
        }
        if (a == null)
        {
            throw new IllegalStateException("countly store has not been set");
        }
        if (e == null || !com.cyberlink.uma.a.c.a(e))
        {
            throw new IllegalStateException("server URL is not valid");
        } else
        {
            return;
        }
    }

    void d(String s)
    {
        d();
        s = (new StringBuilder()).append(g()).append("&events=").append(s).toString();
        a.a(s);
        f();
    }

    void e()
    {
        d();
        String s = (new StringBuilder()).append(g()).append("&sdk_version=").append("2.0").append("&begin_session=1").toString();
        a.a(s);
        f();
    }

    void f()
    {
        if (!a.d() && (f == null || f.isDone()))
        {
            f = b.submit(new a(e, a));
        }
    }
}
