// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shipping.a;

import com.target.mothership.common.params.AddressParams;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.common.PhoneNumber;
import com.target.mothership.model.common.c;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.a.e;
import com.target.mothership.model.guest.interfaces.a.f;
import com.target.mothership.util.o;
import com.target.ui.service.provider.m;
import com.target.ui.util.d.b;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.shipping.a:
//            e

public class a extends com.target.ui.fragment.shipping.a.e
    implements com.target.ui.helper.c.a
{

    private static final String DEFAULT_COUNTRY = "US";
    private com.target.ui.helper.c.a mDataHelper;
    private boolean mIsPrimary;

    public a(com.target.ui.helper.c.a a1, m m1, GuestAddress guestaddress, GuestAddress guestaddress1, boolean flag, boolean flag1, com.target.ui.service.provider.b b1)
    {
        super(m1, guestaddress, guestaddress1, flag, flag1, b1);
        mDataHelper = a1;
        if (guestaddress != null)
        {
            flag = guestaddress.e().booleanValue();
        } else
        {
            flag = false;
        }
        mIsPrimary = flag;
    }

    private void j()
    {
        boolean flag;
        if (mGuestAddress != null)
        {
            flag = mGuestAddress.e().booleanValue();
        } else
        {
            flag = false;
        }
        mPresentation.a(true, flag);
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

    protected void a(GuestAddress guestaddress)
    {
        mShippingActionListener.i();
        mPresentation.f(false);
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
        mShippingActionListener.a(a1, null);
        mPresentation.f(false);
        f();
    }

    public void a(e e1)
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
            obj = c.Home;
        }
        obj = new AddressParams(a2, arraylist, s, s1, s2, s3, s4, "", s5, s6, ((c) (obj)), mIsPrimary);
        mDataHelper.a(mGuestProvider.a(), mGuestAddress, ((AddressParams) (obj)), a1, this);
    }

    public void a(com.target.ui.fragment.shipping.b.a a1)
    {
        super.a(a1);
        j();
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.shipping.b.a)obj);
    }

    public void a(boolean flag)
    {
        mIsPrimary = flag;
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
        mDataHelper.a(guest, o1, this);
    }

    public void b(Guest guest, com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1)
    {
        if (mPresentation == null)
        {
            return;
        }
        if (a1 != null)
        {
            mShippingActionListener.a(a1, null);
        }
        mPresentation.f(false);
        f();
    }

    protected void b(com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1)
    {
        Object obj = new ArrayList();
        ((List) (obj)).add(a1.addressLine);
        if (o.g(a1.apartment))
        {
            ((List) (obj)).add(a1.apartment);
        }
        obj = new AddressParams(com.target.mothership.model.common.a.Shipping, ((List) (obj)), a1.city, a1.state, a1.zipCode, "US", a1.firstName, "", a1.lastName, com.target.ui.util.d.b.g(a1.phoneNumber), c.Home, mIsPrimary);
        mDataHelper.a(mGuestProvider.a(), ((AddressParams) (obj)), a1, this);
    }

    protected void c(com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1)
    {
        if (a1 != null)
        {
            mShippingActionListener.a(a1, null);
        }
        super.c(a1);
    }

    public void c(String s)
    {
        mDataHelper.a(s, this);
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
        j();
    }

    protected void f()
    {
        mPresentation.g();
    }

    protected void g()
    {
        mDataHelper.a(mGuestProvider.a(), mGuestAddress, this);
    }

    protected void h()
    {
        mShippingActionListener.i();
        super.h();
    }

    public void i()
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
        mDataHelper = null;
    }

    public void z_()
    {
        super.z_();
        mDataHelper.a();
    }
}
