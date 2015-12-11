// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.factories.CustomEventBannerFactory;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package com.mopub.mobileads:
//            MoPubView, MoPubErrorCode, CustomEventBanner, HtmlBannerWebView

public class CustomEventBannerAdapter
    implements CustomEventBanner.CustomEventBannerListener
{

    public static final int DEFAULT_BANNER_TIMEOUT_DELAY = 10000;
    private Context mContext;
    private CustomEventBanner mCustomEventBanner;
    private final Handler mHandler = new Handler();
    private boolean mInvalidated;
    private Map mLocalExtras;
    private MoPubView mMoPubView;
    private Map mServerExtras;
    private boolean mStoredAutorefresh;
    private final Runnable mTimeout = new Runnable() {

        final CustomEventBannerAdapter this$0;

        public void run()
        {
            MoPubLog.d("Third-party network timed out.");
            onBannerFailed(MoPubErrorCode.NETWORK_TIMEOUT);
            invalidate();
        }

            
            {
                this$0 = CustomEventBannerAdapter.this;
                super();
            }
    };

    public CustomEventBannerAdapter(MoPubView mopubview, String s, Map map, long l, AdReport adreport)
    {
        Preconditions.checkNotNull(map);
        mMoPubView = mopubview;
        mContext = mopubview.getContext();
        MoPubLog.d((new StringBuilder()).append("Attempting to invoke custom event: ").append(s).toString());
        try
        {
            mCustomEventBanner = CustomEventBannerFactory.create(s);
        }
        // Misplaced declaration of an exception variable
        catch (MoPubView mopubview)
        {
            MoPubLog.d((new StringBuilder()).append("Couldn't locate or instantiate custom event: ").append(s).append(".").toString());
            mMoPubView.loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
            return;
        }
        mServerExtras = new TreeMap(map);
        mLocalExtras = mMoPubView.getLocalExtras();
        if (mMoPubView.getLocation() != null)
        {
            mLocalExtras.put("location", mMoPubView.getLocation());
        }
        mLocalExtras.put("broadcastIdentifier", Long.valueOf(l));
        mLocalExtras.put("mopub-intent-ad-report", adreport);
        mLocalExtras.put("com_mopub_ad_width", Integer.valueOf(mMoPubView.getAdWidth()));
        mLocalExtras.put("com_mopub_ad_height", Integer.valueOf(mMoPubView.getAdHeight()));
    }

    private void cancelTimeout()
    {
        mHandler.removeCallbacks(mTimeout);
    }

    private int getTimeoutDelayMilliseconds()
    {
        if (mMoPubView == null || mMoPubView.getAdTimeoutDelay() == null || mMoPubView.getAdTimeoutDelay().intValue() < 0)
        {
            return 10000;
        } else
        {
            return mMoPubView.getAdTimeoutDelay().intValue() * 1000;
        }
    }

    void invalidate()
    {
        if (mCustomEventBanner != null)
        {
            try
            {
                mCustomEventBanner.onInvalidate();
            }
            catch (Exception exception)
            {
                MoPubLog.d("Invalidating a custom event banner threw an exception", exception);
            }
        }
        mContext = null;
        mCustomEventBanner = null;
        mLocalExtras = null;
        mServerExtras = null;
        mInvalidated = true;
    }

    boolean isInvalidated()
    {
        return mInvalidated;
    }

    void loadAd()
    {
        if (isInvalidated() || mCustomEventBanner == null)
        {
            return;
        }
        if (getTimeoutDelayMilliseconds() > 0)
        {
            mHandler.postDelayed(mTimeout, getTimeoutDelayMilliseconds());
        }
        try
        {
            mCustomEventBanner.loadBanner(mContext, this, mLocalExtras, mServerExtras);
            return;
        }
        catch (Exception exception)
        {
            MoPubLog.d("Loading a custom event banner threw an exception.", exception);
        }
        onBannerFailed(MoPubErrorCode.INTERNAL_ERROR);
    }

    public void onBannerClicked()
    {
        while (isInvalidated() || mMoPubView == null) 
        {
            return;
        }
        mMoPubView.registerClick();
    }

    public void onBannerCollapsed()
    {
        if (isInvalidated())
        {
            return;
        } else
        {
            mMoPubView.setAutorefreshEnabled(mStoredAutorefresh);
            mMoPubView.adClosed();
            return;
        }
    }

    public void onBannerExpanded()
    {
        if (isInvalidated())
        {
            return;
        } else
        {
            mStoredAutorefresh = mMoPubView.getAutorefreshEnabled();
            mMoPubView.setAutorefreshEnabled(false);
            mMoPubView.adPresentedOverlay();
            return;
        }
    }

    public void onBannerFailed(MoPubErrorCode mopuberrorcode)
    {
        while (isInvalidated() || mMoPubView == null) 
        {
            return;
        }
        MoPubErrorCode mopuberrorcode1 = mopuberrorcode;
        if (mopuberrorcode == null)
        {
            mopuberrorcode1 = MoPubErrorCode.UNSPECIFIED;
        }
        cancelTimeout();
        mMoPubView.loadFailUrl(mopuberrorcode1);
    }

    public void onBannerLoaded(View view)
    {
        if (!isInvalidated())
        {
            cancelTimeout();
            if (mMoPubView != null)
            {
                mMoPubView.nativeAdLoaded();
                mMoPubView.setAdContentView(view);
                if (!(view instanceof HtmlBannerWebView))
                {
                    mMoPubView.trackNativeImpression();
                    return;
                }
            }
        }
    }

    public void onLeaveApplication()
    {
        onBannerClicked();
    }
}
