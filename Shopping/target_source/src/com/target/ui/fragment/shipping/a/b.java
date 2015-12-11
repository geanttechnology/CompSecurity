// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shipping.a;

import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.o;
import com.target.ui.f.c;
import com.target.ui.fragment.shipping.ShippingAddressDetailsFragment;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.shipping.a:
//            f

public class b extends f
    implements com.target.ui.helper.c.a
{

    private com.target.ui.helper.c.b mDataHelper;

    public b(com.target.ui.service.provider.b b1, com.target.ui.helper.c.b b2)
    {
        super(b1);
        mDataHelper = b2;
    }

    public void a(c c1)
    {
        c1.d(ShippingAddressDetailsFragment.a(false, mSelectedGuestAddress, false, null, mShippingActionListener));
    }

    public void a(com.target.ui.fragment.shipping.b.b b1)
    {
        super.a(b1);
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.shipping.b.b)obj);
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
            mPresentation.d(true);
        } else
        {
            mPresentation.d(false);
        }
        mPresentation.a(false);
        mShippingAddressList = list;
        mPresentation.a(mShippingAddressList, false);
    }

    public void a(boolean flag, GuestAddress guestaddress, c c1)
    {
        if (mShippingActionListener == null)
        {
            return;
        } else
        {
            c1.d(ShippingAddressDetailsFragment.a(true, mSelectedGuestAddress, flag, guestaddress, mShippingActionListener));
            return;
        }
    }

    protected void b(Guest guest, o o)
    {
        mDataHelper.a(guest, o, this);
    }

    protected void e()
    {
        mDataHelper.a(this);
    }

    public void f()
    {
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
