// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import com.cyberlink.youcammakeup.jniproxy.z;
import com.cyberlink.youcammakeup.kernelctrl.j;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            MotionControlHelper

public class aa
{

    final MotionControlHelper a;
    private boolean b;
    private z c;
    private z d;

    public aa(MotionControlHelper motioncontrolhelper)
    {
        a = motioncontrolhelper;
        super();
        b = true;
        c = null;
        d = null;
        b = true;
        c = new z();
        d = new z();
    }

    public void a(z z1)
    {
        c = j.a(z1);
    }

    public void a(boolean flag)
    {
        b = flag;
    }

    public boolean a()
    {
        return b;
    }

    public z b()
    {
        return j.a(c);
    }

    public void b(z z1)
    {
        d = j.a(z1);
    }

    public z c()
    {
        return j.a(d);
    }
}
