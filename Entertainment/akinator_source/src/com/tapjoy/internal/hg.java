// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.tapjoy.internal:
//            bk, dx, dz

public final class hg
    implements bk
{

    private final dz a;

    public hg(dz dz1)
    {
        a = dz1;
    }

    public final volatile void a(OutputStream outputstream, Object obj)
    {
        ((dx)obj).a(outputstream);
    }

    public final Object b(InputStream inputstream)
    {
        return (dx)a.a(inputstream);
    }
}
