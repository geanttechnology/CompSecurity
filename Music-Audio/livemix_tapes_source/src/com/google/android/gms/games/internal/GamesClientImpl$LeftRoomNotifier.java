// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzatg
    implements com.google.android.gms.common.api.ier
{

    private final int zzWu;
    private final String zzatg;

    public void zza(RoomUpdateListener roomupdatelistener)
    {
        roomupdatelistener.onLeftRoom(zzWu, zzatg);
    }

    public void zznh()
    {
    }

    public void zzo(Object obj)
    {
        zza((RoomUpdateListener)obj);
    }

    (int i, String s)
    {
        zzWu = i;
        zzatg = s;
    }
}
