// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;

import android.util.SparseArray;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.extractor.DefaultTrackOutput;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.util.Assertions;
import java.io.IOException;

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

    public void clear()
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
        boolean flag = true;
        int j = getTrackCount();
        for (int i = 0; i < j; i++)
        {
            flag &= ((DefaultTrackOutput)sampleQueues.valueAt(i)).configureSpliceTo((DefaultTrackOutput)hlsextractorwrapper.sampleQueues.valueAt(i));
        }

        spliceConfigured = flag;
    }

    public void discardUntil(int i, long l)
    {
        Assertions.checkState(isPrepared());
        ((DefaultTrackOutput)sampleQueues.valueAt(i)).discardUntil(l);
    }

    public void drmInitData(DrmInitData drminitdata)
    {
    }

    public void endTracks()
    {
        tracksBuilt = true;
    }

    public long getLargestParsedTimestampUs()
    {
        long l = 0x8000000000000000L;
        for (int i = 0; i < sampleQueues.size(); i++)
        {
            l = Math.max(l, ((DefaultTrackOutput)sampleQueues.valueAt(i)).getLargestParsedTimestampUs());
        }

        return l;
    }

    public MediaFormat getMediaFormat(int i)
    {
        Assertions.checkState(isPrepared());
        return ((DefaultTrackOutput)sampleQueues.valueAt(i)).getFormat();
    }

    public boolean getSample(int i, SampleHolder sampleholder)
    {
        Assertions.checkState(isPrepared());
        return ((DefaultTrackOutput)sampleQueues.valueAt(i)).getSample(sampleholder);
    }

    public int getTrackCount()
    {
        Assertions.checkState(isPrepared());
        return sampleQueues.size();
    }

    public boolean hasSamples(int i)
    {
        Assertions.checkState(isPrepared());
        return !((DefaultTrackOutput)sampleQueues.valueAt(i)).isEmpty();
    }

    public void init(Allocator allocator1)
    {
        allocator = allocator1;
        extractor.init(this);
    }

    public boolean isPrepared()
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

    public int read(ExtractorInput extractorinput)
        throws IOException, InterruptedException
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

    public void seekMap(SeekMap seekmap)
    {
    }

    public TrackOutput track(int i)
    {
        DefaultTrackOutput defaulttrackoutput = new DefaultTrackOutput(allocator);
        sampleQueues.put(i, defaulttrackoutput);
        return defaulttrackoutput;
    }
}
