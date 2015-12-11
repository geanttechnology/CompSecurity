// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.sso;

import android.os.Build;
import android.text.TextUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SymmetricEncryption
{

    private static final String BROKEN_ANDROID_ID = "9774d56d682e549c";
    private static final int KEY_SIZE = 16;
    private static final char hexArray[] = "0123456789ABCDEF".toCharArray();

    public SymmetricEncryption()
    {
    }

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

    public static String decrypt(String s)
    {
        try
        {
            s = hexToByte(s);
            s = new String(decrypt(getRawKey(), ((byte []) (s))), "UTF8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    private static byte[] decrypt(byte abyte0[], byte abyte1[])
        throws Exception
    {
        abyte0 = new SecretKeySpec(abyte0, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        cipher.init(2, abyte0);
        return cipher.doFinal(abyte1);
    }

    public static String encrypt(String s)
    {
        try
        {
            s = bytesToHex(encrypt(getRawKey(), s.getBytes("UTF8")));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    private static byte[] encrypt(byte abyte0[], byte abyte1[])
        throws Exception
    {
        abyte0 = new SecretKeySpec(abyte0, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        cipher.init(1, abyte0);
        return cipher.doFinal(abyte1);
    }

    private static byte[] getRawKey()
        throws Exception
    {
        byte abyte0[] = new byte[16];
        Object obj;
        if (!TextUtils.isEmpty(Build.SERIAL))
        {
            obj = Build.SERIAL;
        } else
        {
            obj = "9774d56d682e549c";
        }
        obj = (new StringBuilder()).append(((String) (obj))).append(Double.toString(Math.pow(3D, 41D))).toString().getBytes("UTF8");
        for (int i = 0; i < 16 && i < obj.length; i++)
        {
            abyte0[i] = obj[i];
        }

        return abyte0;
    }

    public static byte[] hexToByte(String s)
    {
        s = s.toUpperCase();
        int j = s.length();
        byte abyte0[] = new byte[j / 2];
        for (int i = 0; i < j; i += 2)
        {
            abyte0[i / 2] = (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }

        return abyte0;
    }

}
