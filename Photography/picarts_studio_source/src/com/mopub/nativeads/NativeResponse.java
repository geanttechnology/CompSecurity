// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.network.Networking;
import com.mopub.network.TrackingRequest;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.mopub.nativeads:
//            NativeAdInterface, SpinningProgressView, MoPubNative

public class NativeResponse
{

    private final String mAdUnitId;
    private final Context mContext;
    private final ImageLoader mImageLoader;
    private boolean mIsClicked;
    private boolean mIsDestroyed;
    private final String mMoPubClickTracker;
    private final Set mMoPubImpressionTrackers = new HashSet();
    private MoPubNative.MoPubNativeEventListener mMoPubNativeEventListener;
    private final NativeAdInterface mNativeAd;
    private boolean mRecordedImpression;

    public NativeResponse(Context context, String s, String s1, String s2, NativeAdInterface nativeadinterface, MoPubNative.MoPubNativeEventListener mopubnativeeventlistener)
    {
        mContext = context.getApplicationContext();
        mAdUnitId = s2;
        mMoPubNativeEventListener = mopubnativeeventlistener;
        mNativeAd = nativeadinterface;
        mNativeAd.setNativeEventListener(new BaseForwardingNativeAd.NativeEventListener() {

            final NativeResponse this$0;

            public void onAdClicked()
            {
                handleClick(null);
            }

            public void onAdImpressed()
            {
                recordImpression(null);
            }

            
            {
                this$0 = NativeResponse.this;
                super();
            }
        });
        mMoPubImpressionTrackers.add(s);
        mMoPubClickTracker = s1;
        mImageLoader = Networking.getImageLoader(context);
    }

    private void loadImageView(String s, final ImageView imageView)
    {
        if (imageView == null)
        {
            return;
        }
        if (s == null)
        {
            imageView.setImageDrawable(null);
            return;
        } else
        {
            mImageLoader.get(s, new com.mopub.volley.toolbox.ImageLoader.ImageListener() {

                final NativeResponse this$0;
                final ImageView val$imageView;

                public void onErrorResponse(VolleyError volleyerror)
                {
                    MoPubLog.d("Failed to load image.", volleyerror);
                    imageView.setImageDrawable(null);
                }

                public void onResponse(com.mopub.volley.toolbox.ImageLoader.ImageContainer imagecontainer, boolean flag)
                {
                    if (!flag)
                    {
                        MoPubLog.d("Image was not loaded immediately into your ad view. You should call preCacheImages as part of your custom event loading process.");
                    }
                    imageView.setImageBitmap(imagecontainer.getBitmap());
                }

            
            {
                this$0 = NativeResponse.this;
                imageView = imageview;
                super();
            }
            });
            return;
        }
    }

