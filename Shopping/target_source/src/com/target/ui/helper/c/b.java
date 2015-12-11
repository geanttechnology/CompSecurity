// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.c;

import com.google.a.a.e;
import com.target.mothership.model.common.a.j;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.h;
import com.target.mothership.services.o;
import com.target.mothership.services.x;
import com.target.ui.helper.a;
import com.target.ui.service.f;
import com.target.ui.util.q;
import java.util.List;

public class b extends com.target.ui.helper.a
{
    public static interface a
        extends com.target.ui.helper.b
    {

        public abstract void b(List list);

        public abstract void h();

        public abstract void j();

        public abstract void k();
    }


    private static final String LOG_TAG = com/target/ui/helper/c/b.getSimpleName();
    private static int PRIMARY_REASON_INDEX = 0;
    private f mGuestDataService;
    private final String mRequestTag = String.valueOf(hashCode());

    public b()
    {
        mGuestDataService = f.a();
    }

    static String a(b b1)
    {
        return b1.mRequestTag;
    }

    static boolean a(b b1, com.target.ui.helper.b b2, j j, Guest guest, o o)
    {
        return b1.a(b2, j, guest, o);
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
        mGuestDataService.a(mRequestTag);
    }

    public void a(Guest guest, final o requestRetryable, final a listener)
    {
        com.target.ui.service.a.a().a(guest, new h() {

            final b this$0;
            final a val$listener;
            final o val$requestRetryable;

            public String a()
            {
                return com.target.ui.helper.c.b.a(b.this);
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
                q.a(b.b(), (new StringBuilder()).append("Unable to refresh a new anonymous guest session:").append(x1).toString());
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
                this$0 = b.this;
                requestRetryable = o1;
                listener = a1;
                super();
            }
        });
    }

    public void a(final a shippingInfoListener)
    {
        if (!com.target.ui.service.a.a().c().b())
        {
            return;
        } else
        {
            final Guest guest = (Guest)com.target.ui.service.a.a().c().c();
            shippingInfoListener = new d() {

                final b this$0;
                final Guest val$guest;
                final a val$shippingInfoListener;

                public String a()
                {
                    return com.target.ui.helper.c.b.a(b.this);
                }

                public void a(com.target.mothership.model.guest.interfaces.a.j j1)
                {
                    j1 = (com.target.mothership.model.guest.interfaces.a.j.a)j1.f().get(b.c());
                    if (com.target.ui.helper.c.b.a(b.this, shippingInfoListener, j1, guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        shippingInfoListener.j();
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((List)obj);
                }

                public void a(List list)
                {
                    if (list.isEmpty())
                    {
                        q.a(b.b(), "Usable shipping address list is empty");
                        shippingInfoListener.h();
                        return;
                    } else
                    {
                        shippingInfoListener.b(list);
                        return;
                    }
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.guest.interfaces.a.j)obj);
                }

            
            {
                this$0 = b.this;
                shippingInfoListener = a1;
                guest = guest1;
                super();
            }
            };
            mGuestDataService.a(guest, shippingInfoListener);
            return;
        }
    }

}
