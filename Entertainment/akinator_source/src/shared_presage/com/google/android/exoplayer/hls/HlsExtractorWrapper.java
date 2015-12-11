// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.hls;

import android.util.SparseArray;
import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.SampleHolder;
import shared_presage.com.google.android.exoplayer.chunk.Format;
import shared_presage.com.google.android.exoplayer.drm.DrmInitData;
import shared_presage.com.google.android.exoplayer.extractor.DefaultTrackOutput;
import shared_presage.com.google.android.exoplayer.extractor.Extractor;
import shared_presage.com.google.android.exoplayer.extractor.ExtractorInput;
import shared_presage.com.google.android.exoplayer.extractor.ExtractorOutput;
import shared_presage.com.google.android.exoplayer.extractor.SeekMap;
import shared_presage.com.google.android.exoplayer.extractor.TrackOutput;
import shared_presage.com.google.android.exoplayer.upstream.Allocator;
import shared_presage.com.google.android.exoplayer.util.Assertions;

public final class HlsExtractorWrapper
    implements ExtractorOutput
{

    private Allocator allocator;
    private final Extractor extractor;
    public final Format format;
    private boolean prepared;
    private final SparseArray sampleQueues = new SparseArray();
    private final boolean shouldSpliceIn;
    private boolean spliceConfigured;
    public final long startTimeUs;
    private volatile boolean tracksBuilt;
    public final int trigger;

    public HlsExtractorWrapper(int i, Format format1, long l, Extractor extractor1, boolean flag)
    {
        trigger = i;
        format = format1;
        startTimeUs = l;
        extractor = extractor1;
        shouldSpliceIn = flag;
    }

    public final void clear()
    {
        for (int i = 0; i < sampleQueues.size(); i++)
        {
            ((DefaultTrackOutput)sampleQueues.valueAt(i)).clear();
        }

    }

    public final void configureSpliceTo(HlsExtractorWrapper hlsextractorwrapper)
    {
        Assertions.checkState(isPrepared());
        if (spliceConfigured || !hlsextractorwrapper.shouldSpliceIn || !hlsextractorwrapper.isPrepared())
        {
            return;
        }
        int j = getTrackCount();
        int i = 0;
        boolean flag;
        boolean flag1;
        for (flag = true; i < j; flag &= flag1)
        {
            flag1 = ((DefaultTrackOutput)sampleQueues.valueAt(i)).configureSpliceTo((DefaultTrackOutput)hlsextractorwrapper.sampleQueues.valueAt(i));
            i++;
        }

        spliceConfigured = flag;
    }

    public final void discardUntil(int i, long l)
    {
        Assertions.checkState(isPrepared());
        ((DefaultTrackOutput)sampleQueues.valueAt(i)).discardUntil(l);
    }

    public final void drmInitData(DrmInitData drminitdata)
    {
    }

    public final void endTracks()
    {
        tracksBuilt = true;
    }

    public final long getLargestParsedTimestampUs()
    {
        long l = 0x8000000000000000L;
        for (int i = 0; i < sampleQueues.size(); i++)
        {
            l = Math.max(l, ((DefaultTrackOutput)sampleQueues.valueAt(i)).getLargestParsedTimestampUs());
        }

        return l;
    }

    public final MediaFormat getMediaFormat(int i)
    {
        Assertions.checkState(isPrepared());
        return ((DefaultTrackOutput)sampleQueues.valueAt(i)).getFormat();
    }

    public final boolean getSample(int i, SampleHolder sampleholder)
    {
        Assertions.checkState(isPrepared());
        return ((DefaultTrackOutput)sampleQueues.valueAt(i)).getSample(sampleholder);
    }

    public final int getTrackCount()
    {
        Assertions.checkState(isPrepared());
        return sampleQueues.size();
    }

    public final boolean hasSamples(int i)
    {
        Assertions.checkState(isPrepared());
        return !((DefaultTrackOutput)sampleQueues.valueAt(i)).isEmpty();
    }

    public final void init(Allocator allocator1)
    {
        allocator = allocator1;
        extractor.init(this);
    }

    public final boolean isPrepared()
    {
        if (!prepared && tracksBuilt)
        {
            for (int i = 0; i < sampleQueues.size(); i++)
            {
                if (!((DefaultTrackOutput)sampleQueues.valueAt(i)).hasFormat())
                {
                    return false;
                }
            }

            prepared = true;
        }
        return prepared;
    }

    public final int read(ExtractorInput extractorinput)
    {
        boolean flag = true;
        int i = extractor.read(extractorinput, null);
        if (i == 1)
        {
            flag = false;
        }
        Assertions.checkState(flag);
        return i;
    }

    public final void seekMap(SeekMap seekmap)
    {
    }

    public final TrackOutput track(int i)
    {
        DefaultTrackOutput defaulttrackoutput = new DefaultTrackOutput(allocator);
        sampleQueues.put(i, defaulttrackoutput);
        return defaulttrackoutput;
    }
}
