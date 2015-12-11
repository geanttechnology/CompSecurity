// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor;

import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.SampleHolder;
import shared_presage.com.google.android.exoplayer.upstream.Allocator;
import shared_presage.com.google.android.exoplayer.upstream.DataSource;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor:
//            TrackOutput, a, ExtractorInput

public class DefaultTrackOutput
    implements TrackOutput
{

    private volatile MediaFormat format;
    private volatile long largestParsedTimestampUs;
    private long lastReadTimeUs;
    private boolean needKeyframe;
    private final a rollingBuffer;
    private final SampleHolder sampleInfoHolder = new SampleHolder(0);
    private long spliceOutTimeUs;

    public DefaultTrackOutput(Allocator allocator)
    {
        rollingBuffer = new a(allocator);
        needKeyframe = true;
        lastReadTimeUs = 0x8000000000000000L;
        spliceOutTimeUs = 0x8000000000000000L;
        largestParsedTimestampUs = 0x8000000000000000L;
    }

    private boolean advanceToEligibleSample()
    {
        boolean flag = rollingBuffer.a(sampleInfoHolder);
        boolean flag1 = flag;
        if (needKeyframe)
        {
            do
            {
                flag1 = flag;
                if (!flag)
                {
                    break;
                }
                flag1 = flag;
                if (sampleInfoHolder.isSyncFrame())
                {
                    break;
                }
                rollingBuffer.d();
                flag = rollingBuffer.a(sampleInfoHolder);
            } while (true);
        }
        while (!flag1 || spliceOutTimeUs != 0x8000000000000000L && sampleInfoHolder.timeUs >= spliceOutTimeUs) 
        {
            return false;
        }
        return true;
    }

    public void clear()
    {
        rollingBuffer.a();
        needKeyframe = true;
        lastReadTimeUs = 0x8000000000000000L;
        spliceOutTimeUs = 0x8000000000000000L;
        largestParsedTimestampUs = 0x8000000000000000L;
    }

    public boolean configureSpliceTo(DefaultTrackOutput defaulttrackoutput)
    {
        if (spliceOutTimeUs != 0x8000000000000000L)
        {
            return true;
        }
        long l;
        if (rollingBuffer.a(sampleInfoHolder))
        {
            l = sampleInfoHolder.timeUs;
        } else
        {
            l = lastReadTimeUs + 1L;
        }
        for (defaulttrackoutput = defaulttrackoutput.rollingBuffer; defaulttrackoutput.a(sampleInfoHolder) && (sampleInfoHolder.timeUs < l || !sampleInfoHolder.isSyncFrame()); defaulttrackoutput.d()) { }
        if (defaulttrackoutput.a(sampleInfoHolder))
        {
            spliceOutTimeUs = sampleInfoHolder.timeUs;
            return true;
        } else
        {
            return false;
        }
    }

    public void discardUntil(long l)
    {
        while (rollingBuffer.a(sampleInfoHolder) && sampleInfoHolder.timeUs < l) 
        {
            rollingBuffer.d();
            needKeyframe = true;
        }
        lastReadTimeUs = 0x8000000000000000L;
    }

    public void discardUpstreamSamples(int i)
    {
        rollingBuffer.a(i);
        long l;
        if (rollingBuffer.a(sampleInfoHolder))
        {
            l = sampleInfoHolder.timeUs;
        } else
        {
            l = 0x8000000000000000L;
        }
        largestParsedTimestampUs = l;
    }

    public void format(MediaFormat mediaformat)
    {
        format = mediaformat;
    }

    public MediaFormat getFormat()
    {
        return format;
    }

    public long getLargestParsedTimestampUs()
    {
        return largestParsedTimestampUs;
    }

    public int getReadIndex()
    {
        return rollingBuffer.c();
    }

    public boolean getSample(SampleHolder sampleholder)
    {
        if (!advanceToEligibleSample())
        {
            return false;
        } else
        {
            rollingBuffer.b(sampleholder);
            needKeyframe = false;
            lastReadTimeUs = sampleholder.timeUs;
            return true;
        }
    }

    public int getWriteIndex()
    {
        return rollingBuffer.b();
    }

    public boolean hasFormat()
    {
        return format != null;
    }

    public boolean isEmpty()
    {
        return !advanceToEligibleSample();
    }

    public int sampleData(ExtractorInput extractorinput, int i, boolean flag)
    {
        return rollingBuffer.a(extractorinput, i, flag);
    }

    public int sampleData(DataSource datasource, int i, boolean flag)
    {
        return rollingBuffer.a(datasource, i, flag);
    }

    public void sampleData(ParsableByteArray parsablebytearray, int i)
    {
        rollingBuffer.a(parsablebytearray, i);
    }

    public void sampleMetadata(long l, int i, int j, int k, byte abyte0[])
    {
        largestParsedTimestampUs = Math.max(largestParsedTimestampUs, l);
        rollingBuffer.a(l, i, rollingBuffer.e() - (long)j - (long)k, j, abyte0);
    }

    public boolean skipToKeyframeBefore(long l)
    {
        return rollingBuffer.a(l);
    }
}
