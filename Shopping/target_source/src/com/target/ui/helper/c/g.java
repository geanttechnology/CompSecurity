// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.c;

import com.target.mothership.common.params.AddressParams;
import com.target.mothership.common.tender.PaymentTender;
import com.target.mothership.model.c.c;
import com.target.mothership.model.cart.interfaces.InitiatedCheckout;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.cart.interfaces.a.p;
import com.target.mothership.model.cart.interfaces.a.t;
import com.target.mothership.model.common.a.j;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.a.k;
import com.target.mothership.model.guest.interfaces.a.m;
import com.target.mothership.model.h;
import com.target.mothership.services.o;
import com.target.mothership.services.x;
import com.target.ui.helper.a;
import com.target.ui.model.checkout.BillingCardDetailsModel;
import com.target.ui.model.checkout.CardDataModel;
import com.target.ui.model.checkout.DeliveryTypedProducts;
import com.target.ui.model.checkout.PaymentCardInformationModel;
import com.target.ui.model.checkout.TGTPaymentCardInformationModel;
import com.target.ui.service.b;
import com.target.ui.service.f;
import com.target.ui.util.e;
import com.target.ui.util.q;
import java.util.List;

public class g extends com.target.ui.helper.a
{
    private final class a extends d
    {

        final PaymentCardInformationModel existingCard;
        final d getOrderReviewTailCall;
        final Guest guest;
        final InitiatedCheckout initiatedCheckout;
        final c listener;
        final g this$0;
        final PaymentTender updatedPaymentTender;

        public String a()
        {
            return com.target.ui.helper.c.g.b(g.this);
        }

        public void a(com.target.mothership.model.cart.interfaces.a.d d1)
        {
            if (com.target.ui.helper.c.g.d(g.this, listener, (j)d1.f().get(com.target.ui.helper.c.g.b()), guest, (o)c().d()))
            {
                return;
            } else
            {
                TGTPaymentCardInformationModel tgtpaymentcardinformationmodel = new TGTPaymentCardInformationModel();
                tgtpaymentcardinformationmodel.a(existingCard.a());
                tgtpaymentcardinformationmodel.a(false);
                tgtpaymentcardinformationmodel.b(existingCard.c());
                tgtpaymentcardinformationmodel.a(updatedPaymentTender);
                listener.a(tgtpaymentcardinformationmodel, d1);
                return;
            }
        }

        public volatile void a(Object obj)
        {
            a((Void)obj);
        }

        public void a(Void void1)
        {
            com.target.ui.helper.c.g.a(g.this).c(guest, initiatedCheckout, getOrderReviewTailCall);
        }

        public void b(Object obj)
        {
            a((com.target.mothership.model.cart.interfaces.a.d)obj);
        }

        public a(Guest guest1, InitiatedCheckout initiatedcheckout, PaymentCardInformationModel paymentcardinformationmodel, PaymentTender paymenttender, d d1, c c1)
        {
            this$0 = g.this;
            super();
            guest = guest1;
            initiatedCheckout = initiatedcheckout;
            existingCard = paymentcardinformationmodel;
            updatedPaymentTender = paymenttender;
            getOrderReviewTailCall = d1;
            listener = c1;
        }
    }

    private final class b extends d
    {

        private final Guest guest;
        private final c listener;
        final g this$0;

        public String a()
        {
            return com.target.ui.helper.c.g.b(g.this);
        }

        public void a(OrderReview orderreview)
        {
            listener.a(orderreview);
        }

