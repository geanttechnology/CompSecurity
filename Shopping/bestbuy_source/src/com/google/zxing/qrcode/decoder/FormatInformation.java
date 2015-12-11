// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.decoder;


// Referenced classes of package com.google.zxing.qrcode.decoder:
//            ErrorCorrectionLevel

final class FormatInformation
{

    private static final int BITS_SET_IN_HALF_BYTE[] = {
        0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 
        2, 3, 2, 3, 3, 4
    };
    private static final int FORMAT_INFO_DECODE_LOOKUP[][];
    private static final int FORMAT_INFO_MASK_QR = 21522;
    private final byte dataMask;
    private final ErrorCorrectionLevel errorCorrectionLevel;

    private FormatInformation(int i)
    {
        errorCorrectionLevel = ErrorCorrectionLevel.forBits(i >> 3 & 3);
        dataMask = (byte)(i & 7);
    }

    static FormatInformation decodeFormatInformation(int i, int j)
    {
        FormatInformation formatinformation = doDecodeFormatInformation(i, j);
        if (formatinformation != null)
        {
            return formatinformation;
        } else
        {
            return doDecodeFormatInformation(i ^ 0x5412, j ^ 0x5412);
        }
    }

    private static FormatInformation doDecodeFormatInformation(int i, int j)
    {
        int l = 0x7fffffff;
        int ai[][] = FORMAT_INFO_DECODE_LOOKUP;
        int k1 = ai.length;
        int i1 = 0;
        int k = 0;
        for (; i1 < k1; i1++)
        {
            int ai1[] = ai[i1];
            int l1 = ai1[0];
            if (l1 == i || l1 == j)
            {
                return new FormatInformation(ai1[1]);
            }
            int j1 = numBitsDiffering(i, l1);
            if (j1 < l)
            {
                k = ai1[1];
                l = j1;
            }
            if (i == j)
            {
                continue;
            }
            j1 = numBitsDiffering(j, l1);
            if (j1 < l)
            {
                k = ai1[1];
                l = j1;
            }
        }

        if (l <= 3)
        {
            return new FormatInformation(k);
        } else
        {
            return null;
        }
    }

    static int numBitsDiffering(int i, int j)
    {
        i ^= j;
        j = BITS_SET_IN_HALF_BYTE[i & 0xf];
        int k = BITS_SET_IN_HALF_BYTE[i >>> 4 & 0xf];
        int l = BITS_SET_IN_HALF_BYTE[i >>> 8 & 0xf];
        int i1 = BITS_SET_IN_HALF_BYTE[i >>> 12 & 0xf];
        int j1 = BITS_SET_IN_HALF_BYTE[i >>> 16 & 0xf];
        int k1 = BITS_SET_IN_HALF_BYTE[i >>> 20 & 0xf];
        int l1 = BITS_SET_IN_HALF_BYTE[i >>> 24 & 0xf];
        return BITS_SET_IN_HALF_BYTE[i >>> 28 & 0xf] + (j + k + l + i1 + j1 + k1 + l1);
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof FormatInformation)
        {
            if (errorCorrectionLevel == ((FormatInformation) (obj = (FormatInformation)obj)).errorCorrectionLevel && dataMask == ((FormatInformation) (obj)).dataMask)
            {
                return true;
            }
        }
        return false;
    }

    byte getDataMask()
    {
        return dataMask;
    }

    ErrorCorrectionLevel getErrorCorrectionLevel()
    {
        return errorCorrectionLevel;
    }

    public int hashCode()
    {
        return errorCorrectionLevel.ordinal() << 3 | dataMask;
    }

    static 
    {
        int ai[] = {
            21522, 0
        };
        int ai1[] = {
            23371, 3
        };
        int ai2[] = {
            17913, 4
        };
        int ai3[] = {
            20375, 6
        };
        int ai4[] = {
            19104, 7
        };
        int ai5[] = {
            30660, 8
        };
        int ai6[] = {
            29427, 9
        };
        int ai7[] = {
            32170, 10
        };
        int ai8[] = {
            30877, 11
        };
        int ai9[] = {
            25368, 13
        };
        int ai10[] = {
            26998, 15
        };
        int ai11[] = {
            5769, 16
        };
        int ai12[] = {
            5054, 17
        };
        int ai13[] = {
            597, 21
        };
        int ai14[] = {
            3340, 22
        };
        int ai15[] = {
            2107, 23
        };
        int ai16[] = {
            13663, 24
        };
        int ai17[] = {
            12392, 25
        };
        int ai18[] = {
            16177, 26
        };
        int ai19[] = {
            8579, 29
        };
        int ai20[] = {
            11994, 30
        };
        int ai21[] = {
            11245, 31
        };
        FORMAT_INFO_DECODE_LOOKUP = (new int[][] {
            ai, new int[] {
                20773, 1
            }, new int[] {
                24188, 2
            }, ai1, ai2, new int[] {
                16590, 5
            }, ai3, ai4, ai5, ai6, 
            ai7, ai8, new int[] {
                26159, 12
            }, ai9, new int[] {
                27713, 14
            }, ai10, ai11, ai12, new int[] {
                7399, 18
            }, new int[] {
                6608, 19
            }, 
            new int[] {
                1890, 20
            }, ai13, ai14, ai15, ai16, ai17, ai18, new int[] {
                14854, 27
            }, new int[] {
                9396, 28
            }, ai19, 
            ai20, ai21
        });
    }
}
