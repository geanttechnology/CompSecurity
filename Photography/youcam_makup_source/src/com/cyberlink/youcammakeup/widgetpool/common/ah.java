// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import com.cyberlink.youcammakeup.jniproxy.bi;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            MotionControlHelper

public class ah
{

    final MotionControlHelper a;
    private String b;
    private String c;
    private bi d;

    public ah(MotionControlHelper motioncontrolhelper)
    {
        a = motioncontrolhelper;
        super();
    }

    public ah(MotionControlHelper motioncontrolhelper, String s, String s1, bi bi)
    {
        a = motioncontrolhelper;
        super();
        b = s;
        c = s1;
        d = bi;
    }

    static bi a(ah ah1)
    {
        return ah1.d;
    }

    static bi a(ah ah1, bi bi)
    {
        ah1.d = bi;
        return bi;
    }

    public String a()
    {
        return b;
    }

    public void a(bi bi)
    {
        d = bi;
    }

    public void a(String s)
    {
        b = s;
    }

    public String b()
    {
        return c;
    }

    public void b(String s)
    {
        c = s;
    }

    public bi c()
    {
        return d;
    }
}
