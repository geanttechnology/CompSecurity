// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.io;


// Referenced classes of package com.rdio.android.audioplayer.io:
//            AudioStreamCallbacks

public abstract class AudioStream
{
    public static class InvalidOperationException extends RuntimeException
    {

        public InvalidOperationException(String s)
        {
            super(s);
        }
    }


    protected AudioStreamCallbacks callbacks;

    public AudioStream(AudioStreamCallbacks audiostreamcallbacks)
    {
        callbacks = audiostreamcallbacks;
    }

    public abstract void cancel();

    public abstract int getBufferedPercent();

    public abstract long getBytesBuffered();

    public abstract long getTotalLength();

    public abstract boolean isCancelled();

    public abstract boolean isFullyLoaded();

    public abstract boolean isSeekBeyondBuffer(long l, com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin seekorigin);

    public abstract boolean isSeekReverse(long l, com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin seekorigin);

    public abstract boolean reverseSeekingSupported();

    public abstract long seek(long l, com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin seekorigin);
}
