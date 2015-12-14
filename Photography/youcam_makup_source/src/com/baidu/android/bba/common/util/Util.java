// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.bba.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Util
{

    private Util()
    {
    }

    public static String toHexString(byte abyte0[], String s, boolean flag)
    {
        StringBuilder stringbuilder = new StringBuilder();
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            String s2 = Integer.toHexString(abyte0[i] & 0xff);
            String s1 = s2;
            if (flag)
            {
                s1 = s2.toUpperCase();
            }
            if (s1.length() == 1)
            {
                stringbuilder.append("0");
            }
            stringbuilder.append(s1).append(s);
        }

        return stringbuilder.toString();
    }

    public static String toMd5(byte abyte0[], boolean flag)
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.reset();
            messagedigest.update(abyte0);
            abyte0 = toHexString(messagedigest.digest(), "", flag);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new RuntimeException(abyte0);
        }
        return abyte0;
    }
}
