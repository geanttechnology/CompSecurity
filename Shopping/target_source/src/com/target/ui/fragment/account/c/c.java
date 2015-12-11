// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account.c;

import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.OrderSummary;
import com.target.mothership.model.guest.interfaces.a.i;
import com.target.mothership.services.o;
import com.target.ui.g.a;
import com.target.ui.service.provider.m;
import com.target.ui.util.q;
import java.util.List;

public final class c
    implements a, com.target.ui.helper.a.a
{

    private static final String TAG = com/target/ui/fragment/account/c/c.getSimpleName();
    private com.target.ui.helper.a.c mDataHelper;
    private m mGuestProvider;
    private List mOrderHistory;
    private com.target.ui.fragment.account.b.c mPresentation;

    public c(m m1, com.target.ui.helper.a.c c1)
    {
        mGuestProvider = m1;
        mDataHelper = c1;
    }

    private void b(List list)
    {
        mPresentation.c(true);
        if (list.isEmpty())
        {
            mPresentation.e();
            return;
        } else
        {
            mPresentation.a(list);
            return;
        }
    }

    private void n()
    {
        if (mOrderHistory == null)
        {
            o();
            return;
        } else
        {
            b(mOrderHistory);
            return;
        }
    }

    private void o()
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            q.d(TAG, "Guest session is unexpectedly null while fetching order history");
            mPresentation.b();
            return;
        } else
        {
            mPresentation.a(true);
            mDataHelper.a(guest, this);
            return;
        }
    }

    private void p()
    {
        if (mDataHelper != null)
        {
            mDataHelper.a();
            mDataHelper = null;
        }
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        mPresentation.a(0x7f0900a8);
    }

    public void a(Guest guest, o o1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(false);
            mPresentation.a(guest, o1);
            return;
        }
    }

    public void a(OrderSummary ordersummary)
    {
        mPresentation.a(ordersummary);
    }

    public void a(i i1)
    {
        if (mPresentation == null)
        {
            return;
        }
        mPresentation.a(false);
        mPresentation.c(true);
        if (i1.e() == com.target.mothership.model.guest.interfaces.a.i.a.ERR_NO_ORDER_HISTORY_DATA)
        {
            mPresentation.e();
            return;
        } else
        {
            mPresentation.b(0x7f0900af);
            return;
        }
    }

    public void a(com.target.ui.fragment.account.b.c c1)
    {
        mPresentation = c1;
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.account.b.c)obj);
    }

    public void a(List list)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mOrderHistory = list;
            mPresentation.a(false);
            b(list);
            return;
        }
    }

    public void d()
    {
        n();
    }

    public void e()
    {
        mPresentation.a(true);
    }

    public void f()
    {
        n();
    }

    public void g()
    {
        mPresentation.b(0x7f0900ae);
        mPresentation.c(true);
    }

    public void h()
    {
        mPresentation.b(0x7f0900ae);
        mPresentation.c(true);
    }

    public void i()
    {
        mPresentation.b(0x7f0900ae);
        mPresentation.c(true);
    }

    public void j()
    {
        mPresentation.b(0x7f0900ae);
        mPresentation.c(true);
    }

    public void k()
    {
        n();
    }

    public void l()
    {
        p();
        mPresentation.b();
    }

    public void m()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(false);
            mPresentation.g();
            mPresentation.c(false);
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
            mPresentation.a(false);
            mPresentation.b(0x7f09027b);
            return;
        }
    }

    public void v_()
    {
        p();
        mDataHelper = null;
        mGuestProvider = null;
        mOrderHistory = null;
    }

    public void z_()
    {
        p();
        mPresentation = null;
    }

}
