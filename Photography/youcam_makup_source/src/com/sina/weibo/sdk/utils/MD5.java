// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import java.io.PrintStream;
import java.security.MessageDigest;

public class MD5
{

    private static final char hexDigits[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };

    public MD5()
    {
    }

    public static String hexdigest(String s)
    {
        try
        {
            s = hexdigest(s.getBytes());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    public static String hexdigest(byte abyte0[])
    {
        int i = 0;
        char ac[];
        MessageDigest messagedigest = MessageDigest.getInstance("MD5");
        messagedigest.update(abyte0);
        abyte0 = messagedigest.digest();
        ac = new char[32];
        int j = 0;
_L2:
        if (i >= 16)
        {
            byte byte0;
            int k;
            try
            {
                return new String(ac);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                abyte0.printStackTrace();
            }
            break; /* Loop/switch isn't completed */
        }
        byte0 = abyte0[i];
        k = j + 1;
        ac[j] = hexDigits[byte0 >>> 4 & 0xf];
        j = k + 1;
        ac[k] = hexDigits[byte0 & 0xf];
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return null;
    }

    public static void main(String args[])
    {
        System.out.println(hexdigest("c"));
    }

}
