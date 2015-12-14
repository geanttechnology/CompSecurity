// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.aspectj.runtime.internal;


public final class Conversions
{

    public static Object booleanObject(boolean flag)
    {
        return new Boolean(flag);
    }

    public static boolean booleanValue(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (obj instanceof Boolean)
        {
            return ((Boolean)obj).booleanValue();
        } else
        {
            throw new ClassCastException(obj.getClass().getName() + " can not be converted to boolean");
        }
    }

    public static Object intObject(int i)
    {
        return new Integer(i);
    }

    public static int intValue(Object obj)
    {
        if (obj == null)
        {
            return 0;
        }
        if (obj instanceof Number)
        {
            return ((Number)obj).intValue();
        } else
        {
            throw new ClassCastException(obj.getClass().getName() + " can not be converted to int");
        }
    }

    public static Object longObject(long l)
    {
        return new Long(l);
    }

    public static long longValue(Object obj)
    {
        if (obj == null)
        {
            return 0L;
        }
        if (obj instanceof Number)
        {
            return ((Number)obj).longValue();
        } else
        {
            throw new ClassCastException(obj.getClass().getName() + " can not be converted to long");
        }
    }
}
