// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;


// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzawl
    implements com.google.android.gms.internal.ifier
{

    private final int zzYm;
    private final String zzawl;
    private final int zzawm;

    public void zza(com.google.android.gms.games.multiplayer.realtime.ack ack)
    {
        if (ack != null)
        {
            ack.onRealTimeMessageSent(zzYm, zzawm, zzawl);
        }
    }

    public void zznN()
    {
    }

    public void zzq(Object obj)
    {
        zza((com.google.android.gms.games.multiplayer.realtime.ack)obj);
    }

    ageSentCallback(int i, int j, String s)
    {
        zzYm = i;
        zzawm = j;
        zzawl = s;
    }
}
