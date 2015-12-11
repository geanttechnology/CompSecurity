// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil
{

    public SecurityUtil()
    {
    }

    public static String getMD5ForString(String s)
    {
        s = (new BigInteger(1, MessageDigest.getInstance("MD5").digest(s.getBytes("UTF-8")))).toString(16);
        if (s.length() >= 4)
        {
            return s.substring(0, 4);
        }
        return "";
        s;
_L2:
        s.printStackTrace();
        return "";
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
