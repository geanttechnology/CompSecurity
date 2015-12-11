// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzlc;

// Referenced classes of package com.google.android.gms.common.api:
//            ResultCallback, Result, Status

public abstract class ResultCallbacks
    implements ResultCallback
{

    public ResultCallbacks()
    {
    }

    public abstract void onFailure(Status status);

    public final void onResult(Result result)
    {
        Status status = result.getStatus();
        if (status.isSuccess())
        {
            onSuccess(result);
            return;
        } else
        {
            onFailure(status);
            zzlc.zzd(result);
            return;
        }
    }

    public abstract void onSuccess(Result result);
}
