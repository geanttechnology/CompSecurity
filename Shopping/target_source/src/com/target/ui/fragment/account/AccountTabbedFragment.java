// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import com.google.a.a.e;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.util.o;
import com.target.ui.analytics.a.ba;
import com.target.ui.f.c;
import com.target.ui.fragment.common.TabbedFragment;
import com.target.ui.service.a;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.account:
//            AccountManagementFragment, AccountLoginFragment, AccountCreateFragment

public class AccountTabbedFragment extends TabbedFragment
    implements com.target.ui.service.a.b
{

    private static final String KEY_NEW_EMAIL = "newEmail";
    private static final int SIGN_IN_TAB_INDEX = 0;
    private static final int SIGN_UP_TAB_INDEX = 1;
    private boolean mIsCreateAccountMode;
    private String mNewEmail;

    public AccountTabbedFragment()
    {
    }

    public static AccountTabbedFragment a()
    {
        return new AccountTabbedFragment();
    }

    public static AccountTabbedFragment a(String s)
    {
        AccountTabbedFragment accounttabbedfragment = new AccountTabbedFragment();
        Bundle bundle = new Bundle();
        bundle.putString("newEmail", s);
        accounttabbedfragment.setArguments(bundle);
        return accounttabbedfragment;
    }

    private boolean k()
    {
        e e1 = com.target.ui.service.a.a().c();
        if (!e1.b())
        {
            return false;
        }
        boolean flag;
        if (!((Guest)e1.c()).isAnonymous())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    private List l()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(o());
        return arraylist;
    }

    private List n()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(p());
        arraylist.add(q());
        return arraylist;
    }

    private com.target.ui.fragment.common.TabbedFragment.b o()
    {
        return new com.target.ui.fragment.common.TabbedFragment.b(com.target.ui.fragment.account.AccountManagementFragment.a(), "");
    }

    private com.target.ui.fragment.common.TabbedFragment.b p()
    {
        return new com.target.ui.fragment.common.TabbedFragment.b(com.target.ui.fragment.account.AccountLoginFragment.a(), getResources().getString(0x7f0900c1));
    }

    private com.target.ui.fragment.common.TabbedFragment.b q()
    {
        AccountCreateFragment accountcreatefragment;
        if (mIsCreateAccountMode)
        {
            accountcreatefragment = com.target.ui.fragment.account.AccountCreateFragment.a(mNewEmail);
        } else
        {
            accountcreatefragment = com.target.ui.fragment.account.AccountCreateFragment.a();
        }
        return new com.target.ui.fragment.common.TabbedFragment.b(accountcreatefragment, getResources().getString(0x7f0900c2));
    }

    private void r()
    {
        m().e(a());
    }

    protected void a(int i)
    {
        ba.a(j()).e();
    }

    public void a(Guest guest)
    {
        r();
    }

    public void b()
    {
        r();
    }

    protected List c()
    {
        if (k())
        {
            return l();
        } else
        {
            return n();
        }
    }

    protected int d()
    {
        return !mIsCreateAccountMode ? 0 : 1;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (getArguments() != null)
        {
            mNewEmail = getArguments().getString("newEmail");
            mIsCreateAccountMode = com.target.mothership.util.o.g(mNewEmail);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            menuinflater.inflate(0x7f120005, menu);
            j(getString(0x7f090050));
            b(true);
            super.onCreateOptionsMenu(menu, menuinflater);
            return;
        }
    }

    public void onPause()
    {
        super.onPause();
        com.target.ui.service.a.a().b(this);
    }

    public void onResume()
    {
        super.onResume();
        com.target.ui.service.a.a().a(this);
        ba.a(j()).e();
    }
}
