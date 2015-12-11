// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.c.b;

import android.content.res.Resources;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingBase;
import com.target.ui.c.a;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment;
import com.target.ui.helper.product.d;

// Referenced classes of package com.target.ui.c.b:
//            c, f, d, a

public class b extends a
    implements c, com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.c
{

    private com.target.ui.c.b.d mPresentation;
    private f mPresenter;

    public b(BaseNavigationFragment basenavigationfragment, com.target.ui.c.b.d d1)
    {
        super(basenavigationfragment);
        mPresentation = d1;
        mPresenter = l();
    }

    private f l()
    {
        return new f(new d(), true);
    }

    private void m()
    {
        a(s_(), ((com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.c)b()).s_(), "AddToListDialogListener");
    }

    private com.target.ui.c.b.d n()
    {
        return mPresentation;
    }

    private com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.c o()
    {
        return (com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.c)b();
    }

    public void a(int i)
    {
        if (n() == null)
        {
            return;
        } else
        {
            n().a(e().getString(i));
            n().a(false);
            return;
        }
    }

    public void a(int i, ListSummary listsummary)
    {
        if (n() == null)
        {
            return;
        } else
        {
            n().a(e().getString(i), listsummary);
            n().a(false);
            return;
        }
    }

    public void a(Product product)
    {
        mPresenter.a(product);
    }

    public void a(WeeklyAdListingBase weeklyadlistingbase)
    {
        mPresenter.a(weeklyadlistingbase);
    }

    public void a(com.target.ui.c.b.a a1)
    {
        if (j())
        {
            return;
        }
        if (a1.b() != null)
        {
            a1 = ProductAddToListDialogFragment.a(a1.b(), o());
        } else
        {
            a1 = ProductAddToListDialogFragment.a(a1.a(), o());
        }
        a1.show(c(), ProductAddToListDialogFragment.TAG);
    }

    public void a(String s)
    {
        if (n() == null)
        {
            return;
        } else
        {
            n().a(s);
            n().a(false);
            return;
        }
    }

    public void a(String s, ListSummary listsummary)
    {
        if (n() == null)
        {
            return;
        } else
        {
            n().a(s, listsummary);
            n().a(false);
            return;
        }
    }

    public void a(boolean flag)
    {
        if (n() == null)
        {
            return;
        } else
        {
            n().a(flag);
            return;
        }
    }

    public void f()
    {
        super.f();
        m();
        mPresenter.a(this);
    }

    public void g()
    {
        super.g();
        mPresentation = null;
    }

    public void h()
    {
        super.h();
        mPresenter.z_();
    }

    public com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.b s_()
    {
        return mPresenter.s_();
    }
}
