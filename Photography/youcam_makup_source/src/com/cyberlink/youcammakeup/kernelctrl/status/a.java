// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.jniproxy.z;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.j;
import java.util.List;

public class a
{

    public final long a;
    public final long b;
    public final long c;
    public UIImageOrientation d;
    public int e;
    public String f;
    private List g;
    private List h;
    private v i;
    private z j;
    private z k;
    private String l;

    public a(long l1, long l2, long l3, UIImageOrientation uiimageorientation, 
            List list, List list1, z z, z z1, int i1, String s, v v, 
            String s1)
    {
        d = UIImageOrientation.b;
        g = null;
        h = null;
        e = -2;
        f = null;
        j = null;
        k = null;
        l = "";
        a = l1;
        b = l2;
        c = l3;
        d = uiimageorientation;
        g = com.cyberlink.youcammakeup.kernelctrl.j.a(list);
        h = com.cyberlink.youcammakeup.kernelctrl.j.a(list1);
        j = com.cyberlink.youcammakeup.kernelctrl.j.a(z);
        k = com.cyberlink.youcammakeup.kernelctrl.j.a(z1);
        e = i1;
        f = s;
        i = v;
        l = s1;
    }

    public z a()
    {
        return com.cyberlink.youcammakeup.kernelctrl.j.a(j);
    }

    public void a(z z)
    {
        j = com.cyberlink.youcammakeup.kernelctrl.j.a(z);
    }

    public void a(v v)
    {
        i = v;
    }

    public void a(List list, int i1)
    {
        Object obj = null;
        e = i1;
        g = com.cyberlink.youcammakeup.kernelctrl.j.a(list);
        h = com.cyberlink.youcammakeup.kernelctrl.j.a(list);
        if (e != -2 && e != -1)
        {
            z z;
            if (h.get(e) != null && ((ar)h.get(e)).c != null)
            {
                list = ((ar)h.get(e)).c.b();
            } else
            {
                list = null;
            }
            z = obj;
            if (h.get(e) != null)
            {
                z = obj;
                if (((ar)h.get(e)).c != null)
                {
                    z = ((ar)h.get(e)).c.c();
                }
            }
            a(((z) (list)));
            b(z);
        }
    }

    public z b()
    {
        return com.cyberlink.youcammakeup.kernelctrl.j.a(k);
    }

    public void b(z z)
    {
        k = com.cyberlink.youcammakeup.kernelctrl.j.a(z);
    }

    public String c()
    {
        return f;
    }

    public List d()
    {
        return com.cyberlink.youcammakeup.kernelctrl.j.a(g);
    }

    public List e()
    {
        return com.cyberlink.youcammakeup.kernelctrl.j.a(h);
    }

    public v f()
    {
        return i;
    }

    public String g()
    {
        return l;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("imageID: ");
        stringbuilder.append(a);
        stringbuilder.append(", imageWidth: ");
        stringbuilder.append(b);
        stringbuilder.append(", imageHeight: ");
        stringbuilder.append(c);
        stringbuilder.append(", orientation: ");
        stringbuilder.append(d);
        return stringbuilder.toString();
    }
}
