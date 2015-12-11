// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.a;

import b.a.a.a;
import b.a.a.b.t;
import b.a.a.f;
import b.a.a.i;
import b.a.a.y;
import java.io.Serializable;

// Referenced classes of package b.a.a.a:
//            a

public abstract class d extends b.a.a.a.a
    implements y, Serializable
{

    public volatile long a;
    public volatile a b;

    public d()
    {
        this(f.a(), ((a) (t.M())));
    }

    public d(long l, a a1)
    {
        b = f.a(a1);
        a1 = b;
        a = l;
    }

    public d(i i)
    {
        this(f.a(), ((a) (t.b(i))));
    }

    public d(i i, byte byte0)
    {
        this(0L, ((a) (t.b(i))));
    }

    public final long a()
    {
        return a;
    }

    public void a(long l)
    {
        a a1 = b;
        a = l;
    }

    public final a b()
    {
        return b;
    }
}
