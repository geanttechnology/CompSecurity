// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.base;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.bestbuy.android.activities.mdot.MdotWebFragment;

// Referenced classes of package com.bestbuy.android.base:
//            BBYBaseFragment

public class BaseFragmentContainer extends BBYBaseFragment
{

    private boolean a;
    private boolean b;

    public BaseFragmentContainer()
    {
        a = false;
        b = true;
    }

    public void a(Fragment fragment, boolean flag)
    {
        a(fragment, flag, "");
    }

    public void a(Fragment fragment, boolean flag, String s)
    {
        (new Handler()).post(new Runnable(flag, fragment, s) {

            final boolean a;
            final Fragment b;
            final String c;
            final BaseFragmentContainer d;

            public void run()
            {
                FragmentTransaction fragmenttransaction = d.getChildFragmentManager().beginTransaction();
                if (a)
                {
                    fragmenttransaction.addToBackStack(null);
                }
                fragmenttransaction.replace(0x7f0c009e, b, c);
                fragmenttransaction.commitAllowingStateLoss();
                d.getChildFragmentManager().executePendingTransactions();
            }

            
            {
                d = BaseFragmentContainer.this;
                a = flag;
                b = fragment;
                c = s;
                super();
            }
        });
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

    public void d()
    {
        getChildFragmentManager().popBackStack();
    }

    public boolean e()
    {
        boolean flag;
        if (getChildFragmentManager().getBackStackEntryCount() > 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            Object obj = getChildFragmentManager().findFragmentById(0x7f0c009e);
            if (obj instanceof MdotWebFragment)
            {
                obj = (MdotWebFragment)obj;
                if (((MdotWebFragment) (obj)).d())
                {
                    ((MdotWebFragment) (obj)).e();
                    return true;
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
        }
        Object obj1 = getChildFragmentManager().findFragmentById(0x7f0c009e);
        if (obj1 instanceof MdotWebFragment)
        {
            obj1 = (MdotWebFragment)obj1;
            boolean flag1;
            if (((MdotWebFragment) (obj1)).d())
            {
                ((MdotWebFragment) (obj1)).e();
                flag1 = true;
            } else
            {
                getChildFragmentManager().popBackStack();
                flag1 = false;
            }
            return flag1;
        } else
        {
            getChildFragmentManager().popBackStack();
            return false;
        }
    }

    public void onResume()
    {
        super.onResume();
    }
}
