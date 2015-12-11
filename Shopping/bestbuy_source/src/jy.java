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

public class jy extends ka
{

    private static int l = 0;
    private StoreList a;
    private int j;
    private String k;
    private int m;
    private Activity n;

    public jy(Activity activity, BBYBaseFragment bbybasefragment, View view, String s, int i, int i1)
    {
        super(activity, bbybasefragment);
        n = activity;
        k = s;
        g = view;
        j = i;
        m = i1;
    }

    static int a(int i)
    {
        l = i;
        return i;
    }

    static BBYBaseFragment a(jy jy1)
    {
        return jy1.i;
    }

    public void a()
    {
        if (!nr.c(k))
        {
            a = fs.a(n, k, null, j, 10);
            return;
        } else
        {
            a = fs.a(k, null, j, 10);
            return;
        }
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (a != null) goto _L2; else goto _L1
_L1:
        if (i == null || !(i instanceof StoreSearchMapFragment) || !i.isAdded()) goto _L4; else goto _L3
_L3:
        ((StoreSearchMapFragment)i).e();
_L11:
        return;
_L4:
        if (n instanceof PLPStoreSelectionActivity)
        {
            ((PLPStoreSelectionActivity)n).a();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (a.getStores() != null && !a.getStores().isEmpty())
        {
            break; /* Loop/switch isn't completed */
        }
        if (j != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (m == 248) goto _L6; else goto _L5
_L5:
        if (m != 50) goto _L8; else goto _L7
_L7:
        m = 75;
_L9:
        (new jy(n, i, g, k, j, m)).executeOnExecutor(nb.h, new Void[0]);
        return;
_L8:
        if (m == 75)
        {
            m = 248;
        }
        if (true) goto _L9; else goto _L6
_L6:
        if (i != null && (i instanceof StoreSearchMapFragment) && i.isAdded())
        {
            ((StoreSearchMapFragment)i).e();
            return;
        }
        if (n instanceof PLPStoreSelectionActivity)
        {
            ((PLPStoreSelectionActivity)n).a();
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
        if (i != null && (i instanceof StoreSearchMapFragment) && i.isAdded())
        {
            ((StoreSearchMapFragment)i).a(a);
            return;
        }
        if (n instanceof PLPStoreSelectionActivity)
        {
            ((PLPStoreSelectionActivity)n).a(a.getStores(), a.isHasNext());
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
        if (n instanceof PLPStoreSelectionActivity)
        {
            ((PLPStoreSelectionActivity)n).a();
            return;
        } else
        {
            nm.a(n, new no() {

                final jy a;

                public void a()
                {
                    a.d();
                }

            
            {
                a = jy.this;
                super();
            }
            }, new nn() {

                final jy a;

                public void a()
                {
                    jy.a(0);
                    Fragment fragment = jy.a(a).getParentFragment();
                    if (fragment instanceof StoreTabContainer)
                    {
                        ((HomeTabFragment)fragment.getParentFragment()).b().setCurrentTab(0);
                    }
                }

            
            {
                a = jy.this;
                super();
            }
            }, e, l);
            return;
        }
    }

    public void d()
    {
        l++;
        (new jy(n, i, g, k, j, m)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void e()
    {
        if (g != null)
        {
            g.setVisibility(0);
        }
    }

}
