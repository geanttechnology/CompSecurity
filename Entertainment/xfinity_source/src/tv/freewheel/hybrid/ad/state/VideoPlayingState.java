// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.state;


// Referenced classes of package tv.freewheel.hybrid.ad.state:
//            VideoState

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

}
