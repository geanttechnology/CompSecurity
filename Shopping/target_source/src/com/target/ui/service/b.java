// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import com.google.a.a.e;
import com.target.mothership.common.a.f;
import com.target.mothership.common.params.AddressParams;
import com.target.mothership.common.params.ProductRecommendationsParam;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.tender.PaymentTender;
import com.target.mothership.model.cart.b.g;
import com.target.mothership.model.cart.b.i;
import com.target.mothership.model.cart.b.k;
import com.target.mothership.model.cart.b.l;
import com.target.mothership.model.cart.c;
import com.target.mothership.model.cart.interfaces.AddToCart;
import com.target.mothership.model.cart.interfaces.CartDetails;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.CartSummary;
import com.target.mothership.model.cart.interfaces.ExpressOrderReview;
import com.target.mothership.model.cart.interfaces.GiftProduct;
import com.target.mothership.model.cart.interfaces.InitiatedCheckout;
import com.target.mothership.model.cart.interfaces.InitiatedPayPal;
import com.target.mothership.model.cart.interfaces.OrderCompletionDetails;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.cart.interfaces.PromoCode;
import com.target.mothership.model.cart.interfaces.SaveForLaterProduct;
import com.target.mothership.model.cart.interfaces.UsableShipMode;
import com.target.mothership.model.cart.interfaces.a.y;
import com.target.mothership.model.common.AppliedGiftCardTender;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.AccountDetails;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.apigee.c.a.h;
import com.target.mothership.services.o;
import com.target.ui.analytics.a.am;
import com.target.ui.analytics.a.j;
import com.target.ui.analytics.a.n;
import com.target.ui.analytics.a.u;
import com.target.ui.d.a;
import com.target.ui.util.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.target.ui.service:
//            a

