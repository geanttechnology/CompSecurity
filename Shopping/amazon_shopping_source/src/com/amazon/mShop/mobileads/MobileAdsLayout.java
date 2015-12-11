// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mobileads;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AdSize;
import com.amazon.device.ads.AdTargetingOptions;
import com.amazon.device.ads.AmazonOOActionCode;
import com.amazon.device.ads.AmazonOOAdLayout;
import com.amazon.device.ads.AmazonOOAdListener;
import com.amazon.device.ads.AmazonOOAdResponse;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.mash.nav.AmazonNavManager;
import com.amazon.mShop.net.PageMetricsObserver;
import com.amazon.mShop.util.AttributionUtils;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.mobileads:
//            DebugSettingsActivityForAds

public class MobileAdsLayout extends AmazonOOAdLayout
{
    public static class MobileAdsDefaultListener
        implements AmazonOOAdListener
    {

        public void onAdCollapsed(Ad ad)
        {
        }

        public void onAdDismissed(Ad ad)
        {
        }

        public void onAdExpanded(Ad ad)
        {
        }

        public void onAdFailedToLoad(Ad ad, AdError aderror)
        {
        }

        public void onAdLoaded(Ad ad, AdProperties adproperties)
        {
        }

        public AmazonOOActionCode onAdReceived(Ad ad, AmazonOOAdResponse amazonooadresponse)
        {
            return AmazonOOActionCode.DISPLAY;
        }

        public void onSpecialUrlClicked(Ad ad, String s)
        {
        }

        public MobileAdsDefaultListener()
        {
        }
    }


    private com.amazon.mShop.AmazonActivity.OnConfigurationChangedListener mConfigListener;
    private boolean mLoadingStarted;
    private final String mMetricsId = String.valueOf(hashCode());
    private PageMetricsObserver mMetricsObserverForFailure;
    private PageMetricsObserver mMetricsObserverForSuccess;
    private final com.amazon.mShop.AmazonActivity.NewIntentListener mNewIntentListener = new com.amazon.mShop.AmazonActivity.NewIntentListener() {

        final MobileAdsLayout this$0;

        public void handleNewIntent(Intent intent)
        {
            collapseAd();
        }

            
            {
                this$0 = MobileAdsLayout.this;
                super();
            }
    };

    public MobileAdsLayout(Activity activity, AdSize adsize)
    {
        super(activity, adsize);
        mMetricsObserverForSuccess = null;
        mMetricsObserverForFailure = null;
        mLoadingStarted = false;
        mConfigListener = null;
        setShouldDisableWebViewHardwareAcceleration(true);
    }

    private void cancelMetrics(PageMetricsObserver pagemetricsobserver)
    {
        if (pagemetricsobserver != null && !pagemetricsobserver.isFinished())
        {
            pagemetricsobserver.onCancelled();
        }
    }

    private void completeMetrics(PageMetricsObserver pagemetricsobserver)
    {
        if (pagemetricsobserver != null && !pagemetricsobserver.isFinished())
        {
            pagemetricsobserver.completeForObject(mMetricsId);
        }
    }

    private com.amazon.mShop.AmazonActivity.OnConfigurationChangedListener getConfigChangedListener()
    {
        return mConfigListener;
    }

    private com.amazon.mShop.AmazonActivity.NewIntentListener getNewIntentListener()
    {
        return mNewIntentListener;
    }

    private void setConfigChangedListener(com.amazon.mShop.AmazonActivity.OnConfigurationChangedListener onconfigurationchangedlistener)
    {
        mConfigListener = onconfigurationchangedlistener;
    }

    private void setLoadingStarted(boolean flag)
    {
        mLoadingStarted = flag;
    }

    public void load(final AmazonOOAdListener adListener, String s)
    {
        ((AmazonActivity)getContext()).registerNewIntentListener(getNewIntentListener());
        setListener(new AmazonOOAdListener() {

            final MobileAdsLayout this$0;
            final AmazonOOAdListener val$adListener;

            public void onAdCollapsed(Ad ad)
            {
                if (adListener != null)
                {
                    adListener.onAdCollapsed(ad);
                }
            }

            public void onAdDismissed(Ad ad)
            {
                if (adListener != null)
                {
                    adListener.onAdDismissed(ad);
                }
            }

            public void onAdExpanded(Ad ad)
            {
                if (adListener != null)
                {
                    adListener.onAdExpanded(ad);
                }
            }

            public void onAdFailedToLoad(Ad ad, AdError aderror)
            {
                if (adListener != null)
                {
                    adListener.onAdFailedToLoad(ad, aderror);
                }
                completeMetrics(mMetricsObserverForFailure);
                cancelMetrics(mMetricsObserverForSuccess);
            }

            public void onAdLoaded(Ad ad, AdProperties adproperties)
            {
                if (adListener != null)
                {
                    adListener.onAdLoaded(ad, adproperties);
                }
                completeMetrics(mMetricsObserverForSuccess);
                cancelMetrics(mMetricsObserverForFailure);
            }

            public AmazonOOActionCode onAdReceived(Ad ad, AmazonOOAdResponse amazonooadresponse)
            {
                if (adListener != null)
                {
                    return adListener.onAdReceived(ad, amazonooadresponse);
                } else
                {
                    return AmazonOOActionCode.DISPLAY;
                }
            }

            public void onSpecialUrlClicked(Ad ad, String s1)
            {
                ad = Uri.parse(s1);
                if ("amazonmobile".equals(ad.getScheme()) && "shopping".equals(ad.getAuthority()))
                {
                    if (Util.isEmpty(ad.getQueryParameter("clickstream-tag")))
                    {
                        ad.buildUpon().appendQueryParameter("clickstream-tag", ClickStreamTag.ORIGIN_MOBILEADS.getTag()).build();
                    }
                    (new AmazonNavManager()).navigate(s1, getContext());
                }
            }

            
            {
                this$0 = MobileAdsLayout.this;
                adListener = amazonooadlistener;
                super();
            }
        });
        adListener = new AdTargetingOptions();
        if (s != null)
        {
            if (DebugSettings.isDebugEnabled())
            {
                adListener.setAdvancedOption("pt", DebugSettingsActivityForAds.getAdIdWithTypePostfix(getContext(), s));
            } else
            {
                adListener.setAdvancedOption("pt", s);
            }
        }
        adListener.setAdvancedOption("pk", (new StringBuilder()).append("[\"").append(AttributionUtils.getAssociatesTag(getContext())).append("\"]").toString());
        if (mMetricsObserverForSuccess == null || mMetricsObserverForSuccess.isFinished())
        {
            mMetricsObserverForSuccess = new PageMetricsObserver("MobileAdsSuccess");
            mMetricsObserverForSuccess.startForObject(mMetricsId);
        }
        if (mMetricsObserverForFailure == null || mMetricsObserverForFailure.isFinished())
        {
            mMetricsObserverForFailure = new PageMetricsObserver("MobileAdsFailure");
            mMetricsObserverForFailure.startForObject(mMetricsId);
        }
        if (DebugSettings.isDebugEnabled())
        {
            adListener.setAdvancedOption("c", DebugSettingsActivityForAds.getChannel(getContext()));
        }
        loadAd(adListener);
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        cancelMetrics(mMetricsObserverForFailure);
        cancelMetrics(mMetricsObserverForSuccess);
        ((AmazonActivity)getContext()).unregisterConfigChangedListener(getConfigChangedListener());
        ((AmazonActivity)getContext()).unregisterNewIntentListener(getNewIntentListener());
        destroy();
    }




}
