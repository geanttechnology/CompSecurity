// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            AchievementsImpl

class zzQs
    implements com.google.android.gms.games.achievement.Result
{

    final Status zzQs;
    final zzQs zzauz;

    public String getAchievementId()
    {
        return a(zzauz);
    }

    public Status getStatus()
    {
        return zzQs;
    }

    esult(esult esult, Status status)
    {
        zzauz = esult;
        zzQs = status;
        super();
    }
}
