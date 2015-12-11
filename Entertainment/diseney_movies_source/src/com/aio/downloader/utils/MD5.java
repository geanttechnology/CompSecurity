// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{

    private static final String HASH_ALGORITHM = "MD5";
    private static final int RADIX = 36;

    public MD5()
    {
    }

    public static String enlode(String s)
    {
        return (new BigInteger(getMD5(s.getBytes()))).abs().toString(36);
    }

    private static String getHashString(MessageDigest messagedigest)
    {
        StringBuilder stringbuilder = new StringBuilder();
        messagedigest = messagedigest.digest();
        int j = messagedigest.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                return stringbuilder.toString();
            }
            byte byte0 = messagedigest[i];
            stringbuilder.append(Integer.toHexString(byte0 >> 4 & 0xf));
            stringbuilder.append(Integer.toHexString(byte0 & 0xf));
            i++;
        } while (true);
    }

    public static String getMD5(String s)
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(s.getBytes());
            s = getHashString(messagedigest);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    private static byte[] getMD5(byte abyte0[])
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(abyte0);
            abyte0 = messagedigest.digest();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return null;
        }
        return abyte0;
    }

    public static String getMd5Name(String s)
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(s.getBytes());
            s = (new BigInteger(messagedigest.digest())).abs().toString(36);
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
