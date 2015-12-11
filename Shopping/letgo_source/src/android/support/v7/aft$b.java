// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

// Referenced classes of package android.support.v7:
//            aft, afs

private static final class c
    implements Serializable, ParameterizedType
{

    private final Type a;
    private final Type b;
    private final Type c[];

    public boolean equals(Object obj)
    {
        return (obj instanceof ParameterizedType) && aft.a(this, (ParameterizedType)obj);
    }

    public Type[] getActualTypeArguments()
    {
        return (Type[])c.clone();
    }

    public Type getOwnerType()
    {
        return a;
    }

    public Type getRawType()
    {
        return b;
    }

    public int hashCode()
    {
        return Arrays.hashCode(c) ^ b.hashCode() ^ aft.a(a);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder((c.length + 1) * 30);
        stringbuilder.append(aft.f(b));
        if (c.length == 0)
        {
            return stringbuilder.toString();
        }
        stringbuilder.append("<").append(aft.f(c[0]));
        for (int i = 1; i < c.length; i++)
        {
            stringbuilder.append(", ").append(aft.f(c[i]));
        }

        return stringbuilder.append(">").toString();
    }

    public transient r(Type type, Type type1, Type atype[])
    {
        boolean flag = false;
        super();
        if (type1 instanceof Class)
        {
            Class class1 = (Class)type1;
            int i;
            boolean flag1;
            if (Modifier.isStatic(class1.getModifiers()) || class1.getEnclosingClass() == null)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (type != null || i != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            afs.a(flag1);
        }
        if (type == null)
        {
            type = null;
        } else
        {
            type = aft.d(type);
        }
        a = type;
        b = aft.d(type1);
        c = (Type[])atype.clone();
        for (i = ((flag) ? 1 : 0); i < c.length; i++)
        {
            afs.a(c[i]);
            aft.h(c[i]);
            c[i] = aft.d(c[i]);
        }

    }
}
