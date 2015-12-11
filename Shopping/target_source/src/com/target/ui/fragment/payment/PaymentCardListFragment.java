// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.payment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.o;
import com.target.ui.fragment.account.AuthenticateDialog;
import com.target.ui.fragment.account.b;
import com.target.ui.fragment.checkout.SecurityCodeDialogFragment;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.common.ErrorDialogFragment;
import com.target.ui.fragment.payment.a.a;
import com.target.ui.fragment.payment.b.d;
import com.target.ui.helper.c.h;
import com.target.ui.model.checkout.BillingCardDetailsModel;
import com.target.ui.model.checkout.PaymentCardInformationModel;
import com.target.ui.service.provider.f;
import com.target.ui.util.ai;
import com.target.ui.util.al;
import com.target.ui.view.checkout.c;
import com.target.ui.view.common.TargetErrorView;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.payment:
//            PaymentCardDetailsFragment

public class PaymentCardListFragment extends BaseNavigationFragment
    implements com.target.ui.adapter.d.a.b, com.target.ui.fragment.account.BaseAccountDialog.a, com.target.ui.fragment.account.BaseAccountDialog.b, b, com.target.ui.fragment.checkout.SecurityCodeDialogFragment.a, com.target.ui.fragment.payment.a.a
{
    static class Views extends com.target.ui.view.a
    {

        Button doneButton;
        View emptyListContainer;
        TextView emptyListPrimaryHint;
        TextView emptyListSecondaryHint;
        TargetErrorView errorContainer;
        View listContainer;
        ListView paymentCardList;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
        extends Annotation
    {
    }


    private static final int ACCOUNT = 2;
    private static final String ARG_CONTEXT = "am I in checkout or account?";
    private static final String ARG_ORDER_REVIEW = "order review";
    private static final int CHECKOUT = 1;
    private com.target.ui.adapter.d.a mAdapter;
    private List mCards;
    private final android.view.View.OnClickListener mDoneButtonClickListener = new android.view.View.OnClickListener() {

        final PaymentCardListFragment this$0;

        public void onClick(View view)
        {
            com.target.ui.fragment.payment.PaymentCardListFragment.b(PaymentCardListFragment.this).a((PaymentCardInformationModel)com.target.ui.fragment.payment.PaymentCardListFragment.a(PaymentCardListFragment.this).a().d());
        }

            
            {
                this$0 = PaymentCardListFragment.this;
                super();
            }
    };
    private com.target.ui.fragment.account.a.a mPaymentCardDetailsChangeType;
    private com.target.ui.fragment.payment.b.f mPresenter;
    private com.target.ui.view.common.h mSnackBar;
    private final com.target.ui.view.common.c mTryAgainClickListener = new com.target.ui.view.common.c() {

        final PaymentCardListFragment this$0;

        public void A_()
        {
            com.target.ui.fragment.payment.PaymentCardListFragment.b(PaymentCardListFragment.this).i();
        }

            
            {
                this$0 = PaymentCardListFragment.this;
                super();
            }
    };
    private Views mViews;

    public PaymentCardListFragment()
    {
    }

    static com.target.ui.adapter.d.a a(PaymentCardListFragment paymentcardlistfragment)
    {
        return paymentcardlistfragment.mAdapter;
    }

    public static PaymentCardListFragment a()
    {
        return a(2, ((OrderReview) (null)), ((c) (null)));
    }

    private static PaymentCardListFragment a(int i1, OrderReview orderreview, c c1)
        throws IllegalArgumentException
    {
        PaymentCardListFragment paymentcardlistfragment = new PaymentCardListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("am I in checkout or account?", i1);
        bundle.putParcelable("order review", orderreview);
        paymentcardlistfragment.setArguments(bundle);
        if (i1 == 1)
        {
            if (c1 == null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append(com/target/ui/view/checkout/c.getSimpleName()).append("must not be null").toString());
            }
            if (!(c1 instanceof Fragment))
            {
                throw new IllegalArgumentException((new StringBuilder()).append(com/target/ui/view/checkout/c.getSimpleName()).append(" must also be ").append("an instance of ").append(android/support/v4/app/Fragment.getSimpleName()).toString());
            }
            paymentcardlistfragment.setTargetFragment((Fragment)c1, 0);
        }
        return paymentcardlistfragment;
    }

    public static PaymentCardListFragment a(OrderReview orderreview, c c1)
        throws IllegalArgumentException
    {
        return a(1, orderreview, c1);
    }

    static com.target.ui.fragment.payment.b.f b(PaymentCardListFragment paymentcardlistfragment)
    {
        return paymentcardlistfragment.mPresenter;
    }

    private void f(boolean flag)
    {
        if (flag)
        {
            al.a(mViews.listContainer, new View[] {
                mViews.emptyListContainer, mViews.errorContainer
            });
            return;
        } else
        {
            al.a(mViews.emptyListContainer, new View[] {
                mViews.errorContainer, mViews.listContainer
            });
            return;
        }
    }

    private void g(boolean flag)
    {
        if (flag)
        {
            al.a(mViews.emptyListContainer, new View[] {
                mViews.errorContainer, mViews.listContainer
            });
            return;
        } else
        {
            al.a(mViews.listContainer, new View[] {
                mViews.emptyListContainer, mViews.errorContainer
            });
            return;
        }
    }

    private void h(boolean flag)
    {
        if (flag)
        {
            al.a(mViews.errorContainer, new View[] {
                mViews.listContainer, mViews.emptyListContainer
            });
            return;
        } else
        {
            al.a(mViews.listContainer, new View[] {
                mViews.emptyListContainer, mViews.errorContainer
            });
            return;
        }
    }

    private com.target.ui.fragment.payment.b.f i()
    {
        switch (q())
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Tried to initialize presenter, but found no valid ").append(com/target/ui/fragment/payment/PaymentCardListFragment$a.getSimpleName()).append(".  Found ").append(q()).append(" instead.").toString());

        case 2: // '\002'
            return k();

        case 1: // '\001'
            return j();
        }
    }

    private d j()
    {
        return new d(new h(), new f(), p(), o());
    }

    private com.target.ui.fragment.payment.b.b k()
    {
        return new com.target.ui.fragment.payment.b.b(new com.target.ui.helper.a.a(), new f());
    }

    private c o()
    {
        Fragment fragment = getTargetFragment();
        if (fragment == null)
        {
            return null;
        }
        if (!(fragment instanceof c))
        {
            throw new IllegalStateException((new StringBuilder()).append("target fragment must implement ").append(com/target/ui/view/checkout/c.getSimpleName()).toString());
        } else
        {
            return (c)fragment;
        }
    }

    private OrderReview p()
    {
        return (OrderReview)getArguments().getParcelable("order review");
    }

    private int q()
    {
        return getArguments().getInt("am I in checkout or account?");
    }

    private boolean r()
    {
        return mPaymentCardDetailsChangeType != null;
    }

    public void a(int i1)
    {
        j(getString(i1));
    }

    public void a(int i1, int j1)
    {
        mViews.emptyListPrimaryHint.setText(i1);
        mViews.emptyListSecondaryHint.setText(j1);
        g(true);
    }

    public void a(int i1, Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(i1, menu);
    }

    public void a(int i1, boolean flag)
    {
        mViews.errorContainer.a("", getString(i1), flag);
        h(true);
    }

    public void a(com.target.mothership.common.tender.a a1, String s)
    {
        a1 = (PaymentCardInformationModel)mAdapter.a().d();
        if (a1 == null)
        {
            throw new IllegalStateException("Tried to submit a security code for the selected card but there is no currently selected card.");
        } else
        {
            mPresenter.a(a1, s);
            return;
        }
    }

    public void a(OrderReview orderreview)
    {
        if (Z())
        {
            return;
        } else
        {
            orderreview = com.target.ui.fragment.payment.PaymentCardDetailsFragment.a(orderreview, false, o());
            m().b(orderreview, PaymentCardDetailsFragment.TAG);
            return;
        }
    }

    public void a(OrderReview orderreview, PaymentCardInformationModel paymentcardinformationmodel)
    {
        if (Z())
        {
            return;
        } else
        {
            orderreview = com.target.ui.fragment.payment.PaymentCardDetailsFragment.a(orderreview, paymentcardinformationmodel, false, o());
            m().b(orderreview, PaymentCardDetailsFragment.TAG);
            return;
        }
    }

    public void a(Guest guest)
    {
        mPresenter.f();
    }

    public void a(Guest guest, o o1)
    {
        if (Z())
        {
            return;
        } else
        {
            guest = AuthenticateDialog.a(guest, this);
            guest.a(o1);
            guest.show(getFragmentManager(), AuthenticateDialog.TAG);
            return;
        }
    }

    public void a(com.target.ui.fragment.account.a.a a1)
    {
        mPaymentCardDetailsChangeType = a1;
    }

    public void a(PaymentCardInformationModel paymentcardinformationmodel)
    {
        mPresenter.b(paymentcardinformationmodel);
    }

    public void a(String s)
    {
        mPresenter.h();
    }

    public void a(List list)
    {
        mCards = list;
        mAdapter.a(list);
        mViews.paymentCardList.setAdapter(mAdapter);
        f(true);
    }

    public void a(boolean flag)
    {
        mAdapter.b(flag);
        mAdapter.notifyDataSetChanged();
    }

    public boolean a(com.target.ui.e.e e1)
    {
        return mPresenter.a(e1);
    }

    public void b()
    {
        if (Z())
        {
            return;
        } else
        {
            m().b();
            return;
        }
    }

    public void b(int i1)
    {
        if (Z())
        {
            return;
        } else
        {
            ErrorDialogFragment.a(getString(i1)).show(getFragmentManager(), ErrorDialogFragment.TAG);
            return;
        }
    }

    public void b(PaymentCardInformationModel paymentcardinformationmodel)
    {
        mPresenter.c(paymentcardinformationmodel);
    }

    public void b(Object obj)
    {
        mPresenter.e();
    }

    public void b(String s)
    {
        mPresenter.g();
    }

    public void c()
    {
        mPresenter.a(mCards);
    }

    public void c(int i1)
    {
        mSnackBar.b(getString(i1));
    }

    public void c(PaymentCardInformationModel paymentcardinformationmodel)
    {
        if (Z())
        {
            return;
        } else
        {
            paymentcardinformationmodel = com.target.ui.fragment.payment.PaymentCardDetailsFragment.a(paymentcardinformationmodel, this);
            m().b(paymentcardinformationmodel, PaymentCardDetailsFragment.TAG);
            return;
        }
    }

    public void c(boolean flag)
    {
        al.a(mViews.doneButton, flag);
    }

    public void d(int i1)
    {
        ai.b(this, i1);
    }

    public void d(PaymentCardInformationModel paymentcardinformationmodel)
    {
        if (Z())
        {
            return;
        } else
        {
            paymentcardinformationmodel = SecurityCodeDialogFragment.a(paymentcardinformationmodel.a().a(), this);
            m().c(paymentcardinformationmodel);
            return;
        }
    }

    public void d(boolean flag)
    {
        o(flag);
    }

    public void e()
    {
        if (Z())
        {
            return;
        } else
        {
            m().a();
            return;
        }
    }

    public void e(boolean flag)
    {
        mAdapter.a(flag);
        mAdapter.notifyDataSetChanged();
    }

    public void f()
    {
        if (Z())
        {
            return;
        } else
        {
            PaymentCardDetailsFragment paymentcarddetailsfragment = com.target.ui.fragment.payment.PaymentCardDetailsFragment.a(this);
            m().b(paymentcarddetailsfragment, PaymentCardDetailsFragment.TAG);
            return;
        }
    }

    public void g()
    {
        mViews.errorContainer.a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
        h(true);
    }

    public com.target.ui.fragment.account.BaseAccountDialog.a h()
    {
        return this;
    }

    public com.target.ui.fragment.account.BaseAccountDialog.c l()
    {
        return this;
    }

    public com.target.ui.fragment.account.BaseAccountDialog.e n()
    {
        return h();
    }

    public void n_()
    {
        mPresenter.b(mCards);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mPresenter = i();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            menuinflater.inflate(0x7f120001, menu);
            j(getString(0x7f09008d));
            super.onCreateOptionsMenu(menu, menuinflater);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03006b, viewgroup, false);
        mSnackBar = new com.target.ui.view.common.h(getActivity());
        mViews = new Views(layoutinflater);
        mViews.errorContainer.setClickListener(mTryAgainClickListener);
        mViews.doneButton.setOnClickListener(mDoneButtonClickListener);
        mAdapter = new com.target.ui.adapter.d.a(getActivity(), new ArrayList(), this);
        mPresenter.a(this);
        if (r())
        {
            mPresenter.a(mPaymentCardDetailsChangeType);
            mPaymentCardDetailsChangeType = null;
        }
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mPresenter.z_();
        mViews = null;
        mAdapter = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131756540: 
            mPresenter.d();
            break;
        }
        return true;
    }

    public void onPause()
    {
        super.onPause();
        mSnackBar.a();
    }
}
