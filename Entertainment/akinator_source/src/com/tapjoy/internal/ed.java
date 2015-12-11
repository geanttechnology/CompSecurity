// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


final class ed
{

    static int a(int i, int j)
    {
        if (i > -12 || j > -65)
        {
            return -1;
        } else
        {
            return j << 8 ^ i;
        }
    }

    static int a(int i, int j, int k)
    {
        if (i > -12 || j > -65 || k > -65)
        {
            return -1;
        } else
        {
            return j << 8 ^ i ^ k << 16;
        }
    }

    public static int a(byte abyte0[], int i, int j)
    {
        int k;
        for (k = i; k < j && abyte0[k] >= 0; k++) { }
        i = k;
        if (k < j) goto _L2; else goto _L1
_L1:
        i = 0;
_L6:
        return i;
_L4:
        i = k;
_L2:
        byte byte0;
        if (i >= j)
        {
            return 0;
        }
        k = i + 1;
        byte0 = abyte0[i];
        if (byte0 >= 0) goto _L4; else goto _L3
_L3:
        if (byte0 >= -32)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        i = byte0;
        if (k >= j) goto _L6; else goto _L5
_L5:
        if (byte0 < -62)
        {
            break; /* Loop/switch isn't completed */
        }
        i = k + 1;
        if (abyte0[k] <= -65) goto _L2; else goto _L7
_L7:
        return -1;
        int l;
        if (byte0 >= -16)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        if (k >= j - 1)
        {
            return b(abyte0, k, j);
        }
        l = k + 1;
        i = abyte0[k];
        if (i > -65 || byte0 == -32 && i < -96 || byte0 == -19 && i >= -96)
        {
            break; /* Loop/switch isn't completed */
        }
        i = l + 1;
        if (abyte0[l] <= -65) goto _L2; else goto _L8
_L8:
        return -1;
        if (k >= j - 2)
        {
            return b(abyte0, k, j);
        }
        i = k + 1;
        k = abyte0[k];
        if (k > -65 || (byte0 << 28) + (k + 112) >> 30 != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        k = i + 1;
        if (abyte0[i] > -65)
        {
            break; /* Loop/switch isn't completed */
        }
        i = k + 1;
        if (abyte0[k] <= -65) goto _L2; else goto _L9
_L9:
        return -1;
    }

    private static int b(byte abyte0[], int i, int j)
    {
        byte byte0 = abyte0[i - 1];
        switch (j - i)
        {
        default:
            throw new AssertionError();

        case 0: // '\0'
            i = byte0;
            if (byte0 > -12)
            {
                i = -1;
            }
            return i;

        case 1: // '\001'
            return a(byte0, abyte0[i]);

        case 2: // '\002'
            return a(byte0, abyte0[i], abyte0[i + 1]);
        }
    }
}
