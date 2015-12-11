// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.state;

import tv.freewheel.ad.VideoAsset;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.ad.state:
//            VideoState, VideoEndedState

public class VideoPlayingState extends VideoState
{

    private static final VideoPlayingState instance = new VideoPlayingState();

    public VideoPlayingState()
    {
    }

    public static VideoState Instance()
    {
        return instance;
    }

    public void stop(VideoAsset videoasset)
    {
        logger.debug("stop");
        videoasset.state = VideoEndedState.Instance();
        videoasset.onStopPlay();
    }

}
