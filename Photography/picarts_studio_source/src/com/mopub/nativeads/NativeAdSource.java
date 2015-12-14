// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.mopub.common.logging.MoPubLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.mopub.nativeads:
//            MoPubNative, TimestampWrapper, NativeResponse, RequestParameters, 
//            NativeErrorCode

class NativeAdSource
{

    private static final int CACHE_LIMIT = 3;
    private static final int DEFAULT_RETRY_TIME_MILLISECONDS = 1000;
    private static final int EXPIRATION_TIME_MILLISECONDS = 0xdbba0;
    private static final double EXPONENTIAL_BACKOFF_FACTOR = 2D;
    private static final int MAXIMUM_RETRY_TIME_MILLISECONDS = 0x493e0;
    private AdSourceListener mAdSourceListener;
    private MoPubNative mMoPubNative;
    private final MoPubNative.MoPubNativeNetworkListener mMoPubNativeNetworkListener;
    private final List mNativeAdCache;
    private final Handler mReplenishCacheHandler;
    private final Runnable mReplenishCacheRunnable;
    boolean mRequestInFlight;
    private RequestParameters mRequestParameters;
    boolean mRetryInFlight;
    int mRetryTimeMilliseconds;
    int mSequenceNumber;

    NativeAdSource()
    {
        this(((List) (new ArrayList(3))), new Handler());
    }

    NativeAdSource(List list, Handler handler)
    {
        mNativeAdCache = list;
        mReplenishCacheHandler = handler;
        mReplenishCacheRunnable = new Runnable() {

            final NativeAdSource this$0;

            public void run()
            {
                mRetryInFlight = false;
                replenishCache();
            }

            
            {
                this$0 = NativeAdSource.this;
                super();
            }
        };
        mMoPubNativeNetworkListener = new MoPubNative.MoPubNativeNetworkListener() {

            final NativeAdSource this$0;

            public void onNativeFail(NativeErrorCode nativeerrorcode)
            {
                mRequestInFlight = false;
                if (mRetryTimeMilliseconds >= 0x493e0)
                {
                    resetRetryTime();
                    return;
                } else
                {
                    updateRetryTime();
                    mRetryInFlight = true;
                    mReplenishCacheHandler.postDelayed(mReplenishCacheRunnable, mRetryTimeMilliseconds);
                    return;
                }
            }

            public void onNativeLoad(NativeResponse nativeresponse)
            {
                if (mMoPubNative == null)
                {
                    return;
                }
                mRequestInFlight = false;
                NativeAdSource nativeadsource = NativeAdSource.this;
                nativeadsource.mSequenceNumber = nativeadsource.mSequenceNumber + 1;
                resetRetryTime();
                mNativeAdCache.add(new TimestampWrapper(nativeresponse));
                if (mNativeAdCache.size() == 1 && mAdSourceListener != null)
                {
                    mAdSourceListener.onAdsAvailable();
                }
                replenishCache();
            }

            
            {
                this$0 = NativeAdSource.this;
                super();
            }

            private class AdSourceListener
            {

                public abstract void onAdsAvailable();
            }

        };
        mSequenceNumber = 0;
        mRetryTimeMilliseconds = 1000;
    }

    void clear()
    {
        if (mMoPubNative != null)
        {
            mMoPubNative.destroy();
            mMoPubNative = null;
        }
        mRequestParameters = null;
        for (Iterator iterator = mNativeAdCache.iterator(); iterator.hasNext(); ((NativeResponse)((TimestampWrapper)iterator.next()).mInstance).destroy()) { }
        mNativeAdCache.clear();
        mReplenishCacheHandler.removeMessages(0);
        mRequestInFlight = false;
        mSequenceNumber = 0;
        resetRetryTime();
    }

    NativeResponse dequeueAd()
    {
        long l = SystemClock.uptimeMillis();
        if (!mRequestInFlight && !mRetryInFlight)
        {
            mReplenishCacheHandler.post(mReplenishCacheRunnable);
        }
        while (!mNativeAdCache.isEmpty()) 
        {
            TimestampWrapper timestampwrapper = (TimestampWrapper)mNativeAdCache.remove(0);
            if (l - timestampwrapper.mCreatedTimestamp < 0xdbba0L)
            {
                return (NativeResponse)timestampwrapper.mInstance;
            }
        }
        return null;
    }

    MoPubNative.MoPubNativeNetworkListener getMoPubNativeNetworkListener()
    {
        return mMoPubNativeNetworkListener;
    }

    void loadAds(Context context, String s, RequestParameters requestparameters)
    {
        loadAds(requestparameters, new MoPubNative(context, s, mMoPubNativeNetworkListener));
    }

    void loadAds(RequestParameters requestparameters, MoPubNative mopubnative)
    {
        clear();
        mRequestParameters = requestparameters;
        mMoPubNative = mopubnative;
        replenishCache();
    }

    void replenishCache()
    {
        if (!mRequestInFlight && mMoPubNative != null && mNativeAdCache.size() < 3)
        {
            mRequestInFlight = true;
            MoPubLog.d("make request get called");
            mMoPubNative.makeRequest(mRequestParameters, Integer.valueOf(mSequenceNumber));
            return;
        } else
        {
            MoPubLog.d("NOT make request get called");
            return;
        }
    }

    void resetRetryTime()
    {
        mRetryTimeMilliseconds = 1000;
    }

    void setAdSourceListener(AdSourceListener adsourcelistener)
    {
        mAdSourceListener = adsourcelistener;
    }

    void setMoPubNative(MoPubNative mopubnative)
    {
        mMoPubNative = mopubnative;
    }

    void updateRetryTime()
    {
        mRetryTimeMilliseconds = (int)((double)mRetryTimeMilliseconds * 2D);
        if (mRetryTimeMilliseconds > 0x493e0)
        {
            mRetryTimeMilliseconds = 0x493e0;
        }
    }





}
