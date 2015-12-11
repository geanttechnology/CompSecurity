// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.common.api:
//            Result, BatchResultToken, PendingResult, Status

public final class BatchResult
    implements Result
{

    private final Status zzSC;
    private final PendingResult zzaaB[];

    BatchResult(Status status, PendingResult apendingresult[])
    {
        zzSC = status;
        zzaaB = apendingresult;
    }

    public final Status getStatus()
    {
        return zzSC;
    }

    public final Result take(BatchResultToken batchresulttoken)
    {
        boolean flag;
        if (batchresulttoken.mId < zzaaB.length)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "The result token does not belong to this batch");
        return zzaaB[batchresulttoken.mId].await(0L, TimeUnit.MILLISECONDS);
    }
}
