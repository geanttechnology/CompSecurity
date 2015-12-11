// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.c;

import com.google.a.a.e;
import com.target.mothership.model.cart.interfaces.InitiatedCheckout;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.cart.interfaces.a.p;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.common.a.j;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.o;
import com.target.ui.helper.a;
import com.target.ui.service.b;
import java.util.List;

public class i extends com.target.ui.helper.a
{
    public static interface a
        extends com.target.ui.helper.b
    {

        public abstract void a(p p);

        public abstract void a(Object obj, OrderReview orderreview);

        public abstract void i();
    }


    private static final String LOG_TAG = com/target/ui/helper/c/i.getSimpleName();
    private static int PRIMARY_REASON_INDEX = 0;
    private b mCartDataService;
    private final InitiatedCheckout mInitiatedCheckout;
    private final List mProductList;
    private final String mRequestTag = String.valueOf(hashCode());

    public i(InitiatedCheckout initiatedcheckout, List list)
    {
        mCartDataService = com.target.ui.service.b.a();
        mInitiatedCheckout = initiatedcheckout;
        mProductList = list;
    }

    static String a(i j)
    {
        return j.mRequestTag;
    }

    static boolean a(i j, com.target.ui.helper.b b1, j j1, Guest guest, o o)
    {
        return j.a(b1, j1, guest, o);
    }

    static int b()
    {
        return PRIMARY_REASON_INDEX;
    }

    static boolean b(i j, com.target.ui.helper.b b1, j j1, Guest guest, o o)
    {
        return j.a(b1, j1, guest, o);
    }

    public void a()
    {
        mCartDataService.a(mRequestTag);
        mCartDataService = null;
    }

    public void a(final GuestAddress data, final a listener)
    {
        if (!com.target.ui.service.a.a().c().b())
        {
            return;
        } else
        {
            final Guest guest = (Guest)com.target.ui.service.a.a().c().c();
            listener = new d() {

                final i this$0;
                final GuestAddress val$data;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.c.i.a(i.this);
                }

                public void a(com.target.mothership.model.cart.interfaces.a.a a1)
                {
                    com.target.mothership.model.cart.interfaces.a.a.a a2 = (com.target.mothership.model.cart.interfaces.a.a.a)a1.f().get(com.target.ui.helper.c.i.b());
                    if (com.target.ui.helper.c.i.a(i.this, listener, (j)a1.f().get(com.target.ui.helper.c.i.b()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.i();
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((Void)obj);
                }

                public void a(Void void1)
                {
                    void1 = (Guest)com.target.ui.service.a.a().c().a(guest);
                    i.this.a(void1, data, listener);
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.cart.interfaces.a.a)obj);
                }

            
            {
                this$0 = i.this;
                guest = guest1;
                data = guestaddress;
                listener = a1;
                super();
            }
            };
            mCartDataService.a(guest, mInitiatedCheckout, data, mProductList, listener);
            return;
        }
    }

    public void a(final Guest guest, final Object address, final a listener)
    {
        address = new d() {

            final i this$0;
            final Object val$address;
            final Guest val$guest;
            final a val$listener;

            public String a()
            {
                return com.target.ui.helper.c.i.a(i.this);
            }

            public void a(OrderReview orderreview)
            {
                listener.a(address, orderreview);
            }

            public void a(p p1)
            {
                if (com.target.ui.helper.c.i.b(i.this, listener, (j)p1.f().get(com.target.ui.helper.c.i.b()), guest, (o)c().d()))
                {
                    return;
                } else
                {
                    listener.a(p1);
                    return;
                }
            }

            public volatile void a(Object obj)
            {
                a((OrderReview)obj);
            }

            public void b(Object obj)
            {
                a((p)obj);
            }

            
            {
                this$0 = i.this;
                listener = a1;
                address = obj;
                guest = guest1;
                super();
            }
        };
        mCartDataService.c(guest, mInitiatedCheckout, ((d) (address)));
    }

}
