// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzatz
    implements com.google.android.gms.common.api.ier
{

    private final String zzatz;

    public void zza(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
    {
        onturnbasedmatchupdatereceivedlistener.onTurnBasedMatchRemoved(zzatz);
    }

    public void zznh()
    {
    }

    public void zzo(Object obj)
    {
        zza((OnTurnBasedMatchUpdateReceivedListener)obj);
    }

    ceivedListener(String s)
    {
        zzatz = s;
    }
}
