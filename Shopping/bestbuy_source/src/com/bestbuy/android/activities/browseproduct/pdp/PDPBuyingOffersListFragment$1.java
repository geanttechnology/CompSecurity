// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.api.lib.models.product.ProductOffer;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPBuyingOffersListFragment

class a
    implements android.widget.r
{

    final PDPBuyingOffersListFragment a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (ProductOffer)PDPBuyingOffersListFragment.a(a).get(i);
        adapterview = (new StringBuilder()).append("http://www.bestbuy.com/").append(adapterview.getUrl()).toString();
        view = new MdotWebFragment();
        Bundle bundle = new Bundle();
        bundle.putString(a.getResources().getString(0x7f080055), adapterview);
        view.setArguments(bundle);
        PDPBuyingOffersListFragment.a(a, view);
    }

    (PDPBuyingOffersListFragment pdpbuyingofferslistfragment)
    {
        a = pdpbuyingofferslistfragment;
        super();
    }
}
