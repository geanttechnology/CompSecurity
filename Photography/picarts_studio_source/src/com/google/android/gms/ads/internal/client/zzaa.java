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
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzgb;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            zzh, zzl, AdSizeParcel, zze, 
//            zzc, zzs, zzb, zzj, 
//            zzy, zza

public class zzaa
{

    private final Context mContext;
    private final zzh zznL;
    private String zzpa;
    private zza zzsy;
    private AdListener zzsz;
    private final zzel zztD;
    private zzs zztF;
    private String zztG;
    private InAppPurchaseListener zztI;
    private PlayStorePurchaseListener zztJ;
    private OnCustomRenderedAdLoadedListener zztK;
    private PublisherInterstitialAd zztL;
    private AppEventListener zztj;

    public zzaa(Context context)
    {
        this(context, zzh.zzcB(), null);
    }

    public zzaa(Context context, PublisherInterstitialAd publisherinterstitialad)
    {
        this(context, zzh.zzcB(), publisherinterstitialad);
    }

    public zzaa(Context context, zzh zzh1, PublisherInterstitialAd publisherinterstitialad)
    {
        zztD = new zzel();
        mContext = context;
        zznL = zzh1;
        zztL = publisherinterstitialad;
    }

    private void zzM(String s)
    {
        if (zzpa == null)
        {
            zzN(s);
        }
        zztF = zzl.zzcG().zzb(mContext, new AdSizeParcel(), zzpa, zztD);
        if (zzsz != null)
        {
            zztF.zza(new zzc(zzsz));
        }
        if (zzsy != null)
        {
            zztF.zza(new com.google.android.gms.ads.internal.client.zzb(zzsy));
        }
        if (zztj != null)
        {
            zztF.zza(new zzj(zztj));
        }
        if (zztI != null)
        {
            zztF.zza(new zzfx(zztI));
        }
        if (zztJ != null)
        {
            zztF.zza(new zzgb(zztJ), zztG);
        }
        if (zztK != null)
        {
            zztF.zza(new zzcl(zztK));
        }
    }

    private void zzN(String s)
    {
        if (zztF == null)
        {
            throw new IllegalStateException((new StringBuilder("The ad unit ID must be set on InterstitialAd before ")).append(s).append(" is called.").toString());
        } else
        {
            return;
        }
    }

    public AdListener getAdListener()
    {
        return zzsz;
    }

    public String getAdUnitId()
    {
        return zzpa;
    }

    public AppEventListener getAppEventListener()
    {
        return zztj;
    }

    public InAppPurchaseListener getInAppPurchaseListener()
    {
        return zztI;
    }

    public String getMediationAdapterClassName()
    {
        String s;
        if (zztF == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        s = zztF.getMediationAdapterClassName();
        return s;
        RemoteException remoteexception;
        remoteexception;
        zzb.zzd("Failed to get the mediation adapter class name.", remoteexception);
        return null;
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
    {
        return zztK;
    }

    public boolean isLoaded()
    {
        if (zztF == null)
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = zztF.isReady();
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Failed to check if ad is ready.", remoteexception);
            return false;
        }
        return flag;
    }

    public boolean isLoading()
    {
        if (zztF == null)
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = zztF.isLoading();
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Failed to check if ad is loading.", remoteexception);
            return false;
        }
        return flag;
    }

    public void setAdListener(AdListener adlistener)
    {
        zzsz = adlistener;
        if (zztF == null) goto _L2; else goto _L1
_L1:
        zzs zzs1 = zztF;
        if (adlistener == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        adlistener = new zzc(adlistener);
_L3:
        zzs1.zza(adlistener);
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
        if (zzpa != null)
        {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        } else
        {
            zzpa = s;
            return;
        }
    }

    public void setAppEventListener(AppEventListener appeventlistener)
    {
        zztj = appeventlistener;
        if (zztF == null) goto _L2; else goto _L1
_L1:
        zzs zzs1 = zztF;
        if (appeventlistener == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        appeventlistener = new zzj(appeventlistener);
_L3:
        zzs1.zza(appeventlistener);
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
        if (zztJ != null)
        {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        zztI = inapppurchaselistener;
        if (zztF == null) goto _L2; else goto _L1
_L1:
        zzs zzs1 = zztF;
        if (inapppurchaselistener == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        inapppurchaselistener = new zzfx(inapppurchaselistener);
_L3:
        zzs1.zza(inapppurchaselistener);
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
        zztK = oncustomrenderedadloadedlistener;
        if (zztF == null) goto _L2; else goto _L1
_L1:
        zzs zzs1 = zztF;
        if (oncustomrenderedadloadedlistener == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        oncustomrenderedadloadedlistener = new zzcl(oncustomrenderedadloadedlistener);
_L3:
        zzs1.zza(oncustomrenderedadloadedlistener);
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
        if (zztI != null)
        {
            throw new IllegalStateException("In app purchase parameter has already been set.");
        }
        zztJ = playstorepurchaselistener;
        zztG = s;
        if (zztF == null) goto _L2; else goto _L1
_L1:
        zzs zzs1 = zztF;
        if (playstorepurchaselistener == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        playstorepurchaselistener = new zzgb(playstorepurchaselistener);
_L3:
        zzs1.zza(playstorepurchaselistener, s);
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
            zzN("show");
            zztF.showInterstitial();
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Failed to show interstitial.", remoteexception);
        }
    }

    public void zza(zza zza1)
    {
        zzsy = zza1;
        if (zztF == null) goto _L2; else goto _L1
_L1:
        zzs zzs1 = zztF;
        if (zza1 == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        zza1 = new com.google.android.gms.ads.internal.client.zzb(zza1);
_L3:
        zzs1.zza(zza1);
_L2:
        return;
        zza1 = null;
          goto _L3
        zza1;
        zzb.zzd("Failed to set the AdClickListener.", zza1);
        return;
    }

    public void zza(zzy zzy1)
    {
        try
        {
            if (zztF == null)
            {
                zzM("loadAd");
            }
            if (zztF.zzb(zznL.zza(mContext, zzy1)))
            {
                zztD.zze(zzy1.zzcO());
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzy zzy1)
        {
            zzb.zzd("Failed to load ad.", zzy1);
        }
    }
}
