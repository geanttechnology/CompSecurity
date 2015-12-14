// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzr;

// Referenced classes of package com.google.android.gms.analytics:
//            AnalyticsService

class zzIj
    implements Runnable
{

    final Ih zzIj;

    public void run()
    {
label0:
        {
            if (zzIj.Ii.stopSelfResult(zzIj.If))
            {
                if (!zzIj.Ig.zzhR().zziW())
                {
                    break label0;
                }
                zzIj.Ih.zzaT("Device AnalyticsService processed last dispatch request");
            }
            return;
        }
        zzIj.Ih.zzaT("Local AnalyticsService processed last dispatch request");
    }

    ( )
    {
        zzIj = ;
        super();
    }
}
