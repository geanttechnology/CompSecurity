// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzcw;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzn, zzq

class zzpC
    implements Runnable
{

    final zzn zzpB;
    final zzd zzpC;

    public void run()
    {
        try
        {
            zzpB.zzot.zzqx.zza(zzpC);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", remoteexception);
        }
    }

    s.zzd(zzn zzn1, zzd zzd)
    {
        zzpB = zzn1;
        zzpC = zzd;
        super();
    }
}
