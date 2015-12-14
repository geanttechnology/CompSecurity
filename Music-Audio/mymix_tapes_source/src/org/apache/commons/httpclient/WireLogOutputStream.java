// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package org.apache.commons.httpclient:
//            Wire

class WireLogOutputStream extends FilterOutputStream
{

    private OutputStream out;
    private Wire wire;

    public WireLogOutputStream(OutputStream outputstream, Wire wire1)
    {
        super(outputstream);
        out = outputstream;
        wire = wire1;
    }

    public void write(int i)
        throws IOException
    {
        out.write(i);
        wire.output(i);
    }

    public void write(byte abyte0[])
        throws IOException
    {
        out.write(abyte0);
        wire.output(abyte0);
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        out.write(abyte0, i, j);
        wire.output(abyte0, i, j);
    }
}
