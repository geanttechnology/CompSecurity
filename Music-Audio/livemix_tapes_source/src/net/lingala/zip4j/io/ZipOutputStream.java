// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.io;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.CRC32;
import net.lingala.zip4j.model.ZipModel;

// Referenced classes of package net.lingala.zip4j.io:
//            DeflaterOutputStream

public class ZipOutputStream extends DeflaterOutputStream
{

    public ZipOutputStream(OutputStream outputstream)
    {
        this(outputstream, null);
    }

    public ZipOutputStream(OutputStream outputstream, ZipModel zipmodel)
    {
        super(outputstream, zipmodel);
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
        crc.update(abyte0, i, j);
        updateTotalBytesRead(j);
        super.write(abyte0, i, j);
    }
}
