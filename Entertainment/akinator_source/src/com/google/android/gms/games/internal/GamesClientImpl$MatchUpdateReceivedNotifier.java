// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzavY
    implements com.google.android.gms.internal.ifier
{

    private final TurnBasedMatch zzavY;

    public void zza(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
    {
        onturnbasedmatchupdatereceivedlistener.onTurnBasedMatchReceived(zzavY);
    }

    public void zznN()
    {
    }

    public void zzq(Object obj)
    {
        zza((OnTurnBasedMatchUpdateReceivedListener)obj);
    }

    istener(TurnBasedMatch turnbasedmatch)
    {
        zzavY = turnbasedmatch;
    }
}
