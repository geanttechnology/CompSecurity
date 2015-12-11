// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.lifevibes.videoeditor;

import android.graphics.Bitmap;
import java.io.IOException;

// Referenced classes of package com.lifevibes.videoeditor:
//            BaseMediaItem, VideoEditor

public abstract class MediaItem extends BaseMediaItem
{
    public static interface GetThumbnailListCallback
    {

        public abstract void onThumbnail(Bitmap bitmap, int i, int j);
    }


    public static final int END_OF_FILE = -1;
    public static final int RENDERING_MODE_BLACK_BORDER = 0;
    public static final int RENDERING_MODE_CROPPING = 2;
    public static final int RENDERING_MODE_STRETCH = 1;
    private final String mProjectPath;
    private int mRenderingMode;

    protected MediaItem(VideoEditor videoeditor, String s, String s1, int i)
        throws IOException
    {
        super(videoeditor, s, s1);
        mRenderingMode = i;
        mProjectPath = videoeditor.getPath();
    }

    public abstract int getAspectRatio();

    public abstract int getHeight();

    public int getRenderingMode()
    {
        return mRenderingMode;
    }

    public abstract int getWidth();

    public void setRenderingMode(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException("Invalid Rendering Mode");

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
            mRenderingMode = i;
            break;
        }
    }
}
