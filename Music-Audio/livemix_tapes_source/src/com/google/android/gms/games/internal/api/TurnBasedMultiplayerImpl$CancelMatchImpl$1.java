// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            TurnBasedMultiplayerImpl

class zzQs
    implements com.google.android.gms.games.multiplayer.turnbased.
{

    final Status zzQs;
    final zzQs zzaws;

    public String getMatchId()
    {
        return a(zzaws);
    }

    public Status getStatus()
    {
        return zzQs;
    }

    sult(sult sult, Status status)
    {
        zzaws = sult;
        zzQs = status;
        super();
    }
}
