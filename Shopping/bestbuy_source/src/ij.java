// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.ProductAvailabilityFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPAvailabilityFragment;
import com.bestbuy.android.api.lib.models.remix.StoreList;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class ij extends ka
{

    private static int l = 0;
    private String a;
    private double j;
    private double k;
    private ArrayList m;

    public ij(Activity activity, BBYBaseFragment bbybasefragment, View view, double d, double d1, 
            String s)
    {
        super(activity, bbybasefragment, view);
        m = null;
        a = s;
        j = d;
        k = d1;
    }

    public void a()
    {
        m = fs.a(f, j, k, a, 1, 25).getStores();
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        l = 0;
        if (m != null)
        {
            while ((i instanceof PDPAvailabilityFragment) && i.isAdded() || !(i instanceof ProductAvailabilityFragment) || !i.isAdded()) 
            {
                return;
            }
            ((ProductAvailabilityFragment)i).a(m);
            return;
        } else
        {
            c();
            return;
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        while ((i instanceof PDPAvailabilityFragment) && i.isAdded() || !(i instanceof ProductAvailabilityFragment) || !i.isAdded()) 
        {
            return;
        }
        ((ProductAvailabilityFragment)i).a("that location");
    }

    public void onPreExecute()
    {
        super.onPreExecute();
        if (g != null)
        {
            g.setVisibility(0);
        }
    }

}
