// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.jsadapter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.google.android.gms.internal.da;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;

// Referenced classes of package com.google.ads.mediation.jsadapter:
//            JavascriptAdapter

public final class AdViewCheckTask
    implements Runnable
{
    private final class a extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        private final int v;
        private final int w;
        private final WebView x;
        private Bitmap y;
        final AdViewCheckTask z;

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
            this;
            JVM INSTR monitorenter ;
            int i1;
            int j1;
            i1 = y.getWidth();
            j1 = y.getHeight();
            if (i1 != 0 && j1 != 0) goto _L2; else goto _L1
_L1:
            avoid = Boolean.valueOf(false);
_L3:
            this;
            JVM INSTR monitorexit ;
            return avoid;
_L2:
            int i;
            int j;
            i = 0;
            j = 0;
_L4:
            int k;
            if (i < i1)
            {
                k = 0;
                break MISSING_BLOCK_LABEL_52;
            }
            boolean flag;
            if ((double)j / ((double)(i1 * j1) / 100D) > 0.10000000000000001D)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            avoid = Boolean.valueOf(flag);
              goto _L3
            avoid;
            throw avoid;
            if (y.getPixel(i, k) != 0)
            {
                l = j + 1;
            }
            k += 10;
            j = l;
            int l;
            if (k < j1)
            {
                l = j;
                break MISSING_BLOCK_LABEL_62;
            }
            i += 10;
              goto _L4
        }

        protected void a(Boolean boolean1)
        {
            AdViewCheckTask.a(z);
            if (boolean1.booleanValue())
            {
                AdViewCheckTask.b(z).sendAdReceivedUpdate();
                return;
            }
            if (AdViewCheckTask.c(z) > 0L)
            {
                if (da.n(2))
                {
                    da.s("Ad not detected, scheduling another run.");
                }
                AdViewCheckTask.e(z).postDelayed(z, AdViewCheckTask.d(z));
                return;
            } else
            {
                da.s("Ad not detected, Not scheduling anymore runs.");
                AdViewCheckTask.b(z).sendAdNotReceivedUpdate();
                return;
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "AdViewCheckTask$a#doInBackground", null);
_L1:
            aobj = a((Void[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "AdViewCheckTask$a#doInBackground", null);
              goto _L1
        }

        protected void onPostExecute(Object obj)
        {
            TraceMachine.enterMethod(_nr_trace, "AdViewCheckTask$a#onPostExecute", null);
_L1:
            a((Boolean)obj);
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "AdViewCheckTask$a#onPostExecute", null);
              goto _L1
        }

        protected void onPreExecute()
        {
            this;
            JVM INSTR monitorenter ;
            y = Bitmap.createBitmap(w, v, android.graphics.Bitmap.Config.ARGB_8888);
            x.setVisibility(0);
            x.measure(android.view.View.MeasureSpec.makeMeasureSpec(w, 0), android.view.View.MeasureSpec.makeMeasureSpec(v, 0));
            x.layout(0, 0, w, v);
            Canvas canvas = new Canvas(y);
            x.draw(canvas);
            x.invalidate();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public a(int i, int j, WebView webview)
        {
            z = AdViewCheckTask.this;
            super();
            v = j;
            w = i;
            x = webview;
        }
    }


    public static final int BACKGROUND_COLOR = 0;
    private final JavascriptAdapter r;
    private final Handler s = new Handler(Looper.getMainLooper());
    private final long t;
    private long u;

    public AdViewCheckTask(JavascriptAdapter javascriptadapter, long l, long l1)
    {
        r = javascriptadapter;
        t = l;
        u = l1;
    }

    static long a(AdViewCheckTask adviewchecktask)
    {
        long l = adviewchecktask.u - 1L;
        adviewchecktask.u = l;
        return l;
    }

    static JavascriptAdapter b(AdViewCheckTask adviewchecktask)
    {
        return adviewchecktask.r;
    }

    static long c(AdViewCheckTask adviewchecktask)
    {
        return adviewchecktask.u;
    }

    static long d(AdViewCheckTask adviewchecktask)
    {
        return adviewchecktask.t;
    }

    static Handler e(AdViewCheckTask adviewchecktask)
    {
        return adviewchecktask.s;
    }

    public void run()
    {
        if (r == null || r.shouldStopAdCheck())
        {
            return;
        }
        a a1 = new a(r.getWebViewWidth(), r.getWebViewHeight(), r.getWebView());
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

    public void start()
    {
        s.postDelayed(this, t);
    }
}
