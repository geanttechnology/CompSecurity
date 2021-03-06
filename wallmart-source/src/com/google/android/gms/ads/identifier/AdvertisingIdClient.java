// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.common.zza;
import com.google.android.gms.internal.zzav;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient
{
    public static final class Info
    {

        private final String zzol;
        private final boolean zzom;

        public String getId()
        {
            return zzol;
        }

        public boolean isLimitAdTrackingEnabled()
        {
            return zzom;
        }

        public String toString()
        {
            return (new StringBuilder()).append("{").append(zzol).append("}").append(zzom).toString();
        }

        public Info(String s, boolean flag)
        {
            zzol = s;
            zzom = flag;
        }
    }

    static class zza extends Thread
    {

        private WeakReference zzoh;
        private long zzoi;
        CountDownLatch zzoj;
        boolean zzok;

        private void disconnect()
        {
            AdvertisingIdClient advertisingidclient = (AdvertisingIdClient)zzoh.get();
            if (advertisingidclient != null)
            {
                advertisingidclient.finish();
                zzok = true;
            }
        }

        public void cancel()
        {
            zzoj.countDown();
        }

        public void run()
        {
            try
            {
                if (!zzoj.await(zzoi, TimeUnit.MILLISECONDS))
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

        public boolean zzaK()
        {
            return zzok;
        }

        public zza(AdvertisingIdClient advertisingidclient, long l)
        {
            zzoh = new WeakReference(advertisingidclient);
            zzoi = l;
            zzoj = new CountDownLatch(1);
            zzok = false;
            start();
        }
    }


    private static boolean zzog = false;
    private final Context mContext;
    com.google.android.gms.common.zza zzoa;
    zzav zzob;
    boolean zzoc;
    Object zzod;
    zza zzoe;
    final long zzof;

    public AdvertisingIdClient(Context context)
    {
        this(context, 30000L);
    }

    public AdvertisingIdClient(Context context, long l)
    {
        zzod = new Object();
        zzx.zzv(context);
        mContext = context;
        zzoc = false;
        zzof = l;
    }

    public static Info getAdvertisingIdInfo(Context context)
        throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
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

    public static void setShouldSkipGmsCoreVersionCheck(boolean flag)
    {
        zzog = flag;
    }

    static zzav zza(Context context, com.google.android.gms.common.zza zza1)
        throws IOException
    {
        try
        {
            context = com.google.android.gms.internal.zzav.zza.zzb(zza1.zzmS());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IOException("Interrupted exception");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IOException(context);
        }
        return context;
    }

    private void zzaJ()
    {
        Object obj = zzod;
        obj;
        JVM INSTR monitorenter ;
        if (zzoe == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        zzoe.cancel();
        Exception exception;
        try
        {
            zzoe.join();
        }
        catch (InterruptedException interruptedexception) { }
        if (zzof > 0L)
        {
            zzoe = new zza(this, zzof);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static com.google.android.gms.common.zza zzo(Context context)
        throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
    {
        try
        {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new GooglePlayServicesNotAvailableException(9);
        }
        com.google.android.gms.common.zza zza1;
        Intent intent;
        boolean flag;
        if (zzog)
        {
            Log.d("Ads", "Skipping gmscore version check");
            switch (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context))
            {
            case 1: // '\001'
            default:
                throw new IOException("Google Play services not available");

            case 0: // '\0'
            case 2: // '\002'
                break;
            }
        } else
        {
            try
            {
                GooglePlayServicesUtil.zzaa(context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new IOException(context);
            }
        }
        zza1 = new com.google.android.gms.common.zza();
        intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        try
        {
            flag = com.google.android.gms.common.stats.zzb.zzpD().zza(context, intent, zza1, 1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IOException(context);
        }
        if (flag)
        {
            return zza1;
        } else
        {
            throw new IOException("Connection failure");
        }
    }

    protected void finalize()
        throws Throwable
    {
        finish();
        super.finalize();
    }

    public void finish()
    {
        zzx.zzci("Calling this from your main thread can lead to deadlock");
        this;
        JVM INSTR monitorenter ;
        if (mContext != null && zzoa != null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (zzoc)
        {
            com.google.android.gms.common.stats.zzb.zzpD().zza(mContext, zzoa);
        }
_L1:
        zzoc = false;
        zzob = null;
        zzoa = null;
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
        throws IOException
    {
        zzx.zzci("Calling this from your main thread can lead to deadlock");
        this;
        JVM INSTR monitorenter ;
        if (zzoc)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        Object obj = zzod;
        obj;
        JVM INSTR monitorenter ;
        if (zzoe == null || !zzoe.zzaK())
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
        if (!zzoc)
        {
            throw new IOException("AdvertisingIdClient cannot reconnect.");
        }
        break MISSING_BLOCK_LABEL_94;
        Object obj1;
        obj1;
        throw new IOException("AdvertisingIdClient cannot reconnect.", ((Throwable) (obj1)));
        zzx.zzv(zzoa);
        zzx.zzv(zzob);
        obj1 = new Info(zzob.getId(), zzob.zzc(true));
        this;
        JVM INSTR monitorexit ;
        zzaJ();
        return ((Info) (obj1));
        obj1;
        Log.i("AdvertisingIdClient", "GMS remote exception ", ((Throwable) (obj1)));
        throw new IOException("Remote exception");
    }

    public void start()
        throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
    {
        zzb(true);
    }

    protected void zzb(boolean flag)
        throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
    {
        zzx.zzci("Calling this from your main thread can lead to deadlock");
        this;
        JVM INSTR monitorenter ;
        if (zzoc)
        {
            finish();
        }
        zzoa = zzo(mContext);
        zzob = zza(mContext, zzoa);
        zzoc = true;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        zzaJ();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
