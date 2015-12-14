// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ag;

import myobfuscated.aj.j;

// Referenced classes of package myobfuscated.ag:
//            h, g

public abstract class f extends h
{

    private final int a;
    private final int b;

    public f()
    {
        this(0x80000000, 0x80000000);
    }

    public f(int i, int k)
    {
        a = i;
        b = k;
    }

    public final void a(g g1)
    {
        if (!j.a(a, b))
        {
            throw new IllegalArgumentException((new StringBuilder("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ")).append(a).append(" and height: ").append(b).append(", either provide dimensions in the constructor or call override()").toString());
        } else
        {
            g1.a(a, b);
            return;
        }
    }
}
