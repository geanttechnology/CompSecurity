// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads.managers;

import com.adobe.mediacore.metadata.AdSignalingMode;
import com.adobe.mediacore.metadata.MetadataNode;
import com.adobe.mediacore.metadata.TimedMetadata;
import com.adobe.mediacore.timeline.Timeline;
import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.primetime.android.events.AbstractPlayerPlatformVideoEventListener;
import com.comcast.playerplatform.primetime.android.events.PlayerEventManager;
import com.comcast.playerplatform.primetime.android.player.Player;
import com.comcast.playerplatform.primetime.android.primetime.PlayerTimeline;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.playerplatform.primetime.android.ads.managers:
//            BaseAdTimeline

public abstract class BaseAdManager extends AbstractPlayerPlatformVideoEventListener
{

    private static final Logger logger = LoggerFactory.getLogger(com/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager);
    private boolean adBreakCompleteSent;
    protected PlayerTimeline auditdueTimelineMarkers;
    protected PlayerEventManager eventManager;
    protected boolean hasResumePoint;
    protected Player player;
    protected long savedSeekValue;
    protected boolean seekingOutOfAd;
    protected boolean skipAdsOnSeek;
    protected BaseAdTimeline timeline;

    public BaseAdManager()
    {
        seekingOutOfAd = false;
        hasResumePoint = false;
        skipAdsOnSeek = false;
        savedSeekValue = -1L;
        adBreakCompleteSent = false;
        auditdueTimelineMarkers = null;
    }

    public void addPlayerEventManager(PlayerEventManager playereventmanager)
    {
        if (playereventmanager != null)
        {
            eventManager = playereventmanager;
            eventManager.addListener(this);
        }
    }

    public void attachPlayer(Player player1)
    {
        player = player1;
    }

    public Player clearPlayer()
    {
        timeline.clear();
        player = null;
        return null;
    }

    public List getAdList()
    {
        return timeline.getAdList();
    }

    public long getAdOffset()
    {
        long l1 = 0L;
        VideoAdBreak videoadbreak = getCurrentAdBreak();
        long l = l1;
        if (videoadbreak != null)
        {
            l = l1;
            if (videoadbreak.getMarkerPosition() != videoadbreak.getStartTime())
            {
                l = videoadbreak.getStartTime() - videoadbreak.getMarkerPosition();
            }
        }
        return l;
    }

    public VideoAd getCurrentAd()
    {
        return timeline.getCurrentAd();
    }

    public VideoAdBreak getCurrentAdBreak()
    {
        return timeline.getCurrentAdBreak();
    }

    public abstract MetadataNode getMetadataForAdobe();

    public abstract PlayerTimeline getPlayerTimeline(Timeline timeline1);