    private void openClickDestinationUrl(final View view, final SpinningProgressView spinningProgressView)
    {
        Preconditions.checkNotNull(spinningProgressView);
        if (getClickDestinationUrl() == null)
        {
            return;
        }
        if (view != null)
        {
            spinningProgressView.addToRoot(view);
        }
        (new com.mopub.common.UrlHandler.Builder()).withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, new UrlAction[] {
            UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK
        }).withResultActions(new com.mopub.common.UrlHandler.ResultActions() {

            final NativeResponse this$0;
            final SpinningProgressView val$spinningProgressView;
            final View val$view;

            private void removeSpinningProgressView()
            {
                if (view != null)
                {
                    spinningProgressView.removeFromRoot();
                }
            }

            public void urlHandlingFailed(String s, UrlAction urlaction)
            {
                removeSpinningProgressView();
            }

            public void urlHandlingSucceeded(String s, UrlAction urlaction)
            {
                removeSpinningProgressView();
            }

            
            {
                this$0 = NativeResponse.this;
                view = view1;
                spinningProgressView = spinningprogressview;
                super();
            }
        }).build().handleUrl(mContext, getClickDestinationUrl());
    }

    private void setOnClickListener(View view, android.view.View.OnClickListener onclicklistener)
    {
        view.setOnClickListener(onclicklistener);
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            for (int i = 0; i < view.getChildCount(); i++)
            {
                setOnClickListener(view.getChildAt(i), onclicklistener);
            }

        }
    }

    public void clear(View view)
    {
        setOnClickListener(view, null);
        mNativeAd.clear(view);
    }

    public void destroy()
    {
        if (isDestroyed())
        {
            return;
        } else
        {
            mMoPubNativeEventListener = MoPubNative.EMPTY_EVENT_LISTENER;
            mNativeAd.destroy();
            mIsDestroyed = true;
            return;
        }
    }

    public String getAdUnitId()
    {
        return mAdUnitId;
    }

    public String getCallToAction()
    {
        return mNativeAd.getCallToAction();
    }

    public String getClickDestinationUrl()
    {
        return mNativeAd.getClickDestinationUrl();
    }

    public String getClickTracker()
    {
        return mMoPubClickTracker;
    }

    public String getDaaIconClickthroughUrl()
    {
        return mNativeAd.getDaaIconClickthroughUrl();
    }

    public Object getExtra(String s)
    {
        return mNativeAd.getExtra(s);
    }

    public Map getExtras()
    {
        return mNativeAd.getExtras();
    }

    public String getIconImageUrl()
    {
        return mNativeAd.getIconImageUrl();
    }

    public int getImpressionMinPercentageViewed()
    {
        return mNativeAd.getImpressionMinPercentageViewed();
    }

    public int getImpressionMinTimeViewed()
    {
        return mNativeAd.getImpressionMinTimeViewed();
    }

    public List getImpressionTrackers()
    {
        HashSet hashset = new HashSet();
        hashset.addAll(mMoPubImpressionTrackers);
        hashset.addAll(mNativeAd.getImpressionTrackers());
        return new ArrayList(hashset);
    }

    public String getMainImageUrl()
    {
        return mNativeAd.getMainImageUrl();
    }

    MoPubNative.MoPubNativeEventListener getMoPubNativeEventListener()
    {
        return mMoPubNativeEventListener;
    }

    public boolean getRecordedImpression()
    {
        return mRecordedImpression;
    }

    public Double getStarRating()
    {
        return mNativeAd.getStarRating();
    }

    public String getSubtitle()
    {
        return mNativeAd.getText();
    }

    public String getText()
    {
        return mNativeAd.getText();
    }

    public String getTitle()
    {
        return mNativeAd.getTitle();
    }

    public void handleClick(View view)
    {
        handleClick(view, new SpinningProgressView(mContext));
    }

    void handleClick(View view, SpinningProgressView spinningprogressview)
    {
        Preconditions.checkNotNull(spinningprogressview);
        if (isDestroyed())
        {
            return;
        }
        if (!isClicked())
        {
            TrackingRequest.makeTrackingHttpRequest(mMoPubClickTracker, mContext, com.mopub.common.event.BaseEvent.Name.CLICK_REQUEST);
        }
        openClickDestinationUrl(view, spinningprogressview);
        mNativeAd.handleClick(view);
        mIsClicked = true;
        mMoPubNativeEventListener.onNativeClick(view);
    }

    public boolean isClicked()
    {
        return mIsClicked;
    }

    public boolean isDestroyed()
    {
        return mIsDestroyed;
    }

    public boolean isOverridingClickTracker()
    {
        return mNativeAd.isOverridingClickTracker();
    }

    public boolean isOverridingImpressionTracker()
    {
        return mNativeAd.isOverridingImpressionTracker();
    }

    public void loadExtrasImage(String s, ImageView imageview)
    {
        s = ((String) (getExtra(s)));
        if (s != null && (s instanceof String))
        {
            loadImageView((String)s, imageview);
        }
    }

    public void loadIconImage(ImageView imageview)
    {
        loadImageView(getIconImageUrl(), imageview);
    }

    public void loadMainImage(ImageView imageview)
    {
        loadImageView(getMainImageUrl(), imageview);
    }

    public void prepare(View view)
    {
        if (isDestroyed())
        {
            return;
        }
        if (!isOverridingClickTracker())
        {
            setOnClickListener(view, new NativeViewClickListener());
        }
        mNativeAd.prepare(view);
    }

    public void recordImpression(View view)
    {
        if (getRecordedImpression() || isDestroyed())
        {
            return;
        }
        for (Iterator iterator = getImpressionTrackers().iterator(); iterator.hasNext(); TrackingRequest.makeTrackingHttpRequest((String)iterator.next(), mContext, com.mopub.common.event.BaseEvent.Name.IMPRESSION_REQUEST)) { }
        mNativeAd.recordImpression();
        mRecordedImpression = true;
        mMoPubNativeEventListener.onNativeImpression(view);
    }

    void setRecordedImpression(boolean flag)
    {
        mRecordedImpression = flag;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("\n");
        stringbuilder.append(Parameter.TITLE.name).append(":").append(getTitle()).append("\n");
        stringbuilder.append(Parameter.TEXT.name).append(":").append(getText()).append("\n");
        stringbuilder.append(Parameter.ICON_IMAGE.name).append(":").append(getIconImageUrl()).append("\n");
        stringbuilder.append(Parameter.MAIN_IMAGE.name).append(":").append(getMainImageUrl()).append("\n");
        stringbuilder.append(Parameter.STAR_RATING.name).append(":").append(getStarRating()).append("\n");
        stringbuilder.append(Parameter.IMPRESSION_TRACKER.name).append(":").append(getImpressionTrackers()).append("\n");
        stringbuilder.append(Parameter.CLICK_TRACKER.name).append(":").append(mMoPubClickTracker).append("\n");
        stringbuilder.append(Parameter.CLICK_DESTINATION.name).append(":").append(getClickDestinationUrl()).append("\n");
        stringbuilder.append(Parameter.CALL_TO_ACTION.name).append(":").append(getCallToAction()).append("\n");
        stringbuilder.append("recordedImpression:").append(mRecordedImpression).append("\n");
        stringbuilder.append("extras:").append(getExtras());
        return stringbuilder.toString();
    }

    private class NativeViewClickListener
        implements android.view.View.OnClickListener
    {

        final NativeResponse this$0;

        public void onClick(View view)
        {
            handleClick(view);
        }

        NativeViewClickListener()
        {
            this$0 = NativeResponse.this;
            super();
        }
    }


    private class Parameter extends Enum
    {

        private static final Parameter $VALUES[];
        public static final Parameter CALL_TO_ACTION;
        public static final Parameter CLICK_DESTINATION;
        public static final Parameter CLICK_TRACKER;
        public static final Parameter FALLBACK;
        public static final Parameter ICON_IMAGE;
        public static final Parameter IMPRESSION_TRACKER;
        public static final Parameter MAIN_IMAGE;
        public static final Parameter STAR_RATING;
        public static final Parameter TEXT;
        public static final Parameter TITLE;
        static final Set requiredKeys;
        final String name;
        final boolean required;

        static Parameter from(String s)
        {
            Parameter aparameter[] = values();
            int j = aparameter.length;
            for (int i = 0; i < j; i++)
            {
                Parameter parameter = aparameter[i];
                if (parameter.name.equals(s))
                {
                    return parameter;
                }
            }

            return null;
        }

        public static Parameter valueOf(String s)
        {
            return (Parameter)Enum.valueOf(com/mopub/nativeads/NativeResponse$Parameter, s);
        }

        public static Parameter[] values()
        {
            return (Parameter[])$VALUES.clone();
        }

        static 
        {
            int i = 0;
            IMPRESSION_TRACKER = new Parameter("IMPRESSION_TRACKER", 0, "imptracker", true);
            CLICK_TRACKER = new Parameter("CLICK_TRACKER", 1, "clktracker", true);
            TITLE = new Parameter("TITLE", 2, "title", false);
            TEXT = new Parameter("TEXT", 3, "text", false);
            MAIN_IMAGE = new Parameter("MAIN_IMAGE", 4, "mainimage", false);
            ICON_IMAGE = new Parameter("ICON_IMAGE", 5, "iconimage", false);
            CLICK_DESTINATION = new Parameter("CLICK_DESTINATION", 6, "clk", false);
            FALLBACK = new Parameter("FALLBACK", 7, "fallback", false);
            CALL_TO_ACTION = new Parameter("CALL_TO_ACTION", 8, "ctatext", false);
            STAR_RATING = new Parameter("STAR_RATING", 9, "starrating", false);
            $VALUES = (new Parameter[] {
                IMPRESSION_TRACKER, CLICK_TRACKER, TITLE, TEXT, MAIN_IMAGE, ICON_IMAGE, CLICK_DESTINATION, FALLBACK, CALL_TO_ACTION, STAR_RATING
            });
            requiredKeys = new HashSet();
            Parameter aparameter[] = values();
            for (int j = aparameter.length; i < j; i++)
            {
                Parameter parameter = aparameter[i];
                if (parameter.required)
                {
                    requiredKeys.add(parameter.name);
                }
            }

        }

        private Parameter(String s, int i, String s1, boolean flag)
        {
            super(s, i);
            name = s1;
            required = flag;
        }
    }

}