        public void a(p p1)
        {
            if (com.target.ui.helper.c.g.m(g.this, listener, (j)p1.f().get(com.target.ui.helper.c.g.b()), guest, (o)c().d()))
            {
                return;
            } else
            {
                com.target.ui.helper.c.g.a((o)c().d(), listener, p1);
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

        public b(Guest guest1, c c1)
        {
            this$0 = g.this;
            super();
            listener = c1;
            guest = guest1;
        }
    }

    public static interface c
        extends com.target.ui.helper.b
    {

        public abstract void a(com.target.mothership.model.c.c.a.a a1);

        public abstract void a(com.target.mothership.model.c.c.a a1);

        public abstract void a(OrderReview orderreview);

        public abstract void a(com.target.mothership.model.cart.interfaces.a.d d1);

        public abstract void a(p p);

        public abstract void a(t t);

        public abstract void a(k k1);

        public abstract void a(m m1);

        public abstract void a(x x);

        public abstract void a(PaymentCardInformationModel paymentcardinformationmodel, com.target.mothership.model.cart.interfaces.a.d d1);

        public abstract void b(OrderReview orderreview);

        public abstract void b(Guest guest);

        public abstract void c(OrderReview orderreview);

        public abstract void k();
    }


    private static final String LOG_TAG = com/target/ui/helper/c/g.getSimpleName();
    private static int PRIMARY_REASON_INDEX = 0;
    private com.target.ui.service.a mAccountService;
    private com.target.ui.service.b mCartDataService;
    private f mGuestDataService;
    private final String mRequestTag = String.valueOf(hashCode());

    public g()
    {
        mCartDataService = com.target.ui.service.b.a();
        mGuestDataService = com.target.ui.service.f.a();
        mAccountService = com.target.ui.service.a.a();
    }

    static com.target.ui.service.b a(g g1)
    {
        return g1.mCartDataService;
    }

    private void a(final Guest guest, final InitiatedCheckout initiatedCheckout, final c listener)
    {
        listener = new d() {

            final g this$0;
            final d val$getOrderReviewTailCall;
            final Guest val$guest;
            final InitiatedCheckout val$initiatedCheckout;
            final c val$listener;

            public String a()
            {
                return com.target.ui.helper.c.g.b(g.this);
            }

            public void a(t t1)
            {
                if (g.i(g.this, listener, (j)t1.f().get(com.target.ui.helper.c.g.b()), guest, (o)c().d()))
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
                com.target.ui.helper.c.g.a(g.this).c(guest, initiatedCheckout, getOrderReviewTailCall);
            }

            public void b(Object obj)
            {
                a((t)obj);
            }

            
            {
                this$0 = g.this;
                guest = guest1;
                initiatedCheckout = initiatedcheckout;
                getOrderReviewTailCall = d1;
                listener = c1;
                super();
            }
        };
        mCartDataService.g(guest, initiatedCheckout, listener);
    }

    private void a(final Guest guest, final InitiatedCheckout initiatedCheckout, final PaymentCardInformationModel paymentCardInformationModel, final c listener)
    {
        paymentCardInformationModel = new d() {

            final g this$0;
            final Guest val$guest;
            final c val$listener;
            final PaymentCardInformationModel val$paymentCardInformationModel;
            final d val$removeAccountCartCallback;

            public String a()
            {
                return com.target.ui.helper.c.g.b(g.this);
            }

            public void a(t t1)
            {
                if (g.g(g.this, listener, (j)t1.f().get(com.target.ui.helper.c.g.b()), guest, (o)c().d()))
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
                com.target.ui.helper.c.g.c(g.this).a(guest, paymentCardInformationModel.d(), removeAccountCartCallback);
            }

            public void b(Object obj)
            {
                a((t)obj);
            }

            
            {
                this$0 = g.this;
                guest = guest1;
                paymentCardInformationModel = paymentcardinformationmodel;
                removeAccountCartCallback = d1;
                listener = c1;
                super();
            }
        };
        mCartDataService.g(guest, initiatedCheckout, paymentCardInformationModel);
    }

    private void a(final Guest guest, final InitiatedCheckout initiatedCheckout, PaymentCardInformationModel paymentcardinformationmodel, BillingCardDetailsModel billingcarddetailsmodel, c c1)
    {
        initiatedCheckout = new d() {

            final g this$0;
            final com.target.mothership.common.tender.a val$cardType;
            final Guest val$guest;
            final InitiatedCheckout val$initiatedCheckout;
            final c val$listener;
            final PaymentCardInformationModel val$paymentCardInformationModel;

            public String a()
            {
                return com.target.ui.helper.c.g.b(g.this);
            }

            public void a(PaymentTender paymenttender)
            {
                com.target.ui.helper.c.g.a(g.this).a(guest, initiatedCheckout, cardType, paymenttender, null, new a(guest, initiatedCheckout, paymentCardInformationModel, paymenttender, new b(guest, listener), listener));
            }

            public void a(m m1)
            {
                if (com.target.ui.helper.c.g.c(g.this, listener, (j)m1.f().get(com.target.ui.helper.c.g.b()), guest, (o)c().d()))
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
                this$0 = g.this;
                guest = guest1;
                initiatedCheckout = initiatedcheckout;
                cardType = a1;
                paymentCardInformationModel = paymentcardinformationmodel;
                listener = c1;
                super();
            }
        };
        mGuestDataService.a(guest, paymentcardinformationmodel.d(), paymentcardinformationmodel.c(), billingcarddetailsmodel.b(), initiatedCheckout);
    }

    private void a(final Guest guest, final OrderReview orderReview, AddressParams addressparams, final c listener)
    {
        listener = new d() {

            final g this$0;
            final Guest val$guest;
            final c val$listener;
            final OrderReview val$orderReview;

            public String a()
            {
                return com.target.ui.helper.c.g.b(g.this);
            }

            public void a(com.target.mothership.model.cart.interfaces.a.a a1)
            {
                com.target.ui.helper.c.g.a(g.this).c(guest, orderReview, new b(guest, listener));
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
                com.target.ui.helper.c.g.a(g.this).c(guest, orderReview, new b(guest, listener));
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.cart.interfaces.a.a)obj);
            }

            
            {
                this$0 = g.this;
                guest = guest1;
                orderReview = orderreview;
                listener = c1;
                super();
            }
        };
        DeliveryTypedProducts deliverytypedproducts = com.target.ui.util.e.a(orderReview);
        mCartDataService.a(guest, orderReview, addressparams, deliverytypedproducts.a(), true, listener);
    }

