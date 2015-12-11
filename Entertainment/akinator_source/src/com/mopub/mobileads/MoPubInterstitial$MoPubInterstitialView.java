// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.factories.CustomEventInterstitialAdapterFactory;
import java.util.Map;

// Referenced classes of package com.mopub.mobileads:
//            MoPubView, MoPubInterstitial, MoPubErrorCode, CustomEventInterstitialAdapter, 
//            AdViewController

public class setAutorefreshEnabled extends MoPubView
{

    final MoPubInterstitial this$0;

    protected void adFailed(MoPubErrorCode mopuberrorcode)
    {
        if (MoPubInterstitial.access$100(MoPubInterstitial.this) != null)
        {
            MoPubInterstitial.access$100(MoPubInterstitial.this).onInterstitialFailed(MoPubInterstitial.this, mopuberrorcode);
        }
    }

    public AdFormat getAdFormat()
    {
        return AdFormat.INTERSTITIAL;
    }

    protected void loadCustomEvent(String s, Map map)
    {
        if (mAdViewController == null)
        {
            return;
        }
        if (TextUtils.isEmpty(s))
        {
            MoPubLog.d("Couldn't invoke custom event because the server did not specify one.");
            loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
            return;
        }
        if (MoPubInterstitial.access$000(MoPubInterstitial.this) != null)
        {
            MoPubInterstitial.access$000(MoPubInterstitial.this).invalidate();
        }
        MoPubLog.d("Loading custom event interstitial adapter.");
        MoPubInterstitial.access$002(MoPubInterstitial.this, CustomEventInterstitialAdapterFactory.create(MoPubInterstitial.this, s, map, mAdViewController.getBroadcastIdentifier(), mAdViewController.getAdReport()));
        MoPubInterstitial.access$000(MoPubInterstitial.this).setAdapterListener(MoPubInterstitial.this);
        MoPubInterstitial.access$000(MoPubInterstitial.this).loadInterstitial();
    }

    protected void trackImpression()
    {
        MoPubLog.d("Tracking impression for interstitial.");
        if (mAdViewController != null)
        {
            mAdViewController.trackImpression();
        }
    }

    public Factory(Context context)
    {
        this$0 = MoPubInterstitial.this;
        super(context);
        setAutorefreshEnabled(false);
    }
}
