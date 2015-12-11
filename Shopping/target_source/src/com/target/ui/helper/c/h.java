// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.c;

import com.google.a.a.e;
import com.target.mothership.model.cart.interfaces.InitiatedCheckout;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.cart.interfaces.UsableTenders;
import com.target.mothership.model.cart.interfaces.a.n;
import com.target.mothership.model.cart.interfaces.a.p;
import com.target.mothership.model.common.AppliedPaymentCardTender;
import com.target.mothership.model.common.a.j;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.o;
import com.target.ui.helper.a;
import com.target.ui.helper.c;
import com.target.ui.model.checkout.BillingCardDetailsModel;
import com.target.ui.model.checkout.CardDataModel;
import com.target.ui.model.checkout.PaymentCardInformationModel;
import com.target.ui.service.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class h extends com.target.ui.helper.a
{
    private final class a extends d
    {

        private final PaymentCardInformationModel card;
        private final InitiatedCheckout initiatedCheckout;
        private final WeakReference listenerRef;
        private final d orderReviewTailCall;
        private final Guest session;
        final h this$0;

        static WeakReference a(a a1)
        {
            return a1.listenerRef;
        }

        static Guest b(a a1)
        {
            return a1.session;
        }

        public String a()
        {
            return com.target.ui.helper.c.h.a(h.this);
        }

        public void a(com.target.mothership.model.cart.interfaces.a.d d1)
        {
            b b1;
            for (b1 = (b)listenerRef.get(); b1 == null || com.target.ui.helper.c.h.b(h.this, 0, b1, d1.e(), session, (o)c().d());)
            {
                return;
            }

            b1.a(card, d1);
        }

        public volatile void a(Object obj)
        {
            a((Void)obj);
        }

        public void a(Void void1)
        {
            com.target.ui.helper.c.h.b(h.this).c(session, initiatedCheckout, orderReviewTailCall);
        }

        public void b(Object obj)
        {
            a((com.target.mothership.model.cart.interfaces.a.d)obj);
        }

        private a(Guest guest, InitiatedCheckout initiatedcheckout, PaymentCardInformationModel paymentcardinformationmodel, b b1)
        {
            this$0 = h.this;
            super();
            orderReviewTailCall = new _cls1();
            session = guest;
            initiatedCheckout = initiatedcheckout;
            card = paymentcardinformationmodel;
            listenerRef = new WeakReference(b1);
        }

    }

    public static interface b
        extends c
    {

        public abstract void a(OrderReview orderreview);

        public abstract void a(n n);

        public abstract void a(p p);

        public abstract void a(PaymentCardInformationModel paymentcardinformationmodel, com.target.mothership.model.cart.interfaces.a.d d);

        public abstract void c();

        public abstract void c(List list);
    }


    private com.target.ui.service.b mCartDataService;
    private final String mRequestTag = String.valueOf(hashCode());

    public h()
    {
        mCartDataService = com.target.ui.service.b.a();
    }

    static String a(h h1)
    {
        return h1.mRequestTag;
    }

    private void a(Guest guest, InitiatedCheckout initiatedcheckout, PaymentCardInformationModel paymentcardinformationmodel, b b1)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            b1.c();
            return;
        } else
        {
            mCartDataService.a(guest, initiatedcheckout, paymentcardinformationmodel.d(), new a(guest, initiatedcheckout, paymentcardinformationmodel, b1));
            return;
        }
    }

    static void a(o o1, b b1, p p)
    {
        b(o1, b1, p);
    }

    static boolean a(h h1, int i, c c1, j j, Guest guest, o o1)
    {
        return h1.a(i, c1, j, guest, o1);
    }

    static com.target.ui.service.b b(h h1)
    {
        return h1.mCartDataService;
    }

    private void b(Guest guest, InitiatedCheckout initiatedcheckout, PaymentCardInformationModel paymentcardinformationmodel, String s, b b1)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            b1.c();
            return;
        } else
        {
            mCartDataService.a(guest, initiatedcheckout, paymentcardinformationmodel.a().a().a(), paymentcardinformationmodel.d(), s, new a(guest, initiatedcheckout, paymentcardinformationmodel, b1));
            return;
        }
    }

    private static void b(o o1, b b1, p p)
    {
        if (o1 != null && o1.c())
        {
            o1.a();
            return;
        } else
        {
            b1.a(p);
            return;
        }
    }

    static boolean b(h h1, int i, c c1, j j, Guest guest, o o1)
    {
        return h1.a(i, c1, j, guest, o1);
    }

    static boolean c(h h1, int i, c c1, j j, Guest guest, o o1)
    {
        return h1.a(i, c1, j, guest, o1);
    }

    public void a(final Guest currentSession, InitiatedCheckout initiatedcheckout, final b listener)
    {
        listener = new d() {

            final h this$0;
            final Guest val$currentSession;
            final b val$listener;

            public String a()
            {
                return com.target.ui.helper.c.h.a(h.this);
            }

            public void a(UsableTenders usabletenders)
            {
                PaymentCardInformationModel paymentcardinformationmodel = com.target.ui.util.e.a((AppliedPaymentCardTender)usabletenders.b().d());
                usabletenders = com.target.ui.util.e.a(usabletenders.a());
                ArrayList arraylist = new ArrayList(usabletenders.size() + 1);
                if (paymentcardinformationmodel != null)
                {
                    arraylist.add(paymentcardinformationmodel);
                }
                arraylist.addAll(usabletenders);
                listener.c(arraylist);
            }

            public void a(n n1)
            {
                if (com.target.ui.helper.c.h.a(h.this, 30, listener, n1.e(), currentSession, (o)c().d()))
                {
                    return;
                } else
                {
                    listener.a(n1);
                    return;
                }
            }

            public volatile void a(Object obj)
            {
                a((UsableTenders)obj);
            }

            public void b(Object obj)
            {
                a((n)obj);
            }

            
            {
                this$0 = h.this;
                listener = b1;
                currentSession = guest;
                super();
            }
        };
        mCartDataService.d(currentSession, initiatedcheckout, listener);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, PaymentCardInformationModel paymentcardinformationmodel, String s, b b1)
    {
        if (com.target.mothership.util.o.e(s))
        {
            a(guest, initiatedcheckout, paymentcardinformationmodel, b1);
            return;
        } else
        {
            b(guest, initiatedcheckout, paymentcardinformationmodel, s, b1);
            return;
        }
    }

    // Unreferenced inner class com/target/ui/helper/c/h$a$1

/* anonymous class */
    class a._cls1 extends d
    {

        final a this$1;

        public String a()
        {
            return com.target.ui.helper.c.h.a(_fld0);
        }

        public void a(OrderReview orderreview)
        {
            b b1 = (b)com.target.ui.helper.c.a.a(a.this).get();
            if (b1 == null)
            {
                return;
            } else
            {
                b1.a(orderreview);
                return;
            }
        }

        public void a(p p1)
        {
            b b1;
            for (b1 = (b)com.target.ui.helper.c.a.a(a.this).get(); b1 == null || com.target.ui.helper.c.h.c(_fld0, 0, b1, p1.e(), com.target.ui.helper.c.a.b(a.this), (o)c().d());)
            {
                return;
            }

            com.target.ui.helper.c.h.a((o)c().d(), b1, p1);
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
                this$1 = a.this;
                super();
            }
    }

}