    private void a(final Guest guest, final OrderReview orderReview, PaymentCardInformationModel paymentcardinformationmodel, BillingCardDetailsModel billingcarddetailsmodel, final c listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.k();
            return;
        } else
        {
            orderReview = new d() {

                final g this$0;
                final Guest val$guest;
                final c val$listener;
                final OrderReview val$orderReview;

                public String a()
                {
                    return com.target.ui.helper.c.g.b(g.this);
                }

                public void a(PaymentTender paymenttender)
                {
                    listener.a(orderReview);
                }

                public void a(m m1)
                {
                    if (com.target.ui.helper.c.g.b(g.this, listener, (j)m1.f().get(com.target.ui.helper.c.g.b()), guest, (o)c().d()))
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
                this$0 = g.this;
                listener = c1;
                orderReview = orderreview;
                guest = guest1;
                super();
            }
            };
            mGuestDataService.a(guest, paymentcardinformationmodel.d(), paymentcardinformationmodel.c(), billingcarddetailsmodel.b(), orderReview);
            return;
        }
    }

    static void a(o o1, c c1, p p)
    {
        b(o1, c1, p);
    }

    static void a(g g1, Guest guest, OrderReview orderreview, AddressParams addressparams, c c1)
    {
        g1.a(guest, orderreview, addressparams, c1);
    }

    static boolean a(g g1, com.target.ui.helper.b b1, j j1, Guest guest, o o1)
    {
        return g1.a(b1, j1, guest, o1);
    }

    static int b()
    {
        return PRIMARY_REASON_INDEX;
    }

    static String b(g g1)
    {
        return g1.mRequestTag;
    }

    private void b(final Guest guest, final OrderReview orderReview, PaymentCardInformationModel paymentcardinformationmodel, final c listener)
    {
        orderReview = new d() {

            final g this$0;
            final Guest val$guest;
            final c val$listener;
            final OrderReview val$orderReview;

            public String a()
            {
                return com.target.ui.helper.c.g.b(g.this);
            }

            public void a(k k1)
            {
                com.target.mothership.model.guest.interfaces.a.k.a a1 = (com.target.mothership.model.guest.interfaces.a.k.a)k1.f().get(com.target.ui.helper.c.g.b());
                if (com.target.ui.helper.c.g.j(g.this, listener, a1, guest, (o)c().d()))
                {
                    return;
                }
                if (a1 == com.target.mothership.model.guest.interfaces.a.k.a.ERR_MEMBER_CARD_INFO_ID_INVALID)
                {
                    listener.c(orderReview);
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
                listener.c(orderReview);
            }

            public void b(Object obj)
            {
                a((k)obj);
            }

            
            {
                this$0 = g.this;
                listener = c1;
                orderReview = orderreview;
                guest = guest1;
                super();
            }
        };
        mGuestDataService.a(guest, paymentcardinformationmodel.d(), orderReview);
    }

    private void b(final Guest guest, final OrderReview orderReview, final PaymentCardInformationModel paymentCardInformationModel, final BillingCardDetailsModel billingCardDetailsModel, final boolean shouldApplyBillingAddressAsShippingAddress, final c listener)
    {
        listener = new d() {

            final g this$0;
            final BillingCardDetailsModel val$billingCardDetailsModel;
            final Guest val$guest;
            final c val$listener;
            final OrderReview val$orderReview;
            final PaymentCardInformationModel val$paymentCardInformationModel;
            final boolean val$shouldApplyBillingAddressAsShippingAddress;

            public String a()
            {
                return com.target.ui.helper.c.g.b(g.this);
            }

            public void a(com.target.mothership.model.cart.interfaces.a.d d1)
            {
                if (com.target.ui.helper.c.g.a(g.this, listener, (j)d1.f().get(com.target.ui.helper.c.g.b()), guest, (o)c().d()))
                {
                    return;
                } else
                {
                    listener.a(paymentCardInformationModel, d1);
                    return;
                }
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
                if (shouldApplyBillingAddressAsShippingAddress)
                {
                    com.target.ui.helper.c.g.a(g.this, guest, orderReview, billingCardDetailsModel.b(), listener);
                    return;
                } else
                {
                    com.target.ui.helper.c.g.a(g.this).c(guest, orderReview, new b(guest, listener));
                    return;
                }
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.cart.interfaces.a.d)obj);
            }

            
            {
                this$0 = g.this;
                shouldApplyBillingAddressAsShippingAddress = flag;
                guest = guest1;
                orderReview = orderreview;
                billingCardDetailsModel = billingcarddetailsmodel;
                listener = c1;
                paymentCardInformationModel = paymentcardinformationmodel;
                super();
            }
        };
        paymentCardInformationModel = paymentCardInformationModel.a().a().a();
        billingCardDetailsModel = billingCardDetailsModel.b();
        mCartDataService.a(guest, orderReview, paymentCardInformationModel, null, billingCardDetailsModel, listener);
    }

    private static void b(o o1, c c1, p p)
    {
        if (o1 != null && o1.c())
        {
            o1.a();
            return;
        } else
        {
            c1.a(p);
            return;
        }
    }

    static boolean b(g g1, com.target.ui.helper.b b1, j j1, Guest guest, o o1)
    {
        return g1.a(b1, j1, guest, o1);
    }

    static f c(g g1)
    {
        return g1.mGuestDataService;
    }

    static String c()
    {
        return LOG_TAG;
    }

    static boolean c(g g1, com.target.ui.helper.b b1, j j1, Guest guest, o o1)
    {
        return g1.a(b1, j1, guest, o1);
    }

    static boolean d(g g1, com.target.ui.helper.b b1, j j1, Guest guest, o o1)
    {
        return g1.a(b1, j1, guest, o1);
    }

    static boolean e(g g1, com.target.ui.helper.b b1, j j1, Guest guest, o o1)
    {
        return g1.a(b1, j1, guest, o1);
    }

    static boolean f(g g1, com.target.ui.helper.b b1, j j1, Guest guest, o o1)
    {
        return g1.a(b1, j1, guest, o1);
    }

    static boolean g(g g1, com.target.ui.helper.b b1, j j1, Guest guest, o o1)
    {
        return g1.a(b1, j1, guest, o1);
    }

    static boolean h(g g1, com.target.ui.helper.b b1, j j1, Guest guest, o o1)
    {
        return g1.a(b1, j1, guest, o1);
    }

    static boolean i(g g1, com.target.ui.helper.b b1, j j1, Guest guest, o o1)
    {
        return g1.a(b1, j1, guest, o1);
    }

    static boolean j(g g1, com.target.ui.helper.b b1, j j1, Guest guest, o o1)
    {
        return g1.a(b1, j1, guest, o1);
    }

    static boolean k(g g1, com.target.ui.helper.b b1, j j1, Guest guest, o o1)
    {
        return g1.a(b1, j1, guest, o1);
    }

    static boolean l(g g1, com.target.ui.helper.b b1, j j1, Guest guest, o o1)
    {
        return g1.a(b1, j1, guest, o1);
    }

    static boolean m(g g1, com.target.ui.helper.b b1, j j1, Guest guest, o o1)
    {
        return g1.a(b1, j1, guest, o1);
    }

    public void a()
    {
        mAccountService.a(mRequestTag);
        mCartDataService.a(mRequestTag);
        mGuestDataService.a(mRequestTag);
    }

    public void a(final Guest guest, final InitiatedCheckout initiatedCheckout, final PaymentCardInformationModel paymentCardInformationModel, String s, final c listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.k();
            return;
        } else
        {
            listener = new d() {

                final g this$0;
                final Guest val$guest;
                final InitiatedCheckout val$initiatedCheckout;
                final c val$listener;
                final PaymentCardInformationModel val$paymentCardInformationModel;

                public String a()
                {
                    return com.target.ui.helper.c.g.b(g.this);
                }

                public void a(com.target.mothership.model.cart.interfaces.a.d d1)
                {
                    if (com.target.ui.helper.c.g.k(g.this, listener, (j)d1.f().get(com.target.ui.helper.c.g.b()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(paymentCardInformationModel, d1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((Void)obj);
                }

                public void a(Void void1)
                {
                    com.target.ui.helper.c.g.a(g.this).c(guest, initiatedCheckout, new b(guest, listener));
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.cart.interfaces.a.d)obj);
                }

            
            {
                this$0 = g.this;
                guest = guest1;
                initiatedCheckout = initiatedcheckout;
                listener = c1;
                paymentCardInformationModel = paymentcardinformationmodel;
                super();
            }
            };
            com.target.mothership.common.tender.a a1 = paymentCardInformationModel.a().a().a();
            paymentCardInformationModel = paymentCardInformationModel.d();
            mCartDataService.a(guest, initiatedCheckout, a1, paymentCardInformationModel, s, listener);
            return;
        }
    }

    public void a(final Guest guest, final OrderReview orderReview, final BillingCardDetailsModel billingCardDetails, final boolean shouldApplyBillingAddressAsShippingAddress, final c listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.k();
            return;
        } else
        {
            CardDataModel carddatamodel = billingCardDetails.a();
            com.target.mothership.common.params.b b1 = com.target.ui.util.e.a(billingCardDetails);
            billingCardDetails = new d() {

                final g this$0;
                final BillingCardDetailsModel val$billingCardDetails;
                final Guest val$guest;
                final c val$listener;
                final OrderReview val$orderReview;
                final boolean val$shouldApplyBillingAddressAsShippingAddress;

                public String a()
                {
                    return com.target.ui.helper.c.g.b(g.this);
                }

                public void a(com.target.mothership.model.cart.interfaces.a.d d1)
                {
                    if (g.l(g.this, listener, (j)d1.f().get(com.target.ui.helper.c.g.b()), guest, (o)c().d()))
                    {
                        return;
                    } else
                    {
                        listener.a(d1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((Void)obj);
                }

                public void a(Void void1)
                {
                    if (shouldApplyBillingAddressAsShippingAddress)
                    {
                        com.target.ui.helper.c.g.a(g.this, guest, orderReview, billingCardDetails.b(), listener);
                        return;
                    } else
                    {
                        com.target.ui.helper.c.g.a(g.this).c(guest, orderReview, new b(guest, listener));
                        return;
                    }
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.cart.interfaces.a.d)obj);
                }

            
            {
                this$0 = g.this;
                shouldApplyBillingAddressAsShippingAddress = flag;
                guest = guest1;
                orderReview = orderreview;
                billingCardDetails = billingcarddetailsmodel;
                listener = c1;
                super();
            }
            };
            mCartDataService.a(guest, orderReview, b1, carddatamodel.f(), billingCardDetails);
            return;
        }
    }

    public void a(Guest guest, OrderReview orderreview, PaymentCardInformationModel paymentcardinformationmodel, c c1)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            c1.k();
        } else
        {
            boolean flag1 = paymentcardinformationmodel.b();
            boolean flag;
            if (!guest.isAnonymous())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag1 && flag)
            {
                a(guest, ((InitiatedCheckout) (orderreview)), paymentcardinformationmodel, c1);
                return;
            }
            if (flag)
            {
                b(guest, orderreview, paymentcardinformationmodel, c1);
                return;
            }
            if (flag1)
            {
                a(guest, ((InitiatedCheckout) (orderreview)), c1);
                return;
            }
        }
    }

    public void a(Guest guest, OrderReview orderreview, PaymentCardInformationModel paymentcardinformationmodel, BillingCardDetailsModel billingcarddetailsmodel, boolean flag, c c1)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            c1.k();
            return;
        }
        if (guest.isAnonymous())
        {
            b(guest, orderreview, paymentcardinformationmodel, billingcarddetailsmodel, flag, c1);
            return;
        }
        if (paymentcardinformationmodel.b())
        {
            a(guest, ((InitiatedCheckout) (orderreview)), paymentcardinformationmodel, billingcarddetailsmodel, c1);
            return;
        } else
        {
            a(guest, orderreview, paymentcardinformationmodel, billingcarddetailsmodel, c1);
            return;
        }
    }

    public void a(Guest guest, final o requestRetryable, final c listener)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            listener.k();
            return;
        } else
        {
            mAccountService.a(guest, new h() {

                final g this$0;
                final c val$listener;
                final o val$requestRetryable;

                public String a()
                {
                    return com.target.ui.helper.c.g.b(g.this);
                }

                public void a(Guest guest1)
                {
                    if (requestRetryable != null)
                    {
                        requestRetryable.a(guest1);
                        requestRetryable.a();
                    }
                    listener.b(guest1);
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
                    q.a(com.target.ui.helper.c.g.c(), (new StringBuilder()).append("Unable to refresh a new anonymous guest session:").append(x1).toString());
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
                this$0 = g.this;
                requestRetryable = o1;
                listener = c1;
                super();
            }
            });
            return;
        }
    }

    public void a(String s, final c listener)
    {
        listener = new d() {

            final g this$0;
            final c val$listener;

            public String a()
            {
                return com.target.ui.helper.c.g.b(g.this);
            }

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
                this$0 = g.this;
                listener = c1;
                super();
            }
        };
        (new com.target.mothership.model.c.c()).a(s, listener);
    }


    // Unreferenced inner class com/target/ui/helper/c/g$10

