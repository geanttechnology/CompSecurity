// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart;

import com.google.a.a.e;
import com.target.mothership.common.a.f;
import com.target.mothership.common.params.AddressParams;
import com.target.mothership.common.product.CatEntryId;
import com.target.mothership.common.registries.RegistryId;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.tender.PaymentTender;
import com.target.mothership.model.cart.b.m;
import com.target.mothership.model.cart.handler.ac;
import com.target.mothership.model.cart.handler.ae;
import com.target.mothership.model.cart.handler.af;
import com.target.mothership.model.cart.handler.ag;
import com.target.mothership.model.cart.handler.ah;
import com.target.mothership.model.cart.handler.ai;
import com.target.mothership.model.cart.handler.aj;
import com.target.mothership.model.cart.handler.ak;
import com.target.mothership.model.cart.handler.an;
import com.target.mothership.model.cart.handler.ao;
import com.target.mothership.model.cart.handler.ap;
import com.target.mothership.model.cart.handler.aq;
import com.target.mothership.model.cart.handler.ar;
import com.target.mothership.model.cart.handler.as;
import com.target.mothership.model.cart.handler.h;
import com.target.mothership.model.cart.handler.i;
import com.target.mothership.model.cart.handler.j;
import com.target.mothership.model.cart.handler.k;
import com.target.mothership.model.cart.handler.r;
import com.target.mothership.model.cart.handler.v;
import com.target.mothership.model.cart.handler.w;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.GiftProduct;
import com.target.mothership.model.cart.interfaces.InitiatedCheckout;
import com.target.mothership.model.cart.interfaces.InitiatedPayPal;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.cart.interfaces.PromoCode;
import com.target.mothership.model.cart.interfaces.SaveForLaterProduct;
import com.target.mothership.model.cart.interfaces.Shipment;
import com.target.mothership.model.common.AppliedGiftCardTender;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.product.handler.g;
import com.target.mothership.model.product.interfaces.ProductAgeRestriction;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.apigee.c.a.aa;
import com.target.mothership.services.apigee.c.a.ab;
import com.target.mothership.services.apigee.c.a.c;
import com.target.mothership.services.apigee.c.a.l;
import com.target.mothership.services.apigee.c.a.p;
import com.target.mothership.services.apigee.c.a.q;
import com.target.mothership.services.apigee.c.a.s;
import com.target.mothership.services.apigee.c.a.t;
import com.target.mothership.services.apigee.c.a.x;
import com.target.mothership.services.apigee.c.a.y;
import com.target.mothership.services.apigee.c.a.z;
import com.target.mothership.services.apigee.c.c.a;
import com.target.mothership.util.o;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart:
//            a

