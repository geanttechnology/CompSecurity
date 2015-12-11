// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;

import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.g.a.a;
import com.google.api.a.g.ac;
import com.google.api.a.g.h;
import com.google.api.a.g.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.api.a.d:
//            h

public final class ab
{
    private static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        private static final a n[];
        final Character i;
        final String j;
        final String k;
        final boolean l;
        final boolean m;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/google/api/a/d/ab$a, s);
        }

        public static a[] values()
        {
            return (a[])n.clone();
        }

        final String a(String s)
        {
            if (m)
            {
                return com.google.api.a.g.a.a.c(s);
            } else
            {
                return com.google.api.a.g.a.a.a(s);
            }
        }

        static 
        {
            a = new a("PLUS", 0, Character.valueOf('+'), "", ",", false, true);
            b = new a("HASH", 1, Character.valueOf('#'), "#", ",", false, true);
            c = new a("DOT", 2, Character.valueOf('.'), ".", ".", false, false);
            d = new a("FORWARD_SLASH", 3, Character.valueOf('/'), "/", "/", false, false);
            e = new a("SEMI_COLON", 4, Character.valueOf(';'), ";", ";", true, false);
            f = new a("QUERY", 5, Character.valueOf('?'), "?", "&", true, false);
            g = new a("AMP", 6, Character.valueOf('&'), "&", "&", true, false);
            h = new a("SIMPLE", 7, null, "", ",", false, false);
            n = (new a[] {
                a, b, c, d, e, f, g, h
            });
        }

        private a(String s, int i1, Character character, String s1, String s2, boolean flag, boolean flag1)
        {
            super(s, i1);
            i = character;
            j = (String)com.google.api.a.f.a.a.a.a.c.a(s1);
            k = (String)com.google.api.a.f.a.a.a.a.c.a(s2);
            l = flag;
            m = flag1;
            if (character != null)
            {
                com.google.api.a.d.ab.a.put(character, this);
            }
        }
    }


    static final Map a = new HashMap();

    private static String a(String s, Object obj)
    {
        Map map;
        StringBuilder stringbuilder;
        int i;
        int j1;
        map = a(obj);
        stringbuilder = new StringBuilder();
        j1 = s.length();
        i = 0;
_L2:
        Object obj1;
        String s1;
        boolean flag;
        int j;
label0:
        {
            if (i < j1)
            {
                j = s.indexOf('{', i);
                if (j != -1)
                {
                    break label0;
                }
                stringbuilder.append(s.substring(i));
            }
            com.google.api.a.d.h.a(map.entrySet(), stringbuilder);
            return stringbuilder.toString();
        }
        stringbuilder.append(s.substring(i, j));
        i = s.indexOf('}', j + 2);
        obj1 = s.substring(j + 1, i);
        i++;
        flag = ((String) (obj1)).endsWith("*");
        obj = (a)a.get(Character.valueOf(((String) (obj1)).charAt(0)));
        if (obj == null)
        {
            obj = com.google.api.a.d.a.h;
        }
        int l;
        int i1;
        if (((a) (obj)).i == null)
        {
            j = 0;
        } else
        {
            j = 1;
        }
        i1 = ((String) (obj1)).length();
        l = i1;
        if (flag)
        {
            l = i1 - 1;
        }
        s1 = ((String) (obj1)).substring(j, l);
        obj1 = map.remove(s1);
        if (obj1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!(obj1 instanceof Iterator))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = a(s1, (Iterator)obj1, flag, ((a) (obj)));
_L3:
        stringbuilder.append(obj);
        if (true) goto _L2; else goto _L1
_L1:
        if ((obj1 instanceof Iterable) || obj1.getClass().isArray())
        {
            obj = a(s1, ac.a(obj1).iterator(), flag, ((a) (obj)));
        } else
        if (obj1.getClass().isEnum())
        {
            s1 = k.a((Enum)obj1).c;
            obj = obj1;
            if (s1 != null)
            {
                obj = com.google.api.a.g.a.a.c(s1);
            }
        } else
        if (!h.d(obj1))
        {
            obj = a(s1, a(obj1), flag, ((a) (obj)));
        } else
        if (((a) (obj)).m)
        {
            obj = com.google.api.a.g.a.a.d(obj1.toString());
        } else
        {
            obj = com.google.api.a.g.a.a.c(obj1.toString());
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    public static String a(String s, String s1, Object obj)
    {
        if (!s1.startsWith("/")) goto _L2; else goto _L1
_L1:
        s = new com.google.api.a.d.h(s);
        s.a = com.google.api.a.d.h.h(null);
        s = String.valueOf(s.d());
        s1 = String.valueOf(s1);
        if (s1.length() != 0)
        {
            s = s.concat(s1);
        } else
        {
            s = new String(s);
        }
_L4:
        return a(s, obj);
_L2:
        String s2;
        s2 = s1;
        if (!s1.startsWith("http://"))
        {
            if (!s1.startsWith("https://"))
            {
                break; /* Loop/switch isn't completed */
            }
            s2 = s1;
        }
_L5:
        s = s2;
        if (true) goto _L4; else goto _L3
_L3:
        s = String.valueOf(s);
        s1 = String.valueOf(s1);
        if (s1.length() != 0)
        {
            s2 = s.concat(s1);
        } else
        {
            s2 = new String(s);
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    private static String a(String s, Iterator iterator, boolean flag, a a1)
    {
        StringBuilder stringbuilder;
        if (!iterator.hasNext())
        {
            return "";
        }
        stringbuilder = new StringBuilder();
        stringbuilder.append(a1.j);
        if (!flag) goto _L2; else goto _L1
_L1:
        String s1 = a1.k;
_L4:
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        if (flag && a1.l)
        {
            stringbuilder.append(com.google.api.a.g.a.a.c(s));
            stringbuilder.append("=");
        }
        stringbuilder.append(a1.a(iterator.next().toString()));
        if (iterator.hasNext())
        {
            stringbuilder.append(s1);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        String s2 = ",";
        s1 = s2;
        if (a1.l)
        {
            stringbuilder.append(com.google.api.a.g.a.a.c(s));
            stringbuilder.append("=");
            s1 = s2;
        }
        if (true) goto _L4; else goto _L3
_L3:
        return stringbuilder.toString();
    }

    private static String a(String s, Map map, boolean flag, a a1)
    {
        if (map.isEmpty())
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(a1.j);
        String s1;
        if (flag)
        {
            s1 = a1.k;
            s = "=";
        } else
        {
            if (a1.l)
            {
                stringbuilder.append(com.google.api.a.g.a.a.c(s));
                stringbuilder.append("=");
            }
            s = ",";
            s1 = ",";
        }
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)map.next();
            String s2 = a1.a((String)((java.util.Map.Entry) (obj)).getKey());
            obj = a1.a(((java.util.Map.Entry) (obj)).getValue().toString());
            stringbuilder.append(s2);
            stringbuilder.append(s);
            stringbuilder.append(((String) (obj)));
            if (map.hasNext())
            {
                stringbuilder.append(s1);
            }
        } while (true);
        return stringbuilder.toString();
    }

    private static Map a(Object obj)
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        obj = h.b(obj).entrySet().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            Object obj1 = entry.getValue();
            if (obj1 != null && !h.a(obj1))
            {
                linkedhashmap.put(entry.getKey(), obj1);
            }
        } while (true);
        return linkedhashmap;
    }

    static 
    {
        a.values();
    }
}
