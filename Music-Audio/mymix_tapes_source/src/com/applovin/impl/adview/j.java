// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;


// Referenced classes of package com.applovin.impl.adview:
//            AdViewControllerImpl, o, a

class j
    implements Runnable
{

    final AdViewControllerImpl a;

    private j(AdViewControllerImpl adviewcontrollerimpl)
    {
        a = adviewcontrollerimpl;
        super();
    }

    j(AdViewControllerImpl adviewcontrollerimpl, a a1)
    {
        this(adviewcontrollerimpl);
    }

    public void run()
    {
        try
        {
            AdViewControllerImpl.c(a).loadDataWithBaseURL("/", "<html></html>", "text/html", null, "");
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }
}
