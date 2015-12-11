// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;

import e.f;
import e.h;

// Referenced classes of package e.d.a:
//            x, w, v, z

final class y
    implements f
{

    final f a;
    private x b;

    y(x x1, f f1)
    {
        b = x1;
        a = f1;
        super();
    }

    public final void a(long l)
    {
        if (Thread.currentThread() == b.a)
        {
            a.a(l);
            return;
        } else
        {
            b.b.a.b.a(new z(this, l));
            return;
        }
    }
}
