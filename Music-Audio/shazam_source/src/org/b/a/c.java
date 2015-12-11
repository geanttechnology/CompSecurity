// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.b.a;

import java.io.PrintStream;
import java.util.Map;

public final class c
{

    public static void a(StringBuilder stringbuilder, Object obj, Map map)
    {
        if (obj == null)
        {
            stringbuilder.append("null");
            return;
        }
        if (!obj.getClass().isArray())
        {
            try
            {
                stringbuilder.append(obj.toString());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                System.err.println((new StringBuilder("SLF4J: Failed toString() invocation on an object of type [")).append(obj.getClass().getName()).append("]").toString());
            }
            map.printStackTrace();
            stringbuilder.append("[FAILED toString()]");
            return;
        }
        if (obj instanceof boolean[])
        {
            a(stringbuilder, (boolean[])(boolean[])obj);
            return;
        }
        if (obj instanceof byte[])
        {
            a(stringbuilder, (byte[])(byte[])obj);
            return;
        }
        if (obj instanceof char[])
        {
            a(stringbuilder, (char[])(char[])obj);
            return;
        }
        if (obj instanceof short[])
        {
            a(stringbuilder, (short[])(short[])obj);
            return;
        }
        if (obj instanceof int[])
        {
            a(stringbuilder, (int[])(int[])obj);
            return;
        }
        if (obj instanceof long[])
        {
            a(stringbuilder, (long[])(long[])obj);
            return;
        }
        if (obj instanceof float[])
        {
            a(stringbuilder, (float[])(float[])obj);
            return;
        }
        if (obj instanceof double[])
        {
            a(stringbuilder, (double[])(double[])obj);
            return;
        } else
        {
            a(stringbuilder, (Object[])(Object[])obj, map);
            return;
        }
    }

    private static void a(StringBuilder stringbuilder, byte abyte0[])
    {
        stringbuilder.append('[');
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(abyte0[i]);
            if (i != j - 1)
            {
                stringbuilder.append(", ");
            }
        }

        stringbuilder.append(']');
    }

    private static void a(StringBuilder stringbuilder, char ac[])
    {
        stringbuilder.append('[');
        int j = ac.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(ac[i]);
            if (i != j - 1)
            {
                stringbuilder.append(", ");
            }
        }

        stringbuilder.append(']');
    }

    private static void a(StringBuilder stringbuilder, double ad[])
    {
        stringbuilder.append('[');
        int j = ad.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(ad[i]);
            if (i != j - 1)
            {
                stringbuilder.append(", ");
            }
        }

        stringbuilder.append(']');
    }

    private static void a(StringBuilder stringbuilder, float af[])
    {
        stringbuilder.append('[');
        int j = af.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(af[i]);
            if (i != j - 1)
            {
                stringbuilder.append(", ");
            }
        }

        stringbuilder.append(']');
    }

    private static void a(StringBuilder stringbuilder, int ai[])
    {
        stringbuilder.append('[');
        int j = ai.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(ai[i]);
            if (i != j - 1)
            {
                stringbuilder.append(", ");
            }
        }

        stringbuilder.append(']');
    }

    private static void a(StringBuilder stringbuilder, long al[])
    {
        stringbuilder.append('[');
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(al[i]);
            if (i != j - 1)
            {
                stringbuilder.append(", ");
            }
        }

        stringbuilder.append(']');
    }

    private static void a(StringBuilder stringbuilder, Object aobj[], Map map)
    {
        stringbuilder.append('[');
        if (!map.containsKey(((Object) (aobj))))
        {
            map.put(((Object) (aobj)), null);
            int j = aobj.length;
            for (int i = 0; i < j; i++)
            {
                a(stringbuilder, aobj[i], map);
                if (i != j - 1)
                {
                    stringbuilder.append(", ");
                }
            }

            map.remove(((Object) (aobj)));
        } else
        {
            stringbuilder.append("...");
        }
        stringbuilder.append(']');
    }

    private static void a(StringBuilder stringbuilder, short aword0[])
    {
        stringbuilder.append('[');
        int j = aword0.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(aword0[i]);
            if (i != j - 1)
            {
                stringbuilder.append(", ");
            }
        }

        stringbuilder.append(']');
    }

    private static void a(StringBuilder stringbuilder, boolean aflag[])
    {
        stringbuilder.append('[');
        int j = aflag.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(aflag[i]);
            if (i != j - 1)
            {
                stringbuilder.append(", ");
            }
        }

        stringbuilder.append(']');
    }
}
