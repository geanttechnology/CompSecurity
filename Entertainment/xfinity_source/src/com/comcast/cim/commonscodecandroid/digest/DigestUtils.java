// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.commonscodecandroid.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtils
{

    public DigestUtils()
    {
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

    private static MessageDigest getSha256Digest()
    {
        return getDigest("SHA-256");
    }

    private static MessageDigest getSha384Digest()
    {
        return getDigest("SHA-384");
    }

    private static MessageDigest getSha512Digest()
    {
        return getDigest("SHA-512");
    }

    private static MessageDigest getShaDigest()
    {
        return getDigest("SHA");
    }
}
