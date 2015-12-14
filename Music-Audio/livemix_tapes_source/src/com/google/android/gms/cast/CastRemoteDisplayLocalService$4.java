// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.content.Context;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.atomic.AtomicBoolean;

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
        if (laysessionresult.getStatus().isSuccess()) goto _L2; else goto _L1
_L1:
        CastRemoteDisplayLocalService.zzlV().zzc("Connection was not successful", new Object[0]);
        CastRemoteDisplayLocalService.zzc(zzTR);
_L4:
        return;
_L2:
        CastRemoteDisplayLocalService.zzlV().zzb("startRemoteDisplay successful", new Object[0]);
        synchronized (CastRemoteDisplayLocalService.zzlX())
        {
            if (CastRemoteDisplayLocalService.zzlY() != null)
            {
                break MISSING_BLOCK_LABEL_83;
            }
            CastRemoteDisplayLocalService.zzlV().zzb("Remote Display started but session already cancelled", new Object[0]);
            CastRemoteDisplayLocalService.zzc(zzTR);
        }
        return;
        laysessionresult;
        obj;
        JVM INSTR monitorexit ;
        throw laysessionresult;
        obj;
        JVM INSTR monitorexit ;
        laysessionresult = laysessionresult.getPresentationDisplay();
        if (laysessionresult != null)
        {
            CastRemoteDisplayLocalService.zza(zzTR, laysessionresult);
        } else
        {
            CastRemoteDisplayLocalService.zzlV().zzc("Cast Remote Display session created without display", new Object[0]);
        }
        CastRemoteDisplayLocalService.zzlW().set(false);
        if (CastRemoteDisplayLocalService.zzd(zzTR) != null && CastRemoteDisplayLocalService.zze(zzTR) != null)
        {
            try
            {
                CastRemoteDisplayLocalService.zzd(zzTR).unbindService(CastRemoteDisplayLocalService.zze(zzTR));
            }
            // Misplaced declaration of an exception variable
            catch (laySessionResult laysessionresult)
            {
                CastRemoteDisplayLocalService.zzlV().zzb("No need to unbind service, already unbound", new Object[0]);
            }
            CastRemoteDisplayLocalService.zza(zzTR, null);
            CastRemoteDisplayLocalService.zza(zzTR, null);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    laySessionResult(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        zzTR = castremotedisplaylocalservice;
        super();
    }
}
