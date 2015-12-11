// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.location.Location;
import android.os.AsyncTask;
import com.google.a.a.b;
import com.google.a.a.f;
import com.google.a.b.k;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.pointinside.net.requestor.ProductLookupRequestor;
import com.pointinside.net.requestor.RequestorFactory;
import com.pointinside.products.ProductDesc;
import com.pointinside.products.ProductLookupURLBuilder;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.model.LookupResultParcelable;
import java.util.List;

public class w
{
    private class a extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        private Exception mException;
        final w this$0;

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
                avoid = LookupResultParcelable.a(com.target.ui.util.w.b(w.this).fetchProductLookupResponse(w.a(w.this)));
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
                w.c(w.this).a(mException);
                return;
            } else
            {
                w.c(w.this).a(list);
                return;
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "w$a#doInBackground", null);
_L1:
            aobj = a((Void[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "w$a#doInBackground", null);
              goto _L1
        }

        protected void onPostExecute(Object obj)
        {
            TraceMachine.enterMethod(_nr_trace, "w$a#onPostExecute", null);
_L1:
            a((List)obj);
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "w$a#onPostExecute", null);
              goto _L1
        }

        private a()
        {
            this$0 = w.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a(Exception exception);

        public abstract void a(List list);
    }


    private static final com.google.a.a.b toProductDesc = new com.google.a.a.b() {

        public ProductDesc a(String s)
        {
            return ProductDesc.createWithTerm(s);
        }

        public volatile Object a(Object obj)
        {
            return a((String)obj);
        }

    };
    private final b mListener;
    private final List mProducts;
    private final ProductLookupRequestor mRequestor;

    private w(List list, Store store, b b1)
    {
        boolean flag;
        if (list != null && !list.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.a(flag, "Must have at least one product description.");
        mProducts = list;
        mListener = b1;
        list = new ProductLookupURLBuilder(new Location("ProductLookup"));
        list.storeID = store.getStoreId().a();
        mRequestor = RequestorFactory.newProductLookupRequestor(list);
    }

    public static w a(String s, Store store, b b1)
    {
        return a(((List) (k.a(new String[] {
            s
        }))), store, b1);
    }

    public static w a(List list, Store store, b b1)
    {
        return new w(k.a(list, toProductDesc), store, b1);
    }

    static List a(w w1)
    {
        return w1.mProducts;
    }

    static ProductLookupRequestor b(w w1)
    {
        return w1.mRequestor;
    }

    public static w b(List list, Store store, b b1)
    {
        return new w(list, store, b1);
    }

    static b c(w w1)
    {
        return w1.mListener;
    }

    public void a()
    {
        a a1 = new a();
        Void avoid[] = new Void[0];
        if (!(a1 instanceof AsyncTask))
        {
            a1.execute(avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)a1, avoid);
            return;
        }
    }

}
