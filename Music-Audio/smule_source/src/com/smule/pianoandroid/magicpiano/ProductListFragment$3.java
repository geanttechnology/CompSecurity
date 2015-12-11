// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.smule.android.network.models.ListingV2;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListFragment

class a
    implements Runnable
{

    final ListingV2 a;
    final ProductListFragment b;

    public void run()
    {
        if (!a.subscriberOnly)
        {
            ProductListFragment.b(b);
        }
    }

    (ProductListFragment productlistfragment, ListingV2 listingv2)
    {
        b = productlistfragment;
        a = listingv2;
        super();
    }
}
