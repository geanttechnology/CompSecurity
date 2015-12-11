// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

// Referenced classes of package android.support.v7:
//            afz, afu, afb

class a
    implements afz
{

    final Type a;
    final afu b;

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
                throw new afb((new StringBuilder()).append("Invalid EnumSet type: ").append(a.toString()).toString());
            }
        } else
        {
            throw new afb((new StringBuilder()).append("Invalid EnumSet type: ").append(a.toString()).toString());
        }
    }

    erizedType(afu afu1, Type type)
    {
        b = afu1;
        a = type;
        super();
    }
}
