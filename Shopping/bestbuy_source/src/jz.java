// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.plpstoreavailability.PLPStoreSelectionActivity;
import com.bestbuy.android.activities.stores.StoreSearchMapFragment;
import com.bestbuy.android.activities.stores.StoreTabContainer;
import com.bestbuy.android.api.lib.models.remix.StoreList;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class jz extends ka
{

    private static int l = 0;
    private StoreList a;
    private double j;
    private double k;
    private int m;
    private int n;

    public jz(Activity activity, BBYBaseFragment bbybasefragment, View view, double d1, double d2, 
            int i, int i1)
    {
        super(activity, bbybasefragment);
        g = view;
        j = d1;
        k = d2;
        m = i;
        n = i1;
    }

    static int a(int i)
    {
        l = i;
        return i;
    }

    static BBYBaseFragment a(jz jz1)
    {
        return jz1.i;
    }

    public void a()
    {
        a = fs.a(f, j, k, null, m, 10);
    }

    public void b()
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        if (i == null || !(i instanceof StoreSearchMapFragment) || !i.isAdded()) goto _L4; else goto _L3
_L3:
        c();
_L11:
        return;
_L4:
        if (f instanceof PLPStoreSelectionActivity)
        {
            ((PLPStoreSelectionActivity)f).a();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (a.getStores() != null && !a.getStores().isEmpty())
        {
            break; /* Loop/switch isn't completed */
        }
        if (m != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (n == 248) goto _L6; else goto _L5
_L5:
        if (n != 50) goto _L8; else goto _L7
_L7:
        n = 75;
_L9:
        (new jz(f, i, g, j, k, m, n)).executeOnExecutor(nb.h, new Void[0]);
        return;
_L8:
        if (n == 75)
        {
            n = 248;
        }
        if (true) goto _L9; else goto _L6
_L6:
        if (i != null && (i instanceof StoreSearchMapFragment) && i.isAdded())
        {
            c();
            return;
        }
        if (f instanceof PLPStoreSelectionActivity)
        {
            ((PLPStoreSelectionActivity)f).a();
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (a.getStores() == null || !a.getStores().isEmpty()) goto _L11; else goto _L10
_L10:
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (i != null && (i instanceof StoreSearchMapFragment) && i.isAdded())
        {
            ((StoreSearchMapFragment)i).d();
            return;
        }
        if (true) goto _L11; else goto _L12
_L12:
        l = 0;
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (i != null && (i instanceof StoreSearchMapFragment) && i.isAdded())
        {
            ((StoreSearchMapFragment)i).a(a);
            return;
        }
        if (f instanceof PLPStoreSelectionActivity)
        {
            ((PLPStoreSelectionActivity)f).a(a.getStores(), a.isHasNext());
            return;
        }
        if (true) goto _L11; else goto _L13
_L13:
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(f, new no() {

            final jz a;

            public void a()
            {
                a.d();
            }

            
            {
                a = jz.this;
                super();
            }
        }, new nn() {

            final jz a;

            public void a()
            {
                jz.a(0);
                Fragment fragment = jz.a(a).getParentFragment();
                if (fragment instanceof StoreTabContainer)
                {
                    ((HomeTabFragment)fragment.getParentFragment()).b().setCurrentTab(0);
                }
            }

            
            {
                a = jz.this;
                super();
            }
        }, e, l);
    }

    public void d()
    {
        l++;
        (new jz(f, i, g, j, k, m, n)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void e()
    {
        if (g != null)
        {
            g.setVisibility(0);
        }
    }

}
