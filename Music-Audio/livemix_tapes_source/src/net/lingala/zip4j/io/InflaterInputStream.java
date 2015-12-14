// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.unzip.UnzipEngine;

// Referenced classes of package net.lingala.zip4j.io:
//            PartInputStream

public class InflaterInputStream extends PartInputStream
{

    private byte buff[];
    private long bytesWritten;
    private Inflater inflater;
    private byte oneByteBuff[];
    private long uncompressedSize;
    private UnzipEngine unzipEngine;

    public InflaterInputStream(RandomAccessFile randomaccessfile, long l, long l1, UnzipEngine unzipengine)
    {
        super(randomaccessfile, l, l1, unzipengine);
        oneByteBuff = new byte[1];
        inflater = new Inflater(true);
        buff = new byte[4096];
        unzipEngine = unzipengine;
        bytesWritten = 0L;
        uncompressedSize = unzipengine.getFileHeader().getUncompressedSize();
    }

    private void fill()
        throws IOException
    {
        int i = super.read(buff, 0, buff.length);
        if (i == -1)
        {
            throw new EOFException("Unexpected end of ZLIB input stream");
        } else
        {
            inflater.setInput(buff, 0, i);
            return;
        }
    }

    private void finishInflating()
        throws IOException
    {
        for (byte abyte0[] = new byte[1024]; super.read(abyte0, 0, 1024) != -1;) { }
        checkAndReadAESMacBytes();
    }

    public int available()
    {
        return !inflater.finished() ? 1 : 0;
    }

    public void close()
        throws IOException
    {
        inflater.end();
        super.close();
    }

    public UnzipEngine getUnzipEngine()
    {
        return super.getUnzipEngine();
    }

    public int read()
        throws IOException
    {
        if (read(oneByteBuff, 0, 1) == -1)
        {
            return -1;
        } else
        {
            return oneByteBuff[0] & 0xff;
        }
    }

    public int read(byte abyte0[])
        throws IOException
    {
        if (abyte0 == null)
        {
            throw new NullPointerException("input buffer is null");
        } else
        {
            return read(abyte0, 0, abyte0.length);
        }
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        if (abyte0 == null)
        {
            throw new NullPointerException("input buffer is null");
        }
        if (i < 0 || j < 0 || j > abyte0.length - i)
        {
            throw new IndexOutOfBoundsException();
        }
        if (j == 0)
        {
            return 0;
        }
        if (bytesWritten < uncompressedSize) goto _L2; else goto _L1
_L1:
        finishInflating();
        return -1;
_L4:
        if (!inflater.finished() && !inflater.needsDictionary())
        {
            break MISSING_BLOCK_LABEL_88;
        }
        finishInflating();
        return -1;
        if (inflater.needsInput())
        {
            fill();
        }
_L2:
        int k = inflater.inflate(abyte0, i, j);
        if (k != 0)
        {
            try
            {
                bytesWritten = bytesWritten + (long)k;
            }
            catch (DataFormatException dataformatexception)
            {
                abyte0 = "Invalid ZLIB data format";
                if (dataformatexception.getMessage() != null)
                {
                    abyte0 = dataformatexception.getMessage();
                }
                Object obj = abyte0;
                if (unzipEngine != null)
                {
                    obj = abyte0;
                    if (unzipEngine.getLocalFileHeader().isEncrypted())
                    {
                        obj = abyte0;
                        if (unzipEngine.getLocalFileHeader().getEncryptionMethod() == 0)
                        {
                            obj = abyte0 + " - Wrong Password?";
                        }
                    }
                }
                throw new IOException(((String) (obj)));
            }
            return k;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void seek(long l)
        throws IOException
    {
        super.seek(l);
    }

    public long skip(long l)
        throws IOException
    {
        byte abyte0[];
        int i;
        int i1;
        if (l < 0L)
        {
            throw new IllegalArgumentException("negative skip length");
        }
        i1 = (int)Math.min(l, 0x7fffffffL);
        i = 0;
        abyte0 = new byte[512];
_L5:
        if (i < i1) goto _L2; else goto _L1
_L1:
        return (long)i;
_L2:
        int j;
        int k = i1 - i;
        j = k;
        if (k > abyte0.length)
        {
            j = abyte0.length;
        }
        j = read(abyte0, 0, j);
        if (j == -1) goto _L1; else goto _L3
_L3:
        i += j;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
