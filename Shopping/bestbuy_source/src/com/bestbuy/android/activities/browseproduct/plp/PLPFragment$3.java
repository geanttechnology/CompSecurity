// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.plp;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import java.util.ArrayList;
import nb;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.plp:
//            PLPFragment

class a
    implements android.widget.ItemClickListener
{

    final PLPFragment a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        boolean flag1 = true;
        if (PLPFragment.a(a) != null)
        {
            PLPFragment.a(a).setVisibility(8);
        }
        int j = i;
        String s;
        Object obj;
        boolean flag;
        if (PLPFragment.b(a))
        {
            if (i >= 1)
            {
                j = i - 1;
            } else
            {
                j = i;
                if (i == 0)
                {
                    return;
                }
            }
        }
        obj = (BBYProduct)PLPFragment.c(a).get(j);
        if (PLPFragment.d(a))
        {
            if (PLPFragment.e(a).equals("Products"))
            {
                ((HomeActivity)a.d).sendRecommendations("productsclickmostpopular", "product", ((BBYProduct) (obj)));
            } else
            if (PLPFragment.e(a).equals("Cart"))
            {
                ((HomeActivity)a.d).sendRecommendations("cartclickmostpopular", "cart", ((BBYProduct) (obj)));
            }
        }
        ((HomeActivity)a.d).setStoreAvailabilityVisible(false);
        adapterview = nb.a().b().getString("availability_storeid", "");
        view = (HomeActivity)a.d;
        s = ((BBYProduct) (obj)).getSkuId();
        obj = (new StringBuilder()).append("").append(((BBYProduct) (obj)).getSummary().getProductId()).toString();
        flag = flag1;
        if (!PLPFragment.f(a))
        {
            if (PLPFragment.g(a))
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
        }
        view.openPDP(s, adapterview, ((String) (obj)), false, flag);
    }

    (PLPFragment plpfragment)
    {
        a = plpfragment;
        super();
    }
}