class b
    implements com.target.mothership.model.cart.a
{

    private static final int AGE_RESTRICTED_MIN_AGE = 17;
    private static final int AGE_RESTRICTED_PREV_AGE = 1000;
    private final a mServices = new a();

    public b()
    {
    }

    private com.target.mothership.services.apigee.c.a.a a(com.target.mothership.model.cart.b.a a1)
    {
        Object obj = a1.a();
        com.target.mothership.services.apigee.c.a.a a2 = new com.target.mothership.services.apigee.c.a.a((CatEntryId)((ProductDetails) (obj)).f().c(), a1.b());
        Store store = a1.c();
        com.target.mothership.common.a.g g1 = a1.g();
        if (store != null && store.getStoreId() != null && g1 != null)
        {
            a2.a(store.getStoreId().a());
            a2.b((new g()).a(g1));
        }
        if (((ProductDetails) (obj)).t().a())
        {
            int i1 = 17;
            obj = ((ProductDetails) (obj)).t().b();
            if (o.g(((String) (obj))))
            {
                i1 = Integer.parseInt(((String) (obj)));
            }
            a2.a(i1, 1000);
        }
        if (b(a1))
        {
            a2.a(a1.e(), a1.f().a());
        }
        return a2;
    }

    private void a(String s1, c c1, d d1)
    {
        d1 = new com.target.mothership.model.e(new h(d1));
        mServices.a(s1, c1, d1);
    }

    private static boolean a(OrderReview orderreview)
    {
        Iterator iterator = orderreview.n().iterator();
        boolean flag = false;
        boolean flag1 = false;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Shipment shipment = (Shipment)iterator.next();
            orderreview = shipment.b();
            if (orderreview != null)
            {
                orderreview = orderreview.a();
            } else
            {
                orderreview = null;
            }
            if (orderreview == f.ShipToHome || orderreview == f.Special)
            {
                if (!shipment.c().b())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                flag = true;
            } else
            if (orderreview != f.ShipToStore && !flag)
            {
                flag1 = true;
            }
        } while (true);
        return flag1;
    }

    private boolean b(com.target.mothership.model.cart.b.a a1)
    {
        return a1.f() != null && o.g(a1.f().a());
    }

    public void a(Guest guest, PaymentTender paymenttender, d d1)
    {
        c c1 = new c();
        c1.a(paymenttender.a());
        a(guest.getAccessToken(), c1, d1);
    }

    public void a(Guest guest, com.target.mothership.common.tender.a a1, PaymentTender paymenttender, String s1, d d1)
    {
        c c1 = new c();
        c1.a(paymenttender.a());
        if (a1 == com.target.mothership.common.tender.a.TARGET_DEBIT)
        {
            c1.d(s1);
        } else
        {
            c1.e(s1);
        }
        a(guest.getAccessToken(), c1, d1);
    }

    public void a(Guest guest, com.target.mothership.model.cart.b.a a1, d d1)
    {
        Object obj = new com.target.mothership.model.cart.a.c(a1);
        if (((com.target.mothership.model.cart.a.c) (obj)).a())
        {
            d1.b(((com.target.mothership.model.cart.a.c) (obj)).b());
            return;
        }
        obj = a(a1);
        d1 = new com.target.mothership.model.e(new com.target.mothership.model.cart.handler.a(d1));
        if (b(a1))
        {
            mServices.c(guest.getAccessToken(), ((com.target.mothership.services.apigee.c.a.a) (obj)), d1);
            return;
        } else
        {
            mServices.a(guest.getAccessToken(), ((com.target.mothership.services.apigee.c.a.a) (obj)), d1);
            return;
        }
    }

    public void a(Guest guest, com.target.mothership.model.cart.b.l l1, d d1)
    {
        l1 = (new m()).a(l1);
        d1 = new com.target.mothership.model.e(new com.target.mothership.model.cart.handler.b(d1));
        mServices.a(guest.getAccessToken(), l1, d1);
    }

    public void a(Guest guest, CartProduct cartproduct, int i1, d d1)
    {
        if (!o.g(cartproduct.a()))
        {
            throw new IllegalStateException("productId can't be invalid");
        } else
        {
            cartproduct = new ab(cartproduct.a(), i1);
            d1 = new com.target.mothership.model.e(new aq(d1));
            mServices.a(guest.getAccessToken(), cartproduct, d1);
            return;
        }
    }

    public void a(Guest guest, CartProduct cartproduct, d d1)
    {
        if (!o.g(cartproduct.a()))
        {
            throw new IllegalStateException("productId can't be invalid");
        } else
        {
            d1 = new com.target.mothership.model.e(new aj(d1));
            mServices.a(guest.getAccessToken(), cartproduct.a(), d1);
            return;
        }
    }

    public void a(Guest guest, CartProduct cartproduct, com.target.mothership.services.apigee.c.a.h h1, StoreIdentifier storeidentifier, boolean flag, d d1)
    {
        if (!o.g(cartproduct.a()))
        {
            throw new IllegalStateException("productId can't be invalid");
        }
        d1 = new com.target.mothership.model.e(new ao(d1));
        cartproduct = new x(cartproduct.a());
        if (storeidentifier != null)
        {
            cartproduct.a(storeidentifier.a());
        }
        mServices.a(guest.getAccessToken(), h1, flag, cartproduct, d1);
    }

    public void a(Guest guest, GiftProduct giftproduct, d d1)
    {
        com.target.mothership.model.cart.a.h h1 = new com.target.mothership.model.cart.a.h(giftproduct);
        if (h1.a())
        {
            d1.b(h1.b());
        }
        d1 = new com.target.mothership.model.e(new j(d1));
        giftproduct = new com.target.mothership.services.apigee.c.a.e((CatEntryId)giftproduct.f().c(), giftproduct.m_());
        mServices.a(guest.getAccessToken(), giftproduct, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.common.params.b b1, String s1, d d1)
    {
        initiatedcheckout = (new com.target.mothership.model.cart.b.f(s1)).a(b1);
        a(guest.getAccessToken(), ((c) (initiatedcheckout)), d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.common.tender.a a1, String s1, AddressParams addressparams, d d1)
    {
        initiatedcheckout = new y(a1, s1, addressparams);
        a1 = new com.target.mothership.model.e(new h(d1));
        mServices.a(guest.getAccessToken(), initiatedcheckout, a1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.common.tender.a a1, String s1, d d1)
    {
        initiatedcheckout = new com.target.mothership.model.e(new r(d1));
        if (a1 == com.target.mothership.common.tender.a.TARGET_DEBIT)
        {
            a1 = new s(s1);
            mServices.a(guest.getAccessToken(), a1, initiatedcheckout);
            return;
        } else
        {
            a1 = new com.target.mothership.services.apigee.c.a.o(s1);
            mServices.a(guest.getAccessToken(), a1, initiatedcheckout);
            return;
        }
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.model.cart.b.b b1, d d1)
    {
        initiatedcheckout = (new com.target.mothership.model.cart.b.c()).a(b1);
        b1 = new com.target.mothership.model.e(new com.target.mothership.model.cart.handler.b(d1));
        mServices.a(guest.getAccessToken(), initiatedcheckout, b1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.model.cart.b.d d1, d d2)
    {
        initiatedcheckout = new com.target.mothership.services.apigee.c.a.b(d1.b(), d1.a());
        d1 = new com.target.mothership.model.e(new com.target.mothership.model.cart.handler.g(d2));
        mServices.a(guest.getAccessToken(), initiatedcheckout, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.model.cart.b.g g1, d d1)
    {
        initiatedcheckout = new com.target.mothership.model.e(new ap(d1));
        d1 = new aa(g1.a(), g1.b(), g1.c());
        if (o.g(g1.d()))
        {
            d1.a(g1.c());
        }
        mServices.a(guest.getAccessToken(), d1, initiatedcheckout);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.model.cart.b.i i1, d d1)
    {
        initiatedcheckout = (new com.target.mothership.model.cart.b.j()).a(i1);
        i1 = new com.target.mothership.model.e(new com.target.mothership.model.cart.handler.b(d1));
        mServices.a(guest.getAccessToken(), initiatedcheckout, i1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        initiatedcheckout = new com.target.mothership.model.e(new as(d1));
        mServices.e(guest.getAccessToken(), initiatedcheckout);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, String s1, com.target.mothership.common.tender.a a1, String s2, d d1)
    {
        initiatedcheckout = new com.target.mothership.model.e(new r(d1));
        if (a1 == com.target.mothership.common.tender.a.TARGET_DEBIT)
        {
            s1 = new q(s1, s2);
            mServices.a(guest.getAccessToken(), s1, initiatedcheckout);
            return;
        } else
        {
            s1 = new p(s1, s2);
            mServices.a(guest.getAccessToken(), s1, initiatedcheckout);
            return;
        }
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, String s1, d d1)
    {
        initiatedcheckout = new com.target.mothership.model.e(new k(d1));
        s1 = new com.target.mothership.services.apigee.c.a.f(s1);
        mServices.a(guest.getAccessToken(), s1, initiatedcheckout);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, String s1, boolean flag, d d1)
    {
        initiatedcheckout = new com.target.mothership.model.e(new i(d1));
        s1 = new com.target.mothership.services.apigee.c.a.d(s1, flag);
        mServices.a(guest.getAccessToken(), s1, initiatedcheckout);
    }

    public void a(Guest guest, InitiatedPayPal initiatedpaypal, OrderReview orderreview, d d1)
    {
        d1 = new com.target.mothership.model.e(new ag(d1));
        initiatedpaypal = new com.target.mothership.services.apigee.c.a.m(a(orderreview), initiatedpaypal.b());
        mServices.a(guest.getAccessToken(), initiatedpaypal, d1);
    }

    public void a(Guest guest, OrderReview orderreview, d d1)
    {
        d1 = new com.target.mothership.model.e(new af(d1));
        orderreview = new l(a(orderreview));
        mServices.a(guest.getAccessToken(), orderreview, d1);
    }

    public void a(Guest guest, PromoCode promocode, d d1)
    {
        d1 = new com.target.mothership.model.e(new ak(d1));
        promocode = new t(promocode.b());
        mServices.a(guest.getAccessToken(), promocode, d1);
    }

    public void a(Guest guest, SaveForLaterProduct saveforlaterproduct, d d1)
    {
        d1 = new com.target.mothership.model.e(new com.target.mothership.model.cart.handler.a(d1));
        saveforlaterproduct = new com.target.mothership.services.apigee.c.a.j(saveforlaterproduct.b());
        mServices.a(guest.getAccessToken(), saveforlaterproduct, d1);
    }

    public void a(Guest guest, d d1)
    {
        d1 = new com.target.mothership.model.e(new com.target.mothership.model.cart.handler.p(d1));
        mServices.a(guest.getAccessToken(), d1);
    }

    public void a(Guest guest, String s1, BigDecimal bigdecimal, List list, d d1)
    {
        com.target.mothership.model.e e1;
        int i1;
        e1 = new com.target.mothership.model.e(new ai(d1));
        i1 = 0;
_L3:
        AppliedGiftCardTender appliedgiftcardtender;
        if (i1 >= list.size())
        {
            break MISSING_BLOCK_LABEL_130;
        }
        appliedgiftcardtender = (AppliedGiftCardTender)list.get(i1);
        if (!appliedgiftcardtender.b().equals(s1) || appliedgiftcardtender.d().compareTo(bigdecimal) != 0) goto _L2; else goto _L1
_L1:
        s1 = ((AppliedGiftCardTender)list.get(i1)).c();
_L4:
        if (s1 == null)
        {
            d1.a(null);
            return;
        } else
        {
            mServices.b(guest.getAccessToken(), s1, e1);
            return;
        }
_L2:
        i1++;
          goto _L3
        s1 = null;
          goto _L4
    }

    public void a(com.target.mothership.model.h h1)
    {
        h1 = new com.target.mothership.model.e(new v(h1));
        mServices.a(h1);
    }

    public void b(Guest guest, com.target.mothership.model.cart.b.a a1, d d1)
    {
        com.target.mothership.model.cart.a.c c1 = new com.target.mothership.model.cart.a.c(a1);
        if (c1.a())
        {
            d1.b(c1.b());
            return;
        } else
        {
            a1 = a(a1);
            d1 = new com.target.mothership.model.e(new an(d1));
            mServices.b(guest.getAccessToken(), a1, d1);
            return;
        }
    }

    public void b(Guest guest, CartProduct cartproduct, d d1)
    {
        if (!o.g(cartproduct.a()))
        {
            throw new IllegalStateException("productId can't be invalid");
        } else
        {
            d1 = new com.target.mothership.model.e(new com.target.mothership.model.cart.handler.x(d1));
            mServices.d(guest.getAccessToken(), cartproduct.a(), d1);
            return;
        }
    }

    public void b(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.model.cart.b.g g1, d d1)
    {
        initiatedcheckout = new com.target.mothership.model.e(new ap(d1));
        d1 = new z(g1.a(), g1.b());
        if (o.g(g1.d()))
        {
            d1.b(g1.d());
        }
        if (o.g(g1.c()))
        {
            d1.a(g1.c());
        }
        mServices.a(guest.getAccessToken(), d1, initiatedcheckout);
    }

    public void b(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        initiatedcheckout = new com.target.mothership.model.e(new com.target.mothership.model.cart.handler.z(d1));
        mServices.f(guest.getAccessToken(), initiatedcheckout);
    }

    public void b(Guest guest, InitiatedCheckout initiatedcheckout, String s1, d d1)
    {
        initiatedcheckout = new com.target.mothership.model.e(new r(d1));
        s1 = new com.target.mothership.services.apigee.c.a.r(s1);
        mServices.a(guest.getAccessToken(), s1, initiatedcheckout);
    }

    public void b(Guest guest, SaveForLaterProduct saveforlaterproduct, d d1)
    {
        if (!o.g(saveforlaterproduct.b()))
        {
            throw new IllegalStateException("orderItemId can't be invalid");
        } else
        {
            d1 = new com.target.mothership.model.e(new ar(d1));
            mServices.c(guest.getAccessToken(), saveforlaterproduct.b(), d1);
            return;
        }
    }

    public void b(Guest guest, d d1)
    {
        d1 = new com.target.mothership.model.e(new com.target.mothership.model.cart.handler.l(d1));
        mServices.b(guest.getAccessToken(), d1);
    }

    public void c(Guest guest, CartProduct cartproduct, d d1)
    {
        if (!o.g(cartproduct.a()))
        {
            throw new IllegalStateException("productId can't be invalid");
        } else
        {
            d1 = new com.target.mothership.model.e(new ar(d1));
            cartproduct = new com.target.mothership.services.apigee.c.a.i(cartproduct.a());
            mServices.a(guest.getAccessToken(), cartproduct, d1);
            return;
        }
    }

    public void c(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        initiatedcheckout = new com.target.mothership.model.e(new w(d1));
        mServices.g(guest.getAccessToken(), initiatedcheckout);
    }

    public void c(Guest guest, d d1)
    {
        d1 = new com.target.mothership.model.e(new ac(d1));
        mServices.d(guest.getAccessToken(), d1);
    }

    public void d(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        initiatedcheckout = new com.target.mothership.model.e(new ai(d1));
        mServices.h(guest.getAccessToken(), initiatedcheckout);
    }

    public void d(Guest guest, d d1)
    {
        d1 = new com.target.mothership.model.e(new com.target.mothership.model.cart.handler.y(d1));
        mServices.k(guest.getAccessToken(), d1);
    }

    public void e(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        initiatedcheckout = new com.target.mothership.model.e(new ah(d1));
        mServices.c(guest.getAccessToken(), initiatedcheckout);
    }

    public void f(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        initiatedcheckout = new com.target.mothership.model.e(new ae(d1));
        mServices.i(guest.getAccessToken(), initiatedcheckout);
    }

    public void g(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        initiatedcheckout = new com.target.mothership.model.e(new r(d1));
        mServices.j(guest.getAccessToken(), initiatedcheckout);
    }
}
