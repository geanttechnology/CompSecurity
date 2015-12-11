// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.x;
import com.google.b.y;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.b.b.a:
//            l

public final class a extends x
{

    public static final y a = new y() {

        public final x a(f f1, com.google.b.c.a a1)
        {
            a1 = a1.b;
            if (!(a1 instanceof GenericArrayType) && (!(a1 instanceof Class) || !((Class)a1).isArray()))
            {
                return null;
            } else
            {
                a1 = com.google.b.b.b.d(a1);
                return new a(f1, f1.a(com.google.b.c.a.a(a1)), com.google.b.b.b.b(a1));
            }
        }

    };
    private final Class b;
    private final x c;

    public a(f f, x x1, Class class1)
    {
        c = new l(f, x1, class1);
        b = class1;
    }

    public final Object a(com.google.b.d.a a1)
    {
        if (a1.f() == b.i)
        {
            a1.k();
            return null;
        }
        ArrayList arraylist = new ArrayList();
        a1.a();
        for (; a1.e(); arraylist.add(c.a(a1))) { }
        a1.b();
        a1 = ((com.google.b.d.a) (Array.newInstance(b, arraylist.size())));
        for (int i = 0; i < arraylist.size(); i++)
        {
            Array.set(a1, i, arraylist.get(i));
        }

        return a1;
    }

    public final void a(c c1, Object obj)
    {
        if (obj == null)
        {
            c1.f();
            return;
        }
        c1.b();
        int i = 0;
        for (int j = Array.getLength(obj); i < j; i++)
        {
            Object obj1 = Array.get(obj, i);
            c.a(c1, obj1);
        }

        c1.c();
    }

}
