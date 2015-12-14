// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            StatsImpl

private static abstract class _cls1.zzQs extends com.google.android.gms.games.thodImpl
{

    public com.google.android.gms.games.stats.sResult zzaE(Status status)
    {
        return new com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult(status) {

            final Status zzQs;
            final StatsImpl.LoadsImpl zzawj;

            public Status getStatus()
            {
                return zzQs;
            }

            public void release()
            {
            }

            
            {
                zzawj = StatsImpl.LoadsImpl.this;
                zzQs = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzaE(status);
    }
}
