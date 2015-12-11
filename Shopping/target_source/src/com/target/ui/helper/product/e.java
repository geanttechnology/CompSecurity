// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.product;

import com.pointinside.maps.Location;
import com.target.mothership.common.params.ProductRecommendationsParam;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.model.dvm.interfaces.DvmDataResponse;
import com.target.mothership.model.dvm.interfaces.DvmRemoteData;
import com.target.mothership.model.product.interfaces.ProductRecommendations;
import com.target.mothership.model.product.interfaces.ProductSummary;
import com.target.mothership.model.product.interfaces.ProductSummaryWrapper;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.x;
import com.target.mothership.services.z;
import com.target.ui.helper.d.a;
import com.target.ui.model.product.AggregateProductSummaryData;
import com.target.ui.model.product.TGTAggregateProductSummaryData;
import com.target.ui.util.q;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.helper.product:
//            g

public class com.target.ui.helper.product.e
{
    public class a
    {

        private List mTargetNetworkErrors;
        final com.target.ui.helper.product.e this$0;

        public int a()
        {
            return mTargetNetworkErrors.size();
        }

        public void a(x x)
        {
            mTargetNetworkErrors.add(x);
        }

        public a()
        {
            this$0 = com.target.ui.helper.product.e.this;
            super();
            mTargetNetworkErrors = new ArrayList();
        }
    }

    public static interface b
    {

        public abstract void a(AggregateProductSummaryData aggregateproductsummarydata);

        public abstract void b(x x);

        public abstract void j();

        public abstract void k();
    }

    public static interface c
    {

        public abstract void a(ProductSummaryWrapper productsummarywrapper);

        public abstract void c(x x);

        public abstract void l();
    }

    public static interface d
    {

        public abstract void a(String s, RelevantStoreSummary relevantstoresummary, Location location);

        public abstract void h();
    }

    public static interface e
    {

        public abstract void a(ProductRecommendations productrecommendations);

        public abstract void a(x x);

        public abstract void i();
    }


    public static final String TAG = com/target/ui/helper/product/e.getSimpleName();
    private com.target.ui.helper.g.a mDvmDataHelper;
    private List mDvmDataResponseList;
    private DvmRemoteData mDvmRemoteData;
    private g mProductDataHelper;

    public com.target.ui.helper.product.e(g g1, com.target.ui.helper.g.a a1)
    {
        mDvmDataResponseList = new ArrayList();
        mDvmDataHelper = a1;
        mProductDataHelper = g1;
        mDvmRemoteData = null;
    }

    static List a(com.target.ui.helper.product.e e1)
    {
        return e1.mDvmDataResponseList;
    }

    private void a(int i, ProductSummaryWrapper productsummarywrapper, DvmRemoteData dvmremotedata, b b1)
    {
        TGTAggregateProductSummaryData tgtaggregateproductsummarydata = new TGTAggregateProductSummaryData();
        tgtaggregateproductsummarydata.a(productsummarywrapper);
        a(new com.target.ui.helper.d.a(tgtaggregateproductsummarydata, new a(), i), dvmremotedata, b1);
    }

    private void a(int i, ProductSummaryWrapper productsummarywrapper, b b1)
    {
        if (i > 0 && productsummarywrapper.a().i().b() && mDvmRemoteData == null)
        {
            mDvmRemoteData = (DvmRemoteData)productsummarywrapper.a().i().d();
            a(i, productsummarywrapper, mDvmRemoteData, b1);
            return;
        } else
        {
            a(new TGTAggregateProductSummaryData(productsummarywrapper, mDvmDataResponseList), b1);
            return;
        }
    }

    private void a(final com.target.ui.helper.d.a pendingResult, final DvmRemoteData dvmRemoteData, final b listener)
    {
        mDvmDataHelper.a(dvmRemoteData, new com.target.ui.helper.g.a.a() {

            final com.target.ui.helper.product.e this$0;
            final DvmRemoteData val$dvmRemoteData;
            final b val$listener;
            final com.target.ui.helper.d.a val$pendingResult;

            public void b(DvmDataResponse dvmdataresponse)
            {
                com.target.ui.helper.product.e.a(com.target.ui.helper.product.e.this).add(dvmdataresponse);
                ((TGTAggregateProductSummaryData)pendingResult.c()).a(com.target.ui.helper.product.e.a(com.target.ui.helper.product.e.this));
                com.target.ui.helper.product.e.a(com.target.ui.helper.product.e.this, pendingResult, dvmRemoteData, listener);
            }

            public void b(x x)
            {
                ((a)pendingResult.b()).a(x);
                com.target.ui.helper.product.e.a(com.target.ui.helper.product.e.this, pendingResult, dvmRemoteData, listener);
            }

            public void n()
            {
            }

            
            {
                this$0 = com.target.ui.helper.product.e.this;
                pendingResult = a1;
                dvmRemoteData = dvmremotedata;
                listener = b1;
                super();
            }
        });
    }

    static void a(com.target.ui.helper.product.e e1, int i, ProductSummaryWrapper productsummarywrapper, b b1)
    {
        e1.a(i, productsummarywrapper, b1);
    }

