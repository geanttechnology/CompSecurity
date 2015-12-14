// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.Registry;
import com.bumptech.glide.d;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.b;
import java.io.File;
import java.util.List;
import myobfuscated.q.c;
import myobfuscated.t.a;
import myobfuscated.v.af;

// Referenced classes of package com.bumptech.glide.load.engine:
//            c, d, e, af, 
//            h

final class ae
    implements com.bumptech.glide.load.engine.c, c
{

    private final com.bumptech.glide.load.engine.d a;
    private final e b;
    private int c;
    private int d;
    private b e;
    private List f;
    private int g;
    private volatile af h;
    private File i;
    private com.bumptech.glide.load.engine.af j;

    public ae(e e1, com.bumptech.glide.load.engine.d d1)
    {
        c = 0;
        d = -1;
        b = e1;
        a = d1;
    }

    private boolean c()
    {
        return g < f.size();
    }

    public final void a(Exception exception)
    {
        a.a(j, exception, h.c, DataSource.RESOURCE_DISK_CACHE);
    }

    public final void a(Object obj)
    {
        a.a(e, obj, h.c, DataSource.RESOURCE_DISK_CACHE, j);
    }

    public final boolean a()
    {
        List list = b.b();
        if (!list.isEmpty()) goto _L2; else goto _L1
_L1:
        boolean flag1 = false;
_L4:
        return flag1;
_L2:
        boolean flag;
        Object obj = b;
        obj = ((e) (obj)).c.a.b(((e) (obj)).d.getClass(), ((e) (obj)).g, ((e) (obj)).k);
        do
        {
            if (f != null && c())
            {
                break;
            }
            d = d + 1;
            if (d >= ((List) (obj)).size())
            {
                c = c + 1;
                if (c >= list.size())
                {
                    return false;
                }
                d = 0;
            }
            b b1 = (b)list.get(c);
            Class class1 = (Class)((List) (obj)).get(d);
            com.bumptech.glide.load.h h1 = b.c(class1);
            j = new com.bumptech.glide.load.engine.af(b1, b.n, b.e, b.f, h1, class1, b.i);
            i = b.h.a().a(j);
            if (i != null)
            {
                e = b1;
                f = b.a(i);
                g = 0;
            }
        } while (true);
        h = null;
        flag = false;
_L6:
        flag1 = flag;
        if (flag) goto _L4; else goto _L3
_L3:
        flag1 = flag;
        if (!c()) goto _L4; else goto _L5
_L5:
        List list1 = f;
        int k = g;
        g = k + 1;
        h = ((myobfuscated.v.ae)list1.get(k)).buildLoadData(i, b.e, b.f, b.i);
        if (h != null && b.a(h.c.d()))
        {
            flag = true;
            h.c.a(b.o, this);
        }
          goto _L6
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
