// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.d;
import com.google.a.a.e;
import com.google.a.a.f;
import com.google.a.a.g;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

// Referenced classes of package com.google.a.b:
//            d, s, t

public final class j
{

    static final t a = new _cls1();
    private static final Iterator b = new _cls4();

    public static int a(Iterator iterator)
    {
        int i;
        for (i = 0; iterator.hasNext(); i++)
        {
            iterator.next();
        }

        return i;
    }

    public static s a()
    {
        return b();
    }

    public static s a(Object obj)
    {
        return new _cls3(obj);
    }

    static t a(Object aobj[], int i, int k, int l)
    {
        boolean flag;
        if (k >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.a.a.f.a(flag);
        com.google.a.a.f.a(i, i + k, aobj.length);
        com.google.a.a.f.b(l, k);
        if (k == 0)
        {
            return b();
        } else
        {
            return new _cls2(k, l, aobj, i);
        }
    }

    public static Iterator a(Iterator iterator, b b1)
    {
        com.google.a.a.f.a(b1);
        return new _cls7(iterator, b1);
    }

    public static boolean a(Collection collection, Iterator iterator)
    {
        com.google.a.a.f.a(collection);
        com.google.a.a.f.a(iterator);
        boolean flag;
        for (flag = false; iterator.hasNext(); flag |= collection.add(iterator.next())) { }
        return flag;
    }

    public static boolean a(Iterator iterator, g g1)
    {
        com.google.a.a.f.a(g1);
        boolean flag = false;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (g1.a(iterator.next()))
            {
                iterator.remove();
                flag = true;
            }
        } while (true);
        return flag;
    }

    public static boolean a(Iterator iterator, Iterator iterator1)
    {
        do
        {
            if (iterator.hasNext())
            {
                if (iterator1.hasNext())
                {
                    continue;
                }
            } else
            if (!iterator1.hasNext())
            {
                return true;
            }
            return false;
        } while (com.google.a.a.d.a(iterator.next(), iterator1.next()));
        return false;
    }

    public static s b(Iterator iterator, g g1)
    {
        com.google.a.a.f.a(iterator);
        com.google.a.a.f.a(g1);
        return new _cls6(iterator, g1);
    }

    static t b()
    {
        return a;
    }

    public static String b(Iterator iterator)
    {
        return d.a.a((new StringBuilder()).append('['), iterator).append(']').toString();
    }

    public static Iterator c(Iterator iterator)
    {
        com.google.a.a.f.a(iterator);
        return new _cls5(iterator);
    }

    public static boolean c(Iterator iterator, g g1)
    {
        return f(iterator, g1) != -1;
    }

    static ListIterator d(Iterator iterator)
    {
        return (ListIterator)iterator;
    }

    public static boolean d(Iterator iterator, g g1)
    {
        com.google.a.a.f.a(g1);
        while (iterator.hasNext()) 
        {
            if (!g1.a(iterator.next()))
            {
                return false;
            }
        }
        return true;
    }

    public static e e(Iterator iterator, g g1)
    {
        iterator = b(iterator, g1);
        if (iterator.hasNext())
        {
            return com.google.a.a.e.b(iterator.next());
        } else
        {
            return com.google.a.a.e.e();
        }
    }

    public static int f(Iterator iterator, g g1)
    {
        com.google.a.a.f.a(g1, "predicate");
        for (int i = 0; iterator.hasNext(); i++)
        {
            if (g1.a(iterator.next()))
            {
                return i;
            }
        }

        return -1;
    }


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls4 {}

}
