// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.c;

import com.target.mothership.common.params.AddressParams;
import com.target.mothership.model.c.c;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.common.a.j;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.a.e;
import com.target.mothership.model.guest.interfaces.a.l;
import com.target.mothership.model.h;
import com.target.mothership.services.o;
import com.target.mothership.services.x;
import com.target.ui.helper.b;
import com.target.ui.service.f;
import com.target.ui.util.q;
import java.util.List;

public class com.target.ui.helper.c.a extends com.target.ui.helper.a
{
    public static interface a
        extends b
    {

        public abstract void a(com.target.mothership.model.c.c.a.a a1);

        public abstract void a(com.target.mothership.model.c.c.a a1);

        public abstract void a(e e);

        public abstract void a(com.target.mothership.model.guest.interfaces.a.f f1);

        public abstract void a(l l);

        public abstract void b(Guest guest);

        public abstract void b(Guest guest, com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1);

        public abstract void d(com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a a1);

        public abstract void i();
    }


    private static int PRIMARY_FAILURE_REASON_INDEX = 0;
    private static final String TAG = com/target/ui/helper/c/a.getSimpleName();
    private f mGuestDataService;
    private c mLocationManager;
    private final String mRequestTag = String.valueOf(hashCode());

    public com.target.ui.helper.c.a()
    {
        mGuestDataService = f.a();
        mLocationManager = new c();
    }

    static String a(com.target.ui.helper.c.a a1)
    {
        return a1.mRequestTag;
    }

    static boolean a(com.target.ui.helper.c.a a1, b b1, j j, Guest guest, o o)
    {
        return a1.a(b1, j, guest, o);
    }

    static int b()
    {
        return PRIMARY_FAILURE_REASON_INDEX;
    }

    static boolean b(com.target.ui.helper.c.a a1, b b1, j j, Guest guest, o o)
    {
        return a1.a(b1, j, guest, o);
    }

    static String c()
    {
        return TAG;
    }

    static boolean c(com.target.ui.helper.c.a a1, b b1, j j, Guest guest, o o)
    {
        return a1.a(b1, j, guest, o);
    }

    public void a()
    {
        mLocationManager.a(mRequestTag);
        mGuestDataService.a(mRequestTag);
    }

    public void a(final Guest guest, AddressParams addressparams, final com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a addressDetailsHolder, final a listener)
    {
        if (guest == null)
        {
            q.a(TAG, "tried to add a new address but guest session was unexpectedly null");
            return;
        } else
        {
            addressDetailsHolder = new d() {

                final com.target.ui.helper.c.a this$0;
                final com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a val$addressDetailsHolder;
                final Guest val$guest;
                final a val$listener;

                public void a(e e1)
                {
                    if (com.target.ui.helper.c.a.b(com.target.ui.helper.c.a.this, listener, (j)e1.f().get(com.target.ui.helper.c.a.b()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(e1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((String)obj);
                }

                public void a(String s)
                {
                    listener.b(guest, addressDetailsHolder);
                }

                public void b(Object obj)
                {
                    a((e)obj);
                }

            
            {
                this$0 = com.target.ui.helper.c.a.this;
                listener = a2;
                guest = guest1;
                addressDetailsHolder = a3;
                super();
            }
            };
            mGuestDataService.a(guest, addressparams, addressDetailsHolder);
            return;
        }
    }

    public void a(final Guest guest, GuestAddress guestaddress, AddressParams addressparams, final com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a addressDetailsHolder, final a listener)
    {
        if (guest == null)
        {
            q.a(TAG, "tried to edit an address but guest session was unexpectedly null");
            return;
        } else
        {
            addressDetailsHolder = new d() {

                final com.target.ui.helper.c.a this$0;
                final com.target.ui.fragment.shipping.ShippingAddressDetailsFragment.a val$addressDetailsHolder;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.c.a.a(com.target.ui.helper.c.a.this);
                }

                public void a(l l1)
                {
                    if (com.target.ui.helper.c.a.c(com.target.ui.helper.c.a.this, listener, (j)l1.f().get(com.target.ui.helper.c.a.b()), guest, (o)c().d()))
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
                this$0 = com.target.ui.helper.c.a.this;
                listener = a2;
                addressDetailsHolder = a3;
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
            q.a(TAG, "tried to delete address, but guest session was unexpectedly null");
            return;
        } else
        {
            listener = new d() {

                final com.target.ui.helper.c.a this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.c.a.a(com.target.ui.helper.c.a.this);
                }

                public void a(com.target.mothership.model.guest.interfaces.a.f f1)
                {
                    com.target.mothership.model.guest.interfaces.a.f.a a1 = (com.target.mothership.model.guest.interfaces.a.f.a)f1.f().get(com.target.ui.helper.c.a.b());
                    if (com.target.ui.helper.c.a.a(com.target.ui.helper.c.a.this, listener, a1, guest, (o)c().d()))
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
                this$0 = com.target.ui.helper.c.a.this;
                listener = a2;
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

            final com.target.ui.helper.c.a this$0;
            final a val$listener;
            final o val$requestRetryable;

            public String a()
            {
                return com.target.ui.helper.c.a.a(com.target.ui.helper.c.a.this);
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
                q.a(com.target.ui.helper.c.a.c(), (new StringBuilder()).append("Unable to refresh a new anonymous guest session:").append(x1).toString());
                listener.i();
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
                this$0 = com.target.ui.helper.c.a.this;
                requestRetryable = o1;
                listener = a2;
                super();
            }
        });
    }

    public void a(String s, final a listener)
    {
        listener = new d() {

            final com.target.ui.helper.c.a this$0;
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
                this$0 = com.target.ui.helper.c.a.this;
                listener = a2;
                super();
            }
        };
        mLocationManager.a(s, listener);
    }

}
