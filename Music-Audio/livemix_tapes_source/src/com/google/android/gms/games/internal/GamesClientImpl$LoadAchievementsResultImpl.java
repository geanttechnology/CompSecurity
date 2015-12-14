// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.achievement.AchievementBuffer;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzath extends zzath
    implements com.google.android.gms.games.achievement.th
{

    private final AchievementBuffer zzath;

    public AchievementBuffer getAchievements()
    {
        return zzath;
    }

    (DataHolder dataholder)
    {
        super(dataholder);
        zzath = new AchievementBuffer(dataholder);
    }
}
