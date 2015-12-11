// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.volley;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class InternalUtils
{

    private static final char HEX_CHARS[] = "0123456789ABCDEF".toCharArray();

    InternalUtils()
    {
    }

    private static String convertToHex(byte abyte0[])
    {
        char ac[] = new char[abyte0.length * 2];
        for (int i = 0; i < abyte0.length; i++)
        {
            int j = abyte0[i] & 0xff;
            ac[i * 2] = HEX_CHARS[j >>> 4];
            ac[i * 2 + 1] = HEX_CHARS[j & 0xf];
        }

        return new String(ac);
    }

    public static String sha1Hash(String s)
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
            s = s.getBytes("UTF-8");
            messagedigest.update(s, 0, s.length);
            s = convertToHex(messagedigest.digest());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

}
