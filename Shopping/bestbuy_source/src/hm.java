// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.stores.StoreDetailsFragment;
import com.bestbuy.android.api.lib.models.deals.StoreDeals;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class hm extends ka
{

    private static int j = 0;
    private String a;
    private StoreDeals k;

    public hm(Activity activity, BBYBaseFragment bbybasefragment, View view, String s)
    {
        super(activity, bbybasefragment, view);
        a = s;
    }

    public void a()
    {
        k = fs.d(a);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (k == null || k.getCategories().isEmpty())
        {
            c();
        } else
        {
            j = 0;
            if ((i instanceof StoreDetailsFragment) && i.isAdded())
            {
                ((StoreDetailsFragment)i).a(k);
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
        if ((i instanceof StoreDetailsFragment) && i.isAdded())
        {
            ((StoreDetailsFragment)i).b();
        }
    }

    public void d()
    {
        j++;
        (new hm(f, i, g, a)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void e()
    {
        if (g != null)
        {
            g.setVisibility(0);
        }
    }

}
