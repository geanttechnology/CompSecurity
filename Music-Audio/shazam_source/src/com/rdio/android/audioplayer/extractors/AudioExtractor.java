// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.extractors;

import android.util.Log;
import com.rdio.android.audioplayer.io.MediaBuffer;
import com.rdio.android.audioplayer.sources.MediaSource;

// Referenced classes of package com.rdio.android.audioplayer.extractors:
//            MediaExtractor, MediaFormat

public abstract class AudioExtractor
    implements MediaExtractor
{
    public class InvalidHeaderException extends Exception
    {

        final AudioExtractor this$0;

        public InvalidHeaderException(String s)
        {
            this$0 = AudioExtractor.this;
            super(s);
        }
    }

    public class NoProgressOnReadException extends Exception
    {

        final AudioExtractor this$0;

        public NoProgressOnReadException(String s)
        {
            this$0 = AudioExtractor.this;
            super(s);
        }
    }


    private static final String TAG = "AudioExtractor";
    public static final int WAIT_LIMIT_MS = 10000;
    private MediaSource audio_source;

    public AudioExtractor()
    {
        audio_source = null;
    }

    public abstract boolean advance();

    public abstract void cancelIfWaiting();

    public MediaSource getMediaSource()
    {
        return audio_source;
    }

    public abstract long getSampleTime();

    public abstract boolean getTrackFormat(int i, MediaFormat mediaformat);

    protected abstract void onSetDataSource(MediaSource mediasource);

    public abstract int readSampleData(MediaBuffer mediabuffer, int i);

    public void releaseDataSource()
    {
        if (audio_source != null)
        {
            audio_source.setIsInUse(false);
            audio_source = null;
        }
    }

    public abstract int seek(int i, com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin seekorigin);

    public abstract void selectTrack(int i);

    public void setDataSource(MediaSource mediasource)
    {
        if (mediasource != null && mediasource.isValid())
        {
            releaseDataSource();
            audio_source = mediasource;
            audio_source.setIsInUse(true);
            onSetDataSource(mediasource);
            return;
        }
        if ((new StringBuilder("Invalid media source, ")).append(mediasource).toString() != null)
        {
            mediasource = "source is uninitialized";
        } else
        {
            mediasource = "source is null";
        }
        throw new MediaExtractor.InvalidSourceException(mediasource);
    }

    protected boolean waitForData(long l, long l1, int i)
    {
        if (audio_source.isValid()) goto _L2; else goto _L1
_L1:
        Log.e("AudioExtractor", "WaitForData() - AudioStream is null or disposed!");
_L4:
        return false;
_L2:
        com.rdio.android.audioplayer.sources.MediaSource.WaitStatus waitstatus = audio_source.waitForData(l, l1, i, 10000);
        static class _cls1
        {

            static final int $SwitchMap$com$rdio$android$audioplayer$sources$MediaSource$WaitStatus[];

            static 
            {
                $SwitchMap$com$rdio$android$audioplayer$sources$MediaSource$WaitStatus = new int[com.rdio.android.audioplayer.sources.MediaSource.WaitStatus.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$audioplayer$sources$MediaSource$WaitStatus[com.rdio.android.audioplayer.sources.MediaSource.WaitStatus.Cancelled.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$rdio$android$audioplayer$sources$MediaSource$WaitStatus[com.rdio.android.audioplayer.sources.MediaSource.WaitStatus.TimedOut.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$rdio$android$audioplayer$sources$MediaSource$WaitStatus[com.rdio.android.audioplayer.sources.MediaSource.WaitStatus.Success.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.rdio.android.audioplayer.sources.MediaSource.WaitStatus[waitstatus.ordinal()])
        {
        default:
            return true;

        case 2: // '\002'
            throw new NoProgressOnReadException((new StringBuilder("Audio source hasn't fully loaded, size is, ")).append(audio_source.getCurrDataSize()).append(", need ").append(l1).append(" for frame size, timed out after 10000 ms").toString());

        case 1: // '\001'
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
