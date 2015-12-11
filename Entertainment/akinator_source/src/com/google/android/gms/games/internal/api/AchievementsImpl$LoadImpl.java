// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.achievement.AchievementBuffer;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            AchievementsImpl

private static abstract class <init> extends com.google.android.gms.games.pl
{

    public com.google.android.gms.games.achievement.ntsResult zzV(Status status)
    {
        return new com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult(status) {

            final Status zzVb;
            final AchievementsImpl.LoadImpl zzawW;

            public AchievementBuffer getAchievements()
            {
                return new AchievementBuffer(DataHolder.zzbu(14));
            }

            public Status getStatus()
            {
                return zzVb;
            }

            public void release()
            {
            }

            
            {
                zzawW = AchievementsImpl.LoadImpl.this;
                zzVb = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzV(status);
    }

    private _cls1.zzVb(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
    }

    _cls1.zzVb(GoogleApiClient googleapiclient, _cls1.zzVb zzvb)
    {
        this(googleapiclient);
    }
}
