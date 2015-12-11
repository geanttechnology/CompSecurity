// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.a;

import com.google.a.a.e;
import com.target.mothership.common.params.AddressParams;
import com.target.mothership.common.tender.PaymentTender;
import com.target.mothership.model.c.c;
import com.target.mothership.model.cart.b.d;
import com.target.mothership.model.common.a.j;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.OrderDetails;
import com.target.mothership.model.guest.interfaces.OrderSummary;
import com.target.mothership.model.guest.interfaces.a.k;
import com.target.mothership.model.guest.interfaces.a.m;
import com.target.mothership.services.x;
import com.target.mothership.util.b;
import com.target.mothership.util.o;
import com.target.ui.analytics.a.p;
import com.target.ui.service.f;
import com.target.ui.util.q;
import java.util.List;

public class com.target.ui.helper.a.a extends com.target.ui.helper.a
{
    public static interface a
        extends com.target.ui.helper.c
    {

        public abstract void e();
    }

    public static interface b
        extends c
    {

        public abstract void a();

        public abstract void a(com.target.mothership.model.guest.interfaces.a.d d1);
    }

    public static interface c
        extends com.target.ui.helper.b
    {

        public abstract void o_();
    }

    public static interface d
        extends a
    {

        public abstract void a(PaymentTender paymenttender);

        public abstract void a(com.target.mothership.model.guest.interfaces.a.a a1);

        public abstract void a(com.target.mothership.model.guest.interfaces.a.g g1);

        public abstract void a(List list);
    }

    public static interface e
        extends c
    {

        public abstract void a();

        public abstract void a(com.target.mothership.model.guest.interfaces.a.c c1);
    }

    public static interface f
        extends c
    {

        public abstract void a();

        public abstract void d();
    }

    public static interface g
        extends c
    {

        public abstract void a(OrderDetails orderdetails);

        public abstract void a(com.target.mothership.model.guest.interfaces.a.h h1);
    }

    public static interface h
        extends c
    {

        public abstract void a();

        public abstract void a(PaymentTender paymenttender);

        public abstract void a(com.target.mothership.model.guest.interfaces.a.b b1);

        public abstract void a(k k);

        public abstract void a(m m);

        public abstract void b(PaymentTender paymenttender);
    }

    public static interface i
        extends c
    {

        public abstract void a(com.target.mothership.model.guest.interfaces.a.g g1);

        public abstract void c(List list);
    }

    public static interface j
    {

        public abstract void a(com.target.mothership.model.c.c.a.a a1);

        public abstract void a(com.target.mothership.model.c.c.a a1);
    }


    private static int PRIMARY_REASON_INDEX = 0;
    private static final String TAG = com/target/ui/helper/a/a.getSimpleName();
    private final String mRequestTag = String.valueOf(hashCode());

    public com.target.ui.helper.a.a()
    {
    }

    static String a(com.target.ui.helper.a.a a1)
    {
        return a1.mRequestTag;
    }

    static boolean a(com.target.ui.helper.a.a a1, int k, com.target.ui.helper.c c1, com.target.mothership.model.common.a.j j1, Guest guest, com.target.mothership.services.o o1)
    {
        return a1.a(k, c1, j1, guest, o1);
    }

    static boolean a(com.target.ui.helper.a.a a1, com.target.mothership.model.common.a.j j1)
    {
        return a1.b(j1);
    }

    static boolean a(com.target.ui.helper.a.a a1, com.target.ui.helper.b b1, com.target.mothership.model.common.a.j j1, Guest guest, com.target.mothership.services.o o1)
    {
        return a1.a(b1, j1, guest, o1);
    }

    static boolean b(com.target.ui.helper.a.a a1, int k, com.target.ui.helper.c c1, com.target.mothership.model.common.a.j j1, Guest guest, com.target.mothership.services.o o1)
    {
        return a1.a(k, c1, j1, guest, o1);
    }

    static boolean b(com.target.ui.helper.a.a a1, com.target.mothership.model.common.a.j j1)
    {
        return a1.b(j1);
    }

    static boolean b(com.target.ui.helper.a.a a1, com.target.ui.helper.b b1, com.target.mothership.model.common.a.j j1, Guest guest, com.target.mothership.services.o o1)
    {
        return a1.a(b1, j1, guest, o1);
    }

