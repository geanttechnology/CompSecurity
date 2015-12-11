// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.state;

import tv.freewheel.ad.VideoAsset;
import tv.freewheel.ad.handler.VideoViewCallbackHandler;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.ad.state:
//            VideoState, VideoPlayingState

public class VideoEndedState extends VideoState
{

    private static final VideoEndedState instance = new VideoEndedState();

    public VideoEndedState()
    {
    }

    public static VideoState Instance()
    {
        return instance;
    }

    public void play(VideoAsset videoasset)
    {
        logger.debug("play");
        videoasset.callbackHandler.replay = true;
        videoasset.onStartPlay();
        videoasset.state = VideoPlayingState.Instance();
    }

}
