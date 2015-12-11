// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.net.Socket;
import java.util.logging.Logger;

// Referenced classes of package com.paypal.android.sdk:
//            ld, le, km, la, 
//            kn, lb, lc, lh, 
//            kr, lj, ks, kl

public final class kz
{

    private static final Logger a = Logger.getLogger(com/paypal/android/sdk/kz.getName());

    private kz()
    {
    }

    public static kr a(lh lh)
    {
        if (lh == null)
        {
            throw new IllegalArgumentException("sink == null");
        } else
        {
            return new ld(lh);
        }
    }

    public static ks a(lj lj)
    {
        if (lj == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            return new le(lj);
        }
    }

    public static lh a(Socket socket)
    {
        if (socket == null)
        {
            throw new IllegalArgumentException("socket == null");
        }
        kl kl = c(socket);
        socket = socket.getOutputStream();
        if (socket == null)
        {
            throw new IllegalArgumentException("out == null");
        } else
        {
            return new km(kl, new la(kl, socket));
        }
    }

    static Logger a()
    {
        return a;
    }

    public static lj b(Socket socket)
    {
        if (socket == null)
        {
            throw new IllegalArgumentException("socket == null");
        }
        kl kl = c(socket);
        socket = socket.getInputStream();
        if (socket == null)
        {
            throw new IllegalArgumentException("in == null");
        } else
        {
            return new kn(kl, new lb(kl, socket));
        }
    }

    private static kl c(Socket socket)
    {
        return new lc(socket);
    }

}
