// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;

public final class ejj
{

    static final eln a = new ejk();

    public static elm a()
    {
        return a;
    }

    public static elm a(Object obj)
    {
        return new ejn(obj);
    }

    public static elm a(Iterator iterator)
    {
        f.b(iterator);
        if (iterator instanceof elm)
        {
            return (elm)iterator;
        } else
        {
            return new ejp(iterator);
        }
    }

    public static transient elm a(Object aobj[])
    {
        f.b(((Object) (aobj)));
        return new ejl(aobj.length, aobj);
    }

    static eln a(Object aobj[], int i, int j, int k)
    {
        boolean flag;
        if (j >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.a(flag);
        f.a(i, i + j, aobj.length);
        return new ejm(j, k, aobj, i);
    }

    public static Iterator a(Iterator iterator, efx efx)
    {
        f.b(efx);
        return new ejq(iterator, efx);
    }

    static void a(boolean flag)
    {
        f.b(flag, "no calls to next() since the last call to remove()");
    }

    public static boolean a(Iterator iterator, Object obj)
    {
label0:
        {
            if (obj == null)
            {
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                } while (iterator.next() != null);
                return true;
            }
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!obj.equals(iterator.next()));
            return true;
        }
        return false;
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
        } while (f.a(iterator.next(), iterator1.next()));
        return false;
    }

    public static Object[] a(Iterator iterator, Class class1)
    {
        return a.a(a.a(iterator), class1);
    }

    public static String b(Iterator iterator)
    {
        return efy.a(", ").b("null").a(new StringBuilder("["), iterator).append(']').toString();
    }

    public static Object c(Iterator iterator)
    {
        Object obj = iterator.next();
        if (!iterator.hasNext())
        {
            return obj;
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append((new StringBuilder("expected one element but was: <")).append(obj).toString());
        for (int i = 0; i < 4 && iterator.hasNext(); i++)
        {
            stringbuilder.append((new StringBuilder(", ")).append(iterator.next()).toString());
        }

        if (iterator.hasNext())
        {
            stringbuilder.append(", ...");
        }
        stringbuilder.append('>');
        throw new IllegalArgumentException(stringbuilder.toString());
    }

    static void d(Iterator iterator)
    {
        f.b(iterator);
        for (; iterator.hasNext(); iterator.remove())
        {
            iterator.next();
        }

    }

    static 
    {
        new ejo();
    }
}
