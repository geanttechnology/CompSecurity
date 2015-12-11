// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ejr
{

    private static egc a;

    static elm a(elm elm)
    {
        return new eju(elm);
    }

    static Object a(Map map, Object obj)
    {
        f.b(map);
        try
        {
            map = ((Map) (map.get(obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return null;
        }
        return map;
    }

    static String a(Map map)
    {
        StringBuilder stringbuilder = ehc.a(map.size()).append('{');
        a.a(stringbuilder, map.entrySet().iterator());
        return stringbuilder.append('}').toString();
    }

    public static HashMap a()
    {
        return new HashMap();
    }

    public static HashMap a(int i)
    {
        return new HashMap(b(i));
    }

    static Iterator a(Iterator iterator)
    {
        return new ejs(iterator);
    }

    public static java.util.Map.Entry a(Object obj, Object obj1)
    {
        return new ehw(obj, obj1);
    }

    public static int b(int i)
    {
        if (i < 3)
        {
            boolean flag;
            if (i >= 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            f.a(flag);
            return i + 1;
        }
        if (i < 0x40000000)
        {
            return i / 3 + i;
        } else
        {
            return 0x7fffffff;
        }
    }

    public static IdentityHashMap b()
    {
        return new IdentityHashMap();
    }

    static boolean b(Map map, Object obj)
    {
        f.b(map);
        boolean flag;
        try
        {
            flag = map.containsKey(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return false;
        }
        return flag;
    }

    static Object c(Map map, Object obj)
    {
        f.b(map);
        try
        {
            map = ((Map) (map.remove(obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return null;
        }
        return map;
    }

    static boolean d(Map map, Object obj)
    {
        if (map == obj)
        {
            return true;
        }
        if (obj instanceof Map)
        {
            obj = (Map)obj;
            return map.entrySet().equals(((Map) (obj)).entrySet());
        } else
        {
            return false;
        }
    }

    static boolean e(Map map, Object obj)
    {
        return ejj.a(new ejt(map.entrySet().iterator()), obj);
    }

    static 
    {
        a = ehc.a.c("=");
    }
}
