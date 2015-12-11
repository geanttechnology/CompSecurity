// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
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
        ((HomeActivity)du.b(b)).openPDP(((DealOfTheDay)du.a(b).get(a)).getSummary().getSkuId(), ((DealOfTheDay)du.a(b).get(a)).getSummary().getProductId(), false);
    }

    >(du du1, int i)
    {
        b = du1;
        a = i;
        super();
    }
}
