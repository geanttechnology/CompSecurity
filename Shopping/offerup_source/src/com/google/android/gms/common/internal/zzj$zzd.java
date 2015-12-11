// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzx, zzj

public final class zzafN extends zzafN
{

    private zzj zzafM;
    private final int zzafN;

    private void zzpj()
    {
        zzafM = null;
    }

    public final void zza(int i, IBinder ibinder, Bundle bundle)
    {
        zzx.zzb(zzafM, "onPostInitComplete can be called only once per call to getRemoteService");
        zzafM.zza(i, ibinder, bundle, zzafN);
        zzpj();
    }

    public final void zzb(int i, Bundle bundle)
    {
        zzx.zzb(zzafM, "onAccountValidationComplete can be called only once per call to validateAccount");
        zzafM.zza(i, bundle, zzafN);
        zzpj();
    }

    public (zzj zzj1, int i)
    {
        zzafM = zzj1;
        zzafN = i;
    }
}
