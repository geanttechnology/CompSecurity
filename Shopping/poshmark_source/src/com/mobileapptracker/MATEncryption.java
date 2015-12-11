// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MATEncryption
{

    private IvParameterSpec a;
    private SecretKeySpec b;
    private Cipher c;

    public MATEncryption(String s, String s1)
    {
        a = new IvParameterSpec(s1.getBytes());
        b = new SecretKeySpec(s.getBytes(), "AES");
        try
        {
            c = Cipher.getInstance("AES/CBC/NoPadding");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    private static String a(String s)
    {
        int j = s.length();
        for (int i = 0; i < 16 - j % 16; i++)
        {
            s = (new StringBuilder()).append(s).append(' ').toString();
        }

        return s;
    }

    public static String bytesToHex(byte abyte0[])
    {
        if (abyte0 != null) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L4:
        return s1;
_L2:
        int j = abyte0.length;
        String s = "";
        int i = 0;
        do
        {
            s1 = s;
            if (i >= j)
            {
                continue;
            }
            if ((abyte0[i] & 0xff) < 16)
            {
                s = (new StringBuilder()).append(s).append("0").append(Integer.toHexString(abyte0[i] & 0xff)).toString();
            } else
            {
                s = (new StringBuilder()).append(s).append(Integer.toHexString(abyte0[i] & 0xff)).toString();
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static byte[] hexToBytes(String s)
    {
        byte abyte0[];
        abyte0 = null;
        break MISSING_BLOCK_LABEL_2;
_L2:
        do
        {
            return abyte0;
        } while (s == null || s.length() < 2);
        int j = s.length() / 2;
        byte abyte1[] = new byte[j];
        int i = 0;
        do
        {
            abyte0 = abyte1;
            if (i >= j)
            {
                continue;
            }
            abyte1[i] = (byte)Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16);
            i++;
        } while (true);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String md5(String s)
    {
        if (s == null)
        {
            return "";
        }
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(s.getBytes());
            s = bytesToHex(messagedigest.digest());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "";
        }
        return s;
    }

    public static String sha1(String s)
    {
        if (s == null)
        {
            return "";
        }
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
            messagedigest.update(s.getBytes());
            s = bytesToHex(messagedigest.digest());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "";
        }
        return s;
    }

    public static String sha256(String s)
    {
        if (s == null)
        {
            return "";
        }
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
            messagedigest.update(s.getBytes());
            s = bytesToHex(messagedigest.digest());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "";
        }
        return s;
    }

    public byte[] decrypt(String s)
    {
        if (s == null || s.length() == 0)
        {
            throw new Exception("Empty string");
        }
        try
        {
            c.init(2, b, a);
            s = c.doFinal(hexToBytes(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new Exception((new StringBuilder("[decrypt] ")).append(s.getMessage()).toString());
        }
        return s;
    }

    public byte[] encrypt(String s)
    {
        if (s == null || s.length() == 0)
        {
            throw new Exception("Empty string");
        }
        try
        {
            c.init(1, b, a);
            s = c.doFinal(a(s).getBytes());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new Exception((new StringBuilder("[encrypt] ")).append(s.getMessage()).toString());
        }
        return s;
    }
}
