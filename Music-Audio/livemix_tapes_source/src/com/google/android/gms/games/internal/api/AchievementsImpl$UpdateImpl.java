// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            AchievementsImpl

private static abstract class zzwj extends com.google.android.gms.games.
{

    private final String zzwj;

    static String zza(zzwj zzwj1)
    {
        return zzwj1.zzwj;
    }

    public com.google.android.gms.games.achievement.ntResult zzX(Status status)
    {
        return new com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult(status) {

            final Status zzQs;
            final AchievementsImpl.UpdateImpl zzauz;

            public String getAchievementId()
            {
                return AchievementsImpl.UpdateImpl.zza(zzauz);
            }

            public Status getStatus()
            {
                return zzQs;
            }

            
            {
                zzauz = AchievementsImpl.UpdateImpl.this;
                zzQs = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzX(status);
    }

    public _cls1.zzQs(String s, GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
        zzwj = s;
    }
}
