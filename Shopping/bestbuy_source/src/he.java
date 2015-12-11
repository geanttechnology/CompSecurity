// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.pdp.PDPCustomerAlsoViewedFragment;
import com.bestbuy.android.activities.recentlyviewed.RecentlyViewedHomeCard;
import com.bestbuy.android.activities.registry.ScannedItemCustomerAlsoViewedFragment;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class he extends ka
{

    private static int l = 0;
    private ArrayList a;
    private String j;
    private String k;

    public he(Activity activity, BBYBaseFragment bbybasefragment, View view, String s)
    {
        super(activity, bbybasefragment, view);
        j = s;
    }

    public he(Activity activity, BBYBaseFragment bbybasefragment, String s, View view)
    {
        super(activity, bbybasefragment, view);
        k = s;
    }

    public void a()
    {
        if (j != null && !j.isEmpty())
        {
            a = fs.e(j);
        } else
        if (k != null)
        {
            a = fs.g(k);
            return;
        }
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (a == null || a != null && a.isEmpty())
        {
            c();
        } else
        {
            l = 0;
            if (i instanceof RecentlyViewedHomeCard)
            {
                ((RecentlyViewedHomeCard)i).b(a);
                return;
            }
            if (i instanceof PDPCustomerAlsoViewedFragment)
            {
                ((PDPCustomerAlsoViewedFragment)i).a(a);
                return;
            }
            if ((i instanceof ScannedItemCustomerAlsoViewedFragment) && i.isVisible())
            {
                ((ScannedItemCustomerAlsoViewedFragment)i).a(a);
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
        l = 0;
        if ((i instanceof RecentlyViewedHomeCard) && i.isVisible())
        {
            ((RecentlyViewedHomeCard)i).b(a);
        } else
        if ((i instanceof PDPCustomerAlsoViewedFragment) && i.isVisible())
        {
            ((PDPCustomerAlsoViewedFragment)i).b();
            return;
        }
    }

    public void d()
    {
        l++;
        (new he(f, i, g, j)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void onPreExecute()
    {
        if (g != null)
        {
            g.setVisibility(0);
        }
        a = new ArrayList();
    }

}
