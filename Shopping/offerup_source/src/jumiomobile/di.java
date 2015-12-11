// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.util.Base64;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

// Referenced classes of package jumiomobile:
//            dj

public class di
{

    private PublicKey a;
    private Cipher b;
    private Cipher c;
    private SecureRandom d;

    public di(String s)
    {
        d = new SecureRandom();
        String as[] = s.split("\\|");
        KeyFactory keyfactory;
        RSAPublicKeySpec rsapublickeyspec;
        try
        {
            keyfactory = KeyFactory.getInstance("RSA");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        rsapublickeyspec = new RSAPublicKeySpec(new BigInteger(as[1].toLowerCase(), 16), new BigInteger(as[0].toLowerCase(), 16));
        try
        {
            a = keyfactory.generatePublic(rsapublickeyspec);
        }
        catch (InvalidKeySpecException invalidkeyspecexception)
        {
            throw new dj((new StringBuilder("Problem reading public key: ")).append(s).toString(), invalidkeyspecexception);
        }
        try
        {
            b = Cipher.getInstance("AES/CCM/NoPadding");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new dj("Problem instantiation AES Cipher Algorithm", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new dj("Problem instantiation AES Cipher Padding", s);
        }
        try
        {
            c = Cipher.getInstance("RSA/None/PKCS1Padding");
            c.init(1, a);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new dj("Problem instantiation RSA Cipher Algorithm", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new dj("Problem instantiation RSA Cipher Padding", s);
        }
        catch (InvalidKeyException invalidkeyexception)
        {
            throw new dj((new StringBuilder("Invalid public key: ")).append(s).toString(), invalidkeyexception);
        }
    }

    private SecretKey a(int i)
    {
        KeyGenerator keygenerator;
        try
        {
            keygenerator = KeyGenerator.getInstance("AES");
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new dj("Unable to get AES algorithm", nosuchalgorithmexception);
        }
        keygenerator.init(i);
        return keygenerator.generateKey();
    }

    private byte[] b(int i)
    {
        this;
        JVM INSTR monitorenter ;
        byte abyte0[];
        abyte0 = new byte[i];
        d.nextBytes(abyte0);
        this;
        JVM INSTR monitorexit ;
        return abyte0;
        Exception exception;
        exception;
        throw exception;
    }

    public String a(String s)
    {
        SecretKey secretkey = a(256);
        byte abyte1[] = b(12);
        byte abyte2[];
        try
        {
            b.init(1, secretkey, new IvParameterSpec(abyte1));
            abyte2 = b.doFinal(s.getBytes());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new dj("Incorrect AES Block Size", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new dj("Incorrect AES Padding", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new dj("Invalid AES Key", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new dj("Invalid AES Parameters", s);
        }
        s = new byte[abyte1.length + abyte2.length];
        System.arraycopy(abyte1, 0, s, 0, abyte1.length);
        System.arraycopy(abyte2, 0, s, abyte1.length, abyte2.length);
        try
        {
            byte abyte0[] = c.doFinal(secretkey.getEncoded());
            s = (new StringBuilder("adyenan0_1_1$")).append(Base64.encodeToString(abyte0, 2)).append("$").append(Base64.encodeToString(s, 2)).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new dj("Incorrect RSA Block Size", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new dj("Incorrect RSA Padding", s);
        }
        return s;
    }
}
