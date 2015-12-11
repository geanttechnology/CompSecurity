// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.ah;

// Referenced classes of package com.google.android.gms.ads.doubleclick:
//            PublisherAdRequest, AppEventListener

public final class PublisherInterstitialAd
{

    private final ah ea;

    public PublisherInterstitialAd(Context context)
    {
        ea = new ah(context);
    }

    public AdListener getAdListener()
    {
        return ea.getAdListener();
    }

    public String getAdUnitId()
    {
        return ea.getAdUnitId();
    }

    public AppEventListener getAppEventListener()
    {
        return ea.getAppEventListener();
    }

    public boolean isLoaded()
    {
        return ea.isLoaded();
    }

    public void loadAd(PublisherAdRequest publisheradrequest)
    {
        ea.a(publisheradrequest.v());
    }

    public void setAdListener(AdListener adlistener)
    {
        ea.setAdListener(adlistener);
    }

    public void setAdUnitId(String s)
    {
        ea.setAdUnitId(s);
    }

    public void setAppEventListener(AppEventListener appeventlistener)
    {
        ea.setAppEventListener(appeventlistener);
    }

    public void show()
    {
        ea.show();
    }
}
