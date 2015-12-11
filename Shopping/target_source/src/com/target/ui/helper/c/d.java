// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.c;

import com.target.mothership.model.cart.b.g;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.cart.interfaces.a.x;
import com.target.mothership.model.common.a.j;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.util.o;
import com.target.ui.helper.a;
import com.target.ui.helper.c;
import com.target.ui.model.checkout.EmailRecipientDetailsModel;
import com.target.ui.model.checkout.PickUpPersonDetailsModel;
import com.target.ui.model.checkout.SmsRecipientDetailsModel;
import com.target.ui.service.b;
import com.target.ui.util.e;
import java.util.ArrayList;
import java.util.List;

public class d extends com.target.ui.helper.a
{
    public static interface a
        extends c
    {

        public abstract void a(com.target.mothership.model.cart.interfaces.a.a a1);

        public abstract void a(x x);

        public abstract void b(com.target.mothership.model.cart.interfaces.a.a a1);

        public abstract void f(String s);
    }


    private static int PRIMARY_FAILURE_REASON_INDEX = 0;
    private final b mCartDataService = com.target.ui.service.b.a();
    private final List mEmailDeliveryProductList;
    private final EmailRecipientDetailsModel mEmailRecipientDetails;
    private final Guest mGuest;
    private final a mListener;
    private final OrderReview mOrderReview;
    private final List mPendingReceiverList = new ArrayList();
    private final PickUpPersonDetailsModel mPickUpPersonDetails;
    private final List mPickUpProductList;
    private final String mRequestTag = String.valueOf(hashCode());
    private final List mSmsDeliveryProductList;
    private final SmsRecipientDetailsModel mSmsRecipientDetails;
    private final String mTrackingEmail;

    public d(Guest guest, String s, OrderReview orderreview, List list, List list1, List list2, PickUpPersonDetailsModel pickuppersondetailsmodel, 
            EmailRecipientDetailsModel emailrecipientdetailsmodel, SmsRecipientDetailsModel smsrecipientdetailsmodel, a a1)
    {
        mGuest = guest;
        mTrackingEmail = s;
        mOrderReview = orderreview;
        mListener = a1;
        mPickUpProductList = list;
        mEmailDeliveryProductList = list1;
        mSmsDeliveryProductList = list2;
        mPickUpPersonDetails = pickuppersondetailsmodel;
        mEmailRecipientDetails = emailrecipientdetailsmodel;
        mSmsRecipientDetails = smsrecipientdetailsmodel;
    }

    static a a(d d1)
    {
        return d1.mListener;
    }

    private void a(com.target.mothership.model.d d1)
    {
        mPendingReceiverList.remove(d1);
        if (mPendingReceiverList.isEmpty())
        {
            mListener.f(mTrackingEmail);
        }
    }

    static void a(d d1, com.target.mothership.model.d d2)
    {
        d1.a(d2);
    }

    static boolean a(d d1, int l, c c1, j j1, Guest guest, com.target.mothership.services.o o1)
    {
        return d1.a(l, c1, j1, guest, o1);
    }

    static Guest b(d d1)
    {
        return d1.mGuest;
    }

    static boolean b(d d1, int l, c c1, j j1, Guest guest, com.target.mothership.services.o o1)
    {
        return d1.a(l, c1, j1, guest, o1);
    }

    static int c()
    {
        return PRIMARY_FAILURE_REASON_INDEX;
    }

    static String c(d d1)
    {
        return d1.mRequestTag;
    }

    static boolean c(d d1, int l, c c1, j j1, Guest guest, com.target.mothership.services.o o1)
    {
        return d1.a(l, c1, j1, guest, o1);
    }

    private boolean d()
    {
        return i() || j() || k();
    }

    private void e()
    {
        if (i())
        {
            f();
        }
        if (j())
        {
            g();
        }
        if (k())
        {
            h();
        }
    }

    private void f()
    {
        com.target.mothership.model.d d1 = new com.target.mothership.model.d() {

            final d this$0;

            public String a()
            {
                return com.target.ui.helper.c.d.c(d.this);
            }

            public void a(x x1)
            {
                com.target.mothership.model.cart.interfaces.a.x.a a1 = (com.target.mothership.model.cart.interfaces.a.x.a)x1.f().get(com.target.ui.helper.c.d.c());
                if (com.target.ui.helper.c.d.a(d.this, 51, com.target.ui.helper.c.d.a(d.this), a1, com.target.ui.helper.c.d.b(d.this), (com.target.mothership.services.o)c().d()))
                {
                    return;
                } else
                {
                    com.target.ui.helper.c.d.a(d.this).a(x1);
                    return;
                }
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
                com.target.ui.helper.c.d.a(d.this, this);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = d.this;
                super();
            }
        };
        mPendingReceiverList.add(d1);
        g g1 = new g(mPickUpPersonDetails.c(), mPickUpPersonDetails.d(), mPickUpPersonDetails.e(), null);
        if (mPickUpPersonDetails.a())
        {
            mCartDataService.a(mGuest, mOrderReview, g1, d1);
            return;
        } else
        {
            mCartDataService.b(mGuest, mOrderReview, g1, d1);
            return;
        }
    }

