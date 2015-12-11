// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.events;

import com.adobe.ave.drm.DRMManager;
import com.adobe.ave.drm.DRMMetadata;
import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import java.util.Date;
import java.util.EventListener;
import java.util.List;

public abstract class AbstractPlayerPlatformVideoEventListener
    implements EventListener
{

    public AbstractPlayerPlatformVideoEventListener()
    {
    }

    public void acquiringLicense(String s)
    {
    }

    public void adBreakComplete(VideoAdBreak videoadbreak)
    {
    }

    public void adBreakExited(VideoAdBreak videoadbreak)
    {
    }

    public void adBreakStart(VideoAdBreak videoadbreak, VideoAd videoad)
    {
    }

    public void adComplete(String s)
    {
    }

    public void adExited(String s)
    {
    }

    public void adProgress(VideoAdBreak videoadbreak, VideoAd videoad, int i, long l)
    {
    }

    public void adStart(VideoAd videoad)
    {
    }

    public void bitrateChanged(long l, String s, long l1, long l2)
    {
    }

    public void drmComplete(String s, Date date, Date date1)
    {
    }

    public void drmFailure(String s, String s1, String s2, Exception exception)
    {
    }

    public void drmMetaDataAvailable(DRMManager drmmanager, DRMMetadata drmmetadata)
    {
    }

    public void droppedFPSChanged(long l)
    {
    }

    public void durationChanged(long l)
    {
    }

    public void emergencyAlertCompleted(String s)
    {
    }

    public void emergencyAlertFailed(String s, String s1)
    {
    }

    public void emergencyAlertStarted(String s)
    {
    }

    public void fpsChanged(long l)
    {
    }

    public void fragmentWarning(long l, long l1, long l2, String s)
    {
    }

    public void mediaEnded()
    {
    }

    public void mediaFailed(String s, String s1)
    {
    }

    public void mediaOpened(String s, String s1, List list, List list1, List list2, long l, 
            long l1, long l2, double d, boolean flag)
    {
    }

    public void mediaProgress(long l, double d, long l1, long l2, int i)
    {
    }

    public void mediaWarning(String s, String s1)
    {
    }

    public void numberOfAlternativeAudioStreamsChanged(int i)
    {
    }

    public void offlineDRMComplete(String s, Date date, Date date1, String s1)
    {
    }

    public void offlineDRMFailure(String s, String s1)
    {
    }

    public void onBufferComplete()
    {
    }

    public void onBufferStart()
    {
    }

    public void onPlayStarted()
    {
    }

    public void onSeekComplete(long l)
    {
    }

    public void onSeekStart()
    {
    }

    public void onTimelineUpdated()
    {
    }

    public void playStateChanged(PlayerStatus playerstatus)
    {
    }

    public void playbackSpeedChanged(float f)
    {
    }

    public void retryAttempted(String s, String s1, int i)
    {
    }
}
