// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.util.logging.Logger;

// Referenced classes of package com.paypal.android.sdk:
//            jf, ip, kt, ks, 
//            kr, iq, ir, ho, 
//            hq

public final class in
    implements jf
{

    private static final Logger a = Logger.getLogger(com/paypal/android/sdk/ip.getName());
    private static final kt b = kt.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    public in()
    {
    }

    static int a(int i, byte byte0, short word0)
    {
        int j = i;
        if ((byte0 & 8) != 0)
        {
            j = i - 1;
        }
        if (word0 > j)
        {
            throw c("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] {
                Short.valueOf(word0), Integer.valueOf(j)
            });
        } else
        {
            return (short)(j - word0);
        }
    }

    static int a(ks ks1)
    {
        return (ks1.d() & 0xff) << 16 | (ks1.d() & 0xff) << 8 | ks1.d() & 0xff;
    }

    static kt a()
    {
        return b;
    }

    static IOException a(String s, Object aobj[])
    {
        return c(s, aobj);
    }

    static void a(kr kr1, int i)
    {
        kr1.h(i >>> 16 & 0xff);
        kr1.h(i >>> 8 & 0xff);
        kr1.h(i & 0xff);
    }

    static IllegalArgumentException b(String s, Object aobj[])
    {
        throw new IllegalArgumentException(String.format(s, aobj));
    }

    static Logger b()
    {
        return a;
    }

    private static transient IOException c(String s, Object aobj[])
    {
        throw new IOException(String.format(s, aobj));
    }

    public final ho a(ks ks1, boolean flag)
    {
        return new iq(ks1, flag);
    }

    public final hq a(kr kr1, boolean flag)
    {
        return new ir(kr1, flag);
    }

}
