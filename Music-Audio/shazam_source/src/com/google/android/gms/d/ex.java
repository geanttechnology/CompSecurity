// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.b;

// Referenced classes of package com.google.android.gms.d:
//            hm, he, gm

public final class ex
    implements Runnable
{
    protected final class a extends AsyncTask
    {

        final ex a;
        private final WebView b;
        private Bitmap c;

        private transient Boolean a()
        {
            this;
            JVM INSTR monitorenter ;
            int j1;
            int k1;
            j1 = c.getWidth();
            k1 = c.getHeight();
            if (j1 != 0 && k1 != 0) goto _L2; else goto _L1
_L1:
            Boolean boolean1 = Boolean.valueOf(false);
_L3:
            this;
            JVM INSTR monitorexit ;
            return boolean1;
_L2:
            int j;
            int k;
            j = 0;
            k = 0;
_L4:
            int l;
            if (j < j1)
            {
                l = 0;
                break MISSING_BLOCK_LABEL_52;
            }
            boolean flag;
            if ((double)k / ((double)(j1 * k1) / 100D) > 0.10000000000000001D)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            boolean1 = Boolean.valueOf(flag);
              goto _L3
            exception;
            throw exception;
            Exception exception;
            if (c.getPixel(j, l) != 0)
            {
                i1 = k + 1;
            }
            l += 10;
            k = i1;
            int i1;
            if (l < k1)
            {
                i1 = k;
                break MISSING_BLOCK_LABEL_62;
            }
            j += 10;
              goto _L4
        }

        protected final Object doInBackground(Object aobj[])
        {
            return a();
        }

        protected final void onPostExecute(Object obj)
        {
            obj = (Boolean)obj;
            ex.c(a);
            if (((Boolean) (obj)).booleanValue() || a.b() || ex.d(a) <= 0L)
            {
                a.e = ((Boolean) (obj)).booleanValue();
                ex.e(a).a(a.c, true);
            } else
            if (ex.d(a) > 0L)
            {
                if (com.google.android.gms.ads.internal.util.client.b.a(2))
                {
                    com.google.android.gms.ads.internal.util.client.b.a(3);
                }
                ex.g(a).postDelayed(a, ex.f(a));
                return;
            }
        }

        protected final void onPreExecute()
        {
            this;
            JVM INSTR monitorenter ;
            c = Bitmap.createBitmap(ex.a(a), com.google.android.gms.d.ex.b(a), android.graphics.Bitmap.Config.ARGB_8888);
            b.setVisibility(0);
            b.measure(android.view.View.MeasureSpec.makeMeasureSpec(ex.a(a), 0), android.view.View.MeasureSpec.makeMeasureSpec(com.google.android.gms.d.ex.b(a), 0));
            b.layout(0, 0, ex.a(a), com.google.android.gms.d.ex.b(a));
            Canvas canvas = new Canvas(c);
            b.draw(canvas);
            b.invalidate();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public a(WebView webview)
        {
            a = ex.this;
            super();
            b = webview;
        }
    }


    final Handler a;
    final long b;
    protected final he c;
    protected boolean d;
    protected boolean e;
    private long f;
    private hf.a g;
    private final int h;
    private final int i;

    private ex(hf.a a1, he he1, int j, int k)
    {
        b = 200L;
        f = 50L;
        a = new Handler(Looper.getMainLooper());
        c = he1;
        g = a1;
        d = false;
        e = false;
        h = k;
        i = j;
    }

    public ex(hf.a a1, he he1, int j, int k, byte byte0)
    {
        this(a1, he1, j, k);
    }

    static int a(ex ex1)
    {
        return ex1.i;
    }

    static int b(ex ex1)
    {
        return ex1.h;
    }

    static long c(ex ex1)
    {
        long l = ex1.f - 1L;
        ex1.f = l;
        return l;
    }

    static long d(ex ex1)
    {
        return ex1.f;
    }

    static hf.a e(ex ex1)
    {
        return ex1.g;
    }

    static long f(ex ex1)
    {
        return ex1.b;
    }

    static Handler g(ex ex1)
    {
        return ex1.a;
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        d = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(AdResponseParcel adresponseparcel)
    {
        Object obj = new hm(this, c, adresponseparcel.q);
        c.setWebViewClient(((android.webkit.WebViewClient) (obj)));
        he he1 = c;
        if (TextUtils.isEmpty(adresponseparcel.b))
        {
            obj = null;
        } else
        {
            p.e();
            obj = gm.a(adresponseparcel.b);
        }
        he1.loadDataWithBaseURL(((String) (obj)), adresponseparcel.c, "text/html", "UTF-8", null);
    }

    public final boolean b()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = d;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean c()
    {
        return e;
    }

    public final void run()
    {
        if (c == null || b())
        {
            g.a(c, true);
            return;
        } else
        {
            (new a(c.getWebView())).execute(new Void[0]);
            return;
        }
    }
}
