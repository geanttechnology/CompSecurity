// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.b;
import com.google.android.gms.common.c;
import com.google.android.gms.common.g;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.u;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient
{
    public static final class Info
    {

        private final String zzol;
        private final boolean zzom;

        public final String getId()
        {
            return zzol;
        }

        public final boolean isLimitAdTrackingEnabled()
        {
            return zzom;
        }

        public final String toString()
        {
            return (new StringBuilder("{")).append(zzol).append("}").append(zzom).toString();
        }

        public Info(String s, boolean flag)
        {
            zzol = s;
            zzom = flag;
        }
    }

    static final class a extends Thread
    {

        CountDownLatch a;
        boolean b;
        private WeakReference c;
        private long d;

        private void a()
        {
            AdvertisingIdClient advertisingidclient = (AdvertisingIdClient)c.get();
            if (advertisingidclient != null)
            {
                advertisingidclient.finish();
                b = true;
            }
        }

        public final void run()
        {
            try
            {
                if (!a.await(d, TimeUnit.MILLISECONDS))
                {
                    a();
                }
                return;
            }
            catch (InterruptedException interruptedexception)
            {
                a();
            }
        }

        public a(AdvertisingIdClient advertisingidclient, long l)
        {
            c = new WeakReference(advertisingidclient);
            d = l;
            a = new CountDownLatch(1);
            b = false;
            start();
        }
    }


    private static boolean zzog = false;
    private final Context mContext;
    g zzoa;
    u zzob;
    boolean zzoc;
    Object zzod;
    a zzoe;
    final long zzof;

    public AdvertisingIdClient(Context context)
    {
        this(context, 30000L);
    }

    public AdvertisingIdClient(Context context, long l)
    {
        zzod = new Object();
        w.a(context);
        mContext = context;
        zzoc = false;
        zzof = l;
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

    public static void setShouldSkipGmsCoreVersionCheck(boolean flag)
    {
        zzog = flag;
    }

    static u zza(Context context, g g1)
    {
        try
        {
            if (Looper.myLooper() == Looper.getMainLooper())
            {
                throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
            }
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
        if (g1.a)
        {
            throw new IllegalStateException();
        }
        g1.a = true;
        context = com.google.android.gms.d.u.a.a((IBinder)g1.b.take());
        return context;
    }

    private void zzaJ()
    {
        Object obj = zzod;
        obj;
        JVM INSTR monitorenter ;
        if (zzoe == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        zzoe.a.countDown();
        Exception exception;
        try
        {
            zzoe.join();
        }
        catch (InterruptedException interruptedexception) { }
        if (zzof > 0L)
        {
            zzoe = new a(this, zzof);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static g zzo(Context context)
    {
        try
        {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new c(9);
        }
        g g1;
        Intent intent;
        boolean flag;
        if (zzog)
        {
            b.a();
            switch (b.a(context))
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
        g1 = new g();
        intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        try
        {
            flag = com.google.android.gms.common.stats.b.a().a(context, intent, g1, 1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IOException(context);
        }
        if (flag)
        {
            return g1;
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
        w.c("Calling this from your main thread can lead to deadlock");
        this;
        JVM INSTR monitorenter ;
        if (mContext != null && zzoa != null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        try
        {
            if (zzoc)
            {
                com.google.android.gms.common.stats.b.a().a(mContext, zzoa);
            }
        }
        catch (IllegalArgumentException illegalargumentexception) { }
        zzoc = false;
        zzob = null;
        zzoa = null;
        this;
        JVM INSTR monitorexit ;
        return;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Info getInfo()
    {
        w.c("Calling this from your main thread can lead to deadlock");
        this;
        JVM INSTR monitorenter ;
        if (zzoc)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        Object obj = zzod;
        obj;
        JVM INSTR monitorenter ;
        if (zzoe == null || !zzoe.b)
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
        w.a(zzoa);
        w.a(zzob);
        obj1 = new Info(zzob.a(), zzob.a(true));
        this;
        JVM INSTR monitorexit ;
        zzaJ();
        return ((Info) (obj1));
        obj1;
        throw new IOException("Remote exception");
    }

    public void start()
    {
        zzb(true);
    }

    protected void zzb(boolean flag)
    {
        w.c("Calling this from your main thread can lead to deadlock");
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
