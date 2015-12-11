// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.location.Address;
import android.view.View;
import android.widget.LinearLayout;
import com.bestbuy.android.activities.browseproduct.ProductAvailabilityFragment;
import com.bestbuy.android.activities.dnm.DNMListFragment;
import com.bestbuy.android.activities.dnm.DNMSearchFragment;
import com.bestbuy.android.activities.registry.WeddingAddressFragment;
import com.bestbuy.android.base.BBYBaseFragment;

public class ip extends ka
{

    private static int k = 0;
    private Address a;
    private String j;
    private LinearLayout l;
    private double m;
    private double n;

    public ip(Activity activity, BBYBaseFragment bbybasefragment, View view, double d1, double d2)
    {
        super(activity, bbybasefragment);
        g = view;
        m = d1;
        n = d2;
    }

    public ip(Activity activity, BBYBaseFragment bbybasefragment, View view, String s)
    {
        super(activity, bbybasefragment);
        g = view;
        j = s;
    }

    public ip(Activity activity, BBYBaseFragment bbybasefragment, View view, String s, LinearLayout linearlayout)
    {
        super(activity, bbybasefragment);
        g = view;
        j = s;
        l = linearlayout;
    }

    public void a()
    {
        if (m != 0.0D && n != 0.0D)
        {
            a = fs.a(f, m, n);
            return;
        } else
        {
            a = fs.b(f, j);
            return;
        }
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (a == null)
        {
            c();
        } else
        {
            k = 0;
            if (i instanceof DNMSearchFragment)
            {
                ((DNMSearchFragment)i).a(j, a);
                return;
            }
            if (i instanceof DNMListFragment)
            {
                ((DNMListFragment)i).a(j, a);
                return;
            }
            if (i instanceof ProductAvailabilityFragment)
            {
                ((ProductAvailabilityFragment)i).a(Double.valueOf(a.getLatitude()), Double.valueOf(a.getLongitude()));
                return;
            }
            if (i instanceof WeddingAddressFragment)
            {
                ((WeddingAddressFragment)i).a(a);
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
        if (i instanceof ProductAvailabilityFragment)
        {
            ((ProductAvailabilityFragment)i).b(j);
        } else
        if (!(i instanceof WeddingAddressFragment))
        {
            l.setVisibility(0);
            ll.b(l);
            return;
        }
    }

    public void d()
    {
        k++;
        if (m != 0.0D && n != 0.0D)
        {
            (new ip(f, i, g, m, n)).executeOnExecutor(nb.h, new Void[0]);
            return;
        }
        if (l != null)
        {
            (new ip(f, i, g, j, l)).executeOnExecutor(nb.h, new Void[0]);
            return;
        } else
        {
            (new ip(f, i, g, j)).executeOnExecutor(nb.h, new Void[0]);
            return;
        }
    }

    public void e()
    {
        if (g != null)
        {
            g.setVisibility(0);
        }
    }

}
