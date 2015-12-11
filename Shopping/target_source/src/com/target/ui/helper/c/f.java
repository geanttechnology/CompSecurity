// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.c;

import com.google.a.a.e;
import com.target.mothership.model.cart.interfaces.CartUsableShippingInfo;
import com.target.mothership.model.cart.interfaces.InitiatedCheckout;
import com.target.mothership.model.cart.interfaces.a.m;
import com.target.mothership.model.common.a.j;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.h;
import com.target.mothership.services.o;
import com.target.mothership.services.x;
import com.target.ui.helper.a;
import com.target.ui.service.b;
import com.target.ui.util.q;
import java.util.List;

public class f extends com.target.ui.helper.a
{
    public static interface a
        extends com.target.ui.helper.b
    {

        public abstract void b(List list);

        public abstract void h();

        public abstract void j();

        public abstract void k();
    }


    private static final String LOG_TAG = com/target/ui/helper/c/f.getSimpleName();
    private static int PRIMARY_REASON_INDEX = 0;
    private b mCartDataService;
    private com.target.ui.service.f mGuestDataService;
    private InitiatedCheckout mInitiatedCheckout;
    private final String mRequestTag = String.valueOf(hashCode());

    public f(InitiatedCheckout initiatedcheckout)
    {
        mCartDataService = com.target.ui.service.b.a();
        mGuestDataService = com.target.ui.service.f.a();
        mInitiatedCheckout = initiatedcheckout;
    }

    static String a(f f1)
    {
        return f1.mRequestTag;
    }

    static boolean a(f f1, com.target.ui.helper.b b1, j j, Guest guest, o o)
    {
        return f1.a(b1, j, guest, o);
    }

    static String b()
    {
        return LOG_TAG;
    }

    static int c()
    {
        return PRIMARY_REASON_INDEX;
    }

    public void a()
    {
        mCartDataService.a(mRequestTag);
        mGuestDataService.a(mRequestTag);
    }

    public void a(Guest guest, final o requestRetryable, final a listener)
    {
        com.target.ui.service.a.a().a(guest, new h() {

            final f this$0;
            final a val$listener;
            final o val$requestRetryable;

            public String a()
            {
                return com.target.ui.helper.c.f.a(f.this);
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
                q.a(com.target.ui.helper.c.f.b(), (new StringBuilder()).append("Unable to refresh a new anonymous guest session:").append(x1).toString());
                listener.k();
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
                this$0 = f.this;
                requestRetryable = o1;
                listener = a1;
                super();
            }
        });
    }

    public void a(final a listener)
    {
        final Guest guest;
        if (com.target.ui.service.a.a().c().b())
        {
            if ((guest = (Guest)com.target.ui.service.a.a().c().c()) != null)
            {
                listener = new d() {

                    final f this$0;
                    final Guest val$guest;
                    final a val$listener;

                    public String a()
                    {
                        return com.target.ui.helper.c.f.a(f.this);
                    }

                    public void a(CartUsableShippingInfo cartusableshippinginfo)
                    {
                        if (cartusableshippinginfo.a().isEmpty())
                        {
                            q.a(com.target.ui.helper.c.f.b(), "Usable shipping address list is empty");
                            listener.h();
                            return;
                        } else
                        {
                            listener.b(cartusableshippinginfo.a());
                            return;
                        }
                    }

                    public void a(m m1)
                    {
                        m1 = (com.target.mothership.model.cart.interfaces.a.m.a)m1.f().get(f.c());
                        if (com.target.ui.helper.c.f.a(f.this, listener, m1, guest, (o)c().d()))
                        {
                            return;
                        } else
                        {
                            listener.j();
                            return;
                        }
                    }

                    public volatile void a(Object obj)
                    {
                        a((CartUsableShippingInfo)obj);
                    }

                    public void b(Object obj)
                    {
                        a((m)obj);
                    }

            
            {
                this$0 = f.this;
                listener = a1;
                guest = guest1;
                super();
            }
                };
                mCartDataService.a(guest, mInitiatedCheckout, listener);
                return;
            }
        }
    }

}
