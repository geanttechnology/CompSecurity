// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzcx;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzn, zzq

class zzpD
    implements Runnable
{

    final zzn zzpB;
    final zze zzpD;

    public void run()
    {
        try
        {
            zzpB.zzot.zzqy.zza(zzpD);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not call OnContentAdLoadedListener.onContentAdLoaded().", remoteexception);
        }
    }

    s.zze(zzn zzn1, zze zze)
    {
        zzpB = zzn1;
        zzpD = zze;
        super();
    }
}
