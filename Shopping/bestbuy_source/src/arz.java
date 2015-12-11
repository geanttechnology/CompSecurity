// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class arz
{

    private static final Object a = null;
    private static Long b = new Long(0L);
    private static Double c = new Double(0.0D);
    private static ary d = ary.a(0L);
    private static String e;
    private static Boolean f = new Boolean(false);
    private static List g = new ArrayList(0);
    private static Map h = new HashMap();
    private static wk i;

    private static Boolean a(String s)
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

    public static String a(wk wk1)
    {
        return a(c(wk1));
    }

    public static wk a()
    {
        return i;
    }

    public static Boolean b(Object obj)
    {
        if (obj instanceof Boolean)
        {
            return (Boolean)obj;
        } else
        {
            return a(a(obj));
        }
    }

    public static Boolean b(wk wk1)
    {
        return b(c(wk1));
    }

    public static Object c(wk wk1)
    {
        boolean flag = false;
        int i1 = 0;
        int j = 0;
        if (wk1 == null)
        {
            return a;
        }
        switch (wk1.a)
        {
        default:
            aqv.a((new StringBuilder()).append("Failed to convert a value of type: ").append(wk1.a).toString());
            return a;

        case 1: // '\001'
            return wk1.b;

        case 2: // '\002'
            ArrayList arraylist = new ArrayList(wk1.c.length);
            wk1 = wk1.c;
            for (i1 = wk1.length; j < i1; j++)
            {
                Object obj = c(wk1[j]);
                if (obj == a)
                {
                    return a;
                }
                arraylist.add(obj);
            }

            return arraylist;

        case 3: // '\003'
            if (wk1.d.length != wk1.e.length)
            {
                aqv.a((new StringBuilder()).append("Converting an invalid value to object: ").append(wk1.toString()).toString());
                return a;
            }
            HashMap hashmap = new HashMap(wk1.e.length);
            for (int k = ((flag) ? 1 : 0); k < wk1.d.length; k++)
            {
                Object obj1 = c(wk1.d[k]);
                Object obj2 = c(wk1.e[k]);
                if (obj1 == a || obj2 == a)
                {
                    return a;
                }
                hashmap.put(obj1, obj2);
            }

            return hashmap;

        case 4: // '\004'
            aqv.a("Trying to convert a macro reference to object");
            return a;

        case 5: // '\005'
            aqv.a("Trying to convert a function id to object");
            return a;

        case 6: // '\006'
            return Long.valueOf(wk1.h);

        case 7: // '\007'
            StringBuffer stringbuffer = new StringBuffer();
            wk1 = wk1.j;
            int j1 = wk1.length;
            for (int l = i1; l < j1; l++)
            {
                String s = a(wk1[l]);
                if (s == e)
                {
                    return a;
                }
                stringbuffer.append(s);
            }

            return stringbuffer.toString();

        case 8: // '\b'
            return Boolean.valueOf(wk1.i);
        }
    }

    public static wk c(Object obj)
    {
        wk wk1;
        boolean flag;
        flag = false;
        wk1 = new wk();
        if (obj instanceof wk)
        {
            return (wk)obj;
        }
        if (!(obj instanceof String)) goto _L2; else goto _L1
_L1:
        wk1.a = 1;
        wk1.b = (String)obj;
_L4:
        wk1.l = flag;
        return wk1;
_L2:
        if (obj instanceof List)
        {
            wk1.a = 2;
            Object obj1 = (List)obj;
            obj = new ArrayList(((List) (obj1)).size());
            obj1 = ((List) (obj1)).iterator();
            flag = false;
            while (((Iterator) (obj1)).hasNext()) 
            {
                wk wk2 = c(((Iterator) (obj1)).next());
                if (wk2 == i)
                {
                    return i;
                }
                if (flag || wk2.l)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ((List) (obj)).add(wk2);
            }
            wk1.c = (wk[])((List) (obj)).toArray(new wk[0]);
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Map)
        {
            wk1.a = 3;
            Object obj2 = ((Map)obj).entrySet();
            obj = new ArrayList(((Set) (obj2)).size());
            ArrayList arraylist = new ArrayList(((Set) (obj2)).size());
            obj2 = ((Set) (obj2)).iterator();
            flag = false;
            while (((Iterator) (obj2)).hasNext()) 
            {
                Object obj3 = (java.util.Map.Entry)((Iterator) (obj2)).next();
                wk wk3 = c(((java.util.Map.Entry) (obj3)).getKey());
                obj3 = c(((java.util.Map.Entry) (obj3)).getValue());
                if (wk3 == i || obj3 == i)
                {
                    return i;
                }
                if (flag || wk3.l || ((wk) (obj3)).l)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ((List) (obj)).add(wk3);
                arraylist.add(obj3);
            }
            wk1.d = (wk[])((List) (obj)).toArray(new wk[0]);
            wk1.e = (wk[])arraylist.toArray(new wk[0]);
            continue; /* Loop/switch isn't completed */
        }
        if (d(obj))
        {
            wk1.a = 1;
            wk1.b = obj.toString();
            continue; /* Loop/switch isn't completed */
        }
        if (e(obj))
        {
            wk1.a = 6;
            wk1.h = f(obj);
            continue; /* Loop/switch isn't completed */
        }
        if (!(obj instanceof Boolean))
        {
            break; /* Loop/switch isn't completed */
        }
        wk1.a = 8;
        wk1.i = ((Boolean)obj).booleanValue();
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
        aqv.a(stringbuilder.append(((String) (obj))).toString());
        return i;
    }

    private static boolean d(Object obj)
    {
        return (obj instanceof Double) || (obj instanceof Float) || (obj instanceof ary) && ((ary)obj).a();
    }

    private static boolean e(Object obj)
    {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof ary) && ((ary)obj).b();
    }

    private static long f(Object obj)
    {
        if (obj instanceof Number)
        {
            return ((Number)obj).longValue();
        } else
        {
            aqv.a("getInt64 received non-Number");
            return 0L;
        }
    }

    static 
    {
        e = new String("");
        i = c(e);
    }
}
