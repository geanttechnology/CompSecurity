// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            ic, ia, id

final class nit> extends ic
{

    final ia a;

    protected final int a()
    {
        return a.h;
    }

    protected final int a(Object obj)
    {
        if (obj == null)
        {
            return a.a();
        } else
        {
            return a.a(obj, obj.hashCode());
        }
    }

    protected final Object a(int i, int j)
    {
        return a.g[(i << 1) + j];
    }

    protected final Object a(int i, Object obj)
    {
        ia ia1 = a;
        i = (i << 1) + 1;
        Object obj1 = ((id) (ia1)).g[i];
        ((id) (ia1)).g[i] = obj;
        return obj1;
    }

    protected final void a(int i)
    {
        a.d(i);
    }

    protected final void a(Object obj, Object obj1)
    {
        a.put(obj, obj1);
    }

    protected final int b(Object obj)
    {
        return a.a(obj);
    }

    protected final Map b()
    {
        return a;
    }

    protected final void c()
    {
        a.clear();
    }

    (ia ia1)
    {
        a = ia1;
        super();
    }
}
