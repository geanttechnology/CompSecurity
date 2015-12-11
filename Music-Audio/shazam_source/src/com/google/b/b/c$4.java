// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b;

import java.lang.reflect.Type;

// Referenced classes of package com.google.b.b:
//            h, c, k

final class nit>
    implements h
{

    final Class a;
    final Type b;
    final c c;
    private final k d = k.a();

    public final Object a()
    {
        Object obj;
        try
        {
            obj = d.a(a);
        }
        catch (Exception exception)
        {
            throw new RuntimeException((new StringBuilder("Unable to invoke no-args constructor for ")).append(b).append(". Register an InstanceCreator with Gson for this type may fix this problem.").toString(), exception);
        }
        return obj;
    }

    ype(c c1, Class class1, Type type)
    {
        c = c1;
        a = class1;
        b = type;
        super();
    }
}
