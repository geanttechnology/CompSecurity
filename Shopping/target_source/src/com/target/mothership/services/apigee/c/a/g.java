// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.a;

import com.target.mothership.services.f.a.a;
import com.target.mothership.services.f.a.c;
import java.util.Map;

// Referenced classes of package com.target.mothership.services.apigee.c.a:
//            a, aa, ab, ad, 
//            b, c, d, e, 
//            f, i, j, l, 
//            m, o, r, s, 
//            t, v, w, y, 
//            z, x

public class g extends a
{

    private static final c ADD_ITEM;
    private static final String ALL = "all";
    private static final c APPLIED_TEAM_MEMBER_DISCOUNT;
    private static final c APPLY_GIFT_CARD;
    private static final com.target.mothership.services.f.a.b.a APPLY_ON = new com.target.mothership.services.f.a.b.a("apply_on");
    private static final c APPLY_PAYMENT_INSTRUCTION;
    private static final c APPLY_REWARD;
    private static final c APPLY_TEAM_MEMBER_DISCOUNT;
    private static final c CALCULATE_TAX_BY_ZIP;
    private static final c CHECKOUT;
    private static final c FREE_SHIPPING_THRESHOLD;
    private static final com.target.mothership.services.f.a.b.a FROM_CART = new com.target.mothership.services.f.a.b.a("from_cart");
    private static final com.target.mothership.services.f.a.b.a FULFILLMENT_METHOD = new com.target.mothership.services.f.a.b.a("fulfillment_method");
    private static final com.target.mothership.services.f.a.b.a GC_PAYMENT_ID = new com.target.mothership.services.f.a.b.a("giftcard_payment_id");
    private static final c GET_APPLIED_TENDERS;
    private static final c GET_CART_DETAILS;
    private static final c GET_CART_SUMMARY;
    private static final c GET_ORDER_REVIEW;
    private static final c GET_ORDER_SUMMARY;
    private static final c GET_PICKUP_CONTACTS;
    private static final c GET_PRODUCT_SHIPPING_METHODS;
    private static final c GET_USABLE_TENDERS;
    private static final c INITIATE_CHECKOUT;
    private static final c INITIATE_EXPRESS_CHECKOUT;
    private static final c MOVE_SAVE_FOR_LATER_TO_CART;
    private static final c MOVE_TO_SAVE_FOR_LATER_LIST;
    private static final String NO = "N";
    private static final com.target.mothership.services.f.a.b.a ORDER_LINE_ID = new com.target.mothership.services.f.a.b.a("order_line_id");
    private static final c PAYPAL_INITIATE;
    private static final c PAYPAL_UPDATE;
    private static final com.target.mothership.services.f.a.b.a PRODUCT_ORDER_ID = new com.target.mothership.services.f.a.b.a("product_order_id");
    private static final c REMOVE_APPLIED_GC_TENDERS;
    private static final c REMOVE_APPLIED_TENDERS;
    private static final c REMOVE_FROM_SAVE_FOR_LATER_LIST;
    private static final c REMOVE_GET_SAVED_FOR_LATER_LIST;
    private static final c REMOVE_PRODUCT;
    private static final c REMOVE_PRODUCT_FROM_CART;
    private static final c REMOVE_TEAM_MEMBER_DISCOUNT;
    private static final com.target.mothership.services.f.a.b.a RESPONSE_GROUP = new com.target.mothership.services.f.a.b.a("responseGroup");
    private static final String RESPONSE_GROUP_CART_SUMMARY = "cartSummary";
    private static final String RESPONSE_GROUP_ORDER_SUMMARY = "orderSummary";
    private static final c RETURN_POLICY;
    private static final c SHIPPING_DETAILS;
    private static final String SINGLE = "single";
    private static final com.target.mothership.services.f.a.b.a SOURCE = new com.target.mothership.services.f.a.b.a("source");
    private static final String SOURCE_ESP_AND_WARRANTY = "espAddWarranty";
    private static final String SOURCE_REGISTRY_OR_LIST = "registryOrList";
    private static final c TWO_TAP_CHECKOUT;
    private static final com.target.mothership.services.f.a.b.a TYPE = new com.target.mothership.services.f.a.b.a("type");
    private static final c UPDATE_APPLIED_TENDERS;
    private static final c UPDATE_CART;
    private static final c UPDATE_FULFILLMENT_METHOD;
    private static final c UPDATE_PICKUP_CONTACTS;
    private static final c UPDATE_PRODUCT;
    private static final c UPDATE_PRODUCT_FROM_CART;
    private static final c UPDATE_PROMO_CODE;
    private static final c USABLE_SHIPPING_INFO;
    private static final String YES = "Y";

