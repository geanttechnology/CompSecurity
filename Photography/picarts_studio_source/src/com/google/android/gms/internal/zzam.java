// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.internal:
//            zzal, zzah, zzas, zzap, 
//            zzaq

public class zzam extends zzal
{

    private static AdvertisingIdClient zznq = null;
    private static CountDownLatch zznr = new CountDownLatch(1);
    private static volatile boolean zzns;
    private boolean zznt;

    protected zzam(Context context, zzap zzap, zzaq zzaq, boolean flag)
    {
        super(context, zzap, zzaq);
        zznt = flag;
    }

    static AdvertisingIdClient zzZ()
    {
        return zznq;
    }

    static AdvertisingIdClient zza(AdvertisingIdClient advertisingidclient)
    {
        zznq = advertisingidclient;
        return advertisingidclient;
    }

    public static zzam zza(String s, Context context, boolean flag)
    {
        zzah zzah1;
        zzah1 = new zzah();
        zza(s, context, ((zzap) (zzah1)));
        if (!flag) goto _L2; else goto _L1
_L1:
        com/google/android/gms/internal/zzam;
        JVM INSTR monitorenter ;
        if (zznq == null)
        {
            (new Thread(new zzb(context))).start();
        }
        com/google/android/gms/internal/zzam;
        JVM INSTR monitorexit ;
_L2:
        return new zzam(context, zzah1, new zzas(239), flag);
        s;
        com/google/android/gms/internal/zzam;
        JVM INSTR monitorexit ;
        throw s;
    }

    static boolean zza(boolean flag)
    {
        zzns = flag;
        return flag;
    }

    static CountDownLatch zzaa()
    {
        return zznr;
    }

    zza zzY()
    {
label0:
        {
            zza zza1;
            try
            {
                if (zznr.await(2L, TimeUnit.SECONDS))
                {
                    break label0;
                }
                zza1 = new zza(null, false);
            }
            catch (InterruptedException interruptedexception)
            {
                return new zza(null, false);
            }
            return zza1;
        }
        com/google/android/gms/internal/zzam;
        JVM INSTR monitorenter ;
        Object obj;
        if (zznq != null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        obj = new zza(null, false);
        com/google/android/gms/internal/zzam;
        JVM INSTR monitorexit ;
        return ((zza) (obj));
        Exception exception;
        exception;
        com/google/android/gms/internal/zzam;
        JVM INSTR monitorexit ;
        throw exception;
        exception = zznq.getInfo();
        com/google/android/gms/internal/zzam;
        JVM INSTR monitorexit ;
        return new zza(zzk(exception.getId()), exception.isLimitAdTrackingEnabled());
    }

    protected void zzc(Context context)
    {
        super.zzc(context);
        if (zzns || !zznt)
        {
            zza(24, zze(context));
            return;
        }
        String s;
        context = zzY();
        s = context.getId();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        long l;
        if (context.isLimitAdTrackingEnabled())
        {
            l = 1L;
        } else
        {
            l = 0L;
        }
        try
        {
            zza(28, l);
            zza(26, 5L);
            zza(24, s);
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


    private class zzb
        implements Runnable
    {

        private Context zznx;

        public final void run()
        {
            com/google/android/gms/internal/zzam;
            JVM INSTR monitorenter ;
            if (zzam.zzZ() == null)
            {
                AdvertisingIdClient advertisingidclient = new AdvertisingIdClient(zznx);
                advertisingidclient.start();
                zzam.zza(advertisingidclient);
            }
            zzam.zzaa().countDown();
_L1:
            com/google/android/gms/internal/zzam;
            JVM INSTR monitorexit ;
            return;
            Object obj;
            obj;
            zzam.zza(true);
            zzam.zzaa().countDown();
              goto _L1
            obj;
            com/google/android/gms/internal/zzam;
            JVM INSTR monitorexit ;
            throw obj;
            obj;
            zzam.zzaa().countDown();
              goto _L1
            obj;
            zzam.zzaa().countDown();
              goto _L1
            obj;
            zzam.zzaa().countDown();
            throw obj;
        }

        public zzb(Context context)
        {
            zznx = context.getApplicationContext();
            if (zznx == null)
            {
                zznx = context;
            }
        }
    }


    private class zza
    {

        private String zznu;
        private boolean zznv;
        final zzam zznw;

        public String getId()
        {
            return zznu;
        }

        public boolean isLimitAdTrackingEnabled()
        {
            return zznv;
        }

        public zza(String s, boolean flag)
        {
            zznw = zzam.this;
            super();
            zznu = s;
            zznv = flag;
        }
    }

}
