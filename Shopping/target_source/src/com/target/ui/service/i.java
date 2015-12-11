// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.pointinside.location.geofence.VenueProximityCache;
import com.pointinside.net.requestor.ProductSearchRequestor;
import com.pointinside.net.requestor.RequestorFactory;
import com.pointinside.products.ProductSearchURLBuilder;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.h;
import com.target.mothership.model.product.c;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class i
{
    public static interface a
    {

        public abstract void a(Exception exception);

        public abstract void b(List list);
    }

    private static class b extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        private Exception mException;
        private String mSearchDealType;
        private a mSearchListener;
        private ProductSearchRequestor mSearchRequester;
        private Store mSearchStore;

        static a a(b b1)
        {
            return b1.mSearchListener;
        }

        public void _nr_setTrace(Trace trace)
        {
            try
            {
                _nr_trace = trace;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Trace trace)
            {
                return;
            }
        }

        protected transient List a(Void avoid[])
        {
            try
            {
                avoid = mSearchRequester.fetchProductSearchResponse();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                mException = avoid;
                return null;
            }
            return avoid;
        }

        protected void a(List list)
        {
            if (mException != null)
            {
                mSearchListener.a(mException);
                return;
            } else
            {
                final com.target.ui.model.pi_blackfriday_deals.a piDealsTransformer = new com.target.ui.model.pi_blackfriday_deals.a(mSearchDealType);
                (new c()).a(mSearchStore, list. new h() {

                    final b this$0;
                    final com.target.ui.model.pi_blackfriday_deals.a val$piDealsTransformer;
                    final List val$productList;

                    public void a(x x1)
                    {
                        b.a(b.this).b(piDealsTransformer.a(productList));
                    }

                    public volatile void a(Object obj)
                    {
                        a((List)obj);
                    }

                    public void a(List list)
                    {
                        b.a(b.this).b(piDealsTransformer.a(productList, list));
                    }

                    public void b(Object obj)
                    {
                        a((x)obj);
                    }

            
            {
                this$0 = final_b1;
                piDealsTransformer = a1;
                productList = List.this;
                super();
            }
                });
                return;
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "i$b#doInBackground", null);
_L1:
            aobj = a((Void[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "i$b#doInBackground", null);
              goto _L1
        }

        protected void onPostExecute(Object obj)
        {
            TraceMachine.enterMethod(_nr_trace, "i$b#onPostExecute", null);
_L1:
            a((List)obj);
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "i$b#onPostExecute", null);
              goto _L1
        }

        private b(Store store, String s, ProductSearchRequestor productsearchrequestor, a a1)
        {
            mSearchStore = store;
            mSearchDealType = s;
            mSearchRequester = productsearchrequestor;
            mSearchListener = a1;
        }

    }


    private static final String BLACK_FRIDAY_OVERRIDE_DATE_STRING = "2015-11-27T12:00:00";
    private static final String KEY_DEAL_TYPE = "dealType";
    private static final String KEY_LOCATION_TYPE = "locationType";
    private static final int MAX_PRODUCTS_LIMIT = 2000;
    private static final String VALUE_LOCATION_TYPE = "Promo";
    private String mDealType;
    private a mListener;
    private ProductSearchRequestor mRequester;
    private Store mStore;

    protected i(Store store, String s, a a1)
    {
        if (a1 == null)
        {
            throw new IllegalArgumentException("BlackFridayDealSearchListener must not be null");
        } else
        {
            mStore = store;
            mDealType = s;
            mListener = a1;
            return;
        }
    }

    public void a()
    {
        Object obj = VenueProximityCache.getLocation();
        Object obj1 = new HashMap();
        ((HashMap) (obj1)).put("locationType", "Promo");
        ((HashMap) (obj1)).put("dealType", mDealType);
        obj = new ProductSearchURLBuilder(((HashMap) (obj1)), ((android.location.Location) (obj)));
        obj.storeID = mStore.getStoreId().a();
        obj.includeDealsInProducts = true;
        obj.limitToProductsWithDeals = true;
        obj.eventLocationOnly = true;
        obj.maxProductsLimit = 2000;
        obj.overrideDate = "2015-11-27T12:00:00";
        obj1 = new ArrayList();
        ((List) (obj1)).add(com.pointinside.products.BaseProduct.PIProductsProductType.product);
        obj.classes = ((List) (obj1));
        mRequester = RequestorFactory.newProductSearchRequestor(((ProductSearchURLBuilder) (obj)));
        obj = new b(mStore, mDealType, mRequester, mListener);
        Void avoid[] = new Void[0];
        if (!(obj instanceof AsyncTask))
        {
            ((b) (obj)).execute(avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)obj, avoid);
            return;
        }
    }
}
