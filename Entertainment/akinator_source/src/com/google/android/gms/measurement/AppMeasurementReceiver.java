// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzag;
import com.google.android.gms.measurement.internal.zzc;
import com.google.android.gms.measurement.internal.zzp;
import com.google.android.gms.measurement.internal.zzv;

// Referenced classes of package com.google.android.gms.measurement:
//            AppMeasurementService

public final class AppMeasurementReceiver extends BroadcastReceiver
{

    static Boolean zzLi;
    static android.os.PowerManager.WakeLock zzaKH;
    static final Object zzpy = new Object();

    public AppMeasurementReceiver()
    {
    }

    public static boolean zzV(Context context)
    {
        zzx.zzw(context);
        if (zzLi != null)
        {
            return zzLi.booleanValue();
        } else
        {
            boolean flag = zzag.zza(context, com/google/android/gms/measurement/AppMeasurementReceiver, false);
            zzLi = Boolean.valueOf(flag);
            return flag;
        }
    }

    public void onReceive(Context context, Intent intent)
    {
        zzp zzp1;
        Object obj = zzv.zzaL(context);
        zzp1 = ((zzv) (obj)).zzyd();
        intent = intent.getAction();
        boolean flag;
        if (((zzv) (obj)).zzzt().zzjA())
        {
            zzp1.zzzQ().zzj("Device AppMeasurementReceiver got", intent);
        } else
        {
            zzp1.zzzQ().zzj("Local AppMeasurementReceiver got", intent);
        }
        if (!"com.google.android.gms.measurement.UPLOAD".equals(intent)) goto _L2; else goto _L1
_L1:
        flag = AppMeasurementService.zzW(context);
        obj = new Intent(context, com/google/android/gms/measurement/AppMeasurementService);
        ((Intent) (obj)).setAction("com.google.android.gms.measurement.UPLOAD");
        intent = ((Intent) (zzpy));
        intent;
        JVM INSTR monitorenter ;
        context.startService(((Intent) (obj)));
        if (flag)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        intent;
        JVM INSTR monitorexit ;
_L2:
        return;
        context = (PowerManager)context.getSystemService("power");
        if (zzaKH == null)
        {
            zzaKH = context.newWakeLock(1, "AppMeasurement WakeLock");
            zzaKH.setReferenceCounted(false);
        }
        zzaKH.acquire(1000L);
_L3:
        intent;
        JVM INSTR monitorexit ;
        return;
        context;
        intent;
        JVM INSTR monitorexit ;
        throw context;
        context;
        zzp1.zzzL().zzec("AppMeasurementService at risk of not starting. For more reliable app measurements, add the WAKE_LOCK permission to your manifest.");
          goto _L3
    }

}
