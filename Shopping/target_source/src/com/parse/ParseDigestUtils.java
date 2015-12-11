// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class ParseDigestUtils
{

    private static final char hexArray[] = "0123456789abcdef".toCharArray();

    private ParseDigestUtils()
    {
    }

    public static String md5(String s)
    {
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance("MD5");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        messagedigest.update(s.getBytes());
        return toHex(messagedigest.digest());
    }

    private static String toHex(byte abyte0[])
    {
        char ac[] = new char[abyte0.length * 2];
        for (int i = 0; i < abyte0.length; i++)
        {
            int j = abyte0[i] & 0xff;
            ac[i * 2] = hexArray[j >>> 4];
            ac[i * 2 + 1] = hexArray[j & 0xf];
        }

        return new String(ac);
    }

}
