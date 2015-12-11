// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.api:
//            BatchResultToken, Batch, GoogleApiClient, PendingResult

public final class zzVs
{

    private GoogleApiClient zzVs;
    private List zzaaD;

    public final BatchResultToken add(PendingResult pendingresult)
    {
        BatchResultToken batchresulttoken = new BatchResultToken(zzaaD.size());
        zzaaD.add(pendingresult);
        return batchresulttoken;
    }

    public final Batch build()
    {
        return new Batch(zzaaD, zzVs, null);
    }

    public t(GoogleApiClient googleapiclient)
    {
        zzaaD = new ArrayList();
        zzVs = googleapiclient;
    }
}
