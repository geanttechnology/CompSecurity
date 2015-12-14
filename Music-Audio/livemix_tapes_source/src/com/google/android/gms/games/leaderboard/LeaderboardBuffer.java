// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

// Referenced classes of package com.google.android.gms.games.leaderboard:
//            LeaderboardRef, Leaderboard

public final class LeaderboardBuffer extends zzf
{

    public LeaderboardBuffer(DataHolder dataholder)
    {
        super(dataholder);
    }

    protected Object zzk(int i, int j)
    {
        return zzo(i, j);
    }

    protected String zznW()
    {
        return "external_leaderboard_id";
    }

    protected Leaderboard zzo(int i, int j)
    {
        return new LeaderboardRef(zzYX, i, j);
    }
}
