// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.c;

import com.target.mothership.model.cart.interfaces.AppliedGiftCard;
import com.target.mothership.model.cart.interfaces.AppliedPromoCodes;
import com.target.mothership.model.cart.interfaces.AppliedTenders;
import com.target.mothership.model.cart.interfaces.ExpressOrderReview;
import com.target.mothership.model.cart.interfaces.InitiatedCheckout;
import com.target.mothership.model.cart.interfaces.InitiatedPayPal;
import com.target.mothership.model.cart.interfaces.OrderCompletionDetails;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.cart.interfaces.PromoCode;
import com.target.mothership.model.cart.interfaces.a.e;
import com.target.mothership.model.cart.interfaces.a.g;
import com.target.mothership.model.cart.interfaces.a.h;
import com.target.mothership.model.cart.interfaces.a.i;
import com.target.mothership.model.cart.interfaces.a.p;
import com.target.mothership.model.cart.interfaces.a.q;
import com.target.mothership.model.cart.interfaces.a.r;
import com.target.mothership.model.cart.interfaces.a.s;
import com.target.mothership.model.cart.interfaces.a.t;
import com.target.mothership.model.cart.interfaces.a.v;
import com.target.mothership.model.common.AppliedGiftCardTender;
import com.target.mothership.model.common.a.j;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.o;
import com.target.mothership.services.x;
import com.target.ui.helper.a;
import com.target.ui.service.b;
import com.target.ui.service.d;
import com.target.ui.service.f;
import java.util.List;

public class com.target.ui.helper.c.c extends com.target.ui.helper.a
{
    public static interface a
        extends com.target.ui.helper.c, c
    {

        public abstract void a(AppliedTenders appliedtenders);

        public abstract void a(ExpressOrderReview expressorderreview, AppliedTenders appliedtenders);

        public abstract void a(OrderCompletionDetails ordercompletiondetails);

        public abstract void a(OrderReview orderreview, boolean flag);

        public abstract void a(com.target.mothership.model.cart.interfaces.a.c c1, o o, String s);

        public abstract void a(e e1, String s, o o);

        public abstract void a(g g1, o o);

        public abstract void a(h h1, o o);

        public abstract void a(i i1);

        public abstract void a(i i1, AppliedGiftCardTender appliedgiftcardtender);

        public abstract void a(com.target.mothership.model.cart.interfaces.a.o o);

        public abstract void a(p p);

        public abstract void a(q q, o o);

        public abstract void a(r r, o o);

        public abstract void a(s s, String s1);

        public abstract void a(t t);

        public abstract void a(v v, PromoCode promocode);

        public abstract void a(com.target.mothership.model.guest.interfaces.a.g g1);

        public abstract void a(x x);

        public abstract void b(InitiatedPayPal initiatedpaypal);

        public abstract void b(e e1, String s, o o);

        public abstract void b(Guest guest);

        public abstract void e(List list);
    }

    public static interface b
    {

        public abstract void a(com.target.mothership.model.coupon_wallets.interfaces.a.b b1);

        public abstract void c(List list);
    }

    public static interface c
    {

        public abstract void c();
    }


    private static final String COUPON_WALLETS_REQUEST_POST_FIX = "COUPON_WALLETS";
    private static final String GIFT_CARD_REQUEST_POST_FIX = "GIFT_CARD_TENDER";
    private static final String LOG_TAG = com/target/ui/helper/c/c.getSimpleName();
    private static int PRIMARY_FAILURE_REASON_INDEX = 0;
    private com.target.ui.service.a mAccountService;
    private com.target.ui.service.b mCartDataService;
    private final String mCouponWalletsRequestTag;
    private d mCouponWalletsService;
    private final String mGiftCardRequestTag;
    private f mGuestDataService;
    private InitiatedCheckout mInitiatedCheckout;
    private com.target.mothership.model.c.c mLocationManager;
    private final String mRequestTag = String.valueOf(hashCode());

