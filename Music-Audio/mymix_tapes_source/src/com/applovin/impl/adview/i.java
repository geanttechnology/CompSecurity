// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import com.applovin.adview.AppLovinInterstitialAdDialog;

// Referenced classes of package com.applovin.impl.adview:
//            AdViewControllerImpl, InterstitialAdDialogCreatorImpl, d, e, 
//            c, a

class i
    implements Runnable
{

    final AdViewControllerImpl a;

    private i(AdViewControllerImpl adviewcontrollerimpl)
    {
        a = adviewcontrollerimpl;
        super();
    }

    i(AdViewControllerImpl adviewcontrollerimpl, a a1)
    {
        this(adviewcontrollerimpl);
    }

    public void run()
    {
        if (AdViewControllerImpl.d(a) == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        AppLovinInterstitialAdDialog applovininterstitialaddialog = (new InterstitialAdDialogCreatorImpl()).createInterstitialAdDialog(AdViewControllerImpl.e(a), AdViewControllerImpl.f(a));
        applovininterstitialaddialog.setAdDisplayListener(new d(a));
        applovininterstitialaddialog.setAdVideoPlaybackListener(new e(a));
        applovininterstitialaddialog.setAdClickListener(new c(a));
        applovininterstitialaddialog.showAndRender(AdViewControllerImpl.d(a));
        return;
        Throwable throwable;
        throwable;
    }
}
