// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzbg

public class zza
{

    private static Object zzaVD = new Object();
    private static com.google.android.gms.tagmanager.zza zzaVE;
    private volatile boolean mClosed;
    private final Context mContext;
    private final Thread zzIl;
    private volatile com.google.android.gms.ads.identifier.AdvertisingIdClient.Info zzMr;
    private volatile long zzaVA;
    private volatile long zzaVB;
    private zza zzaVC;
    private volatile long zzaVz;
    private final zzmn zzpW;

    private zza(Context context)
    {
        this(context, null, zzmp.zzqt());
    }

    public zza(Context context, zza zza1, zzmn zzmn1)
    {
        zzaVz = 0xdbba0L;
        zzaVA = 30000L;
        mClosed = false;
        zzaVC = new _cls1();
        zzpW = zzmn1;
        if (context != null)
        {
            mContext = context.getApplicationContext();
        } else
        {
            mContext = context;
        }
        if (zza1 != null)
        {
            zzaVC = zza1;
        }
        zzIl = new Thread(new _cls2());
    }

    private void zzCl()
    {
        Process.setThreadPriority(10);
        while (!mClosed) 
        {
            try
            {
                zzMr = zzaVC.zzCn();
                Thread.sleep(zzaVz);
            }
            catch (InterruptedException interruptedexception)
            {
                zzbg.zzaG("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    private void zzCm()
    {
        if (zzpW.currentTimeMillis() - zzaVB < zzaVA)
        {
            return;
        } else
        {
            interrupt();
            zzaVB = zzpW.currentTimeMillis();
            return;
        }
    }

    static Context zza(com.google.android.gms.tagmanager.zza zza1)
    {
        return zza1.mContext;
    }

    public static com.google.android.gms.tagmanager.zza zzaN(Context context)
    {
        if (zzaVE == null)
        {
            synchronized (zzaVD)
            {
                if (zzaVE == null)
                {
                    context = new com.google.android.gms.tagmanager.zza(context);
                    zzaVE = context;
                    context.start();
                }
            }
        }
        return zzaVE;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    static void zzb(com.google.android.gms.tagmanager.zza zza1)
    {
        zza1.zzCl();
    }

    public void interrupt()
    {
        zzIl.interrupt();
    }

    public boolean isLimitAdTrackingEnabled()
    {
        zzCm();
        if (zzMr == null)
        {
            return true;
        } else
        {
            return zzMr.isLimitAdTrackingEnabled();
        }
    }

    public void start()
    {
        zzIl.start();
    }

    public String zzCk()
    {
        zzCm();
        if (zzMr == null)
        {
            return null;
        } else
        {
            return zzMr.getId();
        }
    }


    private class _cls1
        implements zza
    {

        final com.google.android.gms.tagmanager.zza zzaVF;

        public com.google.android.gms.ads.identifier.AdvertisingIdClient.Info zzCn()
        {
            com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info;
            try
            {
                info = AdvertisingIdClient.getAdvertisingIdInfo(com.google.android.gms.tagmanager.zza.zza(zzaVF));
            }
            catch (IllegalStateException illegalstateexception)
            {
                zzbg.zzaH("IllegalStateException getting Advertising Id Info");
                return null;
            }
            catch (GooglePlayServicesRepairableException googleplayservicesrepairableexception)
            {
                zzbg.zzaH("GooglePlayServicesRepairableException getting Advertising Id Info");
                return null;
            }
            catch (IOException ioexception)
            {
                zzbg.zzaH("IOException getting Ad Id Info");
                return null;
            }
            catch (GooglePlayServicesNotAvailableException googleplayservicesnotavailableexception)
            {
                zzbg.zzaH("GooglePlayServicesNotAvailableException getting Advertising Id Info");
                return null;
            }
            catch (Exception exception)
            {
                zzbg.zzaH("Unknown exception. Could not get the Advertising Id Info.");
                return null;
            }
            return info;
        }

        _cls1()
        {
            zzaVF = zza.this;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final com.google.android.gms.tagmanager.zza zzaVF;

        public void run()
        {
            com.google.android.gms.tagmanager.zza.zzb(zzaVF);
        }

        _cls2()
        {
            zzaVF = zza.this;
            super();
        }
    }


    private class zza
    {

        public abstract com.google.android.gms.ads.identifier.AdvertisingIdClient.Info zzCn();
    }

}
