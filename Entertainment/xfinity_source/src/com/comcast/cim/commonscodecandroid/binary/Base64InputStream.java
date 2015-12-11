// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.commonscodecandroid.binary;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.comcast.cim.commonscodecandroid.binary:
//            Base64

public class Base64InputStream extends FilterInputStream
{

    private final Base64 base64;
    private final boolean doEncode;
    private final byte singleByte[];

    public boolean markSupported()
    {
        return false;
    }

    public int read()
        throws IOException
    {
        int i;
        for (i = read(singleByte, 0, 1); i == 0; i = read(singleByte, 0, 1)) { }
        if (i > 0)
        {
            if (singleByte[0] < 0)
            {
                return singleByte[0] + 256;
            } else
            {
                return singleByte[0];
            }
        } else
        {
            return -1;
        }
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        if (abyte0 == null)
        {
            throw new NullPointerException();
        }
        if (i < 0 || j < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        if (i > abyte0.length || i + j > abyte0.length)
        {
            throw new IndexOutOfBoundsException();
        }
        if (j == 0)
        {
            return 0;
        }
        if (!base64.hasData())
        {
            byte abyte1[];
            int k;
            if (doEncode)
            {
                k = 4096;
            } else
            {
                k = 8192;
            }
            abyte1 = new byte[k];
            k = in.read(abyte1);
            if (k > 0 && abyte0.length == j)
            {
                base64.setInitialBuffer(abyte0, i, j);
            }
            if (doEncode)
            {
                base64.encode(abyte1, 0, k);
            } else
            {
                base64.decode(abyte1, 0, k);
            }
        }
        return base64.readResults(abyte0, i, j);
    }
}
