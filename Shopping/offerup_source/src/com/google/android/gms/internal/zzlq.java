// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzb;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.common.internal.zzx;

public class zzlq extends zze
    implements ResultCallback
{

    private final Object zzabh;
    private zzb zzacY;
    private zzlq zzacZ;
    private ResultCallbacks zzada;
    private PendingResult zzadb;

    private void zzd(Result result)
    {
        if (!(result instanceof Releasable))
        {
            break MISSING_BLOCK_LABEL_16;
        }
        ((Releasable)result).release();
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        Log.w("TransformedResultImpl", (new StringBuilder("Unable to release ")).append(result).toString(), runtimeexception);
        return;
    }

    private void zzon()
    {
        if (zzadb == null || zzacY == null && zzada == null)
        {
            return;
        } else
        {
            zzadb.setResultCallback(this);
            return;
        }
    }

    public void onResult(Result result)
    {
        Object obj = zzabh;
        obj;
        JVM INSTR monitorenter ;
        if (!result.getStatus().isSuccess())
        {
            break MISSING_BLOCK_LABEL_96;
        }
        if (zzacY == null) goto _L2; else goto _L1
_L1:
        PendingResult pendingresult = zzacY.zza(result);
        if (pendingresult != null) goto _L4; else goto _L3
_L3:
        zzx(new Status(13, "Transform returned null"));
_L5:
        zzd(result);
_L7:
        obj;
        JVM INSTR monitorexit ;
        return;
_L4:
        zzacZ.zza(pendingresult);
          goto _L5
        result;
        obj;
        JVM INSTR monitorexit ;
        throw result;
_L2:
        if (zzada == null) goto _L7; else goto _L6
_L6:
        zzada.onSuccess(result);
          goto _L7
        zzx(result.getStatus());
        zzd(result);
          goto _L7
    }

    public void zza(PendingResult pendingresult)
    {
        synchronized (zzabh)
        {
            zzadb = pendingresult;
            zzon();
        }
        return;
        pendingresult;
        obj;
        JVM INSTR monitorexit ;
        throw pendingresult;
    }

    public void zzx(Status status)
    {
        Object obj = zzabh;
        obj;
        JVM INSTR monitorenter ;
        if (zzacY == null) goto _L2; else goto _L1
_L1:
        status = zzacY.zzu(status);
        com.google.android.gms.common.internal.zzx.zzb(status, "onFailure must not return null");
        zzacZ.zzx(status);
_L4:
        return;
_L2:
        if (zzada != null)
        {
            zzada.onFailure(status);
        }
        if (true) goto _L4; else goto _L3
_L3:
        status;
        obj;
        JVM INSTR monitorexit ;
        throw status;
    }
}
