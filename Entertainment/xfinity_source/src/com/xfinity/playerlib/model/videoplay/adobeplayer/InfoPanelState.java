// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.model.videoplay.PlayerActionBarMenuType;
import com.xfinity.playerlib.view.videoplay.PlayerPlatformMediaPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            AdEnabledState, VideoStateController, PlaybackState, InfoDetailState, 
//            MobileDataWarningState, VideoState

public class InfoPanelState extends AdEnabledState
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/videoplay/adobeplayer/InfoPanelState);
    boolean showHasForcedBackground;
    private String transactionTag;
    private PlayerActionBarMenuType type;

    public InfoPanelState(VideoStateController videostatecontroller, PlayerActionBarMenuType playeractionbarmenutype)
    {
        super(videostatecontroller);
        transactionTag = "InfoPanel";
        showHasForcedBackground = false;
        type = playeractionbarmenutype;
    }

    private void exitInfoPanel()
    {
        stateController.getUiController().clearBackStack();
        stateController.getUiController().hideInfoPanel();
        if (stateController.isAdPlaying()) goto _L2; else goto _L1
_L1:
        if (stateController.getMediaPlayer().getPlayerStatus() != PlayerStatus.PAUSED) goto _L4; else goto _L3
_L3:
        stateController.getUiController().showMainControlsWithPlayButton();
_L2:
        stateController.transitionToState(new PlaybackState(stateController));
        return;
_L4:
        if (stateController.getMediaPlayer().getPlayerStatus() == PlayerStatus.PLAYING)
        {
            stateController.getUiController().showMainControlsWithPauseButton();
            stateController.getUiController().startMainControlTimeout();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private void showInfoPanel()
    {
        if (type != PlayerActionBarMenuType.BABY_GUIDE) goto _L2; else goto _L1
_L1:
        showHasForcedBackground = stateController.getUiController().showCurrentVideoInfo(transactionTag);
_L4:
        stateController.getUiController().removeMainControlTimeout();
        stateController.getUiController().hideMainControls();
        return;
_L2:
        if (type == PlayerActionBarMenuType.HISTORY)
        {
            showHasForcedBackground = stateController.getUiController().showHistory(transactionTag);
        } else
        if (type == PlayerActionBarMenuType.FAVORITE)
        {
            showHasForcedBackground = stateController.getUiController().showFavorite(transactionTag);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void adBreakStart(VideoAdBreak videoadbreak, VideoAd videoad)
    {
        super.adBreakStart(videoadbreak, videoad);
        exitInfoPanel();
    }

    public String getStateName()
    {
        return "InfoPanelState";
    }

    public void onBabyGuideButton()
    {
        if (type != PlayerActionBarMenuType.BABY_GUIDE)
        {
            type = PlayerActionBarMenuType.BABY_GUIDE;
            showInfoPanel();
        }
    }

    public void onBackButton()
    {
        exitInfoPanel();
    }

    public void onFavoriteItemDetailSelected(VideoFavorite videofavorite)
    {
        stateController.transitionToState(new InfoDetailState(stateController, this, type, videofavorite));
    }

    public void onFavoritesButton()
    {
        if (type != PlayerActionBarMenuType.FAVORITE)
        {
            type = PlayerActionBarMenuType.FAVORITE;
            showInfoPanel();
        }
    }

    public void onHistoryButton()
    {
        if (type != PlayerActionBarMenuType.HISTORY)
        {
            type = PlayerActionBarMenuType.HISTORY;
            showInfoPanel();
        }
    }

    public void onHistoryItemDetailSelected(VideoBookmark videobookmark)
    {
        stateController.transitionToState(new InfoDetailState(stateController, this, type, videobookmark));
    }

    public void onLiveStreamPlaySelected(HalLiveStream hallivestream)
    {
        stateController.setLiveStream(hallivestream);
        stateController.reset();
    }

    public void onLiveStreamPlaySelected(String s)
    {
        Intent intent = stateController.getActivityContext().getIntent();
        Bundle bundle = new Bundle();
        bundle.putString("liveStreamID", s);
        intent.replaceExtras(bundle);
        stateController.getActivityContext().setIntent(intent);
        stateController.resetVideoAndWatchable();
        stateController.resetLiveStream();
        stateController.reset();
    }

    public void onNewVideoPlayOrResumeSelected(VideoBookmark videobookmark)
    {
        Intent intent = stateController.getActivityContext().getIntent();
        Bundle bundle = new Bundle();
        if (videobookmark.isMovie())
        {
            bundle.putSerializable("merlinId", videobookmark.getMerlinId());
        } else
        {
            bundle.putLong("videoId", videobookmark.getVideoId());
            bundle.putSerializable("parentMerlinId", videobookmark.getParentMerlinIdIfApplicable());
        }
        bundle.putLong("companyId", videobookmark.getCompanyId());
        intent.replaceExtras(bundle);
        stateController.getActivityContext().setIntent(intent);
        stateController.resetVideoAndWatchable();
        stateController.resetLiveStream();
        stateController.reset();
    }

    public void onNewVideoPlayOrResumeSelected(VideoFacade videofacade, Watchable watchable)
    {
        super.onNewVideoPlayOrResumeSelected(videofacade, watchable);
        stateController.setVideoAndWatchable(videofacade, watchable);
        stateController.resetLiveStream();
        stateController.reset();
    }

    public void onScreenTouch()
    {
        exitInfoPanel();
    }

    public void onSeriesWatchableDetailSelected(SeriesWatchable serieswatchable)
    {
        stateController.transitionToState(new InfoDetailState(stateController, this, type, serieswatchable));
    }

    public void onVolumeChanged()
    {
        stateController.getUiController().startVolumeControlTimeout();
    }

    public void run()
    {
        if (showHasForcedBackground)
        {
            stateController.transitionToState(new PlaybackState(stateController));
        } else
        {
            showInfoPanel();
        }
        super.run();
    }

    public void transitionToState(VideoState videostate)
    {
        if ((videostate instanceof PlaybackState) || (videostate instanceof InfoDetailState) || (videostate instanceof MobileDataWarningState))
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
