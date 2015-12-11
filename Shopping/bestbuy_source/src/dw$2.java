// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.bestbuy.android.activities.browseproduct.plp.PLPCustomOffersFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.home.pageconfiguration.SIOffer;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import java.util.List;

class lang.Object
    implements android.view.OnClickListener
{

    final int a;
    final dw b;

    public void onClick(View view)
    {
        if (((SIOffer)dw.a(b).get(a)).getOfferType().equals("customOffer"))
        {
            view = ((SIOffer)dw.a(b).get(a)).getUrl();
            ((PLPCustomOffersFragment)dw.c(b)).a(view);
        } else
        if (((SIOffer)dw.a(b).get(a)).getOfferType().equals("product"))
        {
            ((HomeActivity)dw.b(b)).openPDP(((SIOffer)dw.a(b).get(a)).getSummary().getSkuId(), ((SIOffer)dw.a(b).get(a)).getSummary().getProductId(), false);
            return;
        }
    }

    >(dw dw1, int i)
    {
        b = dw1;
        a = i;
        super();
    }
}
