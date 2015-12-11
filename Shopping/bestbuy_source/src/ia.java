// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.pdp.PDPAccessoriesFragment;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdpaccessories.AccessoriesResponse;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class ia extends ka
{

    private String a;
    private OverviewResponse j;
    private ArrayList k;
    private AccessoriesResponse l;

    public ia(Activity activity, BBYBaseFragment bbybasefragment, View view, OverviewResponse overviewresponse)
    {
        super(activity, bbybasefragment);
        j = overviewresponse;
        a = j.getSkuId();
        g = view;
    }

    public void a()
    {
        l = fs.m(a);
        if (l.getSuggestedAccessories() != null)
        {
            k = l.getSuggestedAccessories();
        }
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (k == null || k != null && k.isEmpty())
        {
            c();
        } else
        if (i instanceof PDPAccessoriesFragment)
        {
            ((PDPAccessoriesFragment)i).a(k);
            return;
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if ((i instanceof PDPAccessoriesFragment) && i.isAdded())
        {
            ((PDPAccessoriesFragment)i).b();
        }
    }

    public void d()
    {
        (new ia(f, i, g, j)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void onPreExecute()
    {
        if (g != null)
        {
            g.setVisibility(0);
        }
    }
}
