// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class StringUtil
{

    public static String hashSHA256ToHex(String s)
        throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        s = s.getBytes("UTF-8");
        Object obj = MessageDigest.getInstance("SHA-256");
        ((MessageDigest) (obj)).update(s);
        s = ((MessageDigest) (obj)).digest();
        obj = new StringBuilder(s.length * 2);
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            ((StringBuilder) (obj)).append(String.format("%02X", new Object[] {
                Integer.valueOf(s[i] & 0xff)
            }));
        }

        return ((StringBuilder) (obj)).toString();
    }

    public static boolean isEmptyOrWhitespace(String s)
    {
        return s == null || s.trim().length() == 0;
    }
}
