// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.player;

import android.view.View;
import com.comcast.playerplatform.primetime.android.ads.PlayerAdBreakPolicies;
import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.primetime.android.enums.StreamType;
import com.comcast.playerplatform.primetime.android.enums.ZoomSetting;
import com.comcast.playerplatform.primetime.android.primetime.PlayerAudioTrack;
import com.comcast.playerplatform.primetime.android.primetime.PlayerClosedCaptionsTrack;
import com.comcast.playerplatform.primetime.android.primetime.PlayerTimeline;
import com.comcast.playerplatform.primetime.android.util.ClosedCaptionFormatBuilder;
import com.comcast.playerplatform.primetime.android.util.LogFactory;
import com.comcast.playerplatform.primetime.android.util.PlayerLogger;
import com.comcast.playerplatform.util.android.BitrateParameters;
import com.comcast.playerplatform.util.android.Range;
import java.util.List;

public interface IPlayerPlatform
{

    public abstract boolean getAutoPlay();

    public abstract List getAvailableAudioLanguages();

    public abstract List getAvailableBitrates();

    public abstract List getAvailableClosedCaptionTracks();

    public abstract List getAvailableProfiles();

    public abstract Range getBitrateRange();

    public abstract boolean getClosedCaptionsStatus();

    public abstract VideoAd getCurrentAd();

    public abstract VideoAdBreak getCurrentAdBreak();

    public abstract PlayerAudioTrack getCurrentAudioTrack();

    public abstract int getCurrentBitrate();

    public abstract Asset getCurrentChannel();

    public abstract PlayerClosedCaptionsTrack getCurrentClosedCaptionTrack();

    public abstract double getCurrentPlaybackSpeed();

    public abstract long getCurrentPosition();

    public abstract long getDuration();

    public abstract long getEndPosition();

    public abstract int getInitialBitrate();

    public abstract PlayerLogger getLogger();

    public abstract PlayerStatus getPlayerStatus();

    public abstract long getStartPosition();

    public abstract List getSupportedClosedCaptionsOptions();

    public abstract List getSupportedPlaybackSpeeds();

    public abstract PlayerTimeline getTimeline();

    public abstract String getVersion();

    public abstract long getVideoHeight();

    public abstract StreamType getVideoType();

    public abstract long getVideoWidth();

    public abstract View getView();

    public abstract boolean isAdPlaying();

    public abstract void pause();

    public abstract void play();

    public abstract void seekToLive();

    public abstract void setAutoPlay(Boolean boolean1);

    public abstract void setBitrateParameters(BitrateParameters bitrateparameters);

    public abstract void setBitrateRange(Range range);

    public abstract void setBlock(boolean flag);

    public abstract void setClosedCaptionsEnabled(boolean flag);

    public abstract void setClosedCaptionsOptions(ClosedCaptionFormatBuilder closedcaptionformatbuilder);

    public abstract void setClosedCaptionsTrack(PlayerClosedCaptionsTrack playerclosedcaptionstrack);

    public abstract void setCurrentTimeUpdateInterval(int i);

    public abstract void setInitialBitrate(int i);

    public abstract void setLogger(LogFactory logfactory);

    public abstract void setLoggingVerbosity(com.adobe.mediacore.logging.Logger.Verbosity verbosity);

    public abstract void setPlayerAdBreakPolicies(PlayerAdBreakPolicies playeradbreakpolicies);

    public abstract void setPositionRelative(long l);

    public abstract void setPreferredAudioLanguage(PlayerAudioTrack playeraudiotrack);

    public abstract void setPreferredZoomSetting(ZoomSetting zoomsetting);

    public abstract void setVolume(int i);
}
