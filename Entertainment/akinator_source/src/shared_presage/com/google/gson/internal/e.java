// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal;

import java.lang.reflect.Type;
import shared_presage.com.google.gson.InstanceCreator;

// Referenced classes of package shared_presage.com.google.gson.internal:
//            ObjectConstructor, ConstructorConstructor

final class e
    implements ObjectConstructor
{

    final InstanceCreator a;
    final Type b;
    final ConstructorConstructor c;

    e(ConstructorConstructor constructorconstructor, InstanceCreator instancecreator, Type type)
    {
        c = constructorconstructor;
        a = instancecreator;
        b = type;
        super();
    }

    public final Object construct()
    {
        return a.createInstance(b);
    }
}
