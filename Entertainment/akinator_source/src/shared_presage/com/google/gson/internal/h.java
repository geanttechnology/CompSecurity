// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;
import shared_presage.com.google.gson.JsonIOException;

// Referenced classes of package shared_presage.com.google.gson.internal:
//            ObjectConstructor, ConstructorConstructor

final class h
    implements ObjectConstructor
{

    final Type a;
    final ConstructorConstructor b;

    h(ConstructorConstructor constructorconstructor, Type type)
    {
        b = constructorconstructor;
        a = type;
        super();
    }

    public final Object construct()
    {
        if (a instanceof ParameterizedType)
        {
            Type type = ((ParameterizedType)a).getActualTypeArguments()[0];
            if (type instanceof Class)
            {
                return EnumSet.noneOf((Class)type);
            } else
            {
                throw new JsonIOException((new StringBuilder("Invalid EnumSet type: ")).append(a.toString()).toString());
            }
        } else
        {
            throw new JsonIOException((new StringBuilder("Invalid EnumSet type: ")).append(a.toString()).toString());
        }
    }
}
