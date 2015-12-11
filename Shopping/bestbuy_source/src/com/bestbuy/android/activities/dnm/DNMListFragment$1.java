// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.dnm;

import android.view.View;
import android.widget.AdapterView;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.dnm.DNMProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.activities.dnm:
//            DNMListFragment, DNMSubListFragment, DNMListFragmentContainer

class a
    implements android.widget.ClickListener
{

    final DNMListFragment a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
label0:
        {
            if (i > 0)
            {
                adapterview = (DNMProduct)DNMListFragment.a(a).get(i - 1);
                if (adapterview.getNoOfStoresItemAvlbl() <= 1)
                {
                    break label0;
                }
                adapterview = new DNMSubListFragment((BBYProduct)DNMListFragment.b(a).get(i - 1), DNMListFragment.c(a), DNMListFragment.d(a), DNMListFragment.e(a), DNMListFragment.f(a), adapterview.getNoOfStoresItemAvlbl(), DNMListFragment.g(a), DNMListFragment.h(a), DNMListFragment.i(a));
                ((DNMListFragmentContainer)a.getParentFragment()).a(adapterview, true);
            }
            return;
        }
        ((HomeActivity)DNMListFragment.j(a)).openPDP(adapterview.getSkuId(), "", adapterview.getProductId(), true, adapterview, false, false, false, "");
    }

    tainer(DNMListFragment dnmlistfragment)
    {
        a = dnmlistfragment;
        super();
    }
}
