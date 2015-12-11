// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.state;

import tv.freewheel.hybrid.ad.VideoAsset;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.ad.state:
//            VideoState, VideoPlayingState, VideoPendingState

public class VideoInitState extends VideoState
{

    private static final VideoInitState instance = new VideoInitState();

    public VideoInitState()
    {
    }

    public static VideoState Instance()
    {
        return instance;
    }

    public void play(VideoAsset videoasset)
    {
        logger.debug("play");
        if (videoasset.isReadyToStart())
        {
            videoasset.state = VideoPlayingState.Instance();
            videoasset.onStartPlay();
            return;
        } else
        {
            videoasset.state = VideoPendingState.Instance();
            return;
        }
    }

}
