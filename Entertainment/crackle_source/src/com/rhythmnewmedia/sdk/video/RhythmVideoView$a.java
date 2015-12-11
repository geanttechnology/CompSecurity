// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.video;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.rhythmnewmedia.sdk.video:
//            VideoDataSource, RhythmVideoView

static final class a
    implements VideoDataSource
{

    final List a;

    public final int getNumberOfChannels(RhythmVideoView rhythmvideoview)
    {
        return 1;
    }

    public final int getNumberOfVideosInChannel(RhythmVideoView rhythmvideoview, int i)
    {
        return a.size();
    }

    public final String getVideoTitle(RhythmVideoView rhythmvideoview, int i, int j)
    {
        return ((String[])a.get(j))[1];
    }

    public final String getVideoUrl(RhythmVideoView rhythmvideoview, int i, int j)
    {
        return ((String[])a.get(j))[0];
    }

    ()
    {
        this((byte)0);
    }

    private <init>(byte byte0)
    {
        a = new ArrayList();
    }
}
