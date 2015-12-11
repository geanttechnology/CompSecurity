// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.c.a;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.x;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class l extends x
{

    private final f a;
    private final x b;
    private final Type c;

    l(f f1, x x1, Type type)
    {
        a = f1;
        b = x1;
        c = type;
    }

    public final Object a(com.google.b.d.a a1)
    {
        return b.a(a1);
    }

    public final void a(c c1, Object obj)
    {
        Object obj1;
        x x1;
label0:
        {
            x1 = b;
            Type type = c;
            obj1 = type;
            if (obj == null)
            {
                break label0;
            }
            if (type != java/lang/Object && !(type instanceof TypeVariable))
            {
                obj1 = type;
                if (!(type instanceof Class))
                {
                    break label0;
                }
            }
            obj1 = obj.getClass();
        }
        if (obj1 != c)
        {
            x1 = a.a(com.google.b.c.a.a(((Type) (obj1))));
            obj1 = x1;
            if (x1 instanceof i.a)
            {
                obj1 = x1;
                if (!(b instanceof i.a))
                {
                    obj1 = b;
                }
            }
        } else
        {
            obj1 = x1;
        }
        ((x) (obj1)).a(c1, obj);
    }
}
