// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shipping.a;

import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.cart.interfaces.a.p;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.o;
import com.target.ui.f.c;
import com.target.ui.fragment.shipping.ShippingAddressDetailsFragment;
import com.target.ui.helper.c.f;
import com.target.ui.helper.c.i;
import com.target.ui.service.provider.b;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.shipping.a:
//            f

public class d extends com.target.ui.fragment.shipping.a.f
    implements com.target.ui.helper.c.f.a, com.target.ui.helper.c.i.a
{

    public static final String TAG = com/target/ui/fragment/shipping/a/d.getSimpleName();
    protected f mCheckoutShippingListDataHelper;
    protected b mConnectivityProvider;
    protected OrderReview mOrderReview;
    protected List mProductList;
    protected i mUpdateOrderDataHelper;

    public d(b b1, f f1, i j, OrderReview orderreview, List list)
    {
        super(b1);
        mCheckoutShippingListDataHelper = f1;
        mUpdateOrderDataHelper = j;
        mOrderReview = orderreview;
        mProductList = list;
        mConnectivityProvider = b1;
    }

    private void b(GuestAddress guestaddress)
    {
        if (!mConnectivityProvider.a())
        {
            mPresentation.g();
            return;
        } else
        {
            mUpdateOrderDataHelper.a(guestaddress, this);
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
            mPresentation.h();
            return;
        }
    }

    public void a(GuestAddress guestaddress, OrderReview orderreview)
    {
        while (mShippingActionListener == null || mPresentation == null) 
        {
            return;
        }
        mPresentation.c(false);
        if (guestaddress != null)
        {
            mShippingActionListener.a(guestaddress, orderreview);
        }
        mPresentation.r();
    }

    public void a(c c1)
    {
        c1.d(ShippingAddressDetailsFragment.a(false, mOrderReview, (ArrayList)mProductList, null, false, null, mShippingActionListener));
    }

    public void a(com.target.ui.fragment.shipping.b.b b1)
    {
        super.a(b1);
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.shipping.b.b)obj);
    }

    public volatile void a(Object obj, OrderReview orderreview)
    {
        a((GuestAddress)obj, orderreview);
    }

    protected void a(List list)
    {
        if (mPresentation == null)
        {
            return;
        }
        mPresentation.c(false);
        if (list.isEmpty())
        {
            mPresentation.a(false);
            mPresentation.d(true);
        } else
        {
            mPresentation.a(true);
            mPresentation.d(false);
        }
        mShippingAddressList = list;
        mPresentation.a(mShippingAddressList, true);
    }

    public void a(boolean flag, GuestAddress guestaddress, c c1)
    {
        if (mShippingActionListener == null)
        {
            return;
        } else
        {
            c1.d(ShippingAddressDetailsFragment.a(true, mOrderReview, (ArrayList)mProductList, mSelectedGuestAddress, flag, guestaddress, mShippingActionListener));
            return;
        }
    }

    protected void b(Guest guest, o o)
    {
        mCheckoutShippingListDataHelper.a(guest, o, this);
    }

    protected void e()
    {
        mCheckoutShippingListDataHelper.a(this);
    }

    public void f()
    {
        if (mSelectedGuestAddress == null)
        {
            mPresentation.r();
            return;
        } else
        {
            mPresentation.c(true);
            b(mSelectedGuestAddress);
            return;
        }
    }

    public void i()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.h();
            return;
        }
    }

    public void v_()
    {
        super.v_();
        mUpdateOrderDataHelper = null;
        mCheckoutShippingListDataHelper = null;
    }

    public void z_()
    {
        super.z_();
        mCheckoutShippingListDataHelper.a();
    }

}
