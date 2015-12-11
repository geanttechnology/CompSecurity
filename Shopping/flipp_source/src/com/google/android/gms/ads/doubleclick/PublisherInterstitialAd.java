// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.et;
import com.google.android.gms.internal.f;
import com.google.android.gms.internal.kz;
import com.google.android.gms.internal.r;

// Referenced classes of package com.google.android.gms.ads.doubleclick:
//            PublisherAdRequest, AppEventListener

public final class PublisherInterstitialAd
{

    private final r ea;

    public PublisherInterstitialAd(Context context)
    {
        ea = new r(context);
    }

    public final AdListener getAdListener()
    {
        return ea.a;
    }

    public final String getAdUnitId()
    {
        return ea.c;
    }

    public final AppEventListener getAppEventListener()
    {
        return ea.d;
    }

    public final boolean isLoaded()
    {
        return ea.a();
    }

    public final void loadAd(PublisherAdRequest publisheradrequest)
    {
        ea.a(publisheradrequest.v());
    }

    public final void setAdListener(AdListener adlistener)
    {
        ea.a(adlistener);
    }

    public final void setAdUnitId(String s)
    {
        ea.a(s);
    }

    public final void setAppEventListener(AppEventListener appeventlistener)
    {
        Object obj = ea;
        obj.d = appeventlistener;
        if (((r) (obj)).b == null) goto _L2; else goto _L1
_L1:
        obj = ((r) (obj)).b;
        if (appeventlistener == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        appeventlistener = new kz(appeventlistener);
_L3:
        ((f) (obj)).a(appeventlistener);
_L2:
        return;
        appeventlistener = null;
          goto _L3
        appeventlistener;
        et.a("Failed to set the AppEventListener.", appeventlistener);
        return;
    }

    public final void show()
    {
        ea.b();
    }
}
