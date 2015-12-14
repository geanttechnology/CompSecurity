// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.flurry.android.ads.FlurryAdErrorType;
import com.flurry.android.ads.FlurryAdNative;
import com.flurry.android.ads.FlurryAdNativeAsset;
import com.flurry.android.ads.FlurryAdNativeListener;
import com.mopub.mobileads.FlurryAgentWrapper;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.mopub.nativeads:
//            BaseForwardingNativeAd, NativeErrorCode

public class FlurryForwardingNativeAd extends BaseForwardingNativeAd
{

    private static final int IMPRESSION_VIEW_MIN_TIME = 1000;
    private static final String kLogTag = com/mopub/nativeads/FlurryForwardingNativeAd.getSimpleName();
    FlurryAdNativeListener listener;
    private final Context mContext;
    private final CustomEventNative.CustomEventNativeListener mCustomEventNativeListener;
    private final FlurryForwardingNativeAd mFlurryForwardingNativeAd = this;
    private FlurryAdNative nativeAd;

    FlurryForwardingNativeAd(Context context, FlurryAdNative flurryadnative, CustomEventNative.CustomEventNativeListener customeventnativelistener)
    {
        listener = new FlurryAdNativeListener() {

            final FlurryForwardingNativeAd this$0;

            public void onAppExit(FlurryAdNative flurryadnative1)
            {
                String _tmp = FlurryForwardingNativeAd.kLogTag;
                (new StringBuilder("onAppExit(")).append(flurryadnative1.toString()).append(")");
            }

            public void onClicked(FlurryAdNative flurryadnative1)
            {
                String _tmp = FlurryForwardingNativeAd.kLogTag;
                (new StringBuilder("onClicked(")).append(flurryadnative1.toString()).append(") Successful.");
                notifyAdClicked();
            }

            public void onCloseFullscreen(FlurryAdNative flurryadnative1)
            {
                String _tmp = FlurryForwardingNativeAd.kLogTag;
                (new StringBuilder("onCloseFullscreen(")).append(flurryadnative1.toString()).append(")");
            }

            public void onError(FlurryAdNative flurryadnative1, FlurryAdErrorType flurryaderrortype, int i)
            {
                if (flurryaderrortype.equals(FlurryAdErrorType.FETCH))
                {
                    String _tmp = FlurryForwardingNativeAd.kLogTag;
                    (new StringBuilder("onError(")).append(flurryadnative1.toString()).append(", ").append(flurryaderrortype.toString()).append(",").append(i).append(")");
                    mFlurryForwardingNativeAd.onFetchFailed(flurryadnative1);
                }
            }

            public void onFetched(FlurryAdNative flurryadnative1)
            {
                String _tmp = FlurryForwardingNativeAd.kLogTag;
                (new StringBuilder("onFetched(")).append(flurryadnative1.toString()).append(") Successful.");
                mFlurryForwardingNativeAd.onFetched(flurryadnative1);
            }

            public void onImpressionLogged(FlurryAdNative flurryadnative1)
            {
                String _tmp = FlurryForwardingNativeAd.kLogTag;
                (new StringBuilder("onImpressionLogged(")).append(flurryadnative1.toString()).append(")  Successful.");
                notifyAdImpressed();
            }

            public void onShowFullscreen(FlurryAdNative flurryadnative1)
            {
                String _tmp = FlurryForwardingNativeAd.kLogTag;
                (new StringBuilder("onShowFullscreen(")).append(flurryadnative1.toString()).append(")");
            }

            
            {
                this$0 = FlurryForwardingNativeAd.this;
                super();
            }
        };
        mContext = context;
        nativeAd = flurryadnative;
        mCustomEventNativeListener = customeventnativelistener;
    }

    private List getImageUrls()
    {
        ArrayList arraylist = new ArrayList(2);
        if (getMainImageUrl() != null)
        {
            arraylist.add(getMainImageUrl());
        }
        if (getIconImageUrl() != null)
        {
            arraylist.add(getIconImageUrl());
        }
        return arraylist;
    }

    private void onFetchFailed(FlurryAdNative flurryadnative)
    {
        this;
        JVM INSTR monitorenter ;
        (new StringBuilder("FlurryForwardingNativeAd onFetchFailed: Native ad not available. ")).append(flurryadnative.toString());
        if (mCustomEventNativeListener != null)
        {
            mCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.NETWORK_NO_FILL);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        flurryadnative;
        throw flurryadnative;
    }

