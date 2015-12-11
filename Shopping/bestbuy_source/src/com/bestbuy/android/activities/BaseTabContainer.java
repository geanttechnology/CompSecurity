// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.bestbuy.android.activities.browseproduct.BrowseCategoryFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragmentContainer;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.activities.cart.CartTabContainer;
import com.bestbuy.android.activities.cart.MyCartFragment;
import com.bestbuy.android.activities.dnm.DNMListFragmentContainer;
import com.bestbuy.android.activities.dnm.DNMSubListContainer;
import com.bestbuy.android.activities.home.HomeFragment;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.activities.registry.WishListFragmentContainer;
import com.bestbuy.android.activities.stores.StoreSearchMapFragment;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BaseFragmentContainer;
import java.util.List;
import nu;

public class BaseTabContainer extends BBYBaseFragment
{

    public BaseTabContainer()
    {
    }

    public void a(Fragment fragment, boolean flag)
    {
        (new Handler()).post(new Runnable(flag, fragment) {

            final boolean a;
            final Fragment b;
            final BaseTabContainer c;

            public void run()
            {
                FragmentTransaction fragmenttransaction = c.getChildFragmentManager().beginTransaction();
                if (a)
                {
                    fragmenttransaction.addToBackStack(null);
                }
                fragmenttransaction.replace(0x7f0c009e, b);
                fragmenttransaction.commitAllowingStateLoss();
                c.getChildFragmentManager().executePendingTransactions();
            }

            
            {
                c = BaseTabContainer.this;
                a = flag;
                b = fragment;
                super();
            }
        });
    }

    public boolean a(String s)
    {
        boolean flag;
        if (s.equalsIgnoreCase("Cart"))
        {
            if (getChildFragmentManager().getBackStackEntryCount() >= 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        if (getChildFragmentManager().getBackStackEntryCount() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        s = getChildFragmentManager().findFragmentById(0x7f0c009e);
        if (!(s instanceof MyCartFragment)) goto _L2; else goto _L1
_L1:
        s = ((MyCartFragment)s).getChildFragmentManager().findFragmentById(0x7f0c0171);
        if (!(s instanceof MdotWebFragment)) goto _L4; else goto _L3
_L3:
        s = (MdotWebFragment)s;
        if (!s.d()) goto _L6; else goto _L5
_L5:
        s.e();
_L8:
        return true;
_L6:
        return false;
_L4:
        return false;
_L2:
        Fragment fragment;
        if (!(s instanceof PLPFragmentContainer) && !(s instanceof PDPFragmentContainer) && !(s instanceof DNMListFragmentContainer) && !(s instanceof WishListFragmentContainer) && !(s instanceof DNMSubListContainer))
        {
            break MISSING_BLOCK_LABEL_255;
        }
        fragment = s.getChildFragmentManager().findFragmentById(0x7f0c009e);
        if (fragment instanceof MdotWebFragment)
        {
            s = (MdotWebFragment)fragment;
            if (s.d())
            {
                s.e();
                return true;
            }
            if (getChildFragmentManager().getBackStackEntryCount() == 0)
            {
                return false;
            } else
            {
                getChildFragmentManager().popBackStack();
                return true;
            }
        }
        if (!(fragment instanceof BaseFragmentContainer))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((BaseFragmentContainer)fragment).e() || ((BaseFragmentContainer)s).e()) goto _L8; else goto _L7
_L7:
        getChildFragmentManager().popBackStack();
        return true;
        if (((BaseFragmentContainer)s).e()) goto _L8; else goto _L9
_L9:
        getChildFragmentManager().popBackStack();
        return true;
        if (s instanceof MdotWebFragment)
        {
            s = (MdotWebFragment)s;
            if (s.d())
            {
                if (nu.a)
                {
                    s = (BaseTabContainer)s.getParentFragment();
                    if (s instanceof CartTabContainer)
                    {
                        ((CartTabContainer)s).a(true);
                    }
                    nu.a = false;
                    return true;
                } else
                {
                    s.e();
                    return true;
                }
            }
            if (getChildFragmentManager().getBackStackEntryCount() == 0)
            {
                return false;
            } else
            {
                getChildFragmentManager().popBackStack();
                return true;
            }
        } else
        {
            getChildFragmentManager().popBackStack();
            return true;
        }
        return false;
    }

    public void a_()
    {
        getChildFragmentManager().popBackStack();
    }

    public Fragment b()
    {
        if (getChildFragmentManager() != null)
        {
            return getChildFragmentManager().findFragmentById(0x7f0c009e);
        } else
        {
            return null;
        }
    }

    public void c()
    {
        List list = getChildFragmentManager().getFragments();
        int i = 0;
        do
        {
label0:
            {
                if (i < list.size())
                {
                    Fragment fragment = b();
                    if (!(fragment instanceof BrowseCategoryFragment) && !(fragment instanceof HomeFragment) && !(fragment instanceof StoreSearchMapFragment))
                    {
                        break label0;
                    }
                }
                return;
            }
            (new Handler()).post(new Runnable() {

                final BaseTabContainer a;

                public void run()
                {
                    a.a_();
                }

            
            {
                a = BaseTabContainer.this;
                super();
            }
            });
            i++;
        } while (true);
    }

    public void onResume()
    {
        super.onResume();
    }
}
