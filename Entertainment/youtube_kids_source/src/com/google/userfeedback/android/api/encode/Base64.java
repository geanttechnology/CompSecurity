// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api.encode;

import java.io.UnsupportedEncodingException;

public class Base64
{

    static final boolean $assertionsDisabled;
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    private Base64()
    {
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
        l = j / 3 << 2;
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
        if (!$assertionsDisabled && encoder.op != l)
        {
            throw new AssertionError();
        } else
        {
            return encoder.output;
        }
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

    static 
    {
        boolean flag;
        if (!com/google/userfeedback/android/api/encode/Base64.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }

    private class Decoder extends Coder
    {
        private class Coder
        {

            public int op;
            public byte output[];

            public abstract int maxOutputSize(int i);

            public abstract boolean process(byte abyte0[], int i, int j, boolean flag);

            public Coder()
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
            int i1;
            int i2;
            if (state == 6)
            {
                return false;
            }
            i2 = j + i;
            j = state;
            k = value;
            i1 = 0;
            abyte1 = output;
            ai = alphabet;
_L27:
            int k1;
            int l1;
            k1 = i1;
            l1 = k;
            if (i >= i2) goto _L2; else goto _L1
_L1:
            int j1;
            j1 = i1;
            k1 = k;
            l1 = i;
            if (j != 0) goto _L4; else goto _L3
_L3:
            j1 = i;
            i = k;
            do
            {
                if (j1 + 4 > i2)
                {
                    break;
                }
                k = ai[abyte0[j1] & 0xff] << 18 | ai[abyte0[j1 + 1] & 0xff] << 12 | ai[abyte0[j1 + 2] & 0xff] << 6 | ai[abyte0[j1 + 3] & 0xff];
                i = k;
                if (k < 0)
                {
                    break;
                }
                abyte1[i1 + 2] = (byte)k;
                abyte1[i1 + 1] = (byte)(k >> 8);
                abyte1[i1] = (byte)(k >> 16);
                i1 += 3;
                j1 += 4;
                i = k;
            } while (true);
            k1 = i1;
            l1 = i;
            if (j1 >= i2) goto _L2; else goto _L5
_L5:
            l1 = j1;
            k1 = i;
            j1 = i1;
_L4:
            i = l1 + 1;
            k = ai[abyte0[l1] & 0xff];
            j;
            JVM INSTR tableswitch 0 5: default 292
        //                       0 303
        //                       1 333
        //                       2 373
        //                       3 445
        //                       4 564
        //                       5 600;
               goto _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L6:
            i1 = j1;
            k = k1;
            continue; /* Loop/switch isn't completed */
_L7:
            if (k < 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            j++;
            i1 = j1;
            continue; /* Loop/switch isn't completed */
            if (k == -1) goto _L6; else goto _L13
_L13:
            state = 6;
            return false;
_L8:
            if (k < 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            k = k1 << 6 | k;
            j++;
            i1 = j1;
            continue; /* Loop/switch isn't completed */
            if (k == -1) goto _L6; else goto _L14
_L14:
            state = 6;
            return false;
_L9:
            if (k >= 0)
            {
                k = k1 << 6 | k;
                j++;
                i1 = j1;
            } else
            {
                if (k != -2)
                {
                    continue; /* Loop/switch isn't completed */
                }
                abyte1[j1] = (byte)(k1 >> 4);
                j = 4;
                i1 = j1 + 1;
                k = k1;
            }
            continue; /* Loop/switch isn't completed */
            if (k == -1) goto _L6; else goto _L15
_L15:
            state = 6;
            return false;
_L10:
            if (k >= 0)
            {
                k = k1 << 6 | k;
                abyte1[j1 + 2] = (byte)k;
                abyte1[j1 + 1] = (byte)(k >> 8);
                abyte1[j1] = (byte)(k >> 16);
                i1 = j1 + 3;
                j = 0;
            } else
            {
                if (k != -2)
                {
                    continue; /* Loop/switch isn't completed */
                }
                abyte1[j1 + 1] = (byte)(k1 >> 2);
                abyte1[j1] = (byte)(k1 >> 10);
                i1 = j1 + 2;
                j = 5;
                k = k1;
            }
            continue; /* Loop/switch isn't completed */
            if (k == -1) goto _L6; else goto _L16
_L16:
            state = 6;
            return false;
_L11:
            if (k != -2)
            {
                continue; /* Loop/switch isn't completed */
            }
            j++;
            i1 = j1;
            k = k1;
            continue; /* Loop/switch isn't completed */
            if (k == -1) goto _L6; else goto _L17
_L17:
            state = 6;
            return false;
_L12:
            if (k == -1) goto _L6; else goto _L18
_L18:
            state = 6;
            return false;
_L2:
            if (!flag)
            {
                state = j;
                value = l1;
                op = k1;
                return true;
            }
            i = k1;
            j;
            JVM INSTR tableswitch 0 4: default 676
        //                       0 679
        //                       1 691
        //                       2 699
        //                       3 717
        //                       4 752;
               goto _L19 _L20 _L21 _L22 _L23 _L24
_L20:
            break; /* Loop/switch isn't completed */
_L19:
            i = k1;
_L25:
            state = j;
            op = i;
            return true;
_L21:
            state = 6;
            return false;
_L22:
            abyte1[k1] = (byte)(l1 >> 4);
            i = k1 + 1;
            continue; /* Loop/switch isn't completed */
_L23:
            int l = k1 + 1;
            abyte1[k1] = (byte)(l1 >> 10);
            i = l + 1;
            abyte1[l] = (byte)(l1 >> 2);
            if (true) goto _L25; else goto _L24
_L24:
            state = 6;
            return false;
            if (true) goto _L27; else goto _L26
_L26:
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

        static final boolean $assertionsDisabled;
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
        public int tailLen;

        public int maxOutputSize(int i)
        {
            return (i << 3) / 5 + 10;
        }

        public boolean process(byte abyte0[], int i, int j, boolean flag)
        {
            byte abyte1[];
            byte abyte2[];
            int l;
            int i1;
            int l1;
            abyte1 = alphabet;
            abyte2 = output;
            l = 0;
            i1 = count;
            l1 = j + i;
            tailLen;
            JVM INSTR tableswitch 0 2: default 56
        //                       0 335
        //                       1 345
        //                       2 413;
               goto _L1 _L2 _L3 _L4
_L1:
            int k;
            j = -1;
            k = i;
            i = j;
_L6:
            if (i != -1)
            {
                abyte2[0] = abyte1[i >> 18 & 0x3f];
                abyte2[1] = abyte1[i >> 12 & 0x3f];
                abyte2[2] = abyte1[i >> 6 & 0x3f];
                j = 4;
                abyte2[3] = abyte1[i & 0x3f];
                i = i1 - 1;
                byte abyte3[];
                int j1;
                int k1;
                if (i == 0)
                {
                    i = j;
                    if (do_cr)
                    {
                        i = 5;
                        abyte2[4] = 13;
                    }
                    l = i + 1;
                    abyte2[i] = 10;
                    j = 19;
                    i = l;
                } else
                {
                    j = i;
                    i = 4;
                }
            } else
            {
                j = i1;
                i = l;
            }
            do
            {
                if (k + 3 > l1)
                {
                    break;
                }
                l = (abyte0[k] & 0xff) << 16 | (abyte0[k + 1] & 0xff) << 8 | abyte0[k + 2] & 0xff;
                abyte2[i] = abyte1[l >> 18 & 0x3f];
                abyte2[i + 1] = abyte1[l >> 12 & 0x3f];
                abyte2[i + 2] = abyte1[l >> 6 & 0x3f];
                abyte2[i + 3] = abyte1[l & 0x3f];
                k += 3;
                i += 4;
                j--;
                if (j == 0)
                {
                    if (do_cr)
                    {
                        j = i + 1;
                        abyte2[i] = 13;
                        i = j;
                    }
                    j = i + 1;
                    abyte2[i] = 10;
                    l = 19;
                    i = j;
                    j = l;
                }
            } while (true);
              goto _L5
_L2:
            j = -1;
            k = i;
            i = j;
              goto _L6
_L3:
            if (i + 2 > l1) goto _L1; else goto _L7
_L7:
            k = tail[0];
            j = i + 1;
            i = abyte0[i];
            j1 = abyte0[j];
            tailLen = 0;
            i = (k & 0xff) << 16 | (i & 0xff) << 8 | j1 & 0xff;
            k = j + 1;
              goto _L6
_L4:
            if (i + 1 > l1) goto _L1; else goto _L8
_L8:
            j = tail[0];
            j1 = tail[1];
            k = i + 1;
            i = abyte0[i];
            tailLen = 0;
            i = (j & 0xff) << 16 | (j1 & 0xff) << 8 | i & 0xff;
              goto _L6
_L5:
            if (!flag) goto _L10; else goto _L9
_L9:
            if (k - tailLen != l1 - 1) goto _L12; else goto _L11
_L11:
            l = 0;
            if (tailLen > 0)
            {
                abyte0 = tail;
                l = 1;
                i1 = abyte0[0];
            } else
            {
                i1 = abyte0[k];
                k++;
            }
            i1 = (i1 & 0xff) << 4;
            tailLen = tailLen - l;
            j1 = i + 1;
            abyte2[i] = abyte1[i1 >> 6 & 0x3f];
            l = j1 + 1;
            abyte2[j1] = abyte1[i1 & 0x3f];
            i = l;
            if (do_padding)
            {
                i1 = l + 1;
                abyte2[l] = 61;
                i = i1 + 1;
                abyte2[i1] = 61;
            }
            l = i;
            if (do_newline)
            {
                l = i;
                if (do_cr)
                {
                    abyte2[i] = 13;
                    l = i + 1;
                }
                abyte2[l] = 10;
                l++;
            }
            i1 = k;
_L14:
            if (!$assertionsDisabled && tailLen != 0)
            {
                throw new AssertionError();
            }
            break; /* Loop/switch isn't completed */
_L12:
            if (k - tailLen == l1 - 2)
            {
                l = 0;
                if (tailLen > 1)
                {
                    abyte3 = tail;
                    j1 = 1;
                    i1 = abyte3[0];
                    l = k;
                    k = j1;
                } else
                {
                    i1 = abyte0[k];
                    j1 = k + 1;
                    k = l;
                    l = j1;
                }
                if (tailLen > 0)
                {
                    j1 = tail[k];
                    k1 = k + 1;
                    k = l;
                    l = k1;
                } else
                {
                    j1 = abyte0[l];
                    k1 = l + 1;
                    l = k;
                    k = k1;
                }
                i1 = (j1 & 0xff) << 2 | (i1 & 0xff) << 10;
                tailLen = tailLen - l;
                l = i + 1;
                abyte2[i] = abyte1[i1 >> 12 & 0x3f];
                j1 = l + 1;
                abyte2[l] = abyte1[i1 >> 6 & 0x3f];
                i = j1 + 1;
                abyte2[j1] = abyte1[i1 & 0x3f];
                if (do_padding)
                {
                    l = i + 1;
                    abyte2[i] = 61;
                    i = l;
                }
                l = i;
                if (do_newline)
                {
                    l = i;
                    if (do_cr)
                    {
                        abyte2[i] = 13;
                        l = i + 1;
                    }
                    abyte2[l] = 10;
                    l++;
                }
                i1 = k;
            } else
            {
                i1 = k;
                l = i;
                if (do_newline)
                {
                    i1 = k;
                    l = i;
                    if (i > 0)
                    {
                        i1 = k;
                        l = i;
                        if (j != 19)
                        {
                            if (do_cr)
                            {
                                l = i + 1;
                                abyte2[i] = 13;
                                i = l;
                            }
                            l = i + 1;
                            abyte2[i] = 10;
                            i1 = k;
                        }
                    }
                }
            }
            if (true) goto _L14; else goto _L13
_L13:
            j1 = l;
            if (!$assertionsDisabled)
            {
                j1 = l;
                if (i1 != l1)
                {
                    throw new AssertionError();
                }
            }
              goto _L15
_L10:
            if (k != l1 - 1) goto _L17; else goto _L16
_L16:
            abyte1 = tail;
            l = tailLen;
            tailLen = l + 1;
            abyte1[l] = abyte0[k];
            j1 = i;
_L15:
            op = j1;
            count = j;
            return true;
_L17:
            j1 = i;
            if (k == l1 - 2)
            {
                abyte1 = tail;
                l = tailLen;
                tailLen = l + 1;
                abyte1[l] = abyte0[k];
                abyte1 = tail;
                l = tailLen;
                tailLen = l + 1;
                abyte1[l] = abyte0[k + 1];
                j1 = i;
            }
            if (true) goto _L15; else goto _L18
_L18:
        }

        static 
        {
            boolean flag;
            if (!com/google/userfeedback/android/api/encode/Base64.desiredAssertionStatus())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            $assertionsDisabled = flag;
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
