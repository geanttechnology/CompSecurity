// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.zzl;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;

// Referenced classes of package com.google.android.gms.games.internal:
//            AbstractGamesCallbacks, GamesClientImpl

private static final class zzaiL extends AbstractGamesCallbacks
{

    private final zzl zzaiL;

    public void onTurnBasedMatchRemoved(String s)
    {
        zzaiL.zza(new zzaiL(s));
    }

    public void zzw(DataHolder dataholder)
    {
        TurnBasedMatchBuffer turnbasedmatchbuffer;
        turnbasedmatchbuffer = new TurnBasedMatchBuffer(dataholder);
        dataholder = null;
        if (turnbasedmatchbuffer.getCount() > 0)
        {
            dataholder = (TurnBasedMatch)((TurnBasedMatch)turnbasedmatchbuffer.get(0)).freeze();
        }
        turnbasedmatchbuffer.release();
        if (dataholder != null)
        {
            zzaiL.zza(new (dataholder));
        }
        return;
        dataholder;
        turnbasedmatchbuffer.release();
        throw dataholder;
    }

    (zzl zzl1)
    {
        zzaiL = zzl1;
    }
}
