// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.lifevibes.videoeditor;

import java.io.IOException;

// Referenced classes of package com.lifevibes.videoeditor:
//            MediaItem

public interface VideoEditor
{
    public static interface ExportProgressListener
    {

        public abstract void onProgress(VideoEditor videoeditor, String s, int i);
    }


    public static final int DURATION_OF_STORYBOARD = -1;
    public static final long MAX_SUPPORTED_FILE_SIZE = 0x80000000L;

    public abstract void addMediaItem(MediaItem mediaitem);

    public abstract void cancelExport(String s);

    public abstract void export(String s, int i, int j, int k, int l, ExportProgressListener exportprogresslistener)
        throws IOException, IllegalStateException;

    public abstract int getAspectRatio();

    public abstract String getPath();

    public abstract void release();

    public abstract void setAspectRatio(int i);
}
