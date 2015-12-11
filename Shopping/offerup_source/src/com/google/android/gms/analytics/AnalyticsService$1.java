// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.os.Handler;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzw;

// Referenced classes of package com.google.android.gms.analytics:
//            AnalyticsService

class zzLm
    implements zzw
{

    final int zzLk;
    final zzf zzLl;
    final zzaf zzLm;
    final AnalyticsService zzLn;

    public void zzc(Throwable throwable)
    {
        class _cls1
            implements Runnable
        {

            final AnalyticsService._cls1 zzLo;

            public void run()
            {
label0:
                {
                    if (zzLo.zzLn.stopSelfResult(zzLo.zzLk))
                    {
                        if (!zzLo.zzLl.zziv().zzjA())
                        {
                            break label0;
                        }
                        zzLo.zzLm.zzba("Device AnalyticsService processed last dispatch request");
                    }
                    return;
                }
                zzLo.zzLm.zzba("Local AnalyticsService processed last dispatch request");
            }

            _cls1()
            {
                zzLo = AnalyticsService._cls1.this;
                super();
            }
        }

        AnalyticsService.zza(zzLn).post(new _cls1());
    }

    _cls1(AnalyticsService analyticsservice, int i, zzf zzf, zzaf zzaf)
    {
        zzLn = analyticsservice;
        zzLk = i;
        zzLl = zzf;
        zzLm = zzaf;
        super();
    }
}
