// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.net.SocketTimeoutException;

// Referenced classes of package com.paypal.android.sdk:
//            kl, hn, id

final class ih extends kl
{

    private id b;

    ih(id id1)
    {
        b = id1;
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
        b.b(hn.h);
    }

    public final void b()
    {
        if (d())
        {
            throw a(null);
        } else
        {
            return;
        }
    }
}
