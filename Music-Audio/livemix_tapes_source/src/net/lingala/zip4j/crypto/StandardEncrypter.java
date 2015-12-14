// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.crypto;

import java.util.Random;
import net.lingala.zip4j.crypto.engine.ZipCryptoEngine;
import net.lingala.zip4j.exception.ZipException;

// Referenced classes of package net.lingala.zip4j.crypto:
//            IEncrypter

public class StandardEncrypter
    implements IEncrypter
{

    private byte headerBytes[];
    private ZipCryptoEngine zipCryptoEngine;

    public StandardEncrypter(char ac[], int i)
        throws ZipException
    {
        if (ac == null || ac.length <= 0)
        {
            throw new ZipException("input password is null or empty in standard encrpyter constructor");
        } else
        {
            zipCryptoEngine = new ZipCryptoEngine();
            headerBytes = new byte[12];
            init(ac, i);
            return;
        }
    }

    private void init(char ac[], int i)
        throws ZipException
    {
        if (ac == null || ac.length <= 0)
        {
            throw new ZipException("input password is null or empty, cannot initialize standard encrypter");
        }
        zipCryptoEngine.initKeys(ac);
        headerBytes = generateRandomBytes(12);
        zipCryptoEngine.initKeys(ac);
        headerBytes[11] = (byte)(i >>> 24);
        headerBytes[10] = (byte)(i >>> 16);
        if (headerBytes.length < 12)
        {
            throw new ZipException("invalid header bytes generated, cannot perform standard encryption");
        } else
        {
            encryptData(headerBytes);
            return;
        }
    }

    protected byte encryptByte(byte byte0)
    {
        byte byte1 = (byte)(zipCryptoEngine.decryptByte() & 0xff ^ byte0);
        zipCryptoEngine.updateKeys(byte0);
        return byte1;
    }

    public int encryptData(byte abyte0[])
        throws ZipException
    {
        if (abyte0 == null)
        {
            throw new NullPointerException();
        } else
        {
            return encryptData(abyte0, 0, abyte0.length);
        }
    }

    public int encryptData(byte abyte0[], int i, int j)
        throws ZipException
    {
        if (j < 0)
        {
            throw new ZipException("invalid length specified to decrpyt data");
        }
        int k = i;
        do
        {
            if (k >= i + j)
            {
                return j;
            }
            try
            {
                abyte0[k] = encryptByte(abyte0[k]);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new ZipException(abyte0);
            }
            k++;
        } while (true);
    }

    protected byte[] generateRandomBytes(int i)
        throws ZipException
    {
        if (i <= 0)
        {
            throw new ZipException("size is either 0 or less than 0, cannot generate header for standard encryptor");
        }
        byte abyte0[] = new byte[i];
        Random random = new Random();
        i = 0;
        do
        {
            if (i >= abyte0.length)
            {
                return abyte0;
            }
            abyte0[i] = encryptByte((byte)random.nextInt(256));
            i++;
        } while (true);
    }

    public byte[] getHeaderBytes()
    {
        return headerBytes;
    }
}
