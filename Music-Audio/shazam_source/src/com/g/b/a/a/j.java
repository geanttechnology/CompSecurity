// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.a;

import com.g.b.a.i;
import com.g.b.a.k;
import com.g.b.b;
import com.g.b.g;
import com.g.b.o;
import com.g.b.v;
import com.g.b.x;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

// Referenced classes of package com.g.b.a.a:
//            d

public final class j
{

    static final String a = i.b();
    public static final String b = (new StringBuilder()).append(a).append("-Sent-Millis").toString();
    public static final String c = (new StringBuilder()).append(a).append("-Received-Millis").toString();
    public static final String d = (new StringBuilder()).append(a).append("-Selected-Protocol").toString();
    private static final Comparator e = new Comparator() {

        public final volatile int compare(Object obj, Object obj1)
        {
            obj = (String)obj;
            obj1 = (String)obj1;
            if (obj == obj1)
            {
                return 0;
            }
            if (obj == null)
            {
                return -1;
            }
            if (obj1 == null)
            {
                return 1;
            } else
            {
                return String.CASE_INSENSITIVE_ORDER.compare(obj, obj1);
            }
        }

    };

    public static long a(o o1)
    {
        return b(o1.a("Content-Length"));
    }

    public static long a(v v1)
    {
        return a(v1.c);
    }

    public static long a(x x1)
    {
        return a(x1.f);
    }

    public static v a(b b1, x x1, Proxy proxy)
    {
        if (x1.c == 407)
        {
            return b1.b(proxy, x1);
        } else
        {
            return b1.a(proxy, x1);
        }
    }

    public static Map a(o o1, String s)
    {
        TreeMap treemap = new TreeMap(e);
        int i1 = o1.a.length / 2;
        for (int l = 0; l < i1; l++)
        {
            String s1 = o1.a(l);
            String s2 = o1.b(l);
            ArrayList arraylist = new ArrayList();
            List list = (List)treemap.get(s1);
            if (list != null)
            {
                arraylist.addAll(list);
            }
            arraylist.add(s2);
            treemap.put(s1, Collections.unmodifiableList(arraylist));
        }

        if (s != null)
        {
            treemap.put(null, Collections.unmodifiableList(Collections.singletonList(s)));
        }
        return Collections.unmodifiableMap(treemap);
    }

    public static void a(com.g.b.v.a a1, Map map)
    {
        Iterator iterator = map.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            map = (java.util.Map.Entry)iterator.next();
            String s = (String)map.getKey();
            if (("Cookie".equalsIgnoreCase(s) || "Cookie2".equalsIgnoreCase(s)) && !((List)map.getValue()).isEmpty())
            {
                map = (List)map.getValue();
                if (map.size() == 1)
                {
                    map = (String)map.get(0);
                } else
                {
                    StringBuilder stringbuilder = new StringBuilder();
                    int i1 = map.size();
                    for (int l = 0; l < i1; l++)
                    {
                        if (l > 0)
                        {
                            stringbuilder.append("; ");
                        }
                        stringbuilder.append((String)map.get(l));
                    }

                    map = stringbuilder.toString();
                }
                a1.b(s, map);
            }
        } while (true);
    }

    public static boolean a(x x1, o o1, v v1)
    {
        for (x1 = b(x1.f).iterator(); x1.hasNext();)
        {
            String s = (String)x1.next();
            if (!k.a(o1.c(s), v1.c.c(s)))
            {
                return false;
            }
        }

        return true;
    }

    static boolean a(String s)
    {
        return !"Connection".equalsIgnoreCase(s) && !"Keep-Alive".equalsIgnoreCase(s) && !"Proxy-Authenticate".equalsIgnoreCase(s) && !"Proxy-Authorization".equalsIgnoreCase(s) && !"TE".equalsIgnoreCase(s) && !"Trailers".equalsIgnoreCase(s) && !"Transfer-Encoding".equalsIgnoreCase(s) && !"Upgrade".equalsIgnoreCase(s);
    }

    private static long b(String s)
    {
        if (s == null)
        {
            return -1L;
        }
        long l;
        try
        {
            l = Long.parseLong(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return -1L;
        }
        return l;
    }

    public static List b(o o1, String s)
    {
        ArrayList arraylist = new ArrayList();
        int j1 = o1.a.length / 2;
label0:
        for (int l = 0; l < j1; l++)
        {
            if (!s.equalsIgnoreCase(o1.a(l)))
            {
                continue;
            }
            String s1 = o1.b(l);
            int i1 = 0;
            do
            {
                if (i1 >= s1.length())
                {
                    continue label0;
                }
                int k1 = com.g.b.a.a.d.a(s1, i1, " ");
                String s2 = s1.substring(i1, k1).trim();
                i1 = com.g.b.a.a.d.a(s1, k1);
                if (!s1.regionMatches(true, i1, "realm=\"", 0, 7))
                {
                    continue label0;
                }
                i1 += 7;
                k1 = com.g.b.a.a.d.a(s1, i1, "\"");
                String s3 = s1.substring(i1, k1);
                i1 = com.g.b.a.a.d.a(s1, com.g.b.a.a.d.a(s1, k1 + 1, ",") + 1);
                arraylist.add(new g(s2, s3));
            } while (true);
        }

        return arraylist;
    }

    private static Set b(o o1)
    {
        Object obj1 = Collections.emptySet();
        int j1 = o1.a.length / 2;
        for (int l = 0; l < j1;)
        {
            Object obj2 = obj1;
            if ("Vary".equalsIgnoreCase(o1.a(l)))
            {
                obj2 = o1.b(l);
                Object obj = obj1;
                if (((Set) (obj1)).isEmpty())
                {
                    obj = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                obj1 = ((String) (obj2)).split(",");
                int k1 = obj1.length;
                int i1 = 0;
                do
                {
                    obj2 = obj;
                    if (i1 >= k1)
                    {
                        break;
                    }
                    ((Set) (obj)).add(obj1[i1].trim());
                    i1++;
                } while (true);
            }
            l++;
            obj1 = obj2;
        }

        return ((Set) (obj1));
    }

    public static boolean b(x x1)
    {
        return b(x1.f).contains("*");
    }

    public static o c(x x1)
    {
        o o1 = x1.h.a.c;
        x1 = b(x1.f);
        if (x1.isEmpty())
        {
            return (new com.g.b.o.a()).a();
        }
        com.g.b.o.a a1 = new com.g.b.o.a();
        int l = 0;
        for (int i1 = o1.a.length / 2; l < i1; l++)
        {
            String s = o1.a(l);
            if (x1.contains(s))
            {
                a1.a(s, o1.b(l));
            }
        }

        return a1.a();
    }

    static 
    {
        i.a();
    }
}
