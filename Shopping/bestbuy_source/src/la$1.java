// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Attributes;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Properties;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.HashMap;

class lang.Object
    implements android.view.OnClickListener
{

    final la a;

    public void onClick(View view)
    {
        la.a(a, (String)la.a(a).get("sku"));
        la.a(a, (OverviewResponse)la.a(a).get("Product"));
        la.a(a, ((Boolean)la.a(a).get("isFromDNM")).booleanValue());
        if (la.b(a) != null && la.b(a).getAttributes() != null && la.b(a).getAttributes().isMarketplace() || la.b(a) != null && la.b(a).getCondition() != null && la.b(a).getCondition().equalsIgnoreCase("openbox") || la.b(a).getPriceBlock() != null && la.b(a).getPriceBlock().getProperties() != null && la.b(a).getPriceBlock().getProperties().getContractCondition() != null)
        {
            a.dismiss();
            la.c(a);
            return;
        } else
        {
            a.dismiss();
            nb.a().l(true);
            view = new HashMap();
            view.put("bb.addToList", "1");
            view.put("&&products", (new StringBuilder()).append(";").append(la.d(a)).append(";;;;evar48=PDH-WR").toString());
            lu.b((new StringBuilder()).append(PDPFragment.f()).append("pdp").toString(), view);
            (new iy((HomeActivity)la.e(a), (BBYBaseFragment)la.f(a), la.g(a), la.h(a).getUuid(), la.d(a), la.h(a).getType(), "1")).executeOnExecutor(nb.g, new Void[0]);
            return;
        }
    }

    >(la la1)
    {
        a = la1;
        super();
    }
}
