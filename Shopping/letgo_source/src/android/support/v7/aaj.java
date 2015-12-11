// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;
import java.io.IOException;

// Referenced classes of package android.support.v7:
//            vo, abo, vn

public class aaj
{
    public static interface a
    {

        public abstract com.google.android.gms.ads.identifier.AdvertisingIdClient.Info a();
    }


    private static Object j = new Object();
    private static aaj k;
    private volatile long a;
    private volatile long b;
    private volatile boolean c;
    private volatile com.google.android.gms.ads.identifier.AdvertisingIdClient.Info d;
    private volatile long e;
    private final Context f;
    private final vn g;
    private final Thread h;
    private a i = new a() {

        final aaj a;

        public com.google.android.gms.ads.identifier.AdvertisingIdClient.Info a()
        {
            com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info;
            try
            {
                info = AdvertisingIdClient.getAdvertisingIdInfo(aaj.a(a));
            }
            catch (IllegalStateException illegalstateexception)
            {
                abo.b("IllegalStateException getting Advertising Id Info");
                return null;
            }
            catch (d d1)
            {
                abo.b("GooglePlayServicesRepairableException getting Advertising Id Info");
                return null;
            }
            catch (IOException ioexception)
            {
                abo.b("IOException getting Ad Id Info");
                return null;
            }
            catch (c c1)
            {
                abo.b("GooglePlayServicesNotAvailableException getting Advertising Id Info");
                return null;
            }
            catch (Exception exception)
            {
                abo.b("Unknown exception. Could not get the Advertising Id Info.");
                return null;
            }
            return info;
        }

            
            {
                a = aaj.this;
                super();
            }
    };

    private aaj(Context context)
    {
        this(context, null, android.support.v7.vo.d());
    }

    public aaj(Context context, a a1, vn vn1)
    {
        a = 0xdbba0L;
        b = 30000L;
        c = false;
        g = vn1;
        if (context != null)
        {
            f = context.getApplicationContext();
        } else
        {
            f = context;
        }
        if (a1 != null)
        {
            i = a1;
        }
        h = new Thread(new Runnable() {

            final aaj a;

            public void run()
            {
                aaj.b(a);
            }

            
            {
                a = aaj.this;
                super();
            }
        });
    }

    static Context a(aaj aaj1)
    {
        return aaj1.f;
    }

    public static aaj a(Context context)
    {
        if (k == null)
        {
            synchronized (j)
            {
                if (k == null)
                {
                    k = new aaj(context);
                    k.d();
                }
            }
        }
        return k;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    static void b(aaj aaj1)
    {
        aaj1.e();
    }

    private void e()
    {
        Process.setThreadPriority(10);
        while (!c) 
        {
            try
            {
                d = i.a();
                Thread.sleep(a);
            }
            catch (InterruptedException interruptedexception)
            {
                android.support.v7.abo.c("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    private void f()
    {
        if (g.a() - e < b)
        {
            return;
        } else
        {
            c();
            e = g.a();
            return;
        }
    }

    public String a()
    {
        f();
        if (d == null)
        {
            return null;
        } else
        {
            return d.getId();
        }
    }

    public boolean b()
    {
        f();
        if (d == null)
        {
            return true;
        } else
        {
            return d.isLimitAdTrackingEnabled();
        }
    }

    public void c()
    {
        h.interrupt();
    }

    public void d()
    {
        h.start();
    }

}
