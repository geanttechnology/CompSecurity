// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreegateway.encryption;

import com.braintree.org.bouncycastle.util.encoders.Base64;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.util.ByteArrayBuffer;

// Referenced classes of package com.braintreegateway.encryption:
//            BraintreeEncryptionException

public final class Aes
{

    private static final String ALGORITHM = "AES";
    public static final int IV_LENGTH = 16;
    public static final int KEY_LENGTH = 32;
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    public Aes()
    {
    }

    private static Cipher aesCipher()
        throws BraintreeEncryptionException
    {
        Cipher cipher;
        try
        {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new BraintreeEncryptionException((new StringBuilder()).append("No Such Algorithm: ").append(nosuchalgorithmexception.getMessage()).toString());
        }
        catch (NoSuchPaddingException nosuchpaddingexception)
        {
            throw new BraintreeEncryptionException((new StringBuilder()).append("No Such Padding: ").append(nosuchpaddingexception.getMessage()).toString());
        }
        return cipher;
    }

    public static String encrypt(String s, byte abyte0[], byte abyte1[])
        throws BraintreeEncryptionException
    {
        abyte0 = new SecretKeySpec(abyte0, "AES");
        Cipher cipher = aesCipher();
        try
        {
            cipher.init(1, abyte0, new IvParameterSpec(abyte1));
            s = cipher.doFinal(s.getBytes());
            abyte0 = new ByteArrayBuffer(s.length + abyte1.length);
            abyte0.append(abyte1, 0, abyte1.length);
            abyte0.append(s, 0, s.length);
            s = new String(Base64.encode(abyte0.toByteArray()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new BraintreeEncryptionException((new StringBuilder()).append("Invalid Key: ").append(s.getMessage()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new BraintreeEncryptionException((new StringBuilder()).append("Bad Padding: ").append(s.getMessage()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new BraintreeEncryptionException((new StringBuilder()).append("Illegal Block Size: ").append(s.getMessage()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new BraintreeEncryptionException((new StringBuilder()).append("Invalid Algorithm: ").append(s.getMessage()).toString());
        }
        return s;
    }
}
