// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            GamesMetadataImpl

private static abstract class _cls1.zzVb extends com.google.android.gms.games.nstancesImpl
{

    public com.google.android.gms.games.nstancesImpl zzac(Status status)
    {
        return new com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult(status) {

            final Status zzVb;
            final GamesMetadataImpl.LoadGameInstancesImpl zzaxl;

            public Status getStatus()
            {
                return zzVb;
            }

            public void release()
            {
            }

            
            {
                zzaxl = GamesMetadataImpl.LoadGameInstancesImpl.this;
                zzVb = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzac(status);
    }
}