    public g(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    public com.target.mothership.services.f.a.b.b a()
    {
        return a(FREE_SHIPPING_THRESHOLD, null, null, null, null);
    }

    public com.target.mothership.services.f.a.b.b a(String s)
    {
        return a(GET_CART_DETAILS, null, null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, com.target.mothership.services.apigee.c.a.a a1)
    {
        return a(TWO_TAP_CHECKOUT, ((com.target.mothership.services.n) (a1)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, com.target.mothership.services.apigee.c.a.a a1, boolean flag)
    {
        c c1 = ADD_ITEM;
        android.support.v4.f.a a2 = new android.support.v4.f.a();
        if (flag)
        {
            a2.put(RESPONSE_GROUP.a(), "cartSummary");
        }
        return a(c1, ((com.target.mothership.services.n) (a1)), null, ((Map) (a2)), null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, aa aa)
    {
        return a(UPDATE_PICKUP_CONTACTS, ((com.target.mothership.services.n) (aa)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, ab ab)
    {
        return a(UPDATE_PRODUCT_FROM_CART, ((com.target.mothership.services.n) (ab)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, ad ad)
    {
        return a(SHIPPING_DETAILS, ((com.target.mothership.services.n) (ad)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, b b1)
    {
        return a(APPLY_GIFT_CARD, ((com.target.mothership.services.n) (b1)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, com.target.mothership.services.apigee.c.a.c c1)
    {
        return a(APPLY_PAYMENT_INSTRUCTION, ((com.target.mothership.services.n) (c1)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, d d1)
    {
        return a(UPDATE_PROMO_CODE, ((com.target.mothership.services.n) (d1)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, e e1)
    {
        return a(APPLY_REWARD, ((com.target.mothership.services.n) (e1)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, f f1, boolean flag)
    {
        c c1 = APPLY_TEAM_MEMBER_DISCOUNT;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        if (flag)
        {
            a1.put(RESPONSE_GROUP.a(), "orderSummary");
        }
        return a(c1, ((com.target.mothership.services.n) (f1)), null, ((Map) (a1)), null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, i k)
    {
        return a(MOVE_TO_SAVE_FOR_LATER_LIST, ((com.target.mothership.services.n) (k)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, j j1)
    {
        return a(MOVE_SAVE_FOR_LATER_TO_CART, ((com.target.mothership.services.n) (j1)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, l l)
    {
        return a(PAYPAL_INITIATE, ((com.target.mothership.services.n) (l)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, m m)
    {
        return a(PAYPAL_UPDATE, ((com.target.mothership.services.n) (m)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, o o)
    {
        return a(CHECKOUT, ((com.target.mothership.services.n) (o)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, r r)
    {
        return a(CHECKOUT, ((com.target.mothership.services.n) (r)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, s s1)
    {
        return a(CHECKOUT, ((com.target.mothership.services.n) (s1)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, t t)
    {
        return a(UPDATE_PROMO_CODE, ((com.target.mothership.services.n) (t)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, v v)
    {
        return a(SHIPPING_DETAILS, ((com.target.mothership.services.n) (v)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, w w)
    {
        return a(SHIPPING_DETAILS, ((com.target.mothership.services.n) (w)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, y y)
    {
        return a(UPDATE_APPLIED_TENDERS, ((com.target.mothership.services.n) (y)), ((Map) (new android.support.v4.f.a())), null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, z z)
    {
        return a(UPDATE_PICKUP_CONTACTS, ((com.target.mothership.services.n) (z)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, String s1)
    {
        c c1 = REMOVE_PRODUCT_FROM_CART;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(PRODUCT_ORDER_ID.b(), s1);
        return a(c1, null, ((Map) (a1)), null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, String s1, boolean flag, x x)
    {
        c c1 = UPDATE_FULFILLMENT_METHOD;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(FULFILLMENT_METHOD.b(), s1);
        if (flag)
        {
            a1.put(APPLY_ON.b(), "all");
        } else
        {
            a1.put(APPLY_ON.b(), "single");
        }
        return a(c1, ((com.target.mothership.services.n) (x)), ((Map) (a1)), null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, boolean flag)
    {
        c c1 = REMOVE_TEAM_MEMBER_DISCOUNT;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        if (flag)
        {
            a1.put(RESPONSE_GROUP.a(), "orderSummary");
        }
        return a(c1, null, null, ((Map) (a1)), null, s);
    }

    public com.target.mothership.services.f.a.b.b b(String s)
    {
        return a(GET_CART_SUMMARY, null, null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b b(String s, com.target.mothership.services.apigee.c.a.a a1, boolean flag)
    {
        c c1 = ADD_ITEM;
        android.support.v4.f.a a2 = new android.support.v4.f.a();
        a2.put(SOURCE.a(), "registryOrList");
        if (flag)
        {
            a2.put(RESPONSE_GROUP.a(), "cartSummary");
        }
        return a(c1, a1, null, a2, null, s);
    }

    public com.target.mothership.services.f.a.b.b b(String s, String s1)
    {
        c c1 = REMOVE_APPLIED_GC_TENDERS;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(GC_PAYMENT_ID.b(), s1);
        return a(c1, null, a1, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b c(String s)
    {
        return a(INITIATE_EXPRESS_CHECKOUT, null, null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b c(String s, String s1)
    {
        c c1 = REMOVE_FROM_SAVE_FOR_LATER_LIST;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(ORDER_LINE_ID.b(), s1);
        return a(c1, null, a1, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b d(String s)
    {
        return a(USABLE_SHIPPING_INFO, null, null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b d(String s, String s1)
    {
        c c1 = GET_PRODUCT_SHIPPING_METHODS;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(PRODUCT_ORDER_ID.b(), s1);
        return a(c1, null, a1, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b e(String s)
    {
        return a(GET_USABLE_TENDERS, null, null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b f(String s)
    {
        return a(GET_APPLIED_TENDERS, null, null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b g(String s)
    {
        return a(REMOVE_APPLIED_TENDERS, null, new android.support.v4.f.a(), null, null, s);
    }

    public com.target.mothership.services.f.a.b.b h(String s)
    {
        return a(GET_ORDER_REVIEW, null, null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b i(String s)
    {
        return a(CHECKOUT, null, null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b j(String s)
    {
        return a(REMOVE_GET_SAVED_FOR_LATER_LIST, null, null, null, null, s);
    }

    static 
    {
        GET_CART_SUMMARY = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/cart?responseGroup=cartSummary");
        GET_CART_DETAILS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/cart?responseGroup=cartDetails,shippingInfo,cartSummary,rewardOptions");
        ADD_ITEM = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/products");
        REMOVE_PRODUCT = new c(com.target.mothership.services.f.a.d.a.DELETE, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/products/{product_order_id}?fromCart={from_cart}");
        REMOVE_PRODUCT_FROM_CART = new c(com.target.mothership.services.f.a.d.a.DELETE, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/products/{product_order_id}?fromCart=Y&responseGroup=cartDetails,shippingInfo,eligibleShipModes,cartSummary,rewardOptions");
        APPLY_TEAM_MEMBER_DISCOUNT = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/team_member_discount");
        APPLIED_TEAM_MEMBER_DISCOUNT = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/team_member_discount");
        REMOVE_TEAM_MEMBER_DISCOUNT = new c(com.target.mothership.services.f.a.d.a.DELETE, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/team_member_discount");
        UPDATE_PRODUCT = new c(com.target.mothership.services.f.a.d.a.PUT, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/products?fromCart={from_cart}");
        UPDATE_PRODUCT_FROM_CART = new c(com.target.mothership.services.f.a.d.a.PUT, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/products?fromCart=Y&responseGroup=cartDetails,shippingInfo,eligibleShipModes,cartSummary,rewardOptions");
        UPDATE_FULFILLMENT_METHOD = new c(com.target.mothership.services.f.a.d.a.PUT, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/fullfillment_method?method={fulfillment_method}&applyon={apply_on}");
        CALCULATE_TAX_BY_ZIP = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/tax");
        INITIATE_CHECKOUT = new c(com.target.mothership.services.f.a.d.a.PUT, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/initiate_checkout?channel=apps");
        INITIATE_EXPRESS_CHECKOUT = new c(com.target.mothership.services.f.a.d.a.PUT, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/initiate_checkout?responseGroup=orderReview&channel=apps");
        USABLE_SHIPPING_INFO = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/usable_shipping_address");
        SHIPPING_DETAILS = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/shipping_details");
        RETURN_POLICY = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/static_content/RETURN_POLICY");
        UPDATE_PICKUP_CONTACTS = new c(com.target.mothership.services.f.a.d.a.PUT, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/pickup_contacts");
        GET_PICKUP_CONTACTS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/pickup_contacts");
        APPLY_GIFT_CARD = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/tenders/gift_card");
        APPLY_PAYMENT_INSTRUCTION = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/tenders");
        GET_USABLE_TENDERS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/usable_tenders");
        GET_APPLIED_TENDERS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/applied_tenders");
        REMOVE_APPLIED_GC_TENDERS = new c(com.target.mothership.services.f.a.d.a.DELETE, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/tenders/{giftcard_payment_id}");
        REMOVE_APPLIED_TENDERS = new c(com.target.mothership.services.f.a.d.a.DELETE, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/tenders");
        UPDATE_APPLIED_TENDERS = new c(com.target.mothership.services.f.a.d.a.PUT, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/tenders");
        GET_ORDER_REVIEW = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/order_review?channel=apps");
        GET_ORDER_SUMMARY = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/order_review?responseGroup=orderSummary");
        UPDATE_CART = new c(com.target.mothership.services.f.a.d.a.PUT, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2");
        UPDATE_PROMO_CODE = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/promo_code");
        CHECKOUT = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/checkout?responseGroup=orderDetails");
        MOVE_SAVE_FOR_LATER_TO_CART = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/products?source=SaveForLaterList");
        MOVE_TO_SAVE_FOR_LATER_LIST = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/save_for_later");
        REMOVE_FROM_SAVE_FOR_LATER_LIST = new c(com.target.mothership.services.f.a.d.a.DELETE, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/save_for_later?order_line_id={order_line_id}");
        REMOVE_GET_SAVED_FOR_LATER_LIST = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/saved_for_later");
        APPLY_REWARD = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/rewards");
        FREE_SHIPPING_THRESHOLD = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.TWS, "/wcs/resources/store/10151/offer/globalpromotion");
        GET_PRODUCT_SHIPPING_METHODS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/products/{product_order_id}/shipping_methods");
        TWO_TAP_CHECKOUT = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/express_checkout?mode=twotap&channel=apps");
        PAYPAL_INITIATE = new c(com.target.mothership.services.f.a.d.a.PUT, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/paypal");
        PAYPAL_UPDATE = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/carts/v2/paypal");
    }
}
