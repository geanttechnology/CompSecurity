// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import com.ebay.nautilus.kernel.content.EbayContext;
import java.io.IOException;
import java.io.InterruptedIOException;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            Connector, Response

private static abstract class <init>
{

    protected final ion checkForInterruptedIoException(ion ion)
        throws InterruptedIOException
    {
        for (Throwable throwable = ion.getCause(); throwable != null; throwable = throwable.getCause())
        {
            if (throwable instanceof InterruptedIOException)
            {
                throw (InterruptedIOException)throwable;
            }
        }

        return ion;
    }

    public abstract Response getResponse();

    protected final boolean invalidDeviceClock()
    {
        return System.currentTimeMillis() <= 0x15025d92800L;
    }

    public abstract void sendRequest(EbayContext ebaycontext)
        throws IOException, InterruptedException;

    private ion()
    {
    }

    ion(ion ion)
    {
        this();
    }
}
