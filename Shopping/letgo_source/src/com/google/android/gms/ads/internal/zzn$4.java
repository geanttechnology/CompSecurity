// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.support.v7.om;
import android.support.v7.te;
import android.support.v7.vk;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzn, zzq

class zzpx
    implements Runnable
{

    final zzn zzpt;
    final String zzpw;
    final te zzpx;

    public void run()
    {
        try
        {
            ((om)zzpt.zzos.zzqs.get(zzpw)).a((zzf)zzpx.w);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", remoteexception);
        }
    }

    lient.zzb(zzn zzn1, String s, te te1)
    {
        zzpt = zzn1;
        zzpw = s;
        zzpx = te1;
        super();
    }
}
