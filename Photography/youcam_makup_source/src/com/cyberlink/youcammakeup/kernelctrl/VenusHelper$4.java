// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;


// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            VenusHelper, au, aq

class a
    implements Runnable
{

    final aq a;
    final VenusHelper b;

    public void run()
    {
        (new au(b, a)).executeOnExecutor(VenusHelper.a(b), new Void[0]);
    }

    _cls9(VenusHelper venushelper, aq aq)
    {
        b = venushelper;
        a = aq;
        super();
    }
}
