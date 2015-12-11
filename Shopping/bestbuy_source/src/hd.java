// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.pdp.PDPCustomerAlsoBoughtFragment;
import com.bestbuy.android.activities.registry.ScannedItemCustomerAlsoViewedFragment;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class hd extends ka
{

    private static int k = 0;
    private ArrayList a;
    private String j;

    public hd(Activity activity, BBYBaseFragment bbybasefragment, View view, String s)
    {
        super(activity, bbybasefragment);
        g = view;
        j = s;
    }

    public void a()
    {
        a = fs.f(j);
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
            k = 0;
            if ((i instanceof PDPCustomerAlsoBoughtFragment) && i.isAdded())
            {
                ((PDPCustomerAlsoBoughtFragment)i).a(a);
                return;
            }
            if ((i instanceof ScannedItemCustomerAlsoViewedFragment) && i.isAdded())
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
        if ((i instanceof PDPCustomerAlsoBoughtFragment) && i.isAdded())
        {
            ((PDPCustomerAlsoBoughtFragment)i).b();
        }
    }

    public void d()
    {
        k++;
        (new hd(f, i, g, j)).executeOnExecutor(nb.h, new Void[0]);
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
