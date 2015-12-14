// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.cast:
//            CastRemoteDisplayLocalService

class zzTR
    implements ResultCallback
{

    final CastRemoteDisplayLocalService zzTR;

    public void onResult(Result result)
    {
        zza((laySessionResult)result);
    }

    public void zza(laySessionResult laysessionresult)
    {
        if (!laysessionresult.getStatus().isSuccess())
        {
            CastRemoteDisplayLocalService.zza(zzTR, "Unable to stop the remote display, result unsuccessful");
        } else
        {
            CastRemoteDisplayLocalService.zza(zzTR, "remote display stopped");
        }
        CastRemoteDisplayLocalService.zzb(zzTR, null);
    }

    laySessionResult(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        zzTR = castremotedisplaylocalservice;
        super();
    }
}
