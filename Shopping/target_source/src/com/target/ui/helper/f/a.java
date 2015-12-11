// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.f;

import com.target.mothership.model.coupons.interfaces.CompletedSignUp;
import com.target.mothership.model.coupons.interfaces.RegisteredPhone;
import com.target.mothership.model.coupons.interfaces.a.d;
import com.target.mothership.model.coupons.params.CouponsSignUpParams;
import com.target.ui.service.c;
import java.util.List;

public class com.target.ui.helper.f.a
{
    public static interface a
    {

        public abstract void a(com.target.mothership.model.coupons.interfaces.a.a a1);

        public abstract void a(com.target.mothership.model.coupons.interfaces.a.c c1);

        public abstract void a(Void void1);

        public abstract void a(List list);
    }

    public static interface b
    {

        public abstract void a(RegisteredPhone registeredphone);

        public abstract void a(d d1);
    }

    public static interface c
    {

        public abstract void a(CompletedSignUp completedsignup);

        public abstract void a(com.target.mothership.model.coupons.interfaces.a.b b1);
    }


    private com.target.ui.service.c mCouponDataService;
    private a mCouponOfferListener;
    private b mRegisterListener;
    private final String mRequestTag;
    private c mSignUpListener;

    public com.target.ui.helper.f.a(a a1)
    {
        mCouponOfferListener = a1;
        mCouponDataService = com.target.ui.service.c.a();
        mRequestTag = String.valueOf(hashCode());
    }

    public com.target.ui.helper.f.a(b b1)
    {
        mRegisterListener = b1;
        mCouponDataService = com.target.ui.service.c.a();
        mRequestTag = String.valueOf(hashCode());
    }

    public com.target.ui.helper.f.a(c c1)
    {
        mSignUpListener = c1;
        mCouponDataService = com.target.ui.service.c.a();
        mRequestTag = String.valueOf(hashCode());
    }

    static b a(com.target.ui.helper.f.a a1)
    {
        return a1.mRegisterListener;
    }

    static String b(com.target.ui.helper.f.a a1)
    {
        return a1.mRequestTag;
    }

    static c c(com.target.ui.helper.f.a a1)
    {
        return a1.mSignUpListener;
    }

    static a d(com.target.ui.helper.f.a a1)
    {
        return a1.mCouponOfferListener;
    }

    public void a(CompletedSignUp completedsignup)
    {
        mCouponDataService.b(completedsignup, new com.target.mothership.model.d() {

            final com.target.ui.helper.f.a this$0;

            public String a()
            {
                return com.target.ui.helper.f.a.b(com.target.ui.helper.f.a.this);
            }

            public void a(com.target.mothership.model.coupons.interfaces.a.c c1)
            {
                com.target.ui.helper.f.a.d(com.target.ui.helper.f.a.this).a(c1);
            }

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                com.target.ui.helper.f.a.d(com.target.ui.helper.f.a.this).a(list);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.coupons.interfaces.a.c)obj);
            }

            
            {
                this$0 = com.target.ui.helper.f.a.this;
                super();
            }
        });
    }

    public void a(CompletedSignUp completedsignup, String s)
    {
        mCouponDataService.a(completedsignup, s, new com.target.mothership.model.d() {

            final com.target.ui.helper.f.a this$0;

            public void a(com.target.mothership.model.coupons.interfaces.a.a a1)
            {
                com.target.ui.helper.f.a.d(com.target.ui.helper.f.a.this).a(a1);
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
                com.target.ui.helper.f.a.d(com.target.ui.helper.f.a.this).a(void1);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.coupons.interfaces.a.a)obj);
            }

            
            {
                this$0 = com.target.ui.helper.f.a.this;
                super();
            }
        });
    }

    public void a(RegisteredPhone registeredphone, String s, CouponsSignUpParams couponssignupparams)
    {
        mCouponDataService.a(registeredphone, s, couponssignupparams, new com.target.mothership.model.d() {

            final com.target.ui.helper.f.a this$0;

            public String a()
            {
                return com.target.ui.helper.f.a.b(com.target.ui.helper.f.a.this);
            }

            public void a(CompletedSignUp completedsignup)
            {
                com.target.ui.helper.f.a.c(com.target.ui.helper.f.a.this).a(completedsignup);
            }

            public void a(com.target.mothership.model.coupons.interfaces.a.b b1)
            {
                com.target.ui.helper.f.a.c(com.target.ui.helper.f.a.this).a(b1);
            }

            public volatile void a(Object obj)
            {
                a((CompletedSignUp)obj);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.coupons.interfaces.a.b)obj);
            }

            
            {
                this$0 = com.target.ui.helper.f.a.this;
                super();
            }
        });
    }

    public void a(String s)
    {
        mCouponDataService.a(s, new com.target.mothership.model.d() {

            final com.target.ui.helper.f.a this$0;

            public String a()
            {
                return com.target.ui.helper.f.a.b(com.target.ui.helper.f.a.this);
            }

            public void a(RegisteredPhone registeredphone)
            {
                com.target.ui.helper.f.a.a(com.target.ui.helper.f.a.this).a(registeredphone);
            }

            public void a(d d1)
            {
                com.target.ui.helper.f.a.a(com.target.ui.helper.f.a.this).a(d1);
            }

            public volatile void a(Object obj)
            {
                a((RegisteredPhone)obj);
            }

            public void b(Object obj)
            {
                a((d)obj);
            }

            
            {
                this$0 = com.target.ui.helper.f.a.this;
                super();
            }
        });
    }

    public void b(CompletedSignUp completedsignup)
    {
        mCouponDataService.a(completedsignup, new com.target.mothership.model.d() {

            final com.target.ui.helper.f.a this$0;

            public String a()
            {
                return com.target.ui.helper.f.a.b(com.target.ui.helper.f.a.this);
            }

            public void a(com.target.mothership.model.coupons.interfaces.a.c c1)
            {
                com.target.ui.helper.f.a.d(com.target.ui.helper.f.a.this).a(c1);
            }

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                com.target.ui.helper.f.a.d(com.target.ui.helper.f.a.this).a(list);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.coupons.interfaces.a.c)obj);
            }

            
            {
                this$0 = com.target.ui.helper.f.a.this;
                super();
            }
        });
    }
}
