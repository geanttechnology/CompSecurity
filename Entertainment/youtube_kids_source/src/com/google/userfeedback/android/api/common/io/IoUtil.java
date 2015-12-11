// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api.common.io;


public class IoUtil
{

    public IoUtil()
    {
    }

    public static String decodeUtf8(byte abyte0[], int i, int j, boolean flag)
    {
        StringBuffer stringbuffer = new StringBuffer(j - i);
        while (i < j) 
        {
            int k = i + 1;
            int l1 = abyte0[i] & 0xff;
            if (l1 <= 127)
            {
                stringbuffer.append((char)l1);
                i = k;
            } else
            if (l1 >= 245)
            {
                if (!flag)
                {
                    throw new IllegalArgumentException("Invalid UTF8");
                }
                stringbuffer.append((char)l1);
                i = k;
            } else
            {
                int i1 = 1;
                i = 31;
                int j1 = 224;
                int l = 128;
                while (l1 >= j1) 
                {
                    byte byte0;
                    if (i1 == 1)
                    {
                        byte0 = 4;
                    } else
                    {
                        byte0 = 5;
                    }
                    i >>= 1;
                    i1++;
                    l <<= byte0;
                    j1 = j1 >> 1 | 0x80;
                }
                j1 = 0;
                int k1 = i & l1;
                i = k;
                k = k1;
                for (; j1 < i1; j1++)
                {
                    k <<= 6;
                    if (i >= j)
                    {
                        if (!flag)
                        {
                            throw new IllegalArgumentException("Invalid UTF8");
                        }
                        continue;
                    }
                    if (!flag && (abyte0[i] & 0xc0) != 128)
                    {
                        throw new IllegalArgumentException("Invalid UTF8");
                    }
                    k |= abyte0[i] & 0x3f;
                    i++;
                }

                if (!flag && k < l || k >= 55296 && k <= 57343)
                {
                    throw new IllegalArgumentException("Invalid UTF8");
                }
                if (k <= 65535)
                {
                    stringbuffer.append((char)k);
                } else
                {
                    k -= 0x10000;
                    stringbuffer.append((char)(0xd800 | k >> 10));
                    stringbuffer.append((char)(k & 0x3ff | 0xdc00));
                }
            }
        }
        return stringbuffer.toString();
    }

    public static int encodeUtf8(String s, byte abyte0[], int i)
    {
        int j1 = s.length();
        int j = 0;
        int k = i;
        while (j < j1) 
        {
            i = s.charAt(j);
            int i1 = i;
            int l = j;
            if (i >= 55296)
            {
                i1 = i;
                l = j;
                if (i <= 57343)
                {
                    i1 = i;
                    l = j;
                    if (j + 1 < j1)
                    {
                        char c = s.charAt(j + 1);
                        i1 = i;
                        l = j;
                        if ((c & 0xfc00 ^ i & 0xfc00) == 1024)
                        {
                            l = j + 1;
                            if ((c & 0xfc00) == 55296)
                            {
                                j = i;
                                i = c;
                            } else
                            {
                                j = c;
                            }
                            i1 = 0x10000 + ((i & 0x3ff) << 10 | j & 0x3ff);
                        }
                    }
                }
            }
            if (i1 <= 127)
            {
                if (abyte0 != null)
                {
                    abyte0[k] = (byte)i1;
                }
                i = k + 1;
            } else
            if (i1 <= 2047)
            {
                if (abyte0 != null)
                {
                    abyte0[k] = (byte)(i1 >> 6 | 0xc0);
                    abyte0[k + 1] = (byte)(i1 & 0x3f | 0x80);
                }
                i = k + 2;
            } else
            if (i1 <= 65535)
            {
                if (abyte0 != null)
                {
                    abyte0[k] = (byte)(i1 >> 12 | 0xe0);
                    abyte0[k + 1] = (byte)(i1 >> 6 & 0x3f | 0x80);
                    abyte0[k + 2] = (byte)(i1 & 0x3f | 0x80);
                }
                i = k + 3;
            } else
            {
                if (abyte0 != null)
                {
                    abyte0[k] = (byte)(i1 >> 18 | 0xf0);
                    abyte0[k + 1] = (byte)(i1 >> 12 & 0x3f | 0x80);
                    abyte0[k + 2] = (byte)(i1 >> 6 & 0x3f | 0x80);
                    abyte0[k + 3] = (byte)(i1 & 0x3f | 0x80);
                }
                i = k + 4;
            }
            j = l + 1;
            k = i;
        }
        return k;
    }

    public static byte[] encodeUtf8(String s)
    {
        byte abyte0[] = new byte[encodeUtf8(s, null, 0)];
        encodeUtf8(s, abyte0, 0);
        return abyte0;
    }
}
