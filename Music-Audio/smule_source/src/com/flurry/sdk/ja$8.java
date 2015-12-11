// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

// Referenced classes of package com.flurry.sdk:
//            jf, ja, ih

class it>
    implements jf
{

    final Type a;
    final ja b;

    public Object a()
    {
        if (a instanceof ParameterizedType)
        {
            Type type = ((ParameterizedType)a).getActualTypeArguments()[0];
            if (type instanceof Class)
            {
                return EnumSet.noneOf((Class)type);
            } else
            {
                throw new ih((new StringBuilder()).append("Invalid EnumSet type: ").append(a.toString()).toString());
            }
        } else
        {
            throw new ih((new StringBuilder()).append("Invalid EnumSet type: ").append(a.toString()).toString());
        }
    }

    pe(ja ja1, Type type)
    {
        b = ja1;
        a = type;
        super();
    }
}
