// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.disklrumulticache;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class DigestUtils
{

    private static final char DIGITS[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };

    DigestUtils()
    {
    }

    public static char[] encodeHex(byte abyte0[])
    {
        int k = abyte0.length;
        char ac[] = new char[k << 1];
        int i = 0;
        int j = 0;
        for (; i < k; i++)
        {
            int l = j + 1;
            ac[j] = DIGITS[(abyte0[i] & 0xf0) >>> 4];
            j = l + 1;
            ac[l] = DIGITS[abyte0[i] & 0xf];
        }

        return ac;
    }

    static MessageDigest getDigest(String s)
    {
        try
        {
            s = MessageDigest.getInstance(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s.getMessage());
        }
        return s;
    }

    private static MessageDigest getMd5Digest()
    {
        return getDigest("MD5");
    }

    public static byte[] md5(String s)
    {
        return md5(s.getBytes());
    }

    public static byte[] md5(byte abyte0[])
    {
        return getMd5Digest().digest(abyte0);
    }

    public static String md5Hex(String s)
    {
        return new String(encodeHex(md5(s)));
    }

}
