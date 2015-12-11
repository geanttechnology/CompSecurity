// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

private static final class c
    implements Serializable, ParameterizedType
{

    private static final long serialVersionUID = 0L;
    private final Type a;
    private final Type b;
    private final Type c[];

    public final boolean equals(Object obj)
    {
        return (obj instanceof ParameterizedType) && uals(this, (ParameterizedType)obj);
    }

    public final Type[] getActualTypeArguments()
    {
        return (Type[])c.clone();
    }

    public final Type getOwnerType()
    {
        return a;
    }

    public final Type getRawType()
    {
        return b;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(c) ^ b.hashCode() ^ cess._mth100(a);
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder((c.length + 1) * 30);
        stringbuilder.append(peToString(b));
        if (c.length == 0)
        {
            return stringbuilder.toString();
        }
        stringbuilder.append("<").append(peToString(c[0]));
        for (int i = 1; i < c.length; i++)
        {
            stringbuilder.append(", ").append(peToString(c[i]));
        }

        return stringbuilder.append(">").toString();
    }

    public transient tions(Type type, Type type1, Type atype[])
    {
        boolean flag1 = true;
        int i = 0;
        super();
        if (type1 instanceof Class)
        {
            Class class1 = (Class)type1;
            boolean flag;
            if (type != null || class1.getEnclosingClass() == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            tions.checkArgument(flag);
            flag = flag1;
            if (type != null)
            {
                if (class1.getEnclosingClass() != null)
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
            }
            tions.checkArgument(flag);
        }
        if (type == null)
        {
            type = null;
        } else
        {
            type = nonicalize(type);
        }
        a = type;
        b = nonicalize(type1);
        for (c = (Type[])atype.clone(); i < c.length; i++)
        {
            tions.checkNotNull(c[i]);
            cess._mth000(c[i]);
            c[i] = nonicalize(c[i]);
        }

    }
}
