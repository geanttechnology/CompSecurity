// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.crypto;

import net.lingala.zip4j.crypto.engine.ZipCryptoEngine;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;

// Referenced classes of package net.lingala.zip4j.crypto:
//            IDecrypter

public class StandardDecrypter
    implements IDecrypter
{

    private byte crc[];
    private FileHeader fileHeader;
    private ZipCryptoEngine zipCryptoEngine;

    public StandardDecrypter(FileHeader fileheader, byte abyte0[])
        throws ZipException
    {
        crc = new byte[4];
        if (fileheader == null)
        {
            throw new ZipException("one of more of the input parameters were null in StandardDecryptor");
        } else
        {
            fileHeader = fileheader;
            zipCryptoEngine = new ZipCryptoEngine();
            init(abyte0);
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
        if (i < 0 || j < 0)
        {
            throw new ZipException("one of the input parameters were null in standard decrpyt data");
        }
        int k = i;
        do
        {
            if (k >= i + j)
            {
                return j;
            }
            int l = abyte0[k];
            try
            {
                l = (zipCryptoEngine.decryptByte() ^ l & 0xff) & 0xff;
                zipCryptoEngine.updateKeys((byte)l);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new ZipException(abyte0);
            }
            abyte0[k] = (byte)l;
            k++;
        } while (true);
    }

    public void init(byte abyte0[])
        throws ZipException
    {
        byte abyte1[] = fileHeader.getCrcBuff();
        crc[3] = (byte)(abyte1[3] & 0xff);
        crc[2] = (byte)(abyte1[3] >> 8 & 0xff);
        crc[1] = (byte)(abyte1[3] >> 16 & 0xff);
        crc[0] = (byte)(abyte1[3] >> 24 & 0xff);
        if (crc[2] > 0 || crc[1] > 0 || crc[0] > 0)
        {
            throw new IllegalStateException("Invalid CRC in File Header");
        }
        if (fileHeader.getPassword() == null || fileHeader.getPassword().length <= 0)
        {
            throw new ZipException("Wrong password!", 5);
        }
        zipCryptoEngine.initKeys(fileHeader.getPassword());
        byte byte0 = abyte0[0];
        int i = 0;
        while (i < 12) 
        {
            try
            {
                zipCryptoEngine.updateKeys((byte)(zipCryptoEngine.decryptByte() ^ byte0));
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new ZipException(abyte0);
            }
            if (i + 1 != 12)
            {
                byte0 = abyte0[i + 1];
            }
            i++;
        }
    }
}
