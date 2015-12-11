// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.home.HomeTabContainer;
import com.bestbuy.android.activities.mybby.MyBBYDetailedReceipt;
import com.bestbuy.android.activities.stores.StoreDetailsFragment;
import com.bestbuy.android.api.lib.models.remix.Store;
import com.bestbuy.android.base.BBYBaseFragment;

public class jx extends ka
{

    private static int k = 0;
    private String a;
    private Store j;

    public jx(Activity activity, BBYBaseFragment bbybasefragment, View view, String s)
    {
        super(activity, bbybasefragment);
        g = view;
        a = s;
    }

    static int a(int i)
    {
        k = i;
        return i;
    }

    static BBYBaseFragment a(jx jx1)
    {
        return jx1.i;
    }

    public void a()
    {
        j = fs.c(a);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        k = 0;
        if ((i instanceof MyBBYDetailedReceipt) && i.isAdded())
        {
            ((MyBBYDetailedReceipt)i).a(j);
        } else
        {
            if ((i instanceof StoreDetailsFragment) && i.isAdded())
            {
                ((StoreDetailsFragment)i).a(j);
                return;
            }
            if ((i instanceof PLPFragment) && i.isAdded())
            {
                ((PLPFragment)i).a(j);
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
        nm.a(f, new no() {

            final jx a;

            public void a()
            {
                a.d();
            }

            
            {
                a = jx.this;
                super();
            }
        }, new nn() {

            final jx a;

            public void a()
            {
                jx.a(0);
                android.support.v4.app.Fragment fragment = jx.a(a).getParentFragment();
                if (fragment instanceof HomeTabContainer)
                {
                    ((BaseTabContainer)fragment).a("STORES");
                }
            }

            
            {
                a = jx.this;
                super();
            }
        }, e, k);
    }

    public void d()
    {
        k++;
        (new jx(f, i, g, a)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void e()
    {
        if (g != null)
        {
            g.setVisibility(0);
        }
    }

}
