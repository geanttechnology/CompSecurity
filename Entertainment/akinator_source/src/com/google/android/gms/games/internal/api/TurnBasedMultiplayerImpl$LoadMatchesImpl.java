// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            TurnBasedMultiplayerImpl

private static abstract class <init> extends com.google.android.gms.games.dMatchesImpl
{

    public com.google.android.gms.games.multiplayer.turnbased._cls9 zzaI(Status status)
    {
        return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult(status) {

            final Status zzVb;
            final TurnBasedMultiplayerImpl.LoadMatchesImpl zzayV;

            public LoadMatchesResponse getMatches()
            {
                return new LoadMatchesResponse(new Bundle());
            }

            public Status getStatus()
            {
                return zzVb;
            }

            public void release()
            {
            }

            
            {
                zzayV = TurnBasedMultiplayerImpl.LoadMatchesImpl.this;
                zzVb = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzaI(status);
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
