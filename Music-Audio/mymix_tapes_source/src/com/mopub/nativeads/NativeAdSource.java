// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.mopub.nativeads:
//            AdRendererRegistry, MoPubNative, TimestampWrapper, NativeAd, 
//            MoPubAdRenderer, RequestParameters, NativeErrorCode

class NativeAdSource
{
    static interface AdSourceListener
    {

        public abstract void onAdsAvailable();
    }


    private static final int CACHE_LIMIT = 1;
    private static final int EXPIRATION_TIME_MILLISECONDS = 0xdbba0;
    private static final int MAXIMUM_RETRY_TIME_MILLISECONDS = 0x493e0;
    static final int RETRY_TIME_ARRAY_MILLISECONDS[] = {
        1000, 3000, 5000, 25000, 60000, 0x493e0
    };
    private final AdRendererRegistry mAdRendererRegistry;
    private AdSourceListener mAdSourceListener;
    int mCurrentRetries;
    private MoPubNative mMoPubNative;
    private final MoPubNative.MoPubNativeNetworkListener mMoPubNativeNetworkListener;
    private final List mNativeAdCache;
    private final Handler mReplenishCacheHandler;
    private final Runnable mReplenishCacheRunnable;
    boolean mRequestInFlight;
    private RequestParameters mRequestParameters;
    boolean mRetryInFlight;
    int mSequenceNumber;

    NativeAdSource()
    {
        this(((List) (new ArrayList(1))), new Handler(), new AdRendererRegistry());
    }

    NativeAdSource(List list, Handler handler, AdRendererRegistry adrendererregistry)
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
        mAdRendererRegistry = adrendererregistry;
        mMoPubNativeNetworkListener = new MoPubNative.MoPubNativeNetworkListener() {

            final NativeAdSource this$0;

            public void onNativeFail(NativeErrorCode nativeerrorcode)
            {
                mRequestInFlight = false;
                if (mCurrentRetries >= NativeAdSource.RETRY_TIME_ARRAY_MILLISECONDS.length - 1)
                {
                    resetRetryTime();
                    return;
                } else
                {
                    updateRetryTime();
                    mRetryInFlight = true;
                    mReplenishCacheHandler.postDelayed(mReplenishCacheRunnable, getRetryTime());
                    return;
                }
            }

            public void onNativeLoad(NativeAd nativead)
            {
                if (mMoPubNative == null)
                {
                    return;
                }
                mRequestInFlight = false;
                NativeAdSource nativeadsource = NativeAdSource.this;
                nativeadsource.mSequenceNumber = nativeadsource.mSequenceNumber + 1;
                resetRetryTime();
                mNativeAdCache.add(new TimestampWrapper(nativead));
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
        };
        mSequenceNumber = 0;
        resetRetryTime();
    }

    void clear()
    {
        if (mMoPubNative != null)
        {
            mMoPubNative.destroy();
            mMoPubNative = null;
        }
        mRequestParameters = null;
        for (Iterator iterator = mNativeAdCache.iterator(); iterator.hasNext(); ((NativeAd)((TimestampWrapper)iterator.next()).mInstance).destroy()) { }
        mNativeAdCache.clear();
        mReplenishCacheHandler.removeMessages(0);
        mRequestInFlight = false;
        mSequenceNumber = 0;
        resetRetryTime();
    }

    NativeAd dequeueAd()
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
                return (NativeAd)timestampwrapper.mInstance;
            }
        }
        return null;
    }

    int getAdRendererCount()
    {
        return mAdRendererRegistry.getAdRendererCount();
    }

    public MoPubAdRenderer getAdRendererForViewType(int i)
    {
        return mAdRendererRegistry.getRendererForViewType(i);
    }

    MoPubNative.MoPubNativeNetworkListener getMoPubNativeNetworkListener()
    {
        return mMoPubNativeNetworkListener;
    }

    int getRetryTime()
    {
        if (mCurrentRetries >= RETRY_TIME_ARRAY_MILLISECONDS.length)
        {
            mCurrentRetries = RETRY_TIME_ARRAY_MILLISECONDS.length - 1;
        }
        return RETRY_TIME_ARRAY_MILLISECONDS[mCurrentRetries];
    }

    public int getViewTypeForAd(NativeAd nativead)
    {
        return mAdRendererRegistry.getViewTypeForAd(nativead);
    }

    void loadAds(Context context, String s, RequestParameters requestparameters)
    {
        loadAds(requestparameters, new MoPubNative(context, s, mMoPubNativeNetworkListener));
    }

    void loadAds(RequestParameters requestparameters, MoPubNative mopubnative)
    {
        clear();
        for (Iterator iterator = mAdRendererRegistry.getRendererIterable().iterator(); iterator.hasNext(); mopubnative.registerAdRenderer((MoPubAdRenderer)iterator.next())) { }
        mRequestParameters = requestparameters;
        mMoPubNative = mopubnative;
        replenishCache();
    }

    void registerAdRenderer(MoPubAdRenderer mopubadrenderer)
    {
        mAdRendererRegistry.registerAdRenderer(mopubadrenderer);
        if (mMoPubNative != null)
        {
            mMoPubNative.registerAdRenderer(mopubadrenderer);
        }
    }

    void replenishCache()
    {
        if (!mRequestInFlight && mMoPubNative != null && mNativeAdCache.size() < 1)
        {
            mRequestInFlight = true;
            mMoPubNative.makeRequest(mRequestParameters, Integer.valueOf(mSequenceNumber));
        }
    }

    void resetRetryTime()
    {
        mCurrentRetries = 0;
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
        if (mCurrentRetries < RETRY_TIME_ARRAY_MILLISECONDS.length - 1)
        {
            mCurrentRetries = mCurrentRetries + 1;
        }
    }






}
