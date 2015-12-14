// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;


// Referenced classes of package com.applovin.impl.adview:
//            AdViewControllerImpl, o, a

class f
    implements Runnable
{

    final AdViewControllerImpl a;

    private f(AdViewControllerImpl adviewcontrollerimpl)
    {
        a = adviewcontrollerimpl;
        super();
    }

    f(AdViewControllerImpl adviewcontrollerimpl, a a1)
    {
        this(adviewcontrollerimpl);
    }

    public void run()
    {
        AdViewControllerImpl.c(a).setVisibility(8);
    }
}
