// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            l, o, Command

public class c
{

    private final Map a;
    private final List b;
    private final long c;
    private final long d;
    private final int e;
    private final boolean f;
    private final String g;

    public c(o o1, Map map, long l1, boolean flag)
    {
        this(o1, map, l1, flag, 0L, 0, null);
    }

    public c(o o1, Map map, long l1, boolean flag, long l2, 
            int i)
    {
        this(o1, map, l1, flag, l2, i, null);
    }

    public c(o o1, Map map, long l1, boolean flag, long l2, 
            int i, List list)
    {
        x.a(o1);
        x.a(map);
        d = l1;
        f = flag;
        c = l2;
        e = i;
        Object obj;
        if (list != null)
        {
            obj = list;
        } else
        {
            obj = Collections.EMPTY_LIST;
        }
        b = ((List) (obj));
        g = a(list);
        list = new HashMap();
        obj = map.entrySet().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            java.util.Map.Entry entry1 = (java.util.Map.Entry)((Iterator) (obj)).next();
            if (a(entry1.getKey()))
            {
                String s1 = a(o1, entry1.getKey());
                if (s1 != null)
                {
                    list.put(s1, b(o1, entry1.getValue()));
                }
            }
        } while (true);
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            if (!a(entry.getKey()))
            {
                String s = a(o1, entry.getKey());
                if (s != null)
                {
                    list.put(s, b(o1, entry.getValue()));
                }
            }
        } while (true);
        if (!TextUtils.isEmpty(g))
        {
            l.a(list, "_v", g);
            if (g.equals("ma4.0.0") || g.equals("ma4.0.1"))
            {
                list.remove("adid");
            }
        }
        a = Collections.unmodifiableMap(list);
    }

    public static c a(o o1, c c1, Map map)
    {
        return new c(o1, map, c1.d(), c1.f(), c1.c(), c1.a(), c1.e());
    }

    private static String a(o o1, Object obj)
    {
        if (obj == null)
        {
            o1 = null;
        } else
        {
            Object obj1 = obj.toString();
            obj = obj1;
            if (((String) (obj1)).startsWith("&"))
            {
                obj = ((String) (obj1)).substring(1);
            }
            int i = ((String) (obj)).length();
            obj1 = obj;
            if (i > 256)
            {
                obj1 = ((String) (obj)).substring(0, 256);
                o1.c("Hit param name is too long and will be trimmed", Integer.valueOf(i), obj1);
            }
            o1 = ((o) (obj1));
            if (TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                return null;
            }
        }
        return o1;
    }

    private String a(String s, String s1)
    {
        x.a(s);
        boolean flag;
        if (!s.startsWith("&"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        x.b(flag, "Short param name required");
        s = (String)a.get(s);
        if (s != null)
        {
            return s;
        } else
        {
            return s1;
        }
    }

    private static String a(List list)
    {
        if (list == null) goto _L2; else goto _L1
_L1:
        list = list.iterator();
_L5:
        if (!list.hasNext()) goto _L2; else goto _L3
_L3:
        Command command = (Command)list.next();
        if (!"appendVersion".equals(command.a())) goto _L5; else goto _L4
_L4:
        list = command.b();
_L7:
        if (TextUtils.isEmpty(list))
        {
            return null;
        } else
        {
            return list;
        }
_L2:
        list = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private static boolean a(Object obj)
    {
        if (obj == null)
        {
            return false;
        } else
        {
            return obj.toString().startsWith("&");
        }
    }

    private static String b(o o1, Object obj)
    {
        Object obj1;
        int i;
        if (obj == null)
        {
            obj = "";
        } else
        {
            obj = obj.toString();
        }
        i = ((String) (obj)).length();
        obj1 = obj;
        if (i > 8192)
        {
            obj1 = ((String) (obj)).substring(0, 8192);
            o1.c("Hit param value is too long and will be trimmed", Integer.valueOf(i), obj1);
        }
        return ((String) (obj1));
    }

    public int a()
    {
        return e;
    }

    public Map b()
    {
        return a;
    }

    public long c()
    {
        return c;
    }

    public long d()
    {
        return d;
    }

    public List e()
    {
        return b;
    }

    public boolean f()
    {
        return f;
    }

    public long g()
    {
        return l.a(a("_s", "0"));
    }

    public String h()
    {
        return a("_m", "");
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("ht=").append(d);
        if (c != 0L)
        {
            stringbuffer.append(", dbId=").append(c);
        }
        if ((long)e != 0L)
        {
            stringbuffer.append(", appUID=").append(e);
        }
        Object obj = new ArrayList(a.keySet());
        Collections.sort(((List) (obj)));
        String s;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); stringbuffer.append((String)a.get(s)))
        {
            s = (String)((Iterator) (obj)).next();
            stringbuffer.append(", ");
            stringbuffer.append(s);
            stringbuffer.append("=");
        }

        return stringbuffer.toString();
    }
}
