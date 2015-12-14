// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package org.apache.commons.httpclient:
//            Wire

class WireLogInputStream extends FilterInputStream
{

    private InputStream in;
    private Wire wire;

    public WireLogInputStream(InputStream inputstream, Wire wire1)
    {
        super(inputstream);
        in = inputstream;
        wire = wire1;
    }

    public int read()
        throws IOException
    {
        int i = in.read();
        if (i > 0)
        {
            wire.input(i);
        }
        return i;
    }

    public int read(byte abyte0[])
        throws IOException
    {
        int i = in.read(abyte0);
        if (i > 0)
        {
            wire.input(abyte0, 0, i);
        }
        return i;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        j = in.read(abyte0, i, j);
        if (j > 0)
        {
            wire.input(abyte0, i, j);
        }
        return j;
    }
}
