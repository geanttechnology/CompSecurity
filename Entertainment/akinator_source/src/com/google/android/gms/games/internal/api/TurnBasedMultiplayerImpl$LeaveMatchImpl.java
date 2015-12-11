// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            TurnBasedMultiplayerImpl

private static abstract class <init> extends com.google.android.gms.games.aveMatchImpl
{

    public com.google.android.gms.games.multiplayer.turnbased. zzaG(Status status)
    {
        return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult(status) {

            final Status zzVb;
            final TurnBasedMultiplayerImpl.LeaveMatchImpl zzayT;

            public TurnBasedMatch getMatch()
            {
                return null;
            }

            public Status getStatus()
            {
                return zzVb;
            }

            
            {
                zzayT = TurnBasedMultiplayerImpl.LeaveMatchImpl.this;
                zzVb = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzaG(status);
    }

    private _cls1.zzVb(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
    }

    _cls1.zzVb(GoogleApiClient googleapiclient, _cls1.zzVb zzvb)
    {
        this(googleapiclient);
    }
}
