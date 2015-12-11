// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            AchievementsImpl

class zzVb
    implements com.google.android.gms.games.achievement.Result
{

    final Status zzVb;
    final zzVb zzawX;

    public String getAchievementId()
    {
        return a(zzawX);
    }

    public Status getStatus()
    {
        return zzVb;
    }

    esult(esult esult, Status status)
    {
        zzawX = esult;
        zzVb = status;
        super();
    }
}
