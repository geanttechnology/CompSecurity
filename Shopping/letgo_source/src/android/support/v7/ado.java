// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            adn, abo

public class ado
{

    private static final Object a = null;
    private static Long b = new Long(0L);
    private static Double c = new Double(0.0D);
    private static adn d = adn.a(0L);
    private static String e;
    private static Boolean f = new Boolean(false);
    private static List g = new ArrayList(0);
    private static Map h = new HashMap();
    private static lv.a i;

    private static adn a(String s)
    {
        adn adn1;
        try
        {
            adn1 = adn.a(s);
        }
        catch (NumberFormatException numberformatexception)
        {
            abo.a((new StringBuilder()).append("Failed to convert '").append(s).append("' to a number.").toString());
            return d;
        }
        return adn1;
    }

    public static Object a()
    {
        return a;
    }

    public static String a(lv.a a1)
    {
        return a(e(a1));
    }

    public static String a(Object obj)
    {
        if (obj == null)
        {
            return e;
        } else
        {
            return obj.toString();
        }
    }

    public static adn b(lv.a a1)
    {
        return b(e(a1));
    }

    public static adn b(Object obj)
    {
        if (obj instanceof adn)
        {
            return (adn)obj;
        }
        if (h(obj))
        {
            return adn.a(i(obj));
        }
        if (f(obj))
        {
            return adn.a(Double.valueOf(g(obj)));
        } else
        {
            return a(a(obj));
        }
    }

    public static Long b()
    {
        return b;
    }

    private static Long b(String s)
    {
        s = a(s);
        if (s == d)
        {
            return b;
        } else
        {
            return Long.valueOf(s.longValue());
        }
    }

    public static Boolean c()
    {
        return f;
    }

    private static Boolean c(String s)
    {
        if ("true".equalsIgnoreCase(s))
        {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(s))
        {
            return Boolean.FALSE;
        } else
        {
            return f;
        }
    }

    public static Long c(lv.a a1)
    {
        return c(e(a1));
    }

    public static Long c(Object obj)
    {
        if (h(obj))
        {
            return Long.valueOf(i(obj));
        } else
        {
            return b(a(obj));
        }
    }

    public static adn d()
    {
        return d;
    }

    public static Boolean d(lv.a a1)
    {
        return d(e(a1));
    }

    public static Boolean d(Object obj)
    {
        if (obj instanceof Boolean)
        {
            return (Boolean)obj;
        } else
        {
            return c(a(obj));
        }
    }

    public static lv.a e(Object obj)
    {
        lv.a a1;
        boolean flag;
        flag = false;
        a1 = new lv.a();
        if (obj instanceof lv.a)
        {
            return (lv.a)obj;
        }
        if (!(obj instanceof String)) goto _L2; else goto _L1
_L1:
        a1.a = 1;
        a1.b = (String)obj;
_L4:
        a1.l = flag;
        return a1;
_L2:
        if (obj instanceof List)
        {
            a1.a = 2;
            Object obj1 = (List)obj;
            obj = new ArrayList(((List) (obj1)).size());
            obj1 = ((List) (obj1)).iterator();
            flag = false;
            while (((Iterator) (obj1)).hasNext()) 
            {
                lv.a a2 = e(((Iterator) (obj1)).next());
                if (a2 == i)
                {
                    return i;
                }
                if (flag || a2.l)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ((List) (obj)).add(a2);
            }
            a1.c = (lv.a[])((List) (obj)).toArray(new lv.a[0]);
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Map)
        {
            a1.a = 3;
            Object obj2 = ((Map)obj).entrySet();
            obj = new ArrayList(((Set) (obj2)).size());
            ArrayList arraylist = new ArrayList(((Set) (obj2)).size());
            obj2 = ((Set) (obj2)).iterator();
            flag = false;
            while (((Iterator) (obj2)).hasNext()) 
            {
                Object obj3 = (java.util.Map.Entry)((Iterator) (obj2)).next();
                lv.a a3 = e(((java.util.Map.Entry) (obj3)).getKey());
                obj3 = e(((java.util.Map.Entry) (obj3)).getValue());
                if (a3 == i || obj3 == i)
                {
                    return i;
                }
                if (flag || a3.l || ((lv.a) (obj3)).l)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ((List) (obj)).add(a3);
                arraylist.add(obj3);
            }
            a1.d = (lv.a[])((List) (obj)).toArray(new lv.a[0]);
            a1.e = (lv.a[])arraylist.toArray(new lv.a[0]);
            continue; /* Loop/switch isn't completed */
        }
        if (f(obj))
        {
            a1.a = 1;
            a1.b = obj.toString();
            continue; /* Loop/switch isn't completed */
        }
        if (h(obj))
        {
            a1.a = 6;
            a1.h = i(obj);
            continue; /* Loop/switch isn't completed */
        }
        if (!(obj instanceof Boolean))
        {
            break; /* Loop/switch isn't completed */
        }
        a1.a = 8;
        a1.i = ((Boolean)obj).booleanValue();
        if (true) goto _L4; else goto _L3
_L3:
        StringBuilder stringbuilder = (new StringBuilder()).append("Converting to Value from unknown object type: ");
        if (obj == null)
        {
            obj = "null";
        } else
        {
            obj = obj.getClass().toString();
        }
        abo.a(stringbuilder.append(((String) (obj))).toString());
        return i;
    }

