// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class gz
{

    private final Cipher a;
    private final Cipher b;
    private final SharedPreferences c;

    public gz(Context context)
    {
        try
        {
            a = Cipher.getInstance("AES/CBC/PKCS5Padding");
            b = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte abyte0[] = new byte[a.getBlockSize()];
            System.arraycopy("superRandomInitializationVectorByKEV_jDJ4s391!id".getBytes(), 0, abyte0, 0, a.getBlockSize());
            IvParameterSpec ivparameterspec = new IvParameterSpec(abyte0);
            SecretKeySpec secretkeyspec = new SecretKeySpec(a("EflFpk4jnTwgKXNZvWsk1RbDeOaqz8yZTCk6zdrLtM9fm2a0d5p537JTos6UAqPBSkFNadmxshxxbgEsmujdMTeisJUvxyiA5B4XxeLLgQRCYTUNpHUW39rG"), "AES/CBC/PKCS5Padding");
            a.init(1, secretkeyspec, ivparameterspec);
            b.init(2, secretkeyspec, ivparameterspec);
            c = context.getSharedPreferences("BBY_API_PREF", 0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new ha(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new ha(context);
        }
    }

    private static byte[] a(Cipher cipher, byte abyte0[])
    {
        try
        {
            cipher = cipher.doFinal(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (Cipher cipher)
        {
            throw new ha(cipher);
        }
        return cipher;
    }

    private void b(String s, String s1)
    {
        s1 = a(s1, a);
        c.edit().putString(s, s1).commit();
    }

    private String d(String s)
    {
        return s;
    }

    protected String a(String s, Cipher cipher)
    {
        try
        {
            s = a(cipher, s.getBytes("UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ha(s);
        }
        return Base64.encodeToString(s, 2);
    }

    public void a(String s, String s1)
    {
        if (s1 == null)
        {
            c.edit().remove(d(s)).commit();
            return;
        } else
        {
            b(d(s), s1);
            return;
        }
    }

    protected byte[] a(String s)
    {
        MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
        messagedigest.reset();
        return messagedigest.digest(s.getBytes("UTF-8"));
    }

    public String b(String s)
    {
        if (c.contains(d(s)))
        {
            return c(c.getString(d(s), ""));
        } else
        {
            return null;
        }
    }

    protected String c(String s)
    {
        s = Base64.decode(s, 2);
        s = a(b, s);
        try
        {
            s = new String(s, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ha(s);
        }
        return s;
    }
}
