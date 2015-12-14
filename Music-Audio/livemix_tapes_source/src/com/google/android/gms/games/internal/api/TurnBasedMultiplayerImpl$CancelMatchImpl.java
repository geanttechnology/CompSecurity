// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            TurnBasedMultiplayerImpl

private static abstract class zzwj extends com.google.android.gms.games.celMatchImpl
{

    private final String zzwj;

    static String zza(zzwj zzwj1)
    {
        return zzwj1.zzwj;
    }

    public com.google.android.gms.games.multiplayer.turnbased.Q zzaF(Status status)
    {
        return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult(status) {

            final Status zzQs;
            final TurnBasedMultiplayerImpl.CancelMatchImpl zzaws;

            public String getMatchId()
            {
                return TurnBasedMultiplayerImpl.CancelMatchImpl.zza(zzaws);
            }

            public Status getStatus()
            {
                return zzQs;
            }

            
            {
                zzaws = TurnBasedMultiplayerImpl.CancelMatchImpl.this;
                zzQs = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzaF(status);
    }

    public _cls1.zzQs(String s, GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
        zzwj = s;
    }
}
