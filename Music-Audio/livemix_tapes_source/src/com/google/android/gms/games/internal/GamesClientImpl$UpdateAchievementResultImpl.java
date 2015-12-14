// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.GamesStatusCodes;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzarS
    implements com.google.android.gms.games.achievement.rS
{

    private final Status zzQA;
    private final String zzarS;

    public String getAchievementId()
    {
        return zzarS;
    }

    public Status getStatus()
    {
        return zzQA;
    }

    (int i, String s)
    {
        zzQA = GamesStatusCodes.zzfx(i);
        zzarS = s;
    }
}
