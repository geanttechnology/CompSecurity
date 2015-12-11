// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


final class Base64
{
    public static class Base64DecoderException extends IllegalArgumentException
    {

        public Base64DecoderException(String s)
        {
            super(s);
        }
    }


    private static final byte ALPHABET[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };
    private static final byte DECODABET[] = {
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
        -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
        -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -9, -9, -9, -9, -9
    };
    private static final byte EQUALS_SIGN_ENC = -1;
    private static final byte NEW_LINE = 10;
    private static final byte PADDING_BYTE = 61;
    private static final byte WEBSAFE_ALPHABET[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 45, 95
    };
    private static final byte WEBSAFE_DECODABET[] = {
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
        -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
        -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -9, -9, -9, -9, -9
    };
    private static final byte WHITE_SPACE_ENC = -5;

    private Base64()
    {
    }

    public static byte[] decode(String s)
        throws Base64DecoderException
    {
        s = s.getBytes();
        return decode(((byte []) (s)), 0, s.length);
    }

    public static byte[] decode(byte abyte0[])
        throws Base64DecoderException
    {
        return decode(abyte0, 0, abyte0.length);
    }

    public static byte[] decode(byte abyte0[], int i, int j)
        throws Base64DecoderException
    {
        return decode(abyte0, i, j, DECODABET);
    }

    private static byte[] decode(byte abyte0[], int i, int j, byte abyte1[])
        throws Base64DecoderException
    {
        byte abyte2[] = new byte[(j * 3) / 4 + 2];
        int l = 0;
        byte abyte3[] = new byte[4];
        byte byte1 = 0;
        int i1 = 0;
        int k = 0;
        while (i1 < j) 
        {
            byte byte0 = (byte)(abyte0[i1 + i] & 0x7f);
            int j1 = abyte1[byte0];
            if (j1 < -5)
            {
                throw new Base64DecoderException((new StringBuilder()).append("Bad Base64 input character at ").append(i1).append(": ").append(abyte0[i1 + i]).append("(decimal)").toString());
            }
            byte byte2;
            if (j1 >= -1)
            {
                if (byte0 == 61)
                {
                    if (byte1 != 0)
                    {
                        byte2 = byte1;
                        j1 = l;
                    } else
                    {
                        if (i1 < 2)
                        {
                            throw new Base64DecoderException((new StringBuilder()).append("Invalid padding byte found in position ").append(i1).toString());
                        }
                        byte2 = 1;
                        byte1 = (byte)(abyte0[(j - 1) + i] & 0x7f);
                        if (byte1 != 61 && byte1 != 10)
                        {
                            throw new Base64DecoderException("encoded value has invalid trailing byte");
                        }
                        j1 = l;
                    }
                } else
                {
                    if (byte1 != 0)
                    {
                        throw new Base64DecoderException((new StringBuilder()).append("Data found after trailing padding byte at index ").append(i1).toString());
                    }
                    int k1 = k + 1;
                    abyte3[k] = byte0;
                    k = k1;
                    j1 = l;
                    byte2 = byte1;
                    if (k1 == 4)
                    {
                        j1 = l + decode4to3(abyte3, 0, abyte2, l, abyte1);
                        k = 0;
                        byte2 = byte1;
                    }
                }
            } else
            {
                j1 = l;
                byte2 = byte1;
            }
            i1++;
            l = j1;
            byte1 = byte2;
        }
        i = l;
        if (k != 0)
        {
            if (k == 1)
            {
                throw new Base64DecoderException((new StringBuilder()).append("single trailing character at offset ").append(j - 1).toString());
            }
            abyte3[k] = 61;
            i = l + decode4to3(abyte3, 0, abyte2, l, abyte1);
        }
        abyte0 = new byte[i];
        System.arraycopy(abyte2, 0, abyte0, 0, i);
        return abyte0;
    }

    private static int decode4to3(byte abyte0[], int i, byte abyte1[], int j, byte abyte2[])
    {
        if (abyte0[i + 2] == 61)
        {
            abyte1[j] = (byte)(((abyte2[abyte0[i]] << 24) >>> 6 | (abyte2[abyte0[i + 1]] << 24) >>> 12) >>> 16);
            return 1;
        }
        if (abyte0[i + 3] == 61)
        {
            i = (abyte2[abyte0[i]] << 24) >>> 6 | (abyte2[abyte0[i + 1]] << 24) >>> 12 | (abyte2[abyte0[i + 2]] << 24) >>> 18;
            abyte1[j] = (byte)(i >>> 16);
            abyte1[j + 1] = (byte)(i >>> 8);
            return 2;
        } else
        {
            i = (abyte2[abyte0[i]] << 24) >>> 6 | (abyte2[abyte0[i + 1]] << 24) >>> 12 | (abyte2[abyte0[i + 2]] << 24) >>> 18 | (abyte2[abyte0[i + 3]] << 24) >>> 24;
            abyte1[j] = (byte)(i >> 16);
            abyte1[j + 1] = (byte)(i >> 8);
            abyte1[j + 2] = (byte)i;
            return 3;
        }
    }

