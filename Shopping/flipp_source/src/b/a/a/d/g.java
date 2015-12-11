// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import b.a.a.a;
import b.a.a.aa;
import b.a.a.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// Referenced classes of package b.a.a.d:
//            t, x, u

final class g
    implements t, x
{

    final x a[];
    final t b[];
    private final int c;
    private final int d;

    g(List list)
    {
        boolean flag = false;
        super();
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist = new ArrayList();
        a(list, arraylist1, arraylist);
        if (arraylist1.contains(null) || arraylist1.isEmpty())
        {
            a = null;
            c = 0;
        } else
        {
            int i1 = arraylist1.size();
            a = new x[i1];
            int i = 0;
            int k = 0;
            for (; i < i1; i++)
            {
                list = (x)arraylist1.get(i);
                k += list.a();
                a[i] = list;
            }

            c = k;
        }
        if (arraylist.contains(null) || arraylist.isEmpty())
        {
            b = null;
            d = 0;
            return;
        }
        int j1 = arraylist.size();
        b = new t[j1];
        int l = 0;
        for (int j = ((flag) ? 1 : 0); j < j1; j++)
        {
            list = (t)arraylist.get(j);
            l += list.b();
            b[j] = list;
        }

        d = l;
    }

    private static void a(List list, List list1, List list2)
    {
        int j = list.size();
        int i = 0;
        while (i < j) 
        {
            Object obj = list.get(i);
            if (obj instanceof g)
            {
                a(list1, ((Object []) (((g)obj).a)));
            } else
            {
                list1.add(obj);
            }
            obj = list.get(i + 1);
            if (obj instanceof g)
            {
                a(list2, ((Object []) (((g)obj).b)));
            } else
            {
                list2.add(obj);
            }
            i += 2;
        }
    }

    private static void a(List list, Object aobj[])
    {
        if (aobj != null)
        {
            for (int i = 0; i < aobj.length; i++)
            {
                list.add(aobj[i]);
            }

        }
    }

    public final int a()
    {
        return c;
    }

    public final int a(u u, String s, int i)
    {
        t at[] = b;
        if (at == null)
        {
            throw new UnsupportedOperationException();
        }
        int k = at.length;
        boolean flag = false;
        int j = i;
        for (i = ((flag) ? 1 : 0); i < k && j >= 0; i++)
        {
            j = at[i].a(u, s, j);
        }

        return j;
    }

    public final void a(StringBuffer stringbuffer, long l, a a1, int i, i j, Locale locale)
    {
        x ax[] = a;
        if (ax == null)
        {
            throw new UnsupportedOperationException();
        }
        if (locale == null)
        {
            locale = Locale.getDefault();
        }
        int i1 = ax.length;
        for (int k = 0; k < i1; k++)
        {
            ax[k].a(stringbuffer, l, a1, i, j, locale);
        }

    }

    public final void a(StringBuffer stringbuffer, aa aa, Locale locale)
    {
        x ax[] = a;
        if (ax == null)
        {
            throw new UnsupportedOperationException();
        }
        Locale locale1 = locale;
        if (locale == null)
        {
            locale1 = Locale.getDefault();
        }
        int j = ax.length;
        for (int i = 0; i < j; i++)
        {
            ax[i].a(stringbuffer, aa, locale1);
        }

    }

    public final int b()
    {
        return d;
    }
}
