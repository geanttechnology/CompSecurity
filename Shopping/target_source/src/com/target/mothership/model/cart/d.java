// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart;

import com.target.mothership.common.params.AddressParams;
import com.target.mothership.common.params.b;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.tender.PaymentTender;
import com.target.mothership.common.tender.a;
import com.target.mothership.model.c;
import com.target.mothership.model.cart.b.g;
import com.target.mothership.model.cart.b.i;
import com.target.mothership.model.cart.b.l;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.GiftProduct;
import com.target.mothership.model.cart.interfaces.InitiatedCheckout;
import com.target.mothership.model.cart.interfaces.InitiatedPayPal;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.cart.interfaces.PromoCode;
import com.target.mothership.model.cart.interfaces.SaveForLaterProduct;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.util.h;
import java.math.BigDecimal;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart:
//            a, b

class d extends c
    implements com.target.mothership.model.cart.a
{

    private com.target.mothership.model.cart.b mCartLiveDataSource;

    public d()
    {
        mCartLiveDataSource = new com.target.mothership.model.cart.b();
    }

    public void a(Guest guest, PaymentTender paymenttender, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_apply_payment_instruction.json");
            mCartLiveDataSource.a(guest, paymenttender, d1);
            return;
        } else
        {
            d1.a(null);
            return;
        }
    }

    public void a(Guest guest, a a1, PaymentTender paymenttender, String s, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_apply_payment_instruction.json");
            mCartLiveDataSource.a(guest, a1, paymenttender, s, d1);
            return;
        } else
        {
            d1.a(null);
            return;
        }
    }

    public void a(Guest guest, com.target.mothership.model.cart.b.a a1, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_invalid_input_add_to_cart.json");
        } else
        {
            a("add_item_to_cart.json");
        }
        mCartLiveDataSource.a(guest, a1, d1);
    }

    public void a(Guest guest, l l, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_add_new_shipping_address.json");
            mCartLiveDataSource.a(guest, l, d1);
            return;
        } else
        {
            d1.a(null);
            return;
        }
    }

    public void a(Guest guest, CartProduct cartproduct, int i, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_update_product.json");
        } else
        {
            a("update_cart_product_from_cart.json");
        }
        mCartLiveDataSource.a(guest, cartproduct, i, d1);
    }

    public void a(Guest guest, CartProduct cartproduct, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_remove_product.json");
        } else
        {
            a("remove_product_from_cart.json");
        }
        mCartLiveDataSource.a(guest, cartproduct, d1);
    }

    public void a(Guest guest, CartProduct cartproduct, com.target.mothership.services.apigee.c.a.h h1, StoreIdentifier storeidentifier, boolean flag, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_update_fulfillment_method.json");
        } else
        {
            a("model_update_fulfillment_method.json");
        }
        mCartLiveDataSource.a(guest, cartproduct, h1, storeidentifier, flag, d1);
    }

    public void a(Guest guest, GiftProduct giftproduct, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_apply_reward.json");
            mCartLiveDataSource.a(guest, giftproduct, d1);
            return;
        } else
        {
            d1.a(null);
            return;
        }
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, b b1, String s, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_apply_payment_instruction.json");
            mCartLiveDataSource.a(guest, initiatedcheckout, b1, s, d1);
            return;
        } else
        {
            d1.a(null);
            return;
        }
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, a a1, String s, AddressParams addressparams, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_apply_payment_instruction.json");
            mCartLiveDataSource.a(guest, initiatedcheckout, a1, s, addressparams, d1);
            return;
        } else
        {
            d1.a(null);
            return;
        }
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, a a1, String s, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_checkout_with_cvv.json");
        } else
        {
            a("checkout_order_details.json");
        }
        mCartLiveDataSource.a(guest, initiatedcheckout, a1, s, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.model.cart.b.b b1, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_add_new_shipping_address.json");
            mCartLiveDataSource.a(guest, initiatedcheckout, b1, d1);
            return;
        } else
        {
            d1.a(null);
            return;
        }
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.model.cart.b.d d1, com.target.mothership.model.d d2)
    {
        if (a())
        {
            a("error_cart_invalid_pattern_giftcard_access.json");
        } else
        {
            a("apply_gift_card_response.json");
        }
        mCartLiveDataSource.a(guest, initiatedcheckout, d1, d2);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, g g1, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_update_self_pickup_error.json");
            mCartLiveDataSource.a(guest, initiatedcheckout, g1, d1);
            return;
        } else
        {
            d1.a(null);
            return;
        }
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, i i, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_add_new_shipping_address.json");
            mCartLiveDataSource.a(guest, initiatedcheckout, i, d1);
            return;
        } else
        {
            d1.a(null);
            return;
        }
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_auth_invalid_cookie.json");
        } else
        {
            a("get_cart_usable_shipping_info.json");
        }
        mCartLiveDataSource.a(guest, initiatedcheckout, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, String s, a a1, String s1, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_checkout_with_cvv.json");
        } else
        {
            a("checkout_order_details.json");
        }
        mCartLiveDataSource.a(guest, initiatedcheckout, s, a1, s1, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, String s, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_apply_team_member_discount.json");
        } else
        {
            a("apply_team_member_discount.json");
        }
        mCartLiveDataSource.a(guest, initiatedcheckout, s, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, String s, boolean flag, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_apply_promo_code.json");
        } else
        {
            a("apply_promo_code.json");
        }
        mCartLiveDataSource.a(guest, initiatedcheckout, s, flag, d1);
    }

    public void a(Guest guest, InitiatedPayPal initiatedpaypal, OrderReview orderreview, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("checkout_error_update_paypal.json");
            mCartLiveDataSource.a(guest, initiatedpaypal, orderreview, d1);
            return;
        } else
        {
            d1.a(null);
            return;
        }
    }

    public void a(Guest guest, OrderReview orderreview, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("checkout_error_paypal_initiate.json");
        } else
        {
            a("checkout_paypal_initiate.json");
        }
        mCartLiveDataSource.a(guest, orderreview, d1);
    }

    public void a(Guest guest, PromoCode promocode, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_remove_promo_code.json");
        } else
        {
            a("remove_promo_code.json");
        }
        mCartLiveDataSource.a(guest, promocode, d1);
    }

    public void a(Guest guest, SaveForLaterProduct saveforlaterproduct, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_invalid_input_add_to_cart.json");
        } else
        {
            a("add_item_to_cart.json");
        }
        mCartLiveDataSource.a(guest, saveforlaterproduct, d1);
    }

    public void a(Guest guest, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_empty.json");
        } else
        {
            a("model_cart_price_summary.json");
        }
        mCartLiveDataSource.a(guest, d1);
    }

    public void a(Guest guest, String s, BigDecimal bigdecimal, List list, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_remove_applied_payment_tenders.json");
            mCartLiveDataSource.a(guest, s, bigdecimal, list, d1);
            return;
        } else
        {
            d1.a(null);
            return;
        }
    }

    public void a(com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("free_shipping_threshold.json");
            mCartLiveDataSource.a(h1);
            return;
        }
    }

    public void b(Guest guest, com.target.mothership.model.cart.b.a a1, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_invalid_input_add_to_cart.json");
        } else
        {
            a("two_tap_express_checkout.json");
        }
        mCartLiveDataSource.b(guest, a1, d1);
    }

    public void b(Guest guest, CartProduct cartproduct, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_empty.json");
        } else
        {
            a("get_cart_orderItem_eligible_shipping_methods.json");
        }
        mCartLiveDataSource.b(guest, cartproduct, d1);
    }

    public void b(Guest guest, InitiatedCheckout initiatedcheckout, g g1, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_update_alt_pickup_error.json");
            mCartLiveDataSource.b(guest, initiatedcheckout, g1, d1);
            return;
        } else
        {
            d1.a(null);
            return;
        }
    }

    public void b(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_get_usable_tenders.json");
        } else
        {
            a("get_cart_usable_tenders.json");
        }
        mCartLiveDataSource.b(guest, initiatedcheckout, d1);
    }

    public void b(Guest guest, InitiatedCheckout initiatedcheckout, String s, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_checkout_with_track_email.json");
        } else
        {
            a("checkout_order_details.json");
        }
        mCartLiveDataSource.b(guest, initiatedcheckout, s, d1);
    }

    public void b(Guest guest, SaveForLaterProduct saveforlaterproduct, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_remove_from_saveforlater.json");
            mCartLiveDataSource.b(guest, saveforlaterproduct, d1);
            return;
        } else
        {
            d1.a(null);
            return;
        }
    }

    public void b(Guest guest, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_empty.json");
        } else
        {
            a("model_cart_details.json");
        }
        mCartLiveDataSource.b(guest, d1);
    }

    public void c(Guest guest, CartProduct cartproduct, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_move_to_saveforlater.json");
            mCartLiveDataSource.c(guest, cartproduct, d1);
            return;
        } else
        {
            d1.a(null);
            return;
        }
    }

    public void c(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_auth_scope_1_access_required.json");
            return;
        } else
        {
            a("get_cart_applied_tenders.json");
            mCartLiveDataSource.c(guest, initiatedcheckout, d1);
            return;
        }
    }

    public void c(Guest guest, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_initiate_checkout.json");
        } else
        {
            a("initiate_express_checkout.json");
        }
        mCartLiveDataSource.c(guest, d1);
    }

    public void d(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_remove_applied_payment_tenders.json");
            mCartLiveDataSource.d(guest, initiatedcheckout, d1);
            return;
        } else
        {
            d1.a(null);
            return;
        }
    }

    public void d(Guest guest, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_get_saveforlater_list.json");
        } else
        {
            a("saved_for_later_list.json");
        }
        mCartLiveDataSource.d(guest, d1);
    }

    public void e(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_remove_applied_team_member_discount.json");
            mCartLiveDataSource.e(guest, initiatedcheckout, d1);
            return;
        } else
        {
            d1.a(null);
            return;
        }
    }

    public void f(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_empty.json");
        } else
        {
            a("get_cart_for_order_review.json");
        }
        mCartLiveDataSource.f(guest, initiatedcheckout, d1);
    }

    public void g(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_cart_checkout.json");
        } else
        {
            a("checkout_order_details.json");
        }
        mCartLiveDataSource.(guest, initiatedcheckout, d1);
    }
}
