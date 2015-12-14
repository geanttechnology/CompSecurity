// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import com.cyberlink.youcammakeup.utility.aw;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            VenusHelper, ap, aq

class b
    implements Runnable
{

    final aw a;
    final aq b;
    final VenusHelper c;

    public void run()
    {
        (new ap(c, a, b)).executeOnExecutor(VenusHelper.a(c), new Void[0]);
    }

    _cls9(VenusHelper venushelper, aw aw, aq aq)
    {
        c = venushelper;
        a = aw;
        b = aq;
        super();
    }
}
