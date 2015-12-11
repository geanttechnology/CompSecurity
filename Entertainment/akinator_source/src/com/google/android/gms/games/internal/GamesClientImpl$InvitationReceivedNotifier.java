// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzavB
    implements com.google.android.gms.internal.ifier
{

    private final Invitation zzavB;

    public void zza(OnInvitationReceivedListener oninvitationreceivedlistener)
    {
        oninvitationreceivedlistener.onInvitationReceived(zzavB);
    }

    public void zznN()
    {
    }

    public void zzq(Object obj)
    {
        zza((OnInvitationReceivedListener)obj);
    }

    (Invitation invitation)
    {
        zzavB = invitation;
    }
}
