// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.AdapterView;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Attributes;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;
import java.util.HashMap;

class lang.Object
    implements android.widget.erView.OnItemClickListener
{

    final la a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        int j = 0;
        while (j < la.i(a).size()) 
        {
            if (la.j(a)[i].equals(((RegistryWishList)la.i(a).get(j)).getUuid()))
            {
                la.a(a, (String)la.a(a).get("sku"));
                la.k(a).put(la.j(a)[i], la.d(a));
                la.a(a, (OverviewResponse)la.a(a).get("Product"));
                la.a(a, ((Boolean)la.a(a).get("isFromDNM")).booleanValue());
                if (la.b(a) != null && la.b(a).getAttributes() != null && la.b(a).getAttributes().isMarketplace() || la.l(a))
                {
                    a.dismiss();
                    la.c(a);
                } else
                {
                    a.dismiss();
                    nb.a().j(true);
                    adapterview = new HashMap();
                    adapterview.put("bb.addToList", "1");
                    adapterview.put("&&products", (new StringBuilder()).append(";").append(la.d(a)).append(";;;;evar48=PDH-WL").toString());
                    lu.b((new StringBuilder()).append(PDPFragment.f()).append("pdp").toString(), adapterview);
                    (new iy((HomeActivity)la.e(a), (BBYBaseFragment)la.f(a), la.g(a), la.j(a)[i], la.d(a), ((RegistryWishList)la.i(a).get(j)).getType(), "1")).executeOnExecutor(nb.g, new Void[0]);
                }
            }
            j++;
        }
    }

    >(la la1)
    {
        a = la1;
        super();
    }
}
