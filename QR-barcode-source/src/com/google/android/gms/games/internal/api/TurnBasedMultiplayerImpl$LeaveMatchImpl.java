// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            TurnBasedMultiplayerImpl

private static abstract class <init> extends com.google.android.gms.games.aveMatchImpl
{

    public com.google.android.gms.games.multiplayer.turnbased. au(Status status)
    {
        return new com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult(status) {

            final Status CW;
            final TurnBasedMultiplayerImpl.LeaveMatchImpl aai;

            public TurnBasedMatch getMatch()
            {
                return null;
            }

            public Status getStatus()
            {
                return CW;
            }

            
            {
                aai = TurnBasedMultiplayerImpl.LeaveMatchImpl.this;
                CW = status;
                super();
            }
        };
    }

    public Result c(Status status)
    {
        return au(status);
    }

    private _cls1.CW()
    {
    }

    _cls1.CW(_cls1.CW cw)
    {
        this();
    }
}