/* anonymous class */
    class _cls10 extends d
    {

        final g this$0;
        final d val$getOrderReviewTailCall;
        final Guest val$guest;
        final InitiatedCheckout val$initiatedCheckout;
        final c val$listener;

        public String a()
        {
            return com.target.ui.helper.c.g.b(g.this);
        }

        public void a(k k1)
        {
            com.target.mothership.model.guest.interfaces.a.k.a a1 = (com.target.mothership.model.guest.interfaces.a.k.a)k1.f().get(com.target.ui.helper.c.g.b());
            if (com.target.ui.helper.c.g.f(g.this, listener, a1, guest, (o)c().d()))
            {
                return;
            }
            if (a1 == com.target.mothership.model.guest.interfaces.a.k.a.ERR_MEMBER_CARD_INFO_ID_INVALID)
            {
                com.target.ui.helper.c.g.a(g.this).c(guest, initiatedCheckout, getOrderReviewTailCall);
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
            com.target.ui.helper.c.g.a(g.this).c(guest, initiatedCheckout, getOrderReviewTailCall);
        }

        public void b(Object obj)
        {
            a((k)obj);
        }

            
            {
                this$0 = g.this;
                guest = guest1;
                initiatedCheckout = initiatedcheckout;
                getOrderReviewTailCall = d1;
                listener = c1;
                super();
            }
    }


    // Unreferenced inner class com/target/ui/helper/c/g$12

/* anonymous class */
    class _cls12 extends d
    {

        final g this$0;
        final Guest val$guest;
        final c val$listener;

        public String a()
        {
            return com.target.ui.helper.c.g.b(g.this);
        }

        public void a(OrderReview orderreview)
        {
            listener.b(orderreview);
        }

        public void a(p p1)
        {
            if (com.target.ui.helper.c.g.h(g.this, listener, (j)p1.f().get(com.target.ui.helper.c.g.b()), guest, (o)c().d()))
            {
                return;
            } else
            {
                com.target.ui.helper.c.g.a((o)c().d(), listener, p1);
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
                this$0 = g.this;
                listener = c1;
                guest = guest1;
                super();
            }
    }


    // Unreferenced inner class com/target/ui/helper/c/g$9

/* anonymous class */
    class _cls9 extends d
    {

        final g this$0;
        final Guest val$guest;
        final c val$listener;

        public String a()
        {
            return com.target.ui.helper.c.g.b(g.this);
        }

        public void a(OrderReview orderreview)
        {
            listener.b(orderreview);
        }

        public void a(p p1)
        {
            if (com.target.ui.helper.c.g.e(g.this, listener, (j)p1.f().get(com.target.ui.helper.c.g.b()), guest, (o)c().d()))
            {
                return;
            } else
            {
                com.target.ui.helper.c.g.a((o)c().d(), listener, p1);
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
                this$0 = g.this;
                listener = c1;
                guest = guest1;
                super();
            }
    }

}
