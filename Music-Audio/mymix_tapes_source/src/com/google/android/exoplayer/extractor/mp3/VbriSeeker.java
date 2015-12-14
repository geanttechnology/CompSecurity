// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp3;

import com.google.android.exoplayer.util.MpegAudioHeader;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;

final class VbriSeeker
    implements Mp3Extractor.Seeker
{

    private final long basePosition;
    private final long durationUs;
    private final long positions[];
    private final long timesUs[];

    private VbriSeeker(long al[], long al1[], long l, long l1)
    {
        timesUs = al;
        positions = al1;
        basePosition = l;
        durationUs = l1;
    }

    public static VbriSeeker create(MpegAudioHeader mpegaudioheader, ParsableByteArray parsablebytearray, long l)
    {
        long al[];
        long al1[];
        int k;
        int j1;
        long l1;
        long l2;
        long l3;
        parsablebytearray.skipBytes(10);
        int i = parsablebytearray.readInt();
        if (i <= 0)
        {
            return null;
        }
        k = mpegaudioheader.sampleRate;
        l1 = i;
        int i1;
        int k1;
        if (k >= 32000)
        {
            i = 1152;
        } else
        {
            i = 576;
        }
        l2 = Util.scaleLargeTimestamp(l1, 0xf4240L * (long)i, k);
        i1 = parsablebytearray.readUnsignedShort();
        j1 = parsablebytearray.readUnsignedShort();
        k1 = parsablebytearray.readUnsignedShort();
        al = new long[i1];
        al1 = new long[i1];
        l3 = l2 / (long)i1;
        l1 = 0L;
        k = 0;
_L7:
        if (k >= i1)
        {
            break MISSING_BLOCK_LABEL_225;
        }
        k1;
        JVM INSTR tableswitch 1 4: default 144
    //                   1 154
    //                   2 198
    //                   3 207
    //                   4 216;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_216;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        return null;
_L2:
        int j = parsablebytearray.readUnsignedByte();
_L8:
        l1 += l3;
        al[k] = l1;
        l += j * j1;
        al1[k] = l;
        k++;
        if (true) goto _L7; else goto _L6
_L6:
        j = parsablebytearray.readUnsignedShort();
          goto _L8
_L4:
        j = parsablebytearray.readUnsignedInt24();
          goto _L8
        j = parsablebytearray.readUnsignedIntToInt();
          goto _L8
        return new VbriSeeker(al, al1, (long)mpegaudioheader.frameSize + l, l2);
    }

    public long getDurationUs()
    {
        return durationUs;
    }

    public long getPosition(long l)
    {
        int i = Util.binarySearchFloor(timesUs, l, false, false);
        long l1 = basePosition;
        if (i == -1)
        {
            l = 0L;
        } else
        {
            l = positions[i];
        }
        return l + l1;
    }

    public long getTimeUs(long l)
    {
        return timesUs[Util.binarySearchFloor(positions, l, true, true)];
    }

    public boolean isSeekable()
    {
        return true;
    }
}
