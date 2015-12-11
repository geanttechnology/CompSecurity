// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.b;

import com.google.a.a.e;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.CartProductShippingModeDetails;
import com.target.mothership.model.cart.interfaces.a.k;
import com.target.mothership.model.common.a.j;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.h;
import com.target.mothership.services.o;
import com.target.mothership.services.x;
import com.target.ui.helper.a;
import com.target.ui.service.b;
import java.util.List;

public class c extends com.target.ui.helper.a
{
    public static interface a
        extends com.target.ui.helper.b
    {

        public abstract void a();

        public abstract void a(CartProductShippingModeDetails cartproductshippingmodedetails);

        public abstract void a(k k);

        public abstract void b();
    }


    private static int PRIMARY_REASON_INDEX = 0;
    private com.target.ui.service.a mAccountService;
    private b mCartDataService;
    private final String mRequestTag = String.valueOf(hashCode());

    public c()
    {
        mCartDataService = com.target.ui.service.b.a();
        mAccountService = com.target.ui.service.a.a();
    }

    static String a(c c1)
    {
        return c1.mRequestTag;
    }

    static boolean a(c c1, com.target.ui.helper.b b1, j j, Guest guest, o o)
    {
        return c1.a(b1, j, guest, o);
    }

    static int b()
    {
        return PRIMARY_REASON_INDEX;
    }

    public void a()
    {
        mAccountService.a(mRequestTag);
        mCartDataService.a(mRequestTag);
    }

    public void a(final Guest guest, CartProduct cartproduct, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.a();
            return;
        } else
        {
            listener = new d() {

                final c this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.b.c.a(c.this);
                }

                public void a(CartProductShippingModeDetails cartproductshippingmodedetails)
                {
                    listener.a(cartproductshippingmodedetails);
                }

                public void a(k k1)
                {
                    if (com.target.ui.helper.b.c.a(c.this, listener, (j)k1.f().get(com.target.ui.helper.b.c.b()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(k1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((CartProductShippingModeDetails)obj);
                }

                public void b(Object obj)
                {
                    a((k)obj);
                }

            
            {
                this$0 = c.this;
                listener = a1;
                guest = guest1;
                super();
            }
            };
            mCartDataService.c(guest, cartproduct, listener);
            return;
        }
    }

    public void a(Guest guest, final o requestRetryable, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            return;
        } else
        {
            com.target.ui.service.a.a().a(guest, new h() {

                final c this$0;
                final a val$listener;
                final o val$requestRetryable;

                public String a()
                {
                    return com.target.ui.helper.b.c.a(c.this);
                }

                public void a(Guest guest1)
                {
                    requestRetryable.a(guest1);
                    requestRetryable.a();
                }

                public void a(x x1)
                {
                    listener.b();
                }

                public volatile void a(Object obj)
                {
                    a((Guest)obj);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = c.this;
                requestRetryable = o1;
                listener = a1;
                super();
            }
            });
            return;
        }
    }

}
