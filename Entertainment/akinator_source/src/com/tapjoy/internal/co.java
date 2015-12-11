// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class co
{

    public static byte[] a(byte abyte0[])
    {
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance("SHA-1");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new RuntimeException(abyte0);
        }
        return messagedigest.digest(abyte0);
    }
}
