// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import com.cyberlink.youcammakeup.jniproxy.z;
import com.cyberlink.youcammakeup.kernelctrl.j;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            MotionControlHelper

public class ae
{

    final MotionControlHelper a;
    private String b;
    private boolean c;
    private z d;
    private z e;

    public ae(MotionControlHelper motioncontrolhelper)
    {
        a = motioncontrolhelper;
        super();
        b = null;
        c = true;
        d = null;
        e = null;
        b = null;
        c = true;
        d = null;
        e = null;
    }

    public void a(z z)
    {
        if (z != null)
        {
            d = j.a(z);
            return;
        } else
        {
            d = null;
            return;
        }
    }

    public void a(String s)
    {
        b = s;
    }

    public void a(boolean flag)
    {
        c = flag;
    }

    public boolean a()
    {
        return c;
    }

    public z b()
    {
        return j.a(d);
    }

    public void b(z z)
    {
        if (z != null)
        {
            e = j.a(z);
            return;
        } else
        {
            e = null;
            return;
        }
    }

    public z c()
    {
        return j.a(e);
    }

    public boolean d()
    {
        return d == null;
    }

    public boolean e()
    {
        return e == null;
    }
}
