// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.BrowseCategoryFragment;
import com.bestbuy.android.activities.browseproduct.BrowseSuperSubCategoryFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.cart.MyCartFragment;
import com.bestbuy.android.activities.stores.StoreDetailsFragment;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class hg extends ka
{

    private static int l = 0;
    private ArrayList a;
    private String j;
    private String k;
    private int m;
    private int n;
    private boolean o;

    public hg(Activity activity, BBYBaseFragment bbybasefragment, View view, String s, String s1, int i, int i1, 
            boolean flag)
    {
        super(activity, bbybasefragment);
        j = s;
        g = view;
        k = s1;
        m = i;
        n = i1;
        o = flag;
        a = new ArrayList();
    }

    public void a()
    {
        if (j == null || j.isEmpty())
        {
            j = "all";
        }
        a = fs.a(j, m, n, o);
    }

    public void b()
    {
        boolean flag;
        flag = false;
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (a == null || a.isEmpty())
        {
            break MISSING_BLOCK_LABEL_225;
        }
        l = 0;
        if (!(i instanceof BrowseCategoryFragment) || !i.isAdded()) goto _L2; else goto _L1
_L1:
        ((BrowseCategoryFragment)i).a(a);
_L4:
        return;
_L2:
        if ((i instanceof BrowseSuperSubCategoryFragment) && i.isAdded())
        {
            ((BrowseSuperSubCategoryFragment)i).a(a);
            return;
        }
        if ((i instanceof PLPFragment) && i.isAdded())
        {
            if (m > 1)
            {
                flag = true;
            }
            ((PLPFragment)i).a(a, flag);
            return;
        }
        if ((i instanceof MyCartFragment) && i.isAdded())
        {
            ((MyCartFragment)i).a(a);
            return;
        }
        if (!(i instanceof StoreDetailsFragment) || !i.isAdded()) goto _L4; else goto _L3
_L3:
        ((StoreDetailsFragment)i).a(a);
        return;
        c();
        return;
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (i instanceof BrowseSuperSubCategoryFragment)
        {
            ((BrowseSuperSubCategoryFragment)i).b();
        } else
        {
            if ((i instanceof BrowseCategoryFragment) && i.isAdded())
            {
                ((BrowseCategoryFragment)i).b();
                return;
            }
            if ((i instanceof BrowseSuperSubCategoryFragment) && i.isAdded())
            {
                ((BrowseSuperSubCategoryFragment)i).b();
                return;
            }
            if ((i instanceof MyCartFragment) && i.isAdded())
            {
                ((MyCartFragment)i).d();
                return;
            }
            if ((i instanceof StoreDetailsFragment) && i.isAdded())
            {
                ((StoreDetailsFragment)i).b();
                return;
            }
        }
    }

    public void d()
    {
        l++;
        (new hg(f, i, g, j, k, m, n, o)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void e()
    {
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
