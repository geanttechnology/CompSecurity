// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            PlayersImpl

private static abstract class _cls1.zzQs extends com.google.android.gms.games.gsResultImpl
{

    protected com.google.android.gms.games.gsResultImpl zzaq(Status status)
    {
        return new com.google.android.gms.games.Players.LoadProfileSettingsResult(status) {

            final Status zzQs;
            final PlayersImpl.LoadProfileSettingsResultImpl zzavx;

            public Status getStatus()
            {
                return zzQs;
            }

            public boolean isProfileVisible()
            {
                return true;
            }

            public boolean isVisibilityExplicitlySet()
            {
                return false;
            }

            
            {
                zzavx = PlayersImpl.LoadProfileSettingsResultImpl.this;
                zzQs = status;
                super();
            }
        };
    }

    protected Result zzb(Status status)
    {
        return zzaq(status);
    }
}
