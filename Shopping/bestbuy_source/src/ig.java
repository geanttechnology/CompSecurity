// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.pdp.PDPReviewsListFragment;
import com.bestbuy.android.api.lib.models.pdpfeaturereviews.FeatureReviewsResponse;
import com.bestbuy.android.base.BBYBaseFragment;

public class ig extends ka
{

    private String a;
    private String j;
    private int k;
    private FeatureReviewsResponse l;
    private View m;
    private String n;

    public ig(Activity activity, BBYBaseFragment bbybasefragment, View view, String s, String s1, int i, String s2)
    {
        super(activity, bbybasefragment);
        a = s;
        j = s1;
        k = i;
        m = view;
        n = s2;
    }

    public void a()
    {
        l = fs.a(a, j, k, n);
    }

    public void b()
    {
        if (m != null)
        {
            m.setVisibility(8);
        }
        if ((i instanceof PDPReviewsListFragment) && i.isAdded())
        {
            ((PDPReviewsListFragment)i).a(l);
        }
    }

    public void c()
    {
        if (m != null)
        {
            m.setVisibility(8);
        }
    }

    public void e()
    {
        if (m != null)
        {
            m.setVisibility(0);
        }
    }
}
