// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import com.cyberlink.youcammakeup.jniproxy.ai;
import com.cyberlink.youcammakeup.jniproxy.ax;
import com.cyberlink.youcammakeup.jniproxy.bn;
import com.cyberlink.youcammakeup.jniproxy.y;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            at

public class ar
{

    public final int a;
    public ai b;
    public y c;
    public ax d;
    public bn e;
    public boolean f;
    public at g;

    public ar(int i)
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = false;
        g = null;
        a = i;
        g = new at();
    }

    public ar(ar ar1)
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = false;
        g = null;
        a = ar1.a;
        b = new ai(ar1.b);
        c = new y(ar1.c);
        d = new ax(ar1.d);
        e = new bn(ar1.e);
        f = ar1.f;
        g = new at(ar1.g);
    }

    public void a(ai ai1, y y1)
    {
        b = new ai(ai1);
        c = new y(y1);
    }

    public void a(ax ax1)
    {
        d = new ax(ax1);
    }

    public void a(bn bn1)
    {
        e = new bn(bn1);
    }

    public void a(at at1)
    {
        g = new at(at1);
    }

    public void a(boolean flag)
    {
        f = flag;
    }
}
