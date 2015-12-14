// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.transcoder;

import android.media.MediaMetadataRetriever;
import java.io.File;
import java.text.MessageFormat;
import org.apache.commons.io.FileUtils;

public class VideoProperties
{

    private static final String TAG = com/amazon/gallery/framework/transcoder/VideoProperties.getName();
    private final long duration;
    private final int height;
    private final int videoBitrate;
    private final long videoSize;
    private final int width;

    public VideoProperties(String s)
    {
        MediaMetadataRetriever mediametadataretriever;
        mediametadataretriever = new MediaMetadataRetriever();
        mediametadataretriever.setDataSource(s);
        width = Integer.parseInt(mediametadataretriever.extractMetadata(18));
        height = Integer.parseInt(mediametadataretriever.extractMetadata(19));
        videoBitrate = Integer.parseInt(mediametadataretriever.extractMetadata(20));
        duration = Long.parseLong(mediametadataretriever.extractMetadata(9));
        videoSize = FileUtils.sizeOf(new File(s));
        mediametadataretriever.release();
        return;
        s;
        mediametadataretriever.release();
        throw s;
    }

    public long getDuration()
    {
        return duration;
    }

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }

    public String toString()
    {
        return MessageFormat.format("Video: [width: {0}; height: {1}; video bitrate: {2}; video duration: {3}, video size: {4}]", new Object[] {
            Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(videoBitrate), Long.valueOf(duration), Long.valueOf(videoSize)
        });
    }

}
