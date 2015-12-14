// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            TurnBasedMultiplayerImpl

class zzQs
    implements com.google.android.gms.games.multiplayer.turnbased.
{

    final Status zzQs;
    final zzQs zzaww;

    public LoadMatchesResponse getMatches()
    {
        return new LoadMatchesResponse(new Bundle());
    }

    public Status getStatus()
    {
        return zzQs;
    }

    public void release()
    {
    }

    sult(sult sult, Status status)
    {
        zzaww = sult;
        zzQs = status;
        super();
    }
}
