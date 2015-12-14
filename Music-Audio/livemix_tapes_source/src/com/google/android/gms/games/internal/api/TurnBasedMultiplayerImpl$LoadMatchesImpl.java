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

    public com.google.android.gms.games.multiplayer.turnbased._cls9 zzaJ(Status status)
    {
        return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult(status) {

            final Status zzQs;
            final TurnBasedMultiplayerImpl.LoadMatchesImpl zzaww;

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

            
            {
                zzaww = TurnBasedMultiplayerImpl.LoadMatchesImpl.this;
                zzQs = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzaJ(status);
    }

    private _cls1.zzQs(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
    }

    _cls1.zzQs(GoogleApiClient googleapiclient, _cls1.zzQs zzqs)
    {
        this(googleapiclient);
    }
}
