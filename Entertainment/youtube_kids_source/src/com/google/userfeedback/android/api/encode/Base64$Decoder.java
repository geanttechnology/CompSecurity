// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api.encode;


public class value extends value
{

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
    //                   0 303
    //                   1 333
    //                   2 373
    //                   3 445
    //                   4 564
    //                   5 600;
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
    //                   0 679
    //                   1 691
    //                   2 699
    //                   3 717
    //                   4 752;
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


    public (int i, byte abyte0[])
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
