// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.f;

import com.google.a.c.ad;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

// Referenced classes of package com.google.a.f:
//            c

static final class nit> extends nit>
{

    final Class a(Object obj)
    {
        return com.google.a.f.c.c(((c)obj).a);
    }

    final Iterable b(Object obj)
    {
        obj = (c)obj;
        if (((c) (obj)).a instanceof TypeVariable)
        {
            return com.google.a.f.c.a(((TypeVariable)((c) (obj)).a).getBounds());
        }
        if (((c) (obj)).a instanceof WildcardType)
        {
            return com.google.a.f.c.a(((WildcardType)((c) (obj)).a).getUpperBounds());
        }
        com.google.a.c.e e = ad.g();
        java.lang.reflect.Type atype[] = com.google.a.f.c.c(((c) (obj)).a).getGenericInterfaces();
        int j = atype.length;
        for (int i = 0; i < j; i++)
        {
            e.(((c) (obj)).a(atype[i]));
        }

        return e.();
    }

    final Object c(Object obj)
    {
        obj = (c)obj;
        if (((c) (obj)).a instanceof TypeVariable)
        {
            return com.google.a.f.c.b(((TypeVariable)((c) (obj)).a).getBounds()[0]);
        }
        if (((c) (obj)).a instanceof WildcardType)
        {
            return com.google.a.f.c.b(((WildcardType)((c) (obj)).a).getUpperBounds()[0]);
        }
        java.lang.reflect.Type type = com.google.a.f.c.c(((c) (obj)).a).getGenericSuperclass();
        if (type == null)
        {
            return null;
        } else
        {
            return ((c) (obj)).a(type);
        }
    }

    dcardType()
    {
        super((byte)0);
    }
}