    public static byte[] decodeWebSafe(String s)
        throws Base64DecoderException
    {
        s = s.getBytes();
        return decodeWebSafe(((byte []) (s)), 0, s.length);
    }

    public static byte[] decodeWebSafe(byte abyte0[])
        throws Base64DecoderException
    {
        return decodeWebSafe(abyte0, 0, abyte0.length);
    }

    public static byte[] decodeWebSafe(byte abyte0[], int i, int j)
        throws Base64DecoderException
    {
        return decode(abyte0, i, j, WEBSAFE_DECODABET);
    }

    public static String encode(byte abyte0[])
    {
        return encode(abyte0, 0, abyte0.length, ALPHABET, true);
    }

    private static String encode(byte abyte0[], int i, int j, byte abyte1[], boolean flag)
    {
        abyte0 = encode(abyte0, i, j, abyte1, 0x7fffffff);
        i = abyte0.length;
        do
        {
            if (flag || i <= 0 || abyte0[i - 1] != 61)
            {
                return new String(abyte0, 0, i);
            }
            i--;
        } while (true);
    }

    public static String encode(byte abyte0[], boolean flag)
    {
        return encode(abyte0, 0, abyte0.length, ALPHABET, flag);
    }

    public static byte[] encode(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        int l = ((j + 2) / 3) * 4;
        byte abyte2[] = new byte[l / k + l];
        int j1 = 0;
        l = 0;
        int i1 = 0;
        while (j1 < j - 2) 
        {
            int k1 = (abyte0[j1 + i] << 24) >>> 8 | (abyte0[j1 + 1 + i] << 24) >>> 16 | (abyte0[j1 + 2 + i] << 24) >>> 24;
            abyte2[l] = abyte1[k1 >>> 18];
            abyte2[l + 1] = abyte1[k1 >>> 12 & 0x3f];
            abyte2[l + 2] = abyte1[k1 >>> 6 & 0x3f];
            abyte2[l + 3] = abyte1[k1 & 0x3f];
            int l1 = i1 + 4;
            k1 = l;
            i1 = l1;
            if (l1 == k)
            {
                abyte2[l + 4] = 10;
                k1 = l + 1;
                i1 = 0;
            }
            j1 += 3;
            l = k1 + 4;
        }
        if (j1 < j)
        {
            encode3to4(abyte0, j1 + i, j - j1, abyte2, l, abyte1);
            i = l;
            if (i1 + 4 == k)
            {
                abyte2[l + 4] = 10;
                i = l + 1;
            }
        }
        return abyte2;
    }

    private static byte[] encode3to4(byte abyte0[], int i, int j, byte abyte1[], int k, byte abyte2[])
    {
        int j1 = 0;
        int l;
        int i1;
        if (j > 0)
        {
            l = (abyte0[i] << 24) >>> 8;
        } else
        {
            l = 0;
        }
        if (j > 1)
        {
            i1 = (abyte0[i + 1] << 24) >>> 16;
        } else
        {
            i1 = 0;
        }
        if (j > 2)
        {
            j1 = (abyte0[i + 2] << 24) >>> 24;
        }
        i = i1 | l | j1;
        switch (j)
        {
        default:
            return abyte1;

        case 3: // '\003'
            abyte1[k] = abyte2[i >>> 18];
            abyte1[k + 1] = abyte2[i >>> 12 & 0x3f];
            abyte1[k + 2] = abyte2[i >>> 6 & 0x3f];
            abyte1[k + 3] = abyte2[i & 0x3f];
            return abyte1;

        case 2: // '\002'
            abyte1[k] = abyte2[i >>> 18];
            abyte1[k + 1] = abyte2[i >>> 12 & 0x3f];
            abyte1[k + 2] = abyte2[i >>> 6 & 0x3f];
            abyte1[k + 3] = 61;
            return abyte1;

        case 1: // '\001'
            abyte1[k] = abyte2[i >>> 18];
            abyte1[k + 1] = abyte2[i >>> 12 & 0x3f];
            abyte1[k + 2] = 61;
            abyte1[k + 3] = 61;
            return abyte1;
        }
    }

    public static String encodeWebSafe(byte abyte0[], boolean flag)
    {
        return encode(abyte0, 0, abyte0.length, WEBSAFE_ALPHABET, flag);
    }

    public static byte[] getAlphabet()
    {
        return (byte[])ALPHABET.clone();
    }

    public static byte[] getWebsafeAlphabet()
    {
        return (byte[])WEBSAFE_ALPHABET.clone();
    }

}
