// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.b.h;
import com.google.b.d.a;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.x;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.google.b.b.a:
//            b, l

private static final class b extends x
{

    private final x a;
    private final h b;

    public final Object a(a a1)
    {
        if (a1.f() == b.i)
        {
            a1.k();
            return null;
        }
        Collection collection = (Collection)b.a();
        a1.a();
        for (; a1.e(); collection.add(a.a(a1))) { }
        a1.b();
        return collection;
    }

    public final void a(c c1, Object obj)
    {
        obj = (Collection)obj;
        if (obj == null)
        {
            c1.f();
            return;
        }
        c1.b();
        Object obj1;
        for (obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext(); a.a(c1, obj1))
        {
            obj1 = ((Iterator) (obj)).next();
        }

        c1.c();
    }

    public e(f f, Type type, x x1, h h1)
    {
        a = new l(f, x1, type);
        b = h1;
    }
}
