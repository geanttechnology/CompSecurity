// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.c.a;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.h;
import com.google.a.a.e;
import com.target.mothership.common.a.g;
import com.target.mothership.model.cart.interfaces.AppliedTenders;
import com.target.mothership.model.cart.interfaces.ExpressOrderReview;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.registries.interfaces.RegistryDetails;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.o;
import com.target.ui.c.a;
import com.target.ui.fragment.account.AuthenticateDialog;
import com.target.ui.fragment.checkout.CheckoutHomeFragment;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.product.dialog.ProductAddToCartErrorDialog;
import com.target.ui.fragment.product.dialog.ProductPickUpDialogFragment;
import com.target.ui.fragment.product.dialog.ProductShipItDialogFragment;
import com.target.ui.fragment.store.StoreDetailFragment;
import com.target.ui.helper.product.ProductVariationModelHelper;
import com.target.ui.helper.product.c;
import com.target.ui.model.product.GridItem;
import com.target.ui.model.product.ProductVariationModel;

// Referenced classes of package com.target.ui.c.a:
//            c, f, d, a

public class b extends a
    implements com.target.ui.c.a.c, com.target.ui.fragment.account.BaseAccountDialog.f, com.target.ui.fragment.product.dialog.BaseProductDialogFragment.b, com.target.ui.fragment.product.dialog.ProductAddToCartErrorDialog.c
{

    private d mPresentation;
    private f mPresenter;

    public b(BaseNavigationFragment basenavigationfragment, d d1)
    {
        super(basenavigationfragment);
        mPresentation = d1;
        mPresenter = s();
    }

    private d o()
    {
        return mPresentation;
    }

    private com.target.ui.fragment.product.dialog.ProductAddToCartErrorDialog.c p()
    {
        return (com.target.ui.fragment.product.dialog.ProductAddToCartErrorDialog.c)b();
    }

    private com.target.ui.fragment.product.dialog.BaseProductDialogFragment.b q()
    {
        return (com.target.ui.fragment.product.dialog.BaseProductDialogFragment.b)b();
    }

    private Fragment r()
    {
        return b();
    }

    private f s()
    {
        return new f(new com.target.ui.helper.product.a(), new c(), new ProductVariationModelHelper(a()));
    }

    private void t()
    {
        a(n(), ((com.target.ui.fragment.account.BaseAccountDialog.f)b()).n(), "AuthDialogListener");
        a(l(), ((com.target.ui.fragment.account.BaseAccountDialog.d)b()).l(), "ForgotPasswordDialogListener");
        a(r_(), ((com.target.ui.fragment.product.dialog.BaseProductDialogFragment.b)b()).r_(), "ProductDialogStateListener");
        a(k(), ((com.target.ui.fragment.product.dialog.ProductAddToCartErrorDialog.c)b()).k(), "AddToCartErrorDialogListener");
    }

    public void a(int i)
    {
        if (o() == null)
        {
            return;
        } else
        {
            o().a(e().getString(i));
            return;
        }
    }

    public void a(ExpressOrderReview expressorderreview, AppliedTenders appliedtenders)
    {
        if (j())
        {
            return;
        } else
        {
            d().d(CheckoutHomeFragment.a(expressorderreview, appliedtenders, 1));
            return;
        }
    }

    public void a(ProductDetails productdetails)
    {
        if (o() == null)
        {
            return;
        } else
        {
            o().a(productdetails);
            return;
        }
    }

    public void a(ProductDetails productdetails, RegistryDetails registrydetails, com.target.ui.helper.product.b b1, Store store, g g1, ProductDetails productdetails1, ProductVariationModel productvariationmodel)
    {
        if (mPresenter == null)
        {
            throw new IllegalStateException("onCreateView must be called before addToCart");
        } else
        {
            mPresenter.a(productdetails, registrydetails, b1, store, g1, productdetails1, productvariationmodel);
            return;
        }
    }

    public void a(ProductDetails productdetails, com.target.ui.helper.product.b b1, Store store, g g1)
    {
        a(productdetails, b1, store, g1, null, null);
    }

    public void a(ProductDetails productdetails, com.target.ui.helper.product.b b1, Store store, g g1, ProductDetails productdetails1, ProductVariationModel productvariationmodel)
    {
        if (mPresenter == null)
        {
            throw new IllegalStateException("onCreateView must be called before addToCart");
        } else
        {
            mPresenter.a(productdetails, b1, store, g1, productdetails1, productvariationmodel);
            return;
        }
    }

    public void a(ProductDetails productdetails, ProductVariationModel productvariationmodel, com.target.ui.helper.product.b b1)
    {
        if (o() == null)
        {
            return;
        } else
        {
            o().a(productdetails, productvariationmodel, b1);
            return;
        }
    }

    public void a(Store store)
    {
        if (j())
        {
            return;
        } else
        {
            d().d(StoreDetailFragment.a(store.getStoreId()));
            return;
        }
    }

    public void a(com.target.ui.c.a.a a1, com.target.mothership.model.cart.interfaces.a.a a2, String s1)
    {
        while (c().a(ProductAddToCartErrorDialog.TAG) != null || j()) 
        {
            return;
        }
        ProductAddToCartErrorDialog.a(a1.c(), a2, s1, (Store)a1.g().d(), p()).show(c(), ProductAddToCartErrorDialog.TAG);
    }

    public void a(com.target.ui.c.a.a a1, boolean flag)
    {
        if (j())
        {
            return;
        }
        ProductDetails productdetails;
        if (flag && a1.d().b())
        {
            productdetails = (ProductDetails)a1.d().c();
        } else
        {
            productdetails = a1.e();
        }
        ProductPickUpDialogFragment.a(productdetails, a1.f(), (Store)a1.g().d(), q()).show(c(), ProductPickUpDialogFragment.TAG);
    }

    public void a(com.target.ui.helper.product.b b1, Guest guest, o o1)
    {
        if (j())
        {
            return;
        } else
        {
            b1 = AuthenticateDialog.a(guest, r(), b1);
            b1.a(o1);
            b1.show(c(), AuthenticateDialog.TAG);
            return;
        }
    }

    public void a(com.target.ui.helper.product.b b1, boolean flag)
    {
        if (o() == null)
        {
            return;
        } else
        {
            o().a(b1, flag);
            return;
        }
    }

    public void a(GridItem griditem)
    {
        if (o() == null)
        {
            return;
        } else
        {
            o().a(griditem);
            return;
        }
    }

    public void a(ProductVariationModel productvariationmodel)
    {
        if (o() == null)
        {
            return;
        } else
        {
            o().a(productvariationmodel);
            return;
        }
    }

    public void a(String s1)
    {
        if (o() == null)
        {
            return;
        } else
        {
            o().a(s1);
            return;
        }
    }

    public void a(boolean flag)
    {
        if (o() == null)
        {
            return;
        } else
        {
            o().a(flag);
            return;
        }
    }

    public void b(com.target.ui.c.a.a a1, boolean flag)
    {
        if (j())
        {
            return;
        }
        ProductDetails productdetails;
        if (flag && a1.d().b())
        {
            productdetails = (ProductDetails)a1.d().c();
        } else
        {
            productdetails = a1.e();
        }
        ProductShipItDialogFragment.a(productdetails, a1.f(), a1.c(), (Store)a1.g().d(), q()).show(c(), ProductShipItDialogFragment.TAG);
    }

    public void f()
    {
        super.f();
        t();
        mPresenter.a(this);
    }

    public void g()
    {
        super.g();
        mPresentation = null;
        mPresenter.v_();
        mPresenter = null;
    }

    public void h()
    {
        super.h();
        mPresenter.z_();
    }

    public com.target.ui.fragment.product.dialog.ProductAddToCartErrorDialog.b k()
    {
        return mPresenter.k();
    }

    public com.target.ui.fragment.account.BaseAccountDialog.c l()
    {
        return mPresenter.l();
    }

    public com.target.ui.fragment.account.BaseAccountDialog.e n()
    {
        return mPresenter.n();
    }

    public com.target.ui.fragment.product.dialog.BaseProductDialogFragment.a r_()
    {
        return mPresenter.r_();
    }
}
