// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.io;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;

// Referenced classes of package net.lingala.zip4j.io:
//            CipherOutputStream

public class DeflaterOutputStream extends CipherOutputStream
{

    private byte buff[];
    protected Deflater deflater;
    private boolean firstBytesRead;

    public DeflaterOutputStream(OutputStream outputstream, ZipModel zipmodel)
    {
        super(outputstream, zipmodel);
        deflater = new Deflater();
        buff = new byte[4096];
        firstBytesRead = false;
    }

    private void deflate()
        throws IOException
    {
        int i;
label0:
        {
            int j;
label1:
            {
                j = deflater.deflate(buff, 0, buff.length);
                if (j > 0)
                {
                    i = j;
                    if (!deflater.finished())
                    {
                        break label0;
                    }
                    if (j != 4)
                    {
                        break label1;
                    }
                }
                return;
            }
            if (j < 4)
            {
                decrementCompressedFileSize(4 - j);
                return;
            }
            i = j - 4;
        }
        if (!firstBytesRead)
        {
            super.write(buff, 2, i - 2);
            firstBytesRead = true;
            return;
        } else
        {
            super.write(buff, 0, i);
            return;
        }
    }

    public void closeEntry()
        throws IOException, ZipException
    {
        if (zipParameters.getCompressionMethod() != 8) goto _L2; else goto _L1
_L1:
        if (deflater.finished()) goto _L4; else goto _L3
_L3:
        deflater.finish();
_L7:
        if (!deflater.finished()) goto _L5; else goto _L4
_L4:
        firstBytesRead = false;
_L2:
        super.closeEntry();
        return;
_L5:
        deflate();
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void finish()
        throws IOException, ZipException
    {
        super.finish();
    }

    public void putNextEntry(File file, ZipParameters zipparameters)
        throws ZipException
    {
        super.putNextEntry(file, zipparameters);
        if (zipparameters.getCompressionMethod() == 8)
        {
            deflater.reset();
            if ((zipparameters.getCompressionLevel() < 0 || zipparameters.getCompressionLevel() > 9) && zipparameters.getCompressionLevel() != -1)
            {
                throw new ZipException("invalid compression level for deflater. compression level should be in the range of 0-9");
            }
            deflater.setLevel(zipparameters.getCompressionLevel());
        }
    }

    public void write(int i)
        throws IOException
    {
        write(new byte[] {
            (byte)i
        }, 0, 1);
    }

    public void write(byte abyte0[])
        throws IOException
    {
        write(abyte0, 0, abyte0.length);
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        if (zipParameters.getCompressionMethod() != 8)
        {
            super.write(abyte0, i, j);
        } else
        {
            deflater.setInput(abyte0, i, j);
            while (!deflater.needsInput()) 
            {
                deflate();
            }
        }
    }
}
