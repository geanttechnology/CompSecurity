// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.a.b;

import android.os.Handler;
import e.c.a;
import e.d.c.g;

// Referenced classes of package e.a.b:
//            c

final class d
    implements a
{

    private g a;
    private c b;

    d(c c1, g g)
    {
        b = c1;
        a = g;
        super();
    }

    public final void a()
    {
        e.a.b.c.a(b).removeCallbacks(a);
    }
}
