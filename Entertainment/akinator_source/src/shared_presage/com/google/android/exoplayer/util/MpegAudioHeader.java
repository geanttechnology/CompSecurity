// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.util;


public final class MpegAudioHeader
{

    private static final int BITRATE_V1_L1[] = {
        32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 
        352, 384, 416, 448
    };
    private static final int BITRATE_V1_L2[] = {
        32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 
        224, 256, 320, 384
    };
    private static final int BITRATE_V1_L3[] = {
        32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 
        192, 224, 256, 320
    };
    private static final int BITRATE_V2[] = {
        8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 
        112, 128, 144, 160
    };
    private static final int BITRATE_V2_L1[] = {
        32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 
        176, 192, 224, 256
    };
    public static final int MAX_FRAME_SIZE_BYTES = 4096;
    private static final String MIME_TYPE_BY_LAYER[] = {
        "audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"
    };
    private static final int SAMPLING_RATE_V1[] = {
        44100, 48000, 32000
    };
    public int bitrate;
    public int channels;
    public int frameSize;
    public String mimeType;
    public int sampleRate;
    public int samplesPerFrame;
    public int version;

    public MpegAudioHeader()
    {
    }

    public static int getFrameSize(int i)
    {
        int j;
        int k;
        int l;
        int j1;
        if ((i & 0xffe00000) == 0xffe00000)
        {
            if ((k = i >>> 19 & 3) != 1 && (l = i >>> 17 & 3) != 0 && ((j1 = i >>> 12 & 0xf) != 0 && j1 != 15) && (j = i >>> 10 & 3) != 3)
            {
                j = SAMPLING_RATE_V1[j];
                int i1;
                if (k == 2)
                {
                    j /= 2;
                } else
                if (k == 0)
                {
                    j /= 4;
                }
                i1 = i >>> 9 & 1;
                if (l == 3)
                {
                    if (k == 3)
                    {
                        i = BITRATE_V1_L1[j1 - 1];
                    } else
                    {
                        i = BITRATE_V2_L1[j1 - 1];
                    }
                    return ((i * 12000) / j + i1) * 4;
                }
                if (k == 3)
                {
                    if (l == 2)
                    {
                        i = BITRATE_V1_L2[j1 - 1];
                    } else
                    {
                        i = BITRATE_V1_L3[j1 - 1];
                    }
                } else
                {
                    i = BITRATE_V2[j1 - 1];
                }
                if (k == 3)
                {
                    return (0x23280 * i) / j + i1;
                }
                if (l == 1)
                {
                    k = 0x11940;
                } else
                {
                    k = 0x23280;
                }
                return (k * i) / j + i1;
            }
        }
        return -1;
    }

    public static boolean populateHeader(int i, MpegAudioHeader mpegaudioheader)
    {
        int j;
        int k;
        int l;
        int i1;
        int i2;
        int j2;
        int k2;
        byte byte0 = 2;
        if ((i & 0xffe00000) != 0xffe00000)
        {
            return false;
        }
        i2 = i >>> 19 & 3;
        if (i2 == 1)
        {
            return false;
        }
        j2 = i >>> 17 & 3;
        if (j2 == 0)
        {
            return false;
        }
        l = i >>> 12 & 0xf;
        if (l == 0 || l == 15)
        {
            return false;
        }
        j = i >>> 10 & 3;
        if (j == 3)
        {
            return false;
        }
        j = SAMPLING_RATE_V1[j];
        String s;
        int j1;
        if (i2 == 2)
        {
            k = j / 2;
        } else
        {
            k = j;
            if (i2 == 0)
            {
                k = j / 4;
            }
        }
        k2 = i >>> 9 & 1;
        if (j2 != 3) goto _L2; else goto _L1
_L1:
        if (i2 == 3)
        {
            j = BITRATE_V1_L1[l - 1];
        } else
        {
            j = BITRATE_V2_L1[l - 1];
        }
        j1 = ((j * 12000) / k + k2) * 4;
        l = 384;
        i1 = j;
        j = j1;
_L5:
        s = MIME_TYPE_BY_LAYER[3 - j2];
        j1 = byte0;
        if ((i >> 6 & 3) == 3)
        {
            j1 = 1;
        }
        mpegaudioheader.setValues(i2, s, j, k, j1, i1, l);
        return true;
_L2:
        if (i2 != 3) goto _L4; else goto _L3
_L3:
        int k1;
        if (j2 == 2)
        {
            j = BITRATE_V1_L2[l - 1];
        } else
        {
            j = BITRATE_V1_L3[l - 1];
        }
        l = 1152;
        i1 = j;
_L7:
        j = i1;
        i1 = 0x23280;
_L8:
        k1 = (i1 * j) / k;
        i1 = j;
        j = k1 + k2;
          goto _L5
_L4:
        int l1 = BITRATE_V2[l - 1];
        if (j2 == 1)
        {
            j = 576;
        } else
        {
            j = 1152;
        }
        l = j;
        i1 = l1;
        if (j2 != 1) goto _L7; else goto _L6
_L6:
        i1 = 0x11940;
        l = j;
        j = l1;
          goto _L8
    }

    private void setValues(int i, String s, int j, int k, int l, int i1, int j1)
    {
        version = i;
        mimeType = s;
        frameSize = j;
        sampleRate = k;
        channels = l;
        bitrate = i1;
        samplesPerFrame = j1;
    }

}