    static int c()
    {
        return PRIMARY_REASON_INDEX;
    }

    static boolean c(com.target.ui.helper.a.a a1, com.target.ui.helper.b b1, com.target.mothership.model.common.a.j j1, Guest guest, com.target.mothership.services.o o1)
    {
        return a1.a(b1, j1, guest, o1);
    }

    static boolean d(com.target.ui.helper.a.a a1, com.target.ui.helper.b b1, com.target.mothership.model.common.a.j j1, Guest guest, com.target.mothership.services.o o1)
    {
        return a1.a(b1, j1, guest, o1);
    }

    static boolean e(com.target.ui.helper.a.a a1, com.target.ui.helper.b b1, com.target.mothership.model.common.a.j j1, Guest guest, com.target.mothership.services.o o1)
    {
        return a1.a(b1, j1, guest, o1);
    }

    public void a()
    {
        q.c(TAG, "AccountDataHelper : Cancel Requested");
        com.target.ui.service.a.a().a(mRequestTag);
    }

    public void a(final Guest guest, com.target.mothership.common.params.b b1, final h listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.o_();
            return;
        } else
        {
            com.target.ui.service.f.a().a(guest, b1, new com.target.mothership.model.d() {

                final com.target.ui.helper.a.a this$0;
                final Guest val$guest;
                final h val$listener;

                public String a()
                {
                    return super.a();
                }

                public void a(PaymentTender paymenttender)
                {
                    listener.b(paymenttender);
                }

                public void a(com.target.mothership.model.guest.interfaces.a.b b2)
                {
                    if (com.target.ui.helper.a.a.d(com.target.ui.helper.a.a.this, listener, (com.target.mothership.model.common.a.j)b2.f().get(com.target.ui.helper.a.a.c()), guest, (com.target.mothership.services.o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(b2);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((PaymentTender)obj);
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.guest.interfaces.a.b)obj);
                }

            
            {
                this$0 = com.target.ui.helper.a.a.this;
                listener = h1;
                guest = guest1;
                super();
            }
            });
            return;
        }
    }

