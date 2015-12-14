// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class ab
{

    private KeySpec a;
    private String b;
    private SecretKey c;
    private SecretKeyFactory d;
    private String e;

    public ab()
    {
        b = "DESede/CBC/PKCS7Padding";
        e = "utf-8";
        try
        {
            c = KeyGenerator.getInstance("DESede").generateKey();
            return;
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            nosuchalgorithmexception.printStackTrace();
        }
    }

    public ab(String s)
    {
        b = "DESede/CBC/PKCS7Padding";
        e = "utf-8";
        try
        {
            d(s.getBytes(e));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public ab(byte abyte0[])
    {
        b = "DESede/CBC/PKCS7Padding";
        e = "utf-8";
        d(abyte0);
    }

    private void d(byte abyte0[])
    {
        try
        {
            d = SecretKeyFactory.getInstance("DESede");
            a = new DESedeKeySpec(e(abyte0));
            c = d.generateSecret(a);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
        }
    }

    private byte[] e(byte abyte0[])
    {
        int j = abyte0.length;
        byte abyte1[] = abyte0;
        if (abyte0.length < 24)
        {
            abyte1 = new byte[24];
            byte abyte2[] = new byte[24 - j];
            for (int i = 0; i < 24 - j; i++)
            {
                abyte2[i] = 0;
            }

            System.arraycopy(abyte0, 0, abyte1, 0, j);
            System.arraycopy(abyte2, 0, abyte1, j, 24 - j);
        }
        return abyte1;
    }

    private static IvParameterSpec f(byte abyte0[])
    {
        byte abyte1[] = new byte[8];
        System.arraycopy(abyte0, 0, abyte1, 0, 8);
        return new IvParameterSpec(abyte1);
    }

    public byte[] a()
    {
        return c.getEncoded();
    }

    public byte[] a(String s)
    {
        return a(s.getBytes(e));
    }

    public byte[] a(byte abyte0[])
    {
        IvParameterSpec ivparameterspec = f(c.getEncoded());
        Cipher cipher = Cipher.getInstance(b);
        cipher.init(1, c, ivparameterspec);
        return cipher.doFinal(abyte0);
    }

    public String b()
    {
        return e;
    }

    public void b(String s)
    {
        e = s;
    }

    public byte[] b(byte abyte0[])
    {
        IvParameterSpec ivparameterspec = f(c.getEncoded());
        Cipher cipher = Cipher.getInstance(b);
        cipher.init(2, c, ivparameterspec);
        return cipher.doFinal(abyte0);
    }

    public String c(byte abyte0[])
    {
        return new String(b(abyte0), e);
    }
}
