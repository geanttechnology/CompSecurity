// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class zzp
{

    private static final String TAG = com/google/android/gms/location/places/internal/zzp.getSimpleName();
    private static final long zzaHF;
    private static zzp zzaHG;
    private final Context mContext;
    private final Handler mHandler;
    private final Runnable zzaHH;
    private ArrayList zzaHI;
    private ArrayList zzaHJ;
    private final Object zzpd;

    private zzp(Context context)
    {
        this((Context)zzx.zzw(context), new Handler(Looper.getMainLooper()));
    }

    zzp(Context context, Handler handler)
    {
        zzaHH = new zza(null);
        zzpd = new Object();
        zzaHI = null;
        zzaHJ = null;
        mContext = context;
        mHandler = handler;
    }

    static ArrayList zza(zzp zzp1, ArrayList arraylist)
    {
        zzp1.zzaHI = arraylist;
        return arraylist;
    }

    public static zzp zzaF(Context context)
    {
        com/google/android/gms/location/places/internal/zzp;
        JVM INSTR monitorenter ;
        int i;
        zzx.zzw(context);
        i = android.os.Build.VERSION.SDK_INT;
        if (i >= 14) goto _L2; else goto _L1
_L1:
        context = null;
_L4:
        com/google/android/gms/location/places/internal/zzp;
        JVM INSTR monitorexit ;
        return context;
_L2:
        if (zzaHG == null)
        {
            zzaHG = new zzp(context.getApplicationContext());
        }
        context = zzaHG;
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    static Object zzb(zzp zzp1)
    {
        return zzp1.zzpd;
    }

    static ArrayList zzb(zzp zzp1, ArrayList arraylist)
    {
        zzp1.zzaHJ = arraylist;
        return arraylist;
    }

    static ArrayList zzc(zzp zzp1)
    {
        return zzp1.zzaHI;
    }

    static ArrayList zzd(zzp zzp1)
    {
        return zzp1.zzaHJ;
    }

    static Context zze(zzp zzp1)
    {
        return zzp1.mContext;
    }

    public void zzE(String s, String s1)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (zzaHI == null)
        {
            zzaHI = new ArrayList();
            zzaHJ = new ArrayList();
            mHandler.postDelayed(zzaHH, zzaHF);
        }
        zzaHI.add(s);
        zzaHJ.add(s1);
        if (zzaHI.size() >= 10000)
        {
            if (Log.isLoggable(TAG, 5))
            {
                Log.w(TAG, "Event buffer full, flushing");
            }
            zzaHH.run();
            mHandler.removeCallbacks(zzaHH);
            return;
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    static 
    {
        zzaHF = TimeUnit.SECONDS.toMillis(1L);
    }

    private class zza
        implements Runnable
    {

        final zzp zzaHK;

        public void run()
        {
            synchronized (zzp.zzb(zzaHK))
            {
                Intent intent = new Intent("com.google.android.location.places.METHOD_CALL");
                intent.setPackage("com.google.android.gms");
                intent.putStringArrayListExtra("PLACE_IDS", zzp.zzc(zzaHK));
                intent.putStringArrayListExtra("METHOD_NAMES", zzp.zzd(zzaHK));
                intent.putExtra("PACKAGE_NAME", zzp.zze(zzaHK).getPackageName());
                intent.putExtra("CLIENT_VERSION", GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                zzp.zze(zzaHK).sendBroadcast(intent);
                zzp.zza(zzaHK, null);
                zzp.zzb(zzaHK, null);
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private zza()
        {
            zzaHK = zzp.this;
            super();
        }

        zza(_cls1 _pcls1)
        {
            this();
        }
    }

}
