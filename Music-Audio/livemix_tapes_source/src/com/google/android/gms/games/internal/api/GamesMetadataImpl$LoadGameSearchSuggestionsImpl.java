// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            GamesMetadataImpl

private static abstract class _cls1.zzQs extends com.google.android.gms.games.gestionsImpl
{

    public com.google.android.gms.games.gestionsImpl zzae(Status status)
    {
        return new com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult(status) {

            final Status zzQs;
            final GamesMetadataImpl.LoadGameSearchSuggestionsImpl zzauO;

            public Status getStatus()
            {
                return zzQs;
            }

            public void release()
            {
            }

            
            {
                zzauO = GamesMetadataImpl.LoadGameSearchSuggestionsImpl.this;
                zzQs = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzae(status);
    }
}
