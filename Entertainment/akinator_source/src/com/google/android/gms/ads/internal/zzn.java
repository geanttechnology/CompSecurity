// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzg;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzeq;
import com.google.android.gms.internal.zzer;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzmi;
import java.util.List;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzb, zzq, zzp, zzo

public class zzn extends com.google.android.gms.ads.internal.zzb
{

    public zzn(Context context, AdSizeParcel adsizeparcel, String s, zzem zzem, VersionInfoParcel versioninfoparcel)
    {
        super(context, adsizeparcel, s, zzem, versioninfoparcel, null);
    }

    private static zzd zza(zzeq zzeq1)
        throws RemoteException
    {
        String s = zzeq1.getHeadline();
        List list = zzeq1.getImages();
        String s1 = zzeq1.getBody();
        com.google.android.gms.internal.zzcm zzcm;
        if (zzeq1.zzdw() != null)
        {
            zzcm = zzeq1.zzdw();
        } else
        {
            zzcm = null;
        }
        return new zzd(s, list, s1, zzcm, zzeq1.getCallToAction(), zzeq1.getStarRating(), zzeq1.getStore(), zzeq1.getPrice(), null, zzeq1.getExtras());
    }

    private static zze zza(zzer zzer1)
        throws RemoteException
    {
        String s = zzer1.getHeadline();
        List list = zzer1.getImages();
        String s1 = zzer1.getBody();
        com.google.android.gms.internal.zzcm zzcm;
        if (zzer1.zzdA() != null)
        {
            zzcm = zzer1.zzdA();
        } else
        {
            zzcm = null;
        }
        return new zze(s, list, s1, zzcm, zzer1.getCallToAction(), zzer1.getAdvertiser(), null, zzer1.getExtras());
    }

    private void zza(zzd zzd1)
    {
        zzid.zzIE.post(new _cls2(zzd1));
    }

    private void zza(zze zze1)
    {
        zzid.zzIE.post(new _cls3(zze1));
    }

    private void zza(zzhs zzhs1, String s)
    {
        zzid.zzIE.post(new _cls4(s, zzhs1));
    }

    public void pause()
    {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    public void recordImpression()
    {
        zza(zzot.zzqo, false);
    }

    public void resume()
    {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    public void showInterstitial()
    {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    public void zza(zzck zzck)
    {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    public void zza(zzfs zzfs)
    {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    public void zza(com.google.android.gms.internal.zzhs.zza zza1, zzcg zzcg)
    {
        if (zza1.zzqn != null)
        {
            zzot.zzqn = zza1.zzqn;
        }
        if (zza1.errorCode != -2)
        {
            zzid.zzIE.post(new _cls1(zza1));
            return;
        } else
        {
            zzot.zzqH = 0;
            zzot.zzqm = zzp.zzbu().zza(zzot.context, this, zza1, zzot.zzqi, null, zzox, this, zzcg);
            com.google.android.gms.ads.internal.util.client.zzb.zzaF((new StringBuilder()).append("AdRenderer: ").append(zzot.zzqm.getClass().getName()).toString());
            return;
        }
    }

    public void zza(zzmi zzmi1)
    {
        zzx.zzci("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        zzot.zzqA = zzmi1;
    }

    public void zza(List list)
    {
        zzx.zzci("setNativeTemplates must be called on the main UI thread.");
        zzot.zzqD = list;
    }

    protected boolean zza(AdRequestParcel adrequestparcel, zzhs zzhs1, boolean flag)
    {
        return zzos.zzbp();
    }

    protected boolean zza(zzhs zzhs1, zzhs zzhs2)
    {
        zza(((List) (null)));
        if (!zzot.zzbN())
        {
            throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
        }
        if (!zzhs2.zzEK) goto _L2; else goto _L1
_L1:
        zzeq zzeq1;
        Object obj;
        zzeq1 = zzhs2.zzzv.zzdV();
        obj = zzhs2.zzzv.zzdW();
        if (zzeq1 == null) goto _L4; else goto _L3
_L3:
        try
        {
            obj = zza(zzeq1);
            ((zzd) (obj)).zza(new zzg(zzot.context, this, zzot.zzqi, zzeq1));
            zza(((zzd) (obj)));
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get native ad mapper", remoteexception);
        }
_L6:
        return super.zza(zzhs1, zzhs2);
_L4:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        zze zze1 = zza(((zzer) (obj)));
        zze1.zza(new zzg(zzot.context, this, zzot.zzqi, ((zzer) (obj))));
        zza(zze1);
        continue; /* Loop/switch isn't completed */
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("No matching mapper for retrieved native ad template.");
        zze(0);
        return false;
_L2:
        com.google.android.gms.ads.internal.formats.zzh.zza zza1 = zzhs2.zzHB;
        if ((zza1 instanceof zze) && zzot.zzqy != null)
        {
            zza((zze)zzhs2.zzHB);
        } else
        if ((zza1 instanceof zzd) && zzot.zzqx != null)
        {
            zza((zzd)zzhs2.zzHB);
        } else
        if ((zza1 instanceof zzf) && zzot.zzqA != null && zzot.zzqA.get(((zzf)zza1).getCustomTemplateId()) != null)
        {
            zza(zzhs2, ((zzf)zza1).getCustomTemplateId());
        } else
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("No matching listener for retrieved native ad template.");
            zze(0);
            return false;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void zzb(NativeAdOptionsParcel nativeadoptionsparcel)
    {
        zzx.zzci("setNativeAdOptions must be called on the main UI thread.");
        zzot.zzqB = nativeadoptionsparcel;
    }

    public void zzb(zzcw zzcw)
    {
        zzx.zzci("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        zzot.zzqx = zzcw;
    }

    public void zzb(zzcx zzcx)
    {
        zzx.zzci("setOnContentAdLoadedListener must be called on the main UI thread.");
        zzot.zzqy = zzcx;
    }

    public void zzb(zzmi zzmi1)
    {
        zzx.zzci("setOnCustomClickListener must be called on the main UI thread.");
        zzot.zzqz = zzmi1;
    }

    public zzmi zzbo()
    {
        zzx.zzci("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return zzot.zzqA;
    }

    public zzcy zzr(String s)
    {
        zzx.zzci("getOnCustomClickListener must be called on the main UI thread.");
        return (zzcy)zzot.zzqz.get(s);
    }

    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls1 {}

}
