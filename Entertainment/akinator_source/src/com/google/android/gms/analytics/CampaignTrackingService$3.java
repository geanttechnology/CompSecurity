// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.zzaf;

// Referenced classes of package com.google.android.gms.analytics:
//            CampaignTrackingService

class zzLm
    implements Runnable
{

    final int zzLk;
    final zzaf zzLm;
    final CampaignTrackingService zzLu;

    public void run()
    {
        boolean flag = zzLu.stopSelfResult(zzLk);
        if (flag)
        {
            zzLm.zza("Install campaign broadcast processed", Boolean.valueOf(flag));
        }
    }

    (CampaignTrackingService campaigntrackingservice, int i, zzaf zzaf1)
    {
        zzLu = campaigntrackingservice;
        zzLk = i;
        zzLm = zzaf1;
        super();
    }
}
