// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.d;

import java.lang.reflect.Array;

// Referenced classes of package org.simpleframework.xml.d:
//            ag, ad

final class b
    implements ag
{

    private final ad a = new ad();
    private final ag b;
    private final Class c;

    public b(ag ag1, Class class1)
    {
        b = ag1;
        c = class1;
    }

    public final Object a(String s)
    {
        s = a.b(s);
        int j = s.length;
        Object obj = Array.newInstance(c, j);
        for (int i = 0; i < j; i++)
        {
            Object obj1 = b.a(s[i]);
            if (obj1 != null)
            {
                Array.set(obj, i, obj1);
            }
        }

        return obj;
    }

    public final String a(Object obj)
    {
        int j = Array.getLength(obj);
        String as[] = new String[j];
        for (int i = 0; i < j; i++)
        {
            Object obj1 = Array.get(obj, i);
            if (obj1 != null)
            {
                as[i] = b.a(obj1);
            }
        }

        return a.a(as);
    }
}
