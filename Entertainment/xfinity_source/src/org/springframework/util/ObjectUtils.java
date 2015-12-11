// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.util;

import java.util.Arrays;

public abstract class ObjectUtils
{

    public static boolean nullSafeEquals(Object obj, Object obj1)
    {
        if (obj != obj1)
        {
            if (obj == null || obj1 == null)
            {
                return false;
            }
            if (!obj.equals(obj1))
            {
                if (obj.getClass().isArray() && obj1.getClass().isArray())
                {
                    if ((obj instanceof Object[]) && (obj1 instanceof Object[]))
                    {
                        return Arrays.equals((Object[])(Object[])obj, (Object[])(Object[])obj1);
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
                    }
                }
                return false;
            }
        }
        return true;
    }
}
