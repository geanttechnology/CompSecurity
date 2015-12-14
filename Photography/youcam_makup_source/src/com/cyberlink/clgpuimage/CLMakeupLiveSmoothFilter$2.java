// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;


// Referenced classes of package com.cyberlink.clgpuimage:
//            CLMakeupLiveSmoothFilter

class a
    implements Runnable
{

    final float a;
    final CLMakeupLiveSmoothFilter b;

    public void run()
    {
        b.a(b.i, a);
    }

    _cls9(CLMakeupLiveSmoothFilter clmakeuplivesmoothfilter, float f)
    {
        b = clmakeuplivesmoothfilter;
        a = f;
        super();
    }
}
