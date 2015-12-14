// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;


// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            VenusHelper, ay, aq

class b
    implements Runnable
{

    final boolean a;
    final aq b;
    final VenusHelper c;

    public void run()
    {
        (new ay(c, a, null, null, b)).executeOnExecutor(VenusHelper.a(c), new Void[0]);
    }

    _cls9(VenusHelper venushelper, boolean flag, aq aq)
    {
        c = venushelper;
        a = flag;
        b = aq;
        super();
    }
}
