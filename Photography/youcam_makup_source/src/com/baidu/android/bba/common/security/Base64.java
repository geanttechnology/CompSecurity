// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.bba.common.security;


public final class Base64
{

    private static final byte MAP[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };

    private Base64()
    {
    }

    public static byte[] decode(byte abyte0[])
    {
        return decode(abyte0, abyte0.length);
    }

    public static byte[] decode(byte abyte0[], int i)
    {
        byte abyte1[];
        int j1;
        int k1;
        int j = (i / 4) * 3;
        if (j == 0)
        {
            return new byte[0];
        }
        abyte1 = new byte[j];
        j1 = 0;
        k1 = i;
_L2:
        byte byte0;
        byte0 = abyte0[k1 - 1];
        i = j1;
        if (byte0 != 10)
        {
            i = j1;
            if (byte0 != 13)
            {
                i = j1;
                if (byte0 != 32)
                {
                    if (byte0 != 9)
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    i = j1;
                }
            }
        }
_L3:
        k1--;
        j1 = i;
        if (true) goto _L2; else goto _L1
_L1:
        if (byte0 == 61)
        {
            i = j1 + 1;
        } else
        {
            int l1 = 0;
            int i1 = 0;
            int l = 0;
            i = 0;
            while (l1 < k1) 
            {
                int k = abyte0[l1];
                if (k != 10 && k != 13 && k != 32)
                {
                    if (k == 9)
                    {
                        k = l;
                        l = i;
                        i = i1;
                    } else
                    {
                        if (k >= 65 && k <= 90)
                        {
                            k -= 65;
                        } else
                        if (k >= 97 && k <= 122)
                        {
                            k -= 71;
                        } else
                        if (k >= 48 && k <= 57)
                        {
                            k += 4;
                        } else
                        if (k == 43)
                        {
                            k = 62;
                        } else
                        if (k == 47)
                        {
                            k = 63;
                        } else
                        {
                            return null;
                        }
                        k = i1 << 6 | (byte)k;
                        if (l % 4 == 3)
                        {
                            i1 = i + 1;
                            abyte1[i] = (byte)((0xff0000 & k) >> 16);
                            int i2 = i1 + 1;
                            abyte1[i1] = (byte)((0xff00 & k) >> 8);
                            i = i2 + 1;
                            abyte1[i2] = (byte)(k & 0xff);
                        }
                        i1 = l + 1;
                        l = i;
                        i = k;
                        k = i1;
                    }
                } else
                {
                    k = i1;
                    i1 = i;
                    i = k;
                    k = l;
                    l = i1;
                }
                l1++;
                i1 = i;
                i = l;
                l = k;
            }
            k = i;
            if (j1 > 0)
            {
                l = i1 << j1 * 6;
                k = i + 1;
                abyte1[i] = (byte)((0xff0000 & l) >> 16);
                if (j1 == 1)
                {
                    i = k + 1;
                    abyte1[k] = (byte)((0xff00 & l) >> 8);
                    k = i;
                }
            }
            abyte0 = new byte[k];
            System.arraycopy(abyte1, 0, abyte0, 0, k);
            return abyte0;
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    public static String encode(byte abyte0[], String s)
    {
        byte abyte1[];
        int i;
        int l1;
        i = (abyte0.length * 4) / 3;
        abyte1 = new byte[i + (i / 76 + 3)];
        l1 = abyte0.length - abyte0.length % 3;
        int i1 = 0;
        int j = 0;
        i = 0;
        for (; j < l1; j += 3)
        {
            int j1 = i + 1;
            abyte1[i] = MAP[(abyte0[j] & 0xff) >> 2];
            i = j1 + 1;
            abyte1[j1] = MAP[(abyte0[j] & 3) << 4 | (abyte0[j + 1] & 0xff) >> 4];
            j1 = i + 1;
            abyte1[i] = MAP[(abyte0[j + 1] & 0xf) << 2 | (abyte0[j + 2] & 0xff) >> 6];
            i = j1 + 1;
            abyte1[j1] = MAP[abyte0[j + 2] & 0x3f];
            if ((i - i1) % 76 == 0 && i != 0)
            {
                int k1 = i + 1;
                abyte1[i] = 10;
                i1++;
                i = k1;
            }
        }

        abyte0.length % 3;
        JVM INSTR tableswitch 1 2: default 224
    //                   1 236
    //                   2 303;
           goto _L1 _L2 _L3
_L1:
        return new String(abyte1, 0, i, s);
_L2:
        int k = i + 1;
        abyte1[i] = MAP[(abyte0[l1] & 0xff) >> 2];
        i = k + 1;
        abyte1[k] = MAP[(abyte0[l1] & 3) << 4];
        k = i + 1;
        abyte1[i] = 61;
        i = k + 1;
        abyte1[k] = 61;
        continue; /* Loop/switch isn't completed */
_L3:
        int l = i + 1;
        abyte1[i] = MAP[(abyte0[l1] & 0xff) >> 2];
        i = l + 1;
        abyte1[l] = MAP[(abyte0[l1] & 3) << 4 | (abyte0[l1 + 1] & 0xff) >> 4];
        l = i + 1;
        abyte1[i] = MAP[(abyte0[l1 + 1] & 0xf) << 2];
        i = l + 1;
        abyte1[l] = 61;
        if (true) goto _L1; else goto _L4
_L4:
    }

}
