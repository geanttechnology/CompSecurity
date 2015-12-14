// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter;

import com.cyberlink.youcammakeup.jniproxy.bk;
import com.cyberlink.youcammakeup.jniproxy.u;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter:
//            a

public class d
{

    public u a;
    public bk b;
    public a c;
    private boolean d;

    public d()
    {
        a = new u();
        b = new bk();
        c = new a();
        d = false;
    }

    public d(d d1)
    {
        a = new u(d1.a);
        b = new bk(d1.b);
        c = new a(d1.c);
        d = d1.d;
    }

    public void a()
    {
        d = true;
    }

    public boolean b()
    {
        return d;
    }

    public d c()
    {
        return new d(this);
    }

    public Object clone()
    {
        return c();
    }
}
