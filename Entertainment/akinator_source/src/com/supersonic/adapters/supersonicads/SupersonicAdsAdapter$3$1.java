// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.adapters.supersonicads;

import com.supersonic.mediationsdk.sdk.InterstitialListener;
import com.supersonic.mediationsdk.utils.ErrorBuilder;
import com.supersonicads.sdk.SSAFactory;
import com.supersonicads.sdk.SSAPublisher;
import com.supersonicads.sdk.listeners.OnInterstitialListener;
import java.util.HashMap;

// Referenced classes of package com.supersonic.adapters.supersonicads:
//            SupersonicAdsAdapter

class this._cls1
    implements OnInterstitialListener
{

    final tialShowSuccess this$1;

    public void onInterstitialAdClicked()
    {
        if (SupersonicAdsAdapter.access$1400(_fld0) != null)
        {
            SupersonicAdsAdapter.access$1400(_fld0).onInterstitialAdClicked();
        }
    }

    public void onInterstitialAdClosed()
    {
        if (SupersonicAdsAdapter.access$1400(_fld0) != null)
        {
            SupersonicAdsAdapter.access$1400(_fld0).onInterstitialAdClosed();
        }
    }

    public void onInterstitialAvailability(boolean flag)
    {
        if (SupersonicAdsAdapter.access$1400(_fld0) != null)
        {
            SupersonicAdsAdapter.access$1400(_fld0).onInterstitialAvailability(flag);
        }
    }

    public void onInterstitialInitFail(String s)
    {
        if (SupersonicAdsAdapter.access$1400(_fld0) != null)
        {
            s = ErrorBuilder.buildAdapterInitFailedError(s);
            SupersonicAdsAdapter.access$1400(_fld0).onInterstitialInitFail(s);
        }
    }

    public void onInterstitialInitSuccess()
    {
        if (SupersonicAdsAdapter.access$1400(_fld0) != null)
        {
            SupersonicAdsAdapter.access$1400(_fld0).onInterstitialInitSuccess();
        }
    }

    public void onInterstitialShowFail(String s)
    {
        if (SupersonicAdsAdapter.access$1400(_fld0) != null)
        {
            s = ErrorBuilder.buildAdapterInitFailedError(s);
            SupersonicAdsAdapter.access$1400(_fld0).onInterstitialShowFail(s);
        }
    }

    public void onInterstitialShowSuccess()
    {
        if (SupersonicAdsAdapter.access$1400(_fld0) != null)
        {
            SupersonicAdsAdapter.access$1400(_fld0).onInterstitialShowSuccess();
        }
    }

    l.supersonicConfig()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/supersonic/adapters/supersonicads/SupersonicAdsAdapter$3

/* anonymous class */
    class SupersonicAdsAdapter._cls3
        implements Runnable
    {

        final SupersonicAdsAdapter this$0;
        final String val$appKey;
        final HashMap val$supersonicConfig;
        final String val$userId;

        public void run()
        {
            SupersonicAdsAdapter.access$002(SupersonicAdsAdapter.this, SSAFactory.getPublisherInstance(SupersonicAdsAdapter.access$100(SupersonicAdsAdapter.this)));
            SupersonicAdsAdapter.access$000(SupersonicAdsAdapter.this).initInterstitial(appKey, userId, supersonicConfig, new SupersonicAdsAdapter._cls3._cls1());
        }

            
            {
                this$0 = final_supersonicadsadapter;
                appKey = s;
                userId = s1;
                supersonicConfig = HashMap.this;
                super();
            }
    }

}
