// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzj

abstract class zzafJ extends zzafJ
{

    public final int statusCode;
    public final Bundle zzafJ;
    final zzj zzafK;

    protected void zzc(Boolean boolean1)
    {
        Object obj = null;
        if (boolean1 != null) goto _L2; else goto _L1
_L1:
        zzj.zza(zzafK, 1, null);
_L4:
        return;
_L2:
        switch (statusCode)
        {
        default:
            zzj.zza(zzafK, 1, null);
            boolean1 = obj;
            if (zzafJ != null)
            {
                boolean1 = (PendingIntent)zzafJ.getParcelable("pendingIntent");
            }
            zzh(new ConnectionResult(statusCode, boolean1));
            return;

        case 0: // '\0'
            if (!zzpf())
            {
                zzj.zza(zzafK, 1, null);
                zzh(new ConnectionResult(8, null));
                return;
            }
            break;

        case 10: // '\n'
            zzj.zza(zzafK, 1, null);
            throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected abstract void zzh(ConnectionResult connectionresult);

    protected abstract boolean zzpf();

    protected void zzpg()
    {
    }

    protected void zzt(Object obj)
    {
        zzc((Boolean)obj);
    }

    protected (zzj zzj1, int i, Bundle bundle)
    {
        zzafK = zzj1;
        super(zzj1, Boolean.valueOf(true));
        statusCode = i;
        zzafJ = bundle;
    }
}
