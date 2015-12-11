// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            TurnBasedMultiplayerImpl

private static abstract class zzwN extends com.google.android.gms.games.celMatchImpl
{

    private final String zzwN;

    static String zza(zzwN zzwn)
    {
        return zzwn.zzwN;
    }

    public com.google.android.gms.games.multiplayer.turnbased.Q zzaE(Status status)
    {
        return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult(status) {

            final Status zzVb;
            final TurnBasedMultiplayerImpl.CancelMatchImpl zzayR;

            public String getMatchId()
            {
                return TurnBasedMultiplayerImpl.CancelMatchImpl.zza(zzayR);
            }

            public Status getStatus()
            {
                return zzVb;
            }

            
            {
                zzayR = TurnBasedMultiplayerImpl.CancelMatchImpl.this;
                zzVb = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzaE(status);
    }

    public _cls1.zzVb(String s, GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
        zzwN = s;
    }
}
