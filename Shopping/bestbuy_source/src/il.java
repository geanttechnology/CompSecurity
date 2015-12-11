// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.pdp.PDPRequiredAccessoriesFragment;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdpaccessories.AccessoriesResponse;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class il extends ka
{

    private String a;
    private ArrayList j;
    private OverviewResponse k;
    private AccessoriesResponse l;

    public il(Activity activity, BBYBaseFragment bbybasefragment, View view, OverviewResponse overviewresponse)
    {
        super(activity, bbybasefragment);
        k = overviewresponse;
        a = overviewresponse.getSkuId();
        g = view;
    }

    public void a()
    {
        l = fs.m(a);
        if (l.getRequiredAccessories() != null)
        {
            j = l.getRequiredAccessories();
        }
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (j == null || j != null && j.isEmpty())
        {
            c();
        } else
        if ((i instanceof PDPRequiredAccessoriesFragment) && i.isAdded())
        {
            ((PDPRequiredAccessoriesFragment)i).a(j);
            return;
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
        (new il(f, i, g, k)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void onPreExecute()
    {
        if (g != null)
        {
            g.setVisibility(0);
        }
    }
}
