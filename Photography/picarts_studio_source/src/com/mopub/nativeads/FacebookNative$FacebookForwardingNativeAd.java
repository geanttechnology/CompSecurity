// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.ImpressionListener;
import com.facebook.ads.NativeAd;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.mopub.nativeads:
//            BaseForwardingNativeAd, NativeErrorCode

class mCustomEventNativeListener extends BaseForwardingNativeAd
    implements AdListener, ImpressionListener
{

    private static final String SOCIAL_CONTEXT_FOR_AD = "socialContextForAd";
    private final Context mContext;
    private final r mCustomEventNativeListener;
    private final NativeAd mNativeAd;

    private Double getDoubleRating(com.facebook.ads.Ad ad)
    {
        if (ad == null)
        {
            return null;
        } else
        {
            return Double.valueOf((5D * ad.Ad()) / ad.Ad());
        }
    }

    public void clear(View view)
    {
        mNativeAd.unregisterView();
    }

    public void destroy()
    {
        mNativeAd.destroy();
    }

    void loadAd()
    {
        mNativeAd.setAdListener(this);
        mNativeAd.setImpressionListener(this);
        mNativeAd.loadAd();
    }

    public void onAdClicked(Ad ad)
    {
        notifyAdClicked();
    }

    public void onAdLoaded(Ad ad)
    {
        Object obj = null;
        if (!mNativeAd.equals(ad) || !mNativeAd.isAdLoaded())
        {
            mCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.NETWORK_INVALID_STATE);
            return;
        }
        setTitle(mNativeAd.getAdTitle());
        setText(mNativeAd.getAdBody());
        ad = mNativeAd.getAdCoverImage();
        if (ad == null)
        {
            ad = null;
        } else
        {
            ad = ad.mNativeAd();
        }
        setMainImageUrl(ad);
        ad = mNativeAd.getAdIcon();
        if (ad == null)
        {
            ad = obj;
        } else
        {
            ad = ad.mNativeAd();
        }
        setIconImageUrl(ad);
        setCallToAction(mNativeAd.getAdCallToAction());
        setStarRating(getDoubleRating(mNativeAd.getAdStarRating()));
        addExtra("socialContextForAd", mNativeAd.getAdSocialContext());
        ad = new ArrayList();
        if (getMainImageUrl() != null)
        {
            ad.add(getMainImageUrl());
        }
        if (getIconImageUrl() != null)
        {
            ad.add(getIconImageUrl());
        }
        preCacheImages(mContext, ad, new CustomEventNative.ImageListener() {

            final FacebookNative.FacebookForwardingNativeAd this$0;

            public void onImagesCached()
            {
                mCustomEventNativeListener.onNativeAdLoaded(FacebookNative.FacebookForwardingNativeAd.this);
            }

            public void onImagesFailedToCache(NativeErrorCode nativeerrorcode)
            {
                mCustomEventNativeListener.onNativeAdFailed(nativeerrorcode);
            }

            
            {
                this$0 = FacebookNative.FacebookForwardingNativeAd.this;
                super();
            }
        });
    }

    public void onError(Ad ad, AdError aderror)
    {
        if (aderror != null)
        {
            if (aderror.getErrorCode() == AdError.NO_FILL.getErrorCode())
            {
                mCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.NETWORK_NO_FILL);
                return;
            }
            if (aderror.getErrorCode() == AdError.INTERNAL_ERROR.getErrorCode())
            {
                mCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.NETWORK_INVALID_STATE);
                return;
            }
        }
        mCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
    }

    public void onLoggingImpression(Ad ad)
    {
        notifyAdImpressed();
    }

    public void prepare(View view)
    {
        mNativeAd.registerViewForInteraction(view);
        setOverridingClickTracker(true);
        setOverridingImpressionTracker(true);
    }


    r(Context context, NativeAd nativead, r r)
    {
        mContext = context.getApplicationContext();
        mNativeAd = nativead;
        mCustomEventNativeListener = r;
    }
}