    private void g()
    {
        com.target.mothership.model.d d1 = new com.target.mothership.model.d() {

            final d this$0;

            public String a()
            {
                return com.target.ui.helper.c.d.c(d.this);
            }

            public void a(com.target.mothership.model.cart.interfaces.a.a a1)
            {
                com.target.mothership.model.cart.interfaces.a.a.a a2 = (com.target.mothership.model.cart.interfaces.a.a.a)a1.f().get(com.target.ui.helper.c.d.c());
                if (com.target.ui.helper.c.d.b(d.this, 51, com.target.ui.helper.c.d.a(d.this), a2, com.target.ui.helper.c.d.b(d.this), (com.target.mothership.services.o)c().d()))
                {
                    return;
                } else
                {
                    com.target.ui.helper.c.d.a(d.this).a(a1);
                    return;
                }
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
                com.target.ui.helper.c.d.a(d.this, this);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.cart.interfaces.a.a)obj);
            }

            
            {
                this$0 = d.this;
                super();
            }
        };
        mPendingReceiverList.add(d1);
        String s;
        String s1;
        b b1;
        Guest guest;
        List list;
        if (!o.g(mEmailRecipientDetails.b()) || !o.g(mEmailRecipientDetails.d()))
        {
            s = com.target.ui.util.e.b(mGuest, mOrderReview);
        } else
        {
            s = "Target Guest";
        }
        b1 = mCartDataService;
        guest = mGuest;
        list = mEmailDeliveryProductList;
        if (mEmailRecipientDetails.b() != null)
        {
            s1 = mEmailRecipientDetails.b();
        } else
        {
            s1 = s;
        }
        if (mEmailRecipientDetails.d() != null)
        {
            s = mEmailRecipientDetails.d();
        }
        b1.a(guest, list, s1, s, mEmailRecipientDetails.c(), d1);
    }

    private void h()
    {
        com.target.mothership.model.d d1 = new com.target.mothership.model.d() {

            final d this$0;

            public String a()
            {
                return com.target.ui.helper.c.d.c(d.this);
            }

            public void a(com.target.mothership.model.cart.interfaces.a.a a1)
            {
                com.target.mothership.model.cart.interfaces.a.a.a a2 = (com.target.mothership.model.cart.interfaces.a.a.a)a1.f().get(com.target.ui.helper.c.d.c());
                if (com.target.ui.helper.c.d.c(d.this, 51, com.target.ui.helper.c.d.a(d.this), a2, com.target.ui.helper.c.d.b(d.this), (com.target.mothership.services.o)c().d()))
                {
                    return;
                } else
                {
                    com.target.ui.helper.c.d.a(d.this).b(a1);
                    return;
                }
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
                com.target.ui.helper.c.d.a(d.this, this);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.cart.interfaces.a.a)obj);
            }

            
            {
                this$0 = d.this;
                super();
            }
        };
        mPendingReceiverList.add(d1);
        String s;
        String s1;
        b b1;
        Guest guest;
        List list;
        if (!o.g(mSmsRecipientDetails.b()) || !o.g(mSmsRecipientDetails.d()))
        {
            s = com.target.ui.util.e.b(mGuest, mOrderReview);
        } else
        {
            s = "Target Guest";
        }
        b1 = mCartDataService;
        guest = mGuest;
        list = mSmsDeliveryProductList;
        if (mSmsRecipientDetails.b() != null)
        {
            s1 = mSmsRecipientDetails.b();
        } else
        {
            s1 = s;
        }
        if (mSmsRecipientDetails.d() != null)
        {
            s = mSmsRecipientDetails.d();
        }
        b1.b(guest, list, s1, s, com.target.ui.util.d.b.g(mSmsRecipientDetails.c()), d1);
    }

    private boolean i()
    {
        return !mPickUpProductList.isEmpty() && mPickUpPersonDetails != null;
    }

    private boolean j()
    {
        return !mEmailDeliveryProductList.isEmpty() && mEmailRecipientDetails != null;
    }

    private boolean k()
    {
        return !mSmsDeliveryProductList.isEmpty() && mSmsRecipientDetails != null;
    }

    public void a()
    {
        if (mGuest == null)
        {
            return;
        }
        if (d())
        {
            e();
            return;
        } else
        {
            mListener.f(mTrackingEmail);
            return;
        }
    }

    public void b()
    {
        mCartDataService.a(mRequestTag);
    }

}
