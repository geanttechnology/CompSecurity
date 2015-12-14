// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;


// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzatN
    implements com.google.android.gms.common.api.ier
{

    private final int zzWu;
    private final String zzatN;
    private final int zzatO;

    public void zza(com.google.android.gms.games.multiplayer.realtime.ack ack)
    {
        if (ack != null)
        {
            ack.onRealTimeMessageSent(zzWu, zzatO, zzatN);
        }
    }

    public void zznh()
    {
    }

    public void zzo(Object obj)
    {
        zza((com.google.android.gms.games.multiplayer.realtime.ack)obj);
    }

    ageSentCallback(int i, int j, String s)
    {
        zzWu = i;
        zzatO = j;
        zzatN = s;
    }
}
