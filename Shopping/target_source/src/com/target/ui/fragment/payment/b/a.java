// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.payment.b;

import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.common.tender.PaymentTender;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.a.k;
import com.target.mothership.util.o;
import com.target.ui.fragment.payment.a.b;
import com.target.ui.model.checkout.PaymentCardInformationModel;
import com.target.ui.service.provider.m;
import com.target.ui.util.e;
import com.target.ui.util.q;

// Referenced classes of package com.target.ui.fragment.payment.b:
//            e

public class a extends com.target.ui.fragment.payment.b.e
{

    private static final String TAG = com/target/ui/fragment/payment/b/a.getSimpleName();
    private com.target.ui.helper.a.a mDataHelper;
    private final com.target.ui.helper.a.h mDataListener;
    private PaymentCardInformationModel mExistingCard;
    private m mGuestProvider;
    private int mMode;
    private b mPresentation;
    private final com.target.ui.helper.a.j mZipCodeLookupListener;

    public a(com.target.ui.helper.a.a a1, m m1)
    {
        mDataListener = new com.target.ui.helper.a.h() {

            final a this$0;

            public void a()
            {
                if (a.a(a.this) == null)
                {
                    return;
                } else
                {
                    a.a(a.this).f(false);
                    a.a(a.this).a(com.target.ui.fragment.account.a.a.Delete);
                    return;
                }
            }

            public void a(PaymentTender paymenttender)
            {
                if (a.a(a.this) == null)
                {
                    return;
                } else
                {
                    a.a(a.this).f(false);
                    a.a(a.this).a(com.target.ui.fragment.account.a.a.Update);
                    return;
                }
            }

            public void a(Guest guest, com.target.mothership.services.o o1)
            {
                if (a.a(a.this) == null)
                {
                    return;
                } else
                {
                    a.a(a.this).f(false);
                    a.a(a.this).a(guest, o1);
                    return;
                }
            }

            public void a(com.target.mothership.model.guest.interfaces.a.b b1)
            {
                if (a.a(a.this) == null)
                {
                    return;
                } else
                {
                    a.a(a.this).f(false);
                    a.a(a.this).c(0x7f090278);
                    return;
                }
            }

            public void a(k k1)
            {
                if (a.a(a.this) == null)
                {
                    return;
                } else
                {
                    a.a(a.this).f(false);
                    a.a(a.this).c(0x7f090278);
                    return;
                }
            }

            public void a(com.target.mothership.model.guest.interfaces.a.m m2)
            {
                if (a.a(a.this) == null)
                {
                    return;
                } else
                {
                    a.a(a.this).f(false);
                    a.a(a.this).c(0x7f090278);
                    return;
                }
            }

            public void b(PaymentTender paymenttender)
            {
                if (a.a(a.this) == null)
                {
                    return;
                } else
                {
                    a.a(a.this).f(false);
                    a.a(a.this).a(com.target.ui.fragment.account.a.a.Create);
                    return;
                }
            }

            public void o_()
            {
                if (a.a(a.this) == null)
                {
                    return;
                } else
                {
                    a.a(a.this).f(false);
                    a.a(a.this).o();
                    return;
                }
            }

            public void q_()
            {
                if (a.a(a.this) == null)
                {
                    return;
                } else
                {
                    a.a(a.this).f(false);
                    a.a(a.this).c(0x7f09027b);
                    return;
                }
            }

            
            {
                this$0 = a.this;
                super();
            }
        };
        mZipCodeLookupListener = new com.target.ui.helper.a.j() {

            final a this$0;

            public void a(com.target.mothership.model.c.c.a.a a2)
            {
            }

            public void a(com.target.mothership.model.c.c.a a2)
            {
                if (a.a(a.this) == null)
                {
                    return;
                } else
                {
                    a.a(a.this).a(a2);
                    return;
                }
            }

            
            {
                this$0 = a.this;
                super();
            }
        };
        mMode = 1;
        mExistingCard = null;
        mDataHelper = a1;
        mGuestProvider = m1;
    }

    public a(PaymentCardInformationModel paymentcardinformationmodel, com.target.ui.helper.a.a a1, m m1)
    {
        mDataListener = new _cls1();
        mZipCodeLookupListener = new _cls2();
        mMode = 2;
        mExistingCard = paymentcardinformationmodel;
        mDataHelper = a1;
        mGuestProvider = m1;
    }

