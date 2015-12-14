// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import java.io.UnsupportedEncodingException;

public class Base64
{

    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    private Base64()
    {
    }

    public static byte[] decode(String s, int i)
    {
        return decode(s.getBytes(), i);
    }

    public static byte[] decode(byte abyte0[], int i)
    {
        return decode(abyte0, 0, abyte0.length, i);
    }

    public static byte[] decode(byte abyte0[], int i, int j, int k)
    {
        Decoder decoder = new Decoder(k, new byte[(j * 3) / 4]);
        if (!decoder.process(abyte0, i, j, true))
        {
            throw new IllegalArgumentException("bad base-64");
        }
        if (decoder.op == decoder.output.length)
        {
            return decoder.output;
        } else
        {
            abyte0 = new byte[decoder.op];
            System.arraycopy(decoder.output, 0, abyte0, 0, decoder.op);
            return abyte0;
        }
    }

    public static byte[] encode(byte abyte0[], int i)
    {
        return encode(abyte0, 0, abyte0.length, i);
    }

    public static byte[] encode(byte abyte0[], int i, int j, int k)
    {
        Encoder encoder;
        int l;
        encoder = new Encoder(k, null);
        l = (j / 3) * 4;
        if (!encoder.do_padding) goto _L2; else goto _L1
_L1:
        k = l;
        if (j % 3 > 0)
        {
            k = l + 4;
        }
_L4:
        l = k;
        if (encoder.do_newline)
        {
            l = k;
            if (j > 0)
            {
                int i1 = (j - 1) / 57;
                if (encoder.do_cr)
                {
                    l = 2;
                } else
                {
                    l = 1;
                }
                l = k + l * (i1 + 1);
            }
        }
        encoder.output = new byte[l];
        encoder.process(abyte0, i, j, true);
        return encoder.output;
_L2:
        k = l;
        switch (j % 3)
        {
        default:
            k = l;
            break;

        case 1: // '\001'
            k = l + 2;
            break;

        case 2: // '\002'
            k = l + 3;
            break;

        case 0: // '\0'
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String encodeToString(byte abyte0[], int i)
    {
        try
        {
            abyte0 = new String(encode(abyte0, i), "US-ASCII");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new AssertionError(abyte0);
        }
        return abyte0;
    }

    public static String encodeToString(byte abyte0[], int i, int j, int k)
    {
        try
        {
            abyte0 = new String(encode(abyte0, i, j, k), "US-ASCII");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new AssertionError(abyte0);
        }
        return abyte0;
    }

    private class Decoder extends Coder
    {
        private class Coder
        {

            public int op;
            public byte output[];

            public abstract int maxOutputSize(int i);

            public abstract boolean process(byte abyte0[], int i, int j, boolean flag);

            Coder()
            {
            }
        }


        private static final int DECODE[] = {
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 
            54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
            -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 
            5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
            15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
            25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 
            29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
            39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
            49, 50, 51, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1
        };
        private static final int DECODE_WEBSAFE[] = {
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 
            54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
            -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 
            5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
            15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
            25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 
            29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
            39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
            49, 50, 51, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
            -1, -1, -1, -1, -1, -1
        };
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int alphabet[];
        private int state;
        private int value;

        public int maxOutputSize(int i)
        {
            return (i * 3) / 4 + 10;
        }

        public boolean process(byte abyte0[], int i, int j, boolean flag)
        {
            byte abyte1[];
            int ai[];
            int k;
            int l;
            int j2;
            if (state == 6)
            {
                return false;
            }
            j2 = j + i;
            l = state;
            j = value;
            k = 0;
            abyte1 = output;
            ai = alphabet;
            break MISSING_BLOCK_LABEL_42;
            j = ai[abyte0[i2] & 0xff];
            l;
            JVM INSTR tableswitch 0 5: default 292
        //                       0 313
        //                       1 342
        //                       2 379
        //                       3 446
        //                       4 556
        //                       5 590;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            i = l;
            j = k1;
            k = i1;
_L8:
            l = i;
            i = i2 + 1;
            continue; /* Loop/switch isn't completed */
_L2:
            if (j < 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            i = l + 1;
            k = i1;
              goto _L8
            if (j == -1) goto _L1; else goto _L9
_L9:
            state = 6;
            return false;
_L3:
            if (j < 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            j = k1 << 6 | j;
            i = l + 1;
            k = i1;
              goto _L8
            if (j == -1) goto _L1; else goto _L10
_L10:
            state = 6;
            return false;
_L4:
            if (j >= 0)
            {
                j = k1 << 6 | j;
                i = l + 1;
                k = i1;
            } else
            {
                if (j != -2)
                {
                    continue; /* Loop/switch isn't completed */
                }
                abyte1[i1] = (byte)(k1 >> 4);
                i = 4;
                k = i1 + 1;
                j = k1;
            }
              goto _L8
            if (j == -1) goto _L1; else goto _L11
_L11:
            state = 6;
            return false;
_L5:
            if (j >= 0)
            {
                j = k1 << 6 | j;
                abyte1[i1 + 2] = (byte)j;
                abyte1[i1 + 1] = (byte)(j >> 8);
                abyte1[i1] = (byte)(j >> 16);
                k = i1 + 3;
                i = 0;
            } else
            {
                if (j != -2)
                {
                    continue; /* Loop/switch isn't completed */
                }
                abyte1[i1 + 1] = (byte)(k1 >> 2);
                abyte1[i1] = (byte)(k1 >> 10);
                k = i1 + 2;
                i = 5;
                j = k1;
            }
              goto _L8
            if (j == -1) goto _L1; else goto _L12
_L12:
            state = 6;
            return false;
_L6:
            if (j != -2)
            {
                continue; /* Loop/switch isn't completed */
            }
            i = l + 1;
            k = i1;
            j = k1;
              goto _L8
            if (j == -1) goto _L1; else goto _L13
_L13:
            state = 6;
            return false;
_L7:
            if (j == -1) goto _L1; else goto _L14
_L14:
            state = 6;
            return false;
_L23:
            int i1;
            int k1;
            int i2;
            if (i < j2)
            {
                i1 = k;
                k1 = j;
                i2 = i;
                if (l != 0)
                {
                    break MISSING_BLOCK_LABEL_238;
                }
                int l1 = i;
                i = j;
                do
                {
                    if (l1 + 4 > j2)
                    {
                        break;
                    }
                    j = ai[abyte0[l1] & 0xff] << 18 | ai[abyte0[l1 + 1] & 0xff] << 12 | ai[abyte0[l1 + 2] & 0xff] << 6 | ai[abyte0[l1 + 3] & 0xff];
                    i = j;
                    if (j < 0)
                    {
                        break;
                    }
                    abyte1[k + 2] = (byte)j;
                    abyte1[k + 1] = (byte)(j >> 8);
                    abyte1[k] = (byte)(j >> 16);
                    k += 3;
                    l1 += 4;
                    i = j;
                } while (true);
                i1 = k;
                k1 = i;
                i2 = l1;
                if (l1 < j2)
                {
                    break MISSING_BLOCK_LABEL_238;
                }
                j = i;
            }
            if (!flag)
            {
                state = l;
                value = j;
                op = k;
                return true;
            }
            i = k;
            l;
            JVM INSTR tableswitch 0 4: default 644
        //                       0 647
        //                       1 660
        //                       2 668
        //                       3 685
        //                       4 718;
               goto _L15 _L16 _L17 _L18 _L19 _L20
_L16:
            break; /* Loop/switch isn't completed */
_L15:
            i = k;
_L21:
            state = l;
            op = i;
            return true;
_L17:
            state = 6;
            return false;
_L18:
            abyte1[k] = (byte)(j >> 4);
            i = k + 1;
            continue; /* Loop/switch isn't completed */
_L19:
            int j1 = k + 1;
            abyte1[k] = (byte)(j >> 10);
            i = j1 + 1;
            abyte1[j1] = (byte)(j >> 2);
            if (true) goto _L21; else goto _L20
_L20:
            state = 6;
            return false;
            if (true) goto _L23; else goto _L22
_L22:
        }


        public Decoder(int i, byte abyte0[])
        {
            output = abyte0;
            if ((i & 8) == 0)
            {
                abyte0 = DECODE;
            } else
            {
                abyte0 = DECODE_WEBSAFE;
            }
            alphabet = abyte0;
            state = 0;
            value = 0;
        }
    }


    private class Encoder extends Coder
    {

        private static final byte ENCODE[] = {
            65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
            75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
            85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
            101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
            111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
            121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
            56, 57, 43, 47
        };
        private static final byte ENCODE_WEBSAFE[] = {
            65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
            75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
            85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
            101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
            111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
            121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
            56, 57, 45, 95
        };
        public static final int LINE_GROUPS = 19;
        private final byte alphabet[];
        private int count;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        private final byte tail[] = new byte[2];
        int tailLen;

        public int maxOutputSize(int i)
        {
            return (i * 8) / 5 + 10;
        }

        public boolean process(byte abyte0[], int i, int j, boolean flag)
        {
            byte abyte1[];
            byte abyte2[];
            int k;
            int i1;
            int j1;
            int l1;
            abyte1 = alphabet;
            abyte2 = output;
            k = 0;
            j1 = count;
            l1 = j + i;
            i1 = -1;
            tailLen;
            JVM INSTR tableswitch 0 2: default 60
        //                       0 350
        //                       1 353
        //                       2 415;
               goto _L1 _L1 _L2 _L3
_L1:
            int l;
            j = j1;
            l = i;
            if (i1 == -1) goto _L5; else goto _L4
_L4:
            abyte2[0] = abyte1[i1 >> 18 & 0x3f];
            abyte2[1] = abyte1[i1 >> 12 & 0x3f];
            abyte2[2] = abyte1[i1 >> 6 & 0x3f];
            k = 4;
            abyte2[3] = abyte1[i1 & 0x3f];
            i1 = j1 - 1;
            j = i1;
            l = i;
            if (i1 != 0) goto _L5; else goto _L6
_L6:
            byte abyte3[];
            int k1;
            if (do_cr)
            {
                j = 5;
                abyte2[4] = 13;
            } else
            {
                j = 4;
            }
            abyte2[j] = 10;
            l = 19;
            j++;
            if (i + 3 > l1) goto _L8; else goto _L7
_L7:
            k = (abyte0[i] & 0xff) << 16 | (abyte0[i + 1] & 0xff) << 8 | abyte0[i + 2] & 0xff;
            abyte2[j] = abyte1[k >> 18 & 0x3f];
            abyte2[j + 1] = abyte1[k >> 12 & 0x3f];
            abyte2[j + 2] = abyte1[k >> 6 & 0x3f];
            abyte2[j + 3] = abyte1[k & 0x3f];
            i += 3;
            i1 = j + 4;
            k1 = l - 1;
            j = k1;
            k = i1;
            l = i;
            if (k1 == 0)
            {
                if (do_cr)
                {
                    j = i1 + 1;
                    abyte2[i1] = 13;
                } else
                {
                    j = i1;
                }
                abyte2[j] = 10;
                l = 19;
                j++;
                break MISSING_BLOCK_LABEL_178;
            }
              goto _L5
_L2:
            if (i + 2 <= l1)
            {
                l = tail[0];
                j = i + 1;
                i1 = (l & 0xff) << 16 | (abyte0[i] & 0xff) << 8 | abyte0[j] & 0xff;
                tailLen = 0;
                i = j + 1;
            }
              goto _L1
_L3:
            if (i + 1 <= l1)
            {
                l = tail[0];
                i1 = tail[1];
                j = i + 1;
                i1 = (l & 0xff) << 16 | (i1 & 0xff) << 8 | abyte0[i] & 0xff;
                tailLen = 0;
                i = j;
            }
              goto _L1
_L8:
            if (!flag) goto _L10; else goto _L9
_L9:
            if (i - tailLen != l1 - 1) goto _L12; else goto _L11
_L11:
            if (tailLen > 0)
            {
                abyte0 = tail;
                i = 1;
                k = abyte0[0];
            } else
            {
                k = abyte0[i];
                i = 0;
            }
            k = (k & 0xff) << 4;
            tailLen = tailLen - i;
            i = j + 1;
            abyte2[j] = abyte1[k >> 6 & 0x3f];
            j = i + 1;
            abyte2[i] = abyte1[k & 0x3f];
            i = j;
            if (do_padding)
            {
                k = j + 1;
                abyte2[j] = 61;
                i = k + 1;
                abyte2[k] = 61;
            }
            j = i;
            if (do_newline)
            {
                j = i;
                if (do_cr)
                {
                    abyte2[i] = 13;
                    j = i + 1;
                }
                abyte2[j] = 10;
                j++;
            }
            k = j;
_L13:
            op = k;
            count = l;
            return true;
_L12:
            if (i - tailLen == l1 - 2)
            {
                if (tailLen > 1)
                {
                    abyte3 = tail;
                    k1 = 1;
                    k = abyte3[0];
                    i1 = i;
                    i = k1;
                } else
                {
                    k = abyte0[i];
                    i1 = i + 1;
                    i = 0;
                }
                if (tailLen > 0)
                {
                    i1 = tail[i];
                    i++;
                } else
                {
                    i1 = abyte0[i1];
                }
                k = (i1 & 0xff) << 2 | (k & 0xff) << 10;
                tailLen = tailLen - i;
                i = j + 1;
                abyte2[j] = abyte1[k >> 12 & 0x3f];
                j = i + 1;
                abyte2[i] = abyte1[k >> 6 & 0x3f];
                i = j + 1;
                abyte2[j] = abyte1[k & 0x3f];
                if (do_padding)
                {
                    j = i + 1;
                    abyte2[i] = 61;
                    i = j;
                }
                j = i;
                if (do_newline)
                {
                    j = i;
                    if (do_cr)
                    {
                        abyte2[i] = 13;
                        j = i + 1;
                    }
                    abyte2[j] = 10;
                    j++;
                }
                k = j;
            } else
            {
                k = j;
                if (do_newline)
                {
                    k = j;
                    if (j > 0)
                    {
                        k = j;
                        if (l != 19)
                        {
                            if (do_cr)
                            {
                                i = j + 1;
                                abyte2[j] = 13;
                            } else
                            {
                                i = j;
                            }
                            k = i + 1;
                            abyte2[i] = 10;
                        }
                    }
                }
            }
            continue; /* Loop/switch isn't completed */
_L10:
            if (i == l1 - 1)
            {
                abyte1 = tail;
                k = tailLen;
                tailLen = k + 1;
                abyte1[k] = abyte0[i];
                k = j;
            } else
            {
                k = j;
                if (i == l1 - 2)
                {
                    abyte1 = tail;
                    k = tailLen;
                    tailLen = k + 1;
                    abyte1[k] = abyte0[i];
                    abyte1 = tail;
                    k = tailLen;
                    tailLen = k + 1;
                    abyte1[k] = abyte0[i + 1];
                    k = j;
                }
            }
            if (true) goto _L13; else goto _L5
_L5:
            i1 = j;
            j = k;
            i = l;
            l = i1;
            break MISSING_BLOCK_LABEL_178;
        }


        public Encoder(int i, byte abyte0[])
        {
            boolean flag1 = true;
            super();
            output = abyte0;
            boolean flag;
            if ((i & 1) == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            do_padding = flag;
            if ((i & 2) == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            do_newline = flag;
            if ((i & 4) != 0)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            do_cr = flag;
            if ((i & 8) == 0)
            {
                abyte0 = ENCODE;
            } else
            {
                abyte0 = ENCODE_WEBSAFE;
            }
            alphabet = abyte0;
            tailLen = 0;
            if (do_newline)
            {
                i = 19;
            } else
            {
                i = -1;
            }
            count = i;
        }
    }

}
