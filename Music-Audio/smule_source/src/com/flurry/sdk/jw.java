// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

// Referenced classes of package com.flurry.sdk:
//            iz, iy

public class jw
{

    final Class a;
    final Type b;
    final int c;

    protected jw()
    {
        b = a(getClass());
        a = iz.e(b);
        c = b.hashCode();
    }

    jw(Type type)
    {
        b = iz.d((Type)iy.a(type));
        a = iz.e(b);
        c = b.hashCode();
    }

    public static jw a(Type type)
    {
        return new jw(type);
    }

    static Type a(Class class1)
    {
        class1 = class1.getGenericSuperclass();
        if (class1 instanceof Class)
        {
            throw new RuntimeException("Missing type parameter.");
        } else
        {
            return iz.d(((ParameterizedType)class1).getActualTypeArguments()[0]);
        }
    }

    public static jw b(Class class1)
    {
        return new jw(class1);
    }

    public final Class a()
    {
        return a;
    }

    public final Type b()
    {
        return b;
    }

    public final boolean equals(Object obj)
    {
        return (obj instanceof jw) && iz.a(b, ((jw)obj).b);
    }

    public final int hashCode()
    {
        return c;
    }

    public final String toString()
    {
        return iz.f(b);
    }
}
