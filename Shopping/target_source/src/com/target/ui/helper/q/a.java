// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.q;

import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.common.weeklyad.StoreSlug;
import com.target.mothership.model.h;
import com.target.mothership.model.weeklyad.c;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdHomepage;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingBase;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingDetail;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdPromotion;
import com.target.mothership.services.x;
import java.util.List;

public class com.target.ui.helper.q.a
{
    public static interface a
    {

        public abstract void a(WeeklyAdHomepage weeklyadhomepage, StoreSlug storeslug);

        public abstract void a(com.target.mothership.model.weeklyad.interfaces.a.b b1);

        public abstract void a(x x);
    }

    public static interface b
    {

        public abstract void a(WeeklyAdListingDetail weeklyadlistingdetail);

        public abstract void a_(x x);
    }

    public static interface c
    {

        public abstract void a(com.target.mothership.model.weeklyad.interfaces.a.a a1);

        public abstract void a(List list, WeeklyAdPromotion weeklyadpromotion, StoreSlug storeslug);
    }

    public static interface d
    {

        public abstract void a(StoreSlug storeslug);

        public abstract void a(com.target.mothership.model.weeklyad.interfaces.a.b b1);
    }


    public static final String TAG = com/target/ui/helper/q/a.getSimpleName();
    private final String mRequestTag = String.valueOf(hashCode());
    private com.target.mothership.model.weeklyad.c mWeeklyAdManager;

    public com.target.ui.helper.q.a()
    {
        mWeeklyAdManager = new com.target.mothership.model.weeklyad.c();
    }

    static String a(com.target.ui.helper.q.a a1)
    {
        return a1.mRequestTag;
    }

    public void a()
    {
        mWeeklyAdManager.a(mRequestTag);
    }

    public void a(StoreIdentifier storeidentifier, final PromotionRequest promotionRequest, final a listener)
    {
        a(storeidentifier, new d() {

            final com.target.ui.helper.q.a this$0;
            final a val$listener;
            final PromotionRequest val$promotionRequest;

            public void a(StoreSlug storeslug)
            {
                com.target.ui.helper.q.a.this.a(storeslug, promotionRequest, listener);
            }

            public void a(com.target.mothership.model.weeklyad.interfaces.a.b b1)
            {
                listener.a(b1);
            }

            
            {
                this$0 = com.target.ui.helper.q.a.this;
                promotionRequest = promotionrequest;
                listener = a2;
                super();
            }
        });
    }

    public void a(StoreIdentifier storeidentifier, final a listener)
    {
        a(storeidentifier, new d() {

            final com.target.ui.helper.q.a this$0;
            final a val$listener;

            public void a(StoreSlug storeslug)
            {
                com.target.ui.helper.q.a.this.a(storeslug, listener);
            }

            public void a(com.target.mothership.model.weeklyad.interfaces.a.b b1)
            {
                listener.a(b1);
            }

            
            {
                this$0 = com.target.ui.helper.q.a.this;
                listener = a2;
                super();
            }
        });
    }

    public void a(StoreIdentifier storeidentifier, final d listener)
    {
        mWeeklyAdManager.a(storeidentifier, new com.target.mothership.model.d() {

            final com.target.ui.helper.q.a this$0;
            final d val$listener;

            public String a()
            {
                return com.target.ui.helper.q.a.a(com.target.ui.helper.q.a.this);
            }

            public void a(StoreSlug storeslug)
            {
                listener.a(storeslug);
            }

            public void a(com.target.mothership.model.weeklyad.interfaces.a.b b1)
            {
                listener.a(b1);
            }

            public volatile void a(Object obj)
            {
                a((StoreSlug)obj);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.weeklyad.interfaces.a.b)obj);
            }

            
            {
                this$0 = com.target.ui.helper.q.a.this;
                listener = d1;
                super();
            }
        });
    }

    public void a(final StoreSlug storeSlug, PromotionRequest promotionrequest, final a listener)
    {
        mWeeklyAdManager.a(storeSlug, promotionrequest, new h() {

            final com.target.ui.helper.q.a this$0;
            final a val$listener;
            final StoreSlug val$storeSlug;

            public String a()
            {
                return com.target.ui.helper.q.a.a(com.target.ui.helper.q.a.this);
            }

            public void a(WeeklyAdHomepage weeklyadhomepage)
            {
                listener.a(weeklyadhomepage, storeSlug);
            }

            public void a(x x1)
            {
                listener.a(x1);
            }

            public volatile void a(Object obj)
            {
                a((WeeklyAdHomepage)obj);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = com.target.ui.helper.q.a.this;
                listener = a2;
                storeSlug = storeslug;
                super();
            }
        });
    }

    public void a(final StoreSlug storeSlug, final WeeklyAdPromotion weeklyAdPromotion, PromotionRequest promotionrequest, final c listener)
    {
        mWeeklyAdManager.a(storeSlug, promotionrequest, new com.target.mothership.model.d() {

            final com.target.ui.helper.q.a this$0;
            final c val$listener;
            final StoreSlug val$storeSlug;
            final WeeklyAdPromotion val$weeklyAdPromotion;

            public String a()
            {
                return com.target.ui.helper.q.a.a(com.target.ui.helper.q.a.this);
            }

            public void a(com.target.mothership.model.weeklyad.interfaces.a.a a1)
            {
                listener.a(a1);
            }

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                listener.a(list, weeklyAdPromotion, storeSlug);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.weeklyad.interfaces.a.a)obj);
            }

            
            {
                this$0 = com.target.ui.helper.q.a.this;
                listener = c1;
                weeklyAdPromotion = weeklyadpromotion;
                storeSlug = storeslug;
                super();
            }
        });
    }

    public void a(final StoreSlug storeSlug, final a listener)
    {
        mWeeklyAdManager.a(storeSlug, new h() {

            final com.target.ui.helper.q.a this$0;
            final a val$listener;
            final StoreSlug val$storeSlug;

            public String a()
            {
                return com.target.ui.helper.q.a.a(com.target.ui.helper.q.a.this);
            }

            public void a(WeeklyAdHomepage weeklyadhomepage)
            {
                listener.a(weeklyadhomepage, storeSlug);
            }

            public void a(x x1)
            {
                listener.a(x1);
            }

            public volatile void a(Object obj)
            {
                a((WeeklyAdHomepage)obj);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = com.target.ui.helper.q.a.this;
                listener = a2;
                storeSlug = storeslug;
                super();
            }
        });
    }

    public void a(WeeklyAdListingBase weeklyadlistingbase, PromotionRequest promotionrequest, final b listener)
    {
        mWeeklyAdManager.a(weeklyadlistingbase.c(), promotionrequest, new h() {

            final com.target.ui.helper.q.a this$0;
            final b val$listener;

            public String a()
            {
                return com.target.ui.helper.q.a.a(com.target.ui.helper.q.a.this);
            }

            public void a(WeeklyAdListingDetail weeklyadlistingdetail)
            {
                listener.a(weeklyadlistingdetail);
            }

            public void a(x x1)
            {
                listener.a_(x1);
            }

            public volatile void a(Object obj)
            {
                a((WeeklyAdListingDetail)obj);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = com.target.ui.helper.q.a.this;
                listener = b1;
                super();
            }
        });
    }

}
