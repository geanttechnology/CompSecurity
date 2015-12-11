// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.c.c;

import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.f.c;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.map.StoreMapFragment;
import com.target.ui.fragment.product.dialog.UnknownAisleDialogFragment;
import com.target.ui.helper.j.b;
import com.target.ui.service.provider.h;

// Referenced classes of package com.target.ui.c.c:
//            c, b

public class com.target.ui.c.c.a extends com.target.ui.c.a
{
    private class a
        implements com.target.ui.c.c.b
    {

        final com.target.ui.c.c.a this$0;

        public void a()
        {
            com.target.ui.c.c.a.a(com.target.ui.c.c.a.this);
        }

        public void a(ProductDetails productdetails, Store store)
        {
            com.target.ui.c.c.a.a(com.target.ui.c.c.a.this, productdetails, store);
        }

        public void a(String s, Store store)
        {
            com.target.ui.c.c.a.a(com.target.ui.c.c.a.this, s, store);
        }

        private a()
        {
            this$0 = com.target.ui.c.c.a.this;
            super();
        }

    }


    private com.target.ui.c.c.c mPresenter;

    public com.target.ui.c.c.a(BaseNavigationFragment basenavigationfragment)
    {
        super(basenavigationfragment);
        mPresenter = new com.target.ui.c.c.c(new h(), new b());
    }

    static void a(com.target.ui.c.c.a a1)
    {
        a1.k();
    }

    static void a(com.target.ui.c.c.a a1, ProductDetails productdetails, Store store)
    {
        a1.b(productdetails, store);
    }

    static void a(com.target.ui.c.c.a a1, String s, Store store)
    {
        a1.b(s, store);
    }

    private void b(ProductDetails productdetails, Store store)
    {
        if (j())
        {
            return;
        } else
        {
            d().d(StoreMapFragment.a(productdetails, store));
            return;
        }
    }

    private void b(String s, Store store)
    {
        if (j())
        {
            return;
        } else
        {
            d().d(StoreMapFragment.a(s, store));
            return;
        }
    }

    private void k()
    {
        if (j())
        {
            return;
        } else
        {
            UnknownAisleDialogFragment.a().show(c(), UnknownAisleDialogFragment.TAG);
            return;
        }
    }

    public void a(ProductDetails productdetails, Store store)
    {
        if (mPresenter == null)
        {
            throw new IllegalStateException("onCreateView must be called before navigateToMap");
        } else
        {
            mPresenter.a(productdetails, store);
            return;
        }
    }

    public void a(String s, Store store)
    {
        if (mPresenter == null)
        {
            throw new IllegalStateException("onCreateView must be called before navigateToMap");
        } else
        {
            mPresenter.a(s, store);
            return;
        }
    }

    public void f()
    {
        super.f();
        mPresenter.a(new a());
    }

    public void g()
    {
        super.g();
        mPresenter.v_();
        mPresenter = null;
    }

    public void h()
    {
        super.h();
        mPresenter.z_();
    }
}
