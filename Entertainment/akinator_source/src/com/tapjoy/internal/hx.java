// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.PrintStream;
import java.util.Map;

public final class hx
{

    public static void a(StringBuffer stringbuffer, Object obj, Map map)
    {
        if (obj == null)
        {
            stringbuffer.append("null");
            return;
        }
        if (!obj.getClass().isArray())
        {
            try
            {
                stringbuffer.append(obj.toString());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                System.err.println((new StringBuilder("SLF4J: Failed toString() invocation on an object of type [")).append(obj.getClass().getName()).append("]").toString());
            }
            map.printStackTrace();
            stringbuffer.append("[FAILED toString()]");
            return;
        }
        if (obj instanceof boolean[])
        {
            a(stringbuffer, (boolean[])(boolean[])obj);
            return;
        }
        if (obj instanceof byte[])
        {
            a(stringbuffer, (byte[])(byte[])obj);
            return;
        }
        if (obj instanceof char[])
        {
            a(stringbuffer, (char[])(char[])obj);
            return;
        }
        if (obj instanceof short[])
        {
            a(stringbuffer, (short[])(short[])obj);
            return;
        }
        if (obj instanceof int[])
        {
            a(stringbuffer, (int[])(int[])obj);
            return;
        }
        if (obj instanceof long[])
        {
            a(stringbuffer, (long[])(long[])obj);
            return;
        }
        if (obj instanceof float[])
        {
            a(stringbuffer, (float[])(float[])obj);
            return;
        }
        if (obj instanceof double[])
        {
            a(stringbuffer, (double[])(double[])obj);
            return;
        } else
        {
            a(stringbuffer, (Object[])(Object[])obj, map);
            return;
        }
    }

    private static void a(StringBuffer stringbuffer, byte abyte0[])
    {
        stringbuffer.append('[');
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(abyte0[i]);
            if (i != j - 1)
            {
                stringbuffer.append(", ");
            }
        }

        stringbuffer.append(']');
    }

    private static void a(StringBuffer stringbuffer, char ac[])
    {
        stringbuffer.append('[');
        int j = ac.length;
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(ac[i]);
            if (i != j - 1)
            {
                stringbuffer.append(", ");
            }
        }

        stringbuffer.append(']');
    }

    private static void a(StringBuffer stringbuffer, double ad[])
    {
        stringbuffer.append('[');
        int j = ad.length;
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(ad[i]);
            if (i != j - 1)
            {
                stringbuffer.append(", ");
            }
        }

        stringbuffer.append(']');
    }

    private static void a(StringBuffer stringbuffer, float af[])
    {
        stringbuffer.append('[');
        int j = af.length;
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(af[i]);
            if (i != j - 1)
            {
                stringbuffer.append(", ");
            }
        }

        stringbuffer.append(']');
    }

    private static void a(StringBuffer stringbuffer, int ai[])
    {
        stringbuffer.append('[');
        int j = ai.length;
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(ai[i]);
            if (i != j - 1)
            {
                stringbuffer.append(", ");
            }
        }

        stringbuffer.append(']');
    }

    private static void a(StringBuffer stringbuffer, long al[])
    {
        stringbuffer.append('[');
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(al[i]);
            if (i != j - 1)
            {
                stringbuffer.append(", ");
            }
        }

        stringbuffer.append(']');
    }

    private static void a(StringBuffer stringbuffer, Object aobj[], Map map)
    {
        stringbuffer.append('[');
        if (!map.containsKey(((Object) (aobj))))
        {
            map.put(((Object) (aobj)), null);
            int j = aobj.length;
            for (int i = 0; i < j; i++)
            {
                a(stringbuffer, aobj[i], map);
                if (i != j - 1)
                {
                    stringbuffer.append(", ");
                }
            }

            map.remove(((Object) (aobj)));
        } else
        {
            stringbuffer.append("...");
        }
        stringbuffer.append(']');
    }

    private static void a(StringBuffer stringbuffer, short aword0[])
    {
        stringbuffer.append('[');
        int j = aword0.length;
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(aword0[i]);
            if (i != j - 1)
            {
                stringbuffer.append(", ");
            }
        }

        stringbuffer.append(']');
    }

    private static void a(StringBuffer stringbuffer, boolean aflag[])
    {
        stringbuffer.append('[');
        int j = aflag.length;
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(aflag[i]);
            if (i != j - 1)
            {
                stringbuffer.append(", ");
            }
        }

        stringbuffer.append(']');
    }
}
