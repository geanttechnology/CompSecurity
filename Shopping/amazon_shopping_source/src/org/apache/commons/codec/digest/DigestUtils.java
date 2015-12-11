// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.codec.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.StringUtils;

public class DigestUtils
{

    public DigestUtils()
    {
    }

    private static byte[] getBytesUtf8(String s)
    {
        return StringUtils.getBytesUtf8(s);
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
        return md5(getBytesUtf8(s));
    }

    public static byte[] md5(byte abyte0[])
    {
        return getMd5Digest().digest(abyte0);
    }
}
