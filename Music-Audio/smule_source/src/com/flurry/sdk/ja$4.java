// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.lang.reflect.Type;

// Referenced classes of package com.flurry.sdk:
//            jf, ja, ji

class it>
    implements jf
{

    final Class a;
    final Type b;
    final ja c;
    private final ji d = ji.a();

    public Object a()
    {
        Object obj;
        try
        {
            obj = d.a(a);
        }
        catch (Exception exception)
        {
            throw new RuntimeException((new StringBuilder()).append("Unable to invoke no-args constructor for ").append(b).append(". ").append("Register an InstanceCreator with Gson for this type may fix this problem.").toString(), exception);
        }
        return obj;
    }

    pe(ja ja1, Class class1, Type type)
    {
        c = ja1;
        a = class1;
        b = type;
        super();
    }
}
