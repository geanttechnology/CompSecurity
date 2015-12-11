// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzbd;
import com.google.android.gms.internal.zzcq;
import com.google.android.gms.internal.zzdw;
import com.google.android.gms.internal.zzea;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            zzf, zzj, AdSizeParcel, zzd, 
//            zzc, zzn, zzb, zzh, 
//            zzt, zza

public class zzv
{

    private final Context mContext;
    private zza zzpG;
    private AdListener zzpH;
    private final zzcq zzqB;
    private final zzf zzqC;
    private zzn zzqE;
    private String zzqF;
    private InAppPurchaseListener zzqH;
    private PlayStorePurchaseListener zzqI;
    private OnCustomRenderedAdLoadedListener zzqJ;
    private PublisherInterstitialAd zzqK;
    private AppEventListener zzqb;
    private String zzqd;

    public zzv(Context context)
    {
        this(context, zzf.zzbG(), null);
    }

    public zzv(Context context, PublisherInterstitialAd publisherinterstitialad)
    {
        this(context, zzf.zzbG(), publisherinterstitialad);
    }

    public zzv(Context context, zzf zzf1, PublisherInterstitialAd publisherinterstitialad)
    {
        zzqB = new zzcq();
        mContext = context;
        zzqC = zzf1;
        zzqK = publisherinterstitialad;
    }

    private void zzA(String s)
    {
        if (zzqd == null)
        {
            zzB(s);
        }
        zzqE = zzj.zzbK().zza(mContext, new AdSizeParcel(), zzqd, zzqB);
        if (zzpH != null)
        {
            zzqE.zza(new zzc(zzpH));
        }
        if (zzpG != null)
        {
            zzqE.zza(new com.google.android.gms.ads.internal.client.zzb(zzpG));
        }
        if (zzqb != null)
        {
            zzqE.zza(new zzh(zzqb));
        }
        if (zzqH != null)
        {
            zzqE.zza(new zzdw(zzqH));
        }
        if (zzqI != null)
        {
            zzqE.zza(new zzea(zzqI), zzqF);
        }
        if (zzqJ != null)
        {
            zzqE.zza(new zzbd(zzqJ));
        }
    }

    private void zzB(String s)
    {
        if (zzqE == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("The ad unit ID must be set on InterstitialAd before ").append(s).append(" is called.").toString());
        } else
        {
            return;
        }
    }

    public AdListener getAdListener()
    {
        return zzpH;
    }

    public String getAdUnitId()
    {
        return zzqd;
    }

    public AppEventListener getAppEventListener()
    {
        return zzqb;
    }

    public InAppPurchaseListener getInAppPurchaseListener()
    {
        return zzqH;
    }

    public String getMediationAdapterClassName()
    {
        String s;
        if (zzqE == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        s = zzqE.getMediationAdapterClassName();
        return s;
        RemoteException remoteexception;
        remoteexception;
        zzb.zzd("Failed to get the mediation adapter class name.", remoteexception);
        return null;
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
    {
        return zzqJ;
    }

    public boolean isLoaded()
    {
        if (zzqE == null)
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = zzqE.isReady();
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Failed to check if ad is ready.", remoteexception);
            return false;
        }
        return flag;
    }

    public void setAdListener(AdListener adlistener)
    {
        zzpH = adlistener;
        if (zzqE == null) goto _L2; else goto _L1
_L1:
        zzn zzn1 = zzqE;
        if (adlistener == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        adlistener = new zzc(adlistener);
_L3:
        zzn1.zza(adlistener);
_L2:
        return;
        adlistener = null;
          goto _L3
        adlistener;
        zzb.zzd("Failed to set the AdListener.", adlistener);
        return;
    }

    public void setAdUnitId(String s)
    {
        if (zzqd != null)
        {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        } else
        {
            zzqd = s;
            return;
        }
    }

    public void setAppEventListener(AppEventListener appeventlistener)
    {
        zzqb = appeventlistener;
        if (zzqE == null) goto _L2; else goto _L1
_L1:
        zzn zzn1 = zzqE;
        if (appeventlistener == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        appeventlistener = new zzh(appeventlistener);
_L3:
        zzn1.zza(appeventlistener);
_L2:
        return;
        appeventlistener = null;
          goto _L3
        appeventlistener;
        zzb.zzd("Failed to set the AppEventListener.", appeventlistener);
        return;
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inapppurchaselistener)
    {
        if (zzqI != null)
        {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        zzqH = inapppurchaselistener;
        if (zzqE == null) goto _L2; else goto _L1
_L1:
        zzn zzn1 = zzqE;
        if (inapppurchaselistener == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        inapppurchaselistener = new zzdw(inapppurchaselistener);
_L3:
        zzn1.zza(inapppurchaselistener);
_L2:
        return;
        inapppurchaselistener = null;
          goto _L3
        inapppurchaselistener;
        zzb.zzd("Failed to set the InAppPurchaseListener.", inapppurchaselistener);
        return;
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener oncustomrenderedadloadedlistener)
    {
        zzqJ = oncustomrenderedadloadedlistener;
        if (zzqE == null) goto _L2; else goto _L1
_L1:
        zzn zzn1 = zzqE;
        if (oncustomrenderedadloadedlistener == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        oncustomrenderedadloadedlistener = new zzbd(oncustomrenderedadloadedlistener);
_L3:
        zzn1.zza(oncustomrenderedadloadedlistener);
_L2:
        return;
        oncustomrenderedadloadedlistener = null;
          goto _L3
        oncustomrenderedadloadedlistener;
        zzb.zzd("Failed to set the OnCustomRenderedAdLoadedListener.", oncustomrenderedadloadedlistener);
        return;
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playstorepurchaselistener, String s)
    {
        if (zzqH != null)
        {
            throw new IllegalStateException("In app purchase parameter has already been set.");
        }
        zzqI = playstorepurchaselistener;
        zzqF = s;
        if (zzqE == null) goto _L2; else goto _L1
_L1:
        zzn zzn1 = zzqE;
        if (playstorepurchaselistener == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        playstorepurchaselistener = new zzea(playstorepurchaselistener);
_L3:
        zzn1.zza(playstorepurchaselistener, s);
_L2:
        return;
        playstorepurchaselistener = null;
          goto _L3
        playstorepurchaselistener;
        zzb.zzd("Failed to set the play store purchase parameter.", playstorepurchaselistener);
        return;
    }

    public void show()
    {
        try
        {
            zzB("show");
            zzqE.showInterstitial();
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Failed to show interstitial.", remoteexception);
        }
    }

    public void zza(zza zza1)
    {
        zzpG = zza1;
        if (zzqE == null) goto _L2; else goto _L1
_L1:
        zzn zzn1 = zzqE;
        if (zza1 == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        zza1 = new com.google.android.gms.ads.internal.client.zzb(zza1);
_L3:
        zzn1.zza(zza1);
_L2:
        return;
        zza1 = null;
          goto _L3
        zza1;
        zzb.zzd("Failed to set the AdClickListener.", zza1);
        return;
    }

    public void zza(zzt zzt1)
    {
        try
        {
            if (zzqE == null)
            {
                zzA("loadAd");
            }
            if (zzqE.zza(zzqC.zza(mContext, zzt1)))
            {
                zzqB.zze(zzt1.zzbP());
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzt zzt1)
        {
            zzb.zzd("Failed to load ad.", zzt1);
        }
    }
}
