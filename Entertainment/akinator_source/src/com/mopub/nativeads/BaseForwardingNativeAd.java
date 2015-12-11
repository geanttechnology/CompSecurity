// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.mopub.common.logging.MoPubLog;
import com.mopub.network.Networking;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.mopub.nativeads:
//            NativeAdInterface, NativeErrorCode

abstract class BaseForwardingNativeAd
    implements NativeAdInterface
{
    static interface NativeEventListener
    {

        public abstract void onAdClicked();

        public abstract void onAdImpressed();
    }


    private static final int IMPRESSION_MIN_PERCENTAGE_VIEWED = 50;
    static final double MAX_STAR_RATING = 5D;
    static final double MIN_STAR_RATING = 0D;
    private String mCallToAction;
    private String mClickDestinationUrl;
    private final Map mExtras = new HashMap();
    private String mIconImageUrl;
    private int mImpressionMinTimeViewed;
    private final Set mImpressionTrackers = new HashSet();
    private boolean mIsOverridingClickTracker;
    private boolean mIsOverridingImpressionTracker;
    private String mMainImageUrl;
    private NativeEventListener mNativeEventListener;
    private Double mStarRating;
    private String mText;
    private String mTitle;

    BaseForwardingNativeAd()
    {
        mImpressionMinTimeViewed = 1000;
    }

    static void preCacheImages(Context context, List list, CustomEventNative.ImageListener imagelistener)
    {
        context = Networking.getImageLoader(context);
        Object obj = new AtomicInteger(list.size());
        AtomicBoolean atomicboolean = new AtomicBoolean(false);
        obj = new com.mopub.volley.toolbox.ImageLoader.ImageListener(((AtomicInteger) (obj)), atomicboolean, imagelistener) {

            final AtomicBoolean val$anyFailures;
            final AtomicInteger val$imageCounter;
            final CustomEventNative.ImageListener val$imageListener;

            public void onErrorResponse(VolleyError volleyerror)
            {
                MoPubLog.d("Failed to download a native ads image:", volleyerror);
                boolean flag = anyFailures.getAndSet(true);
                imageCounter.decrementAndGet();
                if (!flag)
                {
                    imageListener.onImagesFailedToCache(NativeErrorCode.IMAGE_DOWNLOAD_FAILURE);
                }
            }

            public void onResponse(com.mopub.volley.toolbox.ImageLoader.ImageContainer imagecontainer, boolean flag)
            {
                if (imagecontainer.getBitmap() != null && imageCounter.decrementAndGet() == 0 && !anyFailures.get())
                {
                    imageListener.onImagesCached();
                }
            }

            
            {
                imageCounter = atomicinteger;
                anyFailures = atomicboolean;
                imageListener = imagelistener;
                super();
            }
        };
        list = list.iterator();
        do
        {
            String s;
label0:
            {
                if (list.hasNext())
                {
                    s = (String)list.next();
                    if (!TextUtils.isEmpty(s))
                    {
                        break label0;
                    }
                    atomicboolean.set(true);
                    imagelistener.onImagesFailedToCache(NativeErrorCode.IMAGE_DOWNLOAD_FAILURE);
                }
                return;
            }
            context.get(s, ((com.mopub.volley.toolbox.ImageLoader.ImageListener) (obj)));
        } while (true);
    }

    final void addExtra(String s, Object obj)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(s, "addExtra key is not allowed to be null"))
        {
            return;
        } else
        {
            mExtras.put(s, obj);
            return;
        }
    }

    final void addImpressionTracker(String s)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(s, "impressionTracker url is not allowed to be null"))
        {
            return;
        } else
        {
            mImpressionTrackers.add(s);
            return;
        }
    }

    public void clear(View view)
    {
    }

    public void destroy()
    {
    }

    public final String getCallToAction()
    {
        return mCallToAction;
    }

    public final String getClickDestinationUrl()
    {
        return mClickDestinationUrl;
    }

    public final Object getExtra(String s)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(s, "getExtra key is not allowed to be null"))
        {
            return null;
        } else
        {
            return mExtras.get(s);
        }
    }

    public final Map getExtras()
    {
        return new HashMap(mExtras);
    }

    public final String getIconImageUrl()
    {
        return mIconImageUrl;
    }

    public final int getImpressionMinPercentageViewed()
    {
        return 50;
    }

    public final int getImpressionMinTimeViewed()
    {
        return mImpressionMinTimeViewed;
    }

    public final Set getImpressionTrackers()
    {
        return new HashSet(mImpressionTrackers);
    }

    public final String getMainImageUrl()
    {
        return mMainImageUrl;
    }

    public final Double getStarRating()
    {
        return mStarRating;
    }

    public final String getText()
    {
        return mText;
    }

    public final String getTitle()
    {
        return mTitle;
    }

    public void handleClick(View view)
    {
    }

    public final boolean isOverridingClickTracker()
    {
        return mIsOverridingClickTracker;
    }

    public final boolean isOverridingImpressionTracker()
    {
        return mIsOverridingImpressionTracker;
    }

    protected final void notifyAdClicked()
    {
        if (mNativeEventListener != null)
        {
            mNativeEventListener.onAdClicked();
        }
    }

    protected final void notifyAdImpressed()
    {
        if (mNativeEventListener != null)
        {
            mNativeEventListener.onAdImpressed();
        }
    }

    public void prepare(View view)
    {
    }

    public void recordImpression()
    {
    }

    final void setCallToAction(String s)
    {
        mCallToAction = s;
    }

    final void setClickDestinationUrl(String s)
    {
        mClickDestinationUrl = s;
    }

    final void setIconImageUrl(String s)
    {
        mIconImageUrl = s;
    }

    final void setImpressionMinTimeViewed(int i)
    {
        if (i >= 0)
        {
            mImpressionMinTimeViewed = i;
        }
    }

    final void setMainImageUrl(String s)
    {
        mMainImageUrl = s;
    }

    public final void setNativeEventListener(NativeEventListener nativeeventlistener)
    {
        mNativeEventListener = nativeeventlistener;
    }

    final void setOverridingClickTracker(boolean flag)
    {
        mIsOverridingClickTracker = flag;
    }

    final void setOverridingImpressionTracker(boolean flag)
    {
        mIsOverridingImpressionTracker = flag;
    }

    final void setStarRating(Double double1)
    {
        if (double1 == null)
        {
            mStarRating = null;
            return;
        }
        if (double1.doubleValue() >= 0.0D && double1.doubleValue() <= 5D)
        {
            mStarRating = double1;
            return;
        } else
        {
            MoPubLog.d((new StringBuilder()).append("Ignoring attempt to set invalid star rating (").append(double1).append("). Must be ").append("between ").append(0.0D).append(" and ").append(5D).append(".").toString());
            return;
        }
    }

    final void setText(String s)
    {
        mText = s;
    }

    final void setTitle(String s)
    {
        mTitle = s;
    }
}
