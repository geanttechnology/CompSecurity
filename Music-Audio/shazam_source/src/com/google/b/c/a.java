// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.c;

import com.google.b.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class a
{

    public final Class a;
    public final Type b;
    final int c;

    public a()
    {
        Type type = getClass().getGenericSuperclass();
        if (type instanceof Class)
        {
            throw new RuntimeException("Missing type parameter.");
        } else
        {
            b = com.google.b.b.b.a(((ParameterizedType)type).getActualTypeArguments()[0]);
            a = com.google.b.b.b.b(b);
            c = b.hashCode();
            return;
        }
    }

    private a(Type type)
    {
        b = com.google.b.b.b.a((Type)com.google.b.b.a.a(type));
        a = com.google.b.b.b.b(b);
        c = b.hashCode();
    }

    public static a a(Class class1)
    {
        return new a(class1);
    }

    public static a a(Type type)
    {
        return new a(type);
    }

    public final boolean equals(Object obj)
    {
        return (obj instanceof a) && com.google.b.b.b.a(b, ((a)obj).b);
    }

    public final int hashCode()
    {
        return c;
    }

    public final String toString()
    {
        return com.google.b.b.b.c(b);
    }
}
