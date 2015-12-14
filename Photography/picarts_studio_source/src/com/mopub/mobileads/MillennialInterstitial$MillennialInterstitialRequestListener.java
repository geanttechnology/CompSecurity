// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMInterstitial;
import com.millennialmedia.android.RequestListener;

// Referenced classes of package com.mopub.mobileads:
//            MillennialInterstitial, MoPubErrorCode

class this._cls0
    implements RequestListener
{

    final MillennialInterstitial this$0;

    public void MMAdOverlayClosed(MMAd mmad)
    {
        MillennialInterstitial.access$000(MillennialInterstitial.this).erstitialDismissed();
    }

    public void MMAdOverlayLaunched(MMAd mmad)
    {
        MillennialInterstitial.access$000(MillennialInterstitial.this).erstitialShown();
    }

    public void MMAdRequestIsCaching(MMAd mmad)
    {
    }

    public void onSingleTap(MMAd mmad)
    {
        MillennialInterstitial.access$000(MillennialInterstitial.this).erstitialClicked();
    }

    public void requestCompleted(MMAd mmad)
    {
        if (MillennialInterstitial.access$100(MillennialInterstitial.this).isAdAvailable())
        {
            MillennialInterstitial.access$000(MillennialInterstitial.this).erstitialLoaded();
            return;
        } else
        {
            MillennialInterstitial.access$000(MillennialInterstitial.this).erstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
            return;
        }
    }

    public void requestFailed(MMAd mmad, MMException mmexception)
    {
        if (MillennialInterstitial.access$100(MillennialInterstitial.this) == null || mmexception == null)
        {
            MillennialInterstitial.access$000(MillennialInterstitial.this).erstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
            return;
        }
        if (mmexception.getCode() == 17 && MillennialInterstitial.access$100(MillennialInterstitial.this).isAdAvailable())
        {
            MillennialInterstitial.access$000(MillennialInterstitial.this).erstitialLoaded();
            return;
        } else
        {
            MillennialInterstitial.access$000(MillennialInterstitial.this).erstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
            return;
        }
    }

    ()
    {
        this$0 = MillennialInterstitial.this;
        super();
    }
}
