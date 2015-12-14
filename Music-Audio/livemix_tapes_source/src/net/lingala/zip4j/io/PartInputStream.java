// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import net.lingala.zip4j.crypto.AESDecrypter;
import net.lingala.zip4j.crypto.IDecrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.unzip.UnzipEngine;

// Referenced classes of package net.lingala.zip4j.io:
//            BaseInputStream

public class PartInputStream extends BaseInputStream
{

    private byte aesBlockByte[];
    private int aesBytesReturned;
    private long bytesRead;
    private int count;
    private IDecrypter decrypter;
    private boolean isAESEncryptedFile;
    private long length;
    private byte oneByteBuff[];
    private RandomAccessFile raf;
    private UnzipEngine unzipEngine;

    public PartInputStream(RandomAccessFile randomaccessfile, long l, long l1, UnzipEngine unzipengine)
    {
        boolean flag = true;
        super();
        oneByteBuff = new byte[1];
        aesBlockByte = new byte[16];
        aesBytesReturned = 0;
        isAESEncryptedFile = false;
        count = -1;
        raf = randomaccessfile;
        unzipEngine = unzipengine;
        decrypter = unzipengine.getDecrypter();
        bytesRead = 0L;
        length = l1;
        if (!unzipengine.getFileHeader().isEncrypted() || unzipengine.getFileHeader().getEncryptionMethod() != 99)
        {
            flag = false;
        }
        isAESEncryptedFile = flag;
    }

    public int available()
    {
        long l = length - bytesRead;
        if (l > 0x7fffffffL)
        {
            return 0x7fffffff;
        } else
        {
            return (int)l;
        }
    }

    protected void checkAndReadAESMacBytes()
        throws IOException
    {
label0:
        {
            if (!isAESEncryptedFile || decrypter == null || !(decrypter instanceof AESDecrypter) || ((AESDecrypter)decrypter).getStoredMac() != null)
            {
                return;
            }
            byte abyte0[] = new byte[10];
            int i = raf.read(abyte0);
            if (i != 10)
            {
                if (!unzipEngine.getZipModel().isSplitArchive())
                {
                    break label0;
                }
                raf.close();
                raf = unzipEngine.startNextSplitFile();
                raf.read(abyte0, i, 10 - i);
            }
            ((AESDecrypter)unzipEngine.getDecrypter()).setStoredMac(abyte0);
            return;
        }
        throw new IOException("Error occured while reading stored AES authentication bytes");
    }

    public void close()
        throws IOException
    {
        raf.close();
    }

    public UnzipEngine getUnzipEngine()
    {
        return unzipEngine;
    }

    public int read()
        throws IOException
    {
        if (bytesRead < length) goto _L2; else goto _L1
_L1:
        return -1;
_L2:
        if (!isAESEncryptedFile)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (aesBytesReturned != 0 && aesBytesReturned != 16)
        {
            break; /* Loop/switch isn't completed */
        }
        if (read(aesBlockByte) == -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        aesBytesReturned = 0;
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        byte abyte0[] = aesBlockByte;
        int i = aesBytesReturned;
        aesBytesReturned = i + 1;
        return abyte0[i] & 0xff;
        if (read(oneByteBuff, 0, 1) == -1) goto _L1; else goto _L4
_L4:
        return oneByteBuff[0] & 0xff;
    }

    public int read(byte abyte0[])
        throws IOException
    {
        return read(abyte0, 0, abyte0.length);
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        int k = j;
        if ((long)j > length - bytesRead)
        {
            j = (int)(length - bytesRead);
            k = j;
            if (j == 0)
            {
                checkAndReadAESMacBytes();
                return -1;
            }
        }
        j = k;
        if (unzipEngine.getDecrypter() instanceof AESDecrypter)
        {
            j = k;
            if (bytesRead + (long)k < length)
            {
                j = k;
                if (k % 16 != 0)
                {
                    j = k - k % 16;
                }
            }
        }
        RandomAccessFile randomaccessfile = raf;
        randomaccessfile;
        JVM INSTR monitorenter ;
        count = raf.read(abyte0, i, j);
        if (count >= j || !unzipEngine.getZipModel().isSplitArchive())
        {
            break MISSING_BLOCK_LABEL_204;
        }
        raf.close();
        raf = unzipEngine.startNextSplitFile();
        if (count < 0)
        {
            count = 0;
        }
        j = raf.read(abyte0, count, j - count);
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        count = count + j;
        randomaccessfile;
        JVM INSTR monitorexit ;
        if (count > 0)
        {
            if (decrypter != null)
            {
                try
                {
                    decrypter.decryptData(abyte0, i, count);
                }
                // Misplaced declaration of an exception variable
                catch (byte abyte0[])
                {
                    throw new IOException(abyte0.getMessage());
                }
            }
            bytesRead = bytesRead + (long)count;
        }
        if (bytesRead >= length)
        {
            checkAndReadAESMacBytes();
        }
        return count;
        abyte0;
        randomaccessfile;
        JVM INSTR monitorexit ;
        throw abyte0;
    }

    public void seek(long l)
        throws IOException
    {
        raf.seek(l);
    }

    public long skip(long l)
        throws IOException
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException();
        }
        long l1 = l;
        if (l > length - bytesRead)
        {
            l1 = length - bytesRead;
        }
        bytesRead = bytesRead + l1;
        return l1;
    }
}
