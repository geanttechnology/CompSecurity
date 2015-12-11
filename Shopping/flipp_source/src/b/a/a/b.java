// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a;

import b.a.a.a.d;
import java.io.Serializable;

// Referenced classes of package b.a.a:
//            y, r, a, i

public final class b extends d
    implements y, Serializable
{

    public b()
    {
    }

    public b(long l, a a1)
    {
        super(l, a1);
    }

    private b(i i)
    {
        super(i);
    }

    public static b a(i i)
    {
        if (i == null)
        {
            throw new NullPointerException("Zone must not be null");
        } else
        {
            return new b(i);
        }
    }

    public final r c_()
    {
        return new r(super.a, super.b);
    }
}
