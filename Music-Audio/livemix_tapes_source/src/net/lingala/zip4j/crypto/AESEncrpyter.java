// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.crypto;

import java.util.Random;
import net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF;
import net.lingala.zip4j.crypto.PBKDF2.PBKDF2Engine;
import net.lingala.zip4j.crypto.PBKDF2.PBKDF2Parameters;
import net.lingala.zip4j.crypto.engine.AESEngine;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.util.Raw;

// Referenced classes of package net.lingala.zip4j.crypto:
//            IEncrypter

public class AESEncrpyter
    implements IEncrypter
{

    private int KEY_LENGTH;
    private int MAC_LENGTH;
    private final int PASSWORD_VERIFIER_LENGTH = 2;
    private int SALT_LENGTH;
    private AESEngine aesEngine;
    private byte aesKey[];
    private byte counterBlock[];
    private byte derivedPasswordVerifier[];
    private boolean finished;
    private byte iv[];
    private int keyStrength;
    private int loopCount;
    private MacBasedPRF mac;
    private byte macKey[];
    private int nonce;
    private char password[];
    private byte saltBytes[];

    public AESEncrpyter(char ac[], int i)
        throws ZipException
    {
        nonce = 1;
        loopCount = 0;
        if (ac == null || ac.length == 0)
        {
            throw new ZipException("input password is empty or null in AES encrypter constructor");
        }
        if (i != 1 && i != 3)
        {
            throw new ZipException("Invalid key strength in AES encrypter constructor");
        } else
        {
            password = ac;
            keyStrength = i;
            finished = false;
            counterBlock = new byte[16];
            iv = new byte[16];
            init();
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

    private static byte[] generateSalt(int i)
        throws ZipException
    {
        if (i != 8 && i != 16)
        {
            throw new ZipException("invalid salt size, cannot generate salt");
        }
        byte byte0 = 0;
        if (i == 8)
        {
            byte0 = 2;
        }
        if (i == 16)
        {
            byte0 = 4;
        }
        byte abyte0[] = new byte[i];
        i = 0;
        do
        {
            if (i >= byte0)
            {
                return abyte0;
            }
            int j = (new Random()).nextInt();
            abyte0[i * 4 + 0] = (byte)(j >> 24);
            abyte0[i * 4 + 1] = (byte)(j >> 16);
            abyte0[i * 4 + 2] = (byte)(j >> 8);
            abyte0[i * 4 + 3] = (byte)j;
            i++;
        } while (true);
    }

    private void init()
        throws ZipException
    {
        switch (keyStrength)
        {
        case 2: // '\002'
        default:
            throw new ZipException("invalid aes key strength, cannot determine key sizes");

        case 3: // '\003'
            break MISSING_BLOCK_LABEL_114;

        case 1: // '\001'
            KEY_LENGTH = 16;
            MAC_LENGTH = 16;
            SALT_LENGTH = 8;
            break;
        }
_L1:
        saltBytes = generateSalt(SALT_LENGTH);
        byte abyte0[] = deriveKey(saltBytes, password);
        if (abyte0 == null || abyte0.length != KEY_LENGTH + MAC_LENGTH + 2)
        {
            throw new ZipException("invalid key generated, cannot decrypt file");
        } else
        {
            aesKey = new byte[KEY_LENGTH];
            macKey = new byte[MAC_LENGTH];
            derivedPasswordVerifier = new byte[2];
            System.arraycopy(abyte0, 0, aesKey, 0, KEY_LENGTH);
            System.arraycopy(abyte0, KEY_LENGTH, macKey, 0, MAC_LENGTH);
            System.arraycopy(abyte0, KEY_LENGTH + MAC_LENGTH, derivedPasswordVerifier, 0, 2);
            aesEngine = new AESEngine(aesKey);
            mac = new MacBasedPRF("HmacSHA1");
            mac.init(macKey);
            return;
        }
        KEY_LENGTH = 32;
        MAC_LENGTH = 32;
        SALT_LENGTH = 16;
          goto _L1
    }

    public int encryptData(byte abyte0[])
        throws ZipException
    {
        if (abyte0 == null)
        {
            throw new ZipException("input bytes are null, cannot perform AES encrpytion");
        } else
        {
            return encryptData(abyte0, 0, abyte0.length);
        }
    }

    public int encryptData(byte abyte0[], int i, int j)
        throws ZipException
    {
        int k;
        if (finished)
        {
            throw new ZipException("AES Encrypter is in finished state (A non 16 byte block has already been passed to encrypter)");
        }
        if (j % 16 != 0)
        {
            finished = true;
        }
        k = i;
_L1:
        int l;
        if (k >= i + j)
        {
            return j;
        }
        if (k + 16 <= i + j)
        {
            l = 16;
        } else
        {
            l = (i + j) - k;
        }
        loopCount = l;
        Raw.prepareBuffAESIVBytes(iv, nonce, 16);
        aesEngine.processBlock(iv, counterBlock);
        l = 0;
_L2:
label0:
        {
            if (l < loopCount)
            {
                break label0;
            }
            mac.update(abyte0, k, loopCount);
            nonce = nonce + 1;
            k += 16;
        }
          goto _L1
        abyte0[k + l] = (byte)(abyte0[k + l] ^ counterBlock[l]);
        l++;
          goto _L2
    }

    public byte[] getDerivedPasswordVerifier()
    {
        return derivedPasswordVerifier;
    }

    public byte[] getFinalMac()
    {
        byte abyte0[] = mac.doFinal();
        byte abyte1[] = new byte[10];
        System.arraycopy(abyte0, 0, abyte1, 0, 10);
        return abyte1;
    }

    public int getPasswordVeriifierLength()
    {
        return 2;
    }

    public byte[] getSaltBytes()
    {
        return saltBytes;
    }

    public int getSaltLength()
    {
        return SALT_LENGTH;
    }

    public void setDerivedPasswordVerifier(byte abyte0[])
    {
        derivedPasswordVerifier = abyte0;
    }

    public void setSaltBytes(byte abyte0[])
    {
        saltBytes = abyte0;
    }
}
