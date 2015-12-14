// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;


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
        int i1;
        int j1;
        int k1;
        if ((i & 0xffe00000) == 0xffe00000)
        {
            if ((i1 = i >>> 19 & 3) != 1 && (j1 = i >>> 17 & 3) != 0 && ((k1 = i >>> 12 & 0xf) != 0 && k1 != 15) && (j = i >>> 10 & 3) != 3)
            {
                int k = SAMPLING_RATE_V1[j];
                int l;
                if (i1 == 2)
                {
                    j = k / 2;
                } else
                {
                    j = k;
                    if (i1 == 0)
                    {
                        j = k / 4;
                    }
                }
                l = i >>> 9 & 1;
                if (j1 == 3)
                {
                    if (i1 == 3)
                    {
                        i = BITRATE_V1_L1[k1 - 1];
                    } else
                    {
                        i = BITRATE_V2_L1[k1 - 1];
                    }
                    return ((i * 12000) / j + l) * 4;
                }
                if (i1 == 3)
                {
                    if (j1 == 2)
                    {
                        i = BITRATE_V1_L2[k1 - 1];
                    } else
                    {
                        i = BITRATE_V1_L3[k1 - 1];
                    }
                } else
                {
                    i = BITRATE_V2[k1 - 1];
                }
                if (i1 == 3)
                {
                    return (0x23280 * i) / j + l;
                }
                if (j1 == 1)
                {
                    k = 0x11940;
                } else
                {
                    k = 0x23280;
                }
                return (k * i) / j + l;
            }
        }
        return -1;
    }

    public static boolean populateHeader(int i, MpegAudioHeader mpegaudioheader)
    {
        if ((0xffe00000 & i) != 0xffe00000)
        {
            return false;
        }
        int i1 = i >>> 19 & 3;
        if (i1 == 1)
        {
            return false;
        }
        int j1 = i >>> 17 & 3;
        if (j1 == 0)
        {
            return false;
        }
        int l = i >>> 12 & 0xf;
        if (l == 0 || l == 15)
        {
            return false;
        }
        int j = i >>> 10 & 3;
        if (j == 3)
        {
            return false;
        }
        int k = SAMPLING_RATE_V1[j];
        char c;
        int k1;
        if (i1 == 2)
        {
            j = k / 2;
        } else
        {
            j = k;
            if (i1 == 0)
            {
                j = k / 4;
            }
        }
        k1 = i >>> 9 & 1;
        if (j1 == 3)
        {
            String s;
            if (i1 == 3)
            {
                l = BITRATE_V1_L1[l - 1];
            } else
            {
                l = BITRATE_V2_L1[l - 1];
            }
            k = ((l * 12000) / j + k1) * 4;
            c = '\u0180';
        } else
        if (i1 == 3)
        {
            if (j1 == 2)
            {
                l = BITRATE_V1_L2[l - 1];
            } else
            {
                l = BITRATE_V1_L3[l - 1];
            }
            c = '\u0480';
            k = (0x23280 * l) / j + k1;
        } else
        {
            l = BITRATE_V2[l - 1];
            if (j1 == 1)
            {
                c = '\u0240';
            } else
            {
                c = '\u0480';
            }
            if (j1 == 1)
            {
                k = 0x11940;
            } else
            {
                k = 0x23280;
            }
            k = (k * l) / j + k1;
        }
        s = MIME_TYPE_BY_LAYER[3 - j1];
        if ((i >> 6 & 3) == 3)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        mpegaudioheader.setValues(i1, s, k, j, i, l, c);
        return true;
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
