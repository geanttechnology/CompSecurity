// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzaa;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

// Referenced classes of package com.google.android.gms.ads:
//            AdRequest, AdListener

public final class InterstitialAd
{

    private final zzaa zznU;

    public InterstitialAd(Context context)
    {
        zznU = new zzaa(context);
    }

    public final AdListener getAdListener()
    {
        return zznU.getAdListener();
    }

    public final String getAdUnitId()
    {
        return zznU.getAdUnitId();
    }

    public final InAppPurchaseListener getInAppPurchaseListener()
    {
        return zznU.getInAppPurchaseListener();
    }

    public final String getMediationAdapterClassName()
    {
        return zznU.getMediationAdapterClassName();
    }

    public final boolean isLoaded()
    {
        return zznU.isLoaded();
    }

    public final boolean isLoading()
    {
        return zznU.isLoading();
    }

    public final void loadAd(AdRequest adrequest)
    {
        zznU.zza(adrequest.zzaF());
    }

    public final void setAdListener(AdListener adlistener)
    {
        zznU.setAdListener(adlistener);
        if (adlistener != null && (adlistener instanceof zza))
        {
            zznU.zza((zza)adlistener);
        } else
        if (adlistener == null)
        {
            zznU.zza(null);
            return;
        }
    }

    public final void setAdUnitId(String s)
    {
        zznU.setAdUnitId(s);
    }

    public final void setInAppPurchaseListener(InAppPurchaseListener inapppurchaselistener)
    {
        zznU.setInAppPurchaseListener(inapppurchaselistener);
    }

    public final void setPlayStorePurchaseParams(PlayStorePurchaseListener playstorepurchaselistener, String s)
    {
        zznU.setPlayStorePurchaseParams(playstorepurchaselistener, s);
    }

    public final void show()
    {
        zznU.show();
    }
}
