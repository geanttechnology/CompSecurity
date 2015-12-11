// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.view.View;
import com.bestbuy.android.api.lib.models.offers.Offer;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            LEBannerHomeCard

class a
    implements android.view.r
{

    final Offer a;
    final LEBannerHomeCard b;

    public void onClick(View view)
    {
        b.a(a);
    }

    (LEBannerHomeCard lebannerhomecard, Offer offer)
    {
        b = lebannerhomecard;
        a = offer;
        super();
    }
}
