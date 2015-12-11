// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.b;

import com.b.a.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.b.b:
//            c, d

public final class a extends c
{

    protected a(b b, d d1, String s)
    {
        super(b, d1, s);
    }

    public static Boolean a(String s)
    {
        if (!s.contains(","))
        {
            return Boolean.valueOf(false);
        }
        if (!s.contains(" "))
        {
            return Boolean.valueOf(true);
        } else
        {
            return Boolean.valueOf(false);
        }
    }

    public static String a(String s, String s1)
    {
        s1 = new StringBuilder(s1);
        for (s = d(s).iterator(); s.hasNext();)
        {
            String s2 = (String)s.next();
            if (!s1.toString().contains(s2))
            {
                if (s1.toString().equals(""))
                {
                    s1.append(s2).append(":1");
                } else
                {
                    s1.append(";").append(s2).append(":1");
                }
            } else
            {
                String as[] = s1.toString().split(";");
                int i = 0;
                while (i < as.length) 
                {
                    if (as[i].contains(s2))
                    {
                        String as1[] = as[i].split(":");
                        int j = Integer.valueOf(as1[1]).intValue();
                        String s3 = (new StringBuilder()).append(as1[0]).append(":").append(Integer.valueOf(j + 1)).toString();
                        s1.replace(s1.indexOf(as[i]), s1.indexOf(as[i]) + as[i].length(), s3);
                    }
                    i++;
                }
            }
        }

        return s1.toString();
    }

    private static Boolean c(String s)
    {
        for (int i = 0; i < s.length(); i++)
        {
            if (!"0123456789".contains((new StringBuilder()).append(s.charAt(i)).toString()))
            {
                return Boolean.valueOf(false);
            }
        }

        return Boolean.valueOf(true);
    }

    private static List d(String s)
    {
        s = s.split(",");
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < s.length; i++)
        {
            arraylist.add(s[i]);
        }

        return arraylist;
    }

    public final List a()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = a.values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.b.c.a a1 = (com.b.c.a)iterator.next();
            if (a1.c.booleanValue())
            {
                arraylist.add(a1);
            }
        } while (true);
        return arraylist;
    }

    public final void a(List list)
    {
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Object obj = (com.b.c.a)list.next();
            Object obj1 = (com.b.c.a)a.get(((com.b.c.a) (obj)).a);
            if (obj1 == null)
            {
                if (a(((com.b.c.a) (obj)).b).booleanValue())
                {
                    obj1 = a(((com.b.c.a) (obj)).b, "");
                    a(((com.b.c.a) (obj)).a, ((String) (obj1)), Boolean.valueOf(true));
                } else
                {
                    a(((com.b.c.a) (obj)));
                }
            } else
            if (c(((com.b.c.a) (obj1)).b).booleanValue() && c(((com.b.c.a) (obj)).b).booleanValue())
            {
                int i = Integer.valueOf(((com.b.c.a) (obj1)).b).intValue();
                int j = Integer.valueOf(((com.b.c.a) (obj)).b).intValue();
                a(((com.b.c.a) (obj1)).a, Integer.valueOf(j + i).toString(), Boolean.valueOf(true));
            } else
            if (a(((com.b.c.a) (obj)).b).booleanValue())
            {
                obj1 = a(((com.b.c.a) (obj)).b, ((com.b.c.a) (obj1)).b);
                a(((com.b.c.a) (obj)).a, ((String) (obj1)), Boolean.valueOf(true));
            } else
            if (!Boolean.valueOf(((com.b.c.a) (obj1)).b.contains(((com.b.c.a) (obj)).b)).booleanValue())
            {
                obj = (new StringBuilder()).append(((com.b.c.a) (obj1)).b).append(",").append(((com.b.c.a) (obj)).b).toString();
                a(((com.b.c.a) (obj1)).a, ((String) (obj)), Boolean.valueOf(true));
            }
        } while (true);
    }
}
