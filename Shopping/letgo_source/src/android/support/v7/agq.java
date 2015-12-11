// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

// Referenced classes of package android.support.v7:
//            aft, afs

public class agq
{

    final Class a;
    final Type b;
    final int c;

    protected agq()
    {
        b = a(getClass());
        a = aft.e(b);
        c = b.hashCode();
    }

    agq(Type type)
    {
        b = aft.d((Type)afs.a(type));
        a = aft.e(b);
        c = b.hashCode();
    }

    public static agq a(Type type)
    {
        return new agq(type);
    }

    static Type a(Class class1)
    {
        class1 = class1.getGenericSuperclass();
        if (class1 instanceof Class)
        {
            throw new RuntimeException("Missing type parameter.");
        } else
        {
            return aft.d(((ParameterizedType)class1).getActualTypeArguments()[0]);
        }
    }

    public static agq b(Class class1)
    {
        return new agq(class1);
    }

    public final Class a()
    {
        return a;
    }

    public final Type b()
    {
        return b;
    }

    public final boolean equals(Object obj)
    {
        return (obj instanceof agq) && aft.a(b, ((agq)obj).b);
    }

    public final int hashCode()
    {
        return c;
    }

    public final String toString()
    {
        return aft.f(b);
    }
}
