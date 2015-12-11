// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.pdp.PDPSourceDetailFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPSourceProductAvailabilityFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPBuyingOptionsFragment;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.BuyingOptionsResponse;
import com.bestbuy.android.base.BBYBaseFragment;

public class im extends ka
{

    private String a;
    private BuyingOptionsResponse j;

    public im(Activity activity, BBYBaseFragment bbybasefragment, View view, String s)
    {
        super(activity, bbybasefragment);
        a = s;
        g = view;
    }

    public void a()
    {
        j = fs.h(a);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (j == null)
        {
            c();
        } else
        if (j != null)
        {
            if ((i instanceof PDPSourceDetailFragment) && i.isAdded())
            {
                ((PDPSourceDetailFragment)i).a(j);
                return;
            }
            if ((i instanceof PDPSourceProductAvailabilityFragment) && i.isAdded())
            {
                ((PDPSourceProductAvailabilityFragment)i).a(j);
                return;
            }
            if ((i instanceof PLPBuyingOptionsFragment) && i.isAdded())
            {
                ((PLPBuyingOptionsFragment)i).a(j);
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
        (new im(f, i, g, a)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void onPreExecute()
    {
        if (g != null)
        {
            g.setVisibility(0);
        }
    }
}