    static void a(com.target.ui.helper.product.e e1, com.target.ui.helper.d.a a1, DvmRemoteData dvmremotedata, b b1)
    {
        e1.b(a1, dvmremotedata, b1);
    }

    private void a(TGTAggregateProductSummaryData tgtaggregateproductsummarydata, b b1)
    {
        b1.a(tgtaggregateproductsummarydata);
    }

    private void b(com.target.ui.helper.d.a a1, DvmRemoteData dvmremotedata, b b1)
    {
        if (a1.a() > 0)
        {
            if (((a)a1.b()).a() > 0)
            {
                a((TGTAggregateProductSummaryData)a1.c(), b1);
                return;
            } else
            {
                a(a1, dvmremotedata, b1);
                return;
            }
        } else
        {
            a((TGTAggregateProductSummaryData)a1.c(), b1);
            return;
        }
    }

    public void a()
    {
        mDvmDataHelper.a();
        mProductDataHelper.a();
        mDvmRemoteData = null;
    }

    public void a(ProductRecommendationsParam productrecommendationsparam, final e listener)
    {
        mProductDataHelper.a(productrecommendationsparam, new g.d() {

            final com.target.ui.helper.product.e this$0;
            final e val$listener;

            public void a(ProductRecommendations productrecommendations)
            {
                listener.a(productrecommendations);
            }

            public void d(x x)
            {
                listener.a(x);
            }

            public void o()
            {
                listener.i();
            }

            
            {
                this$0 = com.target.ui.helper.product.e.this;
                listener = e2;
                super();
            }
        });
    }

    public void a(ProductSummaryParam productsummaryparam, final int noOfDvmTobeRequested, final b listener)
    {
        mProductDataHelper.a(productsummaryparam, new g.e() {

            final com.target.ui.helper.product.e this$0;
            final b val$listener;
            final int val$noOfDvmTobeRequested;

            public void a(ProductSummaryWrapper productsummarywrapper)
            {
                com.target.ui.helper.product.e.a(com.target.ui.helper.product.e.this, noOfDvmTobeRequested, productsummarywrapper, listener);
            }

            public void a(x x1)
            {
                if (x1 != null && z.NOT_FOUND.equals(x1.b()))
                {
                    listener.k();
                    return;
                } else
                {
                    listener.b(x1);
                    return;
                }
            }

            public void t_()
            {
                listener.j();
            }

            
            {
                this$0 = com.target.ui.helper.product.e.this;
                noOfDvmTobeRequested = i;
                listener = b1;
                super();
            }
        });
    }

    public void a(ProductSummaryParam productsummaryparam, final c listener)
    {
        mProductDataHelper.a(productsummaryparam, new g.e() {

            final com.target.ui.helper.product.e this$0;
            final c val$listener;

            public void a(ProductSummaryWrapper productsummarywrapper)
            {
                listener.a(productsummarywrapper);
            }

            public void a(x x)
            {
                listener.c(x);
            }

            public void t_()
            {
                listener.l();
            }

            
            {
                this$0 = com.target.ui.helper.product.e.this;
                listener = c1;
                super();
            }
        });
    }

    public void a(String s)
    {
        mDvmDataHelper.a(s, new com.target.ui.helper.g.a.b() {

            final com.target.ui.helper.product.e this$0;

            public void a(Void void1)
            {
            }

            public void c(x x)
            {
                q.a(com.target.ui.helper.product.e.TAG, "Dvm click registration failure");
            }

            
            {
                this$0 = com.target.ui.helper.product.e.this;
                super();
            }
        });
    }

    public void a(final String searchTerm, final RelevantStoreSummary relevantStoreSummary, final d listener)
    {
        mProductDataHelper.a(searchTerm, relevantStoreSummary, new g.b() {

            final com.target.ui.helper.product.e this$0;
            final d val$listener;
            final RelevantStoreSummary val$relevantStoreSummary;
            final String val$searchTerm;

            public void a()
            {
                listener.h();
            }

            public void a(Location location)
            {
                listener.a(searchTerm, relevantStoreSummary, location);
            }

            
            {
                this$0 = com.target.ui.helper.product.e.this;
                listener = d1;
                searchTerm = s;
                relevantStoreSummary = relevantstoresummary;
                super();
            }
        });
    }

    public void a(List list, final int noOfDvmTobeRequested, Store store, final b listener)
    {
        mProductDataHelper.a(list, store, new g.e() {

            final com.target.ui.helper.product.e this$0;
            final b val$listener;
            final int val$noOfDvmTobeRequested;

            public void a(ProductSummaryWrapper productsummarywrapper)
            {
                com.target.ui.helper.product.e.a(com.target.ui.helper.product.e.this, noOfDvmTobeRequested, productsummarywrapper, listener);
            }

            public void a(x x1)
            {
                if (x1 != null && z.NOT_FOUND.equals(x1.b()))
                {
                    listener.k();
                    return;
                } else
                {
                    listener.b(x1);
                    return;
                }
            }

            public void t_()
            {
                listener.j();
            }

            
            {
                this$0 = com.target.ui.helper.product.e.this;
                noOfDvmTobeRequested = i;
                listener = b1;
                super();
            }
        });
    }

    public boolean b()
    {
        return mProductDataHelper.b();
    }

}
