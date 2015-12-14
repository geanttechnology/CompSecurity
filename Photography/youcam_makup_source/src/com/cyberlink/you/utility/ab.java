// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import com.nostra13.universalimageloader.a.a.b.a;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ab
    implements a
{

    public ab()
    {
    }

    private byte[] a(byte abyte0[])
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
            abyte0.printStackTrace();
            return null;
        }
        return abyte0;
    }

    public String a(String s)
    {
        s = (new BigInteger(a(s.getBytes()))).abs();
        return (new StringBuilder()).append(s.toString(36)).append(".png").toString();
    }
}
