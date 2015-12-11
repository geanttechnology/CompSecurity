// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzawg
    implements com.google.android.gms.internal.ifier
{

    private final String zzawg;

    public void zza(RoomStatusUpdateListener roomstatusupdatelistener)
    {
        roomstatusupdatelistener.onP2PConnected(zzawg);
    }

    public void zznN()
    {
    }

    public void zzq(Object obj)
    {
        zza((RoomStatusUpdateListener)obj);
    }

    (String s)
    {
        zzawg = s;
    }
}
