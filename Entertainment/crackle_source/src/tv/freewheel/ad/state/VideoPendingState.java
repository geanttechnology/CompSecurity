// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.state;

import tv.freewheel.ad.VideoAsset;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.ad.state:
//            VideoState, VideoPausedState, VideoPlayingState, VideoEndedState

public class VideoPendingState extends VideoState
{

    private static final VideoPendingState instance = new VideoPendingState();

    public VideoPendingState()
    {
    }

    public static VideoState Instance()
    {
        return instance;
    }

    public void pause(VideoAsset videoasset)
    {
        logger.debug("pause");
        videoasset.state = VideoPausedState.Instance();
        videoasset.onPausePlay();
    }

    public void play(VideoAsset videoasset)
    {
        logger.debug("play");
        if (videoasset.isReadyToStart())
        {
            videoasset.state = VideoPlayingState.Instance();
            videoasset.onStartPlay();
        }
    }

    public void stop(VideoAsset videoasset)
    {
        logger.debug("stop");
        videoasset.state = VideoEndedState.Instance();
        videoasset.onStopPlay();
    }

}
