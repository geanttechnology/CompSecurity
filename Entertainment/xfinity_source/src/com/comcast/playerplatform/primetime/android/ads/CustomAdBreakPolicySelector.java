// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads;

import com.adobe.mediacore.DefaultAdPolicySelector;
import com.adobe.mediacore.MediaPlayerItem;
import com.adobe.mediacore.metadata.AdBreakAsWatched;
import com.adobe.mediacore.timeline.advertising.AdBreak;
import com.adobe.mediacore.timeline.advertising.AdBreakPlacement;
import com.adobe.mediacore.timeline.advertising.AdBreakPolicy;
import com.adobe.mediacore.timeline.advertising.AdPolicy;
import com.adobe.mediacore.timeline.advertising.AdPolicyInfo;
import com.comcast.playerplatform.primetime.android.ads.managers.BaseAdManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.comcast.playerplatform.primetime.android.ads:
//            VideoAdBreak

public class CustomAdBreakPolicySelector extends DefaultAdPolicySelector
{

    private BaseAdManager adManager;
    private boolean useResumeLogic;

    public CustomAdBreakPolicySelector(MediaPlayerItem mediaplayeritem, BaseAdManager baseadmanager, boolean flag)
    {
        super(mediaplayeritem);
        adManager = baseadmanager;
        useResumeLogic = flag;
    }

    public List selectAdBreaksToPlay(AdPolicyInfo adpolicyinfo)
    {
        List list = adpolicyinfo.getAdBreakPlacements();
        ArrayList arraylist = new ArrayList();
        AdBreakPlacement adbreakplacement = null;
        if (adManager != null && list != null)
        {
            Iterator iterator = list.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                AdBreakPlacement adbreakplacement1 = (AdBreakPlacement)iterator.next();
                if (adpolicyinfo.getSeekToTime() >= adbreakplacement1.getTime() && (adbreakplacement == null || adbreakplacement1.getTime() >= adbreakplacement.getTime()))
                {
                    adbreakplacement = adbreakplacement1;
                }
            } while (true);
            if (adbreakplacement != null && adbreakplacement.getAdBreak() != null)
            {
                AdBreak adbreak = adbreakplacement.getAdBreak();
                boolean flag = adManager.getSkipAdsOnSeek();
                if (useResumeLogic || flag)
                {
                    useResumeLogic = false;
                    adbreak.setIsWatched(Boolean.valueOf(true));
                } else
                if (!adbreak.isWatched().booleanValue() || adbreak.getTime() <= adpolicyinfo.getSeekToTime() && adbreak.getTime() + adbreak.getDuration() > adpolicyinfo.getSeekToTime())
                {
                    arraylist.add(adbreakplacement);
                    return arraylist;
                }
            }
        }
        return arraylist;
    }

    public AdBreakPolicy selectPolicyForAdBreak(AdPolicyInfo adpolicyinfo)
    {
        return AdBreakPolicy.PLAY;
    }

    public AdPolicy selectPolicyForSeekIntoAd(AdPolicyInfo adpolicyinfo)
    {
        AdBreak adbreak = ((AdBreakPlacement)adpolicyinfo.getAdBreakPlacements().get(0)).getAdBreak();
        VideoAdBreak videoadbreak;
        if (adManager != null)
        {
            videoadbreak = adManager.getCurrentAdBreak();
        } else
        {
            videoadbreak = null;
        }
        if (adbreak.isWatched().booleanValue() || videoadbreak != null && videoadbreak.getId().equals(adbreak.getTag()) && adpolicyinfo.getSeekToTime() < adpolicyinfo.getCurrentTime())
        {
            return AdPolicy.PLAY;
        } else
        {
            return AdPolicy.PLAY_FROM_AD_BREAK_BEGIN;
        }
    }

    public AdBreakAsWatched selectWatchedPolicyForAdBreak(AdPolicyInfo adpolicyinfo)
    {
        if (adManager == null)
        {
            return AdBreakAsWatched.AD_BREAK_AS_WATCHED_NEVER;
        }
        adpolicyinfo = adManager.getWatchedPolicy();
        if (adpolicyinfo != null && adpolicyinfo == PlayerAdBreakPolicies.AdBreakWatchedPolicy.MARK_AS_WATCHED)
        {
            return AdBreakAsWatched.AD_BREAK_AS_WATCHED_ON_END;
        } else
        {
            return AdBreakAsWatched.AD_BREAK_AS_WATCHED_NEVER;
        }
    }
}
