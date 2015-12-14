// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import com.facebook.ads.NativeAd;
import java.util.Map;

// Referenced classes of package com.mopub.nativeads:
//            CustomEventNative, NativeErrorCode

public class FacebookNative extends CustomEventNative
{

    private static final String PLACEMENT_ID_KEY = "placement_id";

    public FacebookNative()
    {
    }

    private boolean extrasAreValid(Map map)
    {
        map = (String)map.get("placement_id");
        return map != null && map.length() > 0;
    }

    protected void loadNativeAd(Context context, CustomEventNative.CustomEventNativeListener customeventnativelistener, Map map, Map map1)
    {
        if (extrasAreValid(map1))
        {
            (new FacebookForwardingNativeAd(context, new NativeAd(context, (String)map1.get("placement_id")), customeventnativelistener)).loadAd();
            return;
        } else
        {
            customeventnativelistener.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_CONFIGURATION_ERROR);
            return;
        }
    }

    private class FacebookForwardingNativeAd extends BaseForwardingNativeAd
        implements AdListener, ImpressionListener
    {

        private static final String SOCIAL_CONTEXT_FOR_AD = "socialContextForAd";
        private final Context mContext;
        private final CustomEventNative.CustomEventNativeListener mCustomEventNativeListener;
        private final NativeAd mNativeAd;

        private Double getDoubleRating(com.facebook.ads.NativeAd.Rating rating)
        {
            if (rating == null)
            {
                return null;
            } else
            {
                return Double.valueOf((5D * rating.getValue()) / rating.getScale());
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
                ad = ad.getUrl();
            }
            setMainImageUrl(ad);
            ad = mNativeAd.getAdIcon();
            if (ad == null)
            {
                ad = obj;
            } else
            {
                ad = ad.getUrl();
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

                final FacebookForwardingNativeAd this$0;

                public void onImagesCached()
                {
                    mCustomEventNativeListener.onNativeAdLoaded(FacebookForwardingNativeAd.this);
                }

                public void onImagesFailedToCache(NativeErrorCode nativeerrorcode)
                {
                    mCustomEventNativeListener.onNativeAdFailed(nativeerrorcode);
                }

                
                {
                    this$0 = FacebookForwardingNativeAd.this;
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


        FacebookForwardingNativeAd(Context context, NativeAd nativead, CustomEventNative.CustomEventNativeListener customeventnativelistener)
        {
            mContext = context.getApplicationContext();
            mNativeAd = nativead;
            mCustomEventNativeListener = customeventnativelistener;
        }
    }

}
