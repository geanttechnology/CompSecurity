// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.os.Handler;
import com.google.android.gms.analytics.internal.zzaf;

// Referenced classes of package com.google.android.gms.analytics:
//            CampaignTrackingService

class zzLk
    implements Runnable
{

    final int zzLk;
    final zzaf zzLm;
    final CampaignTrackingService zzLu;
    final Handler zzt;

    public void run()
    {
        zzLu.zza(zzLm, zzt, zzLk);
    }

    (CampaignTrackingService campaigntrackingservice, zzaf zzaf, Handler handler, int i)
    {
        zzLu = campaigntrackingservice;
        zzLm = zzaf;
        zzt = handler;
        zzLk = i;
        super();
    }
}
