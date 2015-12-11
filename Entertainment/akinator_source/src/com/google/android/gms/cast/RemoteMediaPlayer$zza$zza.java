// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzm;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

private final class zzXs
    implements ResultCallback
{

    private final long zzXs;
    final  zzXt;

    public void onResult(Result result)
    {
        zzo((Status)result);
    }

    public void zzo(Status status)
    {
        if (!status.isSuccess())
        {
            RemoteMediaPlayer.zzg(zzXt.).zzb(zzXs, status.getStatusCode());
        }
    }

    ( , long l)
    {
        zzXt = ;
        super();
        zzXs = l;
    }
}
