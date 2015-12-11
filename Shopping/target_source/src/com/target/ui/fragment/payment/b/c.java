// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.payment.b;

import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.cart.interfaces.a.d;
import com.target.mothership.model.cart.interfaces.a.p;
import com.target.mothership.model.cart.interfaces.a.t;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.a.k;
import com.target.mothership.services.x;
import com.target.mothership.util.o;
import com.target.ui.fragment.account.a.a;
import com.target.ui.fragment.payment.a.b;
import com.target.ui.helper.c.g;
import com.target.ui.model.checkout.BillingCardDetailsModel;
import com.target.ui.model.checkout.PaymentCardInformationModel;
import com.target.ui.service.provider.m;
import com.target.ui.util.q;

// Referenced classes of package com.target.ui.fragment.payment.b:
//            e

public class c extends e
    implements com.target.ui.helper.c.g.c
{

    private static final String TAG = com/target/ui/fragment/payment/b/c.getSimpleName();
    private com.target.ui.view.checkout.c mCheckoutPaymentUpdateListener;
    private g mDataHelper;
    private m mGuestProvider;
    private int mMode;
    private OrderReview mOrderReview;
    private PaymentCardInformationModel mPaymentCardInformationModel;
    private b mPresentation;
    private boolean mShouldApplyBillingAddressAsShippingAddress;

    public c(OrderReview orderreview, boolean flag, g g1, m m1, com.target.ui.view.checkout.c c1)
    {
        mMode = 1;
        mOrderReview = orderreview;
        mShouldApplyBillingAddressAsShippingAddress = flag;
        mDataHelper = g1;
        mGuestProvider = m1;
        mCheckoutPaymentUpdateListener = c1;
    }

    public c(OrderReview orderreview, boolean flag, PaymentCardInformationModel paymentcardinformationmodel, g g1, m m1, com.target.ui.view.checkout.c c1)
    {
        mMode = 2;
        mOrderReview = orderreview;
        mShouldApplyBillingAddressAsShippingAddress = flag;
        mPaymentCardInformationModel = paymentcardinformationmodel;
        mDataHelper = g1;
        mGuestProvider = m1;
        mCheckoutPaymentUpdateListener = c1;
    }

    static b a(c c1)
    {
        return c1.mPresentation;
    }

    private boolean b(d d1)
    {
        if (d1 == null || d1.e() == null)
        {
            return false;
        }
        d1 = (com.target.mothership.model.cart.interfaces.a.d.a)d1.e();
        return d1 == com.target.mothership.model.cart.interfaces.a.d.a.ERR_TC_PIN_REQUIRED || d1 == com.target.mothership.model.cart.interfaces.a.d.a.ERR_CVV_REQUIRED;
    }

    private void f(String s)
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            q.a(TAG, "Attempted to apply a card using a security code but the current session was unexpectedly null");
            mPresentation.h();
            return;
        } else
        {
            mPresentation.f(true);
            mDataHelper.a(guest, mOrderReview, mPaymentCardInformationModel, s, this);
            return;
        }
    }

    private void l()
    {
        if (mPaymentCardInformationModel != null)
        {
            mPresentation.a(mPaymentCardInformationModel.a());
        }
        mPresentation.d(false);
        mPresentation.a(false);
        if (mGuestProvider.a() == null)
        {
            mPresentation.h();
            return;
        }
        switch (mMode)
        {
        default:
            q.a(TAG, (new StringBuilder()).append("Unrecognized ").append(com/target/ui/fragment/payment/b/e$a.getSimpleName()).append(": ").append(mMode).toString());
            return;

        case 1: // '\001'
            mPresentation.b(0x7f0901bc);
            mPresentation.e(false);
            return;

        case 2: // '\002'
            mPresentation.b(0x7f090283);
            break;
        }
        mPresentation.e(true);
    }

    private void m()
    {
        com.target.ui.view.checkout.BillingView.c c1 = mPresentation.b();
        if (!c1.a())
        {
            throw new IllegalStateException("Tried to show the security code dialog, but found no valid user inputs");
        } else
        {
            mPresentation.a(c1.b().a());
            return;
        }
    }

    private void n()
    {
        mPresentation.c(0x7f090278);
    }

    private void o()
    {
        (new Handler()).post(new Runnable() {

            final c this$0;

            public void run()
            {
                if (com.target.ui.fragment.payment.b.c.a(c.this) != null)
                {
                    com.target.ui.fragment.payment.b.c.a(c.this).h();
                }
            }

            
            {
                this$0 = c.this;
                super();
            }
        });
    }

    private void p()
    {
        Guest guest = mGuestProvider.a();
        String s;
        if (mMode == 2)
        {
            s = "edit an existing card";
        } else
        {
            s = "add a new card";
        }
        if (guest == null)
        {
            q.a(TAG, (new StringBuilder()).append("Attempted to ").append(s).append(" but the current session was unexpectedly null").toString());
            mPresentation.h();
            return;
        }
        com.target.ui.view.checkout.BillingView.c c1 = mPresentation.b();
        if (!c1.a())
        {
            q.a(TAG, (new StringBuilder()).append("Attempted to ").append(s).append(" but the current user inputs are not valid.").toString());
            mPresentation.d(0x7f0903ff);
            return;
        }
        mPresentation.f(true);
        switch (mMode)
        {
        default:
            q.a(TAG, (new StringBuilder()).append("Tried to handle a click on the done button, but found an unrecognized ").append(com/target/ui/fragment/payment/b/e$a.getSimpleName()).append(": ").append(mMode).toString());
            return;

        case 1: // '\001'
            mDataHelper.a(guest, mOrderReview, c1.b(), mShouldApplyBillingAddressAsShippingAddress, this);
            return;

        case 2: // '\002'
            mDataHelper.a(guest, mOrderReview, mPaymentCardInformationModel, c1.b(), mShouldApplyBillingAddressAsShippingAddress, this);
            break;
        }
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        switch (mMode)
        {
        default:
            q.a(TAG, (new StringBuilder()).append("Unrecognized ").append(com/target/ui/fragment/payment/b/e$a.getSimpleName()).append(": ").append(mMode).toString());
            return;

        case 2: // '\002'
            mPresentation.a(0x7f0901d3);
            mPresentation.a(menu, menuinflater, 0x7f120007);
            return;

        case 1: // '\001'
            mPresentation.a(0x7f0901bc);
            return;
        }
    }

    public void a(com.target.mothership.model.c.c.a.a a1)
    {
    }

    public void a(com.target.mothership.model.c.c.a a1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(a1);
            return;
        }
    }

    public void a(OrderReview orderreview)
    {
        if (mCheckoutPaymentUpdateListener != null)
        {
            mCheckoutPaymentUpdateListener.a(orderreview);
        }
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f(false);
            mPresentation.i();
            return;
        }
    }

    public void a(d d1)
    {
        if (mPresentation == null)
        {
            return;
        }
        mPresentation.f(false);
        if (b(d1))
        {
            m();
            return;
        } else
        {
            n();
            return;
        }
    }

    public void a(p p1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f(false);
            n();
            return;
        }
    }

    public void a(t t)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f(false);
            n();
            return;
        }
    }

    public void a(Guest guest)
    {
    }

    public void a(Guest guest, com.target.mothership.services.o o1)
    {
        if (mPresentation == null)
        {
            return;
        }
        if (guest.isAnonymous())
        {
            mDataHelper.a(guest, o1, this);
            return;
        } else
        {
            mPresentation.f(false);
            mPresentation.a(guest, o1);
            return;
        }
    }

    public void a(k k1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f(false);
            n();
            return;
        }
    }

    public void a(com.target.mothership.model.guest.interfaces.a.m m1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f(false);
            int i1 = com.target.ui.util.b.a(m1);
            mPresentation.c(i1);
            return;
        }
    }

    public void a(x x)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            n();
            return;
        }
    }

    public void a(b b1)
    {
        mPresentation = b1;
        if (mGuestProvider.a() == null)
        {
            o();
            return;
        } else
        {
            l();
            return;
        }
    }

    public void a(PaymentCardInformationModel paymentcardinformationmodel, d d1)
    {
        mPaymentCardInformationModel = paymentcardinformationmodel;
        if (mPresentation == null)
        {
            return;
        }
        mPresentation.f(false);
        if (b(d1))
        {
            m();
            return;
        } else
        {
            n();
            return;
        }
    }

    public volatile void a(Object obj)
    {
        a((b)obj);
    }

    public void a(String s)
    {
        if (com.target.mothership.util.o.e(s))
        {
            q.a(TAG, (new StringBuilder()).append("tried to handle a user-entered zip code, but it was not valid.  (").append(s).append(")").toString());
            return;
        } else
        {
            mDataHelper.a(s, this);
            return;
        }
    }

    public void a(boolean flag)
    {
        mPresentation.e(flag);
    }

    public void b(OrderReview orderreview)
    {
        if (mCheckoutPaymentUpdateListener != null)
        {
            mCheckoutPaymentUpdateListener.a(orderreview);
        }
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f(false);
            mPresentation.a(a.Delete);
            return;
        }
    }

    public void b(Guest guest)
    {
    }

    public void b(Object obj)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f(true);
            return;
        }
    }

    public void b(String s)
    {
        mPresentation.h();
    }

    public void c(OrderReview orderreview)
    {
        if (mCheckoutPaymentUpdateListener != null)
        {
            mCheckoutPaymentUpdateListener.a(orderreview);
        }
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f(false);
            mPresentation.i();
            return;
        }
    }

    public void c(String s)
    {
        mPresentation.h();
    }

    public boolean c()
    {
        mPresentation.d(0x7f090219);
        return false;
    }

    public void d()
    {
        p();
    }

    public void d(String s)
    {
        mPresentation.d(s);
    }

    public void e()
    {
        mPresentation.k();
    }

    public void e(String s)
    {
        f(s);
    }

    public void f()
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            q.a(TAG, "tried to delete the payment card, but the current session was unexpectedly null");
            mPresentation.g();
            return;
        }
        if (mMode != 2)
        {
            throw new IllegalStateException("Cannot delete payment card because we're not in edit mode.");
        }
        if (mPaymentCardInformationModel == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Cannot delete payment card because the local ").append(com/target/ui/model/checkout/PaymentCardInformationModel.getSimpleName()).append(" is unepexcetedly null").toString());
        } else
        {
            mPresentation.f(true);
            mDataHelper.a(guest, mOrderReview, mPaymentCardInformationModel, this);
            return;
        }
    }

    public void g()
    {
        l();
    }

    public void h()
    {
    }

    public void i()
    {
    }

    public void j()
    {
        mPresentation.r();
    }

    public void k()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f(false);
            mPresentation.o();
            return;
        }
    }

    public void q_()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f(false);
            mPresentation.c(0x7f09027b);
            return;
        }
    }

    public void v_()
    {
        mDataHelper = null;
        mPaymentCardInformationModel = null;
        mGuestProvider = null;
        mOrderReview = null;
    }

    public void z_()
    {
        mDataHelper.a();
        mPresentation = null;
    }

}
