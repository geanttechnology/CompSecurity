// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            AchievementsImpl

private static abstract class zzwN extends com.google.android.gms.games.
{

    private final String zzwN;

    static String zza(zzwN zzwn)
    {
        return zzwn.zzwN;
    }

    public com.google.android.gms.games.achievement.ntResult zzW(Status status)
    {
        return new com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult(status) {

            final Status zzVb;
            final AchievementsImpl.UpdateImpl zzawX;

            public String getAchievementId()
            {
                return AchievementsImpl.UpdateImpl.zza(zzawX);
            }

            public Status getStatus()
            {
                return zzVb;
            }

            
            {
                zzawX = AchievementsImpl.UpdateImpl.this;
                zzVb = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzW(status);
    }

    public _cls1.zzVb(String s, GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
        zzwN = s;
    }
}
