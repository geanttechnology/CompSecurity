// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.app.Activity;
import com.comcast.cim.model.system.PlayerAndroidDevice;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.util.android.BitrateParameters;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.view.videoplay.PlayerPlatformMediaPlayer;
import com.xfinity.playerlib.view.videoplay.VideoTrackController;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            DefaultVideoState, VideoStateController, ErrorState, PlaybackState, 
//            VideoState

public class PlayerPreparingState extends DefaultVideoState
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState);

    public PlayerPreparingState(VideoStateController videostatecontroller)
    {
        super(videostatecontroller);
    }

    private void lockBitrate()
    {
        List list = stateController.getMediaPlayer().getAvailableBitrates();
        int j = 0;
        int i = 0;
        if (list != null)
        {
            Iterator iterator = list.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                j = ((Integer)iterator.next()).intValue();
                if (j <= 0x16e360 && j > i)
                {
                    i = j;
                }
            } while (true);
            j = i;
            if (i == 0)
            {
                j = i;
                if (!list.isEmpty())
                {
                    j = ((Integer)list.get(0)).intValue();
                }
            }
        }
        if (j == 0)
        {
            transitionToState(new ErrorState(stateController, stateController.getActivityContext().getString(com.xfinity.playerlib.R.string.player_platform_error_msg_playlist_problem)));
            return;
        } else
        {
            BitrateParameters bitrateparameters = new BitrateParameters(j, j, j);
            stateController.getMediaPlayer().setBitrateParameters(bitrateparameters);
            stateController.getMediaPlayer().play();
            return;
        }
    }

    private void preparePlayer()
    {
        stateController.getUiController().setLaunchScreenMessage(com.xfinity.playerlib.R.string.player_launch_preparing);
        long l = stateController.getVideoTrackController().getResumePoint();
        com.comcast.playerplatform.primetime.android.asset.Asset asset = stateController.createAsset();
        if (asset == null)
        {
            transitionToState(new ErrorState(stateController, stateController.getActivityContext().getString(com.xfinity.playerlib.R.string.video_playback_error_msg_default)));
            return;
        } else
        {
            stateController.getMediaPlayer().prepare(asset, Long.valueOf(l));
            return;
        }
    }

    public String getStateName()
    {
        return "PlayerPreparingState";
    }

    public void onAcquiringLicense(String s)
    {
        stateController.getUiController().setLaunchScreenMessage(com.xfinity.playerlib.R.string.player_launch_acquiring_license);
    }

    public void onMediaOpened(String s, String s1, List list, List list1, long l, long l1, double d, boolean flag)
    {
    }

    public void onPlayStateChanged(PlayerStatus playerstatus)
    {
        if (playerstatus != PlayerStatus.PREPARED) goto _L2; else goto _L1
_L1:
        if (stateController.getLiveStream() == null)
        {
            stateController.getUiController().setupAdBreaks(stateController.getMediaPlayer().getTimeline());
        }
        if (!stateController.getAndroidDevice().wantsStaticBitrate() && !((PlayerUserSettings)stateController.getUserManager().getUserSettings()).getWantsStaticBitrate()) goto _L4; else goto _L3
_L3:
        lockBitrate();
_L6:
        return;
_L4:
        if (!stateController.getMediaPlayer().getAutoPlay())
        {
            stateController.getMediaPlayer().play();
            stateController.getUiController().hideSpinner();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (playerstatus == PlayerStatus.PAUSED)
        {
            stateController.getMediaPlayer().play();
            return;
        }
        if (playerstatus == PlayerStatus.PLAYING)
        {
            stateController.getUiController().setVideoDuration(stateController.getMediaPlayer().getDuration());
            stateController.getUiController().hideLaunchScreen();
            com.xfinity.playerlib.view.videoplay.VideoPlayerFragment.PlayerUIController playeruicontroller;
            int i;
            boolean flag;
            boolean flag1;
            if (!stateController.hasPreroll())
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                stateController.getUiController().startRatingsBug();
                stateController.getUiController().startMainControlTimeout();
                stateController.getUiController().showMainControlsWithPauseButton();
            }
            if (stateController.getDownloadedFile() == null)
            {
                stateController.scheduleAmsContinueCalls();
            }
            stateController.getUiController().styleClosedCaptions();
            if (stateController.isCC())
            {
                stateController.getUiController().setCCButtonVisibility(0);
                stateController.getUiController().setCCButtonEnabled(true);
                if (((PlayerUserSettings)stateController.getUserManager().getUserSettings()).getWantsClosedCaptions() && stateController.getMediaPlayer().hasCC())
                {
                    stateController.getMediaPlayer().setCCEnabled(true);
                    stateController.getUiController().setCCButtonSelected(true);
                }
            } else
            if (stateController.isLiveStream())
            {
                stateController.getUiController().setCCButtonVisibility(0);
                stateController.getUiController().setCCButtonEnabled(false);
            } else
            {
                stateController.getUiController().setCCButtonVisibility(8);
            }
            playerstatus = stateController.getMediaPlayer().getAvailableLanguages();
            if (playerstatus.size() > 1)
            {
                stateController.getUiController().setSAPButtonVisibility(0);
                stateController.getUiController().setSAPButtonEnabled(true);
                i = ((PlayerUserSettings)stateController.getUserManager().getUserSettings()).getAudioTrackIndex();
                if (i >= 0 && playerstatus.size() > i)
                {
                    stateController.getMediaPlayer().setLanguage(i);
                    stateController.getUiController().setSAPButtonSelected(true);
                }
            } else
            if (stateController.isLiveStream())
            {
                stateController.getUiController().setSAPButtonVisibility(0);
                stateController.getUiController().setSAPButtonEnabled(false);
            } else
            {
                stateController.getUiController().setSAPButtonVisibility(8);
            }
            stateController.transitionToState(new PlaybackState(stateController));
            if (stateController.isLiveStream())
            {
                stateController.getVideoTrackController().trackOmnitureLiveStreamStartedMilestone();
            }
            playeruicontroller = stateController.getUiController();
            flag1 = stateController.isCC();
            if (playerstatus.size() > 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            playeruicontroller.announceSapAndCcStates(flag1, flag);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void run()
    {
        if (stateController.getMediaPlayer().getPlayerStatus() == PlayerStatus.IDLE)
        {
            preparePlayer();
            return;
        } else
        {
            onPlayStateChanged(stateController.getMediaPlayer().getPlayerStatus());
            return;
        }
    }

    public void transitionToState(VideoState videostate)
    {
        if (videostate instanceof PlaybackState)
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