    static b a(a a1)
    {
        return a1.mPresentation;
    }

    private void a(Guest guest, com.target.ui.view.checkout.BillingView.b b1)
    {
        if (!b1.a())
        {
            q.a(TAG, "tried to edit an existing card, but address inputs were not valid");
            return;
        } else
        {
            mPresentation.f(true);
            mDataHelper.a(guest, mExistingCard.d(), mPresentation.p(), b1.b(), mDataListener);
            return;
        }
    }

    private void a(Guest guest, com.target.ui.view.checkout.BillingView.c c1)
    {
        if (!c1.a())
        {
            q.a(TAG, "tried to add a new card, but inputs were not valid.");
            return;
        } else
        {
            mPresentation.f(true);
            c1 = com.target.ui.util.e.a(c1.b(), mPresentation.p());
            mDataHelper.a(guest, c1, mDataListener);
            return;
        }
    }

    private void k()
    {
        mMode;
        JVM INSTR tableswitch 1 2: default 28
    //                   1 58
    //                   2 95;
           goto _L1 _L2 _L3
_L1:
        mPresentation.j();
        mPresentation.a(false);
        mPresentation.d(true);
        return;
_L2:
        mPresentation.b(0x7f0903f9);
        boolean flag = mPresentation.b().a();
        mPresentation.e(flag);
        continue; /* Loop/switch isn't completed */
_L3:
        mPresentation.b(0x7f090283);
        com.target.ui.model.checkout.BillingCardDetailsModel billingcarddetailsmodel = mExistingCard.a();
        mPresentation.a(billingcarddetailsmodel);
        mPresentation.c(mExistingCard.c());
        mPresentation.e(true);
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        switch (mMode)
        {
        default:
            return;

        case 1: // '\001'
            mPresentation.a(0x7f0903f9);
            return;

        case 2: // '\002'
            mPresentation.a(0x7f0903fe);
            break;
        }
        mPresentation.a(menu, menuinflater, 0x7f120007);
    }

    public void a(Guest guest)
    {
        k();
    }

    public void a(b b1)
    {
        mPresentation = b1;
        k();
    }

    public volatile void a(Object obj)
    {
        a((b)obj);
    }

    public void a(String s)
    {
        mDataHelper.a(s, mZipCodeLookupListener);
    }

    public void a(boolean flag)
    {
        mPresentation.e(flag);
    }

    public void b(Object obj)
    {
        mPresentation.f(true);
    }

    public void b(String s)
    {
        mPresentation.g();
    }

    public void c(String s)
    {
        mPresentation.g();
    }

    public boolean c()
    {
        mDataHelper.a();
        mPresentation.f(false);
        mPresentation.a(null);
        return true;
    }

    public void d()
    {
        Object obj = mGuestProvider.a();
        if (obj == null)
        {
            if (mMode == 1)
            {
                obj = "add mode";
            } else
            {
                obj = "edit mode";
            }
            q.a(TAG, (new StringBuilder()).append("User pressed the done button in ").append(((String) (obj))).append(", tried to ").append("invoke network call but current guest is unexpectedly null").toString());
            mPresentation.g();
            return;
        }
        switch (mMode)
        {
        default:
            return;

        case 1: // '\001'
            a(((Guest) (obj)), mPresentation.b());
            return;

        case 2: // '\002'
            a(((Guest) (obj)), mPresentation.e());
            break;
        }
    }

    public void d(String s)
    {
        if (o.f(s))
        {
            mPresentation.d(s);
        }
    }

    public void e()
    {
        mPresentation.k();
    }

    public void e(String s)
    {
    }

    public void f()
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            q.a(TAG, "tried to delete payment card but the current guest is null.");
            mPresentation.g();
            return;
        } else
        {
            mPresentation.f(true);
            mDataHelper.a(guest, mExistingCard.d(), mDataListener);
            return;
        }
    }

    public void g()
    {
        k();
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

    public void v_()
    {
        mDataHelper = null;
        mGuestProvider = null;
        mExistingCard = null;
    }

    public void z_()
    {
        mDataHelper.a();
        mPresentation = null;
    }

}
