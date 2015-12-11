// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import com.bestbuy.android.activities.appsettings.NotificationsCategoryFragment;
import com.bestbuy.android.activities.browseproduct.BrowseCategoryFragment;
import com.bestbuy.android.activities.browseproduct.ProductTabContainer;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.api.lib.models.browse.UberCategoryList;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.List;

public class ii extends ka
{

    private static int j = 0;
    private UberCategoryList a;

    public ii(Activity activity, BBYBaseFragment bbybasefragment, View view)
    {
        super(activity, bbybasefragment);
        g = view;
    }

    static int a(int i)
    {
        j = i;
        return i;
    }

    static BBYBaseFragment a(ii ii1)
    {
        return ii1.i;
    }

    static Activity b(ii ii1)
    {
        return ii1.f;
    }

    public void a()
    {
        a = fs.c();
    }

    public void a(Void void1)
    {
        super.onCancelled(void1);
        g.setVisibility(8);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        j = 0;
        if (a == null || a.getHeader().isEmpty())
        {
            break MISSING_BLOCK_LABEL_115;
        }
        if (!(i instanceof BrowseCategoryFragment) || !i.isAdded()) goto _L2; else goto _L1
_L1:
        ((BrowseCategoryFragment)i).a(a);
_L4:
        return;
_L2:
        if (!(i instanceof NotificationsCategoryFragment) || !i.isAdded()) goto _L4; else goto _L3
_L3:
        ((NotificationsCategoryFragment)i).a(a.getHeader());
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
        if (i.isVisible())
        {
            nm.a(f, new no() {

                final ii a;

                public void a()
                {
                    a.d();
                }

            
            {
                a = ii.this;
                super();
            }
            }, new nn() {

                final ii a;

                public void a()
                {
                    ii.a(0);
                    Fragment fragment = ii.a(a).getParentFragment();
                    if (fragment instanceof ProductTabContainer)
                    {
                        ((HomeTabFragment)fragment.getParentFragment()).b().setCurrentTab(0);
                    } else
                    if (fragment == null)
                    {
                        ii.b(a).finish();
                        return;
                    }
                }

            
            {
                a = ii.this;
                super();
            }
            }, e, j);
        }
    }

    public void d()
    {
        j++;
        (new ii(f, i, g)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void onCancelled(Object obj)
    {
        a((Void)obj);
    }

}
