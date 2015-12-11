// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.PlayerStatsBuffer;
import com.google.android.gms.games.stats.PlayerStatsEntity;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzavO extends zzavO
    implements com.google.android.gms.games.stats.pl
{

    private final PlayerStats zzavO = null;

    public PlayerStats getPlayerStats()
    {
        return zzavO;
    }

    (DataHolder dataholder)
    {
        super(dataholder);
        dataholder = new PlayerStatsBuffer(dataholder);
        if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
        zzavO = new PlayerStatsEntity(dataholder.zzgy(0));
_L4:
        dataholder.release();
        return;
_L2:
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        dataholder.release();
        throw exception;
    }
}
