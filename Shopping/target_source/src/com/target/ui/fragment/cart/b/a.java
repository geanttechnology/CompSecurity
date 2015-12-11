// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cart.b;

import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.common.a.f;
import com.target.mothership.model.cart.interfaces.AppliedTenders;
import com.target.mothership.model.cart.interfaces.CartDetails;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.ExpressOrderReview;
import com.target.mothership.model.cart.interfaces.FreeShippingPromotion;
import com.target.mothership.model.cart.interfaces.GiftProduct;
import com.target.mothership.model.cart.interfaces.UsableShipMode;
import com.target.mothership.model.cart.interfaces.a.i;
import com.target.mothership.model.cart.interfaces.a.j;
import com.target.mothership.model.cart.interfaces.a.u;
import com.target.mothership.model.cart.interfaces.a.w;
import com.target.mothership.model.cart.interfaces.a.y;
import com.target.mothership.model.cart.interfaces.a.z;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.product.interfaces.ProductRecommendations;
import com.target.mothership.services.o;
import com.target.mothership.services.x;
import com.target.ui.analytics.a.as;
import com.target.ui.analytics.d;
import com.target.ui.analytics.h;
import com.target.ui.helper.b.b;
import com.target.ui.service.provider.m;
import com.target.ui.util.q;
import java.util.List;

