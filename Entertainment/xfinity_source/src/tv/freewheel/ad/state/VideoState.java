// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.state;

import tv.freewheel.ad.VideoAsset;
import tv.freewheel.utils.Logger;

public class VideoState
{

    protected Logger logger;

    public VideoState()
    {
        logger = Logger.getLogger(this);
    }

    public void play(VideoAsset videoasset)
    {
        logger.warn("invalid action: play");
    }

    public void stop(VideoAsset videoasset)
    {
        logger.warn("invalid action: stop");
    }
}
