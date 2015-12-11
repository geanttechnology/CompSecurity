// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.f;

import com.google.a.a.g;
import java.lang.reflect.Type;

// Referenced classes of package com.google.a.f:
//            e

static final class nit> extends nit>
{

    final Type a(Type type)
    {
        return new nit>(type);
    }

    final Type b(Type type)
    {
        g.a(type);
        Object obj = type;
        if (type instanceof Class)
        {
            Class class1 = (Class)type;
            obj = type;
            if (class1.isArray())
            {
                obj = new nit>(class1.getComponentType());
            }
        }
        return ((Type) (obj));
    }

    e(String s)
    {
        super(s, 0, (byte)0);
    }
}
