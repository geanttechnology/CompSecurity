// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.gifdecoder;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.bumptech.glide.gifdecoder:
//            GifFrame

public class GifHeader
{

    int bgColor;
    int bgIndex;
    GifFrame currentFrame;
    int frameCount;
    List frames;
    int gct[];
    boolean gctFlag;
    int gctSize;
    int height;
    int loopCount;
    int pixelAspect;
    int status;
    int width;

    public GifHeader()
    {
        gct = null;
        status = 0;
        frameCount = 0;
        frames = new ArrayList();
    }

    public int getNumFrames()
    {
        return frameCount;
    }

    public int getStatus()
    {
        return status;
    }
}
