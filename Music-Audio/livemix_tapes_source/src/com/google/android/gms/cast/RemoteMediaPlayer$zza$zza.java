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

private final class zzVA
    implements ResultCallback
{

    private final long zzVA;
    final  zzVB;

    public void onResult(Result result)
    {
        zzr((Status)result);
    }

    public void zzr(Status status)
    {
        if (!status.isSuccess())
        {
            RemoteMediaPlayer.zzg(zzVB.).zzb(zzVA, status.getStatusCode());
        }
    }

    ( , long l)
    {
        zzVB = ;
        super();
        zzVA = l;
    }
}