    public com.target.ui.helper.c.c(InitiatedCheckout initiatedcheckout)
    {
        mCartDataService = com.target.ui.service.b.a();
        mAccountService = com.target.ui.service.a.a();
        mGuestDataService = com.target.ui.service.f.a();
        mCouponWalletsService = com.target.ui.service.d.a();
        mLocationManager = new com.target.mothership.model.c.c();
        mGiftCardRequestTag = (new StringBuilder()).append(mRequestTag).append("GIFT_CARD_TENDER").toString();
        mCouponWalletsRequestTag = (new StringBuilder()).append(mRequestTag).append("COUPON_WALLETS").toString();
        mInitiatedCheckout = initiatedcheckout;
    }

    static String a(com.target.ui.helper.c.c c1)
    {
        return c1.mRequestTag;
    }

    private void a(Guest guest, final ExpressOrderReview expressOrderReview, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.c();
            return;
        } else
        {
            expressOrderReview = new com.target.mothership.model.d() {

                final com.target.ui.helper.c.c this$0;
                final ExpressOrderReview val$expressOrderReview;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this);
                }

                public void a(AppliedTenders appliedtenders)
                {
                    listener.a(expressOrderReview, appliedtenders);
                }

                public void a(i i1)
                {
                    listener.a(expressOrderReview, null);
                }

                public volatile void a(Object obj)
                {
                    a((AppliedTenders)obj);
                }

