// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.io.IOUtils;

public class Md5Util
{

    protected static final char hexArray[] = "0123456789abcdef".toCharArray();

    public static String bytesToHex(byte abyte0[])
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

    public static byte[] md5AsBytes(String s)
        throws NoSuchAlgorithmException, IOException
    {
        Object obj;
        MessageDigest messagedigest;
        messagedigest = MessageDigest.getInstance("MD5");
        obj = null;
        s = new FileInputStream(s);
        obj = new byte[32768];
_L3:
        int i = s.read(((byte []) (obj)));
        if (i <= 0) goto _L2; else goto _L1
_L1:
        messagedigest.update(((byte []) (obj)), 0, i);
          goto _L3
        obj;
_L5:
        if (s != null)
        {
            IOUtils.closeQuietly(s);
        }
        throw obj;
_L2:
        if (s != null)
        {
            IOUtils.closeQuietly(s);
        }
        return messagedigest.digest();
        Exception exception;
        exception;
        s = ((String) (obj));
        obj = exception;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static String md5AsHex(String s)
        throws NoSuchAlgorithmException, IOException
    {
        return bytesToHex(md5AsBytes(s));
    }

}
