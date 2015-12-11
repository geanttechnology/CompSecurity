// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.io.InputStream;

// Referenced classes of package com.amazon.device.ads:
//            dy

final class b extends InputStream
{

    final dy a;
    private final InputStream b;

    public final void close()
    {
        b.close();
        if (dy.b(a))
        {
            a.a();
        }
    }

    public final int read()
    {
        return b.read();
    }

    public (dy dy1, InputStream inputstream)
    {
        a = dy1;
        super();
        b = inputstream;
    }
}
