// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3;


public class Validate
{

    public static void inclusiveBetween(long l, long l1, long l2)
    {
        if (l2 < l || l2 > l1)
        {
            throw new IllegalArgumentException(String.format("The value %s is not in the specified inclusive range of %s to %s", new Object[] {
                Long.valueOf(l2), Long.valueOf(l), Long.valueOf(l1)
            }));
        } else
        {
            return;
        }
    }

    public static transient void isTrue(boolean flag, String s, Object aobj[])
    {
        if (!flag)
        {
            throw new IllegalArgumentException(String.format(s, aobj));
        } else
        {
            return;
        }
    }

    public static Object notNull(Object obj)
    {
        return notNull(obj, "The validated object is null", new Object[0]);
    }

    public static transient Object notNull(Object obj, String s, Object aobj[])
    {
        if (obj == null)
        {
            throw new NullPointerException(String.format(s, aobj));
        } else
        {
            return obj;
        }
    }
}
