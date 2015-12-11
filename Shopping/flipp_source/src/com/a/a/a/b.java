// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import java.io.UnsupportedEncodingException;

// Referenced classes of package com.a.a.a:
//            u

public final class b
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

    public static byte[] a(byte abyte0[])
    {
        int j1 = abyte0.length;
        int i = (j1 / 4) * 3;
        if (i == 0)
        {
            return u.a;
        }
        byte abyte1[] = new byte[i];
        int i1 = 0;
        do
        {
            byte byte0 = abyte0[j1 - 1];
            i = i1;
            if (byte0 != 10)
            {
                i = i1;
                if (byte0 != 13)
                {
                    i = i1;
                    if (byte0 != 32)
                    {
                        i = i1;
                        if (byte0 != 9)
                        {
                            if (byte0 != 61)
                            {
                                break;
                            }
                            i = i1 + 1;
                        }
                    }
                }
            }
            j1--;
            i1 = i;
        } while (true);
        int k1 = 0;
        int l = 0;
        int k = 0;
        i = 0;
        while (k1 < j1) 
        {
            int j = abyte0[k1];
            if (j != 10 && j != 13 && j != 32 && j != 9)
            {
                if (j >= 65 && j <= 90)
                {
                    j -= 65;
                } else
                if (j >= 97 && j <= 122)
                {
                    j -= 71;
                } else
                if (j >= 48 && j <= 57)
                {
                    j += 4;
                } else
                if (j == 43)
                {
                    j = 62;
                } else
                if (j == 47)
                {
                    j = 63;
                } else
                {
                    return null;
                }
                l = l << 6 | (byte)j;
                if (k % 4 == 3)
                {
                    j = i + 1;
                    abyte1[i] = (byte)(l >> 16);
                    int l1 = j + 1;
                    abyte1[j] = (byte)(l >> 8);
                    i = l1 + 1;
                    abyte1[l1] = (byte)l;
                }
                k++;
                j = i;
                i = l;
            } else
            {
                j = i;
                i = l;
            }
            k1++;
            l = i;
            i = j;
        }
        j = i;
        if (i1 > 0)
        {
            k = l << i1 * 6;
            j = i + 1;
            abyte1[i] = (byte)(k >> 16);
            if (i1 == 1)
            {
                i = j + 1;
                abyte1[j] = (byte)(k >> 8);
                j = i;
            }
        }
        abyte0 = new byte[j];
        System.arraycopy(abyte1, 0, abyte0, 0, j);
        return abyte0;
    }

    public static String b(byte abyte0[])
    {
        byte abyte1[];
        int i;
        int l;
        i = 0;
        abyte1 = new byte[((abyte0.length + 2) * 4) / 3];
        l = abyte0.length - abyte0.length % 3;
        for (int j = 0; j < l;)
        {
            int i1 = i + 1;
            abyte1[i] = a[(abyte0[j] & 0xff) >> 2];
            i = i1 + 1;
            abyte1[i1] = a[(abyte0[j] & 3) << 4 | (abyte0[j + 1] & 0xff) >> 4];
            i1 = i + 1;
            abyte1[i] = a[(abyte0[j + 1] & 0xf) << 2 | (abyte0[j + 2] & 0xff) >> 6];
            abyte1[i1] = a[abyte0[j + 2] & 0x3f];
            j += 3;
            i = i1 + 1;
        }

        abyte0.length % 3;
        JVM INSTR tableswitch 1 2: default 172
    //                   1 187
    //                   2 248;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_248;
_L4:
        int k;
        try
        {
            abyte0 = new String(abyte1, 0, i, "US-ASCII");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new AssertionError(abyte0);
        }
        return abyte0;
_L2:
        k = i + 1;
        abyte1[i] = a[(abyte0[l] & 0xff) >> 2];
        i = k + 1;
        abyte1[k] = a[(abyte0[l] & 3) << 4];
        k = i + 1;
        abyte1[i] = 61;
        i = k + 1;
        abyte1[k] = 61;
          goto _L4
        k = i + 1;
        abyte1[i] = a[(abyte0[l] & 0xff) >> 2];
        i = k + 1;
        abyte1[k] = a[(abyte0[l] & 3) << 4 | (abyte0[l + 1] & 0xff) >> 4];
        k = i + 1;
        abyte1[i] = a[(abyte0[l + 1] & 0xf) << 2];
        i = k + 1;
        abyte1[k] = 61;
          goto _L4
    }

}
