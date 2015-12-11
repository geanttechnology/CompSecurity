// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.player;

import android.view.View;
import com.comcast.playerplatform.primetime.android.ads.managers.BaseAdManager;
import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.primetime.android.enums.StreamType;
import com.comcast.playerplatform.primetime.android.events.AbstractPlayerPlatformVideoEventListener;
import com.comcast.playerplatform.primetime.android.primetime.PlayerAudioTrack;
import com.comcast.playerplatform.primetime.android.primetime.PlayerClosedCaptionsTrack;
import com.comcast.playerplatform.primetime.android.primetime.PlayerTimeline;
import com.comcast.playerplatform.primetime.android.util.FragmentInfo;
import com.comcast.playerplatform.primetime.android.util.LogFactory;
import com.comcast.playerplatform.primetime.android.util.PlayerLogger;
import java.util.List;

public interface Player
{

    public abstract void addEventListener(AbstractPlayerPlatformVideoEventListener abstractplayerplatformvideoeventlistener);

    public abstract void destroy();

    public abstract BaseAdManager getAdManager();

    public abstract List getAvailableAudioLanguages();

    public abstract List getAvailableBitrates();

    public abstract List getAvailableClosedCaptionTracks();

    public abstract List getAvailableProfiles();

    public abstract boolean getClosedCaptionsStatus();

    public abstract PlayerAudioTrack getCurrentAudioTrack();

    public abstract int getCurrentBitrate();

    public abstract Asset getCurrentChannel();

    public abstract PlayerClosedCaptionsTrack getCurrentClosedCaptionTrack();

    public abstract float getCurrentPlaybackSpeed();

    public abstract long getCurrentPosition();

    public abstract long getDuration();

    public abstract long getEndPosition();

    public abstract FragmentInfo getFragmentInfo();

    public abstract PlayerLogger getLogger();

    public abstract PlayerStatus getPlayerStatus();

    public abstract List getSupportedClosedCaptionsOptions();

    public abstract List getSupportedPlaybackSpeeds();

    public abstract PlayerTimeline getTimeline();

    public abstract String getVersion();

    public abstract long getVideoHeight();

    public abstract StreamType getVideoType();

    public abstract long getVideoWidth();

    public abstract View getView();

    public abstract boolean hasCC();

    public abstract boolean hasDRM();

    public abstract void pause();

    public abstract void play();

    public abstract void removeEventListener(AbstractPlayerPlatformVideoEventListener abstractplayerplatformvideoeventlistener);

    public abstract void seekToLive();

    public abstract void setAsset(Asset asset, long l, BaseAdManager baseadmanager);

    public abstract void setClosedCaptionsEnabled(boolean flag);

    public abstract void setClosedCaptionsTrack(PlayerClosedCaptionsTrack playerclosedcaptionstrack);

    public abstract void setLogger(LogFactory logfactory);

    public abstract void setLoggingVerbosity(com.adobe.mediacore.logging.Logger.Verbosity verbosity);

    public abstract void setPosition(long l, boolean flag);

    public abstract void setPositionRelative(long l);

    public abstract void setPreferredAudioLanguage(PlayerAudioTrack playeraudiotrack);

    public abstract void setVolume(int i);

    public abstract void stop();
}
