// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.validate;

import com.amazon.insights.impl.InitializationException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionValidator
{

    private final String encryptionAlgorithm;
    private final String secretKey;

    public EncryptionValidator(String s, String s1)
    {
        secretKey = s;
        encryptionAlgorithm = s1;
    }

    public void validate()
    {
        try
        {
            SecretKeySpec secretkeyspec = new SecretKeySpec(secretKey.getBytes("UTF-8"), encryptionAlgorithm);
            Cipher cipher = Cipher.getInstance(secretkeyspec.getAlgorithm());
            cipher.init(1, secretkeyspec);
            byte abyte0[] = cipher.doFinal("!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~".getBytes("UTF-8"));
            Cipher cipher1 = Cipher.getInstance(secretkeyspec.getAlgorithm());
            cipher1.init(2, secretkeyspec);
            if (!(new String(cipher1.doFinal(abyte0), "UTF-8")).equals("!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~"))
            {
                throw new InitializationException("Could not encrypt and decrypt string with AES");
            }
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new InitializationException("UTF-8 encoding is not supported", unsupportedencodingexception);
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new InitializationException("No Provider for AES", nosuchalgorithmexception);
        }
        catch (NoSuchPaddingException nosuchpaddingexception)
        {
            throw new InitializationException("No Such Padding AES", nosuchpaddingexception);
        }
        catch (InvalidKeyException invalidkeyexception)
        {
            throw new InitializationException("Invalid Key for AES", invalidkeyexception);
        }
        catch (IllegalBlockSizeException illegalblocksizeexception)
        {
            throw new InitializationException("Illegal Block size for AES", illegalblocksizeexception);
        }
        catch (BadPaddingException badpaddingexception)
        {
            throw new InitializationException("Bad Padding for AES", badpaddingexception);
        }
    }
}
