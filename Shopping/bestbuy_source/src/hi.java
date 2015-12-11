// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.pdp.PDPReviewsListFragment;
import com.bestbuy.android.api.lib.models.pdpreviews.ReviewsResponse;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class hi extends ka
{

    private static int j = 0;
    private String a;
    private int k;
    private int l;
    private String m;
    private ReviewsResponse n;

    public hi(Activity activity, BBYBaseFragment bbybasefragment, View view, String s, int i, int i1, String s1)
    {
        super(activity, bbybasefragment);
        g = view;
        a = s;
        k = i;
        l = i1;
        m = s1;
    }

    public void a()
    {
        n = fs.a(a, l, k, m);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (n.getResults() == null || n.getResults() != null && n.getResults().isEmpty())
        {
            c();
        } else
        {
            j = 0;
            if ((i instanceof PDPReviewsListFragment) && i.isAdded())
            {
                ((PDPReviewsListFragment)i).a(n);
                return;
            }
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
    }

    public void d()
    {
        j++;
        (new hi(f, i, g, a, k, l, m)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void e()
    {
        if (g != null)
        {
            g.setVisibility(0);
        }
    }

}
