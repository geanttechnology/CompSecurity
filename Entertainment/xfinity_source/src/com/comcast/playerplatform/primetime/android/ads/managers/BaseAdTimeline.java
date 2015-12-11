// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads.managers;

import com.adobe.mediacore.timeline.advertising.Ad;
import com.adobe.mediacore.timeline.advertising.AdBreak;
import com.adobe.mediacore.timeline.advertising.AdClick;
import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.comcast.playerplatform.primetime.android.ads.managers:
//            AdTimeline, BaseAdManager

public class BaseAdTimeline
    implements com.adobe.mediacore.MediaPlayer.AdPlaybackEventListener, AdTimeline
{

    protected List adBreaks;
    protected BaseAdManager adManager;
    protected ArrayList adRestrictions;
    protected VideoAd currentAd;
    protected VideoAdBreak currentAdBreak;
    protected long currentPosition;

    public BaseAdTimeline(BaseAdManager baseadmanager)
    {
        currentPosition = 0L;
        adManager = baseadmanager;
    }

    public void addAd(VideoAdBreak videoadbreak)
    {
    }

    public void clear()
    {
    }

    public void createAdBreak(String s, Long long1, long l)
    {
    }

    public void createAdRestriction(String s, String s1, String s2)
    {
    }

    public List getAdList()
    {
        return adBreaks;
    }

    public VideoAd getCurrentAd()
    {
        return currentAd;
    }

    public VideoAdBreak getCurrentAdBreak()
    {
        return currentAdBreak;
    }

    public boolean isAdPlaying()
    {
        return currentAdBreak != null;
    }

    public void onAdBreakComplete(AdBreak adbreak)
    {
    }

    public void onAdBreakSkipped(AdBreak adbreak)
    {
    }

    public void onAdBreakStart(AdBreak adbreak)
    {
    }

    public void onAdClick(AdBreak adbreak, Ad ad, AdClick adclick)
    {
    }

    public void onAdComplete(AdBreak adbreak, Ad ad)
    {
    }

    public void onAdProgress(AdBreak adbreak, Ad ad, int i)
    {
    }

    public void onAdStart(AdBreak adbreak, Ad ad)
    {
    }

    public void onSeekEnd(long l)
    {
    }

    public void onSeekStart(long l)
    {
    }

    public void setAdList(List list)
    {
        adBreaks = list;
    }

    public void setResumePosition(long l)
    {
    }

    public void streamComplete()
    {
    }

    public void updateProgress(long l)
    {
    }
}
