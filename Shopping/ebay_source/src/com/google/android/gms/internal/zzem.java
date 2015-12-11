// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzeh

public final class zzem
    implements MediationBannerListener, MediationInterstitialListener
{

    private final zzeh zzyg;

    public zzem(zzeh zzeh1)
    {
        zzyg = zzeh1;
    }

    static zzeh zza(zzem zzem1)
    {
        return zzem1.zzyg;
    }

    public void onClick(MediationBannerAdapter mediationbanneradapter)
    {
        zzb.zzay("Adapter called onClick.");
        if (!zzk.zzcA().zzgw())
        {
            zzb.zzaC("onClick must be called on the main UI thread.");
            zza.zzGF.post(new Runnable() {

                final zzem zzyj;

                public void run()
                {
                    try
                    {
                        com.google.android.gms.internal.zzem.zza(zzyj).onAdClicked();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzb.zzd("Could not call onAdClicked.", remoteexception);
                    }
                }

            
            {
                zzyj = zzem.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzyg.onAdClicked();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            zzb.zzd("Could not call onAdClicked.", mediationbanneradapter);
        }
    }
}
