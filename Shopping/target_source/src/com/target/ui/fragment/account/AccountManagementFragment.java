// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.model.guest.interfaces.AccountDetails;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.ui.e.i;
import com.target.ui.e.j;
import com.target.ui.fragment.account.a.b;
import com.target.ui.fragment.account.a.c;
import com.target.ui.fragment.payment.PaymentCardListFragment;
import com.target.ui.fragment.shipping.ShippingAddressListFragment;
import com.target.ui.l.a;
import com.target.ui.util.al;
import com.target.ui.util.q;
import com.target.ui.view.account.AccountExternalLaunchView;
import com.target.ui.view.account.AccountInternalLaunchView;
import com.target.ui.view.account.SettingsView;

// Referenced classes of package com.target.ui.fragment.account:
//            BaseAccountFragment, c, ExternalUrlLauncherImpl, AccountProfileFragment, 
//            AccountGiftCardsFragment, AccountOrderHistoryFragment

public class AccountManagementFragment extends BaseAccountFragment
{
    static class Views extends com.target.ui.view.a
    {

        View editGiftCards;
        View editPayment;
        View editProfile;
        View editShipping;
        AccountExternalLaunchView externalLaunchView;
        AccountInternalLaunchView internalLaunchView;
        View orderHistoryView;
        ScrollView scrollContainer;
        SettingsView settingsView;
        View welcomeHeader;
        TextView welcomeHeaderText;

        Views(View view)
        {
            super(view);
        }
    }


    public static final String TAG = com/target/ui/fragment/account/AccountManagementFragment.getSimpleName();
    private final android.view.View.OnClickListener editGiftCardsClickListener = new android.view.View.OnClickListener() {

        final AccountManagementFragment this$0;

        public void onClick(View view)
        {
            view = com.target.ui.fragment.account.AccountGiftCardsFragment.a();
            m().d(view);
        }

            
            {
                this$0 = AccountManagementFragment.this;
                super();
            }
    };
    private final android.view.View.OnClickListener editPaymentClickListener = new android.view.View.OnClickListener() {

        final AccountManagementFragment this$0;

        public void onClick(View view)
        {
            view = PaymentCardListFragment.a();
            m().d(view);
        }

            
            {
                this$0 = AccountManagementFragment.this;
                super();
            }
    };
    private final android.view.View.OnClickListener editProfileClickListener = new android.view.View.OnClickListener() {

        final AccountManagementFragment this$0;

        public void onClick(View view)
        {
            view = com.target.ui.fragment.account.AccountProfileFragment.a();
            m().d(view);
        }

            
            {
                this$0 = AccountManagementFragment.this;
                super();
            }
    };
    private final android.view.View.OnClickListener editShippingClickListener = new android.view.View.OnClickListener() {

        final AccountManagementFragment this$0;

        public void onClick(View view)
        {
            view = ShippingAddressListFragment.b();
            m().d(view);
        }

            
            {
                this$0 = AccountManagementFragment.this;
                super();
            }
    };
    private a mUserPreferenceService;
    private Views mViews;
    private final android.view.View.OnClickListener orderHistoryClickListener = new android.view.View.OnClickListener() {

        final AccountManagementFragment this$0;

        public void onClick(View view)
        {
            view = com.target.ui.fragment.account.AccountOrderHistoryFragment.a();
            m().d(view);
        }

            
            {
                this$0 = AccountManagementFragment.this;
                super();
            }
    };

    public AccountManagementFragment()
    {
    }

    public static AccountManagementFragment a()
    {
        return new AccountManagementFragment();
    }

    private void a(Guest guest)
    {
        if (!guest.getAccountDetails().b())
        {
            al.c(mViews.welcomeHeaderText);
            return;
        } else
        {
            guest = String.format(getString(0x7f090055), new Object[] {
                ((AccountDetails)guest.getAccountDetails().c()).getFirstName()
            });
            mViews.welcomeHeaderText.setText(guest);
            return;
        }
    }

    private void a(i i)
    {
        mViews.settingsView.setSettingsViewListener(new com.target.ui.fragment.account.c(mUserPreferenceService, i));
    }

    private void k()
    {
        mViews.externalLaunchView.setAccountExternalLaunchClickListener(new b(new ExternalUrlLauncherImpl(getActivity())));
        mViews.internalLaunchView.setAccountInternalLaunchClickListener(new c(getActivity(), m()));
        mViews.editProfile.setOnClickListener(editProfileClickListener);
        mViews.editPayment.setOnClickListener(editPaymentClickListener);
        mViews.editShipping.setOnClickListener(editShippingClickListener);
        mViews.editGiftCards.setOnClickListener(editGiftCardsClickListener);
        mViews.orderHistoryView.setOnClickListener(orderHistoryClickListener);
    }

    private void l()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.externalLaunchView.setAccountExternalLaunchClickListener(null);
            mViews.internalLaunchView.setAccountInternalLaunchClickListener(null);
            mViews.editProfile.setOnClickListener(null);
            mViews.editPayment.setOnClickListener(null);
            mViews.editShipping.setOnClickListener(null);
            mViews.editGiftCards.setOnClickListener(null);
            mViews.orderHistoryView.setOnClickListener(null);
            mViews.settingsView.setSettingsViewListener(null);
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
            a(guest);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mUserPreferenceService = com.target.ui.l.a.a();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030044, viewgroup, false);
        mViews = new Views(layoutinflater);
        mViews.settingsView.setNotificationEnabled(mUserPreferenceService.b());
        mViews.settingsView.setInStoreLocationEnabled(mUserPreferenceService.c());
        viewgroup = (j)getActivity();
        k();
        a(viewgroup.o());
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        l();
        mViews = null;
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        n();
    }

}
