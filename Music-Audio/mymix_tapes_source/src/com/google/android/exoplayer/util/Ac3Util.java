// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;

import com.google.android.exoplayer.MediaFormat;

// Referenced classes of package com.google.android.exoplayer.util:
//            ParsableByteArray, ParsableBitArray

public final class Ac3Util
{

    private static final int BITRATES[] = {
        32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 
        192, 224, 256, 320, 384, 448, 512, 576, 640
    };
    private static final int CHANNEL_COUNTS[] = {
        2, 1, 2, 3, 3, 4, 4, 5
    };
    private static final int FRMSIZECOD_TO_FRAME_SIZE_44_1[] = {
        69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 
        417, 487, 557, 696, 835, 975, 1114, 1253, 1393
    };
    private static final int SAMPLE_RATES[] = {
        48000, 44100, 32000
    };

    private Ac3Util()
    {
    }

    public static int getBitrate(int i, int j)
    {
        return (0xbb800 + i * 8 * j) / 0x177000;
    }

    public static MediaFormat parseAnnexFAc3Format(ParsableByteArray parsablebytearray)
    {
        int i = parsablebytearray.readUnsignedByte();
        int k = SAMPLE_RATES[(i & 0xc0) >> 6];
        int l = parsablebytearray.readUnsignedByte();
        int j = CHANNEL_COUNTS[(l & 0x38) >> 3];
        i = j;
        if ((l & 4) != 0)
        {
            i = j + 1;
        }
        return MediaFormat.createAudioFormat("audio/ac3", -1, i, k, null);
    }

    public static MediaFormat parseAnnexFEAc3Format(ParsableByteArray parsablebytearray)
    {
        parsablebytearray.skipBytes(2);
        int i = parsablebytearray.readUnsignedByte();
        int k = SAMPLE_RATES[(i & 0xc0) >> 6];
        int l = parsablebytearray.readUnsignedByte();
        int j = CHANNEL_COUNTS[(l & 0xe) >> 1];
        i = j;
        if ((l & 1) != 0)
        {
            i = j + 1;
        }
        return MediaFormat.createAudioFormat("audio/eac3", -1, i, k, null);
    }

    public static MediaFormat parseFrameAc3Format(ParsableBitArray parsablebitarray)
    {
        int i = 1;
        parsablebitarray.skipBits(32);
        int j = parsablebitarray.readBits(2);
        parsablebitarray.skipBits(14);
        int k = parsablebitarray.readBits(3);
        if ((k & 1) != 0 && k != 1)
        {
            parsablebitarray.skipBits(2);
        }
        if ((k & 4) != 0)
        {
            parsablebitarray.skipBits(2);
        }
        if (k == 2)
        {
            parsablebitarray.skipBits(2);
        }
        boolean flag = parsablebitarray.readBit();
        k = CHANNEL_COUNTS[k];
        if (!flag)
        {
            i = 0;
        }
        return MediaFormat.createAudioFormat("audio/ac3", -1, i + k, SAMPLE_RATES[j], null);
    }

    public static int parseFrameSize(ParsableBitArray parsablebitarray)
    {
        parsablebitarray.skipBits(32);
        int j = parsablebitarray.readBits(2);
        int i = parsablebitarray.readBits(6);
        j = SAMPLE_RATES[j];
        int k = BITRATES[i / 2];
        if (j == 32000)
        {
            return k * 6;
        }
        if (j == 44100)
        {
            return (FRMSIZECOD_TO_FRAME_SIZE_44_1[i / 2] + i % 2) * 2;
        } else
        {
            return k * 4;
        }
    }

}
