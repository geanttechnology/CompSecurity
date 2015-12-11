// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.Iterator;

public final class ehc
{

    static final efy a = efy.a(", ").b("null");

    static String a(Collection collection)
    {
        StringBuilder stringbuilder = a(collection.size()).append('[');
        a.a(stringbuilder, a.a(collection, new ehd(collection)).iterator());
        return stringbuilder.append(']').toString();
    }

    static StringBuilder a(int i)
    {
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.a(flag, "size must be non-negative");
        return new StringBuilder((int)Math.min((long)i << 3, 0x40000000L));
    }

    public static Collection a(Iterable iterable)
    {
        return (Collection)iterable;
    }

    static boolean a(Collection collection, Object obj)
    {
        f.b(collection);
        boolean flag;
        try
        {
            flag = collection.contains(obj);
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
        return flag;
    }

    static boolean a(Collection collection, Collection collection1)
    {
        f.b(collection);
        for (collection1 = collection1.iterator(); collection1.hasNext();)
        {
            if (!collection.contains(collection1.next()))
            {
                return false;
            }
        }

        return true;
    }

}
