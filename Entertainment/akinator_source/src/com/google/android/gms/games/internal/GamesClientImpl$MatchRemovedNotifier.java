// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzavX
    implements com.google.android.gms.internal.ifier
{

    private final String zzavX;

    public void zza(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
    {
        onturnbasedmatchupdatereceivedlistener.onTurnBasedMatchRemoved(zzavX);
    }

    public void zznN()
    {
    }

    public void zzq(Object obj)
    {
        zza((OnTurnBasedMatchUpdateReceivedListener)obj);
    }

    ceivedListener(String s)
    {
        zzavX = s;
    }
}