public class a
    implements com.target.ui.g.a, com.target.ui.helper.b.a, com.target.ui.helper.b.b.a
{

    private static final String TAG = com/target/ui/fragment/cart/b/a.getSimpleName();
    private com.target.ui.helper.b.a mCartDataHelper;
    private com.target.ui.fragment.cart.b.a.a mCartNotEmptyRecommendationsFeature;
    private com.target.ui.service.provider.b mConnectivityProvider;
    private ExpressOrderReview mExpressOrderReview;
    private FreeShippingPromotion mFreeShippingPromotion;
    private m mGuestProvider;
    private boolean mIsGetCartRequestPending;
    private h mLoadTimestamp;
    private b mPendingActionsHelper;
    private com.target.ui.fragment.cart.a.a mPresentation;

    public a(com.target.ui.helper.b.a a1, m m1, com.target.ui.fragment.cart.b.a.a a2, b b1, com.target.ui.service.provider.b b2)
    {
        mCartDataHelper = a1;
        mGuestProvider = m1;
        mCartNotEmptyRecommendationsFeature = a2;
        mPendingActionsHelper = b1;
        mConnectivityProvider = b2;
    }

    private void a(Guest guest, o o1)
    {
        mPresentation.a(false);
        if (guest.isAnonymous())
        {
            mCartDataHelper.a(guest, o1, this);
            return;
        } else
        {
            mPresentation.a(guest, o1);
            return;
        }
    }

    private void a(boolean flag)
    {
        mIsGetCartRequestPending = flag;
    }

    private void b(int i1)
    {
        mPresentation.k();
        mPresentation.c(i1);
    }

    private void c(Guest guest)
    {
        mLoadTimestamp = new h();
        mCartDataHelper.a(guest, this);
    }

    private void f(CartDetails cartdetails)
    {
        mPresentation.a(false);
        if (cartdetails.b() == 0)
        {
            mCartDataHelper.a(this);
            mPresentation.r();
            return;
        } else
        {
            mCartNotEmptyRecommendationsFeature.a(cartdetails);
            mPresentation.a(cartdetails.b(), String.valueOf(cartdetails.c()));
            mPresentation.o();
            g(cartdetails);
            return;
        }
    }

    private void g(CartDetails cartdetails)
    {
        mPresentation.b(cartdetails, mFreeShippingPromotion);
        mCartNotEmptyRecommendationsFeature.b();
        mPresentation.a(cartdetails, mFreeShippingPromotion);
    }

    private void m()
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            q.d(TAG, "Guest object is null while fetching cart details");
            mPresentation.y();
            return;
        } else
        {
            mPresentation.a(true);
            c(guest);
            return;
        }
    }

    private boolean n()
    {
        return mIsGetCartRequestPending;
    }

    private void o()
    {
        mPresentation.k();
        mPresentation.v();
    }

    private void p()
    {
        mCartDataHelper.a();
        mPendingActionsHelper.a();
    }

    public void a(int i1)
    {
        boolean flag = true;
        if (mPresentation == null)
        {
            return;
        }
        if (i1 != 1)
        {
            flag = false;
        }
        a(flag);
        if (flag)
        {
            mPresentation.b(0x7f09027b);
            return;
        } else
        {
            b(0x7f09027b);
            return;
        }
    }

    public void a(int i1, Guest guest, o o1)
    {
        boolean flag = true;
        if (mPresentation == null)
        {
            return;
        }
        if (i1 != 1)
        {
            flag = false;
        }
        a(flag);
        a(guest, o1);
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
    }

    public void a(AppliedTenders appliedtenders)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(mExpressOrderReview, appliedtenders);
            return;
        }
    }

    public void a(CartDetails cartdetails)
    {
        mPresentation.a(true);
        mPendingActionsHelper.a(cartdetails, this);
    }

    public void a(CartProduct cartproduct)
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            q.d(TAG, "Guest session is null while trying to remove a product");
            mPresentation.y();
            return;
        } else
        {
            mPresentation.a(true);
            mCartDataHelper.a(guest, cartproduct, this);
            return;
        }
    }

    public void a(CartProduct cartproduct, int i1)
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            q.d(TAG, "Guest session is null while requesting a quantity update");
            mPresentation.y();
            return;
        } else
        {
            mPresentation.a(true);
            mCartDataHelper.a(guest, cartproduct, i1, this);
            return;
        }
    }

    public void a(CartProduct cartproduct, UsableShipMode usableshipmode)
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            q.d(TAG, "Guest session is null while updating a shipping method");
            mPresentation.y();
            return;
        } else
        {
            mPresentation.a(true);
            mCartDataHelper.a(guest, cartproduct, usableshipmode, this);
            return;
        }
    }

    public void a(CartProduct cartproduct, com.target.ui.model.a a1, f f1)
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            q.d(TAG, "Guest session is null while updating a pickup store");
            mPresentation.y();
            return;
        } else
        {
            mPresentation.a(true);
            mCartDataHelper.a(guest, cartproduct, a1, f1, this);
            return;
        }
    }

    public void a(ExpressOrderReview expressorderreview)
    {
        if (mPresentation == null)
        {
            return;
        }
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            q.a(TAG, "Guest session was unexpectedly null.  Aborting onInitiateCheckoutSuccess");
            mPresentation.y();
            return;
        } else
        {
            mExpressOrderReview = expressorderreview;
            mCartDataHelper.a(guest, expressorderreview, this);
            return;
        }
    }

    public void a(FreeShippingPromotion freeshippingpromotion)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mFreeShippingPromotion = freeshippingpromotion;
            return;
        }
    }

    public void a(GiftProduct giftproduct)
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            q.d(TAG, "Guest session is null while applying a reward option");
            mPresentation.y();
            return;
        } else
        {
            mPresentation.a(true);
            mCartDataHelper.a(guest, giftproduct, this);
            return;
        }
    }

    public void a(com.target.mothership.model.cart.interfaces.a.a a1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            o();
            return;
        }
    }

    public void a(com.target.mothership.model.cart.interfaces.a.f f1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            o();
            return;
        }
    }

    public void a(i i1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            q.a(TAG, "Problem is fetching applied tenders");
            mPresentation.a(mExpressOrderReview, null);
            return;
        }
    }

    public void a(j j1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.b(0x7f090105);
            return;
        }
    }

    public void a(com.target.mothership.model.cart.interfaces.a.o o1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            o();
            return;
        }
    }

    public void a(u u)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            m();
            return;
        }
    }

    public void a(w w)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(false);
            mPresentation.k();
            mPresentation.a(w);
            return;
        }
    }

    public void a(y y)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(false);
            mPresentation.k();
            mPresentation.a(y);
            return;
        }
    }

    public void a(z z)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.c(0x7f09011d);
            return;
        }
    }

    public void a(Guest guest)
    {
        if (n())
        {
            mPresentation.a(true);
            a(false);
            c(guest);
        }
    }

    public void a(ProductRecommendations productrecommendations)
    {
        if (mPresentation == null)
        {
            return;
        }
        if (productrecommendations.a().isEmpty())
        {
            mPresentation.p();
            return;
        } else
        {
            mPresentation.a(productrecommendations);
            return;
        }
    }

    public void a(x x)
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

    public void a(com.target.ui.fragment.cart.a.a a1)
    {
        mPresentation = a1;
        mCartNotEmptyRecommendationsFeature.a(a1);
        mCartDataHelper.b(this);
        a1 = mGuestProvider.a();
        if (a1 != null)
        {
            mPresentation.a(true);
            c(a1);
            return;
        } else
        {
            mCartDataHelper.c(this);
            mCartDataHelper.a(this);
            mPresentation.r();
            return;
        }
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.cart.a.a)obj);
    }

    public void a(String s)
    {
        mPresentation.y();
    }

    public void b(CartDetails cartdetails)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            as.a(cartdetails, com.target.ui.analytics.d.a(mLoadTimestamp)).e();
            f(cartdetails);
            return;
        }
    }

    public void b(CartProduct cartproduct)
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            q.d(TAG, "Tried to save a cart product in the save for later list, but the current session was null");
            mPresentation.y();
            return;
        } else
        {
            mPresentation.a(true);
            mCartDataHelper.b(guest, cartproduct, this);
            return;
        }
    }

    public void b(Guest guest)
    {
        if (mPresentation == null)
        {
            return;
        }
        if (!n())
        {
            mPresentation.a(false);
            mPresentation.k();
            mPresentation.w();
        }
        a(guest);
    }

    public void b(x x)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            o();
            return;
        }
    }

    public void b(Object obj)
    {
        mPresentation.a(true);
    }

    public void b(String s)
    {
        mPresentation.y();
    }

    public void c()
    {
        mPresentation.k();
        f();
    }

    public void c(CartDetails cartdetails)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            f(cartdetails);
            return;
        }
    }

    public void c(CartProduct cartproduct)
    {
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            q.d(TAG, "Guest session is null while updating a fulfillment method");
            mPresentation.y();
            return;
        } else
        {
            mPresentation.a(true);
            mCartDataHelper.c(guest, cartproduct, this);
            return;
        }
    }

    public void d()
    {
        f();
    }

    public void d(CartDetails cartdetails)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            f(cartdetails);
            return;
        }
    }

    public void d(CartProduct cartproduct)
    {
        mPresentation.g(cartproduct);
    }

    public void e()
    {
        p();
    }

    public void e(CartDetails cartdetails)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            f(cartdetails);
            mPresentation.u();
            mPresentation.a(0x7f09011c);
            return;
        }
    }

    public void f()
    {
        if (n())
        {
            mPresentation.x();
        }
    }

    public void g()
    {
        if (!mConnectivityProvider.a())
        {
            mPresentation.t();
            return;
        }
        if (mGuestProvider.a() == null)
        {
            mCartDataHelper.c(this);
            mPresentation.r();
            return;
        } else
        {
            mPresentation.a(true);
            mPresentation.s();
            m();
            return;
        }
    }

    public void h()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            m();
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
            m();
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
            m();
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
            mPresentation.t();
            return;
        }
    }

    public void l()
    {
        if (mPresentation == null)
        {
            return;
        }
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            q.d(TAG, "Guest session is unexpectedly null.  Aborting onPendingActionsComplete");
            mPresentation.y();
            return;
        } else
        {
            mCartDataHelper.b(guest, this);
            return;
        }
    }

    public void v_()
    {
        mCartDataHelper = null;
        mGuestProvider = null;
        mPendingActionsHelper = null;
    }

    public void z_()
    {
        p();
        mCartNotEmptyRecommendationsFeature.a();
        mPresentation = null;
    }

}
