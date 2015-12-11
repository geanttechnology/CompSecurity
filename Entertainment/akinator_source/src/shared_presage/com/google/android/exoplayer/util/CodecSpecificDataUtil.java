// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.util;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package shared_presage.com.google.android.exoplayer.util:
//            Assertions

public final class CodecSpecificDataUtil
{

    private static final int AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE[] = {
        0, 1, 2, 3, 4, 5, 6, 8
    };
    private static final int AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE[] = {
        0x17700, 0x15888, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 
        11025, 8000, 7350
    };
    private static final byte NAL_START_CODE[] = {
        0, 0, 0, 1
    };
    private static final int SPS_NAL_UNIT_TYPE = 7;

    private CodecSpecificDataUtil()
    {
    }

    public static byte[] buildAacAudioSpecificConfig(int i, int j)
    {
        byte byte0 = -1;
        int k = 0;
        int l = -1;
        for (; k < AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE.length; k++)
        {
            if (i == AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE[k])
            {
                l = k;
            }
        }

        i = 0;
        k = byte0;
        for (; i < AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE.length; i++)
        {
            if (j == AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE[i])
            {
                k = i;
            }
        }

        return (new byte[] {
            (byte)(l >> 1 | 0x10), (byte)((l & 1) << 7 | k << 3)
        });
    }

    public static byte[] buildAacAudioSpecificConfig(int i, int j, int k)
    {
        return (new byte[] {
            (byte)(i << 3 & 0xf8 | j >> 1 & 7), (byte)(j << 7 & 0x80 | k << 3 & 0x78)
        });
    }

    public static byte[] buildNalUnit(byte abyte0[], int i, int j)
    {
        byte abyte1[] = new byte[NAL_START_CODE.length + j];
        System.arraycopy(NAL_START_CODE, 0, abyte1, 0, NAL_START_CODE.length);
        System.arraycopy(abyte0, i, abyte1, NAL_START_CODE.length, j);
        return abyte1;
    }

    private static int findNalStartCode(byte abyte0[], int i)
    {
        int j = abyte0.length;
        for (int k = NAL_START_CODE.length; i <= j - k; i++)
        {
            if (isNalStartCode(abyte0, i))
            {
                return i;
            }
        }

        return -1;
    }

    private static boolean isNalStartCode(byte abyte0[], int i)
    {
        if (abyte0.length - i > NAL_START_CODE.length) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j >= NAL_START_CODE.length)
                {
                    break label1;
                }
                if (abyte0[i + j] != NAL_START_CODE[j])
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public static Pair parseAacAudioSpecificConfig(byte abyte0[])
    {
        boolean flag = true;
        int i = abyte0[0] >> 3 & 0x1f;
        int j;
        if (i == 5 || i == 29)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        j = (abyte0[i] & 7) << 1 | abyte0[i + 1] >> 7 & 1;
        if (j >= 13)
        {
            flag = false;
        }
        Assertions.checkState(flag);
        return Pair.create(Integer.valueOf(AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE[j]), Integer.valueOf(abyte0[i + 1] >> 3 & 0xf));
    }

    private static int parseAvcLevel(byte abyte0[])
    {
        byte byte0 = 8;
        switch (abyte0[8] & 0xff)
        {
        default:
            byte0 = 0;
            // fall through

        case 12: // '\f'
            return byte0;

        case 9: // '\t'
            return 2;

        case 10: // '\n'
            return 1;

        case 11: // '\013'
            return 4;

        case 13: // '\r'
            return 16;

        case 20: // '\024'
            return 32;

        case 21: // '\025'
            return 64;

        case 22: // '\026'
            return 128;

        case 30: // '\036'
            return 256;

        case 31: // '\037'
            return 512;

        case 32: // ' '
            return 1024;

        case 40: // '('
            return 2048;

        case 41: // ')'
            return 4096;

        case 42: // '*'
            return 8192;

        case 50: // '2'
            return 16384;

        case 51: // '3'
            return 32768;
        }
    }

    private static int parseAvcProfile(byte abyte0[])
    {
        switch (abyte0[6] & 0xff)
        {
        default:
            return 0;

        case 66: // 'B'
            return 1;

        case 77: // 'M'
            return 2;

        case 88: // 'X'
            return 4;

        case 100: // 'd'
            return 8;

        case 110: // 'n'
            return 16;

        case 122: // 'z'
            return 32;

        case 244: 
            return 64;
        }
    }

    public static Pair parseSpsNalUnit(byte abyte0[])
    {
        if (isNalStartCode(abyte0, 0) && abyte0.length == 8 && (abyte0[5] & 0x1f) == 7)
        {
            return Pair.create(Integer.valueOf(parseAvcProfile(abyte0)), Integer.valueOf(parseAvcLevel(abyte0)));
        } else
        {
            return null;
        }
    }

    public static byte[][] splitNalUnits(byte abyte0[])
    {
        if (!isNalStartCode(abyte0, 0))
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        int i = 0;
        int j;
        do
        {
            arraylist.add(Integer.valueOf(i));
            j = findNalStartCode(abyte0, i + NAL_START_CODE.length);
            i = j;
        } while (j != -1);
        byte abyte1[][] = new byte[arraylist.size()][];
        i = 0;
        while (i < arraylist.size()) 
        {
            int l = ((Integer)arraylist.get(i)).intValue();
            byte abyte2[];
            int k;
            if (i < arraylist.size() - 1)
            {
                k = ((Integer)arraylist.get(i + 1)).intValue();
            } else
            {
                k = abyte0.length;
            }
            abyte2 = new byte[k - l];
            System.arraycopy(abyte0, l, abyte2, 0, abyte2.length);
            abyte1[i] = abyte2;
            i++;
        }
        return abyte1;
    }

}
