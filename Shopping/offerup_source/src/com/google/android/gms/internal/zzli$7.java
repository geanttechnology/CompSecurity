// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzli, zzlo

class zzWT
    implements ResultCallback
{

    final GoogleApiClient zzWT;
    final zzli zzacr;
    final zzlo zzacv;
    final boolean zzacw;

    public void onResult(Result result)
    {
        zzo((Status)result);
    }

    public void zzo(Status status)
    {
        if (status.isSuccess() && zzacr.isConnected())
        {
            zzacr.reconnect();
        }
        zzacv.zzb(status);
        if (zzacw)
        {
            zzWT.disconnect();
        }
    }

    eApiClient(zzli zzli1, zzlo zzlo1, boolean flag, GoogleApiClient googleapiclient)
    {
        zzacr = zzli1;
        zzacv = zzlo1;
        zzacw = flag;
        zzWT = googleapiclient;
        super();
    }
}
