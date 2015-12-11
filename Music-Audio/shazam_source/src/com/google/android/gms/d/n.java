// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.d:
//            m, i, t, q, 
//            r

public class n extends m
{
    final class a
    {

        String a;
        boolean b;
        final n c;

        public a(String s, boolean flag)
        {
            c = n.this;
            super();
            a = s;
            b = flag;
        }
    }

    private static final class b
        implements Runnable
    {

        private Context a;

        public final void run()
        {
            AdvertisingIdClient advertisingidclient;
            advertisingidclient = new AdvertisingIdClient(a);
            advertisingidclient.start();
            com/google/android/gms/d/n;
            JVM INSTR monitorenter ;
            if (n.a() != null) goto _L2; else goto _L1
_L1:
            n.a(advertisingidclient);
_L3:
            com/google/android/gms/d/n;
            JVM INSTR monitorexit ;
_L4:
            com.google.android.gms.d.n.c().countDown();
            return;
_L2:
            advertisingidclient.finish();
              goto _L3
            Exception exception;
            exception;
            com/google/android/gms/d/n;
            JVM INSTR monitorexit ;
            try
            {
                throw exception;
            }
            catch (c c1)
            {
                n.b();
            }
            catch (IOException ioexception) { }
            catch (d d1) { }
              goto _L4
        }

        public b(Context context)
        {
            a = context.getApplicationContext();
            if (a == null)
            {
                a = context;
            }
        }
    }


    private static AdvertisingIdClient e = null;
    private static CountDownLatch f = new CountDownLatch(1);
    private static boolean g;
    private boolean h;

    private n(Context context, q q, r r, boolean flag)
    {
        super(context, q, r);
        h = flag;
    }

    static AdvertisingIdClient a()
    {
        return e;
    }

    static AdvertisingIdClient a(AdvertisingIdClient advertisingidclient)
    {
        e = advertisingidclient;
        return advertisingidclient;
    }

    public static n a(String s, Context context, boolean flag)
    {
        i j;
        j = new i();
        a(s, context, ((q) (j)));
        if (!flag) goto _L2; else goto _L1
_L1:
        com/google/android/gms/d/n;
        JVM INSTR monitorenter ;
        if (e == null)
        {
            (new Thread(new b(context))).start();
        }
        com/google/android/gms/d/n;
        JVM INSTR monitorexit ;
_L2:
        return new n(context, j, new t(), flag);
        s;
        com/google/android/gms/d/n;
        JVM INSTR monitorexit ;
        throw s;
    }

    static boolean b()
    {
        g = true;
        return true;
    }

    static CountDownLatch c()
    {
        return f;
    }

    private a d()
    {
        com/google/android/gms/d/n;
        JVM INSTR monitorenter ;
        Object obj;
        if (f.await(2L, TimeUnit.SECONDS))
        {
            break MISSING_BLOCK_LABEL_57;
        }
        obj = new a(null, false);
        com/google/android/gms/d/n;
        JVM INSTR monitorexit ;
        return ((a) (obj));
        Object obj1;
        obj1;
        obj1 = new a(null, false);
        com/google/android/gms/d/n;
        JVM INSTR monitorexit ;
        return ((a) (obj1));
        obj1;
        com/google/android/gms/d/n;
        JVM INSTR monitorexit ;
        throw obj1;
        if (e != null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        obj1 = new a(null, false);
        com/google/android/gms/d/n;
        JVM INSTR monitorexit ;
        return ((a) (obj1));
        obj1 = e.getInfo();
        com/google/android/gms/d/n;
        JVM INSTR monitorexit ;
        return new a(a(((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj1)).getId()), ((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj1)).isLimitAdTrackingEnabled());
    }

    protected final void b(Context context)
    {
        super.b(context);
        if (g || !h)
        {
            a(24, d(context));
            return;
        }
        String s;
        context = d();
        s = ((a) (context)).a;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        long l;
        if (((a) (context)).b)
        {
            l = 1L;
        } else
        {
            l = 0L;
        }
        try
        {
            a(28, l);
            a(26, 5L);
            a(24, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
    }

}
