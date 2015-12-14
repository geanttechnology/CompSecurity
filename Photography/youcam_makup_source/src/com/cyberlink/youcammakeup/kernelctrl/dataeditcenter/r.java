// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter;

import com.cyberlink.youcammakeup.utility.at;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class r
{

    private String a;
    private String b;
    private String c;
    private List d;
    private float e;

    public r()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = -1F;
        a = null;
        b = null;
        c = null;
        d = new ArrayList();
        e = -1F;
    }

    public r(r r1)
    {
        Object obj1 = null;
        super();
        a = null;
        b = null;
        c = null;
        d = null;
        e = -1F;
        float f1;
        Object obj;
        if (r1 == null)
        {
            obj = null;
        } else
        {
            obj = r1.b();
        }
        a = ((String) (obj));
        if (r1 == null)
        {
            obj = null;
        } else
        {
            obj = r1.c();
        }
        b = ((String) (obj));
        if (r1 == null)
        {
            obj = obj1;
        } else
        {
            obj = r1.d();
        }
        c = ((String) (obj));
        if (r1 == null)
        {
            f1 = -1F;
        } else
        {
            f1 = r1.g();
        }
        e = f1;
        d = new ArrayList();
        if (r1 != null)
        {
            for (r1 = r1.d.iterator(); r1.hasNext(); d.add(((at) (obj)).m()))
            {
                obj = (at)r1.next();
            }

        }
    }

    public r(String s, at at1, float f1)
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = -1F;
        a = s;
        e = f1;
        d = new ArrayList();
        if (at1 != null)
        {
            d.add(at1.m());
        }
    }

    public r(String s, String s1, String s2, List list, float f1)
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = -1F;
        a = s;
        b = s1;
        c = s2;
        e = f1;
        d = new ArrayList();
        for (s = list.iterator(); s.hasNext(); d.add(s1.m()))
        {
            s1 = (at)s.next();
        }

    }

    public void a(float f1)
    {
        e = f1;
    }

    public void a(String s)
    {
        b = s;
    }

    public String b()
    {
        return a;
    }

    public String c()
    {
        return b;
    }

    public String d()
    {
        return c;
    }

    public at e()
    {
        if (d.size() == 0)
        {
            return null;
        } else
        {
            return (at)d.get(0);
        }
    }

    public List f()
    {
        return d;
    }

    public float g()
    {
        return e;
    }
}
