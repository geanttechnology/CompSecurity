// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal;

import com.millennialmedia.google.gson.JsonIOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

// Referenced classes of package com.millennialmedia.google.gson.internal:
//            j, a

final class a
    implements j
{

    private Type a;

    public final Object a()
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

    on(Type type)
    {
        a = type;
        super();
    }
}
