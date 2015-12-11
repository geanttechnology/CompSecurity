// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shipping.a;

import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.a.f;
import com.target.mothership.model.guest.interfaces.a.l;
import com.target.mothership.services.o;
import com.target.ui.g.a;
import com.target.ui.service.provider.m;
import com.target.ui.util.b;

public abstract class e
    implements com.target.ui.fragment.account.BaseAccountDialog.a, com.target.ui.g.a
{
    public static interface a
    {

        public abstract void a(GuestAddress guestaddress, OrderReview orderreview);

        public abstract void a(com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1, OrderReview orderreview);

        public abstract void i();
    }


    protected com.target.ui.service.provider.b mConnectivityProvider;
    protected GuestAddress mGuestAddress;
    protected m mGuestProvider;
    protected boolean mIsEditMode;
    protected boolean mIsThisAddressCurrentlySelected;
    protected GuestAddress mNewGuestAddress;
    protected com.target.ui.fragment.shipping.b.a mPresentation;
    protected a mShippingActionListener;

    public e(m m, GuestAddress guestaddress, GuestAddress guestaddress1, boolean flag, boolean flag1, com.target.ui.service.provider.b b1)
    {
        mGuestProvider = m;
        mGuestAddress = guestaddress;
        mNewGuestAddress = guestaddress1;
        mIsThisAddressCurrentlySelected = flag1;
        mIsEditMode = flag;
        mConnectivityProvider = b1;
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        if (mIsEditMode)
        {
            mPresentation.a(menu, menuinflater);
            mPresentation.b(menu, menuinflater);
            return;
        } else
        {
            mPresentation.c(menu, menuinflater);
            return;
        }
    }

    public void a(com.target.mothership.model.c.c.a.a a1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f(false);
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
            mPresentation.a(a1);
            return;
        }
    }

    protected abstract void a(GuestAddress guestaddress);

    public void a(Guest guest)
    {
    }

    protected abstract void a(Guest guest, com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1);

    public void a(f f1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f(false);
            mPresentation.a(com.target.ui.util.b.a(f1));
            return;
        }
    }

    public void a(l l1)
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

    protected abstract void a(com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1);

    public void a(a a1)
    {
        mShippingActionListener = a1;
    }

    public void a(com.target.ui.fragment.shipping.b.a a1)
    {
        mPresentation = a1;
        e();
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.shipping.b.a)obj);
    }

    public void a(String s)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.k();
            return;
        }
    }

    public abstract void a(boolean flag);

    public void b(Guest guest)
    {
        if (mPresentation == null)
        {
            return;
        }
        if (mIsThisAddressCurrentlySelected)
        {
            if (mNewGuestAddress != null)
            {
                a(mNewGuestAddress);
                return;
            } else
            {
                c(guest);
                return;
            }
        } else
        {
            h();
            return;
        }
    }

    protected abstract void b(Guest guest, o o);

    protected abstract void b(com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1);

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
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.k();
            return;
        }
    }

    public void b(boolean flag)
    {
        if (mIsEditMode)
        {
            mPresentation.a(flag);
            return;
        } else
        {
            mPresentation.c(flag);
            return;
        }
    }

    public void c()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f(false);
            mPresentation.e(true);
            return;
        }
    }

    protected void c(Guest guest)
    {
        h();
    }

    protected void c(Guest guest, o o)
    {
        if (mPresentation == null)
        {
            return;
        }
        mPresentation.f(false);
        if (!mConnectivityProvider.a())
        {
            mPresentation.i();
            return;
        }
        if (guest.isAnonymous())
        {
            b(guest, o);
            return;
        } else
        {
            mPresentation.a(guest, o);
            return;
        }
    }

    protected void c(com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f(false);
            f();
            return;
        }
    }

    public abstract void c(String s);

    public void d(com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1)
    {
        if (mIsThisAddressCurrentlySelected && com.target.ui.service.a.a().c().b())
        {
            a((Guest)com.target.ui.service.a.a().c().c(), a1);
            return;
        } else
        {
            c(a1);
            return;
        }
    }

    public void e()
    {
        if (mPresentation == null)
        {
            return;
        }
        if (mIsEditMode)
        {
            mPresentation.a(mGuestAddress);
            mPresentation.a(mPresentation.o());
            return;
        } else
        {
            mPresentation.e();
            mPresentation.c(false);
            return;
        }
    }

    public void e(com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1)
    {
        if (!mConnectivityProvider.a())
        {
            mPresentation.i();
            return;
        }
        mPresentation.f(true);
        if (!mPresentation.o())
        {
            mPresentation.f(false);
            return;
        }
        if (mIsEditMode)
        {
            a(a1);
            return;
        } else
        {
            b(a1);
            return;
        }
    }

    protected abstract void f();

    protected abstract void g();

    protected void h()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.f(false);
            f();
            return;
        }
    }

    public void k()
    {
        if (!mConnectivityProvider.a())
        {
            mPresentation.i();
            return;
        } else
        {
            mPresentation.b();
            return;
        }
    }

    public void l()
    {
        if (mPresentation == null)
        {
            return;
        }
        if (!mConnectivityProvider.a())
        {
            mPresentation.i();
            return;
        } else
        {
            mPresentation.f(true);
            g();
            return;
        }
    }

    public void n_()
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

    public void v_()
    {
    }

    public void z_()
    {
        mPresentation = null;
    }
}
