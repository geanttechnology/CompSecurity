// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


class Numbers
{

    Numbers()
    {
    }

    static Number add(Number number, Number number1)
    {
        if ((number instanceof Double) || (number1 instanceof Double))
        {
            return Double.valueOf(number.doubleValue() + number1.doubleValue());
        }
        if ((number instanceof Float) || (number1 instanceof Float))
        {
            return Float.valueOf(number.floatValue() + number1.floatValue());
        }
        if ((number instanceof Long) || (number1 instanceof Long))
        {
            return Long.valueOf(number.longValue() + number1.longValue());
        }
        if ((number instanceof Integer) || (number1 instanceof Integer))
        {
            return Integer.valueOf(number.intValue() + number1.intValue());
        }
        if ((number instanceof Short) || (number1 instanceof Short))
        {
            return Integer.valueOf(number.shortValue() + number1.shortValue());
        }
        if ((number instanceof Byte) || (number1 instanceof Byte))
        {
            return Integer.valueOf(number.byteValue() + number1.byteValue());
        } else
        {
            throw new RuntimeException("Unknown number type.");
        }
    }

    static int compare(Number number, Number number1)
    {
        if ((number instanceof Double) || (number1 instanceof Double))
        {
            return (int)Math.signum(number.doubleValue() - number1.doubleValue());
        }
        if ((number instanceof Float) || (number1 instanceof Float))
        {
            return (int)Math.signum(number.floatValue() - number1.floatValue());
        }
        if ((number instanceof Long) || (number1 instanceof Long))
        {
            long l = number.longValue() - number1.longValue();
            if (l < 0L)
            {
                return -1;
            }
            return l <= 0L ? 0 : 1;
        }
        if ((number instanceof Integer) || (number1 instanceof Integer))
        {
            return number.intValue() - number1.intValue();
        }
        if ((number instanceof Short) || (number1 instanceof Short))
        {
            return number.shortValue() - number1.shortValue();
        }
        if ((number instanceof Byte) || (number1 instanceof Byte))
        {
            return number.byteValue() - number1.byteValue();
        } else
        {
            throw new RuntimeException("Unknown number type.");
        }
    }

    static Number subtract(Number number, Number number1)
    {
        if ((number instanceof Double) || (number1 instanceof Double))
        {
            return Double.valueOf(number.doubleValue() - number1.doubleValue());
        }
        if ((number instanceof Float) || (number1 instanceof Float))
        {
            return Float.valueOf(number.floatValue() - number1.floatValue());
        }
        if ((number instanceof Long) || (number1 instanceof Long))
        {
            return Long.valueOf(number.longValue() - number1.longValue());
        }
        if ((number instanceof Integer) || (number1 instanceof Integer))
        {
            return Integer.valueOf(number.intValue() - number1.intValue());
        }
        if ((number instanceof Short) || (number1 instanceof Short))
        {
            return Integer.valueOf(number.shortValue() - number1.shortValue());
        }
        if ((number instanceof Byte) || (number1 instanceof Byte))
        {
            return Integer.valueOf(number.byteValue() - number1.byteValue());
        } else
        {
            throw new RuntimeException("Unknown number type.");
        }
    }
}
