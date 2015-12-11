// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

final class ekv extends eje
{

    private final transient eic c;

    ekv(eic eic1, Comparator comparator)
    {
        super(comparator);
        c = eic1;
        boolean flag;
        if (!eic1.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.a(flag);
    }

    final int a(Object obj)
    {
        if (obj != null)
        {
            int i;
            try
            {
                i = a.a(c, obj, a, elf.a, elb.b);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return -1;
            }
            if (i >= 0)
            {
                return i;
            }
        }
        return -1;
    }

    final eje a(int i, int j)
    {
        if (i == 0 && j == size())
        {
            return this;
        }
        if (i < j)
        {
            return new ekv(c.a(i, j), a);
        } else
        {
            return a(a);
        }
    }

    final eje a(Object obj, boolean flag)
    {
        return a(0, c(obj, flag));
    }

    final eje a(Object obj, boolean flag, Object obj1, boolean flag1)
    {
        return b(obj, flag).a(obj1, flag1);
    }

    final boolean a()
    {
        return c.a();
    }

    final eje b(Object obj, boolean flag)
    {
        return a(d(obj, flag), size());
    }

    public final elm b()
    {
        return c.b();
    }

    final int c(Object obj, boolean flag)
    {
        eic eic1 = c;
        Object obj1 = f.b(obj);
        Comparator comparator = comparator();
        if (flag)
        {
            obj = elf.d;
        } else
        {
            obj = elf.c;
        }
        return a.a(eic1, obj1, comparator, ((elf) (obj)), elb.a);
    }

    public final boolean contains(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj != null)
        {
            int i;
            try
            {
                i = Collections.binarySearch(c, obj, a);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return false;
            }
            flag = flag1;
            if (i >= 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    public final boolean containsAll(Collection collection)
    {
        boolean flag1 = true;
        if (a.a(comparator(), collection) && collection.size() > 1) goto _L2; else goto _L1
_L1:
        boolean flag = super.containsAll(collection);
_L6:
        return flag;
_L2:
        elm elm;
        Iterator iterator1;
        elm = c.b();
        iterator1 = collection.iterator();
        collection = ((Collection) (iterator1.next()));
_L3:
        int i;
        try
        {
            if (!elm.hasNext())
            {
                break MISSING_BLOCK_LABEL_119;
            }
            i = a(elm.next(), collection);
        }
        // Misplaced declaration of an exception variable
        catch (Collection collection)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Collection collection)
        {
            return false;
        }
        if (i != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!iterator1.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        collection = ((Collection) (iterator1.next()));
          goto _L3
        continue; /* Loop/switch isn't completed */
        if (i <= 0) goto _L3; else goto _L4
_L4:
        return false;
        return false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    final int d(Object obj, boolean flag)
    {
        eic eic1 = c;
        Object obj1 = f.b(obj);
        Comparator comparator = comparator();
        if (flag)
        {
            obj = elf.c;
        } else
        {
            obj = elf.d;
        }
        return a.a(eic1, obj1, comparator, ((elf) (obj)), elb.a);
    }

    public final elm e()
    {
        return c.m_().b();
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof Set))
        {
            return false;
        }
        obj = (Set)obj;
        if (size() != ((Set) (obj)).size())
        {
            return false;
        }
        if (!a.a(a, ((Iterable) (obj))))
        {
            break MISSING_BLOCK_LABEL_113;
        }
        obj = ((Set) (obj)).iterator();
        elm elm = c.b();
_L5:
        if (!elm.hasNext()) goto _L1; else goto _L3
_L3:
        Object obj1;
        Object obj2;
        obj1 = elm.next();
        obj2 = ((Iterator) (obj)).next();
        if (obj2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        int i;
        try
        {
            i = a(obj1, obj2);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        if (i == 0) goto _L5; else goto _L4
_L4:
        return false;
        return containsAll(((Collection) (obj)));
    }

    final eic f()
    {
        return new eiy(this, c);
    }

    public final Object first()
    {
        return c.get(0);
    }

    public final boolean isEmpty()
    {
        return false;
    }

    public final Iterator iterator()
    {
        return c.b();
    }

    public final Object last()
    {
        return c.get(size() - 1);
    }

    public final int size()
    {
        return c.size();
    }

    public final Object[] toArray()
    {
        return c.toArray();
    }

    public final Object[] toArray(Object aobj[])
    {
        return c.toArray(aobj);
    }
}
