// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;
import com.google.android.gms.d.ii;
import com.google.android.gms.d.ij;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.e:
//            aj

public final class e
{
    public static interface a
    {

        public abstract com.google.android.gms.ads.identifier.AdvertisingIdClient.Info a();
    }


    private static Object j = new Object();
    private static e k;
    volatile com.google.android.gms.ads.identifier.AdvertisingIdClient.Info a;
    private volatile long b;
    private volatile long c;
    private volatile boolean d;
    private volatile long e;
    private final Context f;
    private final ii g;
    private final Thread h;
    private a i = new a() {

        final e a;

        public final com.google.android.gms.ads.identifier.AdvertisingIdClient.Info a()
        {
            com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info;
            try
            {
                info = AdvertisingIdClient.getAdvertisingIdInfo(e.a(a));
            }
            catch (IllegalStateException illegalstateexception)
            {
                aj.a();
                return null;
            }
            catch (d d1)
            {
                aj.a();
                return null;
            }
            catch (IOException ioexception)
            {
                aj.a();
                return null;
            }
            catch (c c1)
            {
                aj.a();
                return null;
            }
            catch (Exception exception)
            {
                aj.a();
                return null;
            }
            return info;
        }

            
            {
                a = e.this;
                super();
            }
    };

    private e(Context context)
    {
        this(context, ij.d());
    }

    private e(Context context, ii ii1)
    {
        b = 0xdbba0L;
        c = 30000L;
        d = false;
        g = ii1;
        if (context != null)
        {
            f = context.getApplicationContext();
        } else
        {
            f = context;
        }
        h = new Thread(new Runnable() {

            final e a;

            public final void run()
            {
                e.b(a);
            }

            
            {
                a = e.this;
                super();
            }
        });
    }

    static Context a(e e1)
    {
        return e1.f;
    }

    public static e a(Context context)
    {
        if (k == null)
        {
            synchronized (j)
            {
                if (k == null)
                {
                    context = new e(context);
                    k = context;
                    ((e) (context)).h.start();
                }
            }
        }
        return k;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    static void b(e e1)
    {
        Process.setThreadPriority(10);
        while (!e1.d) 
        {
            try
            {
                e1.a = e1.i.a();
                Thread.sleep(e1.b);
            }
            catch (InterruptedException interruptedexception)
            {
                com.google.android.gms.e.aj.c();
            }
        }
    }

    final void a()
    {
        if (g.a() - e < c)
        {
            return;
        } else
        {
            h.interrupt();
            e = g.a();
            return;
        }
    }

}
