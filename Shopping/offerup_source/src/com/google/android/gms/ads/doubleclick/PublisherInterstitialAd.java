// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.internal.client.zzaa;

// Referenced classes of package com.google.android.gms.ads.doubleclick:
//            PublisherAdRequest, AppEventListener, OnCustomRenderedAdLoadedListener

public final class PublisherInterstitialAd
{

    private final zzaa zznU;

    public PublisherInterstitialAd(Context context)
    {
        zznU = new zzaa(context, this);
    }

    public final AdListener getAdListener()
    {
        return zznU.getAdListener();
    }

    public final String getAdUnitId()
    {
        return zznU.getAdUnitId();
    }

    public final AppEventListener getAppEventListener()
    {
        return zznU.getAppEventListener();
    }

    public final String getMediationAdapterClassName()
    {
        return zznU.getMediationAdapterClassName();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
    {
        return zznU.getOnCustomRenderedAdLoadedListener();
    }

    public final boolean isLoaded()
    {
        return zznU.isLoaded();
    }

    public final void loadAd(PublisherAdRequest publisheradrequest)
    {
        zznU.zza(publisheradrequest.zzaF());
    }

    public final void setAdListener(AdListener adlistener)
    {
        zznU.setAdListener(adlistener);
    }

    public final void setAdUnitId(String s)
    {
        zznU.setAdUnitId(s);
    }

    public final void setAppEventListener(AppEventListener appeventlistener)
    {
        zznU.setAppEventListener(appeventlistener);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener oncustomrenderedadloadedlistener)
    {
        zznU.setOnCustomRenderedAdLoadedListener(oncustomrenderedadloadedlistener);
    }

    public final void show()
    {
        zznU.show();
    }
}
