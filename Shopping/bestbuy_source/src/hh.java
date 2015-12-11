// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.plp.PLPCustomOffersFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.registry.ScannedItemActivity;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class hh extends ka
{

    private ArrayList a;
    private String j;
    private int k;

    public hh(Activity activity, BBYBaseFragment bbybasefragment, View view, String s)
    {
        super(activity, bbybasefragment);
        k = 0;
        g = view;
        j = s;
    }

    static Activity a(hh hh1)
    {
        return hh1.f;
    }

    static Activity b(hh hh1)
    {
        return hh1.f;
    }

    static Activity c(hh hh1)
    {
        return hh1.f;
    }

    static Activity d(hh hh1)
    {
        return hh1.f;
    }

    public void a()
    {
        a = gq.i(j);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if ((i instanceof PLPCustomOffersFragment) && i.isAdded())
        {
            ((PLPCustomOffersFragment)i).a(a, true);
        }
    }

    public void c()
    {
        super.c();
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(f, new no() {

            final hh a;

            public void a()
            {
                a.d();
            }

            
            {
                a = hh.this;
                super();
            }
        }, new nn() {

            final hh a;

            public void a()
            {
                if (hh.a(a) instanceof HomeActivity)
                {
                    ((HomeActivity)hh.b(a)).onBackPressed();
                } else
                if (hh.c(a) instanceof ScannedItemActivity)
                {
                    ((ScannedItemActivity)hh.d(a)).onBackPressed();
                    return;
                }
            }

            
            {
                a = hh.this;
                super();
            }
        }, e, k);
    }

    public void d()
    {
        k = k + 1;
        (new hh(f, i, g, j)).executeOnExecutor(nb.h, new Void[0]);
    }
}
