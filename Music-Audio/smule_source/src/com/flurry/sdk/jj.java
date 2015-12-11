// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            ir, ju, jz, jx, 
//            jy, is, ia, jw, 
//            iz

public final class jj extends ir
{

    public static final is a = new is() {

        public ir a(ia ia1, jw jw1)
        {
            jw1 = jw1.b();
            if (!(jw1 instanceof GenericArrayType) && (!(jw1 instanceof Class) || !((Class)jw1).isArray()))
            {
                return null;
            } else
            {
                jw1 = iz.g(jw1);
                return new jj(ia1, ia1.a(jw.a(jw1)), iz.e(jw1));
            }
        }

    };
    private final Class b;
    private final ir c;

    public jj(ia ia, ir ir1, Class class1)
    {
        c = new ju(ia, ir1, class1);
        b = class1;
    }

    public void a(jz jz1, Object obj)
    {
        if (obj == null)
        {
            jz1.f();
            return;
        }
        jz1.b();
        int i = 0;
        for (int j = Array.getLength(obj); i < j; i++)
        {
            Object obj1 = Array.get(obj, i);
            c.a(jz1, obj1);
        }

        jz1.c();
    }

    public Object b(jx jx1)
    {
        if (jx1.f() == jy.i)
        {
            jx1.j();
            return null;
        }
        ArrayList arraylist = new ArrayList();
        jx1.a();
        for (; jx1.e(); arraylist.add(c.b(jx1))) { }
        jx1.b();
        jx1 = ((jx) (Array.newInstance(b, arraylist.size())));
        for (int i = 0; i < arraylist.size(); i++)
        {
            Array.set(jx1, i, arraylist.get(i));
        }

        return jx1;
    }

}
