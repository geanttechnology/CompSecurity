// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.paypal.android.sdk:
//            ka, hg, gg, gq, 
//            gu, fm, dd, fw, 
//            gr

public final class jz
{

    public static final String a;
    public static final String b;
    public static final String c;
    private static final Comparator d = new ka();
    private static String e;

    public static long a(gg gg1)
    {
        return b(gg1.a("Content-Length"));
    }

    public static long a(gq gq1)
    {
        return a(gq1.e());
    }

    public static long a(gu gu1)
    {
        return a(gu1.g());
    }

    public static gq a(fm fm1, gu gu1, Proxy proxy)
    {
        if (gu1.c() == 407)
        {
            return fm1.b(proxy, gu1);
        } else
        {
            return fm1.a(proxy, gu1);
        }
    }

    public static List a(gg gg1, String s)
    {
        ArrayList arraylist = new ArrayList();
        int k = gg1.a();
label0:
        for (int i = 0; i < k; i++)
        {
            if (!s.equalsIgnoreCase(gg1.a(i)))
            {
                continue;
            }
            String s1 = gg1.b(i);
            int j = 0;
            do
            {
                if (j >= s1.length())
                {
                    continue label0;
                }
                int l = dd.a(s1, j, " ");
                String s2 = s1.substring(j, l).trim();
                j = dd.a(s1, l);
                if (!s1.regionMatches(true, j, "realm=\"", 0, 7))
                {
                    continue label0;
                }
                j += 7;
                l = dd.a(s1, j, "\"");
                String s3 = s1.substring(j, l);
                j = dd.a(s1, dd.a(s1, l + 1, ",") + 1);
                arraylist.add(new fw(s2, s3));
            } while (true);
        }

        return arraylist;
    }

    public static void a(gr gr1, Map map)
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
                    int j = map.size();
                    for (int i = 0; i < j; i++)
                    {
                        if (i > 0)
                        {
                            stringbuilder.append("; ");
                        }
                        stringbuilder.append((String)map.get(i));
                    }

                    map = stringbuilder.toString();
                }
                gr1.b(s, map);
            }
        } while (true);
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

    public static Map b(gg gg1)
    {
        TreeMap treemap = new TreeMap(d);
        int j = gg1.a();
        for (int i = 0; i < j; i++)
        {
            String s = gg1.a(i);
            String s1 = gg1.b(i);
            ArrayList arraylist = new ArrayList();
            List list = (List)treemap.get(s);
            if (list != null)
            {
                arraylist.addAll(list);
            }
            arraylist.add(s1);
            treemap.put(s, Collections.unmodifiableList(arraylist));
        }

        return Collections.unmodifiableMap(treemap);
    }

    static 
    {
        hg.a();
        e = hg.b();
        a = (new StringBuilder()).append(e).append("-Sent-Millis").toString();
        b = (new StringBuilder()).append(e).append("-Received-Millis").toString();
        c = (new StringBuilder()).append(e).append("-Selected-Protocol").toString();
    }
}
