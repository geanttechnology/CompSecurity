// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.os.Bundle;
import android.support.v4.app.h;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import butterknife.ButterKnife;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.OrderHistoryYearGroup;
import com.target.mothership.model.guest.interfaces.OrderSummary;
import com.target.mothership.services.o;
import com.target.ui.analytics.a.aq;
import com.target.ui.e.e;
import com.target.ui.fragment.account.b.c;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.service.provider.f;
import com.target.ui.util.al;
import com.target.ui.view.account.AccountOrderHistoryFooterView;
import com.target.ui.view.account.OrderHistoryExpandView;
import com.target.ui.view.common.ExpandView;
import com.target.ui.view.common.TargetErrorView;
import java.lang.ref.WeakReference;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.account:
//            AuthenticateDialog, AccountOrderDetailsFragment

public class AccountOrderHistoryFragment extends BaseNavigationFragment
    implements BaseAccountDialog.a, BaseAccountDialog.b, c, com.target.ui.view.account.OrderSummaryView.a, com.target.ui.view.common.c
{
    static class Views
    {

        View emptyView;
        TargetErrorView errorView;
        LinearLayout listContainer;
        AccountOrderHistoryFooterView orderHistoryFooterView;
        ScrollView scrollView;

        Views(View view)
        {
            ButterKnife.bind(this, view);
        }
    }

    private final class a
        implements com.target.ui.view.common.ExpandView.a
    {

        private WeakReference mViewRef;
        final AccountOrderHistoryFragment this$0;

        public void a(boolean flag)
        {
            if (flag)
            {
                View view = (View)mViewRef.get();
                if (AccountOrderHistoryFragment.a(AccountOrderHistoryFragment.this) != null && view != null)
                {
                    boolean flag1;
                    if (view.getTop() >= AccountOrderHistoryFragment.a(AccountOrderHistoryFragment.this).scrollView.getHeight() / 2)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (flag1)
                    {
                        AccountOrderHistoryFragment.a(AccountOrderHistoryFragment.this).scrollView.smoothScrollTo(0, view.getTop());
                        return;
                    }
                }
            }
        }

        private a(OrderHistoryExpandView orderhistoryexpandview)
        {
            this$0 = AccountOrderHistoryFragment.this;
            super();
            mViewRef = new WeakReference(orderhistoryexpandview);
        }

    }


    private static final String SAVED_EXPAND_STATE = "savedExpandState";
    private static final String TAG = com/target/ui/fragment/account/AccountOrderHistoryFragment.getSimpleName();
    private boolean mOrderSummaryExpandSavedStateArray[];
    private com.target.ui.fragment.account.c.c mPresenter;
    private Views mViews;

    public AccountOrderHistoryFragment()
    {
    }

    static Views a(AccountOrderHistoryFragment accountorderhistoryfragment)
    {
        return accountorderhistoryfragment.mViews;
    }

    public static AccountOrderHistoryFragment a()
    {
        return new AccountOrderHistoryFragment();
    }

    private void i()
    {
        int k = mViews.listContainer.getChildCount();
        mOrderSummaryExpandSavedStateArray = new boolean[k];
        for (int j = 0; j < k; j++)
        {
            ExpandView expandview = (ExpandView)mViews.listContainer.getChildAt(j);
            mOrderSummaryExpandSavedStateArray[j] = expandview.a();
        }

    }

    public void A_()
    {
        mPresenter.k();
    }

    public void a(int j)
    {
        j(getString(j));
    }

    public void a(Guest guest)
    {
        mPresenter.f();
    }

    public void a(Guest guest, o o)
    {
        if (Z())
        {
            return;
        } else
        {
            AuthenticateDialog.a(guest, this).show(getFragmentManager(), AuthenticateDialog.TAG);
            return;
        }
    }

    public void a(OrderSummary ordersummary)
    {
        if (Z())
        {
            return;
        } else
        {
            ordersummary = AccountOrderDetailsFragment.a(ordersummary);
            m().d(ordersummary);
            return;
        }
    }

    public void a(String s)
    {
        mPresenter.i();
    }

    public void a(List list)
    {
        LayoutInflater layoutinflater = LayoutInflater.from(getActivity());
        int j = 0;
        while (j < list.size()) 
        {
            OrderHistoryYearGroup orderhistoryyeargroup = (OrderHistoryYearGroup)list.get(j);
            OrderHistoryExpandView orderhistoryexpandview = (OrderHistoryExpandView)layoutinflater.inflate(0x7f030176, mViews.listContainer, false);
            mViews.listContainer.addView(orderhistoryexpandview);
            orderhistoryexpandview.a(orderhistoryyeargroup.b(), this);
            orderhistoryexpandview.a(String.valueOf(orderhistoryyeargroup.a()));
            if (mOrderSummaryExpandSavedStateArray != null && mOrderSummaryExpandSavedStateArray.length == list.size())
            {
                orderhistoryexpandview.a(mOrderSummaryExpandSavedStateArray[j]);
            } else
            {
                boolean flag;
                if (j == 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                orderhistoryexpandview.a(flag);
            }
            orderhistoryexpandview.setExpandClickListener(new a(orderhistoryexpandview));
            j++;
        }
        al.a(mViews.listContainer, new View[] {
            mViews.errorView, mViews.emptyView
        });
    }

    public void a(boolean flag)
    {
        o(flag);
    }

    public boolean a(e e1)
    {
        mPresenter.l();
        e1.c(false);
        return true;
    }

    public void b()
    {
        if (Z())
        {
            return;
        } else
        {
            getFragmentManager().c();
            return;
        }
    }

    public void b(int j)
    {
        mViews.errorView.a("", getString(j), true);
        al.a(mViews.errorView, new View[] {
            mViews.listContainer, mViews.emptyView
        });
    }

    public void b(OrderSummary ordersummary)
    {
        mPresenter.a(ordersummary);
    }

    public void b(Object obj)
    {
        mPresenter.e();
    }

    public void b(String s)
    {
        mPresenter.h();
    }

    public void c()
    {
        mPresenter.g();
    }

    public void c(boolean flag)
    {
        if (flag)
        {
            al.b(mViews.orderHistoryFooterView);
            return;
        } else
        {
            al.c(mViews.orderHistoryFooterView);
            return;
        }
    }

    public void e()
    {
        al.a(mViews.emptyView, new View[] {
            mViews.errorView, mViews.listContainer
        });
    }

    public void g()
    {
        mViews.errorView.a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
    }

    public BaseAccountDialog.a h()
    {
        return this;
    }

    public BaseAccountDialog.c l()
    {
        return this;
    }

    public BaseAccountDialog.e n()
    {
        return h();
    }

    public void n_()
    {
        mPresenter.j();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mPresenter = new com.target.ui.fragment.account.c.c(new f(), new com.target.ui.helper.a.c(com.target.ui.service.f.a()));
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            mPresenter.a(menu, menuinflater);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030047, viewgroup, false);
        mViews = new Views(layoutinflater);
        mViews.errorView.setClickListener(this);
        mPresenter.a(this);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mPresenter.v_();
        mPresenter = null;
        mOrderSummaryExpandSavedStateArray = null;
    }

    public void onDestroyView()
    {
        i();
        mPresenter.z_();
        mViews = null;
        super.onDestroyView();
    }

    public void onResume()
    {
        super.onResume();
        aq.j().e();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putBooleanArray("savedExpandState", mOrderSummaryExpandSavedStateArray);
        super.onSaveInstanceState(bundle);
    }

    public void onViewStateRestored(Bundle bundle)
    {
        super.onViewStateRestored(bundle);
        if (bundle != null)
        {
            mOrderSummaryExpandSavedStateArray = bundle.getBooleanArray("savedExpandState");
        }
        mPresenter.d();
    }

}