                public void b(Object obj)
                {
                    a((i)obj);
                }

            
            {
                this$0 = com.target.ui.helper.c.c.this;
                listener = a1;
                expressOrderReview = expressorderreview;
                super();
            }
            };
            mCartDataService.e(guest, mInitiatedCheckout, expressOrderReview);
            return;
        }
    }

    private void a(final Guest guest, final boolean withCouponCode, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.c();
            return;
        } else
        {
            listener = new com.target.mothership.model.d() {

                final com.target.ui.helper.c.c this$0;
                final Guest val$guest;
                final a val$listener;
                final boolean val$withCouponCode;

                public String a()
                {
                    return com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this);
                }

                public void a(OrderReview orderreview)
                {
                    listener.a(orderreview, withCouponCode);
                }

                public void a(p p1)
                {
                    if (com.target.ui.helper.c.c.g(com.target.ui.helper.c.c.this, 0, listener, (j)p1.f().get(com.target.ui.helper.c.c.c()), guest, (o)c().d()))
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
                this$0 = com.target.ui.helper.c.c.this;
                listener = a1;
                withCouponCode = flag;
                guest = guest1;
                super();
            }
            };
            mCartDataService.c(guest, mInitiatedCheckout, listener);
            return;
        }
    }

    static void a(com.target.ui.helper.c.c c1, Guest guest, ExpressOrderReview expressorderreview, a a1)
    {
        c1.a(guest, expressorderreview, a1);
    }

    static void a(com.target.ui.helper.c.c c1, Guest guest, a a1)
    {
        c1.f(guest, a1);
    }

    static void a(com.target.ui.helper.c.c c1, Guest guest, boolean flag, a a1)
    {
        c1.a(guest, flag, a1);
    }

    static boolean a(com.target.ui.helper.c.c c1, int i1, com.target.ui.helper.c c2, j j1, Guest guest, o o)
    {
        return c1.a(i1, c2, j1, guest, o);
    }

    static com.target.ui.service.b b(com.target.ui.helper.c.c c1)
    {
        return c1.mCartDataService;
    }

    static boolean b(com.target.ui.helper.c.c c1, int i1, com.target.ui.helper.c c2, j j1, Guest guest, o o)
    {
        return c1.a(i1, c2, j1, guest, o);
    }

    static int c()
    {
        return PRIMARY_FAILURE_REASON_INDEX;
    }

    static String c(com.target.ui.helper.c.c c1)
    {
        return c1.mGiftCardRequestTag;
    }

    static boolean c(com.target.ui.helper.c.c c1, int i1, com.target.ui.helper.c c2, j j1, Guest guest, o o)
    {
        return c1.a(i1, c2, j1, guest, o);
    }

    static String d()
    {
        return LOG_TAG;
    }

    static String d(com.target.ui.helper.c.c c1)
    {
        return c1.mCouponWalletsRequestTag;
    }

    static boolean d(com.target.ui.helper.c.c c1, int i1, com.target.ui.helper.c c2, j j1, Guest guest, o o)
    {
        return c1.a(i1, c2, j1, guest, o);
    }

    static boolean e(com.target.ui.helper.c.c c1, int i1, com.target.ui.helper.c c2, j j1, Guest guest, o o)
    {
        return c1.a(i1, c2, j1, guest, o);
    }

    private void f(Guest guest, a a1)
    {
        a(guest, false, a1);
    }

    static boolean f(com.target.ui.helper.c.c c1, int i1, com.target.ui.helper.c c2, j j1, Guest guest, o o)
    {
        return c1.a(i1, c2, j1, guest, o);
    }

    static boolean g(com.target.ui.helper.c.c c1, int i1, com.target.ui.helper.c c2, j j1, Guest guest, o o)
    {
        return c1.a(i1, c2, j1, guest, o);
    }

    static boolean h(com.target.ui.helper.c.c c1, int i1, com.target.ui.helper.c c2, j j1, Guest guest, o o)
    {
        return c1.a(i1, c2, j1, guest, o);
    }

    static boolean i(com.target.ui.helper.c.c c1, int i1, com.target.ui.helper.c c2, j j1, Guest guest, o o)
    {
        return c1.a(i1, c2, j1, guest, o);
    }

    static boolean j(com.target.ui.helper.c.c c1, int i1, com.target.ui.helper.c c2, j j1, Guest guest, o o)
    {
        return c1.a(i1, c2, j1, guest, o);
    }

    static boolean k(com.target.ui.helper.c.c c1, int i1, com.target.ui.helper.c c2, j j1, Guest guest, o o)
    {
        return c1.a(i1, c2, j1, guest, o);
    }

    static boolean l(com.target.ui.helper.c.c c1, int i1, com.target.ui.helper.c c2, j j1, Guest guest, o o)
    {
        return c1.a(i1, c2, j1, guest, o);
    }

    static boolean m(com.target.ui.helper.c.c c1, int i1, com.target.ui.helper.c c2, j j1, Guest guest, o o)
    {
        return c1.a(i1, c2, j1, guest, o);
    }

    public void a()
    {
        mGuestDataService.a(mGiftCardRequestTag);
    }

    public void a(Guest guest, com.target.mothership.common.tender.a a1, String s, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.c();
            return;
        } else
        {
            mCartDataService.a(guest, mInitiatedCheckout, a1, s, new com.target.mothership.model.d() {

                final com.target.ui.helper.c.c this$0;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this);
                }

                public void a(OrderCompletionDetails ordercompletiondetails)
                {
                    listener.a(ordercompletiondetails);
                }

                public void a(h h1)
                {
                    listener.a(h1, (o)c().c());
                }

                public volatile void a(Object obj)
                {
                    a((OrderCompletionDetails)obj);
                }

                public void b(Object obj)
                {
                    a((h)obj);
                }

            
            {
                this$0 = com.target.ui.helper.c.c.this;
                listener = a1;
                super();
            }
            });
            return;
        }
    }

    public void a(final Guest guest, com.target.mothership.model.cart.b.d d1, final String hintFlag, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.c();
            return;
        } else
        {
            mCartDataService.a(guest, mInitiatedCheckout, d1, new com.target.mothership.model.d() {

                final com.target.ui.helper.c.c this$0;
                final Guest val$guest;
                final String val$hintFlag;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this);
                }

                public void a(AppliedGiftCard appliedgiftcard)
                {
                    appliedgiftcard = (Guest)com.target.ui.service.a.a().c().a(guest);
                    com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this, appliedgiftcard, listener);
                }

                public void a(com.target.mothership.model.cart.interfaces.a.c c1)
                {
                    if (com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this, 40, listener, (j)c1.f().get(com.target.ui.helper.c.c.c()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(c1, (o)c().d(), hintFlag);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((AppliedGiftCard)obj);
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.cart.interfaces.a.c)obj);
                }

            
            {
                this$0 = com.target.ui.helper.c.c.this;
                guest = guest1;
                listener = a1;
                hintFlag = s;
                super();
            }
            });
            return;
        }
    }

    public void a(final Guest guest, InitiatedPayPal initiatedpaypal, OrderReview orderreview, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.c();
            return;
        } else
        {
            mCartDataService.a(guest, initiatedpaypal, orderreview, new com.target.mothership.model.d() {

                final com.target.ui.helper.c.c this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this);
                }

                public void a(r r1)
                {
                    if (com.target.ui.helper.c.c.l(com.target.ui.helper.c.c.this, 0, listener, (j)r1.f().get(com.target.ui.helper.c.c.c()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(r1, (o)c().d());
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((Void)obj);
                }

                public void a(Void void1)
                {
                    com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this, guest, listener);
                }

                public void b(Object obj)
                {
                    a((r)obj);
                }

            
            {
                this$0 = com.target.ui.helper.c.c.this;
                guest = guest1;
                listener = a1;
                super();
            }
            });
            return;
        }
    }

    public void a(final Guest guest, OrderReview orderreview, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.c();
            return;
        } else
        {
            mCartDataService.a(guest, orderreview, new com.target.mothership.model.d() {

                final com.target.ui.helper.c.c this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this);
                }

                public void a(InitiatedPayPal initiatedpaypal)
                {
                    listener.b(initiatedpaypal);
                }

                public void a(q q1)
                {
                    if (com.target.ui.helper.c.c.k(com.target.ui.helper.c.c.this, 0, listener, (j)q1.f().get(com.target.ui.helper.c.c.c()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(q1, (o)c().d());
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((InitiatedPayPal)obj);
                }

                public void b(Object obj)
                {
                    a((q)obj);
                }

            
            {
                this$0 = com.target.ui.helper.c.c.this;
                listener = a1;
                guest = guest1;
                super();
            }
            });
            return;
        }
    }

    public void a(final Guest guest, final PromoCode promoCode, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.c();
            return;
        } else
        {
            mCartDataService.a(guest, promoCode, new com.target.mothership.model.d() {

                final com.target.ui.helper.c.c this$0;
                final Guest val$guest;
                final a val$listener;
                final PromoCode val$promoCode;

                public String a()
                {
                    return com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this);
                }

                public void a(v v1)
                {
                    if (com.target.ui.helper.c.c.h(com.target.ui.helper.c.c.this, 0, listener, (j)v1.f().get(com.target.ui.helper.c.c.c()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(v1, promoCode);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((String)obj);
                }

                public void a(String s)
                {
                    s = (Guest)com.target.ui.service.a.a().c().a(guest);
                    com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this, s, listener);
                }

                public void b(Object obj)
                {
                    a((v)obj);
                }

            
            {
                this$0 = com.target.ui.helper.c.c.this;
                guest = guest1;
                listener = a1;
                promoCode = promocode;
                super();
            }
            });
            return;
        }
    }

    public void a(final Guest guest, final AppliedGiftCardTender appliedGiftCard, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.c();
            return;
        } else
        {
            final com.target.mothership.model.d removeGiftCardReceiver = new com.target.mothership.model.d() {

                final com.target.ui.helper.c.c this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this);
                }

                public void a(t t1)
                {
                    if (com.target.ui.helper.c.c.c(com.target.ui.helper.c.c.this, 41, listener, (j)t1.f().get(com.target.ui.helper.c.c.c()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(t1);
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
                    com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this, void1, listener);
                }

                public void b(Object obj)
                {
                    a((t)obj);
                }

            
            {
                this$0 = com.target.ui.helper.c.c.this;
                guest = guest1;
                listener = a1;
                super();
            }
            };
            mCartDataService.e(guest, mInitiatedCheckout, new com.target.mothership.model.d() {

                final com.target.ui.helper.c.c this$0;
                final AppliedGiftCardTender val$appliedGiftCard;
                final Guest val$guest;
                final a val$listener;
                final com.target.mothership.model.d val$removeGiftCardReceiver;

                public String a()
                {
                    return com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this);
                }

                public void a(AppliedTenders appliedtenders)
                {
                    com.target.ui.helper.c.c.b(com.target.ui.helper.c.c.this).a(guest, appliedGiftCard, appliedtenders.b(), removeGiftCardReceiver);
                }

                public void a(i i1)
                {
                    if (com.target.ui.helper.c.c.d(com.target.ui.helper.c.c.this, 41, listener, (j)i1.f().get(com.target.ui.helper.c.c.c()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(i1, appliedGiftCard);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((AppliedTenders)obj);
                }

                public void b(Object obj)
                {
                    a((i)obj);
                }

            
            {
                this$0 = com.target.ui.helper.c.c.this;
                guest = guest1;
                appliedGiftCard = appliedgiftcardtender;
                removeGiftCardReceiver = d1;
                listener = a1;
                super();
            }
            });
            return;
        }
    }

    public void a(Guest guest, final o requestRetryable, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.c();
            return;
        } else
        {
            mAccountService.a(guest, new com.target.mothership.model.h() {

                final com.target.ui.helper.c.c this$0;
                final a val$listener;
                final o val$requestRetryable;

                public String a()
                {
                    return com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this);
                }

                public void a(Guest guest1)
                {
                    if (requestRetryable != null)
                    {
                        requestRetryable.a(guest1);
                        requestRetryable.a();
                        return;
                    } else
                    {
                        listener.b(guest1);
                        return;
                    }
                }

                public void a(x x1)
                {
                    listener.a(x1);
                    if (x1 != null)
                    {
                        x1 = x1.getMessage();
                    } else
                    {
                        x1 = "";
                    }
                    com.target.ui.util.q.a(com.target.ui.helper.c.c.d(), (new StringBuilder()).append("Unable to fetch a new anonymous guest session:").append(x1).toString());
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
                this$0 = com.target.ui.helper.c.c.this;
                requestRetryable = o1;
                listener = a1;
                super();
            }
            });
            return;
        }
    }

    public void a(Guest guest, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.c();
            return;
        } else
        {
            mCartDataService.b(guest, mInitiatedCheckout, new com.target.mothership.model.d() {

                final com.target.ui.helper.c.c this$0;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this);
                }

                public void a(OrderCompletionDetails ordercompletiondetails)
                {
                    listener.a(ordercompletiondetails);
                }

                public void a(h h1)
                {
                    listener.a(h1, (o)c().c());
                }

                public volatile void a(Object obj)
                {
                    a((OrderCompletionDetails)obj);
                }

                public void b(Object obj)
                {
                    a((h)obj);
                }

            
            {
                this$0 = com.target.ui.helper.c.c.this;
                listener = a1;
                super();
            }
            });
            return;
        }
    }

    public void a(Guest guest, final b couponWalletsListener, c c1)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            c1.c();
            return;
        } else
        {
            mCouponWalletsService.a(guest, new com.target.mothership.model.d() {

                final com.target.ui.helper.c.c this$0;
                final b val$couponWalletsListener;

                public String a()
                {
                    return com.target.ui.helper.c.c.d(com.target.ui.helper.c.c.this);
                }

                public void a(com.target.mothership.model.coupon_wallets.interfaces.a.b b1)
                {
                    couponWalletsListener.a(b1);
                }

                public volatile void a(Object obj)
                {
                    a((List)obj);
                }

                public void a(List list)
                {
                    couponWalletsListener.c(list);
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.coupon_wallets.interfaces.a.b)obj);
                }

            
            {
                this$0 = com.target.ui.helper.c.c.this;
                couponWalletsListener = b1;
                super();
            }
            });
            return;
        }
    }

    public void a(Guest guest, String s, com.target.mothership.common.tender.a a1, String s1, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.c();
            return;
        } else
        {
            mCartDataService.a(guest, mInitiatedCheckout, s, a1, s1, new com.target.mothership.model.d() {

                final com.target.ui.helper.c.c this$0;
                final a val$listener;

                public void a(OrderCompletionDetails ordercompletiondetails)
                {
                    listener.a(ordercompletiondetails);
                }

                public void a(h h1)
                {
                    listener.a(h1, (o)c().c());
                }

                public volatile void a(Object obj)
                {
                    a((OrderCompletionDetails)obj);
                }

                public void b(Object obj)
                {
                    a((h)obj);
                }

            
            {
                this$0 = com.target.ui.helper.c.c.this;
                listener = a1;
                super();
            }
            });
            return;
        }
    }

    public void a(Guest guest, String s, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.c();
            return;
        } else
        {
            mCartDataService.a(guest, mInitiatedCheckout, s, new com.target.mothership.model.d() {

                final com.target.ui.helper.c.c this$0;
                final a val$listener;

                public void a(OrderCompletionDetails ordercompletiondetails)
                {
                    listener.a(ordercompletiondetails);
                }

                public void a(h h1)
                {
                    listener.a(h1, (o)c().c());
                }

                public volatile void a(Object obj)
                {
                    a((OrderCompletionDetails)obj);
                }

                public void b(Object obj)
                {
                    a((h)obj);
                }

            
            {
                this$0 = com.target.ui.helper.c.c.this;
                listener = a1;
                super();
            }
            });
            return;
        }
    }

    public void b()
    {
        mAccountService.a(mRequestTag);
        mCartDataService.a(mRequestTag);
        mGuestDataService.a(mGiftCardRequestTag);
        mCouponWalletsService.a(mCouponWalletsRequestTag);
        mLocationManager.a(mRequestTag);
    }

    public void b(final Guest guest, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.c();
            return;
        } else
        {
            mCartDataService.e(guest, mInitiatedCheckout, new com.target.mothership.model.d() {

                final com.target.ui.helper.c.c this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this);
                }

                public void a(AppliedTenders appliedtenders)
                {
                    listener.a(appliedtenders);
                }

                public void a(i i1)
                {
                    if (com.target.ui.helper.c.c.b(com.target.ui.helper.c.c.this, 0, listener, (j)i1.f().get(com.target.ui.helper.c.c.c()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(i1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((AppliedTenders)obj);
                }

                public void b(Object obj)
                {
                    a((i)obj);
                }

            
            {
                this$0 = com.target.ui.helper.c.c.this;
                listener = a1;
                guest = guest1;
                super();
            }
            });
            return;
        }
    }

    public void b(final Guest guest, final String couponCode, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.c();
            return;
        } else
        {
            mCartDataService.c(guest, mInitiatedCheckout, couponCode, new com.target.mothership.model.d() {

                final com.target.ui.helper.c.c this$0;
                final String val$couponCode;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this);
                }

                public void a(AppliedPromoCodes appliedpromocodes)
                {
                    appliedpromocodes = (Guest)com.target.ui.service.a.a().c().a(guest);
                    com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this, appliedpromocodes, true, listener);
                }

                public void a(e e1)
                {
                    if (com.target.ui.helper.c.c.e(com.target.ui.helper.c.c.this, 50, listener, (j)e1.f().get(com.target.ui.helper.c.c.c()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.b(e1, couponCode, (o)c().d());
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((AppliedPromoCodes)obj);
                }

                public void b(Object obj)
                {
                    a((e)obj);
                }

            
            {
                this$0 = com.target.ui.helper.c.c.this;
                guest = guest1;
                listener = a1;
                couponCode = s;
                super();
            }
            });
            return;
        }
    }

    public void c(Guest guest, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.c();
            return;
        } else
        {
            mGuestDataService.b(guest, new com.target.mothership.model.d() {

                final com.target.ui.helper.c.c this$0;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.c.c.c(com.target.ui.helper.c.c.this);
                }

                public void a(com.target.mothership.model.guest.interfaces.a.g g1)
                {
                    listener.a(g1);
                }

                public volatile void a(Object obj)
                {
                    a((List)obj);
                }

                public void a(List list)
                {
                    listener.e(list);
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.guest.interfaces.a.g)obj);
                }

            
            {
                this$0 = com.target.ui.helper.c.c.this;
                listener = a1;
                super();
            }
            });
            return;
        }
    }

    public void c(final Guest guest, final String promoCode, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.c();
            return;
        } else
        {
            mCartDataService.b(guest, mInitiatedCheckout, promoCode, new com.target.mothership.model.d() {

                final com.target.ui.helper.c.c this$0;
                final Guest val$guest;
                final a val$listener;
                final String val$promoCode;

                public String a()
                {
                    return com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this);
                }

                public void a(AppliedPromoCodes appliedpromocodes)
                {
                    appliedpromocodes = (Guest)com.target.ui.service.a.a().c().a(guest);
                    com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this, appliedpromocodes, listener);
                }

                public void a(e e1)
                {
                    if (com.target.ui.helper.c.c.f(com.target.ui.helper.c.c.this, 50, listener, (j)e1.f().get(com.target.ui.helper.c.c.c()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(e1, promoCode, (o)c().d());
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((AppliedPromoCodes)obj);
                }

                public void b(Object obj)
                {
                    a((e)obj);
                }

            
            {
                this$0 = com.target.ui.helper.c.c.this;
                guest = guest1;
                listener = a1;
                promoCode = s;
                super();
            }
            });
            return;
        }
    }

    public void d(final Guest guest, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.c();
            return;
        } else
        {
            listener = new com.target.mothership.model.d() {

                final com.target.ui.helper.c.c this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this);
                }

                public void a(ExpressOrderReview expressorderreview)
                {
                    com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this, guest, expressorderreview, listener);
                }

                public void a(com.target.mothership.model.cart.interfaces.a.o o1)
                {
                    if (com.target.ui.helper.c.c.m(com.target.ui.helper.c.c.this, 0, listener, (j)o1.f().get(com.target.ui.helper.c.c.c()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(o1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((ExpressOrderReview)obj);
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.cart.interfaces.a.o)obj);
                }

            
            {
                this$0 = com.target.ui.helper.c.c.this;
                guest = guest1;
                listener = a1;
                super();
            }
            };
            mCartDataService.c(guest, listener);
            return;
        }
    }

    public void d(final Guest guest, String s, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.c();
            return;
        } else
        {
            mCartDataService.d(guest, mInitiatedCheckout, s, new com.target.mothership.model.d() {

                final com.target.ui.helper.c.c this$0;
                final Guest val$guest;
                final a val$listener;

                public String a()
                {
                    return com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this);
                }

                public void a(g g1)
                {
                    if (com.target.ui.helper.c.c.i(com.target.ui.helper.c.c.this, 0, listener, (j)g1.f().get(com.target.ui.helper.c.c.c()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(g1, (o)c().d());
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((String)obj);
                }

                public void a(String s1)
                {
                    s1 = (Guest)com.target.ui.service.a.a().c().a(guest);
                    com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this, s1, listener);
                }

                public void b(Object obj)
                {
                    a((g)obj);
                }

            
            {
                this$0 = com.target.ui.helper.c.c.this;
                guest = guest1;
                listener = a1;
                super();
            }
            });
            return;
        }
    }

    public void e(Guest guest, a a1)
    {
        f(guest, a1);
    }

    public void e(final Guest guest, final String teamMemberNumber, final a listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.c();
            return;
        } else
        {
            mCartDataService.f(guest, mInitiatedCheckout, new com.target.mothership.model.d() {

                final com.target.ui.helper.c.c this$0;
                final Guest val$guest;
                final a val$listener;
                final String val$teamMemberNumber;

                public String a()
                {
                    return com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this);
                }

                public void a(s s1)
                {
                    if (com.target.ui.helper.c.c.j(com.target.ui.helper.c.c.this, 0, listener, (j)s1.f().get(com.target.ui.helper.c.c.c()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(s1, teamMemberNumber);
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
                    com.target.ui.helper.c.c.a(com.target.ui.helper.c.c.this, void1, listener);
                }

                public void b(Object obj)
                {
                    a((s)obj);
                }

            
            {
                this$0 = com.target.ui.helper.c.c.this;
                guest = guest1;
                listener = a1;
                teamMemberNumber = s1;
                super();
            }
            });
            return;
        }
    }

}
