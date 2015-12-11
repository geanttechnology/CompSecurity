// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.utils;


public class HexUtils
{

    private static final char HEX_CHARS[] = "0123456789ABCDEF".toCharArray();

    public HexUtils()
    {
    }

    public static String bytesToHex(byte abyte0[])
    {
        char ac[] = new char[abyte0.length << 1];
        for (int i = 0; i < abyte0.length; i++)
        {
            byte byte0 = abyte0[i];
            char c = HEX_CHARS[byte0 >> 4 & 0xf];
            char c1 = HEX_CHARS[byte0 & 0xf];
            ac[i << 1] = c;
            ac[(i << 1) + 1] = c1;
        }

        return new String(ac);
    }

    public static byte[] hexToBytes(CharSequence charsequence)
    {
        int i = 0;
        byte abyte0[] = new byte[(charsequence.length() + 1) / 2];
        if (charsequence.length() == 0)
        {
            return abyte0;
        }
        abyte0[0] = 0;
        int j = charsequence.length() % 2;
        while (i < charsequence.length()) 
        {
            char c = charsequence.charAt(i);
            if (!isHex(c))
            {
                throw new IllegalArgumentException("string contains non-hex chars");
            }
            if (j % 2 == 0)
            {
                abyte0[j >> 1] = (byte)(hexValue(c) << 4);
            } else
            {
                int k = j >> 1;
                byte byte0 = abyte0[k];
                abyte0[k] = (byte)((byte)hexValue(c) + byte0);
            }
            j++;
            i++;
        }
        return abyte0;
    }

    private static int hexValue(char c)
    {
        if (c >= '0' && c <= '9')
        {
            return c - 48;
        }
        if (c >= 'a' && c <= 'f')
        {
            return (c - 97) + 10;
        } else
        {
            return (c - 65) + 10;
        }
    }

    private static boolean isHex(char c)
    {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F';
    }

}
