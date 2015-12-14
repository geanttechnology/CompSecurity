// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.transcoder;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.media.Video;
import java.text.MessageFormat;

// Referenced classes of package com.amazon.transcoder:
//            TranscodeVideo

public static class start
{

    int audioBitRate;
    private int audioCodec;
    private int containerFormat;
    private String destination;
    private Integer end;
    private String source;
    private int start;
    private Video video;
    int videoBitRate;
    private int videoCodec;
    Integer videoHeight;
    Integer videoWidth;

    private void setSourceVideoMetadata(Video video1, String s)
    {
        MediaMetadataRetriever mediametadataretriever = new MediaMetadataRetriever();
        mediametadataretriever.setDataSource(s);
        if (end == null)
        {
            end = Integer.valueOf(Integer.parseInt(mediametadataretriever.extractMetadata(9)) / 1000);
        }
        if (videoWidth == null)
        {
            videoWidth = Integer.valueOf(Integer.parseInt(mediametadataretriever.extractMetadata(18)));
        }
        if (videoHeight == null)
        {
            videoHeight = Integer.valueOf(Integer.parseInt(mediametadataretriever.extractMetadata(19)));
        }
        mediametadataretriever.release();
        return;
        s;
        GLogger.ex(TranscodeVideo.TAG, "Failed to retrieve metadata from video file. Attempting to retrieve them from video media item...", s);
        if (video1 == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        if (end == null)
        {
            end = Integer.valueOf((int)video1.getDuration());
        }
        if (video1 == null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        if (videoWidth == null)
        {
            videoWidth = Integer.valueOf(video1.getWidth());
        }
        if (video1 == null)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        if (videoHeight == null)
        {
            videoHeight = Integer.valueOf(video1.getHeight());
        }
        mediametadataretriever.release();
        return;
        video1;
        mediametadataretriever.release();
        throw video1;
    }

    public TranscodeVideo build()
    {
        if (TextUtils.isEmpty(source))
        {
            GLogger.e(TranscodeVideo.TAG, "Must provide a path to the source video", new Object[0]);
            return null;
        }
        if (TextUtils.isEmpty(destination))
        {
            GLogger.e(TranscodeVideo.TAG, "Must provide a destination path for the transcoded video", new Object[0]);
            return null;
        } else
        {
            setSourceVideoMetadata(video, source);
            return new TranscodeVideo(this, null);
        }
    }

    public String toString()
    {
        return MessageFormat.format("[source: {0}; destination: {1}; videoBitRate: {2}; audioBitRate: {3}; videoWidth: {4}; videoHeight: {5}; start: {6}; end: {7}]", new Object[] {
            source, destination, Integer.valueOf(videoBitRate), Integer.valueOf(audioBitRate), videoWidth, videoHeight, Integer.valueOf(start), end
        });
    }

    public end withAudioBitRate(int i)
    {
        audioBitRate = i;
        return this;
    }

    public audioBitRate withAudioCodec(int i)
    {
        audioCodec = i;
        return this;
    }

    public audioCodec withContainer(int i)
    {
        containerFormat = i;
        return this;
    }

    public containerFormat withDestination(String s)
    {
        destination = s;
        return this;
    }

    public destination withEnd(int i)
    {
        if (i > start)
        {
            end = Integer.valueOf(i);
        }
        return this;
    }

    public end withHeight(int i)
    {
        videoHeight = Integer.valueOf(i);
        return this;
    }

    public videoHeight withSource(String s)
    {
        source = s;
        return this;
    }

    public source withStart(int i)
    {
        start = i;
        return this;
    }

    public start withVideoBitRate(int i)
    {
        videoBitRate = i;
        return this;
    }

    public videoBitRate withVideoCodec(int i)
    {
        videoCodec = i;
        return this;
    }

    public videoCodec withWidth(int i)
    {
        videoWidth = Integer.valueOf(i);
        return this;
    }








    public o()
    {
        audioCodec = 1;
        videoCodec = 2;
        containerFormat = 2;
        start = 0;
    }
}
