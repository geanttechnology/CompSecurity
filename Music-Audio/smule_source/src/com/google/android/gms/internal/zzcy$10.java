// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.a.b;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzcy, zzcz, zzct

class zzvf
    implements Runnable
{

    final zzcy zzve;
    final b zzvf;

    public void run()
    {
        try
        {
            zzcy.zza(zzve).onAdFailedToLoad(zzcz.zza(zzvf));
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not call onAdFailedToLoad.", remoteexception);
        }
    }

    .client.zzb(zzcy zzcy1, b b)
    {
        zzve = zzcy1;
        zzvf = b;
        super();
    }
}
