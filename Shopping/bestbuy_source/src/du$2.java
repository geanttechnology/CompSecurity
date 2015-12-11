// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import com.bestbuy.android.activities.home.DODHomeCard;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.home.DealOfTheDay;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import java.util.List;

class lang.Object
    implements android.view.OnClickListener
{

    final int a;
    final du b;

    public void onClick(View view)
    {
        if (du.c(b))
        {
            view = nb.a().c();
            if (!view.getBoolean(du.b(b).getString(0x7f08003e), false) && !view.getBoolean(du.b(b).getString(0x7f08004c), false))
            {
                int i = view.getInt(du.b(b).getString(0x7f080086), 1);
                if (i >= 10)
                {
                    (new kt(du.b(b), ku.a)).a();
                } else
                {
                    view = view.edit();
                    view.putInt(du.b(b).getString(0x7f080086), i + 1);
                    view.commit();
                }
            }
            if (((DealOfTheDay)du.a(b).get(a)).getOfferType().equals("customOffer"))
            {
                view = ((DealOfTheDay)du.a(b).get(a)).getUrl();
                du.d(b).a(view);
            } else
            if (((DealOfTheDay)du.a(b).get(a)).getOfferType().equals("product"))
            {
                ((HomeActivity)du.b(b)).openPDP(((DealOfTheDay)du.a(b).get(a)).getSummary().getSkuId(), ((DealOfTheDay)du.a(b).get(a)).getSummary().getProductId(), false);
                return;
            }
        }
    }

    >(du du1, int i)
    {
        b = du1;
        a = i;
        super();
    }
}
