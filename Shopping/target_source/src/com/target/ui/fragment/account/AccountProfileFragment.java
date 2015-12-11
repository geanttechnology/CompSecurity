// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.ui.analytics.a.ba;
import com.target.ui.analytics.a.x;
import com.target.ui.e.e;
import com.target.ui.f.c;
import com.target.ui.util.q;
import com.target.ui.view.account.AccountSessionDetailsView;

// Referenced classes of package com.target.ui.fragment.account:
//            BaseAccountFragment, AccountTabbedFragment

public class AccountProfileFragment extends BaseAccountFragment
{
    static class Views extends com.target.ui.view.a
    {

        AccountSessionDetailsView session;
        View signOutButton;

        Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements android.view.View.OnClickListener
    {

        final AccountProfileFragment this$0;

        public void onClick(View view)
        {
            AccountProfileFragment.a(AccountProfileFragment.this);
        }

        private a()
        {
            this$0 = AccountProfileFragment.this;
            super();
        }

    }


    public static final String TAG = com/target/ui/fragment/account/AccountProfileFragment.getSimpleName();
    private Views mViews;

    public AccountProfileFragment()
    {
    }

    public static AccountProfileFragment a()
    {
        return new AccountProfileFragment();
    }

    static void a(AccountProfileFragment accountprofilefragment)
    {
        accountprofilefragment.o();
    }

    private void a(boolean flag)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.signOutButton.setEnabled(flag);
            return;
        }
    }

    private void k()
    {
        mViews.signOutButton.setOnClickListener(new a());
    }

    private void l()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.signOutButton.setOnClickListener(null);
            return;
        }
    }

    private void n()
    {
        Guest guest = j();
        if (guest == null)
        {
            q.a(TAG, "tried to show the current session but there isn't one.");
            return;
        }
        if (guest.isAnonymous())
        {
            q.a(TAG, "tried to show the current session but it's anonymous");
            return;
        } else
        {
            mViews.session.a(guest);
            return;
        }
    }

    private void o()
    {
        a(false);
        o(true);
        i();
        x.j().e();
    }

    public boolean a(e e1)
    {
        e1.c(false);
        return true;
    }

    protected void b()
    {
        a(true);
        o(false);
    }

    protected void f()
    {
        o(false);
        AccountTabbedFragment accounttabbedfragment = AccountTabbedFragment.a();
        m().e(accounttabbedfragment);
    }

    protected void g()
    {
        a(true);
        o(false);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            menuinflater.inflate(0x7f120005, menu);
            j(getString(0x7f090094));
            super.onCreateOptionsMenu(menu, menuinflater);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030045, viewgroup, false);
        mViews = new Views(layoutinflater);
        k();
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        l();
        mViews = null;
    }

    public void onResume()
    {
        super.onResume();
        ba.a(this).e();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        n();
    }

}
