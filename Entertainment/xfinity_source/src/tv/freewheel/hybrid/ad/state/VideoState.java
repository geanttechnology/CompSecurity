// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.state;

import tv.freewheel.hybrid.ad.VideoAsset;
import tv.freewheel.hybrid.utils.Logger;

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
}
