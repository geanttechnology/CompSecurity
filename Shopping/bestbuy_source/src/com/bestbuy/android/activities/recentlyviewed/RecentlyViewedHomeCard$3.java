// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.recentlyviewed;

import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import he;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.bestbuy.android.activities.recentlyviewed:
//            RecentlyViewedHomeCard

class a
    implements android.support.v4.view.tener
{

    final RecentlyViewedHomeCard a;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        String s;
label0:
        {
            if (RecentlyViewedHomeCard.b(a) != null && !RecentlyViewedHomeCard.b(a).isEmpty())
            {
                RecentlyViewedHomeCard.c(a).setVisibility(0);
                RecentlyViewedHomeCard.a(a, (BBYProduct)RecentlyViewedHomeCard.b(a).get(i));
                s = (String)RecentlyViewedHomeCard.d(a).get(i);
                RecentlyViewedHomeCard.e(a).setVisibility(8);
                RecentlyViewedHomeCard.f(a).setVisibility(8);
                if (RecentlyViewedHomeCard.g(a) != null)
                {
                    RecentlyViewedHomeCard.g(a).cancel(true);
                }
                if (RecentlyViewedHomeCard.h(a) != null)
                {
                    ((HomeActivity)a.d).sendRecommendations("homeloadrecentlyviewed", "GHP", RecentlyViewedHomeCard.a(a, RecentlyViewedHomeCard.b(a)), RecentlyViewedHomeCard.h(a));
                }
                if (i != 0)
                {
                    break label0;
                }
                RecentlyViewedHomeCard.a(a, RecentlyViewedHomeCard.i(a));
            }
            return;
        }
        RecentlyViewedHomeCard.a(a, new he(a.d, a, s, RecentlyViewedHomeCard.j(a)));
        RecentlyViewedHomeCard.g(a).execute(new Void[0]);
    }

    (RecentlyViewedHomeCard recentlyviewedhomecard)
    {
        a = recentlyviewedhomecard;
        super();
    }
}
