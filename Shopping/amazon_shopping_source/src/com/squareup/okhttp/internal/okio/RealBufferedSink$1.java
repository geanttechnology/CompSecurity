// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.okio;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.squareup.okhttp.internal.okio:
//            RealBufferedSink, OkBuffer

class this._cls0 extends OutputStream
{

    final RealBufferedSink this$0;

    private void checkNotClosed()
        throws IOException
    {
        if (RealBufferedSink.access$000(RealBufferedSink.this))
        {
            throw new IOException("closed");
        } else
        {
            return;
        }
    }

    public void close()
        throws IOException
    {
        RealBufferedSink.this.close();
    }

    public void flush()
        throws IOException
    {
        if (!RealBufferedSink.access$000(RealBufferedSink.this))
        {
            RealBufferedSink.this.flush();
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append(RealBufferedSink.this).append(".outputStream()").toString();
    }

    public void write(int i)
        throws IOException
    {
        checkNotClosed();
        buffer.writeByte((byte)i);
        emitCompleteSegments();
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        checkNotClosed();
        buffer.write(abyte0, i, j);
        emitCompleteSegments();
    }

    ()
    {
        this$0 = RealBufferedSink.this;
        super();
    }
}
