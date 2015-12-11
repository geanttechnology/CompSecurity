// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.c;

import com.target.mothership.common.params.AddressParams;
import com.target.mothership.model.c.c;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.common.a.j;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.a.l;
import com.target.mothership.model.h;
import com.target.mothership.services.o;
import com.target.mothership.services.x;
import com.target.ui.helper.a;
import com.target.ui.service.b;
import com.target.ui.service.f;
import com.target.ui.util.q;
import java.util.List;

public class e extends com.target.ui.helper.a
{
    public static interface a
        extends com.target.ui.helper.b
    {

        public abstract void a(com.target.mothership.model.c.c.a.a a1);

        public abstract void a(com.target.mothership.model.c.c.a a1);

        public abstract void a(com.target.mothership.model.cart.interfaces.a.a a1);

        public abstract void a(com.target.mothership.model.guest.interfaces.a.f f1);

        public abstract void a(l l);

        public abstract void b(Guest guest);

        public abstract void b(Guest guest, com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1);

        public abstract void d(com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1);

        public abstract void j();
    }


    private static int PRIMARY_FAILURE_REASON_INDEX = 0;
    private static final String TAG = com/target/ui/helper/c/e.getSimpleName();
    private b mCartDataService;
    private f mGuestDataService;
    private c mLocationManager;
    private OrderReview mOrderReview;
    private List mProductList;
    private final String mRequestTag = String.valueOf(hashCode());

    public e(List list, OrderReview orderreview)
    {
        mProductList = list;
        mOrderReview = orderreview;
        mLocationManager = new c();
        mGuestDataService = f.a();
        mCartDataService = com.target.ui.service.b.a();
    }

    static String a(e e1)
    {
        return e1.mRequestTag;
    }

    static boolean a(e e1, com.target.ui.helper.b b1, j j, Guest guest, o o)
    {
        return e1.a(b1, j, guest, o);
    }

    static boolean b(e e1, com.target.ui.helper.b b1, j j, Guest guest, o o)
    {
        return e1.a(b1, j, guest, o);
    }

    static int c()
    {
        return PRIMARY_FAILURE_REASON_INDEX;
    }

    static boolean c(e e1, com.target.ui.helper.b b1, j j, Guest guest, o o)
    {
        return e1.a(b1, j, guest, o);
    }

    static String d()
    {
        return TAG;
    }

    public void a()
    {
        mCartDataService.a(mRequestTag);
        mGuestDataService.a(mRequestTag);
        mLocationManager.a(mRequestTag);
        mCartDataService = null;
        mGuestDataService = null;
        mLocationManager = null;
    }

    public void a(final Guest guest, AddressParams addressparams, final com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a addressDetailsHolder, final a listener)
    {
        if (guest == null)
        {
            q.a(TAG, "tried to add a new address but the given guest session was null");
            return;
        } else
        {
            addressDetailsHolder = new d() {

                final e this$0;
                final com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a val$addressDetailsHolder;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.c.e.a(e.this);
                }

                public void a(com.target.mothership.model.cart.interfaces.a.a a1)
                {
                    if (com.target.ui.helper.c.e.b(e.this, listener, (j)a1.f().get(com.target.ui.helper.c.e.c()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(a1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((Void)obj);
                }

                public void a(Void void1)
                {
                    listener.b(guest, addressDetailsHolder);
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.cart.interfaces.a.a)obj);
                }

            
            {
                this$0 = e.this;
                listener = a1;
                guest = guest1;
                addressDetailsHolder = a2;
                super();
            }
            };
            mCartDataService.a(guest, mOrderReview, addressparams, mProductList, true, addressDetailsHolder);
            return;
        }
    }

    public void a(final Guest guest, GuestAddress guestaddress, AddressParams addressparams, final com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a addressDetailsHolder, final a listener)
    {
        if (guest == null)
        {
            q.a(TAG, "tried to edit an address but the given guest session was null");
            return;
        } else
        {
            addressDetailsHolder = new d() {

                final e this$0;
                final com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a val$addressDetailsHolder;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.c.e.a(e.this);
                }

                public void a(l l1)
                {
                    if (com.target.ui.helper.c.e.c(e.this, listener, (j)l1.f().get(com.target.ui.helper.c.e.c()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(l1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((String)obj);
                }

                public void a(String s)
                {
                    listener.d(addressDetailsHolder);
                }

                public void b(Object obj)
                {
                    a((l)obj);
                }

            
            {
                this$0 = e.this;
                listener = a1;
                addressDetailsHolder = a2;
                guest = guest1;
                super();
            }
            };
            mGuestDataService.a(guest, guestaddress, addressparams, true, addressDetailsHolder);
            return;
        }
    }

    public void a(final Guest guest, GuestAddress guestaddress, final a listener)
    {
        if (guest == null)
        {
            q.a(TAG, "tried to delete an address but the given guest session was null");
            return;
        } else
        {
            listener = new d() {

                final e this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.c.e.a(e.this);
                }

                public void a(com.target.mothership.model.guest.interfaces.a.f f1)
                {
                    com.target.mothership.model.guest.interfaces.a.f.a a1 = (com.target.mothership.model.guest.interfaces.a.f.a)f1.f().get(com.target.ui.helper.c.e.c());
                    if (com.target.ui.helper.c.e.a(e.this, listener, a1, guest, (o)c().d()))
                    {
                        return;
                    }
                    if (a1 == com.target.mothership.model.guest.interfaces.a.f.a.ERR_INVALID_ADDRESS_ID)
                    {
                        listener.b(guest);
                        return;
                    } else
                    {
                        listener.a(f1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((String)obj);
                }

                public void a(String s)
                {
                    listener.b(guest);
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.guest.interfaces.a.f)obj);
                }

            
            {
                this$0 = e.this;
                listener = a1;
                guest = guest1;
                super();
            }
            };
            mGuestDataService.a(guest, guestaddress, listener);
            return;
        }
    }

    public void a(Guest guest, final o requestRetryable, final a listener)
    {
        com.target.ui.service.a.a().a(guest, new h() {

            final e this$0;
            final a val$listener;
            final o val$requestRetryable;

            public String a()
            {
                return com.target.ui.helper.c.e.a(e.this);
            }

            public void a(Guest guest1)
            {
                requestRetryable.a(guest1);
                requestRetryable.a();
            }

            public void a(x x1)
            {
                if (x1 != null)
                {
                    x1 = x1.getMessage();
                } else
                {
                    x1 = "";
                }
                q.a(com.target.ui.helper.c.e.d(), (new StringBuilder()).append("Unable to refresh a new anonymous guest session:").append(x1).toString());
                listener.j();
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
                this$0 = e.this;
                requestRetryable = o1;
                listener = a1;
                super();
            }
        });
    }

    public void a(String s, final a listener)
    {
        listener = new d() {

            final e this$0;
            final a val$listener;

            public void a(com.target.mothership.model.c.c.a.a a1)
            {
                listener.a(a1);
            }

            public void a(com.target.mothership.model.c.c.a a1)
            {
                listener.a(a1);
            }

            public volatile void a(Object obj)
            {
                a((com.target.mothership.model.c.c.a)obj);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.c.c.a.a)obj);
            }

            
            {
                this$0 = e.this;
                listener = a1;
                super();
            }
        };
        mLocationManager.a(s, listener);
    }

    public List b()
    {
        return mProductList;
    }

}
