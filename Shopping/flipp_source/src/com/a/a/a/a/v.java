// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.a.u;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.a.a.a.a:
//            w

public final class v
{

    private static final Comparator f = new w();
    final List a;
    public String b;
    int c;
    public int d;
    String e;
    private String g;

    public v()
    {
        a = new ArrayList(20);
        c = 1;
        d = -1;
    }

    public v(v v1)
    {
        a = new ArrayList(20);
        c = 1;
        d = -1;
        a.addAll(v1.a);
        g = v1.g;
        b = v1.b;
        c = v1.c;
        d = v1.d;
        e = v1.e;
    }

    public static v a(InputStream inputstream)
    {
        v v1;
        do
        {
            v1 = new v();
            v1.b(u.c(inputstream));
            a(inputstream, v1);
        } while (v1.d == 100);
        return v1;
    }

    public static v a(List list)
    {
        String s1 = null;
        if (list.size() % 2 != 0)
        {
            throw new IllegalArgumentException((new StringBuilder("Unexpected name value block: ")).append(list).toString());
        }
        v v1 = new v();
        int i = 0;
        String s = null;
        for (; i < list.size(); i += 2)
        {
            String s3 = (String)list.get(i);
            String s4 = (String)list.get(i + 1);
            int j = 0;
            while (j < s4.length()) 
            {
                int l = s4.indexOf('\0', j);
                int k = l;
                if (l == -1)
                {
                    k = s4.length();
                }
                String s2 = s4.substring(j, k);
                if (":status".equals(s3))
                {
                    s = s2;
                } else
                if (":version".equals(s3))
                {
                    s1 = s2;
                } else
                {
                    v1.a.add(s3);
                    v1.a.add(s2);
                }
                j = k + 1;
            }
        }

        if (s == null)
        {
            throw new ProtocolException("Expected ':status' header not present");
        }
        if (s1 == null)
        {
            throw new ProtocolException("Expected ':version' header not present");
        } else
        {
            v1.b((new StringBuilder()).append(s1).append(" ").append(s).toString());
            return v1;
        }
    }

    public static v a(Map map)
    {
        v v1 = new v();
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)map.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = (List)((java.util.Map.Entry) (obj)).getValue();
            if (s != null)
            {
                obj = ((List) (obj)).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    v1.c(s, (String)((Iterator) (obj)).next());
                }
            } else
            if (!((List) (obj)).isEmpty())
            {
                v1.b((String)((List) (obj)).get(((List) (obj)).size() - 1));
            }
        } while (true);
        return v1;
    }

    public static void a(InputStream inputstream, v v1)
    {
        do
        {
            String s = u.c(inputstream);
            if (s.length() != 0)
            {
                v1.c(s);
            } else
            {
                return;
            }
        } while (true);
    }

    private void c(String s, String s1)
    {
        a.add(s);
        a.add(s1.trim());
    }

    public final int a()
    {
        return a.size() / 2;
    }

    public final v a(Set set)
    {
        v v1 = new v();
        for (int i = 0; i < a.size(); i += 2)
        {
            String s = (String)a.get(i);
            if (set.contains(s))
            {
                v1.a(s, (String)a.get(i + 1));
            }
        }

        return v1;
    }

    public final String a(int i)
    {
        i *= 2;
        if (i < 0 || i >= a.size())
        {
            return null;
        } else
        {
            return (String)a.get(i);
        }
    }

    public final Map a(boolean flag)
    {
        TreeMap treemap;
        treemap = new TreeMap(f);
        for (int i = 0; i < a.size(); i += 2)
        {
            String s = (String)a.get(i);
            String s1 = (String)a.get(i + 1);
            ArrayList arraylist = new ArrayList();
            List list = (List)treemap.get(s);
            if (list != null)
            {
                arraylist.addAll(list);
            }
            arraylist.add(s1);
            treemap.put(s, Collections.unmodifiableList(arraylist));
        }

        if (!flag || b == null) goto _L2; else goto _L1
_L1:
        treemap.put(null, Collections.unmodifiableList(Collections.singletonList(b)));
_L4:
        return Collections.unmodifiableMap(treemap);
_L2:
        if (g != null)
        {
            treemap.put(null, Collections.unmodifiableList(Collections.singletonList(g)));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(String s)
    {
        g = s.trim();
    }

    public final void a(String s, String s1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("fieldname == null");
        }
        if (s1 == null)
        {
            throw new IllegalArgumentException("value == null");
        }
        if (s.length() == 0 || s.indexOf('\0') != -1 || s1.indexOf('\0') != -1)
        {
            throw new IllegalArgumentException((new StringBuilder("Unexpected header: ")).append(s).append(": ").append(s1).toString());
        } else
        {
            c(s, s1);
            return;
        }
    }

    public final String b(int i)
    {
        i = i * 2 + 1;
        if (i < 0 || i >= a.size())
        {
            return null;
        } else
        {
            return (String)a.get(i);
        }
    }

    public final void b(String s)
    {
        if (e != null)
        {
            throw new IllegalStateException("statusLine is already set");
        }
        boolean flag;
        if (s.length() > 13)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!s.startsWith("HTTP/1.") || s.length() < 12 || s.charAt(8) != ' ' || flag && s.charAt(12) != ' ')
        {
            throw new ProtocolException((new StringBuilder("Unexpected status line: ")).append(s).toString());
        }
        int i = s.charAt(7) - 48;
        if (i < 0 || i > 9)
        {
            throw new ProtocolException((new StringBuilder("Unexpected status line: ")).append(s).toString());
        }
        Object obj;
        int j;
        try
        {
            j = Integer.parseInt(s.substring(9, 12));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ProtocolException((new StringBuilder("Unexpected status line: ")).append(s).toString());
        }
        if (flag)
        {
            obj = s.substring(13);
        } else
        {
            obj = "";
        }
        e = ((String) (obj));
        d = j;
        b = s;
        c = i;
    }

    public final void b(String s, String s1)
    {
        d(s);
        a(s, s1);
    }

    public final byte[] b()
    {
        StringBuilder stringbuilder = new StringBuilder(256);
        stringbuilder.append(g).append("\r\n");
        for (int i = 0; i < a.size(); i += 2)
        {
            stringbuilder.append((String)a.get(i)).append(": ").append((String)a.get(i + 1)).append("\r\n");
        }

        stringbuilder.append("\r\n");
        return stringbuilder.toString().getBytes("ISO-8859-1");
    }

    public final void c(String s)
    {
        int i = s.indexOf(":");
        if (i == -1)
        {
            c("", s);
            return;
        } else
        {
            c(s.substring(0, i), s.substring(i + 1));
            return;
        }
    }

    public final void d(String s)
    {
        for (int i = 0; i < a.size(); i += 2)
        {
            if (s.equalsIgnoreCase((String)a.get(i)))
            {
                a.remove(i);
                a.remove(i);
            }
        }

    }

    public final String e(String s)
    {
        for (int i = a.size() - 2; i >= 0; i -= 2)
        {
            if (s.equalsIgnoreCase((String)a.get(i)))
            {
                return (String)a.get(i + 1);
            }
        }

        return null;
    }

}
