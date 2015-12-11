// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.state;

import tv.freewheel.ad.VideoAsset;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.ad.state:
//            VideoState, VideoPlayingState, VideoEndedState

public class VideoPausedState extends VideoState
{

    private static final VideoPausedState instance = new VideoPausedState();

    public VideoPausedState()
    {
    }

    public static VideoState Instance()
    {
        return instance;
    }

    public void play(VideoAsset videoasset)
    {
        logger.debug("play");
        videoasset.state = VideoPlayingState.Instance();
        videoasset.onResumePlay();
    }

    public void stop(VideoAsset videoasset)
    {
        logger.debug("stop");
        videoasset.state = VideoEndedState.Instance();
        videoasset.onStopPlay();
    }

}
