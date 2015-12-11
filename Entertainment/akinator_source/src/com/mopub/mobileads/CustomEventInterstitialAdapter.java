// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import com.mopub.common.AdReport;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.factories.CustomEventInterstitialFactory;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package com.mopub.mobileads:
//            MoPubInterstitial, MoPubErrorCode, CustomEventInterstitial

public class CustomEventInterstitialAdapter
    implements CustomEventInterstitial.CustomEventInterstitialListener
{
    static interface CustomEventInterstitialAdapterListener
    {

        public abstract void onCustomEventInterstitialClicked();

        public abstract void onCustomEventInterstitialDismissed();

        public abstract void onCustomEventInterstitialFailed(MoPubErrorCode mopuberrorcode);

        public abstract void onCustomEventInterstitialLoaded();

        public abstract void onCustomEventInterstitialShown();
    }


    public static final int DEFAULT_INTERSTITIAL_TIMEOUT_DELAY = 30000;
    private Context mContext;
    private CustomEventInterstitial mCustomEventInterstitial;
    private CustomEventInterstitialAdapterListener mCustomEventInterstitialAdapterListener;
    private final Handler mHandler = new Handler();
    private boolean mInvalidated;
    private Map mLocalExtras;
    private final MoPubInterstitial mMoPubInterstitial;
    private Map mServerExtras;
    private final Runnable mTimeout = new Runnable() {

        final CustomEventInterstitialAdapter this$0;

        public void run()
        {
            MoPubLog.d("Third-party network timed out.");
            onInterstitialFailed(MoPubErrorCode.NETWORK_TIMEOUT);
            invalidate();
        }

            
            {
                this$0 = CustomEventInterstitialAdapter.this;
                super();
            }
    };

    public CustomEventInterstitialAdapter(MoPubInterstitial mopubinterstitial, String s, Map map, long l, AdReport adreport)
    {
        Preconditions.checkNotNull(map);
        mMoPubInterstitial = mopubinterstitial;
        mContext = mMoPubInterstitial.getActivity();
        MoPubLog.d((new StringBuilder()).append("Attempting to invoke custom event: ").append(s).toString());
        try
        {
            mCustomEventInterstitial = CustomEventInterstitialFactory.create(s);
        }
        // Misplaced declaration of an exception variable
        catch (MoPubInterstitial mopubinterstitial)
        {
            MoPubLog.d((new StringBuilder()).append("Couldn't locate or instantiate custom event: ").append(s).append(".").toString());
            mMoPubInterstitial.onCustomEventInterstitialFailed(MoPubErrorCode.ADAPTER_NOT_FOUND);
            return;
        }
        mServerExtras = new TreeMap(map);
        mLocalExtras = mMoPubInterstitial.getLocalExtras();
        if (mMoPubInterstitial.getLocation() != null)
        {
            mLocalExtras.put("location", mMoPubInterstitial.getLocation());
        }
        mLocalExtras.put("broadcastIdentifier", Long.valueOf(l));
        mLocalExtras.put("mopub-intent-ad-report", adreport);
    }

    private void cancelTimeout()
    {
        mHandler.removeCallbacks(mTimeout);
    }

    private int getTimeoutDelayMilliseconds()
    {
        if (mMoPubInterstitial == null || mMoPubInterstitial.getAdTimeoutDelay() == null || mMoPubInterstitial.getAdTimeoutDelay().intValue() < 0)
        {
            return 30000;
        } else
        {
            return mMoPubInterstitial.getAdTimeoutDelay().intValue() * 1000;
        }
    }

    void invalidate()
    {
        if (mCustomEventInterstitial != null)
        {
            try
            {
                mCustomEventInterstitial.onInvalidate();
            }
            catch (Exception exception)
            {
                MoPubLog.d("Invalidating a custom event interstitial threw an exception.", exception);
            }
        }
        mCustomEventInterstitial = null;
        mContext = null;
        mServerExtras = null;
        mLocalExtras = null;
        mCustomEventInterstitialAdapterListener = null;
        mInvalidated = true;
    }

    boolean isInvalidated()
    {
        return mInvalidated;
    }

    void loadInterstitial()
    {
        if (isInvalidated() || mCustomEventInterstitial == null)
        {
            return;
        }
        if (getTimeoutDelayMilliseconds() > 0)
        {
            mHandler.postDelayed(mTimeout, getTimeoutDelayMilliseconds());
        }
        try
        {
            mCustomEventInterstitial.loadInterstitial(mContext, this, mLocalExtras, mServerExtras);
            return;
        }
        catch (Exception exception)
        {
            MoPubLog.d("Loading a custom event interstitial threw an exception.", exception);
        }
        onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
    }

    public void onInterstitialClicked()
    {
        while (isInvalidated() || mCustomEventInterstitialAdapterListener == null) 
        {
            return;
        }
        mCustomEventInterstitialAdapterListener.onCustomEventInterstitialClicked();
    }

    public void onInterstitialDismissed()
    {
        while (isInvalidated() || mCustomEventInterstitialAdapterListener == null) 
        {
            return;
        }
        mCustomEventInterstitialAdapterListener.onCustomEventInterstitialDismissed();
    }

    public void onInterstitialFailed(MoPubErrorCode mopuberrorcode)
    {
        while (isInvalidated() || mCustomEventInterstitialAdapterListener == null) 
        {
            return;
        }
        MoPubErrorCode mopuberrorcode1 = mopuberrorcode;
        if (mopuberrorcode == null)
        {
            mopuberrorcode1 = MoPubErrorCode.UNSPECIFIED;
        }
        cancelTimeout();
        mCustomEventInterstitialAdapterListener.onCustomEventInterstitialFailed(mopuberrorcode1);
    }

    public void onInterstitialLoaded()
    {
        if (!isInvalidated())
        {
            cancelTimeout();
            if (mCustomEventInterstitialAdapterListener != null)
            {
                mCustomEventInterstitialAdapterListener.onCustomEventInterstitialLoaded();
                return;
            }
        }
    }

    public void onInterstitialShown()
    {
        while (isInvalidated() || mCustomEventInterstitialAdapterListener == null) 
        {
            return;
        }
        mCustomEventInterstitialAdapterListener.onCustomEventInterstitialShown();
    }

    public void onLeaveApplication()
    {
        onInterstitialClicked();
    }

    void setAdapterListener(CustomEventInterstitialAdapterListener customeventinterstitialadapterlistener)
    {
        mCustomEventInterstitialAdapterListener = customeventinterstitialadapterlistener;
    }

    void setCustomEventInterstitial(CustomEventInterstitial customeventinterstitial)
    {
        mCustomEventInterstitial = customeventinterstitial;
    }

    void showInterstitial()
    {
        if (isInvalidated() || mCustomEventInterstitial == null)
        {
            return;
        }
        try
        {
            mCustomEventInterstitial.showInterstitial();
            return;
        }
        catch (Exception exception)
        {
            MoPubLog.d("Showing a custom event interstitial threw an exception.", exception);
        }
        onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
    }
}
