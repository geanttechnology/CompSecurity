// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.b;
import java.io.File;
import java.util.List;
import myobfuscated.q.c;
import myobfuscated.v.ae;
import myobfuscated.v.af;

// Referenced classes of package com.bumptech.glide.load.engine:
//            c, e, d, b, 
//            h

final class a
    implements com.bumptech.glide.load.engine.c, c
{

    private List a;
    private final e b;
    private final d c;
    private int d;
    private b e;
    private List f;
    private int g;
    private volatile af h;
    private File i;

    a(e e1, d d1)
    {
        this(e1.b(), e1, d1);
    }

    a(List list, e e1, d d1)
    {
        d = -1;
        a = list;
        b = e1;
        c = d1;
    }

    private boolean c()
    {
        return g < f.size();
    }

    public final void a(Exception exception)
    {
        c.a(e, exception, h.c, DataSource.DATA_DISK_CACHE);
    }

    public final void a(Object obj)
    {
        c.a(e, obj, h.c, DataSource.DATA_DISK_CACHE, e);
    }

    public final boolean a()
    {
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = false;
_L5:
        if (f != null && c()) goto _L2; else goto _L1
_L1:
        d = d + 1;
        if (d < a.size()) goto _L4; else goto _L3
_L3:
        return flag1;
_L4:
        b b1 = (b)a.get(d);
        com.bumptech.glide.load.engine.b b2 = new com.bumptech.glide.load.engine.b(b1, b.n);
        i = b.h.a().a(b2);
        if (i != null)
        {
            e = b1;
            f = b.a(i);
            g = 0;
        }
          goto _L5
_L2:
        h = null;
_L8:
        flag1 = flag;
        if (flag) goto _L3; else goto _L6
_L6:
        flag1 = flag;
        if (!c()) goto _L3; else goto _L7
_L7:
        List list = f;
        int j = g;
        g = j + 1;
        h = ((ae)list.get(j)).buildLoadData(i, b.e, b.f, b.i);
        if (h != null && b.a(h.c.d()))
        {
            flag = true;
            h.c.a(b.o, this);
        }
          goto _L8
    }

    public final void b()
    {
        af af1 = h;
        if (af1 != null)
        {
            af1.c.b();
        }
    }
}
