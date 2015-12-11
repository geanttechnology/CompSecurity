// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzavE
    implements com.google.android.gms.internal.ifier
{

    private final int zzYm;
    private final String zzavE;

    public void zza(RoomUpdateListener roomupdatelistener)
    {
        roomupdatelistener.onLeftRoom(zzYm, zzavE);
    }

    public void zznN()
    {
    }

    public void zzq(Object obj)
    {
        zza((RoomUpdateListener)obj);
    }

    (int i, String s)
    {
        zzYm = i;
        zzavE = s;
    }
}
