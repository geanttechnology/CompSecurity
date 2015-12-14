// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.a;

import android.graphics.Bitmap;

// Referenced classes of package com.pf.common.a:
//            g, i, c

final class k extends g
    implements i
{

    final c c;

    private k(c c1, i j)
    {
        c = c1;
        super(c1, j);
    }

    k(c c1, i j, c._cls1 _pcls1)
    {
        this(c1, j);
    }

    private i c()
    {
        return (i)a;
    }

    public void b(Bitmap bitmap)
    {
        c.c();
        c().b(bitmap);
    }
}
