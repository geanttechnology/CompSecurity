// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.TimeUnit;

class zznj
    implements PendingResult
{

    private final Result zzaoM;

    zznj(Result result)
    {
        zzaoM = result;
    }

    public void addBatchCallback(com.google.android.gms.common.api.PendingResult.BatchCallback batchcallback)
    {
        batchcallback.onComplete(zzaoM.getStatus());
    }

    public Result await()
    {
        return zzaoM;
    }

    public Result await(long l, TimeUnit timeunit)
    {
        return zzaoM;
    }

    public void cancel()
    {
    }

    public boolean isCanceled()
    {
        return false;
    }

    public void setResultCallback(ResultCallback resultcallback)
    {
        resultcallback.onResult(zzaoM);
    }

    public void setResultCallback(ResultCallback resultcallback, long l, TimeUnit timeunit)
    {
        resultcallback.onResult(zzaoM);
    }
}
