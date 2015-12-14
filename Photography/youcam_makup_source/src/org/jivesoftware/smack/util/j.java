// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.util.a.a;
import org.jivesoftware.smack.util.a.b;
import org.jivesoftware.smack.util.a.c;

public class j
{

    private static final Logger a = Logger.getLogger(org/jivesoftware/smack/util/j.getName());
    private static a b = null;

    public j()
    {
    }

    private static int a(int ai[], double d)
    {
        int i = 0;
        int l = ai.length;
        int k = 0;
        do
        {
            if (i >= l || d < (double)ai[i])
            {
                return k;
            }
            k++;
            i++;
        } while (true);
    }

    public static List a(String s)
    {
        if (b == null)
        {
            ArrayList arraylist = new ArrayList(1);
            arraylist.add(new b(s, 5222));
            return arraylist;
        } else
        {
            return a(s, 'c');
        }
    }

    private static List a(String s, char c1)
    {
        ArrayList arraylist = new ArrayList();
        String s1;
        List list;
        if (c1 == 's')
        {
            s1 = (new StringBuilder()).append("_xmpp-server._tcp.").append(s).toString();
        } else
        if (c1 == 'c')
        {
            s1 = (new StringBuilder()).append("_xmpp-client._tcp.").append(s).toString();
        } else
        {
            s1 = s;
        }
        list = b.a(s1);
        if (a.isLoggable(Level.FINE))
        {
            s1 = (new StringBuilder()).append("Resolved SRV RR for ").append(s1).append(":").toString();
            for (Iterator iterator = list.iterator(); iterator.hasNext();)
            {
                c c2 = (c)iterator.next();
                s1 = (new StringBuilder()).append(s1).append(" ").append(c2).toString();
            }

            a.fine(s1);
        }
        arraylist.addAll(a(list));
        arraylist.add(new b(s));
        return arraylist;
    }

    private static List a(List list)
    {
        if (list.size() == 1 && ((c)list.get(0)).a().equals("."))
        {
            return Collections.emptyList();
        }
        Collections.sort(list);
        TreeMap treemap = new TreeMap();
        Object obj;
        c c1;
        for (Iterator iterator1 = list.iterator(); iterator1.hasNext(); ((List) (obj)).add(c1))
        {
            c1 = (c)iterator1.next();
            Integer integer = Integer.valueOf(c1.d());
            List list1 = (List)treemap.get(integer);
            obj = list1;
            if (list1 == null)
            {
                obj = new LinkedList();
                treemap.put(integer, obj);
            }
        }

        list = new ArrayList(list.size());
        Iterator iterator = treemap.keySet().iterator();
        do
        {
label0:
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                List list2 = (List)treemap.get((Integer)iterator.next());
                do
                {
                    int i1 = list2.size();
                    if (i1 <= 0)
                    {
                        break;
                    }
                    int ai[] = new int[list2.size()];
                    int l = 0;
                    int k = 0;
                    Iterator iterator2 = list2.iterator();
                    int i = 1;
                    do
                    {
                        if (!iterator2.hasNext())
                        {
                            break;
                        }
                        if (((c)iterator2.next()).e() > 0)
                        {
                            i = 0;
                        }
                    } while (true);
                    for (Iterator iterator3 = list2.iterator(); iterator3.hasNext();)
                    {
                        l += ((c)iterator3.next()).e() + i;
                        ai[k] = l;
                        k++;
                    }

                    if (l == 0)
                    {
                        i = (int)(Math.random() * (double)i1);
                    } else
                    {
                        i = a(ai, Math.random() * (double)l);
                    }
                    list.add((c)list2.remove(i));
                } while (true);
            }
        } while (true);
        return list;
    }

    public static void a()
    {
        String as[];
        int i;
        int k;
        as = new String[3];
        as[0] = "javax.JavaxResolver";
        as[1] = "minidns.MiniDnsResolver";
        as[2] = "dnsjava.DNSJavaResolver";
        k = as.length;
        i = 0;
_L1:
        Object obj;
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        obj = as[i];
        obj = (new StringBuilder()).append("org.jivesoftware.smack.util.dns").append(((String) (obj))).toString();
        obj = (a)Class.forName(((String) (obj))).getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        a(((a) (obj)));
        return;
        Object obj1;
        obj1;
        a.log(Level.FINE, "Exception on init", ((Throwable) (obj1)));
_L2:
        i++;
          goto _L1
        obj1;
        a.log(Level.FINE, "Exception on init", ((Throwable) (obj1)));
          goto _L2
        obj1;
        a.log(Level.FINE, "Exception on init", ((Throwable) (obj1)));
          goto _L2
        obj1;
        a.log(Level.FINE, "Exception on init", ((Throwable) (obj1)));
          goto _L2
        obj1;
        a.log(Level.FINE, "Exception on init", ((Throwable) (obj1)));
          goto _L2
        obj1;
        a.log(Level.FINE, "Exception on init", ((Throwable) (obj1)));
          goto _L2
    }

    public static void a(a a1)
    {
        b = a1;
    }

}
