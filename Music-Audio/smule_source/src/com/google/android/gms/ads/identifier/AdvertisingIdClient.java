// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.common.zza;
import com.google.android.gms.internal.zzs;
import java.io.IOException;

public class AdvertisingIdClient
{

    private final Context mContext;
    com.google.android.gms.common.zza zzmf;
    zzs zzmg;
    boolean zzmh;
    Object zzmi;
    zza zzmj;
    final long zzmk;

    public AdvertisingIdClient(Context context)
    {
        this(context, 30000L);
    }

    public AdvertisingIdClient(Context context, long l)
    {
        zzmi = new Object();
        zzv.zzr(context);
        mContext = context;
        zzmh = false;
        zzmk = l;
    }

    public static Info getAdvertisingIdInfo(Context context)
    {
        context = new AdvertisingIdClient(context, -1L);
        Info info;
        context.zzb(false);
        info = context.getInfo();
        context.finish();
        return info;
        Exception exception;
        exception;
        context.finish();
        throw exception;
    }

    static zzs zza(Context context, zza zza1)
    {
        try
        {
            context = com.google.android.gms.internal.zzs.zza.zzb(zza1.zzku());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IOException("Interrupted exception");
        }
        return context;
    }

    private void zzad()
    {
        Object obj = zzmi;
        obj;
        JVM INSTR monitorenter ;
        if (zzmj == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        zzmj.cancel();
        Exception exception;
        try
        {
            zzmj.join();
        }
        catch (InterruptedException interruptedexception) { }
        if (zzmk > 0L)
        {
            zzmj = new zza(zzmk);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static com.google.android.gms.common.zza zzj(Context context)
    {
        com.google.android.gms.common.zza zza1;
        Intent intent;
        try
        {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new GooglePlayServicesNotAvailableException(9);
        }
        try
        {
            GooglePlayServicesUtil.zzM(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IOException(context);
        }
        zza1 = new com.google.android.gms.common.zza();
        intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (com.google.android.gms.common.stats.zzb.zznb().zza(context, intent, zza1, 1))
        {
            return zza1;
        } else
        {
            throw new IOException("Connection failure");
        }
    }

    protected void finalize()
    {
        finish();
        super.finalize();
    }

    public void finish()
    {
        zzv.zzbJ("Calling this from your main thread can lead to deadlock");
        this;
        JVM INSTR monitorenter ;
        if (mContext != null && zzmf != null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (zzmh)
        {
            com.google.android.gms.common.stats.zzb.zznb().zza(mContext, zzmf);
        }
_L1:
        zzmh = false;
        zzmg = null;
        zzmf = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", ((Throwable) (obj)));
          goto _L1
    }

    public Info getInfo()
    {
        zzv.zzbJ("Calling this from your main thread can lead to deadlock");
        this;
        JVM INSTR monitorenter ;
        if (zzmh)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        Object obj = zzmi;
        obj;
        JVM INSTR monitorenter ;
        if (zzmj == null || !zzmj.zzae())
        {
            throw new IOException("AdvertisingIdClient is not connected.");
        }
        break MISSING_BLOCK_LABEL_58;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        JVM INSTR monitorexit ;
        zzb(false);
        if (!zzmh)
        {
            throw new IOException("AdvertisingIdClient cannot reconnect.");
        }
        break MISSING_BLOCK_LABEL_94;
        Object obj1;
        obj1;
        throw new IOException("AdvertisingIdClient cannot reconnect.", ((Throwable) (obj1)));
        zzv.zzr(zzmf);
        zzv.zzr(zzmg);
        obj1 = new Info(zzmg.getId(), zzmg.zzc(true));
        this;
        JVM INSTR monitorexit ;
        zzad();
        return ((Info) (obj1));
        obj1;
        Log.i("AdvertisingIdClient", "GMS remote exception ", ((Throwable) (obj1)));
        throw new IOException("Remote exception");
    }

    public void start()
    {
        zzb(true);
    }

    protected void zzb(boolean flag)
    {
        zzv.zzbJ("Calling this from your main thread can lead to deadlock");
        this;
        JVM INSTR monitorenter ;
        if (zzmh)
        {
            finish();
        }
        zzmf = zzj(mContext);
        zzmg = zza(mContext, zzmf);
        zzmh = true;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        zzad();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private class zza extends Thread
    {

        private WeakReference zzml;
        private long zzmm;
        CountDownLatch zzmn;
        boolean zzmo;

        private void disconnect()
        {
            AdvertisingIdClient advertisingidclient = (AdvertisingIdClient)zzml.get();
            if (advertisingidclient != null)
            {
                advertisingidclient.finish();
                zzmo = true;
            }
        }

        public void cancel()
        {
            zzmn.countDown();
        }

        public void run()
        {
            try
            {
                if (!zzmn.await(zzmm, TimeUnit.MILLISECONDS))
                {
                    disconnect();
                }
                return;
            }
            catch (InterruptedException interruptedexception)
            {
                disconnect();
            }
        }

        public boolean zzae()
        {
            return zzmo;
        }

        public zza(long l)
        {
            zzml = new WeakReference(AdvertisingIdClient.this);
            zzmm = l;
            zzmn = new CountDownLatch(1);
            zzmo = false;
            start();
        }
    }


    private class Info
    {

        private final String zzmp;
        private final boolean zzmq;

        public String getId()
        {
            return zzmp;
        }

        public boolean isLimitAdTrackingEnabled()
        {
            return zzmq;
        }

        public String toString()
        {
            return (new StringBuilder()).append("{").append(zzmp).append("}").append(zzmq).toString();
        }

        public Info(String s, boolean flag)
        {
            zzmp = s;
            zzmq = flag;
        }
    }

}