    private void onFetched(FlurryAdNative flurryadnative)
    {
        this;
        JVM INSTR monitorenter ;
        if (flurryadnative == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        (new StringBuilder("FlurryForwardingNativeAd onFetched: Native Ad fetched successfully! ")).append(flurryadnative.toString());
        setupNativeAd(flurryadnative);
        this;
        JVM INSTR monitorexit ;
        return;
        flurryadnative;
        throw flurryadnative;
    }

    private void setupNativeAd(FlurryAdNative flurryadnative)
    {
        this;
        JVM INSTR monitorenter ;
        if (flurryadnative == null) goto _L2; else goto _L1
_L1:
        FlurryAdNativeAsset flurryadnativeasset;
        nativeAd = flurryadnative;
        flurryadnative = nativeAd.getAsset("secHqImage");
        flurryadnativeasset = nativeAd.getAsset("secImage");
        if (flurryadnative == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        if (!TextUtils.isEmpty(flurryadnative.getValue()))
        {
            setMainImageUrl(flurryadnative.getValue());
        }
        if (flurryadnativeasset == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        if (!TextUtils.isEmpty(flurryadnativeasset.getValue()))
        {
            setIconImageUrl(flurryadnativeasset.getValue());
        }
        setTitle(nativeAd.getAsset("headline").getValue());
        setText(nativeAd.getAsset("summary").getValue());
        setImpressionMinTimeViewed(1000);
        setOverridingClickTracker(true);
        setOverridingImpressionTracker(true);
        if (getImageUrls() != null && !getImageUrls().isEmpty()) goto _L4; else goto _L3
_L3:
        (new StringBuilder("preCacheImages: No images to cache. Flurry Ad Native: ")).append(nativeAd.toString());
        mCustomEventNativeListener.onNativeAdLoaded(mFlurryForwardingNativeAd);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        preCacheImages(mContext, getImageUrls(), new CustomEventNative.ImageListener() {

            final FlurryForwardingNativeAd this$0;

            public void onImagesCached()
            {
                if (mCustomEventNativeListener != null)
                {
                    String _tmp = FlurryForwardingNativeAd.kLogTag;
                    mCustomEventNativeListener.onNativeAdLoaded(mFlurryForwardingNativeAd);
                    return;
                } else
                {
                    String _tmp1 = FlurryForwardingNativeAd.kLogTag;
                    return;
                }
            }

            public void onImagesFailedToCache(NativeErrorCode nativeerrorcode)
            {
                if (mCustomEventNativeListener != null)
                {
                    String _tmp = FlurryForwardingNativeAd.kLogTag;
                    (new StringBuilder("preCacheImages: Unable to cache Ad image. Error[")).append(nativeerrorcode.toString()).append("]");
                    mCustomEventNativeListener.onNativeAdFailed(nativeerrorcode);
                    return;
                } else
                {
                    String _tmp1 = FlurryForwardingNativeAd.kLogTag;
                    return;
                }
            }

            
            {
                this$0 = FlurryForwardingNativeAd.this;
                super();
            }
        });
        if (true) goto _L2; else goto _L5
_L5:
        flurryadnative;
        throw flurryadnative;
    }

    public void clear(View view)
    {
        super.clear(view);
        nativeAd.removeTrackingView();
        (new StringBuilder("clear(")).append(nativeAd.toString()).append(" ").append(view.toString()).append(")");
    }

    public void destroy()
    {
        (new StringBuilder("destroy(")).append(nativeAd.toString()).append(") started.");
        super.destroy();
        nativeAd.destroy();
        FlurryAgentWrapper.getInstance().onEndSession(mContext);
    }

    public void fetchAd()
    {
        this;
        JVM INSTR monitorenter ;
        if (mContext != null)
        {
            nativeAd.setListener(listener);
            nativeAd.fetchAd();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public volatile String getDaaIconClickthroughUrl()
    {
        return super.getDaaIconClickthroughUrl();
    }

    public volatile void handleClick(View view)
    {
        super.handleClick(view);
    }

    public void prepare(View view)
    {
        super.prepare(view);
        nativeAd.setTrackingView(view);
        (new StringBuilder("prepare(")).append(nativeAd.toString()).append(" ").append(view.toString()).append(")");
    }

    public volatile void recordImpression()
    {
        super.recordImpression();
    }






}
