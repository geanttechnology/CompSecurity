// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzv, zzi

public final class zzTB extends zzTB
{

    private zzi zzTB;

    private void zzme()
    {
        zzTB = null;
    }

    public void zzb(int i, IBinder ibinder, Bundle bundle)
    {
        zzv.zzb(zzTB, "onPostInitComplete can be called only once per call to getRemoteService");
        zzTB.zza(i, ibinder, bundle);
        zzme();
    }

    public void zzc(int i, Bundle bundle)
    {
        zzv.zzb(zzTB, "onAccountValidationComplete can be called only once per call to validateAccount");
        zzTB.zzb(i, bundle);
        zzme();
    }

    public (zzi zzi1)
    {
        zzTB = zzi1;
    }
}
