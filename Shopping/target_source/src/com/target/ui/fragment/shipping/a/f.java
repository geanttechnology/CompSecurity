// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shipping.a;

import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.o;
import com.target.ui.f.c;
import com.target.ui.fragment.shipping.b.b;
import com.target.ui.g.a;
import java.util.List;

public abstract class f
    implements com.target.ui.fragment.account.BaseAccountDialog.a, a
{

    private com.target.ui.service.provider.b mConnectivityProvider;
    private boolean mDeletedMessageNeedsDisplay;
    protected boolean mNeedsRefresh;
    protected b mPresentation;
    protected GuestAddress mSelectedGuestAddress;
    protected e.a mShippingActionListener;
    protected List mShippingAddressList;
    private boolean mUpdateMessageNeedsDisplay;

    public f(com.target.ui.service.provider.b b1)
    {
        mConnectivityProvider = b1;
    }

    private void c(Guest guest, o o)
    {
        mPresentation.c(false);
        if (!mConnectivityProvider.a())
        {
            mPresentation.g();
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

    private void i()
    {
        if (mPresentation != null)
        {
            if (mShippingAddressList != null && !mNeedsRefresh)
            {
                a(mShippingAddressList);
            } else
            if (!mConnectivityProvider.a())
            {
                mPresentation.g();
            } else
            {
                mPresentation.c(true);
                e();
            }
            if (mUpdateMessageNeedsDisplay)
            {
                mPresentation.k();
                mUpdateMessageNeedsDisplay = false;
                return;
            }
            if (mDeletedMessageNeedsDisplay)
            {
                mPresentation.o();
                mDeletedMessageNeedsDisplay = false;
                return;
            }
        }
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
    }

    public void a(GuestAddress guestaddress)
    {
        mSelectedGuestAddress = guestaddress;
    }

    public void a(Guest guest)
    {
    }

    public void a(Guest guest, o o)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            c(guest, o);
            return;
        }
    }

    public abstract void a(c c1);

    public void a(e.a a1)
    {
        mShippingActionListener = a1;
    }

    public void a(b b1)
    {
        mPresentation = b1;
        i();
    }

    public volatile void a(Object obj)
    {
        a((b)obj);
    }

    public void a(String s)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.q();
            return;
        }
    }

    protected abstract void a(List list);

    public void a(boolean flag)
    {
        if (flag)
        {
            mDeletedMessageNeedsDisplay = true;
        } else
        {
            mUpdateMessageNeedsDisplay = true;
        }
        mNeedsRefresh = true;
    }

    public abstract void a(boolean flag, GuestAddress guestaddress, c c1);

    protected abstract void b(Guest guest, o o);

    public void b(Object obj)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.c(true);
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
            mPresentation.q();
            return;
        }
    }

    public void b(List list)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            a(list);
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
            mPresentation.p();
            return;
        }
    }

    protected abstract void e();

    public abstract void f();

    public void g()
    {
        mPresentation.j();
        mPresentation.c(true);
        e();
    }

    public void h()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.c(false);
            mPresentation.a(false);
            mPresentation.d(true);
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
            mPresentation.a(0x7f090200);
            return;
        }
    }

    public void k()
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

    public void n_()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.p();
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
    }

    public void z_()
    {
        mPresentation = null;
    }
}
