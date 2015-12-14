// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzfw;

// Referenced classes of package com.google.android.gms.ads.internal.purchase:
//            zzc, zzf, zzk, zzg

class val.intent
    implements Runnable
{

    final Intent val$intent;
    final zzf zzCH;
    final zzc zzCI;

    public void run()
    {
        if (zzc.zza(zzCI).zza(zzCH.zzCR, -1, val$intent))
        {
            zzc.zzc(zzCI).zza(new zzg(com.google.android.gms.ads.internal.purchase.zzc.zzb(zzCI), zzCH.zzCS, true, -1, val$intent, zzCH));
            return;
        }
        try
        {
            zzc.zzc(zzCI).zza(new zzg(com.google.android.gms.ads.internal.purchase.zzc.zzb(zzCI), zzCH.zzCS, false, -1, val$intent, zzCH));
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzaH("Fail to verify and dispatch pending transaction");
        }
        return;
    }

    (zzf zzf1, Intent intent1)
    {
        zzCI = final_zzc1;
        zzCH = zzf1;
        val$intent = intent1;
        super();
    }
}
