// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp3;

import com.google.android.exoplayer.util.MpegAudioHeader;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;

final class XingSeeker
    implements Mp3Extractor.Seeker
{

    private final long durationUs;
    private final long firstFramePosition;
    private final long inputLength;
    private final long sizeBytes;
    private final long tableOfContents[];

    private XingSeeker(long al[], long l, long l1, long l2, 
            long l3)
    {
        tableOfContents = al;
        firstFramePosition = l;
        sizeBytes = l1;
        durationUs = l2;
        inputLength = l3;
    }

    public static XingSeeker create(MpegAudioHeader mpegaudioheader, ParsableByteArray parsablebytearray, long l, long l1)
    {
        int i = mpegaudioheader.samplesPerFrame;
        int k = mpegaudioheader.sampleRate;
        long l2 = mpegaudioheader.frameSize;
        if ((parsablebytearray.readInt() & 7) != 7)
        {
            return null;
        }
        int i1 = parsablebytearray.readUnsignedIntToInt();
        if (i1 == 0)
        {
            return null;
        }
        long l3 = Util.scaleLargeTimestamp(i1, (long)i * 0xf4240L, k);
        long l4 = parsablebytearray.readUnsignedIntToInt();
        parsablebytearray.skipBytes(1);
        mpegaudioheader = new long[99];
        for (int j = 0; j < 99; j++)
        {
            mpegaudioheader[j] = parsablebytearray.readUnsignedByte();
        }

        return new XingSeeker(mpegaudioheader, l + l2, l4, l3, l1);
    }

    private long getTimeUsForTocIndex(int i)
    {
        return (durationUs * (long)(i + 1)) / 100L;
    }

    public long getDurationUs()
    {
        return durationUs;
    }

    public long getPosition(long l)
    {
        float f2 = ((float)l * 100F) / (float)durationUs;
        float f;
        long l1;
        if (f2 <= 0.0F)
        {
            f = 0.0F;
        } else
        if (f2 >= 100F)
        {
            f = 256F;
        } else
        {
            int i = (int)f2;
            float f1;
            if (i == 0)
            {
                f = 0.0F;
            } else
            {
                f = tableOfContents[i - 1];
            }
            if (i < 99)
            {
                f1 = tableOfContents[i];
            } else
            {
                f1 = 256F;
            }
            f += (f1 - f) * (f2 - (float)i);
        }
        l1 = (long)(0.00390625F * f * (float)sizeBytes) + firstFramePosition;
        l = l1;
        if (inputLength != -1L)
        {
            l = Math.min(l1, inputLength - 1L);
        }
        return l;
    }

    public long getTimeUs(long l)
    {
        long l1 = (256L * (l - firstFramePosition)) / sizeBytes;
        int i = Util.binarySearchFloor(tableOfContents, l1, true, false);
        long l2 = getTimeUsForTocIndex(i);
        if (i == 98)
        {
            return l2;
        }
        long l3;
        if (i == -1)
        {
            l = 0L;
        } else
        {
            l = tableOfContents[i];
        }
        l3 = tableOfContents[i + 1];
        return l2 + ((getTimeUsForTocIndex(i + 1) - l2) * (l1 - l)) / (l3 - l);
    }

    public boolean isSeekable()
    {
        return true;
    }
}
