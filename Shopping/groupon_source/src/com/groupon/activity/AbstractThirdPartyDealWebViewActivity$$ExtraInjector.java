// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            AbstractThirdPartyDealWebViewActivity

public class 
{

    public static void inject(com.f2prateek.dart.r r, AbstractThirdPartyDealWebViewActivity abstractthirdpartydealwebviewactivity, Object obj)
    {
        r = ((com.f2prateek.dart.r) (r.r(obj, "linkout_deal_url")));
        if (r == null)
        {
            throw new IllegalStateException("Required extra with key 'linkout_deal_url' for field 'url' was not found. If this extra is optional add '@Optional' annotation.");
        } else
        {
            abstractthirdpartydealwebviewactivity.url = (String)r;
            return;
        }
    }

    public ()
    {
    }
}
