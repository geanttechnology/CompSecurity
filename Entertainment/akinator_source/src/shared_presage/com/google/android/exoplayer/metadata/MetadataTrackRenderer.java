// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import java.nio.ByteBuffer;
import shared_presage.com.google.android.exoplayer.ExoPlaybackException;
import shared_presage.com.google.android.exoplayer.MediaFormatHolder;
import shared_presage.com.google.android.exoplayer.SampleHolder;
import shared_presage.com.google.android.exoplayer.SampleSource;
import shared_presage.com.google.android.exoplayer.TrackInfo;
import shared_presage.com.google.android.exoplayer.TrackRenderer;
import shared_presage.com.google.android.exoplayer.util.Assertions;

// Referenced classes of package shared_presage.com.google.android.exoplayer.metadata:
//            MetadataParser

public final class MetadataTrackRenderer extends TrackRenderer
    implements android.os.Handler.Callback
{
    public static interface MetadataRenderer
    {

        public abstract void onMetadata(Object obj);
    }


    private static final int MSG_INVOKE_RENDERER = 0;
    private final MediaFormatHolder formatHolder = new MediaFormatHolder();
    private boolean inputStreamEnded;
    private final Handler metadataHandler;
    private final MetadataParser metadataParser;
    private final MetadataRenderer metadataRenderer;
    private Object pendingMetadata;
    private long pendingMetadataTimestamp;
    private final SampleHolder sampleHolder = new SampleHolder(1);
    private final shared_presage.com.google.android.exoplayer.SampleSource.SampleSourceReader source;
    private int trackIndex;

    public MetadataTrackRenderer(SampleSource samplesource, MetadataParser metadataparser, MetadataRenderer metadatarenderer, Looper looper)
    {
        source = samplesource.register();
        metadataParser = (MetadataParser)Assertions.checkNotNull(metadataparser);
        metadataRenderer = (MetadataRenderer)Assertions.checkNotNull(metadatarenderer);
        if (looper == null)
        {
            samplesource = null;
        } else
        {
            samplesource = new Handler(looper, this);
        }
        metadataHandler = samplesource;
    }

    private void invokeRenderer(Object obj)
    {
        if (metadataHandler != null)
        {
            metadataHandler.obtainMessage(0, obj).sendToTarget();
            return;
        } else
        {
            invokeRendererInternal(obj);
            return;
        }
    }

    private void invokeRendererInternal(Object obj)
    {
        metadataRenderer.onMetadata(obj);
    }

    private void seekToInternal()
    {
        pendingMetadata = null;
        inputStreamEnded = false;
    }

    protected final int doPrepare(long l)
    {
        int i = 0;
        if (!source.prepare(l))
        {
            return 0;
        }
        for (int j = source.getTrackCount(); i < j; i++)
        {
            if (metadataParser.canParse(source.getTrackInfo(i).mimeType))
            {
                trackIndex = i;
                return 1;
            }
        }

        return -1;
    }

    protected final void doSomeWork(long l, long l1)
    {
        source.continueBuffering(trackIndex, l);
        if (inputStreamEnded || pendingMetadata != null) goto _L2; else goto _L1
_L1:
        int i = source.readData(trackIndex, l, formatHolder, sampleHolder, false);
        if (i != -3) goto _L4; else goto _L3
_L3:
        pendingMetadataTimestamp = sampleHolder.timeUs;
        try
        {
            pendingMetadata = metadataParser.parse(sampleHolder.data.array(), sampleHolder.size);
        }
        catch (IOException ioexception)
        {
            throw new ExoPlaybackException(ioexception);
        }
        sampleHolder.data.clear();
_L2:
        if (pendingMetadata != null && pendingMetadataTimestamp <= l)
        {
            invokeRenderer(pendingMetadata);
            pendingMetadata = null;
        }
        return;
_L4:
        if (i == -1)
        {
            inputStreamEnded = true;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected final long getBufferedPositionUs()
    {
        return -3L;
    }

    protected final long getDurationUs()
    {
        return source.getTrackInfo(trackIndex).durationUs;
    }

    public final boolean handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return false;

        case 0: // '\0'
            invokeRendererInternal(message.obj);
            break;
        }
        return true;
    }

    protected final boolean isEnded()
    {
        return inputStreamEnded;
    }

    protected final boolean isReady()
    {
        return true;
    }

    protected final void maybeThrowError()
    {
        try
        {
            source.maybeThrowError();
            return;
        }
        catch (IOException ioexception)
        {
            throw new ExoPlaybackException(ioexception);
        }
    }

    protected final void onDisabled()
    {
        pendingMetadata = null;
        source.disable(trackIndex);
    }

    protected final void onEnabled(long l, boolean flag)
    {
        source.enable(trackIndex, l);
        seekToInternal();
    }

    protected final void seekTo(long l)
    {
        source.seekToUs(l);
        seekToInternal();
    }
}
