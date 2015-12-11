// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.view.View;
import com.bestbuy.android.api.lib.models.offers.Offer;

// Referenced classes of package com.bestbuy.android.activities.home:
//            GHPBannersHomeCard

class a
    implements android.view.e.GHPBannersHomeCard._cls1
{

    final Offer a;
    final GHPBannersHomeCard b;

    public void onClick(View view)
    {
        b.a(a, GHPBannersHomeCard.a(b));
    }

    (GHPBannersHomeCard ghpbannershomecard, Offer offer)
    {
        b = ghpbannershomecard;
        a = offer;
        super();
    }
}
