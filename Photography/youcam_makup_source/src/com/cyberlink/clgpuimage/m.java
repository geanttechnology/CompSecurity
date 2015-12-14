// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;


// Referenced classes of package com.cyberlink.clgpuimage:
//            CLMakeupLiveFilter

class m
{

    final CLMakeupLiveFilter a;
    private boolean b;
    private boolean c[];
    private CLMakeupLiveFilter.CaptureFrameType d;

    private m(CLMakeupLiveFilter clmakeuplivefilter)
    {
        a = clmakeuplivefilter;
        super();
        c = new boolean[CLMakeupLiveFilter.MakeupLiveFeatures.values().length];
        d = CLMakeupLiveFilter.CaptureFrameType.a;
    }

    m(CLMakeupLiveFilter clmakeuplivefilter, CLMakeupLiveFilter._cls1 _pcls1)
    {
        this(clmakeuplivefilter);
    }

    static CLMakeupLiveFilter.CaptureFrameType a(m m1, CLMakeupLiveFilter.CaptureFrameType captureframetype)
    {
        m1.d = captureframetype;
        return captureframetype;
    }

    static boolean a(m m1, boolean flag)
    {
        m1.b = flag;
        return flag;
    }

    static boolean[] a(m m1)
    {
        return m1.c;
    }

    static boolean[] a(m m1, boolean aflag[])
    {
        m1.c = aflag;
        return aflag;
    }

    static boolean b(m m1)
    {
        return m1.b;
    }

    static CLMakeupLiveFilter.CaptureFrameType c(m m1)
    {
        return m1.d;
    }
}
