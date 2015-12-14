// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter;

import com.cyberlink.youcammakeup.jniproxy.ah;
import com.cyberlink.youcammakeup.jniproxy.bi;

public class b
{

    public boolean a;
    public boolean b;
    public boolean c;
    public String d;
    public int e;
    public ah f;
    public ah g;
    public ah h;
    public ah i;
    public bi j;
    public boolean k;

    public b()
    {
    }

    public b a()
    {
        Object obj1 = null;
        b b1 = new b();
        b1.a = a;
        b1.b = b;
        b1.c = c;
        b1.d = new String(d);
        b1.e = e;
        Object obj;
        if (f != null)
        {
            obj = new ah(f);
        } else
        {
            obj = null;
        }
        b1.f = ((ah) (obj));
        if (g != null)
        {
            obj = new ah(g);
        } else
        {
            obj = null;
        }
        b1.g = ((ah) (obj));
        if (h != null)
        {
            obj = new ah(h);
        } else
        {
            obj = null;
        }
        b1.h = ((ah) (obj));
        if (i != null)
        {
            obj = new ah(i);
        } else
        {
            obj = null;
        }
        b1.i = ((ah) (obj));
        obj = obj1;
        if (j != null)
        {
            obj = new bi(j);
        }
        b1.j = ((bi) (obj));
        b1.k = k;
        return b1;
    }

    public Object clone()
    {
        return a();
    }
}
