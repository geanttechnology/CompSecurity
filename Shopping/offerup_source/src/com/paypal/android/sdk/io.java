// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.paypal.android.sdk:
//            lj, ks, in, ip, 
//            kq, lk

final class io
    implements lj
{

    int a;
    byte b;
    int c;
    int d;
    short e;
    private final ks f;

    public io(ks ks1)
    {
        f = ks1;
    }

    public final long a(kq kq, long l)
    {
_L7:
        if (d != 0) goto _L2; else goto _L1
_L1:
        f.f(e);
        e = 0;
        if ((b & 4) == 0) goto _L4; else goto _L3
_L3:
        return -1L;
_L4:
        int i = c;
        int j = in.a(f);
        d = j;
        a = j;
        byte byte0 = f.d();
        b = f.d();
        if (in.b().isLoggable(Level.FINE))
        {
            in.b().fine(ip.a(true, c, a, byte0, b));
        }
        c = f.f() & 0x7fffffff;
        if (byte0 != 9)
        {
            throw in.a("%s != TYPE_CONTINUATION", new Object[] {
                Byte.valueOf(byte0)
            });
        }
        if (c != i)
        {
            throw in.a("TYPE_CONTINUATION streamId changed", new Object[0]);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        l = f.a(kq, Math.min(l, d));
        if (l == -1L) goto _L3; else goto _L5
_L5:
        d = (int)((long)d - l);
        return l;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final lk a()
    {
        return f.a();
    }

    public final void close()
    {
    }
}
