// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement;

import android.os.Handler;
import com.google.android.gms.measurement.internal.zzc;
import com.google.android.gms.measurement.internal.zzp;
import com.google.android.gms.measurement.internal.zzv;

// Referenced classes of package com.google.android.gms.measurement:
//            AppMeasurementService

class zzaKL
    implements Runnable
{

    final aKJ zzaKL;

    public void run()
    {
label0:
        {
            if (zzaKL.aKK.stopSelfResult(zzaKL.Lk))
            {
                if (!zzaKL.aKI.zzzt().zzjA())
                {
                    break label0;
                }
                zzaKL.aKJ.zzzQ().t("Device AppMeasurementService processed last upload request");
            }
            return;
        }
        zzaKL.aKJ.zzzQ().t("Local AppMeasurementService processed last upload request");
    }

    aKJ(aKJ akj)
    {
        zzaKL = akj;
        super();
    }

    // Unreferenced inner class com/google/android/gms/measurement/AppMeasurementService$1

/* anonymous class */
    class AppMeasurementService._cls1
        implements Runnable
    {

        final int zzLk;
        final zzv zzaKI;
        final zzp zzaKJ;
        final AppMeasurementService zzaKK;

        public void run()
        {
            zzaKI.zzAk();
            AppMeasurementService.zza(zzaKK).post(new AppMeasurementService._cls1._cls1(this));
        }

            
            {
                zzaKK = appmeasurementservice;
                zzaKI = zzv1;
                zzLk = i;
                zzaKJ = zzp1;
                super();
            }
    }

}
