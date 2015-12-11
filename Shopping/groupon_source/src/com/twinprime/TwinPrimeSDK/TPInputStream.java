// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPEventLog

class TPInputStream extends InputStream
{

    private InputStream is;
    int totalBytes;
    private TPEventLog tpEvLog;

    TPInputStream(InputStream inputstream, TPEventLog tpeventlog)
    {
        totalBytes = 0;
        is = inputstream;
        tpEvLog = tpeventlog;
    }

    public void close()
        throws IOException
    {
        is.close();
    }

    public int read()
        throws IOException
    {
        int i = is.read();
        if (i != -1)
        {
            totalBytes = totalBytes + 1;
        }
        return i;
    }

    public int read(byte abyte0[])
        throws IOException
    {
        int i = is.read(abyte0);
        if (i != -1)
        {
            totalBytes = totalBytes + i;
        }
        return i;
    }
}
