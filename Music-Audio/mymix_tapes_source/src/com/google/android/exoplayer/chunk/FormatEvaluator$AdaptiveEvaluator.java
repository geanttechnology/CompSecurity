// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.upstream.BandwidthMeter;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.chunk:
//            FormatEvaluator, Format, MediaChunk

public static final class bandwidthFraction
    implements FormatEvaluator
{

    public static final float DEFAULT_BANDWIDTH_FRACTION = 0.75F;
    public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
    public static final int DEFAULT_MAX_INITIAL_BITRATE = 0xc3500;
    public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
    public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;
    private final float bandwidthFraction;
    private final BandwidthMeter bandwidthMeter;
    private final long maxDurationForQualityDecreaseUs;
    private final int maxInitialBitrate;
    private final long minDurationForQualityIncreaseUs;
    private final long minDurationToRetainAfterDiscardUs;

    private Format determineIdealFormat(Format aformat[], long l)
    {
        int i;
        if (l == -1L)
        {
            l = maxInitialBitrate;
        } else
        {
            l = (long)((float)l * bandwidthFraction);
        }
        for (i = 0; i < aformat.length; i++)
        {
            Format format = aformat[i];
            if ((long)format.bitrate <= l)
            {
                return format;
            }
        }

        return aformat[aformat.length - 1];
    }

    public void disable()
    {
    }

    public void enable()
    {
    }

    public void evaluate(List list, long l, Format aformat[], bandwidthFraction bandwidthfraction)
    {
        Format format;
        Format format1;
        boolean flag1;
        long l1;
        boolean flag;
        if (list.isEmpty())
        {
            l1 = 0L;
        } else
        {
            l1 = ((MediaChunk)list.get(list.size() - 1)).endTimeUs - l;
        }
        format = bandwidthfraction.bandwidthFraction;
        format1 = determineIdealFormat(aformat, bandwidthMeter.getBitrateEstimate());
        if (format1 != null && format != null && format1.bitrate > format.bitrate)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (format1 != null && format != null && format1.bitrate < format.bitrate)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        if (l1 >= minDurationForQualityIncreaseUs) goto _L4; else goto _L3
_L3:
        aformat = format;
_L6:
        if (format != null && aformat != format)
        {
            bandwidthfraction. = 3;
        }
        bandwidthfraction. = aformat;
        return;
_L4:
        aformat = format1;
        if (l1 < minDurationToRetainAfterDiscardUs)
        {
            continue; /* Loop/switch isn't completed */
        }
        int i = 1;
        do
        {
            aformat = format1;
            if (i >= list.size())
            {
                continue; /* Loop/switch isn't completed */
            }
            aformat = (MediaChunk)list.get(i);
            if (((MediaChunk) (aformat)).startTimeUs - l >= minDurationToRetainAfterDiscardUs && ((MediaChunk) (aformat)).format.bitrate < format1.bitrate && ((MediaChunk) (aformat)).format.height < format1.height && ((MediaChunk) (aformat)).format.height < 720 && ((MediaChunk) (aformat)).format.width < 1280)
            {
                bandwidthfraction.ze = i;
                aformat = format1;
                continue; /* Loop/switch isn't completed */
            }
            i++;
        } while (true);
_L2:
        aformat = format1;
        if (flag1)
        {
            aformat = format1;
            if (format != null)
            {
                aformat = format1;
                if (l1 >= maxDurationForQualityDecreaseUs)
                {
                    aformat = format;
                }
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public (BandwidthMeter bandwidthmeter)
    {
        this(bandwidthmeter, 0xc3500, 10000, 25000, 25000, 0.75F);
    }

    public <init>(BandwidthMeter bandwidthmeter, int i, int j, int k, int l, float f)
    {
        bandwidthMeter = bandwidthmeter;
        maxInitialBitrate = i;
        minDurationForQualityIncreaseUs = (long)j * 1000L;
        maxDurationForQualityDecreaseUs = (long)k * 1000L;
        minDurationToRetainAfterDiscardUs = (long)l * 1000L;
        bandwidthFraction = f;
    }
}
