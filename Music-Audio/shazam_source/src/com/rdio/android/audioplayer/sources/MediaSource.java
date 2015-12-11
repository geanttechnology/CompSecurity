// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.sources;

import com.rdio.android.audioplayer.io.AudioStream;

// Referenced classes of package com.rdio.android.audioplayer.sources:
//            MediaSourceCallbacks

public interface MediaSource
{
    public static class InvalidStreamException extends Exception
    {

        public InvalidStreamException(String s)
        {
            super(s);
        }
    }

    public static final class SeekOrigin extends Enum
    {

        private static final SeekOrigin $VALUES[];
        public static final SeekOrigin Begin;
        public static final SeekOrigin Current;
        public static final SeekOrigin End;

        public static SeekOrigin valueOf(String s)
        {
            return (SeekOrigin)Enum.valueOf(com/rdio/android/audioplayer/sources/MediaSource$SeekOrigin, s);
        }

        public static SeekOrigin[] values()
        {
            return (SeekOrigin[])$VALUES.clone();
        }

        static 
        {
            Begin = new SeekOrigin("Begin", 0);
            Current = new SeekOrigin("Current", 1);
            End = new SeekOrigin("End", 2);
            $VALUES = (new SeekOrigin[] {
                Begin, Current, End
            });
        }

        private SeekOrigin(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class WaitStatus extends Enum
    {

        private static final WaitStatus $VALUES[];
        public static final WaitStatus Cancelled;
        public static final WaitStatus Success;
        public static final WaitStatus TimedOut;

        public static WaitStatus valueOf(String s)
        {
            return (WaitStatus)Enum.valueOf(com/rdio/android/audioplayer/sources/MediaSource$WaitStatus, s);
        }

        public static WaitStatus[] values()
        {
            return (WaitStatus[])$VALUES.clone();
        }

        static 
        {
            Success = new WaitStatus("Success", 0);
            TimedOut = new WaitStatus("TimedOut", 1);
            Cancelled = new WaitStatus("Cancelled", 2);
            $VALUES = (new WaitStatus[] {
                Success, TimedOut, Cancelled
            });
        }

        private WaitStatus(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract void addCallbacksListener(MediaSourceCallbacks mediasourcecallbacks);

    public abstract com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType blockingGetMediaType();

    public abstract void cancelWait();

    public abstract void destroy();

    public abstract int getBitRate();

    public abstract int getBufferedPercent();

    public abstract long getBytesBuffered();

    public abstract long getBytesRead();

    public abstract long getCurrDataSize();

    public abstract double getDuration();

    public abstract com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType getMediaType();

    public abstract boolean getWaitForStreamLoad();

    public abstract boolean hasStream(AudioStream audiostream);

    public abstract boolean isFullyConsumed();

    public abstract boolean isInUse();

    public abstract boolean isValid();

    public abstract boolean isWaitingForStreamToLoad();

    public abstract byte readByte();

    public abstract int readByteAsInt();

    public abstract int readBytes(byte abyte0[], int i, int j);

    public abstract long readLong();

    public abstract String readString(int i);

    public abstract long readUInt();

    public abstract long readUInt(int i);

    public abstract int readUShort();

    public abstract void removeCallbacksListener(MediaSourceCallbacks mediasourcecallbacks);

    public abstract int seek(int i, SeekOrigin seekorigin);

    public abstract long seekBytes(long l, SeekOrigin seekorigin);

    public abstract void setIsInUse(boolean flag);

    public abstract void setWaitForStreamLoad(boolean flag);

    public abstract void updateMediaBitrate(int i);

    public abstract void updateMediaDuration(long l);

    public abstract void updateMediaInfo(com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType mediatype, int i, long l);

    public abstract void updateMediaType(com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType mediatype);

    public abstract WaitStatus waitForData(long l, int i);

    public abstract WaitStatus waitForData(long l, long l1, int i, int j);
}
