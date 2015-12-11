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

class zzaKJ
    implements Runnable
{

    final int zzLk;
    final zzv zzaKI;
    final zzp zzaKJ;
    final AppMeasurementService zzaKK;

    public void run()
    {
        zzaKI.zzAk();
        AppMeasurementService.zza(zzaKK).post(new Runnable() {

            final AppMeasurementService._cls1 zzaKL;

            public void run()
            {
label0:
                {
                    if (zzaKL.zzaKK.stopSelfResult(zzaKL.zzLk))
                    {
                        if (!zzaKL.zzaKI.zzzt().zzjA())
                        {
                            break label0;
                        }
                        zzaKL.zzaKJ.zzzQ().zzec("Device AppMeasurementService processed last upload request");
                    }
                    return;
                }
                zzaKL.zzaKJ.zzzQ().zzec("Local AppMeasurementService processed last upload request");
            }

            
            {
                zzaKL = AppMeasurementService._cls1.this;
                super();
            }
        });
    }

    _cls1.zzaKL(AppMeasurementService appmeasurementservice, zzv zzv1, int i, zzp zzp)
    {
        zzaKK = appmeasurementservice;
        zzaKI = zzv1;
        zzLk = i;
        zzaKJ = zzp;
        super();
    }
}
