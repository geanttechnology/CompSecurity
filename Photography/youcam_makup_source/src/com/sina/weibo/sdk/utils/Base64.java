// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;


public final class Base64
{

    private static char alphabet[];
    private static byte codes[];

    public Base64()
    {
    }

    public static byte[] decode(byte abyte0[])
    {
        int j1 = 0;
        int k = ((abyte0.length + 3) / 4) * 3;
        int i = k;
        if (abyte0.length > 0)
        {
            i = k;
            if (abyte0[abyte0.length - 1] == 61)
            {
                i = k - 1;
            }
        }
        k = i;
        if (abyte0.length > 1)
        {
            k = i;
            if (abyte0[abyte0.length - 2] == 61)
            {
                k = i - 1;
            }
        }
        byte abyte1[] = new byte[k];
        int i1 = 0;
        int k1 = 0;
        int l1 = 0;
        do
        {
            int j;
            int l;
            int i2;
            byte byte0;
            if (i1 >= abyte0.length)
            {
                if (j1 != abyte1.length)
                {
                    throw new RuntimeException("miscalculated data length!");
                } else
                {
                    return abyte1;
                }
            }
            byte0 = codes[abyte0[i1] & 0xff];
            i2 = j1;
            j = k1;
            l = l1;
            if (byte0 >= 0)
            {
                l = l1 + 6;
                j = k1 << 6 | byte0;
                if (l >= 8)
                {
                    l -= 8;
                    abyte1[j1] = (byte)(j >> l & 0xff);
                    i2 = j1 + 1;
                } else
                {
                    i2 = j1;
                }
            }
            i1++;
            j1 = i2;
            k1 = j;
            l1 = l;
        } while (true);
    }

    public static char[] encode(byte abyte0[])
    {
        char ac[] = new char[((abyte0.length + 2) / 3) * 4];
        int i = 0;
        int j = 0;
        do
        {
            if (j >= abyte0.length)
            {
                return ac;
            }
            int l = (abyte0[j] & 0xff) << 8;
            char ac1[];
            int k;
            int i1;
            if (j + 1 < abyte0.length)
            {
                l |= abyte0[j + 1] & 0xff;
                k = 1;
            } else
            {
                k = 0;
            }
            l <<= 8;
            if (j + 2 < abyte0.length)
            {
                l |= abyte0[j + 2] & 0xff;
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            ac1 = alphabet;
            if (i1 != 0)
            {
                i1 = l & 0x3f;
            } else
            {
                i1 = 64;
            }
            ac[i + 3] = ac1[i1];
            l >>= 6;
            ac1 = alphabet;
            if (k != 0)
            {
                k = l & 0x3f;
            } else
            {
                k = 64;
            }
            ac[i + 2] = ac1[k];
            k = l >> 6;
            ac[i + 1] = alphabet[k & 0x3f];
            ac[i + 0] = alphabet[k >> 6 & 0x3f];
            j += 3;
            i += 4;
        } while (true);
    }

    public static byte[] encodebyte(byte abyte0[])
    {
        byte abyte1[] = new byte[((abyte0.length + 2) / 3) * 4];
        int i = 0;
        int j = 0;
        do
        {
            if (j >= abyte0.length)
            {
                return abyte1;
            }
            int l = (abyte0[j] & 0xff) << 8;
            char ac[];
            int k;
            int i1;
            if (j + 1 < abyte0.length)
            {
                l |= abyte0[j + 1] & 0xff;
                k = 1;
            } else
            {
                k = 0;
            }
            l <<= 8;
            if (j + 2 < abyte0.length)
            {
                l |= abyte0[j + 2] & 0xff;
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            ac = alphabet;
            if (i1 != 0)
            {
                i1 = l & 0x3f;
            } else
            {
                i1 = 64;
            }
            abyte1[i + 3] = (byte)ac[i1];
            l >>= 6;
            ac = alphabet;
            if (k != 0)
            {
                k = l & 0x3f;
            } else
            {
                k = 64;
            }
            abyte1[i + 2] = (byte)ac[k];
            k = l >> 6;
            abyte1[i + 1] = (byte)alphabet[k & 0x3f];
            abyte1[i + 0] = (byte)alphabet[k >> 6 & 0x3f];
            j += 3;
            i += 4;
        } while (true);
    }

    static 
    {
        int i;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
        codes = new byte[256];
        i = 0;
_L7:
        if (i < 256) goto _L2; else goto _L1
_L1:
        i = 65;
_L8:
        if (i <= 90) goto _L4; else goto _L3
_L3:
        i = 97;
_L9:
        if (i <= 122) goto _L6; else goto _L5
_L5:
        i = 48;
_L10:
        if (i > 57)
        {
            codes[43] = 62;
            codes[47] = 63;
            return;
        }
        break MISSING_BLOCK_LABEL_119;
_L2:
        codes[i] = -1;
        i++;
          goto _L7
_L4:
        codes[i] = (byte)(i - 65);
        i++;
          goto _L8
_L6:
        codes[i] = (byte)((i + 26) - 97);
        i++;
          goto _L9
        codes[i] = (byte)((i + 52) - 48);
        i++;
          goto _L10
    }
}
