// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreegateway.encryption;

import com.braintree.org.bouncycastle.asn1.ASN1InputStream;
import com.braintree.org.bouncycastle.asn1.x509.RSAPublicKeyStructure;
import com.braintree.org.bouncycastle.util.encoders.Base64;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

// Referenced classes of package com.braintreegateway.encryption:
//            BraintreeEncryptionException

public final class Rsa
{

    private static final String ALGORITHM = "RSA";
    private static final String TRANSFORMATION = "RSA/ECB/PKCS1Padding";

    public Rsa()
    {
    }

    public static String encrypt(byte abyte0[], String s)
        throws BraintreeEncryptionException
    {
        try
        {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKey(s));
            abyte0 = new String(Base64.encode(cipher.doFinal(Base64.encode(abyte0))));
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new BraintreeEncryptionException((new StringBuilder()).append("No Such Algorithm: ").append(abyte0.getMessage()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new BraintreeEncryptionException((new StringBuilder()).append("No Such Padding: ").append(abyte0.getMessage()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new BraintreeEncryptionException((new StringBuilder()).append("Invalid Key: ").append(abyte0.getMessage()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new BraintreeEncryptionException((new StringBuilder()).append("Illegal Block Size: ").append(abyte0.getMessage()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new BraintreeEncryptionException((new StringBuilder()).append("Bad Padding: ").append(abyte0.getMessage()).toString());
        }
        return abyte0;
    }

    private static PublicKey publicKey(String s)
        throws BraintreeEncryptionException
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        obj = null;
        obj3 = null;
        obj1 = null;
        obj2 = null;
        s = new ASN1InputStream(Base64.decode(s));
        obj = RSAPublicKeyStructure.getInstance(s.readObject());
        obj = new RSAPublicKeySpec(((RSAPublicKeyStructure) (obj)).getModulus(), ((RSAPublicKeyStructure) (obj)).getPublicExponent());
        obj = KeyFactory.getInstance("RSA").generatePublic(((java.security.spec.KeySpec) (obj)));
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new BraintreeEncryptionException((new StringBuilder()).append("IO Exception: ").append(s.getMessage()).toString());
        }
        return ((PublicKey) (obj));
        s;
        obj = obj2;
_L4:
        throw new BraintreeEncryptionException((new StringBuilder()).append("No Such Algorithm: ").append(s.getMessage()).toString());
        s;
_L1:
        try
        {
            ((ASN1InputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new BraintreeEncryptionException((new StringBuilder()).append("IO Exception: ").append(s.getMessage()).toString());
        }
        throw s;
        s;
        obj = obj3;
_L3:
        throw new BraintreeEncryptionException((new StringBuilder()).append("Invalid Key Spec: ").append(s.getMessage()).toString());
_L2:
        throw new BraintreeEncryptionException((new StringBuilder()).append("IO Exception: ").append(s.getMessage()).toString());
        obj1;
        obj = s;
        s = ((String) (obj1));
          goto _L1
        obj1;
        obj = s;
        s = ((String) (obj1));
          goto _L2
        obj1;
        obj = s;
        s = ((String) (obj1));
          goto _L3
        obj1;
        obj = s;
        s = ((String) (obj1));
          goto _L4
        s;
        obj = obj1;
          goto _L2
    }
}
