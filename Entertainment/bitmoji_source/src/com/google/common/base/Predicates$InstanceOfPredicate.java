// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.io.Serializable;

// Referenced classes of package com.google.common.base:
//            Predicate, Predicates, Preconditions

private static class <init>
    implements Predicate, Serializable
{

    private static final long serialVersionUID = 0L;
    private final Class clazz;

    public boolean apply(Object obj)
    {
        return clazz.isInstance(obj);
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof clazz)
        {
            obj = (clazz)obj;
            flag = flag1;
            if (clazz == ((clazz) (obj)).clazz)
            {
                flag = true;
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return clazz.hashCode();
    }

    public String toString()
    {
        String s = String.valueOf(clazz.getName());
        return (new StringBuilder(String.valueOf(s).length() + 23)).append("Predicates.instanceOf(").append(s).append(")").toString();
    }

    private (Class class1)
    {
        clazz = (Class)Preconditions.checkNotNull(class1);
    }

    clazz(Class class1, clazz clazz1)
    {
        this(class1);
    }
}
