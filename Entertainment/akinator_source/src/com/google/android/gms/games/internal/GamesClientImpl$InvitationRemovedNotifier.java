// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzavC
    implements com.google.android.gms.internal.ifier
{

    private final String zzavC;

    public void zza(OnInvitationReceivedListener oninvitationreceivedlistener)
    {
        oninvitationreceivedlistener.onInvitationRemoved(zzavC);
    }

    public void zznN()
    {
    }

    public void zzq(Object obj)
    {
        zza((OnInvitationReceivedListener)obj);
    }

    (String s)
    {
        zzavC = s;
    }
}
