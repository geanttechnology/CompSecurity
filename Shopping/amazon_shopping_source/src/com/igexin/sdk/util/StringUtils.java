// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtils
{

    public StringUtils()
    {
    }

    public static String getMD5Str(String s)
    {
        char ac1[];
        byte abyte0[];
        abyte0 = s.getBytes();
        ac1 = new char[16];
        ac1;
        ac1[0] = '0';
        ac1[1] = '1';
        ac1[2] = '2';
        ac1[3] = '3';
        ac1[4] = '4';
        ac1[5] = '5';
        ac1[6] = '6';
        ac1[7] = '7';
        ac1[8] = '8';
        ac1[9] = '9';
        ac1[10] = 'a';
        ac1[11] = 'b';
        ac1[12] = 'c';
        ac1[13] = 'd';
        ac1[14] = 'e';
        ac1[15] = 'f';
        s = null;
        MessageDigest messagedigest = MessageDigest.getInstance("MD5");
        s = messagedigest;
_L2:
        if (s == null)
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        nosuchalgorithmexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        s.update(abyte0);
        s = s.digest();
        char ac[] = new char[32];
        int i = 0;
        int j = 0;
        for (; i < 16; i++)
        {
            byte byte0 = s[i];
            int k = j + 1;
            ac[j] = ac1[byte0 >>> 4 & 0xf];
            j = k + 1;
            ac[k] = ac1[byte0 & 0xf];
        }

        return new String(ac);
    }
}
