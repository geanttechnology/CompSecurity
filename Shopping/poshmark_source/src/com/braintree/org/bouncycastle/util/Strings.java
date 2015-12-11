// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.util;

import java.io.ByteArrayOutputStream;
import java.util.Vector;

public final class Strings
{

    public Strings()
    {
    }

    public static String fromUTF8ByteArray(byte abyte0[])
    {
        int i = 0;
        int j = 0;
        while (i < abyte0.length) 
        {
            j++;
            if ((abyte0[i] & 0xf0) == 240)
            {
                j++;
                i += 4;
            } else
            if ((abyte0[i] & 0xe0) == 224)
            {
                i += 3;
            } else
            if ((abyte0[i] & 0xc0) == 192)
            {
                i += 2;
            } else
            {
                i++;
            }
        }
        char ac[] = new char[j];
        i = 0;
        j = 0;
        while (i < abyte0.length) 
        {
            char c;
            if ((abyte0[i] & 0xf0) == 240)
            {
                int k = ((abyte0[i] & 3) << 18 | (abyte0[i + 1] & 0x3f) << 12 | (abyte0[i + 2] & 0x3f) << 6 | abyte0[i + 3] & 0x3f) - 0x10000;
                char c1 = (char)(0xd800 | k >> 10);
                c = (char)(0xdc00 | k & 0x3ff);
                ac[j] = c1;
                i += 4;
                j++;
            } else
            if ((abyte0[i] & 0xe0) == 224)
            {
                c = (char)((abyte0[i] & 0xf) << 12 | (abyte0[i + 1] & 0x3f) << 6 | abyte0[i + 2] & 0x3f);
                i += 3;
            } else
            if ((abyte0[i] & 0xd0) == 208)
            {
                c = (char)((abyte0[i] & 0x1f) << 6 | abyte0[i + 1] & 0x3f);
                i += 2;
            } else
            if ((abyte0[i] & 0xc0) == 192)
            {
                c = (char)((abyte0[i] & 0x1f) << 6 | abyte0[i + 1] & 0x3f);
                i += 2;
            } else
            {
                c = (char)(abyte0[i] & 0xff);
                i++;
            }
            ac[j] = c;
            j++;
        }
        return new String(ac);
    }

    public static String[] split(String s, char c)
    {
        Vector vector = new Vector();
        for (boolean flag = true; flag;)
        {
            int i = s.indexOf(c);
            if (i > 0)
            {
                vector.addElement(s.substring(0, i));
                s = s.substring(i + 1);
            } else
            {
                flag = false;
                vector.addElement(s);
            }
        }

        s = new String[vector.size()];
        for (c = '\0'; c != s.length; c++)
        {
            s[c] = (String)vector.elementAt(c);
        }

        return s;
    }

    public static byte[] toByteArray(String s)
    {
        byte abyte0[] = new byte[s.length()];
        for (int i = 0; i != abyte0.length; i++)
        {
            abyte0[i] = (byte)s.charAt(i);
        }

        return abyte0;
    }

    public static byte[] toByteArray(char ac[])
    {
        byte abyte0[] = new byte[ac.length];
        for (int i = 0; i != abyte0.length; i++)
        {
            abyte0[i] = (byte)ac[i];
        }

        return abyte0;
    }

    public static String toLowerCase(String s)
    {
        boolean flag = false;
        char ac[] = s.toCharArray();
        for (int i = 0; i != ac.length;)
        {
            char c = ac[i];
            boolean flag1 = flag;
            if ('A' <= c)
            {
                flag1 = flag;
                if ('Z' >= c)
                {
                    flag1 = true;
                    ac[i] = (char)((c - 65) + 97);
                }
            }
            i++;
            flag = flag1;
        }

        if (flag)
        {
            s = new String(ac);
        }
        return s;
    }

    public static byte[] toUTF8ByteArray(String s)
    {
        return toUTF8ByteArray(s.toCharArray());
    }

    public static byte[] toUTF8ByteArray(char ac[])
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        int i = 0;
        while (i < ac.length) 
        {
            int j = ac[i];
            if (j < 128)
            {
                bytearrayoutputstream.write(j);
            } else
            if (j < 2048)
            {
                bytearrayoutputstream.write(j >> 6 | 0xc0);
                bytearrayoutputstream.write(j & 0x3f | 0x80);
            } else
            if (j >= 55296 && j <= 57343)
            {
                if (i + 1 >= ac.length)
                {
                    throw new IllegalStateException("invalid UTF-16 codepoint");
                }
                i++;
                char c = ac[i];
                if (j > 56319)
                {
                    throw new IllegalStateException("invalid UTF-16 codepoint");
                }
                j = ((j & 0x3ff) << 10 | c & 0x3ff) + 0x10000;
                bytearrayoutputstream.write(j >> 18 | 0xf0);
                bytearrayoutputstream.write(j >> 12 & 0x3f | 0x80);
                bytearrayoutputstream.write(j >> 6 & 0x3f | 0x80);
                bytearrayoutputstream.write(j & 0x3f | 0x80);
            } else
            {
                bytearrayoutputstream.write(j >> 12 | 0xe0);
                bytearrayoutputstream.write(j >> 6 & 0x3f | 0x80);
                bytearrayoutputstream.write(j & 0x3f | 0x80);
            }
            i++;
        }
        return bytearrayoutputstream.toByteArray();
    }

    public static String toUpperCase(String s)
    {
        boolean flag = false;
        char ac[] = s.toCharArray();
        for (int i = 0; i != ac.length;)
        {
            char c = ac[i];
            boolean flag1 = flag;
            if ('a' <= c)
            {
                flag1 = flag;
                if ('z' >= c)
                {
                    flag1 = true;
                    ac[i] = (char)((c - 97) + 65);
                }
            }
            i++;
            flag = flag1;
        }

        if (flag)
        {
            s = new String(ac);
        }
        return s;
    }
}
