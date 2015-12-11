// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.videoplay.PlayerActionBarMenuType;
import com.xfinity.playerlib.view.videoplay.PlayerPlatformMediaPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            AdEnabledState, VideoStateController, PlaybackState, InfoPanelState, 
//            MobileDataWarningState, VideoState

public class InfoDetailState extends AdEnabledState
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/videoplay/adobeplayer/InfoDetailState);
    private VideoBookmark bookmark;
    private int depthNumber;
    private VideoFavorite favorite;
    private VideoState previousState;
    private String transactionTag;
    private PlayerActionBarMenuType type;
    private SeriesWatchable watchable;

    public InfoDetailState(VideoStateController videostatecontroller, VideoState videostate, PlayerActionBarMenuType playeractionbarmenutype, VideoBookmark videobookmark)
    {
        super(videostatecontroller);
        depthNumber = 1;
        watchable = null;
        bookmark = null;
        favorite = null;
        bookmark = videobookmark;
        previousState = videostate;
        type = playeractionbarmenutype;
        setTransactionInfo();
    }

    public InfoDetailState(VideoStateController videostatecontroller, VideoState videostate, PlayerActionBarMenuType playeractionbarmenutype, VideoFavorite videofavorite)
    {
        super(videostatecontroller);
        depthNumber = 1;
        watchable = null;
        bookmark = null;
        favorite = null;
        favorite = videofavorite;
        previousState = videostate;
        type = playeractionbarmenutype;
        setTransactionInfo();
    }

    public InfoDetailState(VideoStateController videostatecontroller, VideoState videostate, PlayerActionBarMenuType playeractionbarmenutype, SeriesWatchable serieswatchable)
    {
        super(videostatecontroller);
        depthNumber = 1;
        watchable = null;
        bookmark = null;
        favorite = null;
        watchable = serieswatchable;
        previousState = videostate;
        type = playeractionbarmenutype;
        setTransactionInfo();
    }

    private void backupOneLevel()
    {
        stateController.getUiController().popFragmentFromBackStack(transactionTag);
        stateController.transitionToState(previousState);
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

    private void setTransactionInfo()
    {
        if (previousState instanceof InfoDetailState)
        {
            depthNumber = ((InfoDetailState)previousState).getDepthNumber() + 1;
        }
        transactionTag = (new StringBuilder()).append("InfoDetail").append(depthNumber).toString();
    }

    private void showInfoPanel()
    {
        if (watchable != null)
        {
            stateController.getUiController().showSeriesWatchableDetail(watchable, transactionTag);
        } else
        {
            if (bookmark != null)
            {
                stateController.getUiController().showHistoryItemDetail(bookmark, transactionTag);
                return;
            }
            if (favorite != null)
            {
                stateController.getUiController().showFavoriteDetail(favorite, transactionTag);
                return;
            }
        }
    }

    public void adBreakStart(VideoAdBreak videoadbreak, VideoAd videoad)
    {
        super.adBreakStart(videoadbreak, videoad);
        exitInfoPanel();
    }

    public int getDepthNumber()
    {
        return depthNumber;
    }

    public String getStateName()
    {
        return (new StringBuilder()).append("InfoDetailState").append(depthNumber).toString();
    }

    public void onBabyGuideButton()
    {
        if (type != PlayerActionBarMenuType.BABY_GUIDE)
        {
            stateController.transitionToState(new InfoPanelState(stateController, PlayerActionBarMenuType.BABY_GUIDE));
        }
    }

    public void onBackButton()
    {
        backupOneLevel();
    }

    public void onFavoritesButton()
    {
        if (type != PlayerActionBarMenuType.FAVORITE)
        {
            stateController.transitionToState(new InfoPanelState(stateController, PlayerActionBarMenuType.FAVORITE));
        }
    }

    public void onHistoryButton()
    {
        if (type != PlayerActionBarMenuType.HISTORY)
        {
            stateController.transitionToState(new InfoPanelState(stateController, PlayerActionBarMenuType.HISTORY));
        }
    }

    public void onNewVideoPlayOrResumeSelected(VideoFacade videofacade, Watchable watchable1)
    {
        stateController.setVideoAndWatchable(videofacade, watchable1);
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
        showInfoPanel();
        super.run();
    }

    public void transitionToState(VideoState videostate)
    {
        if ((videostate instanceof InfoDetailState) || (videostate instanceof InfoPanelState) || (videostate instanceof PlaybackState) || (videostate instanceof MobileDataWarningState))
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
