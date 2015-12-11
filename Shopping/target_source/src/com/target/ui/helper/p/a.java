// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.p;

import com.google.a.a.e;
import com.target.mothership.common.params.ProductDealsParam;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.model.coupons.interfaces.AvailableCouponOffer;
import com.target.mothership.model.coupons.interfaces.CompletedSignUp;
import com.target.mothership.model.h;
import com.target.mothership.model.product.c;
import com.target.mothership.model.product.interfaces.ProductSummaryWrapper;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.x;
import com.target.mothership.services.z;
import com.target.ui.helper.q.b;
import com.target.ui.model.shop.AggregateDealsData;
import com.target.ui.model.shop.TGTAggregateDealsData;
import com.target.ui.util.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class com.target.ui.helper.p.a
{
    public static interface a
    {

        public abstract void a(AvailableCouponOffer availablecouponoffer);

        public abstract void a(com.target.mothership.model.coupons.interfaces.a.a a1, AvailableCouponOffer availablecouponoffer);
    }

    public static interface b
    {

        public abstract void a(c c1);

        public abstract void a(AggregateDealsData aggregatedealsdata);
    }

    public class c
    {

        private List mTargetNetworkErrors;
        final com.target.ui.helper.p.a this$0;

        public int a()
        {
            return mTargetNetworkErrors.size();
        }

        public void a(x x)
        {
            mTargetNetworkErrors.add(x);
        }

        public c()
        {
            this$0 = com.target.ui.helper.p.a.this;
            super();
            mTargetNetworkErrors = new ArrayList();
        }
    }

    public static interface d
    {

        public abstract void a(ProductSummaryWrapper productsummarywrapper);

        public abstract void a(x x);
    }


    private static final int NUM_INDEPENDENT_REQUEST = 3;
    public static final String TAG = com/target/ui/helper/p/a.getSimpleName();
    private List mCachedCouponOffers;
    private Store mCachedStore;
    private List mCachedWeeklyAdData;
    private boolean mCachingEnabled;
    private com.target.mothership.model.coupons.c mCouponsManager;
    private long mLastCancellationNanoTime;
    private com.target.mothership.model.product.c mProductManager;
    private final String mRequestTag;
    private com.target.ui.helper.q.b mWeeklyAdFullDataHelper;

    public com.target.ui.helper.p.a()
    {
        this(new com.target.mothership.model.product.c(), new com.target.mothership.model.coupons.c(), new com.target.ui.helper.q.b());
    }

    public com.target.ui.helper.p.a(com.target.mothership.model.product.c c1, com.target.mothership.model.coupons.c c2, com.target.ui.helper.q.b b1)
    {
        mCachingEnabled = false;
        mLastCancellationNanoTime = -1L;
        mRequestTag = String.valueOf(hashCode());
        mProductManager = c1;
        mCouponsManager = c2;
        mWeeklyAdFullDataHelper = b1;
    }

    static Store a(com.target.ui.helper.p.a a1, Store store)
    {
        a1.mCachedStore = store;
        return store;
    }

    static String a(com.target.ui.helper.p.a a1)
    {
        return a1.mRequestTag;
    }

    static List a(com.target.ui.helper.p.a a1, List list)
    {
        a1.mCachedCouponOffers = list;
        return list;
    }

    private void a(Store store, ProductSummaryParam productsummaryparam, final com.target.ui.helper.d.a pendingResult, final b listener)
    {
        if (productsummaryparam == null)
        {
            productsummaryparam = a(store);
        }
        mProductManager.a(productsummaryparam, new h() {

            final com.target.ui.helper.p.a this$0;
            final b val$listener;
            final com.target.ui.helper.d.a val$pendingResult;

            public String a()
            {
                return com.target.ui.helper.p.a.a(com.target.ui.helper.p.a.this);
            }

            public void a(ProductSummaryWrapper productsummarywrapper)
            {
                ((TGTAggregateDealsData)pendingResult.c()).a(productsummarywrapper);
                com.target.ui.helper.p.a.a(com.target.ui.helper.p.a.this, pendingResult, listener);
            }

            public void a(x x1)
            {
                if (!z.NOT_FOUND.equals(x1.b()))
                {
                    ((c)pendingResult.b()).a(x1);
                }
                com.target.ui.helper.p.a.a(com.target.ui.helper.p.a.this, pendingResult, listener);
            }

            public volatile void a(Object obj)
            {
                a((ProductSummaryWrapper)obj);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = com.target.ui.helper.p.a.this;
                pendingResult = a2;
                listener = b1;
                super();
            }
        });
    }

    private void a(final Store store, PromotionRequest promotionrequest, final com.target.ui.helper.d.a pendingResult, final b listener)
    {
        if (store == null)
        {
            ((TGTAggregateDealsData)pendingResult.c()).b(new ArrayList());
            a(pendingResult, listener);
            return;
        }
        if (mCachingEnabled && mCachedStore != null && mCachedStore.getStoreId().equals(store.getStoreId()) && mCachedWeeklyAdData != null)
        {
            ((TGTAggregateDealsData)pendingResult.c()).b(mCachedWeeklyAdData);
            a(pendingResult, listener);
            return;
        } else
        {
            mWeeklyAdFullDataHelper.a(store.getStoreId(), promotionrequest, new com.target.ui.helper.q.b.b() {

                final com.target.ui.helper.p.a this$0;
                final b val$listener;
                final com.target.ui.helper.d.a val$pendingResult;
                final Store val$store;

                public void a(com.target.mothership.model.weeklyad.interfaces.a.b b1)
                {
                    ((c)pendingResult.b()).a(b1.d());
                    com.target.ui.helper.p.a.a(com.target.ui.helper.p.a.this, pendingResult, listener);
                }

                public void a(com.target.ui.helper.q.b.a a1, List list)
                {
                    x x1;
                    for (list = a1.b().iterator(); list.hasNext(); ((c)pendingResult.b()).a(x1))
                    {
                        x1 = (x)list.next();
                    }

                    for (a1 = a1.a().iterator(); a1.hasNext(); ((c)pendingResult.b()).a(list.d()))
                    {
                        list = (com.target.mothership.model.weeklyad.interfaces.a.a)a1.next();
                    }

                    com.target.ui.helper.p.a.a(com.target.ui.helper.p.a.this, pendingResult, listener);
                }

                public void a(List list)
                {
                    com.target.ui.helper.p.a.a(com.target.ui.helper.p.a.this, store);
                    com.target.ui.helper.p.a.b(com.target.ui.helper.p.a.this, list);
                    ((TGTAggregateDealsData)pendingResult.c()).b(list);
                    com.target.ui.helper.p.a.a(com.target.ui.helper.p.a.this, pendingResult, listener);
                }

            
            {
                this$0 = com.target.ui.helper.p.a.this;
                store = store1;
                pendingResult = a2;
                listener = b1;
                super();
            }
            });
            return;
        }
    }

    private void a(com.target.ui.helper.d.a a1, b b1)
    {
        while (a1.a() > 0 || a(a1.d())) 
        {
            return;
        }
        if (((c)a1.b()).a() > 0)
        {
            b1.a((c)a1.b());
            return;
        } else
        {
            b1.a((AggregateDealsData)a1.c());
            return;
        }
    }

    static void a(com.target.ui.helper.p.a a1, com.target.ui.helper.d.a a2, b b1)
    {
        a1.a(a2, b1);
    }

    private boolean a(long l)
    {
        boolean flag;
        if (l < mLastCancellationNanoTime)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            q.c(TAG, String.format("Flagged canceled request. Request/Cancellation time : %s/%s", new Object[] {
                Long.valueOf(l), Long.valueOf(mLastCancellationNanoTime)
            }));
        }
        return flag;
    }

    static boolean a(com.target.ui.helper.p.a a1, long l)
    {
        return a1.a(l);
    }

    static List b(com.target.ui.helper.p.a a1, List list)
    {
        a1.mCachedWeeklyAdData = list;
        return list;
    }

    private void b(final com.target.ui.helper.d.a pendingResult, final b listener)
    {
        CompletedSignUp completedsignup = (CompletedSignUp)mCouponsManager.a().d();
        if (completedsignup == null)
        {
            ((TGTAggregateDealsData)pendingResult.c()).a(new ArrayList());
            a(pendingResult, listener);
            return;
        }
        if (mCachingEnabled && mCachedCouponOffers != null)
        {
            ((TGTAggregateDealsData)pendingResult.c()).a(mCachedCouponOffers);
            a(pendingResult, listener);
            return;
        } else
        {
            mCouponsManager.a(completedsignup, new h() {

                final com.target.ui.helper.p.a this$0;
                final b val$listener;
                final com.target.ui.helper.d.a val$pendingResult;

                public String a()
                {
                    return com.target.ui.helper.p.a.a(com.target.ui.helper.p.a.this);
                }

                public void a(x x1)
                {
                    ((TGTAggregateDealsData)pendingResult.c()).b(new ArrayList());
                    com.target.ui.helper.p.a.a(com.target.ui.helper.p.a.this, pendingResult, listener);
                }

                public volatile void a(Object obj)
                {
                    a((List)obj);
                }

                public void a(List list)
                {
                    com.target.ui.helper.p.a.a(com.target.ui.helper.p.a.this, list);
                    ((TGTAggregateDealsData)pendingResult.c()).a(list);
                    com.target.ui.helper.p.a.a(com.target.ui.helper.p.a.this, pendingResult, listener);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = com.target.ui.helper.p.a.this;
                pendingResult = a2;
                listener = b1;
                super();
            }
            });
            return;
        }
    }

    public ProductSummaryParam a(Store store)
    {
        return new ProductDealsParam(store);
    }

    public void a()
    {
        mCouponsManager.a(mRequestTag);
        mProductManager.a(mRequestTag);
        mWeeklyAdFullDataHelper.a();
        mLastCancellationNanoTime = System.nanoTime();
    }

    public void a(ProductSummaryParam productsummaryparam, final d listener)
    {
        final long requestNanoTime = System.nanoTime();
        mProductManager.a(productsummaryparam, new h() {

            final com.target.ui.helper.p.a this$0;
            final d val$listener;
            final long val$requestNanoTime;

            public String a()
            {
                return com.target.ui.helper.p.a.a(com.target.ui.helper.p.a.this);
            }

            public void a(ProductSummaryWrapper productsummarywrapper)
            {
                if (com.target.ui.helper.p.a.a(com.target.ui.helper.p.a.this, requestNanoTime))
                {
                    return;
                } else
                {
                    listener.a(productsummarywrapper);
                    return;
                }
            }

            public void a(x x1)
            {
                if (com.target.ui.helper.p.a.a(com.target.ui.helper.p.a.this, requestNanoTime))
                {
                    return;
                } else
                {
                    listener.a(x1);
                    return;
                }
            }

            public volatile void a(Object obj)
            {
                a((ProductSummaryWrapper)obj);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = com.target.ui.helper.p.a.this;
                requestNanoTime = l;
                listener = d1;
                super();
            }
        });
    }

    public void a(final AvailableCouponOffer availableCouponOffer, final a listener)
    {
        CompletedSignUp completedsignup = (CompletedSignUp)mCouponsManager.a().d();
        mCouponsManager.a(completedsignup, availableCouponOffer, new com.target.mothership.model.d() {

            final com.target.ui.helper.p.a this$0;
            final AvailableCouponOffer val$availableCouponOffer;
            final a val$listener;

            public String a()
            {
                return com.target.ui.helper.p.a.a(com.target.ui.helper.p.a.this);
            }

            public void a(com.target.mothership.model.coupons.interfaces.a.a a1)
            {
                listener.a(a1, availableCouponOffer);
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
                listener.a(availableCouponOffer);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.coupons.interfaces.a.a)obj);
            }

            
            {
                this$0 = com.target.ui.helper.p.a.this;
                listener = a2;
                availableCouponOffer = availablecouponoffer;
                super();
            }
        });
    }

    public void a(Store store, ProductSummaryParam productsummaryparam, PromotionRequest promotionrequest, b b1)
    {
        com.target.ui.helper.d.a a1 = new com.target.ui.helper.d.a(new TGTAggregateDealsData(), new c(), 3);
        b(a1, b1);
        a(store, productsummaryparam, a1, b1);
        a(store, promotionrequest, a1, b1);
    }

    public void a(boolean flag)
    {
        mCachingEnabled = flag;
    }

    public boolean b()
    {
        return mCouponsManager.a().b();
    }

}
