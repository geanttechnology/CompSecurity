// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.c.a;

import android.view.Menu;
import android.view.MenuInflater;
import com.google.a.a.e;
import com.target.mothership.common.a.g;
import com.target.mothership.model.cart.interfaces.AppliedTenders;
import com.target.mothership.model.cart.interfaces.ExpressOrderReview;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.registries.interfaces.RegistryDetails;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.o;
import com.target.ui.g.a;
import com.target.ui.helper.product.ProductVariationModelHelper;
import com.target.ui.helper.product.b;
import com.target.ui.helper.product.c;
import com.target.ui.model.product.GridItem;
import com.target.ui.model.product.ProductVariationModel;

// Referenced classes of package com.target.ui.c.a:
//            a, c

public class f
    implements com.target.ui.fragment.account.BaseAccountDialog.e, com.target.ui.fragment.account.BaseAccountDialog.f, com.target.ui.fragment.product.dialog.BaseProductDialogFragment.a, com.target.ui.fragment.product.dialog.BaseProductDialogFragment.b, com.target.ui.fragment.product.dialog.ProductAddToCartErrorDialog.b, com.target.ui.fragment.product.dialog.ProductAddToCartErrorDialog.c, a, com.target.ui.helper.product.a.b, com.target.ui.helper.product.c.a
{

    private com.target.ui.c.a.a mAddToCartData;
    private com.target.ui.helper.product.a mAddToCartHelper;
    private c mAddToCartValidator;
    private com.target.ui.c.a.c mPresentation;
    private ProductVariationModelHelper mProductVariationModelHelper;

    public f(com.target.ui.helper.product.a a1, c c1, ProductVariationModelHelper productvariationmodelhelper)
    {
        mAddToCartHelper = a1;
        mAddToCartValidator = c1;
        mProductVariationModelHelper = productvariationmodelhelper;
    }

    private void a(com.target.ui.c.a.a a1)
    {
        ProductDetails productdetails = a1.e();
        b b2 = a1.c();
        b b1 = b2;
        if (b.EXPRESS_CHECKOUT.equals(b2))
        {
            b1 = b.SHIP;
        }
        boolean flag;
        if (!a1.a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mAddToCartValidator.a(productdetails, b1, flag, this);
    }

    private void a(b b1, boolean flag)
    {
        if (b1.equals(b.EXPRESS_CHECKOUT))
        {
            mPresentation.a(flag);
            return;
        } else
        {
            mPresentation.a(b1, flag);
            return;
        }
    }

    private void b(com.target.ui.c.a.a a1)
    {
        if (c(a1))
        {
            mAddToCartHelper.a(a1.e(), (RegistryDetails)a1.i().c(), a1.c(), a1.a(), this, (Store)a1.g().d(), (g)a1.h().d());
            return;
        } else
        {
            mAddToCartHelper.a(a1.e(), a1.c(), a1.a(), this, (Store)a1.g().d(), (g)a1.h().d());
            return;
        }
    }

    private boolean c(com.target.ui.c.a.a a1)
    {
        return a1.b();
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
    }

    public void a(Guest guest)
    {
        if (mPresentation == null)
        {
            return;
        }
        if (mAddToCartData != null)
        {
            a(mAddToCartData.c(), false);
        }
        mPresentation.a(0x7f09046e);
    }

    public void a(ProductDetails productdetails, RegistryDetails registrydetails, b b1, Store store, g g1, ProductDetails productdetails1, ProductVariationModel productvariationmodel)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            a(b1, true);
            b(productdetails, registrydetails, b1, store, g1, productdetails1, productvariationmodel);
            a(mAddToCartData);
            return;
        }
    }

    public void a(ProductDetails productdetails, b b1)
    {
        if (mPresentation == null)
        {
            return;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$helper$product$AddToCartItemType[];

            static 
            {
                $SwitchMap$com$target$ui$helper$product$AddToCartItemType = new int[com.target.ui.helper.product.b.values().length];
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.PICK_UP.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.helper.product.AddToCartItemType[b1.ordinal()])
        {
        default:
            mPresentation.b(mAddToCartData, true);
            return;

        case 1: // '\001'
            mPresentation.a(mAddToCartData, true);
            break;
        }
    }

    public void a(ProductDetails productdetails, b b1, ProductDetails productdetails1, ProductVariationModel productvariationmodel, Store store, g g1)
    {
        if (mPresentation == null)
        {
            return;
        }
        a(b1, true);
        mPresentation.a(productdetails, productvariationmodel, b1);
        if (mAddToCartData == null)
        {
            b(productdetails, b1, store, g1, productdetails1, productvariationmodel);
        }
        mAddToCartData.a(productdetails);
        if (productvariationmodel != null)
        {
            mAddToCartData.a(productvariationmodel);
        }
        mAddToCartData.a(store);
        mAddToCartData.a(g1);
        b(mAddToCartData);
    }

    public void a(ProductDetails productdetails, b b1, Store store, g g1, ProductDetails productdetails1, ProductVariationModel productvariationmodel)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            a(b1, true);
            b(productdetails, b1, store, g1, productdetails1, productvariationmodel);
            a(mAddToCartData);
            return;
        }
    }

    public void a(ProductDetails productdetails, b b1, String s)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(mAddToCartData, com.target.mothership.model.cart.interfaces.a.b.a.ERR_CART_AGE_CHECK_FAILURE, s);
            return;
        }
    }

    public void a(Store store)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(store);
            return;
        }
    }

    public void a(com.target.ui.c.a.c c1)
    {
        mPresentation = c1;
    }

    public void a(b b1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            a(b1, false);
            return;
        }
    }

    public void a(b b1, com.target.mothership.model.cart.interfaces.a.b b2, Store store)
    {
        if (mPresentation == null)
        {
            return;
        }
        a(b1, false);
        if (b2 == null)
        {
            mPresentation.a(mAddToCartData, com.target.mothership.model.cart.interfaces.a.b.a.ERR_CART_UNKNOWN, "");
            return;
        } else
        {
            mPresentation.a(mAddToCartData, (com.target.mothership.model.cart.interfaces.a.b.a)b2.e(), "");
            return;
        }
    }

    public void a(b b1, Guest guest, o o)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            a(b1, false);
            mPresentation.a(b1, guest, o);
            return;
        }
    }

    public void a(b b1, ProductDetails productdetails, ExpressOrderReview expressorderreview, AppliedTenders appliedtenders)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            a(b1, false);
            mPresentation.a(productdetails);
            mPresentation.a(expressorderreview, appliedtenders);
            return;
        }
    }

    public void a(b b1, Store store)
    {
        if (mPresentation != null)
        {
            a(b1, false);
            mPresentation.a(0x7f090414);
            if (mAddToCartData != null)
            {
                mPresentation.a(mAddToCartData.e());
                return;
            }
        }
    }

    public void a(GridItem griditem)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(griditem);
            return;
        }
    }

    public void a(ProductVariationModel productvariationmodel)
    {
        if (mPresentation != null)
        {
            mPresentation.a(productvariationmodel);
            if (mAddToCartData != null)
            {
                mAddToCartData.a(productvariationmodel);
                return;
            }
        }
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.c.a.c)obj);
    }

    public void a(String s)
    {
        if (mPresentation == null)
        {
            return;
        }
        if (mAddToCartData != null)
        {
            a(mAddToCartData.c(), false);
        }
        mPresentation.a(0x7f09006c);
    }

    public void b(ProductDetails productdetails, RegistryDetails registrydetails, b b1, Store store, g g1, ProductDetails productdetails1, ProductVariationModel productvariationmodel)
    {
        if (productvariationmodel == null)
        {
            productvariationmodel = mProductVariationModelHelper.a(productdetails);
        }
        productdetails = new com.target.ui.c.a.a(productdetails, registrydetails, b1, productvariationmodel, productdetails1);
        productdetails.a(store);
        productdetails.a(g1);
        productdetails.a(false);
        mAddToCartData = productdetails;
    }

    public void b(ProductDetails productdetails, b b1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(mAddToCartData, false);
            return;
        }
    }

    public void b(ProductDetails productdetails, b b1, Store store, g g1, ProductDetails productdetails1, ProductVariationModel productvariationmodel)
    {
        ProductVariationModel productvariationmodel1 = productvariationmodel;
        if (productvariationmodel == null)
        {
            productvariationmodel1 = mProductVariationModelHelper.a(productdetails);
        }
        productdetails = new com.target.ui.c.a.a(productdetails, b1, productvariationmodel1, productdetails1);
        productdetails.a(store);
        productdetails.a(g1);
        productdetails.a(false);
        mAddToCartData = productdetails;
    }

    public void b(b b1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            a(b1, false);
            return;
        }
    }

    public void b(b b1, Store store)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mAddToCartData.a(true);
            a(mAddToCartData);
            return;
        }
    }

    public void b(Object obj)
    {
        c((b)obj);
    }

    public void b(String s)
    {
        if (mPresentation == null)
        {
            return;
        }
        if (mAddToCartData != null)
        {
            a(mAddToCartData.c(), false);
        }
        mPresentation.a(0x7f090074);
    }

    public void c()
    {
    }

    public void c(ProductDetails productdetails, b b1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            a(b1, false);
            mPresentation.a(0x7f090456);
            return;
        }
    }

    public void c(b b1)
    {
        while (mPresentation == null || mAddToCartData == null) 
        {
            return;
        }
        a(mAddToCartData.c(), true);
    }

    public void c(b b1, Store store)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(0x7f090416);
            b(mAddToCartData);
            return;
        }
    }

    public void d(ProductDetails productdetails, b b1)
    {
        b(mAddToCartData);
    }

    public com.target.ui.fragment.product.dialog.ProductAddToCartErrorDialog.b k()
    {
        return this;
    }

    public com.target.ui.fragment.account.BaseAccountDialog.c l()
    {
        return this;
    }

    public com.target.ui.fragment.account.BaseAccountDialog.e n()
    {
        return this;
    }

    public void n_()
    {
    }

    public com.target.ui.fragment.product.dialog.BaseProductDialogFragment.a r_()
    {
        return this;
    }

    public void v_()
    {
        mAddToCartHelper = null;
        mAddToCartValidator = null;
        mProductVariationModelHelper = null;
    }

    public void z_()
    {
        mAddToCartHelper.a();
        mPresentation = null;
    }
}
