// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons;

import com.target.mothership.model.coupons.a.k;
import com.target.mothership.model.coupons.handler.f;
import com.target.mothership.model.coupons.handler.g;
import com.target.mothership.model.coupons.handler.i;
import com.target.mothership.model.coupons.handler.j;
import com.target.mothership.model.coupons.interfaces.AvailableCouponOffer;
import com.target.mothership.model.coupons.interfaces.CompletedSignUp;
import com.target.mothership.model.coupons.interfaces.RegisteredPhone;
import com.target.mothership.model.coupons.params.CouponsSignUpParams;
import com.target.mothership.model.d;
import com.target.mothership.model.e;
import com.target.mothership.model.h;
import com.target.mothership.services.b.a.c.a;
import java.util.List;

// Referenced classes of package com.target.mothership.model.coupons:
//            a

class com.target.mothership.model.coupons.b
    implements com.target.mothership.model.coupons.a
{
    private final class a extends com.target.mothership.model.d
    {

        private com.target.mothership.model.d postCallback;
        final com.target.mothership.model.coupons.b this$0;

        public String a()
        {
            return postCallback.a();
        }

        public void a(CompletedSignUp completedsignup)
        {
            postCallback.a(completedsignup);
        }

        public void a(com.target.mothership.model.coupons.interfaces.a.b b1)
        {
            postCallback.b(b1);
        }

        public volatile void a(Object obj)
        {
            a((CompletedSignUp)obj);
        }

        public void b(Object obj)
        {
            a((com.target.mothership.model.coupons.interfaces.a.b)obj);
        }

        a(com.target.mothership.model.d d1)
        {
            this$0 = com.target.mothership.model.coupons.b.this;
            super();
            postCallback = d1;
        }
    }

    private final class b extends com.target.mothership.model.d
    {

        private final CompletedSignUp completedSignUp;
        private com.target.mothership.model.d postCallback;
        final com.target.mothership.model.coupons.b this$0;

        public String a()
        {
            return postCallback.a();
        }

        public void a(CompletedSignUp completedsignup)
        {
            com.target.mothership.model.coupons.b.this.b(completedSignUp, postCallback);
        }

        public void a(com.target.mothership.model.coupons.interfaces.a.b b1)
        {
            com.target.mothership.model.coupons.b.this.b(completedSignUp, postCallback);
        }

        public volatile void a(Object obj)
        {
            a((CompletedSignUp)obj);
        }

        public void b(Object obj)
        {
            a((com.target.mothership.model.coupons.interfaces.a.b)obj);
        }

        public b(CompletedSignUp completedsignup, com.target.mothership.model.d d1)
        {
            this$0 = com.target.mothership.model.coupons.b.this;
            super();
            postCallback = d1;
            completedSignUp = completedsignup;
        }
    }

    private final class c extends com.target.mothership.model.d
    {

        private com.target.mothership.model.d postCallback;
        final com.target.mothership.model.coupons.b this$0;

        public String a()
        {
            return postCallback.a();
        }

        public void a(CompletedSignUp completedsignup)
        {
            c(completedsignup, postCallback);
        }

        public void a(com.target.mothership.model.coupons.interfaces.a.b b1)
        {
            postCallback.b(b1);
        }

        public volatile void a(Object obj)
        {
            a((CompletedSignUp)obj);
        }

        public void b(Object obj)
        {
            a((com.target.mothership.model.coupons.interfaces.a.b)obj);
        }

        c(com.target.mothership.model.d d1)
        {
            this$0 = com.target.mothership.model.coupons.b.this;
            super();
            postCallback = d1;
        }
    }

    private final class d extends com.target.mothership.model.d
    {

        private com.target.mothership.model.d postCallback;
        final com.target.mothership.model.coupons.b this$0;

        public String a()
        {
            return postCallback.a();
        }

        public void a(com.target.mothership.model.coupons.interfaces.a.c c1)
        {
            postCallback.b(c1);
        }

        public volatile void a(Object obj)
        {
            a((List)obj);
        }

        public void a(List list)
        {
            postCallback.a(list);
        }

        public void b(Object obj)
        {
            a((com.target.mothership.model.coupons.interfaces.a.c)obj);
        }

        d(com.target.mothership.model.d d1)
        {
            this$0 = com.target.mothership.model.coupons.b.this;
            super();
            postCallback = d1;
        }
    }

    private final class e extends com.target.mothership.model.d
    {

        private com.target.mothership.model.d postCallback;
        private final CouponsSignUpParams signUpParams;
        final com.target.mothership.model.coupons.b this$0;

        public String a()
        {
            return postCallback.a();
        }

        public void a(com.target.mothership.model.coupons.interfaces.a.b b1)
        {
            postCallback.b(b1);
        }

        public volatile void a(Object obj)
        {
            a((String)obj);
        }

        public void a(String s)
        {
            com.target.mothership.model.coupons.b.this.a(s, signUpParams, postCallback);
        }

        public void b(Object obj)
        {
            a((com.target.mothership.model.coupons.interfaces.a.b)obj);
        }

        public e(CouponsSignUpParams couponssignupparams, com.target.mothership.model.d d1)
        {
            this$0 = com.target.mothership.model.coupons.b.this;
            super();
            postCallback = d1;
            signUpParams = couponssignupparams;
        }
    }


    private final com.target.mothership.services.b.a.c.a mServices = new com.target.mothership.services.b.a.c.a();

    public com.target.mothership.model.coupons.b()
    {
    }

    public void a(CompletedSignUp completedsignup, AvailableCouponOffer availablecouponoffer, com.target.mothership.model.d d1)
    {
        a(completedsignup, availablecouponoffer.a(), d1);
    }

    public void a(CompletedSignUp completedsignup, com.target.mothership.model.d d1)
    {
        c(completedsignup, new b(completedsignup, new d(d1)));
    }

    public void a(CompletedSignUp completedsignup, h h1)
    {
        completedsignup = new com.target.mothership.model.e(new g(h1));
        String s = com.target.mothership.cache.b.getInstance().getValidCouponAccessKey();
        k k1 = new k(s);
        if (k1.a())
        {
            h1.a(k1.b());
            return;
        } else
        {
            mServices.a(s, completedsignup);
            return;
        }
    }

    public void a(CompletedSignUp completedsignup, String s, com.target.mothership.model.d d1)
    {
        Object obj = com.target.mothership.cache.b.getInstance();
        if (completedsignup != null)
        {
            completedsignup = ((com.target.mothership.cache.b) (obj)).getValidCouponAccessKey();
        } else
        {
            completedsignup = null;
        }
        obj = new com.target.mothership.model.coupons.a.a(completedsignup);
        if (((com.target.mothership.model.coupons.a.a) (obj)).a())
        {
            d1.b(((com.target.mothership.model.coupons.a.a) (obj)).b());
            return;
        } else
        {
            d1 = new com.target.mothership.model.e(new com.target.mothership.model.coupons.handler.a(completedsignup, d1));
            mServices.b(completedsignup, s, d1);
            return;
        }
    }

    public void a(RegisteredPhone registeredphone, String s, CouponsSignUpParams couponssignupparams, com.target.mothership.model.d d1)
    {
        a(registeredphone, s, ((com.target.mothership.model.d) (new e(couponssignupparams, new c(new a(d1))))));
    }

    public void a(RegisteredPhone registeredphone, String s, com.target.mothership.model.d d1)
    {
        d1 = new com.target.mothership.model.e(new j(d1));
        mServices.a(registeredphone.a(), s, d1);
    }

    public void a(String s, CouponsSignUpParams couponssignupparams, com.target.mothership.model.d d1)
    {
        com.target.mothership.model.coupons.a.d d2 = new com.target.mothership.model.coupons.a.d(s);
        if (d2.a())
        {
            d1.b(d2.b());
            return;
        } else
        {
            d1 = new com.target.mothership.model.e(new i(s, d1));
            s = new com.target.mothership.services.b.a.a.b(s, couponssignupparams.a(), couponssignupparams.b(), couponssignupparams.c(), couponssignupparams.d(), couponssignupparams.e());
            mServices.a(s, d1);
            return;
        }
    }

    public void a(String s, com.target.mothership.model.d d1)
    {
        d1 = new com.target.mothership.model.e(new com.target.mothership.model.coupons.handler.h(s, d1));
        mServices.b(s, d1);
    }

    public void b(CompletedSignUp completedsignup, com.target.mothership.model.d d1)
    {
        Object obj = com.target.mothership.cache.b.getInstance();
        if (completedsignup != null)
        {
            completedsignup = ((com.target.mothership.cache.b) (obj)).getValidCouponAccessKey();
        } else
        {
            completedsignup = null;
        }
        obj = new com.target.mothership.model.coupons.a.e(completedsignup);
        if (((com.target.mothership.model.coupons.a.e) (obj)).a())
        {
            d1.b(((com.target.mothership.model.coupons.a.e) (obj)).b());
            return;
        } else
        {
            d1 = new com.target.mothership.model.e(new f(d1));
            mServices.d(completedsignup, d1);
            return;
        }
    }

    public void c(CompletedSignUp completedsignup, com.target.mothership.model.d d1)
    {
        Object obj = com.target.mothership.cache.b.getInstance();
        com.target.mothership.model.coupons.a.d d2;
        if (completedsignup != null)
        {
            obj = ((com.target.mothership.cache.b) (obj)).getValidCouponAccessKey();
        } else
        {
            obj = null;
        }
        d2 = new com.target.mothership.model.coupons.a.d(((String) (obj)));
        if (d2.a())
        {
            d1.b(d2.b());
            return;
        } else
        {
            completedsignup = new com.target.mothership.model.e(new com.target.mothership.model.coupons.handler.b(completedsignup, d1));
            mServices.c(((String) (obj)), completedsignup);
            return;
        }
    }
}
