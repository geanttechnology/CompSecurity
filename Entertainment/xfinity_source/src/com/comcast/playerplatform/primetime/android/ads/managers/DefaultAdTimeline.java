// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads.managers;

import com.adobe.mediacore.timeline.advertising.Ad;
import com.adobe.mediacore.timeline.advertising.AdAsset;
import com.adobe.mediacore.timeline.advertising.AdBreak;
import com.adobe.mediacore.timeline.advertising.AdClick;
import com.comcast.playerplatform.primetime.android.ads.AdRestriction;
import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import com.comcast.playerplatform.primetime.android.primetime.PlayerTimeline;
import com.comcast.playerplatform.primetime.android.primetime.TimelineMarker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.comcast.playerplatform.primetime.android.ads.managers:
//            BaseAdTimeline, BaseAdManager

public class DefaultAdTimeline extends BaseAdTimeline
    implements com.adobe.mediacore.MediaPlayer.AdPlaybackEventListener
{

    public DefaultAdTimeline(BaseAdManager baseadmanager)
    {
        super(baseadmanager);
    }

    public void onAdBreakComplete(AdBreak adbreak)
    {
label0:
        {
            adManager.triggerAdBreakComplete(currentAdBreak);
            if (adBreaks == null)
            {
                break label0;
            }
            Iterator iterator = adBreaks.iterator();
            VideoAdBreak videoadbreak;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                videoadbreak = (VideoAdBreak)iterator.next();
            } while (adbreak.getTime() != videoadbreak.getStartTime());
            adManager.markAsSeen(videoadbreak);
        }
        currentAdBreak = null;
    }

    public void onAdBreakSkipped(AdBreak adbreak)
    {
    }

    public void onAdBreakStart(AdBreak adbreak)
    {
label0:
        {
            if (adBreaks == null)
            {
                break label0;
            }
            Iterator iterator = adBreaks.iterator();
            VideoAdBreak videoadbreak;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                videoadbreak = (VideoAdBreak)iterator.next();
            } while (adbreak.getTime() != videoadbreak.getStartTime());
            currentAdBreak = videoadbreak;
        }
        if (currentAdBreak == null)
        {
            Iterator iterator1 = adbreak.adsIterator();
            ArrayList arraylist = new ArrayList();
            long l = adbreak.getTime();
            while (iterator1.hasNext()) 
            {
                Object obj = (Ad)iterator1.next();
                VideoAd videoad = new VideoAd();
                videoad.setStartTime(l);
                videoad.setId(String.valueOf(((Ad) (obj)).getId()));
                videoad.setDuration(((Ad) (obj)).getDuration());
                l += ((Ad) (obj)).getDuration();
                if (((Ad) (obj)).isClickable())
                {
                    videoad.setIsClickable(true);
                    AdClick adclick = ((Ad) (obj)).getPrimaryAsset().getAdClick();
                    if (adclick.getTitle() != null)
                    {
                        obj = adclick.getTitle();
                    } else
                    {
                        obj = "";
                    }
                    videoad.setClickUrl(adclick.getUrl());
                    videoad.setClickTitle(((String) (obj)));
                }
                arraylist.add(videoad);
            }
            currentAdBreak = new VideoAdBreak();
            currentAdBreak.setId(adbreak.getTag());
            currentAdBreak.setVideoAdsList(arraylist);
            if (currentAdBreak != null)
            {
                currentAdBreak.setHasBeenSeen(adbreak.isWatched().booleanValue());
                if (adRestrictions != null && adRestrictions.size() > 0)
                {
                    adbreak = adRestrictions.iterator();
                    do
                    {
                        if (!adbreak.hasNext())
                        {
                            break;
                        }
                        AdRestriction adrestriction = (AdRestriction)adbreak.next();
                        if (currentAdBreak.getId().equals(adrestriction.getId()))
                        {
                            currentAdBreak.addRestriction(adrestriction);
                        }
                    } while (true);
                }
            }
        }
        adbreak = adManager.getPlayerTimeline(null);
        if (adbreak != null)
        {
            adbreak = adbreak.timelineMarkers();
            long l1 = -1L;
            do
            {
                if (!adbreak.hasNext())
                {
                    break;
                }
                TimelineMarker timelinemarker = (TimelineMarker)adbreak.next();
                if (timelinemarker.getTime() > l1 && timelinemarker.getTime() <= currentAdBreak.getStartTime())
                {
                    l1 = timelinemarker.getTime();
                }
            } while (true);
            currentAdBreak.setMarkerPosition(l1);
        }
        if (adManager != null)
        {
            adManager.triggerAdBreakStart(currentAdBreak, (VideoAd)currentAdBreak.getVideoAdsList().get(0));
        }
    }

    public void onAdComplete(AdBreak adbreak, Ad ad)
    {
        adManager.triggerAdComplete(currentAdBreak, currentAd);
        currentAd = null;
    }

    public void onAdProgress(AdBreak adbreak, Ad ad, int i)
    {
    }

    public void onAdStart(AdBreak adbreak, Ad ad)
    {
        currentAd = new VideoAd();
        currentAd.setId(String.valueOf(ad.getId()));
        currentAd.setDuration(ad.getDuration());
        if (ad.isClickable())
        {
            currentAd.setIsClickable(true);
            ad = ad.getPrimaryAsset().getAdClick();
            if (ad.getTitle() != null)
            {
                adbreak = ad.getTitle();
            } else
            {
                adbreak = "";
            }
            currentAd.setClickUrl(ad.getUrl());
            currentAd.setClickTitle(adbreak);
        }
        if (adManager != null)
        {
            adManager.triggerAdStart(currentAdBreak, currentAd);
        }
    }

    public void setResumePosition(long l)
    {
        VideoAdBreak videoadbreak1 = null;
        VideoAdBreak videoadbreak = null;
        if (adBreaks != null)
        {
            Iterator iterator = adBreaks.iterator();
            do
            {
                videoadbreak1 = videoadbreak;
                if (!iterator.hasNext())
                {
                    break;
                }
                videoadbreak1 = (VideoAdBreak)iterator.next();
                if (l >= videoadbreak1.getStartTime() && (videoadbreak == null || videoadbreak1.getStartTime() >= videoadbreak.getStartTime()))
                {
                    videoadbreak = videoadbreak1;
                }
            } while (true);
        }
        if (videoadbreak1 != null)
        {
            videoadbreak1.setHasBeenSeen(true);
        }
        updateProgress(l);
    }

    public void updateProgress(long l)
    {
        if (currentAdBreak != null)
        {
            currentAdBreak.updateProgress(l);
            if (adManager != null)
            {
                adManager.triggerAdProgress(currentAdBreak, currentAd, currentAdBreak.getPercentComplete(), currentAdBreak.getSecondsRemaining());
            }
        }
    }
}
