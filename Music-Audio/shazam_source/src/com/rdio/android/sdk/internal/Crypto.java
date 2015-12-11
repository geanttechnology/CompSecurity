// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import java.security.MessageDigest;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Crypto
{

    protected static final byte AES_IV[] = {
        42, 13, 57, 67, 41, 13, 12, -86, 23, -74, 
        -89, 71, 12, 43, -45, 12
    };
    private static String ALGORITHM = "AES/CBC";
    private static String ALGORITHM_NOPADDING = "/NoPadding";
    private static String ALGORITHM_PADDING = "/PKCS5Padding";

    public Crypto()
    {
    }

    protected static String getAESAlgorithm(boolean flag)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append(ALGORITHM);
        String s;
        if (flag)
        {
            s = ALGORITHM_PADDING;
        } else
        {
            s = ALGORITHM_NOPADDING;
        }
        return stringbuilder.append(s).toString();
    }

    public static Cipher getCipher(SecretKey secretkey, IvParameterSpec ivparameterspec, int i, boolean flag)
    {
        Cipher cipher = Cipher.getInstance(getAESAlgorithm(flag));
        cipher.init(i, secretkey, ivparameterspec);
        return cipher;
    }

    public static SecretKey makeKey(byte abyte0[])
    {
        if (abyte0 == null)
        {
            abyte0 = SecureRandom.getInstance("SHA1PRNG");
            abyte0.nextBytes(new byte[5]);
            KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
            keygenerator.init(256, abyte0);
            return keygenerator.generateKey();
        } else
        {
            return new SecretKeySpec(abyte0, "AES");
        }
    }

    public static String md5(byte abyte0[])
    {
        StringBuffer stringbuffer = new StringBuffer(32);
        abyte0 = md5Bytes(abyte0);
        for (int i = 0; i < abyte0.length; i++)
        {
            String s = Integer.toHexString(abyte0[i] & 0xff);
            if (s.length() == 1)
            {
                stringbuffer.append("0");
            }
            stringbuffer.append(s);
        }

        return stringbuffer.toString();
    }

    public static byte[] md5Bytes(byte abyte0[])
    {
        new StringBuffer(32);
        MessageDigest messagedigest = MessageDigest.getInstance("MD5");
        messagedigest.update(abyte0);
        return messagedigest.digest();
    }

    public static byte[] runCipher(SecretKey secretkey, IvParameterSpec ivparameterspec, int i, byte abyte0[], boolean flag)
    {
        return getCipher(secretkey, ivparameterspec, i, flag).doFinal(abyte0);
    }

}
