// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.common.util.Strings;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.mopub.mobileads:
//            VastAbsoluteProgressTracker, VastFractionalProgressTracker, VastCompanionAdConfig, VastIconConfig, 
//            VastErrorCode

public class VastVideoConfig
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private final ArrayList mAbsoluteTrackers = new ArrayList();
    private String mClickThroughUrl;
    private final ArrayList mClickTrackers = new ArrayList();
    private final ArrayList mCloseTrackers = new ArrayList();
    private final ArrayList mCompleteTrackers = new ArrayList();
    private String mCustomCloseIconUrl;
    private String mCustomCtaText;
    private com.mopub.common.util.DeviceUtils.ForceOrientation mCustomForceOrientation;
    private String mCustomSkipText;
    private String mDiskMediaFileUrl;
    private final ArrayList mErrorTrackers = new ArrayList();
    private final ArrayList mFractionalTrackers = new ArrayList();
    private final ArrayList mImpressionTrackers = new ArrayList();
    private boolean mIsForceOrientationSet;
    private VastCompanionAdConfig mLandscapeVastCompanionAdConfig;
    private String mNetworkMediaFileUrl;
    private final ArrayList mPauseTrackers = new ArrayList();
    private VastCompanionAdConfig mPortraitVastCompanionAdConfig;
    private final ArrayList mResumeTrackers = new ArrayList();
    private String mSkipOffset;
    private final ArrayList mSkipTrackers = new ArrayList();
    private VastIconConfig mVastIconConfig;

    public VastVideoConfig()
    {
        mCustomForceOrientation = com.mopub.common.util.DeviceUtils.ForceOrientation.FORCE_LANDSCAPE;
    }

    public void addAbsoluteTrackers(List list)
    {
        Preconditions.checkNotNull(list, "absoluteTrackers cannot be null");
        mAbsoluteTrackers.addAll(list);
        Collections.sort(mAbsoluteTrackers);
    }

    public void addClickTrackers(List list)
    {
        Preconditions.checkNotNull(list, "clickTrackers cannot be null");
        mClickTrackers.addAll(list);
    }

    public void addCloseTrackers(List list)
    {
        Preconditions.checkNotNull(list, "closeTrackers cannot be null");
        mCloseTrackers.addAll(list);
    }

    public void addCompleteTrackers(List list)
    {
        Preconditions.checkNotNull(list, "completeTrackers cannot be null");
        mCompleteTrackers.addAll(list);
    }

    public void addErrorTrackers(List list)
    {
        Preconditions.checkNotNull(list, "errorTrackers cannot be null");
        mErrorTrackers.addAll(list);
    }

    public void addFractionalTrackers(List list)
    {
        Preconditions.checkNotNull(list, "fractionalTrackers cannot be null");
        mFractionalTrackers.addAll(list);
        Collections.sort(mFractionalTrackers);
    }

    public void addImpressionTrackers(List list)
    {
        Preconditions.checkNotNull(list, "impressionTrackers cannot be null");
        mImpressionTrackers.addAll(list);
    }

    public void addPauseTrackers(List list)
    {
        Preconditions.checkNotNull(list, "pauseTrackers cannot be null");
        mPauseTrackers.addAll(list);
    }

    public void addResumeTrackers(List list)
    {
        Preconditions.checkNotNull(list, "resumeTrackers cannot be null");
        mResumeTrackers.addAll(list);
    }

    public void addSkipTrackers(List list)
    {
        Preconditions.checkNotNull(list, "skipTrackers cannot be null");
        mSkipTrackers.addAll(list);
    }

    public ArrayList getAbsoluteTrackers()
    {
        return mAbsoluteTrackers;
    }

    public String getClickThroughUrl()
    {
        return mClickThroughUrl;
    }

    public List getClickTrackers()
    {
        return mClickTrackers;
    }

    public List getCloseTrackers()
    {
        return mCloseTrackers;
    }

    public List getCompleteTrackers()
    {
        return mCompleteTrackers;
    }

    public String getCustomCloseIconUrl()
    {
        return mCustomCloseIconUrl;
    }

    public String getCustomCtaText()
    {
        return mCustomCtaText;
    }

    public com.mopub.common.util.DeviceUtils.ForceOrientation getCustomForceOrientation()
    {
        return mCustomForceOrientation;
    }

    public String getCustomSkipText()
    {
        return mCustomSkipText;
    }

    public String getDiskMediaFileUrl()
    {
        return mDiskMediaFileUrl;
    }

    public List getErrorTrackers()
    {
        return mErrorTrackers;
    }

    public ArrayList getFractionalTrackers()
    {
        return mFractionalTrackers;
    }

    public List getImpressionTrackers()
    {
        return mImpressionTrackers;
    }

    public String getNetworkMediaFileUrl()
    {
        return mNetworkMediaFileUrl;
    }

    public List getPauseTrackers()
    {
        return mPauseTrackers;
    }

    public int getRemainingProgressTrackerCount()
    {
        return getUntriggeredTrackersBefore(0x7fffffff, 0x7fffffff).size();
    }

    public List getResumeTrackers()
    {
        return mResumeTrackers;
    }

    public Integer getSkipOffsetMillis(int i)
    {
        if (mSkipOffset == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        Integer integer;
        if (!Strings.isAbsoluteTracker(mSkipOffset))
        {
            break MISSING_BLOCK_LABEL_39;
        }
        integer = Strings.parseAbsoluteOffset(mSkipOffset);
        if (integer == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        if (integer.intValue() < i)
        {
            return integer;
        }
        break MISSING_BLOCK_LABEL_107;
        int j;
        if (!Strings.isPercentageTracker(mSkipOffset))
        {
            break MISSING_BLOCK_LABEL_88;
        }
        float f = Float.parseFloat(mSkipOffset.replace("%", "")) / 100F;
        j = Math.round((float)i * f);
        if (j >= i)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        return Integer.valueOf(j);
        MoPubLog.d(String.format("Invalid VAST skipoffset format: %s", new Object[] {
            mSkipOffset
        }));
_L2:
        return null;
        NumberFormatException numberformatexception;
        numberformatexception;
        MoPubLog.d(String.format("Failed to parse skipoffset %s", new Object[] {
            mSkipOffset
        }));
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String getSkipOffsetString()
    {
        return mSkipOffset;
    }

    public List getSkipTrackers()
    {
        return mSkipTrackers;
    }

    public List getUntriggeredTrackersBefore(int i, int j)
    {
        float f;
        ArrayList arraylist;
        Object obj;
        Object obj1;
        boolean flag;
        if (j > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (com.mopub.common.Preconditions.NoThrow.checkArgument(flag))
        {
            f = (float)i / (float)j;
            arraylist = new ArrayList();
            obj = new VastAbsoluteProgressTracker("", i);
            j = mAbsoluteTrackers.size();
            i = 0;
        } else
        {
            return Collections.emptyList();
        }
        if (i >= j) goto _L2; else goto _L1
_L1:
        obj1 = (VastAbsoluteProgressTracker)mAbsoluteTrackers.get(i);
        if (((VastAbsoluteProgressTracker) (obj1)).compareTo(((VastAbsoluteProgressTracker) (obj))) <= 0) goto _L3; else goto _L2
_L2:
        obj = new VastFractionalProgressTracker("", f);
        j = mFractionalTrackers.size();
        i = 0;
_L5:
        if (i < j)
        {
            obj1 = (VastFractionalProgressTracker)mFractionalTrackers.get(i);
            if (((VastFractionalProgressTracker) (obj1)).compareTo(((VastFractionalProgressTracker) (obj))) <= 0)
            {
                break MISSING_BLOCK_LABEL_164;
            }
        }
        return arraylist;
_L3:
        if (!((VastAbsoluteProgressTracker) (obj1)).isTracked())
        {
            arraylist.add(obj1);
        }
        i++;
        break MISSING_BLOCK_LABEL_52;
        if (!((VastFractionalProgressTracker) (obj1)).isTracked())
        {
            arraylist.add(obj1);
        }
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public VastCompanionAdConfig getVastCompanionAd(int i)
    {
        switch (i)
        {
        default:
            return mLandscapeVastCompanionAdConfig;

        case 1: // '\001'
            return mPortraitVastCompanionAdConfig;

        case 2: // '\002'
            return mLandscapeVastCompanionAdConfig;
        }
    }

    public VastIconConfig getVastIconConfig()
    {
        return mVastIconConfig;
    }

    public void handleClick(final Activity activity, int i, final int requestCode)
    {
        Preconditions.checkNotNull(activity, "activity cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(mClickTrackers, null, Integer.valueOf(i), mNetworkMediaFileUrl, activity);
        if (TextUtils.isEmpty(mClickThroughUrl))
        {
            return;
        } else
        {
            (new com.mopub.common.UrlHandler.Builder()).withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, new UrlAction[] {
                UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK
            }).withResultActions(new com.mopub.common.UrlHandler.ResultActions() {

                final VastVideoConfig this$0;
                final Activity val$activity;
                final int val$requestCode;

                public void urlHandlingFailed(String s, UrlAction urlaction)
                {
                }

                public void urlHandlingSucceeded(String s, UrlAction urlaction)
                {
                    if (urlaction != UrlAction.OPEN_IN_APP_BROWSER)
                    {
                        break MISSING_BLOCK_LABEL_45;
                    }
                    urlaction = new Bundle();
                    urlaction.putString("URL", s);
                    s = Intents.getStartActivityIntent(activity, com/mopub/common/MoPubBrowser, urlaction);
                    activity.startActivityForResult(s, requestCode);
                    return;
                    s;
                    MoPubLog.d((new StringBuilder()).append("Activity ").append(com/mopub/common/MoPubBrowser.getName()).append(" not found. Did you ").append("declare it in your AndroidManifest.xml?").toString());
                    return;
                }

            
            {
                this$0 = VastVideoConfig.this;
                activity = activity1;
                requestCode = i;
                super();
            }
            }).withoutMoPubBrowser().build().handleUrl(activity, mClickThroughUrl);
            return;
        }
    }

    public void handleClose(Context context, int i)
    {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(mCloseTrackers, null, Integer.valueOf(i), mNetworkMediaFileUrl, context);
        TrackingRequest.makeVastTrackingHttpRequest(mSkipTrackers, null, Integer.valueOf(i), mNetworkMediaFileUrl, context);
    }

    public void handleComplete(Context context, int i)
    {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(mCompleteTrackers, null, Integer.valueOf(i), mNetworkMediaFileUrl, context);
    }

    public void handleError(Context context, VastErrorCode vasterrorcode, int i)
    {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(mErrorTrackers, vasterrorcode, Integer.valueOf(i), mNetworkMediaFileUrl, context);
    }

    public void handleImpression(Context context, int i)
    {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(mImpressionTrackers, null, Integer.valueOf(i), mNetworkMediaFileUrl, context);
    }

    public void handlePause(Context context, int i)
    {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(mPauseTrackers, null, Integer.valueOf(i), mNetworkMediaFileUrl, context);
    }

    public void handleResume(Context context, int i)
    {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(mResumeTrackers, null, Integer.valueOf(i), mNetworkMediaFileUrl, context);
    }

    public boolean hasCompanionAd()
    {
        return mLandscapeVastCompanionAdConfig != null && mPortraitVastCompanionAdConfig != null;
    }

    public boolean isCustomForceOrientationSet()
    {
        return mIsForceOrientationSet;
    }

    public void setClickThroughUrl(String s)
    {
        mClickThroughUrl = s;
    }

    public void setCustomCloseIconUrl(String s)
    {
        if (s != null)
        {
            mCustomCloseIconUrl = s;
        }
    }

    public void setCustomCtaText(String s)
    {
        if (s != null)
        {
            mCustomCtaText = s;
        }
    }

    public void setCustomForceOrientation(com.mopub.common.util.DeviceUtils.ForceOrientation forceorientation)
    {
        if (forceorientation != null && forceorientation != com.mopub.common.util.DeviceUtils.ForceOrientation.UNDEFINED)
        {
            mCustomForceOrientation = forceorientation;
            mIsForceOrientationSet = true;
        }
    }

    public void setCustomSkipText(String s)
    {
        if (s != null)
        {
            mCustomSkipText = s;
        }
    }

    public void setDiskMediaFileUrl(String s)
    {
        mDiskMediaFileUrl = s;
    }

    public void setNetworkMediaFileUrl(String s)
    {
        mNetworkMediaFileUrl = s;
    }

    public void setSkipOffset(String s)
    {
        if (s != null)
        {
            mSkipOffset = s;
        }
    }

    public void setVastCompanionAd(VastCompanionAdConfig vastcompanionadconfig, VastCompanionAdConfig vastcompanionadconfig1)
    {
        mLandscapeVastCompanionAdConfig = vastcompanionadconfig;
        mPortraitVastCompanionAdConfig = vastcompanionadconfig1;
    }

    public void setVastIconConfig(VastIconConfig vasticonconfig)
    {
        mVastIconConfig = vasticonconfig;
    }
}
