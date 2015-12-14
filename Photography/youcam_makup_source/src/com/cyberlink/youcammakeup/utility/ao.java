// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            ap, at, PanelDataCenter, BeautyMode

public class ao
{

    private final BeautyMode a;
    private final String b;
    private final List c;
    private final List d;
    private PanelDataCenter.LipstickProfile e;
    private final String f;
    private final ap g;
    private final int h;
    private final int i;

    ao(BeautyMode beautymode, String s, List list, List list1, int j, int k, String s1, 
            ap ap1)
    {
        a = beautymode;
        b = s;
        c = list;
        d = list1;
        h = j;
        i = k;
        f = s1;
        g = ap1;
    }

    public static ao a(BeautyMode beautymode, r r1)
    {
        String s = r1.b();
        String s1 = r1.d();
        ap ap1 = new ap();
        ap1.a = r1.c();
        ArrayList arraylist = new ArrayList();
        at at1;
        for (Iterator iterator = r1.f().iterator(); iterator.hasNext(); arraylist.add(at1))
        {
            at1 = (at)iterator.next();
            at1.a((int)r1.g());
        }

        if (s != null)
        {
            r1 = PanelDataCenter.a().a(s);
        } else
        {
            r1 = null;
        }
        return new ao(beautymode, s, arraylist, r1, 0, 0, s1, ap1);
    }

    static String a(ao ao1)
    {
        return ao1.b;
    }

    static List b(ao ao1)
    {
        return ao1.d;
    }

    static List c(ao ao1)
    {
        return ao1.c;
    }

    static PanelDataCenter.LipstickProfile d(ao ao1)
    {
        return ao1.e;
    }

    static int e(ao ao1)
    {
        return ao1.h;
    }

    public BeautyMode a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public String c()
    {
        if (g == null)
        {
            return null;
        } else
        {
            return g.a;
        }
    }

    public float d()
    {
        return g.b;
    }

    public int e()
    {
        return c.size();
    }

    public List f()
    {
        return c;
    }

    public int g()
    {
        return h;
    }

    public int h()
    {
        return i;
    }

    public String i()
    {
        return f;
    }
}
