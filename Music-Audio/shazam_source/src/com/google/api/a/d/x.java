// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;

import com.google.api.a.f.a.a.a.a.c;
import java.io.InputStream;

// Referenced classes of package com.google.api.a.d:
//            b

public final class x extends b
{

    public long c;
    public boolean d;
    private final InputStream e;

    public x(String s, InputStream inputstream)
    {
        super(s);
        c = -1L;
        e = (InputStream)com.google.api.a.f.a.a.a.a.c.a(inputstream);
    }

    public final long a()
    {
        return c;
    }

    public final volatile b a(String s)
    {
        return (x)super.a(s);
    }

    public final b a(boolean flag)
    {
        return b(flag);
    }

    public final x b(boolean flag)
    {
        return (x)super.a(flag);
    }

    public final InputStream b()
    {
        return e;
    }

    public final boolean d()
    {
        return d;
    }
}
