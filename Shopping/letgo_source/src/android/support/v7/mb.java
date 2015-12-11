// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package android.support.v7:
//            ma, lw, mh, me, 
//            mf

public class mb extends ma
{
    class a
    {

        final mb a;
        private String b;
        private boolean c;

        public String a()
        {
            return b;
        }

        public boolean b()
        {
            return c;
        }

        public a(String s, boolean flag)
        {
            a = mb.this;
            super();
            b = s;
            c = flag;
        }
    }

    private static final class b
        implements Runnable
    {

        private Context a;

        public void run()
        {
            AdvertisingIdClient advertisingidclient;
            advertisingidclient = new AdvertisingIdClient(a);
            advertisingidclient.start();
            android/support/v7/mb;
            JVM INSTR monitorenter ;
            if (mb.f() != null) goto _L2; else goto _L1
_L1:
            mb.a(advertisingidclient);
_L3:
            android/support/v7/mb;
            JVM INSTR monitorexit ;
_L4:
            mb.g().countDown();
            return;
_L2:
            advertisingidclient.finish();
              goto _L3
            Exception exception;
            exception;
            android/support/v7/mb;
            JVM INSTR monitorexit ;
            try
            {
                throw exception;
            }
            catch (c c1)
            {
                mb.a(true);
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

    protected mb(Context context, me me, mf mf, boolean flag)
    {
        super(context, me, mf);
        h = flag;
    }

    public static mb a(String s, Context context, boolean flag)
    {
        lw lw1;
        lw1 = new lw();
        a(s, context, ((me) (lw1)));
        if (!flag) goto _L2; else goto _L1
_L1:
        android/support/v7/mb;
        JVM INSTR monitorenter ;
        if (e == null)
        {
            (new Thread(new b(context))).start();
        }
        android/support/v7/mb;
        JVM INSTR monitorexit ;
_L2:
        return new mb(context, lw1, new mh(239), flag);
        s;
        android/support/v7/mb;
        JVM INSTR monitorexit ;
        throw s;
    }

    static AdvertisingIdClient a(AdvertisingIdClient advertisingidclient)
    {
        e = advertisingidclient;
        return advertisingidclient;
    }

    static boolean a(boolean flag)
    {
        g = flag;
        return flag;
    }

    static AdvertisingIdClient f()
    {
        return e;
    }

    static CountDownLatch g()
    {
        return f;
    }

    protected void a(Context context)
    {
        super.a(context);
        if (g || !h)
        {
            a(24, c(context));
            return;
        }
        String s;
        context = e();
        s = context.a();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        long l;
        if (context.b())
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

    a e()
        throws IOException
    {
        android/support/v7/mb;
        JVM INSTR monitorenter ;
        Object obj;
        if (f.await(2L, TimeUnit.SECONDS))
        {
            break MISSING_BLOCK_LABEL_57;
        }
        obj = new a(null, false);
        android/support/v7/mb;
        JVM INSTR monitorexit ;
        return ((a) (obj));
        Object obj1;
        obj1;
        obj1 = new a(null, false);
        android/support/v7/mb;
        JVM INSTR monitorexit ;
        return ((a) (obj1));
        obj1;
        android/support/v7/mb;
        JVM INSTR monitorexit ;
        throw obj1;
        if (e != null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        obj1 = new a(null, false);
        android/support/v7/mb;
        JVM INSTR monitorexit ;
        return ((a) (obj1));
        obj1 = e.getInfo();
        android/support/v7/mb;
        JVM INSTR monitorexit ;
        return new a(a(((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj1)).getId()), ((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj1)).isLimitAdTrackingEnabled());
    }

}
