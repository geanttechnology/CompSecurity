// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.util.Base64;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            SSODeviceInfo

public class AESCipher
{

    private static final String TAG = com/amazon/identity/auth/device/framework/AESCipher.getName();
    private final SecretKeySpec mKeySpec;

    public AESCipher(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("encryption key was null");
        } else
        {
            mKeySpec = new SecretKeySpec(abyte0, "AES");
            return;
        }
    }

    private Cipher createAESCipher(int i, String s, AlgorithmParameterSpec algorithmparameterspec)
    {
        String s2 = null;
        String s3 = null;
        String s4 = null;
        String s1 = null;
        try
        {
            s = Cipher.getInstance(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "Aborting cipher creation", s);
            return s1;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "Aborting cipher creation", s);
            return s2;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "Aborting cipher creation because the key was invalid", s);
            return s3;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "Aborting cipher creation due to the occurrence of invalid algorithm parameters.", s);
            return s4;
        }
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        s.init(i, mKeySpec, algorithmparameterspec);
        return s;
    }

    public static String generateAesSecureStorageKey()
    {
        Object obj;
        try
        {
            obj = KeyGenerator.getInstance("AES");
            ((KeyGenerator) (obj)).init(128);
            obj = Base64.encodeToString(((KeyGenerator) (obj)).generateKey().getEncoded(), 0);
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            MAPLog.e(TAG, "Could not generate a symmetric key for algorithm AES");
            return null;
        }
        return ((String) (obj));
    }

    public static String generateAesSecureStorageKeyForDevice(SSODeviceInfo ssodeviceinfo)
    {
        String s;
        s = ssodeviceinfo.getDeviceSecret();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        ssodeviceinfo = ssodeviceinfo.getDeviceSerialNumber();
        if (ssodeviceinfo == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        ssodeviceinfo = Base64.encodeToString(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(s.toCharArray(), ssodeviceinfo.getBytes(), 1000, 128)).getEncoded(), 0);
        return ssodeviceinfo;
        ssodeviceinfo;
        MAPLog.e(TAG, "Could not generate a symmetric key with PBKDF2");
        return generateAesSecureStorageKey();
    }

    protected static byte[] performCipherOperation(Cipher cipher, byte abyte0[], int i, int j)
    {
        if (cipher == null)
        {
            return null;
        }
        try
        {
            cipher = cipher.doFinal(abyte0, i, j);
        }
        // Misplaced declaration of an exception variable
        catch (Cipher cipher)
        {
            MAPLog.e(TAG, "Encrypting / Decrypting failed with the given key. Aborting!", cipher);
            return null;
        }
        return cipher;
    }

    public byte[] concat(byte abyte0[], byte abyte1[])
    {
        byte abyte2[];
        try
        {
            abyte2 = new byte[abyte1.length + 16];
            System.arraycopy(abyte0, 0, abyte2, 0, 16);
            System.arraycopy(abyte1, 0, abyte2, 16, abyte1.length);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            MAPLog.e(TAG, "Exception happended during concatenating the initialization vectors and the cipher text", abyte0);
            return null;
        }
        return abyte2;
    }

    public byte[] decryptCBCMode(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("dataToDecrypt is null");
        } else
        {
            return performCipherOperation(createAESCipher(2, "AES/CBC/PKCS7Padding", new IvParameterSpec(abyte0, 0, 16)), abyte0, 16, abyte0.length - 16);
        }
    }

    public byte[] decryptECBMode(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("dataToDecrypt is null");
        } else
        {
            return performCipherOperation(createAESCipher(2, "AES", null), abyte0, 0, abyte0.length);
        }
    }

    public byte[] encryptCBCMode(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("dataToEncrypt is null");
        } else
        {
            SecureRandom securerandom = new SecureRandom();
            byte abyte1[] = new byte[16];
            securerandom.nextBytes(abyte1);
            return concat(abyte1, performCipherOperation(createAESCipher(1, "AES/CBC/PKCS7Padding", new IvParameterSpec(abyte1)), abyte0, 0, abyte0.length));
        }
    }

    public byte[] encryptECBMode(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("dataToEncrypt is null");
        } else
        {
            return performCipherOperation(createAESCipher(1, "AES", null), abyte0, 0, abyte0.length);
        }
    }

}