    public static Object e(lv.a a1)
    {
        boolean flag = false;
        int i1 = 0;
        int j = 0;
        if (a1 == null)
        {
            return a;
        }
        switch (a1.a)
        {
        default:
            abo.a((new StringBuilder()).append("Failed to convert a value of type: ").append(a1.a).toString());
            return a;

        case 1: // '\001'
            return a1.b;

        case 2: // '\002'
            ArrayList arraylist = new ArrayList(a1.c.length);
            a1 = a1.c;
            for (i1 = a1.length; j < i1; j++)
            {
                Object obj = e(a1[j]);
                if (obj == a)
                {
                    return a;
                }
                arraylist.add(obj);
            }

            return arraylist;

        case 3: // '\003'
            if (a1.d.length != a1.e.length)
            {
                abo.a((new StringBuilder()).append("Converting an invalid value to object: ").append(a1.toString()).toString());
                return a;
            }
            HashMap hashmap = new HashMap(a1.e.length);
            for (int k = ((flag) ? 1 : 0); k < a1.d.length; k++)
            {
                Object obj1 = e(a1.d[k]);
                Object obj2 = e(a1.e[k]);
                if (obj1 == a || obj2 == a)
                {
                    return a;
                }
                hashmap.put(obj1, obj2);
            }

            return hashmap;

        case 4: // '\004'
            abo.a("Trying to convert a macro reference to object");
            return a;

        case 5: // '\005'
            abo.a("Trying to convert a function id to object");
            return a;

        case 6: // '\006'
            return Long.valueOf(a1.h);

        case 7: // '\007'
            StringBuffer stringbuffer = new StringBuffer();
            a1 = a1.j;
            int j1 = a1.length;
            for (int l = i1; l < j1; l++)
            {
                String s = a(a1[l]);
                if (s == e)
                {
                    return a;
                }
                stringbuffer.append(s);
            }

            return stringbuffer.toString();

        case 8: // '\b'
            return Boolean.valueOf(a1.i);
        }
    }

    public static String e()
    {
        return e;
    }

    public static lv.a f()
    {
        return i;
    }

    private static boolean f(Object obj)
    {
        return (obj instanceof Double) || (obj instanceof Float) || (obj instanceof adn) && ((adn)obj).a();
    }

    private static double g(Object obj)
    {
        if (obj instanceof Number)
        {
            return ((Number)obj).doubleValue();
        } else
        {
            abo.a("getDouble received non-Number");
            return 0.0D;
        }
    }

    private static boolean h(Object obj)
    {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof adn) && ((adn)obj).b();
    }

    private static long i(Object obj)
    {
        if (obj instanceof Number)
        {
            return ((Number)obj).longValue();
        } else
        {
            abo.a("getInt64 received non-Number");
            return 0L;
        }
    }

    static 
    {
        e = new String("");
        i = e(e);
    }
}
