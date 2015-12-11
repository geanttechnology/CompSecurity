// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;

final class zzl
{

    private static volatile zzl zzaMF;
    private final String zzaLl;
    private final Status zzaMD;
    private final boolean zzaME;

    zzl(Context context)
    {
        boolean flag1 = true;
        super();
        Resources resources = context.getResources();
        int i = resources.getIdentifier("google_app_measurement_enable", "integer", context.getPackageName());
        boolean flag = flag1;
        if (i != 0)
        {
            if (resources.getInteger(i) != 0)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
        }
        zzaME = flag;
        i = resources.getIdentifier("google_app_id", "string", context.getPackageName());
        if (i == 0)
        {
            if (zzaME)
            {
                zzaMD = new Status(10, "Missing an expected resource: 'R.string.google_app_id' for initializing Google services.  Possible causes are missing google-services.json or com.google.gms.google-services gradle plugin.");
            } else
            {
                zzaMD = Status.zzabb;
            }
            zzaLl = null;
            return;
        }
        context = resources.getString(i);
        if (TextUtils.isEmpty(context))
        {
            if (zzaME)
            {
                zzaMD = new Status(10, (new StringBuilder()).append("The resource 'R.string.google_app_id' is invalid, expected an app  identifier and found: '").append(context).append("'.").toString());
            } else
            {
                zzaMD = Status.zzabb;
            }
            zzaLl = null;
            return;
        } else
        {
            zzaLl = context;
            zzaMD = Status.zzabb;
            return;
        }
    }

    public static Status zzaK(Context context)
    {
        zzx.zzb(context, "Context must not be null.");
        if (zzaMF != null) goto _L2; else goto _L1
_L1:
        com/google/android/gms/measurement/internal/zzl;
        JVM INSTR monitorenter ;
        if (zzaMF == null)
        {
            zzaMF = new zzl(context);
        }
        com/google/android/gms/measurement/internal/zzl;
        JVM INSTR monitorexit ;
_L2:
        return zzaMF.zzaMD;
        context;
        com/google/android/gms/measurement/internal/zzl;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static String zzzC()
    {
        if (zzaMF != null) goto _L2; else goto _L1
_L1:
        com/google/android/gms/measurement/internal/zzl;
        JVM INSTR monitorenter ;
        if (zzaMF == null)
        {
            throw new IllegalStateException("Initialize must be called before getGoogleAppId.");
        }
        break MISSING_BLOCK_LABEL_31;
        Exception exception;
        exception;
        com/google/android/gms/measurement/internal/zzl;
        JVM INSTR monitorexit ;
        throw exception;
        com/google/android/gms/measurement/internal/zzl;
        JVM INSTR monitorexit ;
_L2:
        return zzaMF.zzzD();
    }

    public static boolean zzzE()
    {
        if (zzaMF != null) goto _L2; else goto _L1
_L1:
        com/google/android/gms/measurement/internal/zzl;
        JVM INSTR monitorenter ;
        if (zzaMF == null)
        {
            throw new IllegalStateException("Initialize must be called before isMeasurementEnabled.");
        }
        break MISSING_BLOCK_LABEL_31;
        Exception exception;
        exception;
        com/google/android/gms/measurement/internal/zzl;
        JVM INSTR monitorexit ;
        throw exception;
        com/google/android/gms/measurement/internal/zzl;
        JVM INSTR monitorexit ;
_L2:
        return zzaMF.zzzF();
    }

    String zzzD()
    {
        if (!zzaMD.isSuccess())
        {
            throw new IllegalStateException((new StringBuilder()).append("Initialize must be successful before calling getGoogleAppId.  The result of the previous call to initialize was: '").append(zzaMD).append("'.").toString());
        } else
        {
            return zzaLl;
        }
    }

    boolean zzzF()
    {
        if (!zzaMD.isSuccess())
        {
            throw new IllegalStateException((new StringBuilder()).append("Initialize must be successful before calling isMeasurementEnabledInternal.  The result of the previous call to initialize was: '").append(zzaMD).append("'.").toString());
        } else
        {
            return zzaME;
        }
    }
}
