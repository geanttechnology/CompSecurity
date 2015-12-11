// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            TurnBasedMultiplayerImpl

class zzVb
    implements com.google.android.gms.games.multiplayer.turnbased.
{

    final Status zzVb;
    final zzVb zzayR;

    public String getMatchId()
    {
        return a(zzayR);
    }

    public Status getStatus()
    {
        return zzVb;
    }

    sult(sult sult, Status status)
    {
        zzayR = sult;
        zzVb = status;
        super();
    }
}
