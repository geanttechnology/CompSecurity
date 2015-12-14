// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.stats;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

// Referenced classes of package com.google.android.gms.games.stats:
//            PlayerStatsRef, PlayerStats

public final class PlayerStatsBuffer extends AbstractDataBuffer
{

    public PlayerStatsBuffer(DataHolder dataholder)
    {
        super(dataholder);
    }

    public Object get(int i)
    {
        return zzgp(i);
    }

    public PlayerStats zzgp(int i)
    {
        return new PlayerStatsRef(zzYX, i);
    }
}
