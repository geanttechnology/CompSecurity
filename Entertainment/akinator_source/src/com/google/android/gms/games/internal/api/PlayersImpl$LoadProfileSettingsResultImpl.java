// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            PlayersImpl

private static abstract class _cls1.zzVb extends com.google.android.gms.games.gsResultImpl
{

    protected com.google.android.gms.games.gsResultImpl zzap(Status status)
    {
        return new com.google.android.gms.games.Players.LoadProfileSettingsResult(status) {

            final Status zzVb;
            final PlayersImpl.LoadProfileSettingsResultImpl zzaxV;

            public Status getStatus()
            {
                return zzVb;
            }

            
            {
                zzaxV = PlayersImpl.LoadProfileSettingsResultImpl.this;
                zzVb = status;
                super();
            }
        };
    }

    protected Result zzb(Status status)
    {
        return zzap(status);
    }
}
