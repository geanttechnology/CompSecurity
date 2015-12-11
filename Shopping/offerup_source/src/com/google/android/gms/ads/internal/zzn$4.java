// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzmi;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzn, zzq

class zzpF
    implements Runnable
{

    final zzn zzpB;
    final String zzpE;
    final zzhs zzpF;

    public void run()
    {
        try
        {
            ((zzcz)zzpB.zzot.zzqA.get(zzpE)).zza((zzf)zzpF.zzHB);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", remoteexception);
        }
    }

    lient.zzb(zzn zzn1, String s, zzhs zzhs1)
    {
        zzpB = zzn1;
        zzpE = s;
        zzpF = zzhs1;
        super();
    }
}
