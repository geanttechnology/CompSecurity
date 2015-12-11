// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.internal.utils;

import java.util.Arrays;
import java.util.Comparator;

public final class Objects
{

    private Objects()
    {
    }

    public static int compare(Object obj, Object obj1, Comparator comparator)
    {
        if (obj == obj1)
        {
            return 0;
        } else
        {
            return comparator.compare(obj, obj1);
        }
    }

    public static boolean deepEquals(Object obj, Object obj1)
    {
        if (obj == null || obj1 == null)
        {
            return obj == obj1;
        }
        if ((obj instanceof Object[]) && (obj1 instanceof Object[]))
        {
            return Arrays.deepEquals((Object[])(Object[])obj, (Object[])(Object[])obj1);
        }
        if ((obj instanceof boolean[]) && (obj1 instanceof boolean[]))
        {
            return Arrays.equals((boolean[])(boolean[])obj, (boolean[])(boolean[])obj1);
        }
        if ((obj instanceof byte[]) && (obj1 instanceof byte[]))
        {
            return Arrays.equals((byte[])(byte[])obj, (byte[])(byte[])obj1);
        }
        if ((obj instanceof char[]) && (obj1 instanceof char[]))
        {
            return Arrays.equals((char[])(char[])obj, (char[])(char[])obj1);
        }
        if ((obj instanceof double[]) && (obj1 instanceof double[]))
        {
            return Arrays.equals((double[])(double[])obj, (double[])(double[])obj1);
        }
        if ((obj instanceof float[]) && (obj1 instanceof float[]))
        {
            return Arrays.equals((float[])(float[])obj, (float[])(float[])obj1);
        }
        if ((obj instanceof int[]) && (obj1 instanceof int[]))
        {
            return Arrays.equals((int[])(int[])obj, (int[])(int[])obj1);
        }
        if ((obj instanceof long[]) && (obj1 instanceof long[]))
        {
            return Arrays.equals((long[])(long[])obj, (long[])(long[])obj1);
        }
        if ((obj instanceof short[]) && (obj1 instanceof short[]))
        {
            return Arrays.equals((short[])(short[])obj, (short[])(short[])obj1);
        } else
        {
            return obj.equals(obj1);
        }
    }

    public static boolean equals(Object obj, Object obj1)
    {
        if (obj == null)
        {
            return obj1 == null;
        } else
        {
            return obj.equals(obj1);
        }
    }

    public static transient int hash(Object aobj[])
    {
        return Arrays.hashCode(aobj);
    }

    public static int hashCode(Object obj)
    {
        if (obj == null)
        {
            return 0;
        } else
        {
            return obj.hashCode();
        }
    }

    public static Object requireNonNull(Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException();
        } else
        {
            return obj;
        }
    }

    public static Object requireNonNull(Object obj, String s)
    {
        if (obj == null)
        {
            throw new NullPointerException(s);
        } else
        {
            return obj;
        }
    }

    public static String toString(Object obj)
    {
        if (obj == null)
        {
            return "null";
        } else
        {
            return obj.toString();
        }
    }

    public static String toString(Object obj, String s)
    {
        if (obj == null)
        {
            return s;
        } else
        {
            return obj.toString();
        }
    }
}
