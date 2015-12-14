// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;


class count extends count
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
    //                   0 350
    //                   1 353
    //                   2 415;
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


    public (int i, byte abyte0[])
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
