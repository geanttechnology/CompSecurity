// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import com.amazon.dp.logger.DPLogger;
import com.dp.utils.FailFast;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamProxy extends IInputStream.Stub
{

    private static final DPLogger log = new DPLogger("TComm.InputStreamProxy");
    private final InputStream mInputStream;

    public InputStreamProxy(InputStream inputstream)
    {
        if (inputstream == null)
        {
            throw new IllegalArgumentException("InputStream cannot be null");
        } else
        {
            mInputStream = inputstream;
            return;
        }
    }

    public int available()
    {
        int i;
        try
        {
            i = mInputStream.available();
        }
        catch (IOException ioexception)
        {
            log.error("available", "IOException caught while calling available", new Object[] {
                ioexception
            });
            return -2;
        }
        return i;
    }

    public boolean close()
    {
        try
        {
            mInputStream.close();
        }
        catch (IOException ioexception)
        {
            log.error("close", "IOException caught while calling close", new Object[] {
                ioexception
            });
            return false;
        }
        return true;
    }

    public int readByte()
    {
        int i;
        try
        {
            i = mInputStream.read();
        }
        catch (IOException ioexception)
        {
            log.error("readByte", "IOException caught while calling read", new Object[] {
                ioexception
            });
            return -2;
        }
        return i;
    }

    public int readBytes(byte abyte0[])
    {
        FailFast.expectNotNull(abyte0);
        log.debug("read(byte[])", "About to read", new Object[] {
            "length", Integer.valueOf(abyte0.length)
        });
        int i;
        try
        {
            i = mInputStream.read(abyte0);
        }
        catch (IOException ioexception)
        {
            log.error("readBytes", "IOException caught while calling read", new Object[] {
                "data.length", Integer.valueOf(abyte0.length), ioexception
            });
            return -2;
        }
        return i;
    }

    public int readBytesIntoOffset(byte abyte0[], int i, int j)
    {
        FailFast.expectNotNull(abyte0);
        log.debug("read(byte[],int,int)", "About to read", new Object[] {
            "data.length", Integer.valueOf(abyte0.length), "offset", Integer.valueOf(i), "length", Integer.valueOf(j)
        });
        try
        {
            i = mInputStream.read(abyte0, i, j);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            log.error("readBytesIntoOffset", "IOException caught while calling read", new Object[] {
                abyte0
            });
            return -2;
        }
        return i;
    }

}
