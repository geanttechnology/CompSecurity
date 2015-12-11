// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.io;

import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CacheStream extends FilterInputStream
{

    private volatile OutputStream out;
    private boolean readingArray;

    public CacheStream(InputStream inputstream, OutputStream outputstream)
    {
        super(inputstream);
        readingArray = false;
        out = outputstream;
    }

    public void close()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        StreamUtil.closeQuietly(out);
        out = null;
        super.close();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public int read()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        OutputStream outputstream;
        int i;
        i = super.read();
        if (readingArray)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        outputstream = out;
        if (outputstream == null || i == -1)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        out.write(i);
_L2:
        this;
        JVM INSTR monitorexit ;
        return i;
        Object obj;
        obj;
        StreamUtil.closeQuietly(out);
        out = null;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        readingArray = true;
        OutputStream outputstream;
        j = super.read(abyte0, i, j);
        outputstream = out;
        if (outputstream == null || j <= 0)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        out.write(abyte0, i, j);
_L1:
        readingArray = false;
        this;
        JVM INSTR monitorexit ;
        return j;
        abyte0;
        StreamUtil.closeQuietly(out);
        out = null;
          goto _L1
        abyte0;
        readingArray = false;
        throw abyte0;
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
    }
}
