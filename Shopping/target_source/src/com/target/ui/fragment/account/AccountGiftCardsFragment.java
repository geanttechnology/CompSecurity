// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.os.Bundle;
import android.support.v4.app.h;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.target.mothership.common.tender.PaymentTender;
import com.target.mothership.model.cart.b.d;
import com.target.mothership.model.common.GiftCardTender;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.a.g;
import com.target.mothership.services.o;
import com.target.mothership.util.b;
import com.target.ui.adapter.a.a;
import com.target.ui.analytics.a.ba;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.scan.ScanGiftCardFragment;
import com.target.ui.util.ai;
import com.target.ui.util.al;
import com.target.ui.util.q;
import com.target.ui.view.AddActionView;
import com.target.ui.view.account.AccountGiftCardsFooterView;
import com.target.ui.view.checkout.GiftCardInputView;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.common.c;
import com.target.ui.view.common.e;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.account:
//            AuthenticateDialog, AccountGiftCardDetailFragment

public class AccountGiftCardsFragment extends BaseNavigationFragment
    implements com.target.ui.adapter.a.a.a, BaseAccountDialog.a, BaseAccountDialog.b, com.target.ui.fragment.scan.ScanGiftCardFragment.a, com.target.ui.helper.a.a.d, c, e
{
    static class Views extends com.target.ui.view.a
    {

        AddActionView addActionView;
        View emptyListContainer;
        TextView emptyListPrimaryHint;
        TextView emptyListSecondaryHint;
        TargetErrorView errorView;
        View giftCardInputContainer;
        GiftCardInputView giftCardInputView;
        AccountGiftCardsFooterView giftCardsFooterView;
        ListView listView;

        Views(View view)
        {
            super(view);
        }
    }


    private static final String ARG_PENDING_GIFT_CARD_SCAN = "the user has recently scanned a GiftCard barcode";
    private static final String ARG_SHOWING_GIFT_CARD_INPUT = "the GiftCard input is shown to the user";
    private static final int NO_ANIMATION_TIME = 0;
    public static final String TAG = com/target/ui/fragment/account/AccountGiftCardsFragment.getSimpleName();
    private com.target.ui.helper.a.a mAccountDataHelper;
    private a mAdapter;
    private List mGiftCardTendersList;
    private Views mViews;

    public AccountGiftCardsFragment()
    {
    }

    public static AccountGiftCardsFragment a()
    {
        AccountGiftCardsFragment accountgiftcardsfragment = new AccountGiftCardsFragment();
        accountgiftcardsfragment.setArguments(new Bundle());
        return accountgiftcardsfragment;
    }

    private void a(final Menu actionAdd)
    {
        actionAdd = actionAdd.findItem(0x7f1005fc);
        if (actionAdd == null || actionAdd.getActionView() == null)
        {
            return;
        }
        mViews.addActionView = (AddActionView)actionAdd.getActionView();
        if (s())
        {
            mViews.addActionView.b(0L);
        }
        mViews.addActionView.setOnClickListener(new android.view.View.OnClickListener() {

            final AccountGiftCardsFragment this$0;
            final MenuItem val$actionAdd;

            public void onClick(View view)
            {
                onOptionsItemSelected(actionAdd);
            }

            
            {
                this$0 = AccountGiftCardsFragment.this;
                actionAdd = menuitem;
                super();
            }
        });
    }

    private void a(Guest guest, o o1)
    {
        if (mViews == null)
        {
            return;
        }
        o(false);
        if (al.a(mViews.giftCardInputContainer))
        {
            mViews.giftCardInputView.a(false);
            mViews.giftCardInputView.a();
        }
        b(guest, o1);
    }

    private void a(boolean flag)
    {
        if (flag)
        {
            mViews.emptyListPrimaryHint.setText(getString(0x7f09008a));
            mViews.emptyListSecondaryHint.setText(getString(0x7f09008b));
            al.a(mViews.emptyListContainer, new View[] {
                mViews.listView, mViews.errorView
            });
        } else
        {
            al.a(mViews.listView, new View[] {
                mViews.emptyListContainer, mViews.errorView
            });
        }
        e(true);
    }

    private void b(Guest guest, o o1)
    {
        if (Z())
        {
            return;
        } else
        {
            guest = com.target.ui.fragment.account.AuthenticateDialog.a(guest, this);
            guest.a(o1);
            guest.show(getFragmentManager(), AuthenticateDialog.TAG);
            return;
        }
    }

    private void b(List list)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            o(false);
            a(list.isEmpty());
            mAdapter = new a(getActivity(), list, this);
            mViews.listView.setAdapter(mAdapter);
            return;
        }
    }

    private void c(boolean flag)
    {
        getArguments().putBoolean("the GiftCard input is shown to the user", flag);
    }

    private void d(String s1)
    {
        o(false);
        mViews.giftCardInputView.a(false);
        mViews.giftCardInputView.a();
        mViews.giftCardInputView.b(s1);
    }

    private void d(boolean flag)
    {
        boolean flag1 = false;
        if (mViews == null)
        {
            return;
        }
        if (flag)
        {
            al.a(mViews.giftCardInputContainer, new View[] {
                mViews.emptyListContainer, mViews.errorView
            });
        } else
        {
            al.c(mViews.giftCardInputContainer);
            if (!com.target.mothership.util.b.a().b())
            {
                e();
            } else
            {
                if (mGiftCardTendersList == null || mGiftCardTendersList.isEmpty())
                {
                    flag1 = true;
                }
                a(flag1);
            }
        }
        c(flag);
    }

    private void e(boolean flag)
    {
        if (flag)
        {
            al.b(mViews.giftCardsFooterView);
            return;
        } else
        {
            al.c(mViews.giftCardsFooterView);
            return;
        }
    }

    private void h()
    {
        Guest guest = i();
        if (guest == null)
        {
            com.target.ui.util.q.d(TAG, "Guest session is null");
            return;
        } else
        {
            o(true);
            mAccountDataHelper.a(guest, this);
            return;
        }
    }

    private Guest i()
    {
        com.target.ui.service.a a1 = com.target.ui.service.a.a();
        if (a1.c().b())
        {
            return (Guest)a1.c().c();
        } else
        {
            return null;
        }
    }

    private void j()
    {
        if (mViews != null)
        {
            e(true);
            if (mAdapter == null)
            {
                mViews.errorView.a("", getString(0x7f090084), true);
                u();
                return;
            }
        }
    }

    private void k()
    {
        mViews.errorView.setClickListener(this);
        mViews.giftCardInputView.setGiftCardActionListener(this);
    }

    private void o()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.errorView.setClickListener(null);
            mViews.giftCardInputView.setGiftCardActionListener(null);
            return;
        }
    }

    private boolean p()
    {
        return getArguments().containsKey("the user has recently scanned a GiftCard barcode");
    }

    private String q()
    {
        return getArguments().getString("the user has recently scanned a GiftCard barcode", null);
    }

    private void r()
    {
        getArguments().remove("the user has recently scanned a GiftCard barcode");
    }

    private boolean s()
    {
        return getArguments().getBoolean("the GiftCard input is shown to the user", false);
    }

    private void t()
    {
        String s1;
        if (mViews != null)
        {
            if ((s1 = q()) != null)
            {
                mViews.giftCardInputView.a(s1);
                r();
                return;
            }
        }
    }

    private void u()
    {
        if (mViews == null)
        {
            return;
        }
        o(false);
        if (al.a(mViews.giftCardInputContainer))
        {
            mViews.giftCardInputView.a(false);
            mViews.giftCardInputView.a();
            al.c(mViews.giftCardInputContainer);
            mViews.addActionView.a(0L);
        }
        al.a(mViews.errorView, new View[] {
            mViews.emptyListContainer, mViews.listView
        });
    }

    public void A_()
    {
        al.c(mViews.errorView);
        h();
    }

    public void a(int i1)
    {
        if (mViews == null)
        {
            return;
        }
        String s1 = getString(0x7f09027b);
        if (i1 == 40)
        {
            d(s1);
            return;
        } else
        {
            mViews.errorView.a("", s1, true);
            u();
            return;
        }
    }

    public void a(int i1, Guest guest, o o1)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            a(guest, o1);
            return;
        }
    }

    public void a(PaymentTender paymenttender)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.giftCardInputView.a(false);
            mViews.giftCardInputView.b();
            al.c(mViews.giftCardInputContainer);
            h();
            return;
        }
    }

    public void a(d d1, String s1)
    {
        o(true);
        mViews.giftCardInputView.a(true);
        s1 = i();
        if (s1 == null)
        {
            com.target.ui.util.q.a(TAG, "Guest session is null");
            return;
        } else
        {
            mAccountDataHelper.a(s1, d1, this);
            return;
        }
    }

    public void a(GiftCardTender giftcardtender)
    {
        com.target.ui.f.c c1;
        if (!Z())
        {
            if ((c1 = m()) != null)
            {
                if (giftcardtender.e() == null)
                {
                    ai.a(this, 0x7f090078);
                    return;
                } else
                {
                    c1.d(com.target.ui.fragment.account.AccountGiftCardDetailFragment.a(giftcardtender));
                    return;
                }
            }
        }
    }

    public void a(Guest guest)
    {
    }

    public void a(com.target.mothership.model.guest.interfaces.a.a a1)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            d(com.target.ui.util.b.a(getActivity(), (com.target.mothership.model.guest.interfaces.a.a.a)a1.e()));
            return;
        }
    }

    public void a(g g1)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            o(false);
            g1 = getString(0x7f090083);
            e(true);
            mViews.errorView.a("", g1, true);
            u();
            return;
        }
    }

    public void a(String s1)
    {
    }

    public void a(List list)
    {
        mGiftCardTendersList = list;
        b(list);
    }

    public boolean a(com.target.ui.e.e e1)
    {
        mAccountDataHelper.a();
        e1.c(false);
        if (Z())
        {
            return true;
        } else
        {
            getFragmentManager().c();
            return true;
        }
    }

    public BaseAccountDialog.a b()
    {
        return this;
    }

    public void b(Object obj)
    {
        o(true);
    }

    public void b(String s1)
    {
    }

    public void c()
    {
        j();
    }

    public void c(String s1)
    {
        if (!com.target.ui.util.validation.b.n(s1))
        {
            ai.a(this, 0x7f090281);
            return;
        }
        Bundle bundle1 = getArguments();
        Bundle bundle = bundle1;
        if (bundle1 == null)
        {
            bundle = new Bundle();
        }
        bundle.putString("the user has recently scanned a GiftCard barcode", s1);
    }

    public void e()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            o(false);
            mViews.errorView.a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
            e(false);
            u();
            return;
        }
    }

    public void g()
    {
        ScanGiftCardFragment scangiftcardfragment = ScanGiftCardFragment.a(this);
        m().d(scangiftcardfragment);
    }

    public BaseAccountDialog.c l()
    {
        return this;
    }

    public BaseAccountDialog.e n()
    {
        return b();
    }

    public void n_()
    {
        j();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mAccountDataHelper = new com.target.ui.helper.a.a();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        }
        menuinflater.inflate(0x7f120000, menu);
        a(menu);
        j(getString(0x7f090086));
        if (s())
        {
            d(true);
        }
        super.onCreateOptionsMenu(menu, menuinflater);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030041, viewgroup, false);
        mViews = new Views(layoutinflater);
        k();
        mViews.giftCardInputView.setRedeemButtonLabel(getString(0x7f090088));
        if (mGiftCardTendersList != null)
        {
            b(mGiftCardTendersList);
            return layoutinflater;
        } else
        {
            h();
            return layoutinflater;
        }
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        o();
        mViews = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131756540: 
            break;
        }
        if (al.a(mViews.giftCardInputContainer))
        {
            d(false);
            mViews.addActionView.a();
            return true;
        } else
        {
            d(true);
            mViews.addActionView.b();
            return true;
        }
    }

    public void onResume()
    {
        super.onResume();
        if (p())
        {
            t();
        }
        ba.a(this).e();
    }

}
