// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter;

import com.cyberlink.youcammakeup.utility.at;

public class k
{

    private String a;
    private float b;
    private at c;

    public k()
    {
        a = null;
        b = -1F;
        c = null;
        a = null;
        b = -1F;
        c = new at(0);
    }

    public k(k k1)
    {
        Object obj1 = null;
        super();
        a = null;
        b = -1F;
        c = null;
        float f;
        Object obj;
        if (k1 == null || k1.a() == null)
        {
            obj = null;
        } else
        {
            obj = new String(k1.a());
        }
        a = ((String) (obj));
        if (k1 == null)
        {
            f = -1F;
        } else
        {
            f = k1.b();
        }
        b = f;
        obj = obj1;
        if (k1 != null)
        {
            if (k1.c() == null)
            {
                obj = obj1;
            } else
            {
                obj = k1.c().m();
            }
        }
        c = ((at) (obj));
    }

    public k(String s, float f, at at1)
    {
        Object obj = null;
        super();
        a = null;
        b = -1F;
        c = null;
        if (s != null)
        {
            s = new String(s);
        } else
        {
            s = null;
        }
        a = s;
        b = f;
        s = obj;
        if (at1 != null)
        {
            s = at1.m();
        }
        c = s;
    }

    public String a()
    {
        return a;
    }

    public void a(float f)
    {
        b = f;
    }

    public float b()
    {
        return b;
    }

    public at c()
    {
        return c;
    }
}
