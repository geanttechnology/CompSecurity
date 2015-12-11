// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import com.comcast.cim.analytics.XfinityEventData;
import com.comcast.cim.cmasl.analytics.AnalyticsLogger;
import com.comcast.cim.cmasl.analytics.EventData;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.model.videoplay.PlayerActionBarMenuType;
import com.xfinity.playerlib.view.videoplay.PlayerPlatformMediaPlayer;
import com.xfinity.playerlib.view.videoplay.VideoTrackController;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            AdEnabledState, VideoStateController, InfoPanelState, EndCardState, 
//            MobileDataWarningState, VideoState

public class PlaybackState extends AdEnabledState
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/videoplay/adobeplayer/PlaybackState);

    public PlaybackState(VideoStateController videostatecontroller)
    {
        super(videostatecontroller);
    }

    public String getStateName()
    {
        return "PlaybackState";
    }

    public void onBabyGuideButton()
    {
        if (!stateController.isAdPlaying())
        {
            stateController.transitionToState(new InfoPanelState(stateController, PlayerActionBarMenuType.BABY_GUIDE));
        }
    }

    public void onBackButton()
    {
        if (stateController.getUiController().isAdViewVisible())
        {
            stateController.getUiController().hideAdView();
            return;
        }
        if (!stateController.isLiveStream() && !stateController.getMediaPlayer().isAdPlaying())
        {
            stateController.getVideoTrackController().onEndPlayback(stateController.getMediaPlayer().getPosition(), stateController.getMediaPlayer().getDuration());
        }
        super.onBackButton();
    }

    public void onCCButton()
    {
        boolean flag1 = true;
        byte byte0 = 0;
        if (!stateController.isAdPlaying())
        {
            boolean flag2 = ((PlayerUserSettings)stateController.getUserManager().getUserSettings()).getWantsClosedCaptions();
            Object obj = stateController.getMediaPlayer();
            XfinityEventData xfinityeventdata;
            boolean flag;
            if (!flag2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ((PlayerPlatformMediaPlayer) (obj)).setCCEnabled(flag);
            obj = stateController.getUiController();
            if (!flag2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ((com.xfinity.playerlib.view.videoplay.VideoPlayerFragment.PlayerUIController) (obj)).setCCButtonSelected(flag);
            obj = (PlayerUserSettings)stateController.getUserManager().getUserSettings();
            if (!flag2)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            ((PlayerUserSettings) (obj)).setWantsClosedCaptions(flag);
            obj = (PlayerUserSettings)stateController.getUserManager().getUserSettings();
            if (flag2)
            {
                byte0 = -1;
            }
            ((PlayerUserSettings) (obj)).setCCTrackIndex(byte0);
            xfinityeventdata = new XfinityEventData("Toggle CC");
            if (!flag2)
            {
                obj = "On";
            } else
            {
                obj = "Off";
            }
            xfinityeventdata.addData("State", ((String) (obj)));
            stateController.getSplunker().logData(xfinityeventdata);
        }
    }

    public void onDurationChanged(long l)
    {
        stateController.getUiController().updateProgress();
    }

    public void onFavoritesButton()
    {
        if (!stateController.isAdPlaying())
        {
            stateController.transitionToState(new InfoPanelState(stateController, PlayerActionBarMenuType.FAVORITE));
        }
    }

    public void onHistoryButton()
    {
        if (!stateController.isAdPlaying())
        {
            stateController.transitionToState(new InfoPanelState(stateController, PlayerActionBarMenuType.HISTORY));
        }
    }

    public void onMediaProgress(long l, double d, long l1, long l2, int i)
    {
        super.onMediaProgress(l, d, l1, l2, i);
        stateController.getUiController().updateProgress();
    }

    public void onPauseButton()
    {
        if (!stateController.isAdPlaying() && stateController.getMediaPlayer().getPlayerStatus() == PlayerStatus.PLAYING)
        {
            stateController.getMediaPlayer().pause();
        }
        stateController.getUiController().removeVolumeControlTimeout();
    }

    public void onPlayButton()
    {
        if (!stateController.isAdPlaying() && (stateController.getMediaPlayer().getPlayerStatus() == PlayerStatus.PAUSED || stateController.getMediaPlayer().getPlayerStatus() == PlayerStatus.SUSPENDED))
        {
            stateController.getMediaPlayer().play();
        }
    }

    public void onPlayStateChanged(PlayerStatus playerstatus)
    {
        if (!playerstatus.equals(PlayerStatus.PLAYING)) goto _L2; else goto _L1
_L1:
        if (stateController.isAdPlaying()) goto _L4; else goto _L3
_L3:
        if (!stateController.getUiController().isAccessibilityModeOn()) goto _L6; else goto _L5
_L5:
        stateController.getUiController().removeMainControlTimeout();
        if (!stateController.getUiController().isManualControlToggleOn()) goto _L8; else goto _L7
_L7:
        stateController.getUiController().showMainControlsWithPauseButton();
_L4:
        return;
_L8:
        stateController.getUiController().hideAllControls();
        return;
_L6:
        if (stateController.getUiController().isMainControlShowing())
        {
            stateController.getUiController().removeMainControlTimeout();
            stateController.getUiController().hideAllControls();
            return;
        } else
        {
            stateController.getUiController().startMainControlTimeout();
            stateController.getUiController().showMainControlsWithPauseButton();
            return;
        }
_L2:
        if (!playerstatus.equals(PlayerStatus.PAUSED))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (stateController.isAdPlaying()) goto _L4; else goto _L9
_L9:
        stateController.getUiController().removeMainControlTimeout();
        stateController.getUiController().showMainControlsWithPlayButton();
        return;
        if (!playerstatus.equals(PlayerStatus.COMPLETE)) goto _L4; else goto _L10
_L10:
        stateController.getVideoTrackController().onEndPlayback(stateController.getMediaPlayer().getPosition(), stateController.getMediaPlayer().getDuration());
        stateController.transitionToState(new EndCardState(stateController));
        return;
    }

    public void onSAPButton()
    {
        if (!stateController.isAdPlaying() && stateController.getMediaPlayer().getAvailableLanguages().size() > 1)
        {
            stateController.getUiController().removeMainControlTimeout();
            stateController.getUiController().showSAPSelectionDialog();
        }
    }

    public void onScreenTouch()
    {
        if (!stateController.getUiController().isDialogShowing())
        {
            if (!stateController.isAdPlaying())
            {
                onPlayStateChanged(stateController.getMediaPlayer().getPlayerStatus());
            } else
            if (!stateController.getUiController().isAdViewVisible() && !stateController.getMediaPlayer().isCurrentAdClickable())
            {
                stateController.getUiController().startMainControlTimeout();
                stateController.getUiController().startAdsActionBarTimeout();
                return;
            }
        }
    }

    public void onSeekRequest(long l)
    {
        if (!stateController.isAdPlaying())
        {
            stateController.getMediaPlayer().setPosition(l, false);
        }
    }

    public void onTimelineUpdated()
    {
        stateController.getUiController().setupAdBreaks(stateController.getMediaPlayer().getTimeline());
    }

    public void onUserMovedSeekBar(int i)
    {
        stateController.getUiController().showThumbTimeView(i);
    }

    public void onUserSeekEnded(boolean flag)
    {
        if (stateController.getMediaPlayer().getPlayerStatus() == PlayerStatus.PLAYING)
        {
            stateController.getUiController().startMainControlTimeout();
        }
        if (!flag && !isSeeking)
        {
            stateController.getUiController().setIsSeeking(Boolean.valueOf(false));
        }
    }

    public void onUserSeekStarted()
    {
        stateController.getUiController().removeMainControlTimeout();
        stateController.getUiController().setIsSeeking(Boolean.valueOf(true));
    }

    public void onVolumeChanged()
    {
        if (stateController.getMediaPlayer().getPlayerStatus() == PlayerStatus.PLAYING && !stateController.getUiController().isDialogShowing())
        {
            stateController.getUiController().startMainControlTimeout();
        }
    }

    public void run()
    {
        stateController.getUiController().updateProgress();
        super.run();
    }

    public void transitionToState(VideoState videostate)
    {
        if ((videostate instanceof InfoPanelState) || (videostate instanceof EndCardState) || (videostate instanceof MobileDataWarningState))
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
