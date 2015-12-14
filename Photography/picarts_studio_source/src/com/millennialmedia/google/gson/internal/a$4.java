// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal;

import java.lang.reflect.Type;

// Referenced classes of package com.millennialmedia.google.gson.internal:
//            j, a, n

final class c
    implements j
{

    private final n a = n.a();
    private Class b;
    private Type c;

    public final Object a()
    {
        Object obj;
        try
        {
            obj = a.a(b);
        }
        catch (Exception exception)
        {
            throw new RuntimeException((new StringBuilder("Unable to invoke no-args constructor for ")).append(c).append(". Register an InstanceCreator with Gson for this type may fix this problem.").toString(), exception);
        }
        return obj;
    }

    (Class class1, Type type)
    {
        b = class1;
        c = type;
        super();
    }
}
