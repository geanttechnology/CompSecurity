// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.util.Base64;
import com.amazon.identity.auth.device.framework.AESCipher;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.io.UnsupportedEncodingException;

public abstract class AbstractTokenEncryptor
{

    private static final String TAG = com/amazon/identity/auth/device/storage/AbstractTokenEncryptor.getName();

    public AbstractTokenEncryptor()
    {
    }

    private String fromUTF8(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        }
        try
        {
            abyte0 = new String(abyte0, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            MAPLog.e(TAG, "Cannot encode the given bytes as aUTF-8 string on this platform.");
            return null;
        }
        return abyte0;
    }

    private AESCipher getCipher()
    {
        byte abyte0[] = getEncryptionKey();
        if (abyte0 == null)
        {
            MAPLog.e(TAG, "Aborting encrypt/decrypt because a valid cipher could not be created.");
            return null;
        } else
        {
            return new AESCipher(abyte0);
        }
    }

    private byte[] toUtf8(String s)
    {
        if (s == null)
        {
            return null;
        }
        try
        {
            s = s.getBytes("UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "Cannot encode a string as UTF-8 on this platform.");
            return null;
        }
        return s;
    }

    public String decryptToken(String s)
    {
        AESCipher aescipher = getCipher();
        if (aescipher == null || s == null)
        {
            return null;
        } else
        {
            return fromUTF8(aescipher.decryptECBMode(Base64.decode(s, 0)));
        }
    }

    public String encryptToken(String s)
    {
        s = toUtf8(s);
        AESCipher aescipher = getCipher();
        if (s == null || aescipher == null)
        {
            return null;
        } else
        {
            return Base64.encodeToString(aescipher.encryptECBMode(s), 0);
        }
    }

    protected abstract byte[] getEncryptionKey();

}
