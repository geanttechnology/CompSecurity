// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.payment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.o;
import com.target.ui.fragment.account.AuthenticateDialog;
import com.target.ui.fragment.cart.CartHomeFragment;
import com.target.ui.fragment.checkout.CheckoutHomeFragment;
import com.target.ui.fragment.checkout.SecurityCodeDialogFragment;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.common.ErrorDialogFragment;
import com.target.ui.fragment.payment.a.b;
import com.target.ui.fragment.payment.b.a;
import com.target.ui.fragment.payment.b.e;
import com.target.ui.fragment.scan.ScanCreditCardFragment;
import com.target.ui.helper.c.g;
import com.target.ui.model.checkout.BillingCardDetailsModel;
import com.target.ui.model.checkout.CardDataModel;
import com.target.ui.model.checkout.PaymentCardInformationModel;
import com.target.ui.util.ai;
import com.target.ui.util.al;
import com.target.ui.view.checkout.BillingView;
import com.target.ui.view.checkout.f;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.common.c;
import java.lang.annotation.Annotation;

// Referenced classes of package com.target.ui.fragment.payment:
//            PaymentCardDeleteDialogFragment

public class PaymentCardDetailsFragment extends BaseNavigationFragment
    implements com.target.ui.fragment.account.BaseAccountDialog.a, com.target.ui.fragment.account.BaseAccountDialog.b, com.target.ui.fragment.checkout.SecurityCodeDialogFragment.a, PaymentCardDeleteDialogFragment.a, b, com.target.ui.fragment.scan.ScanCreditCardFragment.a, com.target.ui.view.account.b, com.target.ui.view.checkout.b, f, c
{
    static class Views extends com.target.ui.view.a
    {

        BillingView billingView;
        Button button;
        TargetErrorView errorContainer;
        View paymentDetailsContainer;
        com.target.ui.view.common.a setAsDefault;

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
    private static final String ARG_MODE = "add or edit mode";
    private static final String ARG_ORDER_REVIEW = "order review";
    private static final String ARG_PAYMENT_CARD_CONTEXT = "am I in checkout or account?";
    private static final String ARG_PAYMENT_CARD_INFORMATION_MODEL = "payment card information model";
    private static final String ARG_SHOULD_APPLY_BILLING_AS_SHIPPING = "applyBillingAddressAsShippingAddress";
    private static final int CHECKOUT = 1;
    private final android.view.View.OnClickListener mActionButtonClickListener = new android.view.View.OnClickListener() {

        final PaymentCardDetailsFragment this$0;

        public void onClick(View view)
        {
            com.target.ui.fragment.payment.PaymentCardDetailsFragment.a(PaymentCardDetailsFragment.this).d();
        }

            
            {
                this$0 = PaymentCardDetailsFragment.this;
                super();
            }
    };
    private com.target.ui.fragment.account.b mPaymentCardChangeListener;
    private e mPresenter;
    private Views mViews;

    public PaymentCardDetailsFragment()
    {
    }

    private OrderReview A()
    {
        return (OrderReview)getArguments().getParcelable("order review");
    }

    private boolean B()
    {
        return getArguments().getBoolean("applyBillingAddressAsShippingAddress");
    }

    private PaymentCardInformationModel C()
    {
        return (PaymentCardInformationModel)getArguments().getParcelable("payment card information model");
    }

    private static PaymentCardDetailsFragment a(int i1, int j1, boolean flag, PaymentCardInformationModel paymentcardinformationmodel, com.target.ui.fragment.account.b b1, OrderReview orderreview, com.target.ui.view.checkout.c c1)
    {
        PaymentCardDetailsFragment paymentcarddetailsfragment;
        paymentcarddetailsfragment = new PaymentCardDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("am I in checkout or account?", i1);
        bundle.putInt("add or edit mode", j1);
        bundle.putParcelable("order review", orderreview);
        bundle.putBoolean("applyBillingAddressAsShippingAddress", flag);
        bundle.putParcelable("payment card information model", paymentcardinformationmodel);
        paymentcarddetailsfragment.setArguments(bundle);
        i1;
        JVM INSTR tableswitch 1 2: default 88
    //                   1 110
    //                   2 91;
           goto _L1 _L2 _L3
_L1:
        return paymentcarddetailsfragment;
_L3:
        if (b1 != null)
        {
            paymentcarddetailsfragment.setTargetFragment((Fragment)b1, 0);
            return paymentcarddetailsfragment;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (c1 != null)
        {
            paymentcarddetailsfragment.setTargetFragment((Fragment)c1, 0);
            return paymentcarddetailsfragment;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public static PaymentCardDetailsFragment a(OrderReview orderreview, PaymentCardInformationModel paymentcardinformationmodel, boolean flag, com.target.ui.view.checkout.c c1)
    {
        if (c1 != null && !(c1 instanceof Fragment))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(com/target/ui/view/checkout/c.getSimpleName()).append(" must be an ").append("instance of ").append(android/support/v4/app/Fragment.getSimpleName()).toString());
        } else
        {
            return a(1, 2, flag, paymentcardinformationmodel, null, orderreview, c1);
        }
    }

    public static PaymentCardDetailsFragment a(OrderReview orderreview, boolean flag, com.target.ui.view.checkout.c c1)
    {
        if (c1 != null && !(c1 instanceof Fragment))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(com/target/ui/view/checkout/c.getSimpleName()).append(" must be an ").append("instance of ").append(android/support/v4/app/Fragment.getSimpleName()).toString());
        } else
        {
            return a(1, 1, flag, null, null, orderreview, c1);
        }
    }

    public static PaymentCardDetailsFragment a(com.target.ui.fragment.account.b b1)
    {
        if (b1 != null && !(b1 instanceof Fragment))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(com/target/ui/fragment/account/b.getSimpleName()).append(" must be an instance of ").append(android/support/v4/app/Fragment.getSimpleName()).toString());
        } else
        {
            return a(2, 1, false, null, b1, null, null);
        }
    }

    public static PaymentCardDetailsFragment a(PaymentCardInformationModel paymentcardinformationmodel, com.target.ui.fragment.account.b b1)
        throws IllegalArgumentException
    {
        if (b1 != null && !(b1 instanceof Fragment))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(com/target/ui/fragment/account/b.getSimpleName()).append(" must be an instance of ").append(android/support/v4/app/Fragment.getSimpleName()).toString());
        } else
        {
            return a(2, 2, false, paymentcardinformationmodel, b1, null, null);
        }
    }

    static e a(PaymentCardDetailsFragment paymentcarddetailsfragment)
    {
        return paymentcarddetailsfragment.mPresenter;
    }

    private void g(boolean flag)
    {
        if (flag)
        {
            al.a(mViews.errorContainer, new View[] {
                mViews.paymentDetailsContainer
            });
            return;
        } else
        {
            al.a(mViews.paymentDetailsContainer, new View[] {
                mViews.errorContainer
            });
            return;
        }
    }

    private e t()
    {
        int i1 = z();
        switch (i1)
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Tried to initialize a presenter, but found no valid ").append(com/target/ui/fragment/payment/PaymentCardDetailsFragment$a.getSimpleName()).append(".  Found ").append(i1).append(" instead.").toString());

        case 1: // '\001'
            return u();

        case 2: // '\002'
            return v();
        }
    }

    private com.target.ui.fragment.payment.b.c u()
    {
        int i1 = y();
        switch (i1)
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Tried to initialize a presenter but found no valid ").append(com/target/ui/fragment/payment/b/e$a.getSimpleName()).append(".  Found ").append(i1).append(" instead.").toString());

        case 2: // '\002'
            return new com.target.ui.fragment.payment.b.c(A(), B(), C(), new g(), new com.target.ui.service.provider.f(), w());

        case 1: // '\001'
            return new com.target.ui.fragment.payment.b.c(A(), B(), new g(), new com.target.ui.service.provider.f(), w());
        }
    }

    private com.target.ui.fragment.payment.b.a v()
    {
        int i1 = y();
        switch (i1)
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Tried to initialize a presenter but found no valid ").append(com/target/ui/fragment/payment/b/e$a.getSimpleName()).append(".  Found ").append(i1).append(" instead.").toString());

        case 2: // '\002'
            return new com.target.ui.fragment.payment.b.a(C(), new com.target.ui.helper.a.a(), new com.target.ui.service.provider.f());

        case 1: // '\001'
            return new com.target.ui.fragment.payment.b.a(new com.target.ui.helper.a.a(), new com.target.ui.service.provider.f());
        }
    }

    private com.target.ui.view.checkout.c w()
    {
        Fragment fragment = getTargetFragment();
        if (!(fragment instanceof com.target.ui.view.checkout.c))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Target fragment must be an instance of ").append(com/target/ui/view/checkout/c.getSimpleName()).append(".  Found ").append(fragment.getClass().getSimpleName()).append(" instead.").toString());
        } else
        {
            return (com.target.ui.view.checkout.c)fragment;
        }
    }

    private com.target.ui.fragment.account.b x()
    {
        Fragment fragment = getTargetFragment();
        if (!(fragment instanceof com.target.ui.fragment.account.b))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Target fragment must be an instance of ").append(com/target/ui/fragment/account/b.getSimpleName()).append(".  Found ").append(fragment.getClass().getSimpleName()).append(" instead.").toString());
        } else
        {
            return (com.target.ui.fragment.account.b)fragment;
        }
    }

    private int y()
    {
        int i1 = getArguments().getInt("add or edit mode");
        switch (i1)
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Tried to retrieve the ").append(com/target/ui/fragment/payment/b/e$a.getSimpleName()).append(" from the ").append("argument bundle, but did not find a recognized value.  Found ").append(i1).append(" instead.").toString());

        case 2: // '\002'
            return 2;

        case 1: // '\001'
            return 1;
        }
    }

    private int z()
    {
        return getArguments().getInt("am I in checkout or account?");
    }

    public void A_()
    {
        mPresenter.g();
    }

    public void a()
    {
        mPresenter.f();
    }

    public void a(int i1)
    {
        j(getString(i1));
    }

    public void a(Menu menu, MenuInflater menuinflater, int i1)
    {
        menuinflater.inflate(i1, menu);
    }

    public void a(View view, boolean flag)
    {
        mPresenter.a(flag);
    }

    public void a(com.target.mothership.common.tender.a a1, String s1)
    {
        mPresenter.e(s1);
    }

    public void a(com.target.mothership.model.c.c.a a1)
    {
        mViews.billingView.a(a1);
    }

    public void a(Guest guest)
    {
        mPresenter.a(guest);
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
        if (Z())
        {
            return;
        }
        if (mPaymentCardChangeListener != null && a1 != null)
        {
            mPaymentCardChangeListener.a(a1);
        }
        com.target.ui.util.e.a.a(this);
        m().b();
    }

    public void a(BillingCardDetailsModel billingcarddetailsmodel)
    {
        mViews.billingView.a(billingcarddetailsmodel);
    }

    public void a(CardDataModel carddatamodel)
    {
        if (Z())
        {
            return;
        } else
        {
            SecurityCodeDialogFragment.a(carddatamodel, this).show(getFragmentManager(), SecurityCodeDialogFragment.TAG);
            return;
        }
    }

    public void a(String s1)
    {
        mPresenter.c(s1);
    }

    public void a(boolean flag)
    {
        mViews.billingView.a(flag);
    }

    public boolean a(com.target.ui.e.e e1)
    {
        return mPresenter.c();
    }

    public com.target.ui.view.checkout.BillingView.c b()
    {
        return mViews.billingView.b();
    }

    public void b(int i1)
    {
        mViews.button.setText(i1);
    }

    public void b(BillingCardDetailsModel billingcarddetailsmodel)
    {
    }

    public void b(Object obj)
    {
        mPresenter.b(obj);
    }

    public void b(String s1)
    {
        mPresenter.b(s1);
    }

    public void c()
    {
        mPresenter.h();
    }

    public void c(int i1)
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

    public void c(String s1)
    {
        mPresenter.d(s1);
    }

    public void c(boolean flag)
    {
        mViews.setAsDefault.setChecked(flag);
    }

    public void d(int i1)
    {
        ai.a(this, i1);
    }

    public void d(String s1)
    {
        mViews.billingView.a(s1);
    }

    public void d(boolean flag)
    {
        if (flag)
        {
            al.b(mViews.setAsDefault.getView());
            mViews.setAsDefault.setText(getString(0x7f090091));
            return;
        } else
        {
            al.c(mViews.setAsDefault.getView());
            return;
        }
    }

    public com.target.ui.view.checkout.BillingView.b e()
    {
        return mViews.billingView.a();
    }

    public void e(String s1)
    {
        mPresenter.a(s1);
    }

    public void e(boolean flag)
    {
        mViews.button.setEnabled(flag);
    }

    public void f(boolean flag)
    {
        o(flag);
    }

    public void g()
    {
        if (Z())
        {
            return;
        } else
        {
            com.target.ui.util.e.a.a(this);
            m().a();
            return;
        }
    }

    public void h()
        throws IllegalStateException
    {
        if (Z())
        {
            return;
        }
        if (z() != 1)
        {
            throw new IllegalStateException("Cannot navigate back to cart because we're not currently in the context of checkout, thus the cart page does not exist on the back stack");
        } else
        {
            m().a(CartHomeFragment.TAG);
            return;
        }
    }

    public void i()
        throws IllegalStateException
    {
        if (Z())
        {
            return;
        }
        if (z() != 1)
        {
            throw new IllegalStateException("Cannot navigate back to checkout when in the context of Account.  The checkout fragments do not exist in the back stack.");
        } else
        {
            m().a(CheckoutHomeFragment.TAG);
            return;
        }
    }

    public void j()
    {
        g(false);
        f(false);
    }

    public void k()
    {
        if (Z())
        {
            return;
        } else
        {
            com.target.ui.fragment.payment.PaymentCardDeleteDialogFragment.a(this).show(getFragmentManager(), PaymentCardDeleteDialogFragment.TAG);
            return;
        }
    }

    public com.target.ui.fragment.account.BaseAccountDialog.c l()
    {
        return this;
    }

    public com.target.ui.fragment.account.BaseAccountDialog.e n()
    {
        return s();
    }

    public void n_()
    {
        mPresenter.i();
    }

    public void o()
    {
        mViews.errorContainer.a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
        g(true);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (getTargetFragment() == null)
        {
            throw new IllegalStateException("Unable to retrieve target fragment listener because the target fragment is unexpectedly null");
        }
        switch (z())
        {
        default:
            return;

        case 2: // '\002'
            mPaymentCardChangeListener = x();
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mPresenter = t();
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
        layoutinflater = layoutinflater.inflate(0x7f03006a, viewgroup, false);
        mViews = new Views(layoutinflater);
        mViews.billingView.setActionListener(this);
        mViews.billingView.setInputValidationListener(this);
        mViews.billingView.setPaymentCardEntryActionListener(this);
        mViews.errorContainer.setClickListener(this);
        mViews.button.setOnClickListener(mActionButtonClickListener);
        mPresenter.a(this);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mPresenter.v_();
        mPresenter = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mPresenter.z_();
        mViews = null;
    }

    public void onDetach()
    {
        super.onDetach();
        mPaymentCardChangeListener = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131756548: 
            mPresenter.e();
            break;
        }
        return true;
    }

    public boolean p()
    {
        return mViews.setAsDefault.isChecked();
    }

    public void q()
    {
        mPresenter.j();
    }

    public void r()
    {
        if (Z())
        {
            return;
        } else
        {
            ScanCreditCardFragment scancreditcardfragment = ScanCreditCardFragment.b(this);
            m().c(scancreditcardfragment);
            return;
        }
    }

    public com.target.ui.fragment.account.BaseAccountDialog.a s()
    {
        return this;
    }
}
