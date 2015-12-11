// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.j;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.target.mothership.common.product.Barcode;
import com.target.mothership.model.h;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductDetailsWrapper;
import com.target.mothership.services.x;
import com.target.mothership.services.z;
import com.target.ui.model.scan.ScanResultItem;
import java.util.Iterator;
import java.util.List;

public class c
{
    private static class a extends AsyncTask
        implements TraceFieldInterface
    {

        private static final long CONNECTION_RETRY_DURATION = 1000L;
        private static a sInstance;
        public Trace _nr_trace;
        private boolean mIsInitialized;
        private a mListener;

        public static a a()
        {
            if (sInstance == null)
            {
                sInstance = new a();
            }
            return sInstance;
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

        protected transient Boolean a(Void avoid[])
        {
_L2:
            Thread.sleep(1000L);
            if (isCancelled())
            {
                return Boolean.valueOf(false);
            }
            continue; /* Loop/switch isn't completed */
            avoid;
            return Boolean.valueOf(false);
            if (!com.target.mothership.util.b.a().b()) goto _L2; else goto _L1
_L1:
            return Boolean.valueOf(true);
        }

        public void a(a a1)
        {
label0:
            {
                mListener = a1;
                if (!mIsInitialized)
                {
                    mIsInitialized = true;
                    a1 = new Void[0];
                    if (this instanceof AsyncTask)
                    {
                        break label0;
                    }
                    execute(a1);
                }
                return;
            }
            AsyncTaskInstrumentation.execute((AsyncTask)this, a1);
        }

        protected void a(Boolean boolean1)
        {
            super.onPostExecute(boolean1);
            for (sInstance = null; mListener == null || !boolean1.booleanValue();)
            {
                return;
            }

            mListener.a();
        }

        protected Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "c$a#doInBackground", null);
_L1:
            aobj = a((Void[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "c$a#doInBackground", null);
              goto _L1
        }

        protected void onPostExecute(Object obj)
        {
            TraceMachine.enterMethod(_nr_trace, "c$a#onPostExecute", null);
_L1:
            a((Boolean)obj);
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "c$a#onPostExecute", null);
              goto _L1
        }

        private a()
        {
        }
    }

    public static interface a.a
    {

        public abstract void a();
    }

    public static interface b
    {

        public abstract void a(ProductDetails productdetails);

        public abstract void a(ScanResultItem scanresultitem);

        public abstract void a(ScanResultItem scanresultitem, String s);

        public abstract void b(ScanResultItem scanresultitem);
    }


    private a mCheckNetwork;
    private b mListener;
    private com.target.mothership.model.product.c mProductManager;
    private String mRequestTag;

    public c(b b1)
    {
        mProductManager = new com.target.mothership.model.product.c();
        mRequestTag = String.valueOf(hashCode());
        mListener = b1;
    }

    static b a(c c1)
    {
        return c1.mListener;
    }

    static String b(c c1)
    {
        return c1.mRequestTag;
    }

    public void a()
    {
        mProductManager.a(mRequestTag);
        if (mCheckNetwork != null)
        {
            mCheckNetwork.cancel(true);
        }
    }

    public void a(final ScanResultItem scanResult)
    {
        scanResult.a(com.target.ui.model.scan.ScanResultItem.a.UPC_RESULT);
        Barcode barcode = new Barcode(scanResult.a());
        mProductManager.a(null, barcode, false, new h() {

            final c this$0;
            final ScanResultItem val$scanResult;

            public String a()
            {
                return c.b(c.this);
            }

            public void a(ProductDetailsWrapper productdetailswrapper)
            {
                if (!productdetailswrapper.b().isEmpty()) goto _L2; else goto _L1
_L1:
                if (c.a(c.this) != null) goto _L4; else goto _L3
_L3:
                return;
_L4:
                c.a(c.this).a(scanResult);
                return;
_L2:
                productdetailswrapper = (ProductDetails)productdetailswrapper.b().get(0);
                String s = productdetailswrapper.g();
                if (s != null && s.length() != 0)
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (c.a(c.this) == null) goto _L3; else goto _L5
_L5:
                c.a(c.this).a(scanResult);
                return;
                if (c.a(c.this) == null) goto _L3; else goto _L6
_L6:
                c.a(c.this).a(scanResult, productdetailswrapper.g());
                c.a(c.this).a(productdetailswrapper);
                return;
            }

            public void a(x x1)
            {
                if (c.a(c.this) == null)
                {
                    return;
                }
                if (x1.b().equals(z.NOT_FOUND))
                {
                    c.a(c.this).a(scanResult);
                    return;
                } else
                {
                    c.a(c.this).b(scanResult);
                    return;
                }
            }

            public volatile void a(Object obj)
            {
                a((ProductDetailsWrapper)obj);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = c.this;
                scanResult = scanresultitem;
                super();
            }
        });
    }

    public void a(final List scanResults)
    {
        mCheckNetwork = a.a();
        mCheckNetwork.a(new a.a() {

            final c this$0;
            final List val$scanResults;

            public void a()
            {
                Iterator iterator = scanResults.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    ScanResultItem scanresultitem = (ScanResultItem)iterator.next();
                    if (scanresultitem.c() == com.target.ui.model.scan.ScanResultItem.a.CONNECTION_ISSUE)
                    {
                        c.this.a(scanresultitem);
                    }
                } while (true);
            }

            
            {
                this$0 = c.this;
                scanResults = list;
                super();
            }
        });
    }
}
