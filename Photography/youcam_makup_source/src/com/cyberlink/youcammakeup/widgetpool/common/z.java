// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import com.cyberlink.youcammakeup.jniproxy.bi;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            MotionControlHelper

public class z
{

    final MotionControlHelper a;
    private String b;
    private bi c;
    private bi d;

    public z(MotionControlHelper motioncontrolhelper)
    {
        a = motioncontrolhelper;
        super();
    }

    public z(MotionControlHelper motioncontrolhelper, String s, bi bi, bi bi1)
    {
        a = motioncontrolhelper;
        super();
        b = s;
        c = bi;
        d = bi1;
    }

    static bi a(z z1)
    {
        return z1.c;
    }

    static bi a(z z1, bi bi)
    {
        z1.c = bi;
        return bi;
    }

    static bi b(z z1)
    {
        return z1.d;
    }

    static bi b(z z1, bi bi)
    {
        z1.d = bi;
        return bi;
    }

    public String a()
    {
        return b;
    }

    public void a(bi bi)
    {
        c = bi;
    }

    public void a(String s)
    {
        b = s;
    }

    public bi b()
    {
        return c;
    }

    public void b(bi bi)
    {
        d = bi;
    }

    public bi c()
    {
        return d;
    }
}
