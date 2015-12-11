// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.graphics.Bitmap;

// Referenced classes of package com.g.c:
//            a, e, u, x

final class k extends a
{

    private final Object m = new Object();
    private e n;

    k(u u, x x, int i, int j, Object obj, String s)
    {
        super(u, null, x, i, j, 0, null, s, obj, false);
        n = null;
    }

    final void a()
    {
        if (n != null)
        {
            n.b();
        }
    }

    final void a(Bitmap bitmap, u.d d)
    {
        if (n != null)
        {
            n.a();
        }
    }

    final void b()
    {
        super.b();
        n = null;
    }

    final Object c()
    {
        return m;
    }
}
