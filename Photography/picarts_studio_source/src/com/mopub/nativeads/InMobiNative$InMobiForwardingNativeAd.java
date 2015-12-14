// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMNative;
import com.inmobi.monetization.IMNativeListener;
import com.mopub.common.util.Json;
import com.mopub.common.util.Numbers;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.mopub.nativeads:
//            BaseForwardingNativeAd, NativeErrorCode

class mCustomEventNativeListener extends BaseForwardingNativeAd
    implements IMNativeListener
{

    static final String CTA = "cta";
    static final String DESCRIPTION = "description";
    static final String ICON = "icon";
    static final int IMPRESSION_MIN_TIME_VIEWED = 0;
    static final String LANDING_URL = "landing_url";
    static final String RATING = "rating";
    static final String SCREENSHOTS = "screenshots";
    static final String TITLE = "title";
    static final String URL = "url";
    private final Context mContext;
    private final tener mCustomEventNativeListener;
    private IMNative mImNative;

    public void destroy()
    {
        mImNative.detachFromView();
    }

    public void handleClick(View view)
    {
        mImNative.handleClick(null);
    }

    void loadAd()
    {
        mImNative.loadAd();
    }

    public void onNativeRequestFailed(IMErrorCode imerrorcode)
    {
        if (imerrorcode == IMErrorCode.INVALID_REQUEST)
        {
            mCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.NETWORK_INVALID_REQUEST);
            return;
        }
        if (imerrorcode == IMErrorCode.INTERNAL_ERROR || imerrorcode == IMErrorCode.NETWORK_ERROR)
        {
            mCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.NETWORK_INVALID_STATE);
            return;
        }
        if (imerrorcode == IMErrorCode.NO_FILL)
        {
            mCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.NETWORK_NO_FILL);
            return;
        } else
        {
            mCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
            return;
        }
    }

    public void onNativeRequestSucceeded(IMNative imnative)
    {
        if (imnative == null)
        {
            mCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.NETWORK_INVALID_STATE);
            return;
        }
        String s;
        try
        {
            parseJson(imnative);
        }
        // Misplaced declaration of an exception variable
        catch (IMNative imnative)
        {
            mCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.INVALID_JSON);
            return;
        }
        imnative = new ArrayList();
        s = getMainImageUrl();
        if (s != null)
        {
            imnative.add(s);
        }
        s = getIconImageUrl();
        if (s != null)
        {
            imnative.add(s);
        }
        preCacheImages(mContext, imnative, new CustomEventNative.ImageListener() {

            final InMobiNative.InMobiForwardingNativeAd this$0;

            public void onImagesCached()
            {
                mCustomEventNativeListener.onNativeAdLoaded(InMobiNative.InMobiForwardingNativeAd.this);
            }

            public void onImagesFailedToCache(NativeErrorCode nativeerrorcode)
            {
                mCustomEventNativeListener.onNativeAdFailed(nativeerrorcode);
            }

            
            {
                this$0 = InMobiNative.InMobiForwardingNativeAd.this;
                super();
            }
        });
    }

    void parseJson(IMNative imnative)
    {
        imnative = new JSONObject(new JSONTokener(imnative.getContent()));
        setTitle((String)Json.getJsonValue(imnative, "title", java/lang/String));
        setText((String)Json.getJsonValue(imnative, "description", java/lang/String));
        JSONObject jsonobject = (JSONObject)Json.getJsonValue(imnative, "screenshots", org/json/JSONObject);
        if (jsonobject != null)
        {
            setMainImageUrl((String)Json.getJsonValue(jsonobject, "url", java/lang/String));
        }
        jsonobject = (JSONObject)Json.getJsonValue(imnative, "icon", org/json/JSONObject);
        if (jsonobject != null)
        {
            setIconImageUrl((String)Json.getJsonValue(jsonobject, "url", java/lang/String));
        }
        setClickDestinationUrl((String)Json.getJsonValue(imnative, "landing_url", java/lang/String));
        setCallToAction((String)Json.getJsonValue(imnative, "cta", java/lang/String));
        try
        {
            setStarRating(Numbers.parseDouble(imnative.opt("rating")));
        }
        // Misplaced declaration of an exception variable
        catch (IMNative imnative) { }
        setImpressionMinTimeViewed(0);
    }

    public void prepare(View view)
    {
        if (view != null && (view instanceof ViewGroup))
        {
            mImNative.attachToView((ViewGroup)view);
            return;
        }
        if (view != null && (view.getParent() instanceof ViewGroup))
        {
            mImNative.attachToView((ViewGroup)view.getParent());
            return;
        } else
        {
            Log.e("MoPub", "InMobi did not receive ViewGroup to attachToView, unable to record impressions");
            return;
        }
    }

    void setIMNative(IMNative imnative)
    {
        mImNative = imnative;
    }


    tener(Context context, tener tener)
    {
        mContext = context.getApplicationContext();
        mCustomEventNativeListener = tener;
    }
}
