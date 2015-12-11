// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.flurry.sdk:
//            dl, ap, de, cy, 
//            gd, cd, i, ce, 
//            df

public class cz
{

    private static final String a = com/flurry/sdk/cz.getSimpleName();
    private static int b = 500;

    public cz()
    {
    }

    static int a()
    {
        return b;
    }

    static int a(String s)
    {
        boolean flag = false;
        int j = ((flag) ? 1 : 0);
        if (s != null)
        {
            s = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})").matcher(s);
            j = ((flag) ? 1 : 0);
            if (s.find())
            {
                j = ((flag) ? 1 : 0);
                if (s.groupCount() == 3)
                {
                    int k;
                    int l;
                    try
                    {
                        j = Integer.parseInt(s.group(1));
                        k = Integer.parseInt(s.group(2));
                        l = Integer.parseInt(s.group(3));
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        return 0;
                    }
                    j = l + (j * 60 * 60 + k * 60);
                }
            }
        }
        return j;
    }

    static dl a(List list)
    {
        Object obj;
        Iterator iterator;
        obj = null;
        Object obj1 = null;
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        iterator = list.iterator();
        list = obj1;
_L5:
        dl dl1;
        obj = list;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_115;
        }
        dl1 = (dl)iterator.next();
        if (dl1.b() > a() || dl1.a() == null || (dl1.c() == null || !dl1.c().equalsIgnoreCase("video/mp4")) && !dl1.a().endsWith("mp4")) goto _L2; else goto _L1
_L1:
        if (list != null) goto _L4; else goto _L3
_L3:
        obj = dl1;
_L6:
        list = ((List) (obj));
          goto _L5
_L4:
        obj = dl1;
        if (list.b() < dl1.b()) goto _L6; else goto _L2
_L2:
        obj = list;
          goto _L6
        return ((dl) (obj));
    }

    public static void a(int j)
    {
        b = j;
    }

    public static void a(ap ap1, String s, String s1)
    {
        ap1 = ap1.g();
        if (ap1 != null)
        {
            ap1 = ap1.a(de.q);
            if (ap1 != null)
            {
                ap1 = ap1.iterator();
                do
                {
                    if (!ap1.hasNext())
                    {
                        break;
                    }
                    String s2 = (String)ap1.next();
                    if (s2 != null)
                    {
                        gd.a(3, a, (new StringBuilder()).append("Close Tracking URL: ").append(s2).toString());
                        a(s, s1, s2);
                    }
                } while (true);
            }
        }
    }

    private static void a(String s, String s1, String s2)
    {
        s = new cd(s, s1, s2, System.currentTimeMillis() + 0xdbba0L, false);
        com.flurry.sdk.i.a().i().b(s);
    }

    public static void b(ap ap1, String s, String s1)
    {
        ap1 = ap1.g();
        if (ap1 != null)
        {
            ap1 = ap1.g();
            if (ap1 != null)
            {
                ap1 = ap1.iterator();
                do
                {
                    if (!ap1.hasNext())
                    {
                        break;
                    }
                    String s2 = (String)ap1.next();
                    if (s2 != null)
                    {
                        gd.a(3, a, (new StringBuilder()).append("Error Tracking URL: ").append(s2).toString());
                        a(s, s1, s2);
                    }
                } while (true);
            }
        }
    }

    public static void c(ap ap1, String s, String s1)
    {
        ap1 = ap1.g();
        if (ap1 != null)
        {
            ap1 = ap1.a(df.c);
            if (ap1 != null)
            {
                ap1 = ap1.iterator();
                do
                {
                    if (!ap1.hasNext())
                    {
                        break;
                    }
                    String s2 = (String)ap1.next();
                    if (!TextUtils.isEmpty(s2))
                    {
                        gd.a(3, a, (new StringBuilder()).append("ClickTracking Tracking URL: ").append(s2).toString());
                        a(s, s1, s2);
                    }
                } while (true);
            }
        }
    }

    public static void d(ap ap1, String s, String s1)
    {
        ap1 = ap1.g();
        if (ap1 != null)
        {
            ap1 = ap1.h();
            if (ap1 != null)
            {
                ap1 = ap1.iterator();
                do
                {
                    if (!ap1.hasNext())
                    {
                        break;
                    }
                    String s2 = (String)ap1.next();
                    if (s2 != null)
                    {
                        gd.a(3, a, (new StringBuilder()).append("Impression Tracking URL: ").append(s2).toString());
                        a(s, s1, s2);
                    }
                } while (true);
            }
        }
    }

    public static void e(ap ap1, String s, String s1)
    {
        ap1 = ap1.g();
        if (ap1 != null)
        {
            ap1 = ap1.a(de.c);
            if (ap1 != null)
            {
                ap1 = ap1.iterator();
                do
                {
                    if (!ap1.hasNext())
                    {
                        break;
                    }
                    String s2 = (String)ap1.next();
                    if (s2 != null)
                    {
                        gd.a(3, a, (new StringBuilder()).append("Start Tracking URL: ").append(s2).toString());
                        a(s, s1, s2);
                    }
                } while (true);
            }
        }
    }

    public static void f(ap ap1, String s, String s1)
    {
        ap1 = ap1.g();
        if (ap1 != null)
        {
            ap1 = ap1.a(de.e);
            if (ap1 != null)
            {
                ap1 = ap1.iterator();
                do
                {
                    if (!ap1.hasNext())
                    {
                        break;
                    }
                    String s2 = (String)ap1.next();
                    if (s2 != null)
                    {
                        gd.a(3, a, (new StringBuilder()).append("First Quartile Tracking URL: ").append(s2).toString());
                        a(s, s1, s2);
                    }
                } while (true);
            }
        }
    }

    public static void g(ap ap1, String s, String s1)
    {
        ap1 = ap1.g();
        if (ap1 != null)
        {
            ap1 = ap1.a(de.d);
            if (ap1 != null)
            {
                ap1 = ap1.iterator();
                do
                {
                    if (!ap1.hasNext())
                    {
                        break;
                    }
                    String s2 = (String)ap1.next();
                    if (s2 != null)
                    {
                        gd.a(3, a, (new StringBuilder()).append("Midpoint Tracking URL: ").append(s2).toString());
                        a(s, s1, s2);
                    }
                } while (true);
            }
        }
    }

    public static void h(ap ap1, String s, String s1)
    {
        ap1 = ap1.g();
        if (ap1 != null)
        {
            ap1 = ap1.a(de.f);
            if (ap1 != null)
            {
                ap1 = ap1.iterator();
                do
                {
                    if (!ap1.hasNext())
                    {
                        break;
                    }
                    String s2 = (String)ap1.next();
                    if (s2 != null)
                    {
                        gd.a(3, a, (new StringBuilder()).append("Third Quartile Tracking URL: ").append(s2).toString());
                        a(s, s1, s2);
                    }
                } while (true);
            }
        }
    }

    public static void i(ap ap1, String s, String s1)
    {
        ap1 = ap1.g();
        if (ap1 != null)
        {
            ap1 = ap1.a(de.g);
            if (ap1 != null)
            {
                ap1 = ap1.iterator();
                do
                {
                    if (!ap1.hasNext())
                    {
                        break;
                    }
                    String s2 = (String)ap1.next();
                    if (s2 != null)
                    {
                        gd.a(3, a, (new StringBuilder()).append("Complete Tracking URL: ").append(s2).toString());
                        a(s, s1, s2);
                    }
                } while (true);
            }
        }
    }

}
