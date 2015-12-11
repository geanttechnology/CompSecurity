// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import java.io.IOException;

// Referenced classes of package com.aio.downloader.utils:
//            MyBase64

public class ASCIIutil
{

    public ASCIIutil()
    {
    }

    public static String ByteArrayToString(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (abyte0 == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = abyte0.length;
        i = 0;
_L5:
        if (i < j) goto _L3; else goto _L2
_L2:
        return stringbuilder.toString();
_L3:
        stringbuilder.append(String.format("%02X ", new Object[] {
            Byte.valueOf(abyte0[i])
        }));
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static String asciiToString(String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        s = s.split(",");
        int i = 0;
        do
        {
            if (i >= s.length)
            {
                return stringbuffer.toString();
            }
            stringbuffer.append((char)Integer.parseInt(s[i]));
            i++;
        } while (true);
    }

    public static String stringToAscii(String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        s = s.toCharArray();
        int i = 0;
        do
        {
            if (i >= s.length)
            {
                return stringbuffer.toString();
            }
            if (i != s.length - 1)
            {
                stringbuffer.append(s[i]).append(",");
            } else
            {
                stringbuffer.append(s[i]);
            }
            i++;
        } while (true);
    }

    public static String toparse(String s)
    {
        char ac[] = s.toCharArray();
        String s1 = "";
        int j = 0;
        do
        {
            if (j >= ac.length)
            {
                int i;
                char c;
                int k;
                try
                {
                    s = new String(MyBase64.decode(s1));
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s.printStackTrace();
                    return s1;
                }
                return s;
            }
            c = s.charAt(j);
            if (c >= '0' && c <= '9' || c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z')
            {
                k = c - j % 10;
                if (k < 48)
                {
                    i = (122 - (48 - k)) + 1;
                } else
                if (c >= 'A' && k < 65)
                {
                    i = (57 - (65 - k)) + 1;
                } else
                {
                    i = k;
                    if (c >= 'a')
                    {
                        i = k;
                        if (k < 97)
                        {
                            i = (90 - (97 - k)) + 1;
                        }
                    }
                }
            } else
            {
                i = c;
            }
            s1 = (new StringBuilder(String.valueOf(s1))).append(asciiToString(String.valueOf(i))).toString();
            j++;
        } while (true);
    }
}
