// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.silentupdate;


final class a
{

    private static final byte a[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };

    a()
    {
    }

    public static String a(byte abyte0[], String s)
    {
        byte abyte1[];
        int i;
        int l1;
        i = (abyte0.length * 4) / 3;
        abyte1 = new byte[i + (i / 76 + 3)];
        l1 = abyte0.length - abyte0.length % 3;
        int j = 0;
        int i1 = 0;
        i = 0;
        while (j < l1) 
        {
            int j1 = i + 1;
            abyte1[i] = a[(abyte0[j] & 0xff) >> 2];
            i = j1 + 1;
            abyte1[j1] = a[(abyte0[j] & 3) << 4 | (abyte0[j + 1] & 0xff) >> 4];
            j1 = i + 1;
            abyte1[i] = a[(abyte0[j + 1] & 0xf) << 2 | (abyte0[j + 2] & 0xff) >> 6];
            int k1 = j1 + 1;
            abyte1[j1] = a[abyte0[j + 2] & 0x3f];
            j1 = i1;
            i = k1;
            if ((k1 - i1) % 76 == 0)
            {
                if (k1 == 0)
                {
                    i = k1;
                    j1 = i1;
                } else
                {
                    abyte1[k1] = 10;
                    j1 = i1 + 1;
                    i = k1 + 1;
                }
            }
            j += 3;
            i1 = j1;
        }
        abyte0.length % 3;
        JVM INSTR tableswitch 1 2: default 248
    //                   1 260
    //                   2 327;
           goto _L1 _L2 _L3
_L1:
        return new String(abyte1, 0, i, s);
_L2:
        int k = i + 1;
        abyte1[i] = a[(abyte0[l1] & 0xff) >> 2];
        i = k + 1;
        abyte1[k] = a[(abyte0[l1] & 3) << 4];
        k = i + 1;
        abyte1[i] = 61;
        i = k + 1;
        abyte1[k] = 61;
        continue; /* Loop/switch isn't completed */
_L3:
        int l = i + 1;
        abyte1[i] = a[(abyte0[l1] & 0xff) >> 2];
        i = l + 1;
        abyte1[l] = a[(abyte0[l1] & 3) << 4 | (abyte0[l1 + 1] & 0xff) >> 4];
        l = i + 1;
        abyte1[i] = a[(abyte0[l1 + 1] & 0xf) << 2];
        i = l + 1;
        abyte1[l] = 61;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public static byte[] a(byte abyte0[])
    {
        return a(abyte0, abyte0.length);
    }

    public static byte[] a(byte abyte0[], int i)
    {
        int j = (i / 4) * 3;
        if (j == 0)
        {
            return new byte[0];
        }
        byte abyte1[] = new byte[j];
        int k1 = 0;
        int l1 = i;
        do
        {
            byte byte0 = abyte0[l1 - 1];
            i = k1;
            if (byte0 != 10)
            {
                i = k1;
                if (byte0 != 13)
                {
                    i = k1;
                    if (byte0 != 32)
                    {
                        i = k1;
                        if (byte0 != 9)
                        {
                            if (byte0 != 61)
                            {
                                int i2 = 0;
                                int l = 0;
                                int k = 0;
                                i = 0;
                                while (i2 < l1) 
                                {
                                    int i1 = abyte0[i2];
                                    if (i1 != 10 && i1 != 13)
                                    {
                                        if (i1 == 32)
                                        {
                                            i1 = l;
                                            l = i;
                                            i = i1;
                                        } else
                                        if (i1 == 9)
                                        {
                                            i1 = l;
                                            l = i;
                                            i = i1;
                                        } else
                                        {
                                            if (i1 >= 65 && i1 <= 90)
                                            {
                                                i1 -= 65;
                                            } else
                                            if (i1 >= 97 && i1 <= 122)
                                            {
                                                i1 -= 71;
                                            } else
                                            if (i1 >= 48 && i1 <= 57)
                                            {
                                                i1 += 4;
                                            } else
                                            if (i1 == 43)
                                            {
                                                i1 = 62;
                                            } else
                                            if (i1 == 47)
                                            {
                                                i1 = 63;
                                            } else
                                            {
                                                return null;
                                            }
                                            i1 = l << 6 | (byte)i1;
                                            if (k % 4 == 3)
                                            {
                                                l = i + 1;
                                                abyte1[i] = (byte)((0xff0000 & i1) >> 16);
                                                int j2 = l + 1;
                                                abyte1[l] = (byte)((0xff00 & i1) >> 8);
                                                i = j2 + 1;
                                                abyte1[j2] = (byte)(i1 & 0xff);
                                            }
                                            k++;
                                            l = i;
                                            i = i1;
                                        }
                                    } else
                                    {
                                        int j1 = l;
                                        l = i;
                                        i = j1;
                                    }
                                    i2++;
                                    i1 = i;
                                    i = l;
                                    l = i1;
                                }
                                break;
                            }
                            i = k1 + 1;
                        }
                    }
                }
            }
            l1--;
            k1 = i;
        } while (true);
        k = i;
        if (k1 > 0)
        {
            l <<= k1 * 6;
            k = i + 1;
            abyte1[i] = (byte)((0xff0000 & l) >> 16);
            if (k1 == 1)
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

}
