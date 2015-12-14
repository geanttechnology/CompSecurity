// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.pm.Signature;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;

public final class SignatureHelpers
{

    public static String getSignatureFingerprint(String s, Signature signature)
        throws GeneralSecurityException
    {
        if (signature != null)
        {
            signature = signature.toByteArray();
            s = MessageDigest.getInstance(s).digest(signature);
            if (s != null)
            {
                signature = new StringBuffer();
                for (int i = 0; i < s.length; i++)
                {
                    String s1 = Integer.toHexString(s[i] & 0xff);
                    if (s1.length() == 1)
                    {
                        signature.append("0");
                    }
                    signature.append(s1);
                }

                return signature.toString();
            }
        }
        return null;
    }
}
