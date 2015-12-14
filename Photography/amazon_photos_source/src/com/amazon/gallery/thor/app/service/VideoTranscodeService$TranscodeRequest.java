// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.service;

import com.amazon.gallery.framework.model.media.Video;
import java.io.File;
import java.util.UUID;
import org.apache.commons.lang3.Validate;

// Referenced classes of package com.amazon.gallery.thor.app.service:
//            VideoTranscodeService

public static class <init>
{
    public static final class Builder
    {

        private int audioCodec;
        private int endTime;
        private long maxFileSize;
        private File outputFile;
        private int startTime;
        private Video video;
        private int videoCodec;
        private int videoContainer;

        public VideoTranscodeService.TranscodeRequest build()
        {
            Validate.notNull(outputFile);
            return new VideoTranscodeService.TranscodeRequest(video, startTime, endTime, maxFileSize, outputFile, videoContainer, audioCodec, videoCodec, null);
        }

        public Builder withBounds(int i, int j)
        {
            Validate.inclusiveBetween(0L, j + 1, i);
            Validate.inclusiveBetween(i, (int)video.getDuration(), j);
            startTime = i;
            endTime = j;
            return this;
        }

        public Builder withMaxFileSize(long l)
        {
            Validate.inclusiveBetween(0L, 0x7fffffffffffffffL, l);
            maxFileSize = l;
            return this;
        }

        public Builder withOutputFile(File file)
        {
            outputFile = (File)Validate.notNull(file);
            return this;
        }

        public Builder withVideoContainer(VideoTranscodeService.Container container)
        {
label0:
            {
                if (container != null)
                {
                    videoContainer = container.code;
                    switch (VideoTranscodeService._cls5.$SwitchMap$com$amazon$gallery$thor$app$service$VideoTranscodeService$Container[container.ordinal()])
                    {
                    default:
                        videoCodec = 2;
                        audioCodec = 1;
                        break;

                    case 1: // '\001'
                        break label0;
                    }
                }
                return this;
            }
            videoCodec = 2;
            audioCodec = 2;
            return this;
        }

        public Builder(Video video1)
        {
            videoContainer = VideoTranscodeService.Container.FORMAT_MP4.code;
            videoCodec = 2;
            audioCodec = 1;
            maxFileSize = 0x500000L;
            video = (Video)Validate.notNull(video1);
            startTime = 0;
            endTime = (int)(video1.getDuration() / 1000L);
        }
    }


    private final int audioCodec;
    private final int duration;
    private final int endTime;
    private final String id;
    private long maxFileSize;
    private final File outputFile;
    private final int startTime;
    private final Video video;
    private final int videoCodec;
    private final int videoContainer;
    private id workState;

    public String getId()
    {
        return id;
    }










    private Builder.endTime(Video video1, int i, int j, long l, File file, int k, 
            int i1, int j1)
    {
        id = UUID.randomUUID().toString();
        video = video1;
        startTime = i;
        endTime = j;
        duration = j - i;
        workState = RTED;
        outputFile = file;
        maxFileSize = l;
        videoContainer = k;
        audioCodec = i1;
        videoCodec = j1;
    }

    videoCodec(Video video1, int i, int j, long l, File file, int k, 
            int i1, int j1, videoCodec videocodec)
    {
        this(video1, i, j, l, file, k, i1, j1);
    }
}
