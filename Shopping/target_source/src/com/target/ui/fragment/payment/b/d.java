// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.payment.b;

import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.cart.interfaces.a.n;
import com.target.mothership.model.cart.interfaces.a.p;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.o;
import com.target.ui.e.e;
import com.target.ui.fragment.payment.a.a;
import com.target.ui.helper.c.h;
import com.target.ui.model.checkout.PaymentCardInformationModel;
import com.target.ui.service.provider.m;
import com.target.ui.util.q;
import com.target.ui.view.checkout.c;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.payment.b:
//            f

public class d
    implements f, com.target.ui.helper.c.h.b
{

    private static final String TAG = com/target/ui/fragment/payment/b/d.getSimpleName();
    private h mDataHelper;
    private m mGuestProvider;
    private OrderReview mOrderReview;
    private a mPresentation;
    private c mUpdateListener;

    public d(h h1, m m1, OrderReview orderreview, c c1)
    {
        mGuestProvider = m1;
        mDataHelper = h1;
        mOrderReview = orderreview;
        mUpdateListener = c1;
    }

    private void j()
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            q.a(TAG, "Tried to refresh the payment card list, but session was unexpectedly null.");
            mPresentation.e();
            return;
        } else
        {
            mPresentation.d(true);
            mDataHelper.a(guest, mOrderReview, this);
            return;
        }
    }

    private void k()
    {
        mPresentation.b(0x7f090278);
    }

    public void a(int l)
    {
        if (mPresentation == null)
        {
            return;
        }
        mPresentation.d(false);
        switch (l)
        {
        default:
            mPresentation.b(0x7f09027b);
            return;

        case 30: // '\036'
            mPresentation.a(0x7f09027b, true);
            break;
        }
    }

    public void a(int l, Guest guest, o o)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.d(false);
            mPresentation.a(guest, o);
            return;
        }
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        mPresentation.a(0x7f120001, menu, menuinflater);
        mPresentation.a(0x7f090220);
    }

    public void a(OrderReview orderreview)
    {
        if (mUpdateListener != null)
        {
            mUpdateListener.a(orderreview);
        }
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.d(false);
            mPresentation.b();
            return;
        }
    }

    public void a(n n)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.d(false);
            mPresentation.a(0x7f090202, true);
            return;
        }
    }

    public void a(p p)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            k();
            return;
        }
    }

    public void a(com.target.ui.fragment.account.a.a a1)
    {
    }

    public void a(a a1)
    {
        mPresentation = a1;
        mPresentation.c(true);
        mPresentation.e(true);
        j();
    }

    public void a(PaymentCardInformationModel paymentcardinformationmodel)
    {
        if (paymentcardinformationmodel == null || paymentcardinformationmodel.b())
        {
            mPresentation.b();
            return;
        }
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            mPresentation.e();
            return;
        } else
        {
            mPresentation.d(true);
            mDataHelper.a(guest, mOrderReview, paymentcardinformationmodel, null, this);
            return;
        }
    }

    public void a(PaymentCardInformationModel paymentcardinformationmodel, com.target.mothership.model.cart.interfaces.a.d d1)
    {
        if (mPresentation != null)
        {
            mPresentation.d(false);
            d1 = d1.f();
            if (d1.isEmpty())
            {
                k();
                return;
            }
            d1 = d1.iterator();
            do
            {
                if (!d1.hasNext())
                {
                    continue;
                }
                com.target.mothership.model.cart.interfaces.a.a a1 = (com.target.mothership.model.cart.interfaces.a.a)d1.next();
                static class _cls1
                {

                    static final int $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyPaymentInstructionFailure$ApplyPaymentInstructionFailureReason[];

                    static 
                    {
                        $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyPaymentInstructionFailure$ApplyPaymentInstructionFailureReason = new int[com.target.mothership.model.cart.interfaces.a.a.values().length];
                        try
                        {
                            $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyPaymentInstructionFailure$ApplyPaymentInstructionFailureReason[com.target.mothership.model.cart.interfaces.a.a.ERR_TC_PIN_REQUIRED.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyPaymentInstructionFailure$ApplyPaymentInstructionFailureReason[com.target.mothership.model.cart.interfaces.a.a.ERR_CVV_REQUIRED.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyPaymentInstructionFailure$ApplyPaymentInstructionFailureReason[com.target.mothership.model.cart.interfaces.a.a.ERR_CART_UNKNOWN.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (_cls1..SwitchMap.com.target.mothership.model.cart.interfaces.error.ApplyPaymentInstructionFailure.ApplyPaymentInstructionFailureReason[a1.ordinal()])
                {
                default:
                    k();
                    break;

                case 1: // '\001'
                case 2: // '\002'
                    mPresentation.d(paymentcardinformationmodel);
                    break;
                }
            } while (true);
        }
        break MISSING_BLOCK_LABEL_108;
        while (true) 
        {
            return;
        }
    }

    public void a(PaymentCardInformationModel paymentcardinformationmodel, String s)
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            mPresentation.e();
            return;
        } else
        {
            mPresentation.d(true);
            mDataHelper.a(guest, mOrderReview, paymentcardinformationmodel, s, this);
            return;
        }
    }

    public volatile void a(Object obj)
    {
        a((a)obj);
    }

    public void a(List list)
    {
        while (mPresentation == null || list != null && !list.isEmpty()) 
        {
            return;
        }
        mPresentation.a(0x7f09027a, true);
    }

    public boolean a(e e1)
    {
        mPresentation.d(0x7f090219);
        return true;
    }

    public void b(PaymentCardInformationModel paymentcardinformationmodel)
    {
        mPresentation.a(mOrderReview, paymentcardinformationmodel);
    }

    public void b(List list)
    {
        while (mPresentation == null || list != null && !list.isEmpty()) 
        {
            return;
        }
        mPresentation.a(0x7f09027a, true);
    }

    public void c()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.g();
            return;
        }
    }

    public void c(PaymentCardInformationModel paymentcardinformationmodel)
    {
    }

    public void c(List list)
    {
        if (mPresentation == null)
        {
            return;
        }
        mPresentation.d(false);
        if (list.isEmpty())
        {
            mPresentation.a(0x7f0901c5, 0x7f0901bd);
            return;
        } else
        {
            mPresentation.a(list);
            return;
        }
    }

    public void d()
    {
        mPresentation.a(mOrderReview);
    }

    public void e()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.d(true);
            return;
        }
    }

    public void f()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            j();
            return;
        }
    }

    public void g()
    {
        mPresentation.e();
    }

    public void h()
    {
        mPresentation.e();
    }

    public void i()
    {
        j();
    }

    public void v_()
    {
        mDataHelper = null;
    }

    public void z_()
    {
        mPresentation = null;
    }

}
