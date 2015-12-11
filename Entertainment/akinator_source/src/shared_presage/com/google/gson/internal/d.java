// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal;

import java.lang.reflect.Type;

// Referenced classes of package shared_presage.com.google.gson.internal:
//            ObjectConstructor, UnsafeAllocator, ConstructorConstructor

final class d
    implements ObjectConstructor
{

    final Class a;
    final Type b;
    final ConstructorConstructor c;
    private final UnsafeAllocator d = UnsafeAllocator.create();

    d(ConstructorConstructor constructorconstructor, Class class1, Type type)
    {
        c = constructorconstructor;
        a = class1;
        b = type;
        super();
    }

    public final Object construct()
    {
        Object obj;
        try
        {
            obj = d.newInstance(a);
        }
        catch (Exception exception)
        {
            throw new RuntimeException((new StringBuilder("Unable to invoke no-args constructor for ")).append(b).append(". Register an InstanceCreator with Gson for this type may fix this problem.").toString(), exception);
        }
        return obj;
    }
}
