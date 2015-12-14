// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.crypto;

import java.util.Arrays;
import net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF;
import net.lingala.zip4j.crypto.PBKDF2.PBKDF2Engine;
import net.lingala.zip4j.crypto.PBKDF2.PBKDF2Parameters;
import net.lingala.zip4j.crypto.engine.AESEngine;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.util.Raw;

// Referenced classes of package net.lingala.zip4j.crypto:
//            IDecrypter

public class AESDecrypter
    implements IDecrypter
{

    private int KEY_LENGTH;
    private int MAC_LENGTH;
    private final int PASSWORD_VERIFIER_LENGTH = 2;
    private int SALT_LENGTH;
    private AESEngine aesEngine;
    private byte aesKey[];
    private byte counterBlock[];
    private byte derivedPasswordVerifier[];
    private byte iv[];
    private LocalFileHeader localFileHeader;
    private int loopCount;
    private MacBasedPRF mac;
    private byte macKey[];
    private int nonce;
    private byte storedMac[];

    public AESDecrypter(LocalFileHeader localfileheader, byte abyte0[], byte abyte1[])
        throws ZipException
    {
        nonce = 1;
        loopCount = 0;
        if (localfileheader == null)
        {
            throw new ZipException("one of the input parameters is null in AESDecryptor Constructor");
        } else
        {
            localFileHeader = localfileheader;
            storedMac = null;
            iv = new byte[16];
            counterBlock = new byte[16];
            init(abyte0, abyte1);
            return;
        }
    }

    private byte[] deriveKey(byte abyte0[], char ac[])
        throws ZipException
    {
        try
        {
            abyte0 = (new PBKDF2Engine(new PBKDF2Parameters("HmacSHA1", "ISO-8859-1", abyte0, 1000))).deriveKey(ac, KEY_LENGTH + MAC_LENGTH + 2);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new ZipException(abyte0);
        }
        return abyte0;
    }

    private void init(byte abyte0[], byte abyte1[])
        throws ZipException
    {
        AESExtraDataRecord aesextradatarecord;
        if (localFileHeader == null)
        {
            throw new ZipException("invalid file header in init method of AESDecryptor");
        }
        aesextradatarecord = localFileHeader.getAesExtraDataRecord();
        if (aesextradatarecord == null)
        {
            throw new ZipException("invalid aes extra data record - in init method of AESDecryptor");
        }
        aesextradatarecord.getAesStrength();
        JVM INSTR tableswitch 1 3: default 68
    //                   1 98
    //                   2 147
    //                   3 168;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new ZipException("invalid aes key strength for file: " + localFileHeader.getFileName());
_L2:
        KEY_LENGTH = 16;
        MAC_LENGTH = 16;
        SALT_LENGTH = 8;
_L6:
        if (localFileHeader.getPassword() == null || localFileHeader.getPassword().length <= 0)
        {
            throw new ZipException("empty or null password provided for AES Decryptor");
        }
        break; /* Loop/switch isn't completed */
_L3:
        KEY_LENGTH = 24;
        MAC_LENGTH = 24;
        SALT_LENGTH = 12;
        continue; /* Loop/switch isn't completed */
_L4:
        KEY_LENGTH = 32;
        MAC_LENGTH = 32;
        SALT_LENGTH = 16;
        if (true) goto _L6; else goto _L5
_L5:
        abyte0 = deriveKey(abyte0, localFileHeader.getPassword());
        if (abyte0 == null || abyte0.length != KEY_LENGTH + MAC_LENGTH + 2)
        {
            throw new ZipException("invalid derived key");
        }
        aesKey = new byte[KEY_LENGTH];
        macKey = new byte[MAC_LENGTH];
        derivedPasswordVerifier = new byte[2];
        System.arraycopy(abyte0, 0, aesKey, 0, KEY_LENGTH);
        System.arraycopy(abyte0, KEY_LENGTH, macKey, 0, MAC_LENGTH);
        System.arraycopy(abyte0, KEY_LENGTH + MAC_LENGTH, derivedPasswordVerifier, 0, 2);
        if (derivedPasswordVerifier == null)
        {
            throw new ZipException("invalid derived password verifier for AES");
        }
        if (!Arrays.equals(abyte1, derivedPasswordVerifier))
        {
            throw new ZipException("Wrong Password for file: " + localFileHeader.getFileName(), 5);
        } else
        {
            aesEngine = new AESEngine(aesKey);
            mac = new MacBasedPRF("HmacSHA1");
            mac.init(macKey);
            return;
        }
    }

    public int decryptData(byte abyte0[])
        throws ZipException
    {
        return decryptData(abyte0, 0, abyte0.length);
    }

    public int decryptData(byte abyte0[], int i, int j)
        throws ZipException
    {
        int k;
        if (aesEngine == null)
        {
            throw new ZipException("AES not initialized properly");
        }
        k = i;
_L1:
        if (k >= i + j)
        {
            return j;
        }
        int l;
        if (k + 16 <= i + j)
        {
            l = 16;
        } else
        {
            l = (i + j) - k;
        }
        try
        {
            loopCount = l;
            mac.update(abyte0, k, loopCount);
            Raw.prepareBuffAESIVBytes(iv, nonce, 16);
            aesEngine.processBlock(iv, counterBlock);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw abyte0;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new ZipException(abyte0);
        }
        l = 0;
_L2:
        if (l < loopCount)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        nonce = nonce + 1;
        k += 16;
          goto _L1
        abyte0[k + l] = (byte)(abyte0[k + l] ^ counterBlock[l]);
        l++;
          goto _L2
    }

    public byte[] getCalculatedAuthenticationBytes()
    {
        return mac.doFinal();
    }

    public int getPasswordVerifierLength()
    {
        return 2;
    }

    public int getSaltLength()
    {
        return SALT_LENGTH;
    }

    public byte[] getStoredMac()
    {
        return storedMac;
    }

    public void setStoredMac(byte abyte0[])
    {
        storedMac = abyte0;
    }
}
