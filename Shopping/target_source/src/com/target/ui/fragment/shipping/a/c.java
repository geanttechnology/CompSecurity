// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shipping.a;

import com.target.mothership.common.params.AddressParams;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.cart.interfaces.a.p;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.common.PhoneNumber;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.a.f;
import com.target.mothership.util.o;
import com.target.ui.fragment.shipping.b.a;
import com.target.ui.helper.c.e;
import com.target.ui.helper.c.i;
import com.target.ui.service.provider.m;
import com.target.ui.util.d.b;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.shipping.a:
//            e

public class c extends com.target.ui.fragment.shipping.a.e
    implements com.target.ui.helper.c.e.a, com.target.ui.helper.c.i.a
{
    private static class a
        implements com.target.ui.helper.c.i.a
    {

        final c mPresenter;

        public void a(p p)
        {
            mPresenter.a(p);
        }

        public void a(Guest guest, com.target.mothership.services.o o1)
        {
            mPresenter.a(guest, o1);
        }

        public void a(com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1, OrderReview orderreview)
        {
            com.target.ui.fragment.shipping.a.c.a(mPresenter, a1, orderreview);
        }

        public volatile void a(Object obj, OrderReview orderreview)
        {
            a((com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a)obj, orderreview);
        }

        public void i()
        {
            mPresenter.i();
        }

        public void q_()
        {
            mPresenter.q_();
        }

        private a(c c1)
        {
            mPresenter = c1;
        }

    }


    private static final String DEFAULT_COUNTRY = "US";
    private final com.target.ui.helper.c.i.a mAddressDetailsHolderCallbacks = new a(this);
    private e mCheckoutShippingDetailsDataHelper;
    private i mUpdateOrderDataHelper;

    public c(e e1, m m1, i k, GuestAddress guestaddress, GuestAddress guestaddress1, boolean flag, boolean flag1, 
            com.target.ui.service.provider.b b1)
    {
        super(m1, guestaddress, guestaddress1, flag, flag1, b1);
        mCheckoutShippingDetailsDataHelper = e1;
        mUpdateOrderDataHelper = k;
    }

    private void a(com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1, OrderReview orderreview)
    {
        if (mPresentation == null)
        {
            return;
        }
        mPresentation.f(false);
        if (mShippingActionListener != null)
        {
            if (a1 != null)
            {
                mShippingActionListener.a(a1, orderreview);
            } else
            {
                mShippingActionListener.a(null, orderreview);
            }
        }
        f();
    }

    static void a(c c1, com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1, OrderReview orderreview)
    {
        c1.a(a1, orderreview);
    }

    private void m()
    {
        if (com.target.ui.util.e.b(mCheckoutShippingDetailsDataHelper.b()))
        {
            mPresentation.d(true);
            return;
        } else
        {
            mPresentation.d(false);
            return;
        }
    }

    private void n()
    {
        mPresentation.a(false, false);
    }

    public void a(com.target.mothership.model.c.c.a.a a1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            super.a(a1);
            return;
        }
    }

    public void a(com.target.mothership.model.c.c.a a1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            super.a(a1);
            return;
        }
    }

    public void a(com.target.mothership.model.cart.interfaces.a.a a1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f(false);
            mPresentation.j();
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
            mPresentation.j();
            return;
        }
    }

    protected void a(GuestAddress guestaddress)
    {
        mUpdateOrderDataHelper.a(guestaddress, this);
    }

    public void a(GuestAddress guestaddress, OrderReview orderreview)
    {
        if (mPresentation == null)
        {
            return;
        }
        mPresentation.f(false);
        if (mShippingActionListener != null)
        {
            mShippingActionListener.a(guestaddress, orderreview);
        }
        f();
    }

    public void a(Guest guest, com.target.mothership.services.o o1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            c(guest, o1);
            return;
        }
    }

    protected void a(Guest guest, com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1)
    {
        mUpdateOrderDataHelper.a(guest, a1, mAddressDetailsHolderCallbacks);
    }

    public void a(f f1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            super.a(f1);
            return;
        }
    }

    protected void a(com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(a1.addressLine);
        if (o.g(a1.apartment))
        {
            arraylist.add(a1.apartment);
        }
        com.target.mothership.model.common.a a2 = com.target.mothership.model.common.a.Shipping;
        String s = a1.city;
        String s1 = a1.state;
        String s2 = a1.zipCode;
        String s3 = mGuestAddress.getCountry();
        String s4 = a1.firstName;
        String s5 = a1.lastName;
        String s6 = com.target.ui.util.d.b.g(a1.phoneNumber);
        Object obj;
        if (mGuestAddress.d() != null)
        {
            obj = mGuestAddress.d().b();
        } else
        {
            obj = com.target.mothership.model.common.c.Home;
        }
        obj = new AddressParams(a2, arraylist, s, s1, s2, s3, s4, "", s5, s6, ((com.target.mothership.model.common.c) (obj)), true);
        mCheckoutShippingDetailsDataHelper.a(mGuestProvider.a(), mGuestAddress, ((AddressParams) (obj)), a1, this);
    }

    public void a(com.target.ui.fragment.shipping.b.a a1)
    {
        super.a(a1);
        m();
        n();
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.shipping.b.a)obj);
    }

    public volatile void a(Object obj, OrderReview orderreview)
    {
        a((GuestAddress)obj, orderreview);
    }

    public void a(boolean flag)
    {
    }

    public void b(Guest guest)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            super.b(guest);
            return;
        }
    }

    protected void b(Guest guest, com.target.mothership.services.o o1)
    {
        mCheckoutShippingDetailsDataHelper.a(guest, o1, this);
    }

    public void b(Guest guest, com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mUpdateOrderDataHelper.a(guest, a1, mAddressDetailsHolderCallbacks);
            return;
        }
    }

    protected void b(com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1)
    {
        Object obj = new ArrayList();
        ((List) (obj)).add(a1.addressLine);
        if (o.g(a1.apartment))
        {
            ((List) (obj)).add(a1.apartment);
        }
        obj = new AddressParams(com.target.mothership.model.common.a.Shipping, ((List) (obj)), a1.city, a1.state, a1.zipCode, "US", a1.firstName, "", a1.lastName, com.target.ui.util.d.b.g(a1.phoneNumber), com.target.mothership.model.common.c.Home, true);
        mCheckoutShippingDetailsDataHelper.a(mGuestProvider.a(), ((AddressParams) (obj)), a1, this);
    }

    protected void c(Guest guest)
    {
        a(guest, ((com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a) (null)));
    }

    public void c(String s)
    {
        mCheckoutShippingDetailsDataHelper.a(s, this);
    }

    public void d(com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            super.d(a1);
            return;
        }
    }

    public void e()
    {
        super.e();
        m();
        n();
    }

    protected void f()
    {
        mPresentation.h();
    }

    protected void g()
    {
        mCheckoutShippingDetailsDataHelper.a(mGuestProvider.a(), mGuestAddress, this);
    }

    public void i()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f(false);
            mPresentation.j();
            return;
        }
    }

    public void j()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.j();
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
            mPresentation.a(0x7f09027b);
            return;
        }
    }

    public void v_()
    {
        super.v_();
        mCheckoutShippingDetailsDataHelper = null;
        mUpdateOrderDataHelper = null;
    }

    public void z_()
    {
        super.z_();
        mUpdateOrderDataHelper.a();
        mCheckoutShippingDetailsDataHelper.a();
    }
}
