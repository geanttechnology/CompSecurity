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
        if (type instanceof Class)
        {
            return e.a((Class)type);
        } else
        {
            return new nit>(type);
        }
    }

    final Type b(Type type)
    {
        return (Type)g.a(type);
    }

    e(String s)
    {
        super(s, 1, (byte)0);
    }
}
