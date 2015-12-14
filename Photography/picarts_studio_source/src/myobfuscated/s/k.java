// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.s;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package myobfuscated.s:
//            l, s

final class k
{

    private final l a = new l();
    private final Map b = new HashMap();

    k()
    {
    }

    private static void a(l l1)
    {
        l1.c.d = l1;
        l1.d.c = l1;
    }

    private static void b(l l1)
    {
        l1.d.c = l1.c;
        l1.c.d = l1.d;
    }

    public final Object a()
    {
        for (l l1 = a.d; !l1.equals(a); l1 = l1.d)
        {
            Object obj = l1.a();
            if (obj != null)
            {
                return obj;
            }
            b(l1);
            b.remove(l1.a);
            ((s)l1.a).a();
        }

        return null;
    }

    public final Object a(s s1)
    {
        l l1 = (l)b.get(s1);
        if (l1 == null)
        {
            l1 = new l(s1);
            b.put(s1, l1);
            s1 = l1;
        } else
        {
            s1.a();
            s1 = l1;
        }
        b(s1);
        s1.d = a;
        s1.c = a.c;
        a(((l) (s1)));
        return s1.a();
    }

    public final void a(s s1, Object obj)
    {
        l l1 = (l)b.get(s1);
        if (l1 == null)
        {
            l1 = new l(s1);
            b(l1);
            l1.d = a.d;
            l1.c = a;
            a(l1);
            b.put(s1, l1);
            s1 = l1;
        } else
        {
            s1.a();
            s1 = l1;
        }
        if (((l) (s1)).b == null)
        {
            s1.b = new ArrayList();
        }
        ((l) (s1)).b.add(obj);
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("GroupedLinkedMap( ");
        l l1 = a.c;
        boolean flag = false;
        for (; !l1.equals(a); l1 = l1.c)
        {
            flag = true;
            stringbuilder.append('{').append(l1.a).append(':').append(l1.b()).append("}, ");
        }

        if (flag)
        {
            stringbuilder.delete(stringbuilder.length() - 2, stringbuilder.length());
        }
        return stringbuilder.append(" )").toString();
    }
}
