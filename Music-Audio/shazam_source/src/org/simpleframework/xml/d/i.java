// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.d;

import java.lang.reflect.Array;

// Referenced classes of package org.simpleframework.xml.d:
//            ag

final class i
    implements ag
{

    private final Class a;

    public i(Class class1)
    {
        a = class1;
    }

    private static String a(Object obj, int j)
    {
        StringBuilder stringbuilder = new StringBuilder(j);
        for (int k = 0; k < j; k++)
        {
            Object obj1 = Array.get(obj, k);
            if (obj1 != null)
            {
                stringbuilder.append(obj1);
            }
        }

        return stringbuilder.toString();
    }

    public final Object a(String s)
    {
        s = s.toCharArray();
        int k = s.length;
        if (a == Character.TYPE)
        {
            return s;
        }
        Object obj = Array.newInstance(a, k);
        for (int j = 0; j < k; j++)
        {
            Array.set(obj, j, Character.valueOf(s[j]));
        }

        return obj;
    }

    public final String a(Object obj)
    {
        int j = Array.getLength(obj);
        if (a == Character.TYPE)
        {
            return new String((char[])(char[])obj);
        } else
        {
            return a(obj, j);
        }
    }
}