public class com.target.ui.service.b
    implements a.b
{
    public static interface a
    {

        public abstract void a(int i1);
    }

    private final class b extends d
    {

        private d mReceiver;
        final com.target.ui.service.b this$0;

        public String a()
        {
            return mReceiver.a();
        }

        public void a(OrderCompletionDetails ordercompletiondetails)
        {
            com.target.ui.service.b.a(com.target.ui.service.b.this, 0);
            mReceiver.a(ordercompletiondetails);
        }

        public void a(com.target.mothership.model.cart.interfaces.a.h h1)
        {
            mReceiver.b(h1, (o)c().d());
            n.a(h1.d(), h1.e()).e();
        }

        public volatile void a(Object obj)
        {
            a((OrderCompletionDetails)obj);
        }

        public void b(Object obj)
        {
            a((com.target.mothership.model.cart.interfaces.a.h)obj);
        }

        public b(d d1)
        {
            this$0 = com.target.ui.service.b.this;
            super();
            mReceiver = d1;
        }
    }


    private static final String LOG_TAG = com/target/ui/service/b.getSimpleName();
    private static int PRIMARY_REASON_INDEX = 0;
    private static com.target.ui.service.b sInstance;
    private final int CART_EMPTY_QUANTITY = 0;
    private final int CART_MAX_RECOMMENDATION = 6;
    private final int CART_MIN_RECOMMENDATION = 6;
    private final int CART_NOT_EMPTY_MAX_RECOMMENDATION = 8;
    private c mCartManager;
    private int mCartQuantity;
    private boolean mIsCartBadgeSetup;
    private CopyOnWriteArrayList mOnCartQuantityUpdatedListeners;

    private com.target.ui.service.b()
    {
        mOnCartQuantityUpdatedListeners = new CopyOnWriteArrayList();
        mCartManager = new c();
        com.target.ui.service.a.a().a(this);
    }

    static c a(com.target.ui.service.b b1)
    {
        return b1.mCartManager;
    }

    public static com.target.ui.service.b a()
    {
        if (sInstance == null)
        {
            sInstance = new com.target.ui.service.b();
        }
        return sInstance;
    }

    private void a(int i1)
    {
        mCartQuantity = i1;
        Iterator iterator = mOnCartQuantityUpdatedListeners.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            a a1 = (a)iterator.next();
            if (a1 != null)
            {
                a1.a(i1);
            }
        } while (true);
        com.target.ui.d.a.c().b(i1);
    }

    static void a(com.target.ui.service.b b1, int i1)
    {
        b1.a(i1);
    }

    static int d()
    {
        return PRIMARY_REASON_INDEX;
    }

    static String e()
    {
        return LOG_TAG;
    }

    public void a(CartDetails cartdetails, com.target.mothership.model.h h1)
    {
        com.target.mothership.model.product.c c1 = new com.target.mothership.model.product.c();
        h1 = new u(h1);
        ProductRecommendationsParam productrecommendationsparam = new ProductRecommendationsParam();
        productrecommendationsparam.a(com.target.mothership.common.params.ProductRecommendationsParam.a.CART_NOT_EMPTY_RECOMMENDATIONS);
        ArrayList arraylist = new ArrayList();
        for (cartdetails = cartdetails.a().iterator(); cartdetails.hasNext(); arraylist.add(((CartProduct)cartdetails.next()).k_())) { }
        productrecommendationsparam.a(arraylist);
        productrecommendationsparam.a(6);
        productrecommendationsparam.b(8);
        c1.a(productrecommendationsparam, h1);
    }

    public void a(Guest guest)
    {
        if (guest == null || guest.isAnonymous() || !guest.getAccountDetails().b())
        {
            return;
        } else
        {
            a(((AccountDetails)guest.getAccountDetails().c()).getCartQuantity());
            return;
        }
    }

    public void a(Guest guest, com.target.mothership.model.cart.b.a a1, final d callback)
    {
        callback = new d() {

            final com.target.ui.service.b this$0;
            final d val$callback;

            public String a()
            {
                return callback.a();
            }

            public void a(AddToCart addtocart)
            {
                com.target.ui.service.b.a(com.target.ui.service.b.this, addtocart.a());
                callback.a(addtocart);
            }

            public void a(com.target.mothership.model.cart.interfaces.a.b b1)
            {
                callback.b(b1, (o)c().d());
                n.a(b1.d(), b1.e()).e();
            }

            public volatile void a(Object obj)
            {
                a((AddToCart)obj);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.cart.interfaces.a.b)obj);
            }

            
            {
                this$0 = com.target.ui.service.b.this;
                callback = d1;
                super();
            }
        };
        mCartManager.a(guest, a1, callback);
    }

    public void a(Guest guest, l l1, d d1)
    {
        d1 = new j(d1);
        mCartManager.a(guest, l1, d1);
    }

    public void a(Guest guest, CartProduct cartproduct, int i1, final d callback)
    {
        callback = new d() {

            final com.target.ui.service.b this$0;
            final d val$callback;

            public String a()
            {
                return callback.a();
            }

            public void a(CartDetails cartdetails)
            {
                com.target.ui.service.b.a(com.target.ui.service.b.this, cartdetails.b());
                callback.a(cartdetails);
            }

            public void a(y y1)
            {
                callback.b(y1, (o)c().d());
                n.a(y1.d(), y1.e()).e();
            }

            public volatile void a(Object obj)
            {
                a((CartDetails)obj);
            }

            public void b(Object obj)
            {
                a((y)obj);
            }

            
            {
                this$0 = com.target.ui.service.b.this;
                callback = d1;
                super();
            }
        };
        if (cartproduct.j_() > i1)
        {
            am.a(cartproduct, cartproduct.j_() - i1).e();
        } else
        {
            com.target.ui.analytics.b.e.a(cartproduct, i1 - cartproduct.j_()).a();
        }
        mCartManager.a(guest, cartproduct, i1, callback);
    }

    public void a(Guest guest, CartProduct cartproduct, StoreIdentifier storeidentifier, f f1, d d1)
    {
        d1 = new j(d1);
        if (f1 == f.StorePickup)
        {
            f1 = h.PICKUP_IN_STORE;
        } else
        {
            f1 = h.SHIP_TO_STORE;
        }
        mCartManager.a(guest, cartproduct, f1, storeidentifier, true, d1);
    }

    public void a(Guest guest, CartProduct cartproduct, UsableShipMode usableshipmode, d d1)
    {
        usableshipmode = new j(d1);
        mCartManager.a(guest, cartproduct, h.SHIP_TO_HOME, null, true, usableshipmode);
    }

    public void a(Guest guest, CartProduct cartproduct, final d callback)
    {
        callback = new d() {

            final com.target.ui.service.b this$0;
            final d val$callback;

            public String a()
            {
                return callback.a();
            }

            public void a(CartDetails cartdetails)
            {
                com.target.ui.service.b.a(com.target.ui.service.b.this, cartdetails.b());
                callback.a(cartdetails);
            }

            public void a(com.target.mothership.model.cart.interfaces.a.u u1)
            {
                callback.b(u1, (o)c().d());
                n.a(u1.d(), u1.e()).e();
            }

            public volatile void a(Object obj)
            {
                a((CartDetails)obj);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.cart.interfaces.a.u)obj);
            }

            
            {
                this$0 = com.target.ui.service.b.this;
                callback = d1;
                super();
            }
        };
        am.a(cartproduct, cartproduct.j_()).e();
        mCartManager.a(guest, cartproduct, callback);
    }

    public void a(Guest guest, GiftProduct giftproduct, d d1)
    {
        d1 = new j(d1);
        mCartManager.a(guest, giftproduct, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, AddressParams addressparams, List list, boolean flag, d d1)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            CartProduct cartproduct = (CartProduct)list.next();
            if (!cartproduct.A())
            {
                arraylist.add(new k(cartproduct));
            }
        } while (true);
        addressparams = new i(addressparams, arraylist, Boolean.valueOf(flag));
        list = new j(d1);
        mCartManager.a(guest, initiatedcheckout, addressparams, list);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.common.params.b b1, String s, d d1)
    {
        d1 = new j(d1);
        mCartManager.a(guest, initiatedcheckout, b1, s, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, PaymentTender paymenttender, d d1)
    {
        d1 = new j(d1);
        mCartManager.a(guest, initiatedcheckout, paymenttender, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.common.tender.a a1, PaymentTender paymenttender, String s, d d1)
    {
        d1 = new j(d1);
        mCartManager.a(guest, initiatedcheckout, a1, paymenttender, s, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.common.tender.a a1, String s, AddressParams addressparams, d d1)
    {
        d1 = new j(d1);
        mCartManager.a(guest, initiatedcheckout, a1, s, addressparams, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.common.tender.a a1, String s, d d1)
    {
        d1 = new b(d1);
        mCartManager.a(guest, initiatedcheckout, a1, s, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.model.cart.b.d d1, d d2)
    {
        d2 = new j(d2);
        mCartManager.a(guest, initiatedcheckout, d1, d2);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, g g1, d d1)
    {
        d1 = new j(d1);
        mCartManager.a(guest, initiatedcheckout, g1, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, GuestAddress guestaddress, List list, d d1)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            CartProduct cartproduct = (CartProduct)list.next();
            if (!cartproduct.A())
            {
                arraylist.add(new k(cartproduct));
            }
        } while (true);
        guestaddress = new com.target.mothership.model.cart.b.b(guestaddress.a(), arraylist);
        list = new j(d1);
        mCartManager.a(guest, initiatedcheckout, guestaddress, list);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        d1 = new j(d1);
        mCartManager.a(guest, initiatedcheckout, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, String s, com.target.mothership.common.tender.a a1, String s1, d d1)
    {
        d1 = new b(d1);
        mCartManager.a(guest, initiatedcheckout, s, a1, s1, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, String s, d d1)
    {
        d1 = new b(d1);
        mCartManager.b(guest, initiatedcheckout, s, d1);
    }

    public void a(Guest guest, InitiatedPayPal initiatedpaypal, OrderReview orderreview, d d1)
    {
        d1 = new j(d1);
        mCartManager.a(guest, initiatedpaypal, orderreview, d1);
    }

    public void a(Guest guest, OrderReview orderreview, d d1)
    {
        d1 = new j(d1);
        mCartManager.a(guest, orderreview, d1);
    }

    public void a(Guest guest, PromoCode promocode, d d1)
    {
        d1 = new j(d1);
        mCartManager.a(guest, promocode, d1);
    }

    public void a(Guest guest, SaveForLaterProduct saveforlaterproduct, final d callback)
    {
        callback = new d() {

            final com.target.ui.service.b this$0;
            final d val$callback;

            public String a()
            {
                return callback.a();
            }

            public void a(AddToCart addtocart)
            {
                callback.a(addtocart);
            }

            public void a(com.target.mothership.model.cart.interfaces.a.b b1)
            {
                callback.b(b1, (o)c().d());
                n.a(b1.d(), b1.e()).e();
            }

            public volatile void a(Object obj)
            {
                a((AddToCart)obj);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.cart.interfaces.a.b)obj);
            }

            
            {
                this$0 = com.target.ui.service.b.this;
                callback = d1;
                super();
            }
        };
        mCartManager.a(guest, saveforlaterproduct, callback);
    }

    public void a(Guest guest, AppliedGiftCardTender appliedgiftcardtender, List list, d d1)
    {
        d1 = new j(d1);
        mCartManager.a(guest, appliedgiftcardtender.b(), appliedgiftcardtender.d(), list, d1);
    }

    public void a(final Guest guest, final d callback)
    {
        callback = new d() {

            final com.target.ui.service.b this$0;
            final d val$callback;
            final Guest val$guest;
            final d val$retryCallback;

            public String a()
            {
                return callback.a();
            }

            public void a(CartDetails cartdetails)
            {
                com.target.ui.service.b.a(com.target.ui.service.b.this, cartdetails.b());
                callback.a(cartdetails);
            }

            public void a(com.target.mothership.model.cart.interfaces.a.j j1)
            {
                if (com.target.ui.util.e.a((com.target.mothership.model.common.a.j)j1.f().get(com.target.ui.service.b.d())))
                {
                    com.target.ui.service.b.a(com.target.ui.service.b.this).b(guest, retryCallback);
                } else
                {
                    callback.b(j1, (o)c().d());
                }
                n.a(j1.d(), j1.e()).e();
            }

            public volatile void a(Object obj)
            {
                a((CartDetails)obj);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.cart.interfaces.a.j)obj);
            }

            
            {
                this$0 = com.target.ui.service.b.this;
                callback = d1;
                guest = guest1;
                retryCallback = d2;
                super();
            }
        };
        mCartManager.b(guest, callback);
    }

    public void a(Guest guest, List list, String s, String s1, String s2, d d1)
    {
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(new com.target.mothership.model.cart.b.e((CartProduct)list.next(), s1, s, null, s2))) { }
        list = new l(arraylist);
        s = new j(d1);
        mCartManager.a(guest, list, s);
    }

    public void a(com.target.mothership.model.h h1)
    {
        com.target.mothership.model.product.c c1 = new com.target.mothership.model.product.c();
        h1 = new u(h1);
        ProductRecommendationsParam productrecommendationsparam = new ProductRecommendationsParam();
        productrecommendationsparam.a(com.target.mothership.common.params.ProductRecommendationsParam.a.CART_RECOMMENDATIONS);
        productrecommendationsparam.a(6);
        productrecommendationsparam.b(6);
        c1.a(productrecommendationsparam, h1);
    }

    public void a(a a1)
    {
        if (mOnCartQuantityUpdatedListeners.contains(a1))
        {
            return;
        } else
        {
            mOnCartQuantityUpdatedListeners.add(a1);
            return;
        }
    }

    public void a(String s)
    {
        mCartManager.a(s);
    }

    public void b()
    {
        mCartQuantity = 0;
        a(mCartQuantity);
    }

    public void b(Guest guest)
    {
        if (mIsCartBadgeSetup)
        {
            q.a(LOG_TAG, "Your request to fetch the cart summary was blocked. This is a hack and look up the java-doc of getCartSummary for more details");
            return;
        } else
        {
            mIsCartBadgeSetup = true;
            mCartManager.a(guest, new d() {

                final com.target.ui.service.b this$0;

                public void a(CartSummary cartsummary)
                {
                    com.target.ui.service.b.a(com.target.ui.service.b.this, cartsummary.b());
                }

                public void a(com.target.mothership.model.cart.interfaces.a.j j1)
                {
                    q.a(com.target.ui.service.b.e(), "Unable to fetch the Cart Summary");
                    n.a(j1.d(), j1.e()).e();
                }

                public volatile void a(Object obj)
                {
                    a((CartSummary)obj);
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.cart.interfaces.a.j)obj);
                }

            
            {
                this$0 = com.target.ui.service.b.this;
                super();
            }
            });
            return;
        }
    }

    public void b(Guest guest, com.target.mothership.model.cart.b.a a1, final d callback)
    {
        callback = new d() {

            final com.target.ui.service.b this$0;
            final d val$callback;

            public String a()
            {
                return callback.a();
            }

            public void a(ExpressOrderReview expressorderreview)
            {
                callback.a(expressorderreview);
            }

            public void a(com.target.mothership.model.cart.interfaces.a.b b1)
            {
                callback.b(b1, (o)c().d());
                n.a(b1.d(), b1.e()).e();
            }

            public volatile void a(Object obj)
            {
                a((ExpressOrderReview)obj);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.cart.interfaces.a.b)obj);
            }

            
            {
                this$0 = com.target.ui.service.b.this;
                callback = d1;
                super();
            }
        };
        mCartManager.b(guest, a1, callback);
    }

    public void b(Guest guest, CartProduct cartproduct, d d1)
    {
        d1 = new j(d1);
        mCartManager.c(guest, cartproduct, d1);
    }

    public void b(Guest guest, InitiatedCheckout initiatedcheckout, g g1, d d1)
    {
        d1 = new j(d1);
        mCartManager.b(guest, initiatedcheckout, g1, d1);
    }

    public void b(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        d1 = new b(d1);
        mCartManager.g(guest, initiatedcheckout, d1);
    }

    public void b(Guest guest, InitiatedCheckout initiatedcheckout, String s, d d1)
    {
        d1 = new j(d1);
        mCartManager.a(guest, initiatedcheckout, s, false, d1);
    }

    public void b(Guest guest, SaveForLaterProduct saveforlaterproduct, d d1)
    {
        d1 = new j(d1);
        mCartManager.b(guest, saveforlaterproduct, d1);
    }

    public void b(Guest guest, d d1)
    {
        d1 = new j(d1);
        mCartManager.d(guest, d1);
    }

    public void b(Guest guest, List list, String s, String s1, String s2, d d1)
    {
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(new com.target.mothership.model.cart.b.e((CartProduct)list.next(), s1, s, s2, null))) { }
        list = new l(arraylist);
        s = new j(d1);
        mCartManager.a(guest, list, s);
    }

    public void b(com.target.mothership.model.h h1)
    {
        h1 = new u(h1);
        mCartManager.a(h1);
    }

    public void b(a a1)
    {
        if (!mOnCartQuantityUpdatedListeners.contains(a1))
        {
            return;
        } else
        {
            mOnCartQuantityUpdatedListeners.remove(a1);
            return;
        }
    }

    public int c()
    {
        return mCartQuantity;
    }

    public void c(Guest guest, CartProduct cartproduct, d d1)
    {
        d1 = new j(d1);
        mCartManager.b(guest, cartproduct, d1);
    }

    public void c(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        mCartManager.f(guest, initiatedcheckout, d1);
    }

    public void c(Guest guest, InitiatedCheckout initiatedcheckout, String s, d d1)
    {
        d1 = new j(d1);
        mCartManager.a(guest, initiatedcheckout, s, true, d1);
    }

    public void c(Guest guest, d d1)
    {
        d1 = new j(d1);
        mCartManager.c(guest, d1);
    }

    public void d(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        d1 = new j(d1);
        mCartManager.b(guest, initiatedcheckout, d1);
    }

    public void d(Guest guest, InitiatedCheckout initiatedcheckout, String s, d d1)
    {
        d1 = new j(d1);
        mCartManager.a(guest, initiatedcheckout, s, d1);
    }

    public void e(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        d1 = new j(d1);
        mCartManager.c(guest, initiatedcheckout, d1);
    }

    public void f(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        d1 = new j(d1);
        mCartManager.e(guest, initiatedcheckout, d1);
    }

    public void g(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        d1 = new j(d1);
        mCartManager.d(guest, initiatedcheckout, d1);
    }


    // Unreferenced inner class com/target/ui/service/b$1

/* anonymous class */
    class _cls1 extends d
    {

        final com.target.ui.service.b this$0;
        final d val$callback;

        public String a()
        {
            return callback.a();
        }

        public void a(CartDetails cartdetails)
        {
            com.target.ui.service.b.a(com.target.ui.service.b.this, cartdetails.b());
            callback.a(cartdetails);
        }

        public void a(com.target.mothership.model.cart.interfaces.a.j j1)
        {
            callback.b(j1, (o)c().d());
            n.a(j1.d(), j1.e()).e();
        }

        public volatile void a(Object obj)
        {
            a((CartDetails)obj);
        }

        public void b(Object obj)
        {
            a((com.target.mothership.model.cart.interfaces.a.j)obj);
        }

            
            {
                this$0 = com.target.ui.service.b.this;
                callback = d1;
                super();
            }
    }

}
