// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.xfinity.playerlib.view.videoplay.PlayerPlatformErrorException;
import com.xfinity.playerlib.view.videoplay.PlayerPlatformMediaPlayer;
import com.xfinity.playerlib.view.videoplay.VideoTrackController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            DefaultVideoState, VideoStateController, MobileDataWarningState, ResetPlayerState, 
//            VideoState

public abstract class AdEnabledState extends DefaultVideoState
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/videoplay/adobeplayer/AdEnabledState);
    private boolean backgrounded;
    private int bufferingWarnings;
    private boolean isBuffering;
    private boolean isClickableAdButtonVisible;
    protected boolean isSeeking;
    private boolean pausedForBackground;

    public AdEnabledState(VideoStateController videostatecontroller)
    {
        super(videostatecontroller);
        isBuffering = false;
        isSeeking = false;
        bufferingWarnings = 0;
        pausedForBackground = false;
        backgrounded = false;
    }

    public void adBreakComplete(VideoAdBreak videoadbreak)
    {
        stateController.getUiController().updateAdTimeLeft(0L);
        stateController.getUiController().hideAdControls();
        if (!stateController.getUiController().hasShownRatingsBug())
        {
            stateController.getUiController().startRatingsBug();
            long l = stateController.getVideoTrackController().getResumePoint();
            if (l > 0L)
            {
                stateController.getMediaPlayer().setPosition(l, true);
            }
            stateController.getUiController().startMainControlTimeout();
            stateController.getUiController().showMainControlsWithPauseButton();
            return;
        } else
        {
            stateController.getVideoTrackController().onCustomUpdateEvent(stateController.getMediaPlayer().getPosition(), stateController.getMediaPlayer().getDuration());
            return;
        }
    }

    public void adBreakStart(VideoAdBreak videoadbreak, VideoAd videoad)
    {
        if (!videoad.isClickable())
        {
            stateController.getUiController().hideAllControls();
        } else
        {
            stateController.getUiController().hideMainControlsAndActionBar();
        }
        stateController.getUiController().dismissDialogs();
        stateController.getUiController().showAdControlsWithTimeLeft(videoadbreak.getDuration());
        if (videoadbreak.getStartTime() != 0L)
        {
            stateController.getVideoTrackController().onCustomUpdateEvent(videoadbreak.getStartTime(), stateController.getMediaPlayer().getDuration());
        }
    }

    public void adComplete(long l)
    {
        stateController.getUiController().hideClickableAdButton();
        isClickableAdButtonVisible = false;
        if (stateController.getUiController().isAdViewVisible())
        {
            stateController.getMediaPlayer().pause();
        }
    }

    public void adProgress(VideoAdBreak videoadbreak, VideoAd videoad, int i, long l)
    {
        stateController.getUiController().updateAdTimeLeft(l);
        if (videoad.isClickable() && !isClickableAdButtonVisible && i > 0)
        {
            stateController.getUiController().showClickableAdButtonForUrl(videoad.getClickTitle().trim(), videoad.getClickUrl());
            isClickableAdButtonVisible = true;
        }
    }

    public void adStart(VideoAd videoad)
    {
        if (videoad.isClickable())
        {
            stateController.getUiController().turnLightsOn();
            stateController.getUiController().removeMainControlTimeout();
            if (!stateController.getUiController().isAdsActionBarAdjustedForStatusBar())
            {
                stateController.getUiController().moveAdsActionBarDown(false);
            }
            return;
        }
        if (stateController.getUiController().isAdsActionBarAdjustedForStatusBar())
        {
            stateController.getUiController().moveAdsActionBarUp(false);
        }
        stateController.getUiController().hideClickableAdButton();
        isClickableAdButtonVisible = false;
    }

    public void onAMSContinueException(Exception exception)
    {
        PlayerPlatformMediaPlayer playerplatformmediaplayer = stateController.getMediaPlayer();
        if (PlayerStatus.PLAYING.equals(playerplatformmediaplayer.getPlayerStatus()))
        {
            playerplatformmediaplayer.pause();
        }
        super.onAMSContinueException(exception);
    }

    public void onActivityPaused()
    {
        backgrounded = true;
        if (stateController.getMediaPlayer() != null)
        {
            if (stateController.getMediaPlayer().getPlayerStatus() == PlayerStatus.PLAYING)
            {
                stateController.getMediaPlayer().pause();
                pausedForBackground = true;
            }
            if (!stateController.isAdPlaying())
            {
                stateController.getVideoTrackController().onCustomUpdateEvent(stateController.getMediaPlayer().getPosition(), stateController.getMediaPlayer().getDuration());
            }
        }
        super.onActivityPaused();
    }

    public void onBitrateChanged(long l, String s, int i, int j)
    {
        stateController.getUiController().updateCurrentBitrate(l);
        LOG.debug((new StringBuilder()).append("Changing Bitrate to ").append(l).append(", reason: ").append(s).toString());
        LOG.debug((new StringBuilder()).append("Current Height/Width: ").append(i).append("/").append(j).toString());
    }

    public void onBufferComplete()
    {
        isBuffering = false;
        bufferingWarnings = 0;
        if (!isSeeking)
        {
            stateController.getUiController().hideSpinner();
        }
    }

    public void onBufferStart()
    {
        if (!stateController.shouldUseDownloadFile())
        {
            isBuffering = true;
            if (!isSeeking)
            {
                stateController.getUiController().showBuffering();
            }
        }
    }

    public void onConnectivityChanged()
    {
        if (isBuffering)
        {
            if (!stateController.getInternetConnection().isConnected())
            {
                stateController.getUiController().setWaitingForInternetText();
            } else
            {
                bufferingWarnings = 0;
                stateController.getUiController().showBuffering();
            }
        }
        if (!stateController.shouldUseDownloadFile())
        {
            stateController.transitionToState(new MobileDataWarningState(stateController, this));
        }
    }

    public void onHeadsetButtonEvent(int i)
    {
        if (!stateController.isAdPlaying())
        {
            if (i == 126 || i == 85 && stateController.getMediaPlayer().getPlayerStatus() == PlayerStatus.PAUSED)
            {
                onPlayButton();
            } else
            if (i == 127 || i == 85 && stateController.getMediaPlayer().getPlayerStatus() == PlayerStatus.PLAYING)
            {
                onPauseButton();
                return;
            }
        }
    }

    public void onHeadsetNoiseDetected()
    {
        if (!stateController.isAdPlaying() && stateController.getMediaPlayer().getPlayerStatus() == PlayerStatus.PLAYING && !stateController.isLiveStream())
        {
            onPauseButton();
        }
    }

    public void onMediaWarning(String s, String s1)
    {
        if ((new PlayerPlatformErrorException(s, s1)).getMajorCode() == 0x330cc && isBuffering && stateController.getInternetConnection().isConnected())
        {
            bufferingWarnings = bufferingWarnings + 1;
            if (bufferingWarnings >= 3)
            {
                stateController.getUiController().setWaitingForInternetText();
            }
        }
    }

    public void onVideoSeekComplete()
    {
        isSeeking = false;
        stateController.getUiController().hideSpinner();
        if (isBuffering)
        {
            stateController.getUiController().showBuffering();
        }
    }

    public void onVideoSeekStart()
    {
        isSeeking = true;
        stateController.getUiController().showSeeking();
    }

    public void run()
    {
        if (backgrounded)
        {
            if (pausedForBackground)
            {
                stateController.getMediaPlayer().play();
            } else
            {
                onPlayStateChanged(PlayerStatus.PAUSED);
            }
            backgrounded = false;
            pausedForBackground = false;
            if (!stateController.isAdPlaying())
            {
                stateController.getUiController().startRatingsBug();
                stateController.getUiController().setupAccessibilityControlToggle();
            }
        }
        if (stateController.isAdPlaying())
        {
            if (!stateController.getUiController().isClickableAdsButtonVisibile())
            {
                stateController.getUiController().hideAllControls();
            }
            stateController.getUiController().showAdControlsWithTimeLeft(stateController.getAdDuration());
        }
    }

    public void transitionToState(VideoState videostate)
    {
        if (videostate instanceof ResetPlayerState)
        {
            stateController.setState(videostate);
            return;
        } else
        {
            super.transitionToState(videostate);
            return;
        }
    }

}
