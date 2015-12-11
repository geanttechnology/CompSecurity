// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.b.c;
import com.google.b.b.h;
import com.google.b.c.a;
import com.google.b.f;
import com.google.b.x;
import com.google.b.y;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.google.b.b.a:
//            l

public final class b
    implements y
{
    private static final class a extends x
    {

        private final x a;
        private final h b;

        public final Object a(com.google.b.d.a a1)
        {
            if (a1.f() == com.google.b.d.b.i)
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

        public final void a(com.google.b.d.c c1, Object obj)
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

        public a(f f1, Type type, x x1, h h1)
        {
            a = new l(f1, x1, type);
            b = h1;
        }
    }


    private final c a;

    public b(c c1)
    {
        a = c1;
    }

    public final x a(f f1, com.google.b.c.a a1)
    {
        Type type = a1.b;
        Class class1 = a1.a;
        if (!java/util/Collection.isAssignableFrom(class1))
        {
            return null;
        } else
        {
            type = com.google.b.b.b.a(type, class1);
            return new a(f1, type, f1.a(com.google.b.c.a.a(type)), a.a(a1));
        }
    }
}