    public long getSeekAdjustment(long l, long l1, boolean flag)
    {
        VideoAdBreak videoadbreak;
        Object obj;
        long l2;
        long l4;
        obj = null;
        videoadbreak = null;
        l2 = l;
        skipAdsOnSeek = flag;
        l4 = l2;
        if (timeline == null) goto _L2; else goto _L1
_L1:
        l4 = l2;
        if (flag) goto _L2; else goto _L3
_L3:
        VideoAdBreak videoadbreak2;
        videoadbreak2 = timeline.getCurrentAdBreak();
        l4 = l2;
        if (videoadbreak2 != null)
        {
            l4 = l2;
            if (getAdOffset() != 0L)
            {
                l4 = l2;
                if (videoadbreak2.getMarkerPosition() < l)
                {
                    l4 = l2 + getAdOffset();
                }
            }
        }
        if (videoadbreak2 == null || videoadbreak2.hasBeenSeen() || !videoadbreak2.isSeekDisabled() || getAdOffset() + l1 >= l4) goto _L5; else goto _L4
_L4:
        l4 = l1;
_L2:
        return l4;
_L5:
        List list = timeline.getAdList();
        VideoAdBreak videoadbreak1 = obj;
        if (player != null)
        {
            videoadbreak1 = obj;
            if (list != null)
            {
                Iterator iterator = list.iterator();
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
        }
        long l3 = l4;
        if (videoadbreak1 != null)
        {
            l3 = l4;
            if (videoadbreak1 != videoadbreak2)
            {
                l3 = l4;
                if (!videoadbreak1.hasBeenSeen())
                {
                    l3 = l4;
                    if (videoadbreak1.isSeekDisabled())
                    {
                        l3 = videoadbreak1.getStartTime();
                        if (l > videoadbreak1.getEndTime())
                        {
                            savedSeekValue = l;
                        } else
                        {
                            savedSeekValue = -1L;
                        }
                    }
                }
            }
        }
        l4 = l3;
        if (videoadbreak2 == null) goto _L2; else goto _L6
_L6:
        l4 = l3;
        if (videoadbreak2.coversLocation(l3)) goto _L2; else goto _L7
_L7:
        if (l3 != l1)
        {
            break; /* Loop/switch isn't completed */
        }
        l4 = l3;
        if (l3 == l) goto _L2; else goto _L8
_L8:
        seekingOutOfAd = true;
        return l3;
    }

    public abstract AdSignalingMode getSignalingMode();

    public boolean getSkipAdsOnSeek()
    {
        return skipAdsOnSeek;
    }

    public BaseAdTimeline getTimeline(Timeline timeline1)
    {
        return timeline;
    }

    public com.comcast.playerplatform.primetime.android.ads.PlayerAdBreakPolicies.AdBreakWatchedPolicy getWatchedPolicy()
    {
        com.comcast.playerplatform.primetime.android.ads.PlayerAdBreakPolicies.AdBreakWatchedPolicy adbreakwatchedpolicy1 = com.comcast.playerplatform.primetime.android.ads.PlayerAdBreakPolicies.AdBreakWatchedPolicy.DO_NOT_MARK;
        com.comcast.playerplatform.primetime.android.ads.PlayerAdBreakPolicies.AdBreakWatchedPolicy adbreakwatchedpolicy = adbreakwatchedpolicy1;
        if (getCurrentAdBreak() == null)
        {
            adbreakwatchedpolicy = adbreakwatchedpolicy1;
            if (!seekingOutOfAd)
            {
                adbreakwatchedpolicy = com.comcast.playerplatform.primetime.android.ads.PlayerAdBreakPolicies.AdBreakWatchedPolicy.MARK_AS_WATCHED;
            }
        }
        if (seekingOutOfAd)
        {
            seekingOutOfAd = false;
        }
        return adbreakwatchedpolicy;
    }

    public boolean isAdPlaying()
    {
        return timeline != null && timeline.isAdPlaying();
    }

    public void markAsSeen(VideoAdBreak videoadbreak)
    {
        if (videoadbreak != null && !videoadbreak.hasBeenSeen() && !seekingOutOfAd)
        {
            videoadbreak.setHasBeenSeen(true);
        }
        if (seekingOutOfAd)
        {
            seekingOutOfAd = false;
        }
    }

    public void mediaProgress(long l, double d, long l1, long l2, int i)
    {
        timeline.updateProgress(l);
    }

    public abstract void onTimedMetadata(TimedMetadata timedmetadata);

    public void playStateChanged(PlayerStatus playerstatus)
    {
        if (player != null && playerstatus.equals(PlayerStatus.PREPARED))
        {
            auditdueTimelineMarkers = player.getTimeline();
        }
    }

    public void removePlayerEventManager()
    {
        if (eventManager != null)
        {
            eventManager.removeListener(this);
        }
        eventManager = null;
    }

    public void setAdList(List list)
    {
        timeline.setAdList(list);
    }

    public void setResumePosition(long l)
    {
        if (l > 0L)
        {
            hasResumePoint = true;
            timeline.setResumePosition(l);
            return;
        } else
        {
            timeline.updateProgress(0L);
            return;
        }
    }

    public void triggerAdBreakComplete(VideoAdBreak videoadbreak)
    {
        if (videoadbreak != null && eventManager != null)
        {
            if (seekingOutOfAd)
            {
                eventManager.adBreakExited(videoadbreak);
            } else
            {
                eventManager.adBreakComplete(videoadbreak);
            }
        }
        if (savedSeekValue > 0L && player != null && !seekingOutOfAd)
        {
            player.setPosition(savedSeekValue, true);
            savedSeekValue = -1L;
        }
    }

    public void triggerAdBreakStart(VideoAdBreak videoadbreak, VideoAd videoad)
    {
        adBreakCompleteSent = false;
        if (eventManager != null)
        {
            eventManager.adBreakStart(videoadbreak, videoad);
        }
    }

    public void triggerAdComplete(VideoAdBreak videoadbreak, VideoAd videoad)
    {
label0:
        {
            if (videoad.getEndTime() == videoadbreak.getEndTime() && !adBreakCompleteSent)
            {
                triggerAdProgress(videoadbreak, videoadbreak.getAdAtLocation(videoadbreak.getEndTime() - 10L), 100, 0L);
                adBreakCompleteSent = true;
            }
            if (videoadbreak != null && eventManager != null)
            {
                if (!seekingOutOfAd)
                {
                    break label0;
                }
                eventManager.adExited(videoad.getId());
            }
            return;
        }
        eventManager.adComplete(videoad.getId());
    }

    public void triggerAdProgress(VideoAdBreak videoadbreak, VideoAd videoad, int i, long l)
    {
        if (videoadbreak != null && eventManager != null && !adBreakCompleteSent)
        {
            eventManager.adProgress(videoadbreak, videoad, i, l);
            if (i == 100)
            {
                adBreakCompleteSent = true;
            }
        }
    }

    public void triggerAdStart(VideoAdBreak videoadbreak, VideoAd videoad)
    {
        if (videoadbreak != null && eventManager != null)
        {
            eventManager.adStart(videoad);
        }
    }

}
