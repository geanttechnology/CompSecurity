// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.view.View;
import com.mopub.common.logging.MoPubLog;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.mopub.nativeads:
//            BaseNativeAd, ImpressionInterface, ClickInterface

public abstract class StaticNativeAd extends BaseNativeAd
    implements ImpressionInterface, ClickInterface
{

    private static final int IMPRESSION_MIN_PERCENTAGE_VIEWED = 50;
    static final double MAX_STAR_RATING = 5D;
    static final double MIN_STAR_RATING = 0D;
    private String mCallToAction;
    private String mClickDestinationUrl;
    private final Map mExtras = new HashMap();
    private String mIconImageUrl;
    private int mImpressionMinTimeViewed;
    private boolean mImpressionRecorded;
    private String mMainImageUrl;
    private String mPrivacyInformationIconClickThroughUrl;
    private Double mStarRating;
    private String mText;
    private String mTitle;

    public StaticNativeAd()
    {
        mImpressionMinTimeViewed = 1000;
    }

    public final void addExtra(String s, Object obj)
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

    public final String getMainImageUrl()
    {
        return mMainImageUrl;
    }

    public final String getPrivacyInformationIconClickThroughUrl()
    {
        return mPrivacyInformationIconClickThroughUrl;
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

    public final boolean isImpressionRecorded()
    {
        return mImpressionRecorded;
    }

    public void prepare(View view)
    {
    }

    public void recordImpression(View view)
    {
    }

    public final void setCallToAction(String s)
    {
        mCallToAction = s;
    }

    public final void setClickDestinationUrl(String s)
    {
        mClickDestinationUrl = s;
    }

    public final void setIconImageUrl(String s)
    {
        mIconImageUrl = s;
    }

    public final void setImpressionMinTimeViewed(int i)
    {
        if (i >= 0)
        {
            mImpressionMinTimeViewed = i;
        }
    }

    public final void setImpressionRecorded()
    {
        mImpressionRecorded = true;
    }

    public final void setMainImageUrl(String s)
    {
        mMainImageUrl = s;
    }

    public final void setPrivacyInformationIconClickThroughUrl(String s)
    {
        mPrivacyInformationIconClickThroughUrl = s;
    }

    public final void setStarRating(Double double1)
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

    public final void setText(String s)
    {
        mText = s;
    }

    public final void setTitle(String s)
    {
        mTitle = s;
    }
}
