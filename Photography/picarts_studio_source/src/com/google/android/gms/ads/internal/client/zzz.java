// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzgb;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            zzh, zzk, zzl, AdSizeParcel, 
//            zzs, zzc, zzj, zzb, 
//            zzy, zze, zza

public class zzz
{

    private final zzh zznL;
    private boolean zzoN;
    private String zzpa;
    private com.google.android.gms.ads.internal.client.zza zzsy;
    private AdListener zzsz;
    private final zzel zztD;
    private final AtomicBoolean zztE;
    private zzs zztF;
    private String zztG;
    private ViewGroup zztH;
    private InAppPurchaseListener zztI;
    private PlayStorePurchaseListener zztJ;
    private OnCustomRenderedAdLoadedListener zztK;
    private AppEventListener zztj;
    private AdSize zztk[];

    public zzz(ViewGroup viewgroup)
    {
        this(viewgroup, null, false, zzh.zzcB());
    }

    public zzz(ViewGroup viewgroup, AttributeSet attributeset, boolean flag)
    {
        this(viewgroup, attributeset, flag, zzh.zzcB());
    }

    zzz(ViewGroup viewgroup, AttributeSet attributeset, boolean flag, zzh zzh1)
    {
        this(viewgroup, attributeset, flag, zzh1, null);
    }

    zzz(ViewGroup viewgroup, AttributeSet attributeset, boolean flag, zzh zzh1, zzs zzs1)
    {
        zztD = new zzel();
        zztH = viewgroup;
        zznL = zzh1;
        zztF = zzs1;
        zztE = new AtomicBoolean(false);
        if (attributeset != null)
        {
            zzh1 = viewgroup.getContext();
            try
            {
                attributeset = new zzk(zzh1, attributeset);
                zztk = attributeset.zzi(flag);
                zzpa = attributeset.getAdUnitId();
            }
            // Misplaced declaration of an exception variable
            catch (AttributeSet attributeset)
            {
                zzl.zzcF().zza(viewgroup, new AdSizeParcel(zzh1, AdSize.BANNER), attributeset.getMessage(), attributeset.getMessage());
                return;
            }
            if (viewgroup.isInEditMode())
            {
                zzl.zzcF().zza(viewgroup, new AdSizeParcel(zzh1, zztk[0]), "Ads by Google");
            }
        }
    }

    private void zzcS()
    {
        com.google.android.gms.dynamic.zzd zzd = zztF.zzaM();
        if (zzd == null)
        {
            return;
        }
        try
        {
            zztH.addView((View)zze.zzp(zzd));
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Failed to get an ad frame.", remoteexception);
        }
        return;
    }

    public void destroy()
    {
        try
        {
            if (zztF != null)
            {
                zztF.destroy();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Failed to destroy AdView.", remoteexception);
        }
    }

    public AdListener getAdListener()
    {
        return zzsz;
    }

    public AdSize getAdSize()
    {
        Object obj;
        if (zztF == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        obj = zztF.zzaN();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        obj = ((AdSizeParcel) (obj)).zzcD();
        return ((AdSize) (obj));
        RemoteException remoteexception;
        remoteexception;
        zzb.zzd("Failed to get the current AdSize.", remoteexception);
        if (zztk != null)
        {
            return zztk[0];
        } else
        {
            return null;
        }
    }

    public AdSize[] getAdSizes()
    {
        return zztk;
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

    public boolean isLoading()
    {
        boolean flag;
        if (zztF == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        flag = zztF.isLoading();
        return flag;
        RemoteException remoteexception;
        remoteexception;
        zzb.zzd("Failed to check if ad is loading.", remoteexception);
        return false;
    }

    public void pause()
    {
        try
        {
            if (zztF != null)
            {
                zztF.pause();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Failed to call pause.", remoteexception);
        }
    }

    public void recordManualImpression()
    {
        if (!zztE.getAndSet(true)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (zztF == null) goto _L1; else goto _L3
_L3:
        zztF.zzaP();
        return;
        RemoteException remoteexception;
        remoteexception;
        zzb.zzd("Failed to record impression.", remoteexception);
        return;
    }

    public void resume()
    {
        try
        {
            if (zztF != null)
            {
                zztF.resume();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Failed to call resume.", remoteexception);
        }
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

    public transient void setAdSizes(AdSize aadsize[])
    {
        if (zztk != null)
        {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        } else
        {
            zza(aadsize);
            return;
        }
    }

    public void setAdUnitId(String s)
    {
        if (zzpa != null)
        {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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
            break MISSING_BLOCK_LABEL_56;
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

    public void setManualImpressionsEnabled(boolean flag)
    {
        zzoN = flag;
        try
        {
            if (zztF != null)
            {
                zztF.setManualImpressionsEnabled(zzoN);
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Failed to set manual impressions.", remoteexception);
        }
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
        zzb.zzd("Failed to set the onCustomRenderedAdLoadedListener.", oncustomrenderedadloadedlistener);
        return;
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playstorepurchaselistener, String s)
    {
        if (zztI != null)
        {
            throw new IllegalStateException("InAppPurchaseListener has already been set.");
        }
        zztJ = playstorepurchaselistener;
        zztG = s;
        if (zztF == null) goto _L2; else goto _L1
_L1:
        zzs zzs1 = zztF;
        if (playstorepurchaselistener == null)
        {
            break MISSING_BLOCK_LABEL_62;
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

    public void zza(com.google.android.gms.ads.internal.client.zza zza1)
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
                zzcT();
            }
            if (zztF.zzb(zznL.zza(zztH.getContext(), zzy1)))
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

    public transient void zza(AdSize aadsize[])
    {
        zztk = aadsize;
        try
        {
            if (zztF != null)
            {
                zztF.zza(new AdSizeParcel(zztH.getContext(), zztk));
            }
        }
        // Misplaced declaration of an exception variable
        catch (AdSize aadsize[])
        {
            zzb.zzd("Failed to set the ad size.", aadsize);
        }
        zztH.requestLayout();
    }

    void zzcT()
    {
        if ((zztk == null || zzpa == null) && zztF == null)
        {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        zztF = zzcU();
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
        zztF.zza(zzl.zzcH());
        zztF.setManualImpressionsEnabled(zzoN);
        zzcS();
    }

    protected zzs zzcU()
    {
        android.content.Context context = zztH.getContext();
        return zzl.zzcG().zza(context, new AdSizeParcel(context, zztk), zzpa, zztD);
    }
}
