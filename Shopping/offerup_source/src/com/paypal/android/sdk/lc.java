// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.paypal.android.sdk:
//            kl, kz

final class lc extends kl
{

    private Socket b;

    lc(Socket socket)
    {
        b = socket;
        super();
    }

    protected final IOException a(IOException ioexception)
    {
        SocketTimeoutException sockettimeoutexception = new SocketTimeoutException("timeout");
        if (ioexception != null)
        {
            sockettimeoutexception.initCause(ioexception);
        }
        return sockettimeoutexception;
    }

    protected final void a()
    {
        try
        {
            b.close();
            return;
        }
        catch (Exception exception)
        {
            kz.a().log(Level.WARNING, (new StringBuilder("Failed to close timed out socket ")).append(b).toString(), exception);
            return;
        }
        catch (AssertionError assertionerror)
        {
            if (assertionerror.getCause() != null && assertionerror.getMessage() != null && assertionerror.getMessage().contains("getsockname failed"))
            {
                kz.a().log(Level.WARNING, (new StringBuilder("Failed to close timed out socket ")).append(b).toString(), assertionerror);
                return;
            } else
            {
                throw assertionerror;
            }
        }
    }
}