    public void a(final Guest guest, PaymentTender paymenttender, final h listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.o_();
            return;
        } else
        {
            com.target.ui.service.f.a().a(guest, paymenttender, new com.target.mothership.model.d() {

                final com.target.ui.helper.a.a this$0;
                final Guest val$guest;
                final h val$listener;

                public String a()
                {
                    return super.a();
                }

                public void a(k k1)
                {
                    if (com.target.ui.helper.a.a.c(com.target.ui.helper.a.a.this, listener, (com.target.mothership.model.common.a.j)k1.f().get(com.target.ui.helper.a.a.c()), guest, (com.target.mothership.services.o)c().d()))
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
                    a((Void)obj);
                }

                public void a(Void void1)
                {
                    listener.a();
                }

                public void b(Object obj)
                {
                    a((k)obj);
                }

            
            {
                this$0 = com.target.ui.helper.a.a.this;
                listener = h1;
                guest = guest1;
                super();
            }
            });
            return;
        }
    }

    public void a(final Guest guest, PaymentTender paymenttender, boolean flag, AddressParams addressparams, final h listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.o_();
            return;
        } else
        {
            com.target.ui.service.f.a().a(guest, paymenttender, flag, addressparams, new com.target.mothership.model.d() {

                final com.target.ui.helper.a.a this$0;
                final Guest val$guest;
                final h val$listener;

                public String a()
                {
                    return super.a();
                }

                public void a(PaymentTender paymenttender1)
                {
                    listener.a(paymenttender1);
                }

                public void a(m m1)
                {
                    if (com.target.ui.helper.a.a.b(com.target.ui.helper.a.a.this, listener, (com.target.mothership.model.common.a.j)m1.f().get(com.target.ui.helper.a.a.c()), guest, (com.target.mothership.services.o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(m1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((PaymentTender)obj);
                }

                public void b(Object obj)
                {
                    a((m)obj);
                }

            
            {
                this$0 = com.target.ui.helper.a.a.this;
                listener = h1;
                guest = guest1;
                super();
            }
            });
            return;
        }
    }

    public void a(final Guest guest, com.target.mothership.model.cart.b.d d1, final d listener)
    {
        if (listener == null)
        {
            return;
        }
        if (!com.target.mothership.util.b.a().b())
        {
            listener.e();
            return;
        } else
        {
            com.target.ui.service.f.a().a(guest, d1, new com.target.mothership.model.d() {

                final com.target.ui.helper.a.a this$0;
                final Guest val$guest;
                final d val$listener;

                public String a()
                {
                    return com.target.ui.helper.a.a.a(com.target.ui.helper.a.a.this);
                }

                public void a(PaymentTender paymenttender)
                {
                    p.j().e();
                    listener.a(paymenttender);
                }

                public void a(com.target.mothership.model.guest.interfaces.a.a a1)
                {
                    if (com.target.ui.helper.a.a.b(com.target.ui.helper.a.a.this, 40, listener, (com.target.mothership.model.common.a.j)a1.f().get(com.target.ui.helper.a.a.c()), guest, (com.target.mothership.services.o)c().d()))
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
                    a((PaymentTender)obj);
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.guest.interfaces.a.a)obj);
                }

            
            {
                this$0 = com.target.ui.helper.a.a.this;
                listener = d1;
                guest = guest1;
                super();
            }
            });
            return;
        }
    }

    public void a(final Guest guest, OrderSummary ordersummary, final g listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.o_();
            return;
        } else
        {
            com.target.ui.service.f.a().a(guest, ordersummary, new com.target.mothership.model.d() {

                final com.target.ui.helper.a.a this$0;
                final Guest val$guest;
                final g val$listener;

                public String a()
                {
                    return super.a();
                }

                public void a(OrderDetails orderdetails)
                {
                    listener.a(orderdetails);
                }

                public void a(com.target.mothership.model.guest.interfaces.a.h h1)
                {
                    if (com.target.ui.helper.a.a.e(com.target.ui.helper.a.a.this, listener, (com.target.mothership.model.common.a.j)h1.f().get(com.target.ui.helper.a.a.c()), guest, (com.target.mothership.services.o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(h1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((OrderDetails)obj);
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.guest.interfaces.a.h)obj);
                }

            
            {
                this$0 = com.target.ui.helper.a.a.this;
                listener = g1;
                guest = guest1;
                super();
            }
            });
            return;
        }
    }

    public void a(final Guest guest, final d listener)
    {
        if (listener == null)
        {
            return;
        }
        if (!com.target.mothership.util.b.a().b())
        {
            listener.e();
            return;
        } else
        {
            com.target.ui.service.f.a().b(guest, new com.target.mothership.model.d() {

                final com.target.ui.helper.a.a this$0;
                final Guest val$guest;
                final d val$listener;

                public String a()
                {
                    return com.target.ui.helper.a.a.a(com.target.ui.helper.a.a.this);
                }

                public void a(com.target.mothership.model.guest.interfaces.a.g g1)
                {
                    if (com.target.ui.helper.a.a.a(com.target.ui.helper.a.a.this, 0, listener, (com.target.mothership.model.common.a.j)g1.f().get(com.target.ui.helper.a.a.c()), guest, (com.target.mothership.services.o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(g1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((List)obj);
                }

                public void a(List list)
                {
                    listener.a(list);
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.guest.interfaces.a.g)obj);
                }

            
            {
                this$0 = com.target.ui.helper.a.a.this;
                listener = d1;
                guest = guest1;
                super();
            }
            });
            return;
        }
    }

    public void a(final Guest guest, final i listener)
    {
        if (listener == null)
        {
            return;
        }
        if (!com.target.mothership.util.b.a().b())
        {
            listener.o_();
            return;
        } else
        {
            com.target.ui.service.f.a().c(guest, new com.target.mothership.model.d() {

                final com.target.ui.helper.a.a this$0;
                final Guest val$guest;
                final i val$listener;

                public String a()
                {
                    return com.target.ui.helper.a.a.a(com.target.ui.helper.a.a.this);
                }

                public void a(com.target.mothership.model.guest.interfaces.a.g g1)
                {
                    if (com.target.ui.helper.a.a.a(com.target.ui.helper.a.a.this, listener, (com.target.mothership.model.common.a.j)g1.f().get(com.target.ui.helper.a.a.c()), guest, (com.target.mothership.services.o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(g1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((List)obj);
                }

                public void a(List list)
                {
                    listener.c(list);
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.guest.interfaces.a.g)obj);
                }

            
            {
                this$0 = com.target.ui.helper.a.a.this;
                listener = k;
                guest = guest1;
                super();
            }
            });
            return;
        }
    }

    public void a(final f listener)
    {
        if (listener == null)
        {
            return;
        }
        if (!com.target.mothership.util.b.a().b())
        {
            listener.o_();
            return;
        } else
        {
            com.target.ui.service.a.a().b(new com.target.mothership.model.h() {

                final com.target.ui.helper.a.a this$0;
                final f val$listener;

                public String a()
                {
                    return com.target.ui.helper.a.a.a(com.target.ui.helper.a.a.this);
                }

                public void a(x x1)
                {
                    listener.d();
                }

                public volatile void a(Object obj)
                {
                    a((Void)obj);
                }

                public void a(Void void1)
                {
                    listener.a();
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = com.target.ui.helper.a.a.this;
                listener = f1;
                super();
            }
            });
            return;
        }
    }

    public void a(String s, final j listener)
    {
        listener = new com.target.mothership.model.d() {

            final com.target.ui.helper.a.a this$0;
            final j val$listener;

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
                this$0 = com.target.ui.helper.a.a.this;
                listener = j1;
                super();
            }
        };
        (new com.target.mothership.model.c.c()).a(s, listener);
    }

    public void a(String s, String s1, final e listener)
    {
        while (listener == null || o.e(s) || o.e(s1)) 
        {
            return;
        }
        if (!com.target.mothership.util.b.a().b())
        {
            listener.o_();
            return;
        } else
        {
            com.target.ui.service.a.a().a(s, s1, new com.target.mothership.model.d() {

                final com.target.ui.helper.a.a this$0;
                final e val$listener;

                public String a()
                {
                    return com.target.ui.helper.a.a.a(com.target.ui.helper.a.a.this);
                }

                public void a(Guest guest)
                {
                    listener.a();
                }

                public void a(com.target.mothership.model.guest.interfaces.a.c c1)
                {
                    if (com.target.ui.helper.a.a.a(com.target.ui.helper.a.a.this, (com.target.mothership.model.common.a.j)c1.f().get(com.target.ui.helper.a.a.c())))
                    {
                        listener.q_();
                        return;
                    } else
                    {
                        listener.a(c1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((Guest)obj);
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.guest.interfaces.a.c)obj);
                }

            
            {
                this$0 = com.target.ui.helper.a.a.this;
                listener = e1;
                super();
            }
            });
            return;
        }
    }

    public void a(String s, String s1, String s2, String s3, boolean flag, final b listener)
    {
        if (listener == null)
        {
            return;
        }
        if (!com.target.mothership.util.b.a().b())
        {
            listener.o_();
            return;
        } else
        {
            com.target.ui.service.a.a().a(s, s1, s2, s3, flag, new com.target.mothership.model.d() {

                final com.target.ui.helper.a.a this$0;
                final b val$listener;

                public void a(Guest guest)
                {
                    listener.a();
                }

                public void a(com.target.mothership.model.guest.interfaces.a.d d1)
                {
                    if (com.target.ui.helper.a.a.b(com.target.ui.helper.a.a.this, (com.target.mothership.model.common.a.j)d1.f().get(com.target.ui.helper.a.a.c())))
                    {
                        listener.q_();
                        return;
                    } else
                    {
                        listener.a(d1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((Guest)obj);
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.guest.interfaces.a.d)obj);
                }

            
            {
                this$0 = com.target.ui.helper.a.a.this;
                listener = b1;
                super();
            }
            });
            return;
        }
    }

    public Guest b()
    {
        if (!com.target.ui.service.a.a().c().b())
        {
            q.a(TAG, "tried to show the current session but there isn't one.");
            return null;
        } else
        {
            return (Guest)com.target.ui.service.a.a().c().c();
        }
    }

}
