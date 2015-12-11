// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.GamesStatusCodes;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzauq
    implements com.google.android.gms.games.achievement.uq
{

    private final Status zzSC;
    private final String zzauq;

    public String getAchievementId()
    {
        return zzauq;
    }

    public Status getStatus()
    {
        return zzSC;
    }

    (int i, String s)
    {
        zzSC = GamesStatusCodes.zzfG(i);
        zzauq = s;
    }
}
