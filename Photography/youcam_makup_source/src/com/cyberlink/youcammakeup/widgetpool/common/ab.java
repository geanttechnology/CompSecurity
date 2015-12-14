// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import com.cyberlink.youcammakeup.jniproxy.bi;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            MotionControlHelper

public class ab
{

    final MotionControlHelper a;
    private String b;
    private bi c;

    public ab(MotionControlHelper motioncontrolhelper)
    {
        a = motioncontrolhelper;
        super();
    }

    public ab(MotionControlHelper motioncontrolhelper, String s, bi bi)
    {
        a = motioncontrolhelper;
        super();
        b = s;
        c = bi;
    }

    static bi a(ab ab1)
    {
        return ab1.c;
    }

    static bi a(ab ab1, bi bi)
    {
        ab1.c = bi;
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
}
