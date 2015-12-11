// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.recentlyviewed.RecentlyViewedHomeCard;
import com.bestbuy.android.activities.registry.RecentlyViewedListCard;
import com.bestbuy.android.api.lib.models.home.Recommendation;
import com.bestbuy.android.api.lib.models.home.recentlyviewed.RecentlyViewedAlsoViewed;
import com.bestbuy.android.api.lib.models.home.recentlyviewed.RecentlyViewedAlsoViewedRecommendations;
import com.bestbuy.android.api.lib.models.home.recentlyviewed.RecentlyViewedAlsoViewedResponse;
import com.bestbuy.android.api.lib.models.home.recentlyviewed.RecentlyViewedData;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.List;

public class hk extends ka
{

    private static int a = 0;
    private Recommendation j;
    private RecentlyViewedAlsoViewedResponse k;

    public hk(Activity activity, BBYBaseFragment bbybasefragment, View view, Recommendation recommendation)
    {
        super(activity, bbybasefragment);
        g = view;
        j = recommendation;
    }

    static int a(int i)
    {
        a = i;
        return i;
    }

    static BBYBaseFragment a(hk hk1)
    {
        return hk1.i;
    }

    static BBYBaseFragment b(hk hk1)
    {
        return hk1.i;
    }

    static BBYBaseFragment c(hk hk1)
    {
        return hk1.i;
    }

    static BBYBaseFragment d(hk hk1)
    {
        return hk1.i;
    }

    static BBYBaseFragment e(hk hk1)
    {
        return hk1.i;
    }

    public void a()
    {
        k = fs.a(f, j);
    }

    public void b()
    {
        a = 0;
        if (!i.isDetached())
        {
            if (k == null || k.getSi() == null || k.getSi().getResponse() == null || k.getSi().getResponse().getRecommendations() == null || k.getSi().getResponse().getRecommendations().getSkus() == null || k.getSi().getResponse().getRecommendations().getSkus().size() == 0)
            {
                if ((i instanceof RecentlyViewedHomeCard) && i.isAdded())
                {
                    ((RecentlyViewedHomeCard)i).b();
                }
            } else
            if ((i instanceof RecentlyViewedHomeCard) && i.isAdded())
            {
                ((RecentlyViewedHomeCard)i).a(k);
                return;
            }
        }
    }

    public void c()
    {
        nm.a(f, new no() {

            final hk a;

            public void a()
            {
                a.d();
            }

            
            {
                a = hk.this;
                super();
            }
        }, new nn() {

            final hk a;

            public void a()
            {
                hk.a(0);
                if (!hk.a(a).isDetached())
                {
                    if (hk.b(a) instanceof RecentlyViewedHomeCard)
                    {
                        ((RecentlyViewedHomeCard)hk.c(a)).b();
                    } else
                    if (hk.d(a) instanceof RecentlyViewedListCard)
                    {
                        ((RecentlyViewedListCard)hk.e(a)).b();
                        return;
                    }
                }
            }

            
            {
                a = hk.this;
                super();
            }
        }, e, a);
    }

    public void d()
    {
        a++;
        (new hk(f, i, g, j)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void e()
    {
        if (g != null)
        {
            g.setVisibility(0);
        }
        k = new RecentlyViewedAlsoViewedResponse();
    }

}
