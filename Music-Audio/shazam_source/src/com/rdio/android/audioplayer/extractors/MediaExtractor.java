// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.extractors;

import com.rdio.android.audioplayer.io.MediaBuffer;
import com.rdio.android.audioplayer.sources.MediaSource;

// Referenced classes of package com.rdio.android.audioplayer.extractors:
//            MediaFormat

public interface MediaExtractor
{
    public static class InvalidSourceException extends Exception
    {

        public InvalidSourceException(String s)
        {
            super(s);
        }
    }

    public static class MediaParseException extends RuntimeException
    {

        public MediaParseException(String s)
        {
            super(s);
        }
    }


    public abstract boolean advance();

    public abstract void cancelIfWaiting();

    public abstract MediaSource getMediaSource();

    public abstract long getSampleTime();

    public abstract boolean getTrackFormat(int i, MediaFormat mediaformat);

    public abstract int readSampleData(MediaBuffer mediabuffer, int i);

    public abstract void releaseDataSource();

    public abstract int seek(int i, com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin seekorigin);

    public abstract void selectTrack(int i);

    public abstract void setDataSource(MediaSource mediasource);
}
