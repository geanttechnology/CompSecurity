// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzavZ
    implements com.google.android.gms.internal.ifier
{

    private final RealTimeMessage zzavZ;

    public void zza(RealTimeMessageReceivedListener realtimemessagereceivedlistener)
    {
        realtimemessagereceivedlistener.onRealTimeMessageReceived(zzavZ);
    }

    public void zznN()
    {
    }

    public void zzq(Object obj)
    {
        zza((RealTimeMessageReceivedListener)obj);
    }

    ner(RealTimeMessage realtimemessage)
    {
        zzavZ = realtimemessage;
    }
}
