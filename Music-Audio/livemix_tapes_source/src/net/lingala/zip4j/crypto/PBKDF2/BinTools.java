// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.crypto.PBKDF2;


class BinTools
{

    public static final String hex = "0123456789ABCDEF";

    BinTools()
    {
    }

    public static String bin2hex(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return "";
        }
        StringBuffer stringbuffer = new StringBuffer(abyte0.length * 2);
        int i = 0;
        do
        {
            if (i >= abyte0.length)
            {
                return stringbuffer.toString();
            }
            int j = (abyte0[i] + 256) % 256;
            stringbuffer.append("0123456789ABCDEF".charAt(j / 16 & 0xf));
            stringbuffer.append("0123456789ABCDEF".charAt(j % 16 & 0xf));
            i++;
        } while (true);
    }

    public static int hex2bin(char c)
    {
        if (c >= '0' && c <= '9')
        {
            return c - 48;
        }
        if (c >= 'A' && c <= 'F')
        {
            return (c - 65) + 10;
        }
        if (c >= 'a' && c <= 'f')
        {
            return (c - 97) + 10;
        } else
        {
            throw new IllegalArgumentException("Input string may only contain hex digits, but found '" + c + "'");
        }
    }

    public static byte[] hex2bin(String s)
    {
        String s1 = s;
        int i;
        int j;
        if (s == null)
        {
            s1 = "";
        } else
        if (s.length() % 2 != 0)
        {
            s1 = "0" + s;
        }
        s = new byte[s1.length() / 2];
        j = 0;
        i = 0;
        do
        {
            if (j >= s1.length())
            {
                return s;
            }
            int k = j + 1;
            char c = s1.charAt(j);
            j = k + 1;
            char c1 = s1.charAt(k);
            s[i] = (byte)(hex2bin(c) * 16 + hex2bin(c1));
            i++;
        } while (true);
    }
}
