// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.f;

import com.google.a.a.g;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

abstract class a
{

    a()
    {
    }

    final Type a()
    {
        Type type = getClass().getGenericSuperclass();
        g.a(type instanceof ParameterizedType, "%s isn't parameterized", new Object[] {
            type
        });
        return ((ParameterizedType)type).getActualTypeArguments()[0];
    }
}
