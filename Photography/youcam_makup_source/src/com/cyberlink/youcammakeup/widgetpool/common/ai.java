// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;


// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            MotionControlHelper

public class ai
{

    boolean a;
    int b;
    final MotionControlHelper c;

    public ai(MotionControlHelper motioncontrolhelper)
    {
        c = motioncontrolhelper;
        super();
        a = false;
        b = 0;
        a = false;
        b = 0;
    }

    public void a(int i)
    {
        b = i;
    }

    public void a(boolean flag)
    {
        a = flag;
    }

    public boolean a()
    {
        return a;
    }

    public int b()
    {
        return b;
    }
}
